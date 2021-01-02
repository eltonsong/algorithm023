// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/2/2021


// Definition for singly-linked list.
class Node {
    int val;
    Node next;
    Node prev;
    Node() {}
    Node(int val) { this.val = val; next = null; prev = null; }
}

//利用head, tail, next, prev，能够双向遍历整个链表

class MyCircularDeque {

    private Node head = new Node();
    private Node tail = new Node();
    private int size;
    private int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        capacity = k;
        size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == capacity) { // deque满时，返回错误
            return false;
        }
        if (size == 0) { // 当deque为空时直接插入，设置头和尾
            head = tail = new Node(value);
        } else { // 不为空时从前插入队列
            Node tmp = new Node(value);
            tmp.next = head;
            head.prev = tmp;
            head = tmp;
        }
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == capacity) { // deque满时返回错误
            return false;
        }
        if (size == 0) { // 当deque为空时直接插入，设置头和尾
            head = tail = new Node(value);
        } else { // 不为空时从前插入队尾
            Node tmp = new Node(value);
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
        }
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size == 0) { // deque 为空时无法删除，返回错误
            return false;
        }
        if(size == 1) { // 删除后为空，重置头和尾
            head = tail = null;
        } else { // 删除头，重新设置头
            Node newHead = head.next;
            head.next = null;
            head = null;
            head = newHead;
        }
        size--;
        return true;
    }


    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size == 0) { // deque 为空时无法删除，返回错误
            return false;
        }
        if(size == 1) { // 删除后为空，重置头和尾
            head = tail = null;
        } else { //删除尾，重新设置尾
            Node newTail = tail.prev;
            tail.prev = null;
            tail = null;
            tail = newTail;
        }
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (tail == null) {
            return -1;
        }
        return tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}


// Your MyCircularDeque object will be instantiated and called as such:
// MyCircularDeque obj = new MyCircularDeque(k);
// boolean param_1 = obj.insertFront(value);
// boolean param_2 = obj.insertLast(value);
// boolean param_3 = obj.deleteFront();
// boolean param_4 = obj.deleteLast();
// int param_5 = obj.getFront();
// int param_6 = obj.getRear();
// boolean param_7 = obj.isEmpty();
// boolean param_8 = obj.isFull();