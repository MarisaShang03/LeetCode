package com.company;

import java.util.HashMap;
import java.util.Stack;

public class LC20 {
    //自己写的版本 不对
    public boolean isValid2(String s) {
        int n = s.length();
        int i = 0;
        boolean valid = false;
        while (i < s.length()) {
            valid = false;
            for (int j = i + i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    i = j + 1;
                    valid = true;
                    continue;
                }
            }
            if (!valid) return false;
        }
        return valid;
    }

    //Stack唯一解法
    private static HashMap<Character, Character> map = new HashMap<>();

    public LC20() {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (map.isEmpty()) {
                    return false;
                }
                if (stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //stack 也可以写成 map pair 是反过来']','['
    public boolean isValid2(String s, HashMap map) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println(isValid("}}") );
    }

}
