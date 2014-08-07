package containers;

import java.util.PriorityQueue;

/** 
 * @Description: well you know, it is just a test! so you can ignore it!!
 * @author Rock King 2014年8月8日 上午2:38:39 
 * @see ~!^ Keep bugs away and code with U!	 
 */ 
class ToDoList extends PriorityQueue<ToDoList.ToDoItem>{

	static class ToDoItem implements Comparable<ToDoItem>{

		private char primary;
		private int secondry;
		private String item;
		public ToDoItem(String item,int secondry,char primary){
			this.item = item;
			this.secondry = secondry;
			this.primary = primary;
		}
		@Override
		public int compareTo(ToDoItem o) {
			if(primary>o.primary)
				return +1;
			if(primary == o.primary){
				if(secondry>o.secondry)
					return +1;
				else if(secondry == o.secondry)
					return 0;
			}
			return -1;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return Character.toString(primary)+secondry+": "+item; 
		}
	}
	public void add(char primary,int secondry,String item) {
		super.add(new ToDoItem(item, secondry, primary));
	}
	
	public static void main(String[] args) {
		ToDoList toDoList = new ToDoList();
		toDoList.add('C',4,"Empty trash");
		toDoList.add('A',2,"Feed Dog");
		toDoList.add('B',3,"Feed Bird");
		toDoList.add('B',2,"Mow Laun");
		toDoList.add('C',1,"Feed Cat");
		while(!toDoList.isEmpty()){
			System.out.println(toDoList.remove());
		}
		
	}
}
