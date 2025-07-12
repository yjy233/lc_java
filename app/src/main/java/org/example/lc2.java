package org.example;

import java.util.ArrayList;
import java.util.List;

public class lc2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;

        int jin = 0;
        while(l1 != null || l2 != null){
            if (l1 == null) {
                l1 = l2;
                l2 = null;
                continue;
            }

            int he = l1.val;
            //l1 = l1.next;
            he += jin;
            if (l2 != null){
                he += l2.val;
                l2 = l2.next;
            }

            l1.val = (he%10);
            jin = he/10;

            tmp.next = l1;
            tmp = l1;
            l1= l1.next;
            tmp.next = null;
        }

        if (jin >0 ){
            tmp.next = new ListNode(1);
            tmp.next.next = null;
        }

        return head.next;
    };

    public static void main(String[] args){
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(9);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(1);

        ListNode l3 = addTwoNumbers(ListNode.buildList(l1),ListNode.buildList(l2));
        ListNode.showList(l3);

    }
}
