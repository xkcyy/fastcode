package com.xkcyy.linq;

public interface GroupingEnumerable<TKey,TElement> extends Enumerable<TElement> {
    TKey getKey();
}
