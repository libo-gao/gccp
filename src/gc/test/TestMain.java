package gc.test;

import gc.CopyCollectHeap;
import gc.Heap;
import gc.MarkSweepHeap;
import gc.RefCountHeap;

public class TestMain {
	private void run(String caseName, Heap heap, TestCase test) {
		try {
			test.run(heap);
			System.out.println("✔ " + caseName);
		} catch (Exception e) {
			System.out.println("✘ " + caseName);
		}
	}

	public void run() {
		run("node normal", new Heap(300), new TestNode(100));
		run("node refcount", new RefCountHeap(204), new TestNode(100));
		run("node marksweep", new MarkSweepHeap(204), new TestNode(100));
		run("node copycollect", new MarkSweepHeap(204), new TestNode(100));

		run("cycle normal", new Heap(100000), new TestCycle(50));
		run("cycle marksweep", new MarkSweepHeap(104), new TestCycle(50));
		run("cycle copycollect", new CopyCollectHeap(208), new TestCycle(50));
	}

	public static void main(String[] args) {
		TestMain test = new TestMain();
		test.run();
	}
}
