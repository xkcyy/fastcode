package com.xkcyy.linq.impls;

import com.xkcyy.linq.ArrayEnumerable;
import com.xkcyy.linq.Enumerable;

import java.util.Iterator;

/**
 * @description:
 * @author: yuand
 * @date: 2019-01-28 23:11
 **/
public class WhereSelectArrayEnumerable<TSource,TTarget> implements Enumerable<TTarget> {
    private ArrayEnumerable<TSource> source;
    public WhereSelectArrayEnumerable(ArrayEnumerable<TSource> source){
        this.source=source;
    }

    @Override
    public int count() {
        return source.count();
    }

    @Override
    public Iterator<TTarget> iterator() {
        return source.iterator();
    }
}
