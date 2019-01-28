package com.xkcyy.linq.impls;

import com.xkcyy.lambda.FuncWithArg;
import com.xkcyy.linq.Enumerable;

import java.util.Iterator;

/**
 * @description:
 * @author: yuand
 * @date: 2019-01-28 23:06
 **/
public class WhereSelectDefaultEnumerable<TSource,TTarget> implements Enumerable<TTarget> {
    private Enumerable<TSource> baseEnumerable;
    private FuncWithArg<TSource,TTarget> selector;
    public WhereSelectDefaultEnumerable(Enumerable<TSource> baseEnumerable, FuncWithArg<TSource,TTarget> selector){
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
        WhereSelectDefaultEnumerable<TSource,TNewTarget> result =new WhereSelectDefaultEnumerable<>(baseEnumerable,newSelector2);
        return result;
    }

    @Override
    public int count() {
        return baseEnumerable.count();
    }

    private class SelectEnumerableIterator implements Iterator<TTarget>{
        private Iterator<TSource> baseIterator;
        public SelectEnumerableIterator(){
            this.baseIterator= WhereSelectDefaultEnumerable.this.baseEnumerable.iterator();
        }
        @Override
        public boolean hasNext() {
            return baseIterator.hasNext();
        }

        @Override
        public TTarget next() {
            TSource next = baseIterator.next();
            return WhereSelectDefaultEnumerable.this.selector.call(next);
        }
    }
}
