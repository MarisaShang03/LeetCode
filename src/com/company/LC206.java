package com.company;

public class LC206 {
    //自己写的
//    public ListNode reverseList(ListNode head) {
//        int n=0;
//        while(head.hasNext()){
//            n++;
//            head=head.next();
//        }
//        int[] rev= new int[n];
//        int j=0
//        for(int i=n;i>=0; i++){
//        }
//    }


    //code正确
//    public ListNode reverseList(ListNode head) {
//        ListNode prev=null;
//        ListNode cur =head
//        ListNode next=null;

         //可以用cur循环, 也可以直接用head
//        while(cur!=null){
//            next=cur.next;
//            cur.next=prev;
//            //下两行顺序要注意
//            prev=cur;
//            cur=temp;
//        }
//        return prev;
//    }

}
