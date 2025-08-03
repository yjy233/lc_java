package org.example;

import java.util.Arrays;
import java.util.List;


public class Lc61 {
    public static ListNode rotateRight(ListNode head, int k) {
        int l = 0;
        ListNode tmp = head;
        while(tmp != null){
            l++;
            tmp = tmp.next;
        }

        k = k%l;
        if (k == 0) return head;

        ListNode quick = head;
        ListNode slow = head;
        while(k > 0){
            quick = quick.next;
            k--;
        }

        while(quick.next!=null) {
            quick = quick.next;
            slow = slow.next;
        }

        ListNode res = slow.next;
        slow.next = null;
        tmp = res;
        while(tmp.next != null){
            tmp = tmp.next;
        }

        tmp.next = head;


        return res;
    }

    public static void main(String[] args){
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        ListNode head = ListNode.buildList(nums);

        ListNode.showList(rotateRight(head,3));


    }
}
