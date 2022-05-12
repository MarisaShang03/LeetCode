package com.company;

public class LC371 {
    public int getSum(int a, int b) {
    int x=Math.abs(a), y=Math.abs(b);
    if(a<b){
        getSum(b,a);
    }
    int sign=a>0? 0:1;
    if(a*b>=0){
        //sum a+b

        while(y!=0) {
            int answer = x ^ y;
            int carry = (x & y) << 1;
            x=answer;
            y=carry;
        }
    }else{
        //a-b
        while(y!=0){
            int answer=x^y;
            int borrow=(-x)&y << 1;
            x=answer;
            y=borrow;
        }
    }
    return x*sign;
    }
}
