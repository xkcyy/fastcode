package com.xkcyy.lambda;

/**
 * @description:
 * @author: yuand
 * @date: 2019-01-27 21:34
 **/
@FunctionalInterface
public interface FuncWith2Args<TArg1,TArg2,TResult>  {
    TResult call(TArg1 arg1,TArg2 arg2);
}


