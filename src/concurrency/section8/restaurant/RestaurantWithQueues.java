package concurrency.section8.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

import enumerated.menu.Course;
import enumerated.menu.Food;

//this is given to the waiter, who gives it to the chef
class Order{

	private static int count = 0;
	private final int id = count++;
	private final Customer customer;
	private final WaitPerson waitPerson;
	private final Food food;
	public Order(Customer customer, WaitPerson waitPerson, Food food) {
		this.customer = customer;
		this.waitPerson = waitPerson;
		this.food = food;
	}
	public Food item(){
		return food;
	}
	public Customer getCustomer(){
		return customer;
	}
	public WaitPerson getWaitPerson(){
		return waitPerson;
	}
	@Override
	public String toString() {
		return "Order:"+id+",item:"+food+",customer:"+customer+",served by "+waitPerson+"\n";
	}
	
}

// this is what comes back from chef
class Plate{
	private final Order order;
	private final Food food;
	public Plate(Order order,Food food){
		this.order = order;
		this.food = food;
	}
	@Override
	public String toString() {
		return food.toString();
	}
	public Order getOrder(){
		return order;
	}
	public Food getFood(){
		return food;
	}
}

class Customer implements Runnable{

	private static int counter = 0;
	private final int id = counter++;
	private final WaitPerson waitPerson;
	private SynchronousQueue<Plate> plateSetting = new SynchronousQueue<Plate>();
	public Customer(WaitPerson waitPerson) {
		this.waitPerson = waitPerson;
	}
	//only blocks if customer is still eating previous course
	public void delived(Plate p) throws InterruptedException{
		plateSetting.put(p);
	}

	public void run() {
		for(Course course:Course.values()){
			Food food = course.randomSelection();
			try {
				waitPerson.placeOrder(this,food);
				System.out.println(this+" eating "+plateSetting.take());
			} catch (InterruptedException e) {
				System.out.println(this+" for waiting course interrupted!");
				break;
			}
		}
		System.out.println(this + "finished meal,leaving...");
	}
	@Override
	public String toString() {
		return "Customer "+id;
	}
}

class WaitPerson implements Runnable{

	private static int counter = 0;
	private final int id = counter++;
	private final Restaurant r;
	BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<Plate>();
	public WaitPerson(Restaurant r){
		this.r = r;
	}
	public void placeOrder(Customer customer, Food food) throws InterruptedException {
		r.orders.put(new Order(customer, this, food));
	}
	public void run() {
		try {
			while(!Thread.interrupted()){
				Plate plate = filledOrders.take();
				System.out.println(this + "received "+plate+" delivering to "+plate.getOrder().getCustomer());
				plate.getOrder().getCustomer().delived(plate);
			}
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted!");
		}
		System.out.println(this +" off duty!");
	}
	@Override
	public String toString() {
		return "WaitPerson ： "+id+". ";
	}
}

class Chef implements Runnable{

	private static int counter = 0;
	private final int id = counter++;
	private static Random random = new Random(47);
	private final Restaurant restaurant;
	public Chef(Restaurant r){
		this.restaurant = r;
	}
	public void run() {
		try {
			while(!Thread.interrupted()){
				Order order = restaurant.orders.take();
				Food requestItem = order.item();
				TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
				Plate plate = new Plate(order, requestItem);
				order.getWaitPerson().filledOrders.put(plate);
			}
		} catch (Exception e) {
			System.out.println(this +" interrupted!");
		}
		System.out.println(this +" off duty!");
	}
	@Override
	public String toString() {
		return "Chef :"+id+" ";
	}
}

class Restaurant implements Runnable{

	private List<WaitPerson> waitPersons = new ArrayList<WaitPerson>();
	private List<Chef> chefs = new ArrayList<Chef>();
	private ExecutorService exec ;
	private static Random random = new Random(47);
	BlockingQueue<Order> orders = new LinkedBlockingQueue<Order>();
	public Restaurant(ExecutorService exec,int nWaitPerson,int nChef){
		this.exec = exec;
		for(int i=0;i<nWaitPerson;i++){
			WaitPerson waitPerson = new WaitPerson(this);
			waitPersons.add(waitPerson);
			exec.execute(waitPerson);
		}
		for(int i=0;i<nChef;i++){
			Chef chef = new Chef(this);
			chefs.add(chef);
			exec.execute(chef);
		}
	}
	public void run() {
		try {
			while(!Thread.interrupted()){
				WaitPerson waitPerson = waitPersons.get(random.nextInt(waitPersons.size()));
				Customer c = new Customer(waitPerson);
				exec.execute(c);
				TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
			}
		} catch (Exception e) {
			System.out.println("Restraunt Interrupted!");
		}
		System.out.println("Restraunt closing!");
	}
	
}
public class RestaurantWithQueues {

	public static void main(String[] args)throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		Restaurant restaurant = new Restaurant(exec, 8, 2);
		exec.execute(restaurant);
		System.out.println("Press Enter to quit");
		System.in.read();
		exec.shutdownNow();
	}
}
