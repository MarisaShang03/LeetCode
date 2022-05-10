package com.company;

public class LC153 {

//    public int findMin(int[] nums) {
//        if (nums[0] < nums[nums.length - 1]) {
//            return nums[0];
//        }
//        return helper(0, nums.length - 1,nums);
//    }

    public int helper(int start, int end, int[] numbers) {
        int inflex = (start + end) / 2;
        if (start == end) {
            return numbers[inflex];
        }
        if (numbers[inflex] < numbers[inflex + 1] && numbers[inflex] > numbers[0]) {
            return helper(inflex + 1, end,numbers);
        } else if (numbers[inflex] < numbers[inflex + 1] && numbers[inflex] < numbers[0]) {
            return helper(start, end - 1,numbers);
        } else {
            return numbers[inflex+1];
        }
    }

    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int l=0, r=nums.length-1,m=-1;
        while(l<=r){ //??=
            m=(l+r)/2;
            if(nums[m]<nums[m+1] && nums[m]>nums[0]){
                l=m+1;
            }else if(nums[m]<nums[m+1] && nums[m]<nums[0]) {
                r = r - 1;
            }else{
                return nums[m+1];
            }
        }
        return -1;
    }
}
