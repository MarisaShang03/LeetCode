package com.company;

public class LC53_2 {
    //        public int maxSubArray(int[] nums) {
//         int current=nums[0], max=nums[0];
//         for(int i=1;i<nums.length;i++){
//             if(current+nums[i]>nums[i]){
//                 current+=nums[i];
//             }else{
//              current=nums[i];
//             }
//             max=Math.max(max,current);

//         }
//         return max;
//     }

    //这个按照解释2的是错的
//    public int maxSubArray(int[] nums) {
//        int current=nums[0], max=nums[0];
//        for(int i=1;i<nums.length;i++){
//            if(current+nums[i]>0){
//                current+=nums[i];
//            }else{
//                current=nums[i];
//            }
//            max=Math.max(max,current);
//        }
//        return max;
//    }
}
