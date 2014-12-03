package concurrency.section9;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import utils.MapData;
import arrays.CountingGenerator;

;

abstract class MapTest extends Tester<Map<Integer, Integer>> {

	MapTest(String testId, int nReaders, int nWriters) {
		super(testId, nReaders, nWriters);
	}

	class Reader extends TestTask {

		long result = 0;

		@Override
		void putResults() {
			readResult += result;
			readTime += duration;
		}

		@Override
		void test() {
			for (long i = 0; i < testCycles; i++)
				for (int index = 0; index < containerSize; index++)
					result += testContainer.get(index);
		}

	}

	class Writer extends TestTask {

		long result = 0;

		@Override
		void putResults() {
			writerTime += duration;
		}

		@Override
		void test() {
			for (long i = 0; i < testCycles; i++)
				for (int index = 0; index < containerSize; index++)
					testContainer.put(index, writerData[index]);
		}

	}

	@Override
	void startReaderAndWriters() {
		for (int i = 0; i < nReaders; i++)
			exec.execute(new Reader());
		for (int i = 0; i < nWriters; i++)
			exec.execute(new Writer());
	}
}

class SynchronizationHashMapTester extends MapTest {

	SynchronizationHashMapTester(int nReaders, int nWriters) {
		super("SynchronizationHashMapTester", nReaders, nWriters);
	}

	@Override
	Map<Integer, Integer> containerInitializer() {
		return Collections.synchronizedMap(new HashMap<Integer, Integer>(
				MapData.map(new CountingGenerator.Integer(),
						new CountingGenerator.Integer(), containerSize)));
	}

}

class ConcurrentHashMapTester extends MapTest {

	ConcurrentHashMapTester(int nReaders, int nWriters) {
		super("ConcurrentHashMapTester", nReaders, nWriters);
	}

	@Override
	Map<Integer, Integer> containerInitializer() {
		return new ConcurrentHashMap<Integer, Integer>(MapData.map(
				new CountingGenerator.Integer(),
				new CountingGenerator.Integer(), containerSize));
	}
}

public class MapComparisons {

	public static void main(String[] args) {
		Tester.initMain(args);
		new SynchronizationHashMapTester(10, 0);
		new SynchronizationHashMapTester(9, 1);
		new SynchronizationHashMapTester(5, 5);
		new ConcurrentHashMapTester(10, 0);
		new ConcurrentHashMapTester(9, 1);
		new ConcurrentHashMapTester(5, 5);
		
	}
}
