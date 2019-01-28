package com.xkcyy.linq;

import com.xkcyy.lambda.FuncWithArg;

import java.util.Comparator;

public interface OrderedEnumerable<T> extends Enumerable<T> {
    <TKey extends Comparable<TKey>> OrderedEnumerable<T> thenBy(FuncWithArg<T, TKey> keySelector);
    <TKey> OrderedEnumerable<T> thenBy(FuncWithArg<T, TKey> keySelector,Comparator<TKey> comparator);
    <TKey extends Comparable<TKey>> OrderedEnumerable<T> thenByDescending(FuncWithArg<T, TKey> keySelector);
    <TKey> OrderedEnumerable<T> thenByDescending(FuncWithArg<T, TKey> keySelector, Comparator<TKey> comparator);
}
