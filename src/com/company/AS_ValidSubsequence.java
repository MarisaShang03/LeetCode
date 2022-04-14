package com.company;

import java.util.Arrays;
import java.util.List;

public class AS_ValidSubsequence {
    //自己写的 应该是对的 但AE run不出
    public static boolean isValidSubsequence2(List<Integer> array, List<Integer> sequence) {
        int a = 0, b = 0;
        while (b < sequence.size()) {
            while (a < array.size()) {
                if (sequence.get(b).equals(array.get(a))) {
                    b++;
                }
                a++;
            }
        }
        return b == sequence.size();
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int a = 0, b = 0;
        while (b < sequence.size() && a < array.size() ) {
                if (sequence.get(b).equals(array.get(a))) {
                    b++;
                }
                a++;
            }
        return b == sequence.size();
    }

    public static void main(String[] args){
       var array= Arrays.asList( 5, 1, 22, 25, 6, -1, 8, 10);
       var  sequence =Arrays.asList(1, 6, -1, 10);
        System.out.println(isValidSubsequence(array,sequence));
        System.out.println(isValidSubsequence2(array,sequence));

    }
}
