package com.xkcyy.linq.impls;

import com.xkcyy.lambda.Func;
import com.xkcyy.lambda.FuncWithArg;
import com.xkcyy.linq.Enumerable;
import com.xkcyy.linq.ListEnumerable;

import java.util.Iterator;

/**
 * @description:
 * @author: yuand
 * @date: 2019-01-28 23:34
 **/
public class WhereListEnumerable<TSource> implements Enumerable<TSource> {
    private ListEnumerable<TSource> source;
    FuncWithArg<TSource, Boolean> predicate;
    public WhereListEnumerable(ListEnumerable<TSource> source,FuncWithArg<TSource, Boolean> predicate){
        this.source=source;
        this.predicate=predicate;
    }

    @Override
    public Iterator<TSource> iterator() {
        return null;
    }
}
