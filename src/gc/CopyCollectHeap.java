package gc;

/**
 * For simplicity, implement Fenichel's algorithm instead of Cheney's algorithm.
 * 
 * Semi-space garbage collection [Fenichel, 1969] is a copying algorithm, which
 * means that reachable objects are relocated from one address to another during
 * a collection. Available memory is divided into two equal-size regions called
 * "from-space" and "to-space".
 * 
 * Allocation is simply a matter of keeping a pointer into to-space which is
 * incremented by the amount of memory requested for each allocation (that is,
 * memory is allocated sequentially out of to-space). When there is insufficient
 * space in to-space to fulfill an allocation, a collection is performed.
 * 
 * A collection consists of swapping the roles of the regions, and copying the
 * live objects from from-space to to-space, leaving a block of free space
 * (corresponding to the memory used by all unreachable objects) at the end of
 * the to-space.
 * 
 * Since objects are moved during a collection, the addresses of all references
 * must be updated. This is done by storing a "forwarding address" for an object
 * when it is copied out of from-space. Like the mark-bit, this forwarding
 * address can be thought of as an additional field of the object, but is
 * usually implemented by temporarily repurposing some space from the object.
 * 
 * The primary benefits of semi-space collection over mark-sweep are that the
 * allocation costs are extremely low (no need to maintain and search the free
 * list), and fragmentation is avoided.
 */
public class CopyCollectHeap extends Heap {
	private static final int SIZE = -1;
	private static final int FORWARD = -2;

	private int toSpace;
	private int fromSpace;
	private int allocPtr;

	/**
	 * Though the super constructor is invoked and the free list is initialized,
	 * the free list is not used in the implementation of this copy collector.
	 */
	public CopyCollectHeap(int size) {
		super(size);
		toSpace = 0;
		fromSpace = size / 2;
		allocPtr = toSpace;
	}

	public void allocate(Var v, int size) throws InsufficientMemory {
		// TODO
	}

	private void collect() {
		// TODO
	}

	private int copy(int addr) {
		// TODO
		return 0;
	}
}
