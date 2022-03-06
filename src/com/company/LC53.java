package com.company;

import java.util.Arrays;
//For LC
public class LC53 {
//    public int maxSubArray(int[] nums) {
//        // Initialize our variables using the first element.
//        int currentSubarray = nums[0];
//        int maxSubarray = nums[0];
//
//        // Start with the 2nd element since we already used the first one.
//        for (int i = 1; i < nums.length; i++) {
//            int num = nums[i];
//            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
//            currentSubarray = Math.max(num, currentSubarray + num);
//            maxSubarray = Math.max(maxSubarray, currentSubarray);
//        }
//        return maxSubarray;
//    }
//    public static int maxSubArray(int[] nums) {
//        int[] dp=new int[nums.length+1];
//        Arrays.fill(dp,Integer.MIN_VALUE);
//        dp[0]=0;
//        for(int i=0;i<=nums.length;i++){
//            for(int j=0;j<i;j++){
//              dp[i]=Math.max(dp[i], dp[i-1]+nums[j]);
//                }
//            }
//        return dp[nums.length];
//    }

        public static int maxSubArray(int[] nums) {
            int[] numsArray=nums;
            // Our helper function is designed to solve this problem for
            // any array - so just call it using the entire input!
            return findBestSubarray(0, numsArray.length - 1,numsArray);
        }

        private static int findBestSubarray(int left, int right, int[] numsArray) {
            // Base case - empty array.
            if (left > right) {
                return Integer.MIN_VALUE;
            }

            int mid = Math.floorDiv(left + right, 2);
            System.out.println("mid is"+mid);
            int curr = 0;
            int bestLeftSum = 0;
            int bestRightSum = 0;

            // Iterate from the middle to the beginning.
            for (int i = mid - 1; i >= left; i--) {
                curr += numsArray[i];
                bestLeftSum = Math.max(bestLeftSum, curr);
            }


            // Reset curr and iterate from the middle to the end.
            curr = 0;
            for (int i = mid + 1; i <= right; i++) {
                curr += numsArray[i];
                bestRightSum = Math.max(bestRightSum, curr);
            }

            // The bestCombinedSum uses the middle element and the best
            // possible sum from each half.
            int bestCombinedSum = numsArray[mid] + bestLeftSum + bestRightSum;
            System.out.println("Left is"+bestLeftSum);
            System.out.println("Right is"+bestRightSum);
            System.out.println("Combined is"+bestCombinedSum);

            // Find the best subarray possible from both halves.
            int leftHalf = findBestSubarray(left, mid - 1,numsArray);
            int rightHalf = findBestSubarray(mid + 1, right,numsArray);

            // The largest of the 3 is the answer for any given input array.
            return Math.max(bestCombinedSum, Math.max(leftHalf, rightHalf));
        }

    private static int findBestSubarrays(int[] nums) {
            int[] dp=new int[nums.length+1];
            Arrays.fill(dp,Integer.MIN_VALUE);
            dp[0]=0;
            for(int i=0;i<nums.length;i++){
                for(int j=i;j<nums.length;j++)
                }
            }

    }

    public static void main(String[] args){
        int[] nums={2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

}
