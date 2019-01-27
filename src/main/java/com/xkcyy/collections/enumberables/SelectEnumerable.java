package com.xkcyy.collections.enumberables;

import com.xkcyy.lambda.FuncWithArg;
import com.xkcyy.collections.Enumerable;

import java.util.Iterator;

/**
 * @description:
 * @author: yuand
 * @date: 2019-01-27 16:24
 **/
public class SelectEnumerable<TSource,TTarget> implements Enumerable<TTarget> {
    private Enumerable<TSource> baseEnumerable;
    private FuncWithArg<TSource,TTarget> selector;
    public SelectEnumerable(Enumerable<TSource> baseEnumerable, FuncWithArg<TSource,TTarget> selector){
        this.baseEnumerable=baseEnumerable;
        this.selector=selector;
    }

    @Override
    public Iterator<TTarget> iterator() {
        return new SelectEnumerableIterator();
    }

    @Override
    public <TNewTarget> Enumerable<TNewTarget> select(FuncWithArg<TTarget,TNewTarget> newSelector){
        FuncWithArg<TSource,TNewTarget> newSelector2=
                x->newSelector.call(selector.call(x));
        SelectEnumerable<TSource,TNewTarget> result =new SelectEnumerable<>(baseEnumerable,newSelector2);
        return result;
    }

    @Override
    public int count() {
        return baseEnumerable.count();
    }

    private class SelectEnumerableIterator implements Iterator<TTarget>{
        private Iterator<TSource> baseIterator;
        public SelectEnumerableIterator(){
            this.baseIterator= SelectEnumerable.this.baseEnumerable.iterator();
        }
        @Override
        public boolean hasNext() {
            return baseIterator.hasNext();
        }

        @Override
        public TTarget next() {
            TSource next = baseIterator.next();
            return SelectEnumerable.this.selector.call(next);
        }
    }
}
