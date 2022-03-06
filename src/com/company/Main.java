package com.company;

import java.util.Arrays;

public class Main {

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] sCount=new int[26];
        int[] tCount=new int[26];
        for(int i=0;i<s.length();i++){
            sCount[s.charAt(i)-'a']++;
            tCount[t.charAt(i)-'a']++;
        }
        return Arrays.equals(sCount,tCount);
    }
    public static boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()) return false;
        boolean[] flag=new boolean[s.length()];
        Arrays.fill(flag,false);
        for(int i=0;i<s.length();i++){
            for(int j=0;j<t.length();j++){
                if(s.charAt(i)==t.charAt(j) && flag[j]==false){
                    flag[j]=true;
                }
            }
        }
        for(boolean k:flag){
            if(k==false){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
    isAnagram2("aacc", "ccac");
    }
}
