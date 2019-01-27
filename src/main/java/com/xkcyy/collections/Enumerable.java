package com.xkcyy.collections;

import com.xkcyy.lambda.FuncWith2Args;
import com.xkcyy.lambda.FuncWithArg;
import com.xkcyy.collections.enumberables.SelectEnumerable;
import com.xkcyy.collections.enumberables.WhereEnumerable;

import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @description: 公开枚举器，该枚举器支持在指定类型的集合上进行简单迭代。
 * @author: yuand
 * @date: 2019-01-24 22:10
 **/
public interface Enumerable<T> extends Iterable<T> {
    static <T> Enumerable<T> parse(Iterable<T>  source) {
        return new RootEnumerable<>(source);
    }

    static <T> Enumerable<T> parse(T[] array) {
        return new ArrayEnumerable<>(array);
    }

    static Enumerable<Integer> range(Integer num) {
         return range(1,num);
    }

    static Enumerable<Integer> range(int start,int count){
        if(count<0) {
            return null;
        }
        Integer[] array = new Integer[count];
        for (int i = 0; i < count; i++) {
            array[i] = start+i;
        }
        return Enumerable.parse(array);
    }

    default <TTarget> Enumerable<TTarget> select(FuncWithArg<T,TTarget> selector){
        return new SelectEnumerable<>(this,selector);
    }

    default Enumerable<T> where(FuncWithArg<T,Boolean> predicate){
        return new WhereEnumerable<>(this,predicate);
    }

    default boolean contains(FuncWithArg<T,Boolean> predicate){
        for(T item :this){
            if(predicate.call(item)) {
                return true;
            }
        }
        return false;
    }

    default int count(){
        int count = 0;
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()){
            iterator.next();
            count++;
        }
        return count;
    }

    default <TAccumulate> TAccumulate aggregate(TAccumulate seed, FuncWith2Args<TAccumulate,T,TAccumulate> func){
        TAccumulate result = seed;
        for(T element : this){
            result = func.call(result,element);
        }
        return result;
    }


    default long sum(FuncWithArg<T,Integer> itemFunc){
        long result = 0;
        for(T element : this){
            result += itemFunc.call(element);
        }
        return result;
    }

    default T firstOrDefault(){
        for(T element : this){
           return element;
        }
        return null;
    }
    default T firstOrDefault(FuncWithArg<T,Boolean> predicate){
        return where(predicate).firstOrDefault();
    }
    default T first(){
        for(T element : this){
            return element;
        }
        throw new NoSuchElementException();
    }
    default T first(FuncWithArg<T,Boolean> predicate) {
        return where(predicate).first();
    }


}
