package com.xkcyy.linq.impls;

import com.xkcyy.linq.Enumerable;

import java.util.Iterator;
import java.util.Objects;

/**
 * @description:
 * @author: yuand
 * @date: 2019-01-28 22:19
 **/
public class DefaultEnumerableImpl<T> implements Enumerable<T> {
    private Iterable<T> source;
    protected Iterable<T> getSource(){
        return source;
    }
    public DefaultEnumerableImpl(Iterable<T> source){
        Objects.requireNonNull(source);
        this.source=source;
    }
    @Override
    public Iterator<T> iterator() {
        return source.iterator();
    }
}
