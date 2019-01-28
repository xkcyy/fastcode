package com.xkcyy.linq;

import com.xkcyy.lambda.FuncWithArg;
import com.xkcyy.linq.impls.ArrayEnumerableImpl;
import com.xkcyy.linq.impls.WhereArrayEnumerable;

import java.util.Iterator;

/**
 * @description:
 * @author: yuand
 * @date: 2019-01-28 20:52
 **/
public interface Enumerable<T> extends Iterable<T>, EnumerableExtend<T> {
    default int count() {
        Iterator<T> iterator = iterator();
        int count = 0;
        if (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    }

    default Enumerable<T> where(FuncWithArg<T,Boolean> predicate){
        if(this instanceof ArrayEnumerable){
            return new WhereArrayEnumerable();
        }else if(this instanceof ListEnumerable){
            return new WhereListEnumerable();
        }
    }

    static <T> ArrayEnumerable<T> parse(T[] array) {
        return new ArrayEnumerableImpl<>(array);
    }


}
