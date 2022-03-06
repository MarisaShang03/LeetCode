package com.company;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    /*1.
    Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
    1)Sliding Window O(n); Brute Force(n^2)
     */
    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return maxSum;
    }

    //Brute Force
    public static int findMaxSumSubArrayBF(int k, int[] arr) {
        int maxSum = 0, windowSum;
        for (int i = 0; i <= arr.length - k; i++) {
            windowSum = 0;
            for (int j = i; j < i + k; j++) {
                windowSum += arr[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    /*2
    Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
     */
    //code is right
    public static int findMinSubArrayBF(int S, int[] arr) {
        int min = 0, length = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int j = i;
            while (j < arr.length && sum < S) {
                sum += arr[j];
                j++;
            }
            if (sum >= S) {
                length = j - i;
                if (min == 0) {
                    min = length;
                } else {
                    min = Math.min(min, length);
                }
            }
        }
        return min;
    }

    //sliding window
    public static int findMinSubArray(int S, int[] arr) {
        int start = 0, sum = 0, min = Integer.MAX_VALUE;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (sum >= S) {
                min = Math.min(min, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /*
    Given a string, find the length of the longest substring in it with no more than K distinct characters.
     */

    //        public static int findLength(String str, int k) {
//            String cur= "";
//            int start=0;
//           int numChar=0;  //num of distinct char
//            for(int end=0; end<str.length();end++){
//                char char1=str.charAt(end);
//                while(numChar<=k){
//                    cur=cur+char1;
//                    if(!cur.contains(char1))
//                        numChar++;
//                    }
//                }
//                if(!cur.contains(char1)){
//                    cur.add(char1);
//                }
//            }
//            return -1;
//        }
    /*Sliding Window using HashMap
     */
    public static int findLength1(String str, int k) {
        int start = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char rightChar = str.charAt(end);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(start);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }

    public static int findLength(String str, int k) {
        int start = 0, maxLength = 0;
        Map<Character, Integer> mapFreq = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char rightChar = str.charAt(end);
            mapFreq.put(rightChar, mapFreq.getOrDefault(rightChar, 0) + 1);
            while (mapFreq.size() > k) {
                char leftChar = str.charAt(start);
                mapFreq.put(leftChar, mapFreq.get(leftChar) - 1);
                if (mapFreq.get(leftChar) == 0) {
                    mapFreq.remove(leftChar);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static int findMinSubArray2(int S, int[] arr) {
        int start = 0, minLength = Integer.MAX_VALUE, sum = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += end;
            while (sum >= S) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= arr[start];
                start--;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static int findMaxSumSubArray2(int k, int[] arr) {
        int start = 0, sum = 0, maxsum = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            if (end - start + 1 >= k) {
                maxsum = Math.max(sum, maxsum);
                sum -= arr[start];
                start++;
            }
        }
        return maxsum;
    }

//    public int lengthOfLongestSubstring(String s) {
//        int length = 0, max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length(); j++) {
//                if(check(s,i,j)) max=Math.max(max, j-i+1);
//            }
//        }
//    }

    private boolean check(String s, int start, int end) {
        int[] chars=new int[128];
        for(int i=start; i<end; i++) {
            chars[s.charAt(i)]++;
            if (chars[s.charAt(i)] > 1) return false;
        }
        return true;
    }






    public static void main(String[] args) {
        int result = findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
//        result = findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
//        System.out.println("Smallest subarray length: " + result);
//        result = findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
//        System.out.println("Smallest subarray length: " + result);
    }
}
