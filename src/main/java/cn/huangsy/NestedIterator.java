package cn.huangsy;

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
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

import java.util.*;

/**
 * @author huangsy
 * @date 2021/3/23 8:39
 */
public class NestedIterator implements Iterator<Integer> {

    Deque<Iterator<NestedInteger>> deque = new LinkedList<Iterator<NestedInteger>>();

    public NestedIterator(List<NestedInteger> nestedList) {
        deque.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return deque.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!deque.isEmpty()) {
            Iterator<NestedInteger> it = deque.peek();
            if (!it.hasNext()) {
                deque.pop();
                continue;
            }

            NestedInteger next = it.next();
            if (next.isInteger()) {
                List<NestedInteger> nestedIntegers = new ArrayList<>();
                nestedIntegers.add(next);
                deque.push(nestedIntegers.iterator());
                return true;
            }
            deque.push(next.getList().iterator());
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */