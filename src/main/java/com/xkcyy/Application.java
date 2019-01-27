package com.xkcyy;

import com.xkcyy.collections.Enumerable;

/**
 * @description:
 * @author: yuand
 * @date: 2019-01-24 22:06
 **/
public class Application {
    public static void main(String[] args){
        try{
            System.out.println("开始:");
        /*    int count = Enumerable.range(5)
                    .count();*/
            long total = Enumerable.range(5).sum(x->x);
            System.out.println("计数:"+total);
            for(int zz : Enumerable.range(5)){
                System.out.println("计数:"+zz);
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
