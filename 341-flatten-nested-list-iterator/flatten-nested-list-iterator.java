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
    List<Integer> list;
    int curr, size;
    public NestedIterator(List<NestedInteger> nestedList) {
        list=new ArrayList<Integer>();
        for(NestedInteger i:nestedList){
            if(i.isInteger()){
                list.add(i.getInteger());
            }
            else{
                NestedIterator itr = new NestedIterator(i.getList());
                list.addAll(itr.list);
            }
        }
        curr=0;
        size=list.size();
    }

    @Override
    public Integer next() {
        return list.get(curr++);
    }

    @Override
    public boolean hasNext() {
        if(curr<size){
            return true;
        }

        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */