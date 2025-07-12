package org.example;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public static ListNode buildList(List<Integer> nums){
         ListNode head = new ListNode(-1);

         ListNode now = head;
        for (Integer num:nums){
            ListNode tmp = new ListNode(num);
            now.next = tmp;
            now = tmp;
        }

        return head.next;
    }

    public static void showList(ListNode head){
        while(head != null){
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
        System.out.println("\n");
    }

    public static void main(String[] args){
        List<Integer> nums = new ArrayList<>();
        for (int i =0;i<5;i++){
            nums.add(i);
        }

        ListNode head = buildList(nums);
        showList(head);
    }

}


