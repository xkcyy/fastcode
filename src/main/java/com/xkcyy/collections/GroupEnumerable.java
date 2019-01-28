package com.xkcyy.collections;

public interface GroupEnumerable<TKey, TSource> extends Enumerable<TSource> {
    TKey getKey();

}
