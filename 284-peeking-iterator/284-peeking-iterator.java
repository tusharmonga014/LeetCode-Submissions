// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer currentVal;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iter = iterator;
        this.currentVal = iter.hasNext() ? iter.next() : null;
        
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return this.currentVal;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer nVal = this.currentVal;
        this.currentVal = iter.hasNext() ? iter.next() : null;
        return nVal;
	}
	
	@Override
	public boolean hasNext() {
	    return this.currentVal != null;
	}
}