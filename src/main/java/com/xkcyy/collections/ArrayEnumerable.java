package com.xkcyy.collections;

import java.util.*;
import java.util.function.Consumer;

/**
 * @description: 数组枚举器
 * @author: yuand
 * @date: 2019-01-24 23:08
 **/
public class ArrayEnumerable<T> extends RootEnumerable<T> {
    private T[] array;
    public ArrayEnumerable(T[] source){
        this(new ArrayIterable<>(source));
        array=source;
    }
    public ArrayEnumerable(ArrayIterable<T> source){
        super(source);
    }

    @Override
    public int count() {
        return array.length;
    }
}

