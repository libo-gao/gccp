package gc;

/**
 * A reference-counting heap.
 */
public class RefCountHeap extends Heap {
	private static final int SIZE = -1;
	private static final int COUNTER = -2;

	public RefCountHeap(int size) {
		super(size);
	}

	public void endScope() {
		// TODO decrease counters
		super.endScope();
	}

	/**
	 * Allocate memory with 2 extra slots, one for the object size, the other
	 * for the reference counter.
	 */
	public void allocate(Var v, int size) throws InsufficientMemory {
		super.allocate(v, size + 2);
		v.addr += 2;
		data[v.addr + SIZE] = size;
		data[v.addr + COUNTER] = 1;
	}

	public void assign(Var v1, Var v2) {
		if (!v1.isNull())
			decreaseCounter(v1.addr);
		super.assign(v1, v2);
		increaseCounter(v1.addr);
	}

	public void readField(Var v1, Var v2, int fieldOffset) {
		// TODO decrease counter
		super.readField(v1, v2, fieldOffset);
		// TODO increase counter
	}

	public void writeField(Var v1, int fieldOffset, Var v2) {
		// TODO decrease counter
		super.writeField(v1, fieldOffset, v2);
		// TODO increase counter
	}

	private void increaseCounter(int addr) {
		// TODO
	}

	private void decreaseCounter(int addr) {
		// TODO
	}
}
