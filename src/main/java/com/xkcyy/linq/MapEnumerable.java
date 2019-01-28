package com.xkcyy.linq;

import java.util.HashMap;
import java.util.Map;

public interface MapEnumerable<TKey,TValue> extends Map<TKey,TValue> ,Enumerable<Map.Entry<TKey,TValue>> {
    
}
