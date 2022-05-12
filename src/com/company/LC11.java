package com.company;

public class LC11 {
    //自己写的 正确的
//    public int maxArea(int[] height) {
//        int n=height.length;
//        int max=0;
//        for(int i=0;i<n;i++){
//            for(int j=i+1; j<n; j++){
//                int cur=(j-i)*Math.min(height[i], height[j]);
//                max=Math.max(max,cur);
//            }
//        }
//        return max;
//    }

    public int maxArea(int[] height){
        int l=0,h=height.length-1;
        int maxArea=-1;
        while(l<h){
            int area=(h-l) * Math.min(height[l], height[h]);
            maxArea=Math.max(maxArea,area);
            if(height[l]<=height[h]){
                l++;
            }else{
                h--;
            }
        }
        return maxArea;
    }



}
