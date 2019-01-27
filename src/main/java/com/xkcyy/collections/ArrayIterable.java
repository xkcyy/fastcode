package com.xkcyy.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @description:
 * @author: yuand
 * @date: 2019-01-27 16:12
 **/
public class ArrayIterable<T> implements Iterable<T> {
    private T[] source;
    public ArrayIterable(T[] source){
        this.source=source;
    }
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator(source);
    }

    private static class ArrayIterator<E> implements Iterator<E> {
        int cursor;
        int lastRet = -1;
        int arrayLength ;
        E[] source;
        ArrayIterator(E[] array) {
            Objects.requireNonNull(array);
            source=array;
            arrayLength=array.length;
        }

        @Override
        public boolean hasNext() {
            return cursor != arrayLength;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            int i = cursor;
            if (i >= arrayLength) {
                throw new NoSuchElementException();
            }
            cursor = i + 1;
            return source[lastRet = i];
        }

        @Override
        @SuppressWarnings("unchecked")
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            int i = cursor;
            if (i >= arrayLength) {
                return;
            }
            while (i != arrayLength ) {
                consumer.accept(source[i++]);
            }
            cursor = i;
            lastRet = i - 1;
        }
    }
}
