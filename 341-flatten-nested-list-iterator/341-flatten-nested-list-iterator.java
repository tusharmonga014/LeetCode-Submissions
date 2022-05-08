/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    ArrayList<Integer> arr;
    int idx;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.arr = new ArrayList<>();
        this.idx = 0;
        fillArr(nestedList, 0);
    }
    
    private void fillArr(List<NestedInteger> nestedList, int i) {
        if(i == nestedList.size()) {
            return;
        }
        NestedInteger ni = nestedList.get(i);
        if(ni.isInteger()) {
            this.arr.add(ni.getInteger());
        } else {
            fillArr(ni.getList(), 0);
        }
        fillArr(nestedList, i + 1);
    }

    @Override
    public Integer next() {
        return this.arr.get(this.idx++);
    }

    @Override
    public boolean hasNext() {
        return this.idx < this.arr.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */