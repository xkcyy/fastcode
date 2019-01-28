package com.xkcyy.linq.impls;

import com.xkcyy.linq.ArrayEnumerable;

import java.util.Iterator;
import java.util.Objects;

/**
 * @description:
 * @author: yuand
 * @date: 2019-01-28 21:20
 **/
public class ArrayEnumerableImpl<T> implements ArrayEnumerable<T> {

    private final T[] arraySource;
    private final int length;
    public ArrayEnumerableImpl(T[] array) {
        Objects.requireNonNull(array);
        this.arraySource = array;
        this.length = array.length;
    }

    @Override
    public int count() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    @Override
    public T[] getArray() {
        return arraySource;
    }

    private class ArrayIterator implements Iterator<T>{
        private int cursor = 0;
        @Override
        public boolean hasNext() {
            return cursor<length;
        }

        @Override
        public T next() {
            return arraySource[cursor++];
        }
    }
}
