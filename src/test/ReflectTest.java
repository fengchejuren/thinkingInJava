package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import domain.Car;

public class ReflectTest {

	public static Car intClassByDefaultConst() throws Exception{
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class<?> car = loader.loadClass("domain.Car");
		
		Constructor<?> constructor = car.getDeclaredConstructor((Class[])null);
		Car car2 = (Car) constructor.newInstance();
		Method setBrand = car.getMethod("setBrand", String.class);
		setBrand.invoke(car2, "GoodCar");
		Method setColor = car.getMethod("setColor", String.class);
		setColor.invoke(car2, "black");
		Method setMaxspeed = car.getMethod("setMaxspeed", int.class);
		setMaxspeed.invoke(car2, 5);
		
		return car2;
		
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(intClassByDefaultConst().getBrand());
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		System.out.println(loader);
		System.out.println(loader.getParent());
		System.out.println(loader.getParent().getParent());
		
		
	}
	
}
