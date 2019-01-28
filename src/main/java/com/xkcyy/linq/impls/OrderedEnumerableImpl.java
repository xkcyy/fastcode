package com.xkcyy.linq.impls;

import com.xkcyy.lambda.FuncWithArg;
import com.xkcyy.linq.Enumerable;
import com.xkcyy.linq.OrderedEnumerable;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Comparator;
import java.util.Iterator;

/**
 * @description:
 * @author: yuand
 * @date: 2019-01-28 22:32
 **/
public class OrderedEnumerableImpl<TKey,TElement> extends DefaultEnumerableImpl<TElement> implements OrderedEnumerable<TElement> {
    FuncWithArg<TElement,TKey> keySelector;
    OrderedEnumerable<TElement> parent
    public OrderedEnumerableImpl(TKey key, Enumerable<TElement> source){
        super(source);
    }

    @Override
    public <TKey extends Comparable<TKey>> OrderedEnumerable<TElement> thenBy(FuncWithArg<TElement, TKey> keySelector) {
        return null;
    }

    @Override
    public <TKey> OrderedEnumerable<TElement> thenBy(FuncWithArg<TElement, TKey> keySelector, Comparator<TKey> comparator) {
        return null;
    }

    @Override
    public <TKey extends Comparable<TKey>> OrderedEnumerable<TElement> thenByDescending(FuncWithArg<TElement, TKey> keySelector) {
        return null;
    }

    @Override
    public <TKey> OrderedEnumerable<TElement> thenByDescending(FuncWithArg<TElement, TKey> keySelector, Comparator<TKey> comparator) {
        return null;
    }

    @Override
    public Iterator<TElement> iterator() {
        return null;
    }
}
