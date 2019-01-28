package com.xkcyy.linq;

public interface LimitEnumerable<T> extends Enumerable<T> {
    default int getOffSet(){
        return 0;
    }
    int getLimitCount();
}
