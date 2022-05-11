package com.company;

public class LC33 {
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == target) {
                return m;
            } else if (nums[m] >= nums[l]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target <= nums[r] && target > nums[m]) {
                    r = r + 1;
                }else{
                    l=m-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
     //   int[] nums  = {4,5,6,7,0,1,2};
        int[] nums  = {1,3};
        System.out.println(search(nums, 0));
    }
}

