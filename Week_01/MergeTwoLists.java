// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/2/2021

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

//两种方法
//1. 递归
//2. 迭代

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //     递归
        //     if (l1 == null) {
        //         return l2;
        //     } else if (l2 == null) {
        //         return l1;
        //     } else if (l1.val < l2.val) {
        //         l1.next = mergeTwoLists(l1.next, l2);
        //         return l1;
        //     } else {
        //         l2.next = mergeTwoLists(l1, l2.next);
        //         return l2;
        //     }
        // }

        //     迭代
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2. val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1; //当有一串链表为空时跳出循环，接到另一串链表
        return head.next;
    }
}
