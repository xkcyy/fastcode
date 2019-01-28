package com.xkcyy.linq;

import java.util.Iterator;
import java.util.Objects;

/**
 * @description: 数组
 * @author: yuand
 * @date: 2019-01-28 20:58
 **/
public interface ArrayEnumerable<T> extends Enumerable<T>{
    T[] getArray();
}
