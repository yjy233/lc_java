package org.example;

public class Lc19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode quick = head;
        ListNode slow = head;
        ListNode res = head;
        int tmpN = n;

        int l = 0;

        while(quick != null) {
            quick = quick.next;
            l++;
        }
        quick = head;

        while(n>0){
            if (quick == null) return head;
            quick = quick.next;
            n--;
        }

        while(quick != null) {
            quick = quick.next;
            if (quick == null) break;
            slow = slow.next;
        }

        if (slow == res) {
            if (l == 1) {
                return null;
            }

            if (l == tmpN) return res.next;
        }

        System.out.println(slow.val);
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return res;
    }

}
