package com.company;

import java.util.HashSet;
import java.util.Set;

public class AS_twoNumberSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> set= new HashSet<>();
        for(int a:array){
            int b=targetSum-a;
            if(set.contains(b)){
                //以下两行可以变成return new int[] {a,b}
                int[] result={a,b};
                return result;

            }else{
                set.add(a);
            }
        }
        //int[0]注意
        return new int[0];
    }

}
