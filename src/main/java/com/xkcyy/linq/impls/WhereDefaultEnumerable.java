package com.xkcyy.linq.impls;

import com.xkcyy.lambda.FuncWithArg;
import com.xkcyy.linq.Enumerable;

import java.util.Iterator;

/**
 * @description:
 * @author: yuand
 * @date: 2019-01-28 23:29
 **/
class WhereDefaultEnumerable <TSource> implements Enumerable<TSource> {
    Enumerable<TSource> source;
    FuncWithArg<TSource, Boolean> predicate;

    public WhereDefaultEnumerable(Enumerable<TSource> source, FuncWithArg<TSource, Boolean> predicate){
        this.source=source;
        this.predicate=predicate;
    }

    @Override
    public Iterator<TSource> iterator() {
        return new WhereEnumerableIterator();
    }

    @Override
    public Enumerable<TSource> where(FuncWithArg<TSource,Boolean> predicate){
        FuncWithArg<TSource,Boolean> newPredicate= x->this.predicate.call(x)&&predicate.call(x);
        return new WhereDefaultEnumerable<>(this.source,newPredicate);
    }
    private class WhereEnumerableIterator implements Iterator<TSource>{
        private Iterator<TSource> baseIterator;
        private TSource current;
        private WhereEnumerableIterator(){
            baseIterator= WhereDefaultEnumerable.this.source.iterator();
        }
        @Override
        public boolean hasNext() {
            while (baseIterator.hasNext()) {
                TSource next = baseIterator.next();
                if (predicate.call(current)) {
                    current = next;
                    return true;
                }
            }
            current = null;
            return false;
        }

        @Override
        public TSource next() {
            return current;
        }
    }
}
