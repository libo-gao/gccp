package gc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MarkSweepHeap extends Heap {
	private static final int SIZE = -1;
	private static final int MARKER = -2;

	private int markTag = 0;
	private Set<Integer> allocatedObjectAddresses = new HashSet<Integer>();

	public MarkSweepHeap(int size) {
		super(size);
	}

	public void allocate(Var v, int size) throws InsufficientMemory {
		try {
			allocateObject(v, size);
		} catch (InsufficientMemory e) {
			markAndSweep();
			allocateObject(v, size);
		}
		// TODO
	}

	/**
	 * Allocate memory with 2 extra slots, one for the object size, the other
	 * for the marker.
	 */
	private void allocateObject(Var v, int size) throws InsufficientMemory {
		super.allocate(v, size + 2);
		// TODO
	}

	private void markAndSweep() {
		// TODO
	}

	private void mark(int addr) {
		// TODO
	}

	private boolean sweep(int addr) {
		// TODO
		return false;
	}
}
