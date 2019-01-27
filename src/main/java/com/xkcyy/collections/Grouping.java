package com.xkcyy.collections;

public interface Grouping<TKey, TSource> extends Enumerable<TSource> {
    TKey getKey();
}
