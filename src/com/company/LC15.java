package com.company;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //注意declare语法
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums,res,i);
            }
        }
        return res;
    }
     public void twoSum(int[] nums,List<List <Integer>> res, int i){
            int l=i+1,r=nums.length-1;
            while(l<r){
                int sum=nums[l]+nums[r];
                if(sum==-nums[i]){
                    res.add(Arrays.asList( nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                }else if(sum<-nums[i]){
                    l++;
                }else{
                    r--;
                }
            }
        }
}
