package concurrency.section8;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * 银行出纳员仿真
 * 每个客户都需要一定数量的服务时间。这个是出纳员必须花费在客户身上的时间
 * 
 * @author Administrator
 * 
 */

class Customer {
	private int serviceTime;

	public Customer(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	@Override
	public String toString() {
		return "[ " + serviceTime + " ]";
	}
}

class CustomerLine extends ArrayBlockingQueue<Customer> {

	public CustomerLine(int maxLineSize) {
		super(maxLineSize);
	}

	@Override
	public String toString() {
		if (this.size() == 0)
			return "[Empty]";
		String s = "";
		for (Customer customer : this) {
			s += customer;
		}
		return s;
	}

}

class CustomerGenerator implements Runnable {

	private CustomerLine customerLine;
	private static Random random = new Random(47);

	public CustomerGenerator(CustomerLine customerLine) {
		this.customerLine = customerLine;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
				Customer customer = new Customer(random.nextInt(1000));
				customerLine.put(customer);
			}
		} catch (InterruptedException e) {
			System.out.println("Generator Customer Interrupted!");
		}
		System.out.println("Generator Customer terminated!");
	}

}

class Teller implements Runnable, Comparable<Teller> {

	private static int counter = 0;
	private final int id = counter++;
	private int customerServered = 0;
	private CustomerLine customerLine;
	private boolean serverCustomerLine = true;

	public Teller(CustomerLine customerLine) {
		this.customerLine = customerLine;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				Customer customer = customerLine.take();
				TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
				synchronized (this) {
					customerServered++;
					while (!serverCustomerLine) {
						wait();
					}
				}
			}
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted!");
		}
		System.out.println(this + " terminated!");

	}

	public synchronized void deSomethingElse() {
		customerServered = 0;
		serverCustomerLine = false;
	}

	public synchronized void serverCustomerLine() {
		assert !serverCustomerLine : "already servering: " + this;
		serverCustomerLine = true;
		notifyAll();
	}

	@Override
	public String toString() {
		return "Teller : " + id + " ";
	}

	public String shortString() {
		return "T :" + id;
	}

	public synchronized int compareTo(Teller arg0) {
		return customerServered < arg0.customerServered ? -1
				: (customerServered == arg0.customerServered ? 0 : 1);
	}

}

class TellerManager implements Runnable {

	private ExecutorService exec;
	private CustomerLine custormers;
	private PriorityQueue<Teller> workingTellers = new PriorityQueue<Teller>();
	private Queue<Teller> tellerDoingOtherThings = new LinkedList<Teller>();
	private int adjustmentPeriod;
	private static Random random = new Random();

	public TellerManager(ExecutorService exec, CustomerLine custormers,
			int adjustmentPeriod) {
		this.exec = exec;
		this.custormers = custormers;
		this.adjustmentPeriod = adjustmentPeriod;
		Teller teller = new Teller(custormers);
		exec.execute(teller);
		workingTellers.add(teller);
	}

	public void adjustTellerNumber() {
		// this is actually s control system
		if (custormers.size() / workingTellers.size() > 2) {
			// if tellers are on break or doing another job, breaking one back;
			if (tellerDoingOtherThings.size() > 0) {
				Teller teller = tellerDoingOtherThings.remove();
				teller.serverCustomerLine();
				workingTellers.offer(teller);
				return;
			}
			// else create a new teller
			Teller teller = new Teller(custormers);
			exec.execute(teller);
			workingTellers.add(teller);
			return;
		}
		//if line is short enough,remove a teller
		if(workingTellers.size()>1 && custormers.size()/workingTellers.size()<2){
			reassignOneTeller();
		}
		if(custormers.size()==0){
			while(workingTellers.size()>1){
				reassignOneTeller();
			}
		}
	}

	private void reassignOneTeller() {
		Teller teller = workingTellers.poll();
		teller.deSomethingElse();
		tellerDoingOtherThings.offer(teller);
	}

	public void run() {
		try {
			while(!Thread.interrupted()){
				TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
				adjustTellerNumber();
				System.out.print(custormers +" { ");
				for(Teller teller:workingTellers){
					System.out.print(teller.shortString()+" ");
				}
				System.out.println(" }");
			}
		} catch (Exception e) {
			System.out.println(this+" interrupted!");
		}
		System.out.println(this+" terminated!");
	}
	@Override
	public String toString() {
		return "TellerManager ";
	}
}

public class BankTellerSimulation {

	static final int MAX_LINE_SIZE = 50;
	static final int ADJUSTMENT_PERIOD = 1000;
	
	public static void main(String[] args) throws Exception{
		ExecutorService exec = Executors.newCachedThreadPool();
		CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
		exec.execute(new CustomerGenerator(customers));
		exec.execute(new TellerManager(exec, customers, ADJUSTMENT_PERIOD));
		if(args.length>0){
			TimeUnit.SECONDS.sleep(new Integer(args[0]));
		}else {
			System.out.println("Pess Enter to quit");
			System.in.read();
		}
		exec.shutdownNow();
	}
	
}
