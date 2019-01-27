package com.xkcyy.lambda;
@FunctionalInterface
public interface FuncWithArg<TArg,TResult> {
    TResult call(TArg arg);
}
