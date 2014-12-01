package concurrency.section8;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Car{
	private final int id;
	private boolean engine = false,driveTrain = false,wheels = false;
	public Car(int id) {
		this.id = id;
	}
	public Car(){
		id = -1;
	}
	public synchronized int getId(){return id;}
	public synchronized void addEngine(){engine = true;}
	public synchronized void addDriveTrain(){driveTrain = true;}
	public synchronized void addWheels(){wheels = true;}
	@Override
	public String toString() {
		return "Car [driveTrain=" + driveTrain + ", engine=" + engine + ", id="
				+ id + ", wheels=" + wheels + "]";
	}
	
}
class CarQueue extends LinkedBlockingQueue<Car>{}

class ChassisBuilder implements Runnable{

	private CarQueue carQueue;
	private int counter = 0;
	
	public ChassisBuilder(CarQueue carQueue) {
		this.carQueue = carQueue;
	}

	public void run() {
		try {
			while(!Thread.interrupted()){
				TimeUnit.MILLISECONDS.sleep(500);
				Car car = new Car(counter++);
				System.out.println("ChassisBuilder created ");
				carQueue.put(car);
			}
		} catch (InterruptedException e) {
			System.out.println("ChassisBuilder interrupted!");
		}
		System.out.println("ChassisBuilder Off!");
		
	}
	
}

class Assembler implements Runnable{

	private CarQueue chassisQueue,finishingQueue;
	private Car car;
	private CyclicBarrier barrier = new CyclicBarrier(4);
	private RobotPool robotPool;
	public Assembler(CarQueue chassisQueue, CarQueue finishingQueue,
			RobotPool robotPool) {
		this.chassisQueue = chassisQueue;
		this.finishingQueue = finishingQueue;
		this.robotPool = robotPool;
	}
	public Car car(){
		return car;
	}
	public CyclicBarrier barrier(){
		return barrier;
	}
	public void run() {
		try {
			while(!Thread.interrupted()){
				car = chassisQueue.take();
				robotPool.hire(EngineRobot.class,this);
				robotPool.hire(DriverTrainRobot.class, this);
				robotPool.hire(WheelRobot.class, this);
				barrier.await();
				finishingQueue.put(car);
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting Assembler interrrupted!");
		} catch (BrokenBarrierException e){
			throw new RuntimeException(e);
		}
		System.out.println("Assembler Off...");
	}
	
}
	


class Reporter implements Runnable{

	private CarQueue carQueue;
	public Reporter(CarQueue carQueue){
		this.carQueue = carQueue;
	}
	public void run() {
		try {
			while(!Thread.interrupted()){
				System.out.println(carQueue.take());
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting Reporter via interrupted!");
		}
		System.out.println("Reporter Off");
	}
	
}

abstract class Robot implements Runnable{
	private RobotPool robotPool;
	public Robot(RobotPool robotPool){
		this.robotPool = robotPool;
	}
	protected Assembler assembler;
	public Robot assignAssembler(Assembler assembler){
		this.assembler = assembler;
		return this;
	}
	private boolean engage = false;
	public synchronized void engage(){
		engage = true;
		notifyAll();
	}
	abstract protected void preformService();
	public void run() {
		try {
			powerDown();
			while(!Thread.interrupted()){
				preformService();
				assembler.barrier().await();
				powerDown();
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting "+this+" via interrupted!");
		} catch (BrokenBarrierException e){
			throw new RuntimeException(e);
		}
		System.out.println(this+" Off...");
	}
	private synchronized void powerDown() throws InterruptedException{
		engage = false;
		assembler = null;
		robotPool.release(this);
		while(engage == false)
			wait();
	}
	@Override
	public String toString() {
		return getClass().getName();
	}
}
class EngineRobot extends Robot{

	public EngineRobot(RobotPool robotPool) {
		super(robotPool);
	}

	@Override
	protected void preformService() {
		System.out.println(this+" installing engine");
		assembler.car().addEngine();
	}
	
}
class DriverTrainRobot extends Robot{

	public DriverTrainRobot(RobotPool robotPool) {
		super(robotPool);
	}

	@Override
	protected void preformService() {
		System.out.println(this+" installing driver");
		assembler.car().addDriveTrain();
	}
	
}
class WheelRobot extends Robot{

	public WheelRobot(RobotPool robotPool) {
		super(robotPool);
	}

	@Override
	protected void preformService() {
		System.out.println(this+" installing wheel");
		assembler.car().addWheels();
	}
}
class RobotPool{
	private Set<Robot> pool = new HashSet<Robot>();
	public synchronized void add(Robot robot){
		pool.add(robot);
		notifyAll();
	}
	public synchronized void hire(Class<? extends Robot> robotType,Assembler d) throws InterruptedException{
		for(Robot robot:pool){
			if(robot.getClass().equals(robotType)){
				pool.remove(robot);
				robot.assignAssembler(d);
				robot.engage();
				return;
			}
		}
		wait();
		hire(robotType, d);
	}

	public void release(Robot robot) {
		add(robot);
	}
}
public class CarBuilder {

	public static void main(String[] args) throws InterruptedException {
		CarQueue chassisQueue = new CarQueue(),
				 finishingQueue = new CarQueue();
		ExecutorService exec = Executors.newCachedThreadPool();
		RobotPool robotPool = new RobotPool();
		exec.execute(new EngineRobot(robotPool));
		exec.execute(new DriverTrainRobot(robotPool));
		exec.execute(new WheelRobot(robotPool));
		exec.execute(new Assembler(chassisQueue, finishingQueue, robotPool));
		exec.execute(new Reporter(finishingQueue));
		exec.execute(new ChassisBuilder(chassisQueue));
		TimeUnit.SECONDS.sleep(10);
		exec.shutdownNow();
	}
}
