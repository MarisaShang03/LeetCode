package com.company;

import java.util.HashSet;

public class LC141 {
   

    //自己思路 应该不对
//    public boolean hasCycle(ListNode head) {
//        for(int i=0; i<head.size()){
//            ListNode temp=head;
//            while(temp!=null){
//                if(temp.next=head){
//                    return true;
//                }
//                temp=temp.next;
//            }
//        }
//        return false;
//    }


    //using hashset code正确
//    public boolean hasCycle(ListNode head) {
//        HashSet<ListNode> visited=new HashSet<>();
//        ListNode temp=head;
//        while(temp!=null){
//            if(visited.contains(temp)) return true;
//            visited.add(temp);
//            temp=temp.next;
//        }
//        return false;
//    }
    //还有另外一种解 Floyd's cyle
}
