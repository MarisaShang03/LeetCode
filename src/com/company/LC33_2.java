package com.company;

public class LC33_2 {
    public static int search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        } else if(nums.length == 1) {
            return -1;
        }

        while(l<=r){
            int m=(l+r)/2;
            if(nums[m]==target){
                return m;
            }


            if(target>nums[m] )  {
                l=m+1;;
            }else if(target<nums[m] && target<nums[0] && nums[m]>=nums[0]){
                l=m+1;;
            } else if(target<nums[m] && target>nums[0] ) {
                r=m-1;
            }else if(target<nums[0] && target <nums[0] && nums[m]<=nums[0]){
                r=m-1;
            }
        }
        return -1;
    }
}
