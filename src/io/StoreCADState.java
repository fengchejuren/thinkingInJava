/**  
 * @Title: StoreCADStates.java 
 * @Package io 
 * @Description: TODO 
 * @author Rock King 2014年8月15日 上午12:02:13
 * @version V1.0  
 */ 
package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**Shape实现了Serializable接口，所以任何继承Shape的类也是可以序列化的。
 * 每个Shape都含有数据，并且每个Shape都含有一个static 字段，用来确定Shape类型的颜色。
 * @author Administrator
 *
 */
abstract class Shape implements Serializable{
	
	public static final int RED=1,BLUE=2,GREEN=3;
	
	private int xPos,yPos,dimention;
	
	private static int counter = 0;
	
	private static Random random = new Random(47);
	
	public abstract void setColor(int color);
	public abstract int getColor();
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass()+" [ Color="+getColor()+",xPos="+xPos+" ,yPos= "+yPos+",dimention="+dimention+" ] \n";
	}
	
	public Shape(int xPos, int yPos, int dimention) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.dimention = dimention;
	}
	
	public static Shape randomFactory(){
		int xVal = random.nextInt(100);
		int yVal = random.nextInt(100);
		int dimention = random.nextInt(100);
		switch(counter++ % 3){
			default:
			case 0: return new Circle(xVal,yVal,dimention);	
			case 1: return new Square(xVal, yVal, dimention);
			case 2: return new Line(xVal, yVal, dimention);
		}
		
	}
	
}

class Circle extends Shape{
	
	private static int color = RED;
	
	/**
	 * @param xPos
	 * @param yPos
	 * @param dimention
	 */
	public Circle(int xPos, int yPos, int dimention) {
		super(xPos, yPos, dimention);
	}

	/* (non-Javadoc)
	 * @see io.Shape#setColor(int)
	 */
	@Override
	public void setColor(int color) {
		this.color = color;
		
	}

	/* (non-Javadoc)
	 * @see io.Shape#getColor()
	 */
	@Override
	public int getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	
}

class Square extends Shape{

	private static int color ;
	/**
	 * @param xPos
	 * @param yPos
	 * @param dimention
	 */
	public Square(int xPos, int yPos, int dimention) {
		super(xPos, yPos, dimention);
		color = RED;
	}

	/* (non-Javadoc)
	 * @see io.Shape#setColor(int)
	 */
	@Override
	public void setColor(int color) {
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see io.Shape#getColor()
	 */
	@Override
	public int getColor() {
		return color;
	}
	
}

class Line extends Shape{

	private static int color = RED;
	public static void serializeStaticState(ObjectOutputStream out) throws IOException{
		out.writeInt(color);
	}

	public static void deSerializeStaticState(ObjectInputStream in) throws IOException{
		color = in.readInt();
	}
	/**
	 * @param xPos
	 * @param yPos
	 * @param dimention
	 */
	public Line(int xPos, int yPos, int dimention) {
		super(xPos, yPos, dimention);
	}

	/* (non-Javadoc)
	 * @see io.Shape#setColor(int)
	 */
	@Override
	public void setColor(int color) {
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see io.Shape#getColor()
	 */
	@Override
	public int getColor() {
		return color;
	}
	
	
}


/** 只要将任何对象序列化到单一的流中，就可以恢复出与我们当时写的一样的对象网，并且没有任何意外重复复制出的对象。
 * 如果想保存系统状态，最安全的做法是将其作为“原子”的操作进行序列化
 * @Description: TODO
 * @author Rock King 2014年8月15日 上午12:02:13 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class StoreCADState {

	public static void main(String[] args) throws IOException, Exception {
		List<Class<? extends Shape>> shapeType = new ArrayList<Class<? extends Shape>>();
		//add reference to the List class
		shapeType.add(Circle.class);
		shapeType.add(Square.class);
		shapeType.add(Line.class);
		List<Shape> shapes = new ArrayList<Shape>();
		// make some shapes
		for(int i=0;i<10;i++)
			shapes.add(Shape.randomFactory());
		for(int i=0;i<10;i++)
			shapes.get(i).setColor(Shape.GREEN);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
		out.writeObject(shapeType);
		Line.serializeStaticState(out);
		out.writeObject(shapes);
		//out.close();
		System.out.println(shapes);
	}
	
	
	
}
