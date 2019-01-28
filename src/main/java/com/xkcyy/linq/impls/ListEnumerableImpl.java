package com.xkcyy.linq.impls;

import com.xkcyy.linq.ListEnumerable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @description:
 * @author: yuand
 * @date: 2019-01-28 22:24
 **/
public class ListEnumerableImpl<T> implements ListEnumerable<T> {

    private List<T> listSource;
    public ListEnumerableImpl(List<T> listSource){
        this.listSource=listSource;
    }

    @Override
    public int size() {
        return listSource.size();
    }

    @Override
    public boolean isEmpty() {
        return listSource.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return listSource.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return listSource.iterator();
    }

    @Override
    public Object[] toArray() {
        return listSource.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return listSource.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return listSource.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return listSource.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return listSource.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return listSource.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return listSource.addAll(index,c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return listSource.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return listSource.retainAll(c);
    }

    @Override
    public void clear() {
        listSource.clear();
    }

    @Override
    public T get(int index) {
        return listSource.get(index);
    }

    @Override
    public T set(int index, T element) {
        return listSource.set(index,element);
    }

    @Override
    public void add(int index, T element) {
        listSource.add(index,element);
    }

    @Override
    public T remove(int index) {
        return listSource.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return listSource.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return listSource.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return listSource.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return listSource.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return listSource.subList(fromIndex,toIndex);
    }
}
