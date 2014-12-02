package concurrency.section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import utils.CountingIntegerList;

abstract class ListTest extends Tester<List<Integer>>{

	ListTest(String testId, int nReaders, int nWriters) {
		super(testId, nReaders, nWriters);
	}
	class Reader extends TestTask{

		long result = 0;
		@Override
		void putResults() {
			readResult += result;
			readTime += duration;
		}

		@Override
		void test() {
			for(long i=0;i<testCycles;i++){
				for(int index=0;index<containerSize;i++){
					result += testContainer.get(index);
				}
			}
		}
		
	}
	
	class Writer extends TestTask{
		
		long result = 0;
		
		@Override
		void test() {
			for(long i=0;i<testCycles;i++){
				for(int index=0;index<containerSize;i++){
					testContainer.set(index, writerData[index]);
				}
			}
		}
		@Override
		void putResults() {
			writerTime += duration;
		}
	}
	@Override
	void startReaderAndWriters() {
		for(int i=0;i<nReaders;i++)
			exec.execute(new Reader());
		for(int i=0;i<nWriters;i++)
			exec.execute(new Writer());
	}
}

class SynchronizedArrayListTest extends ListTest{

	@Override
	List<Integer> containerInitializer() {
		return Collections.synchronizedList(new ArrayList<Integer>(new CountingIntegerList(containerSize)));
	}
	SynchronizedArrayListTest( int nReaders, int nWriters) {
		super("Synched ArrayList", nReaders, nWriters);
	}
	
}
 
class CopyOnWriteArrayListTest extends ListTest{

	CopyOnWriteArrayListTest(int nReaders, int nWriters) {
		super("CopyOnWriteArrayListTest", nReaders, nWriters);
	}

	@Override
	List<Integer> containerInitializer() {
		return new CopyOnWriteArrayList<Integer>(new CountingIntegerList(containerSize));
	}
}

public class ListComparisons {

	public static void main(String[] args) {
		Tester.initMain(args);
		new SynchronizedArrayListTest(10, 0);
		new SynchronizedArrayListTest(9, 1);
		new SynchronizedArrayListTest(5, 5);
		new CopyOnWriteArrayListTest(10, 0);
		new CopyOnWriteArrayListTest(9, 1 );
		new CopyOnWriteArrayListTest(5, 5);
	}
}
