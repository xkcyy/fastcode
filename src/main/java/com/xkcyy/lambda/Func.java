package com.xkcyy.lambda;

/**
 * @description:
 * @author: yuand
 * @date: 2019-01-27 00:31
 **/
@FunctionalInterface
public interface Func<TResult> {
    TResult call();
}
