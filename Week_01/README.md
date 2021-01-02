学习笔记

第一周的学习我受益良多。除去知识本身令我感触最深的一定是超哥教给我们的学习方法。
虽然我现在还在学校中，但我深感平时在课堂中学过一遍的知识或者是写过一遍的作业现在都很难回想起来。
这就算是踩到了超哥说的误区"做题只做一遍"吧。希望通过这十周系统的学习训练能够让我对从学习方法到
知识体系都进行全面的升级。

另外附上两句超哥讲的令我印象深刻的话：
程序最终都可以用if-else, for-loop以及递归写出来
算法的本质就是升维，以及空间换时间

**用"addLast"这一套API改写Deque**
        
        public static void main(String[] args) {
             Deque<Integer> deque = new LinkedList<>();
             deque.addFirst(1);
             deque.addLast(2);
             deque.offerLast(3);
             
             System.out.println(deque.getFirst());
             System.out.println(deque.toString());
             System.out.println(deque);
        
             while (deque.size() > 0) {
                  System.out.println(deque.removeFirst());
             }
             System.out.println(deque);
        }
 

**Queue 与 Priority Queue 源码分析**

**1. Queue**

Queue 的主要实现：

1.加入

boolean add(E e); //throw exception

boolean offer(E e); //return false

2.移除：

E remove(); //throw exception

E poll(); //return false

3.返回头元素：

E element(); //throw exception

E peek(); //return false

**2.Priority Queue**

Priority Queue 顾名思义是在Queue的基础上构建的可以依次输出最高级元素的数据结构，
所以本质上与上文Queue所进行的三种实现六个方法相似。只是它引进了一个相对复杂的结构，堆。
由于堆的结构远比Queue复杂，所以在这里的源码使用了大量的自顶向下的编程思路，
将复杂结构的构建放在下方，前面的方法比如"add" "offer"等都具有跟Queue的源码相似的结构。
在这些方法中再调用下方建立的与堆相联系的子方法，以及为了遍历堆而建立的一个iterator class。

这里比较能体现堆在Priority里的应用的方法我认为是removeAt，
在前面跟remove相关的方法也调用了这里。代码如下

           assert i >= 0 && i < size;
           modCount++;
           int s = --size;
           if (s == i) // removed last element
               queue[i] = null;
           else {
               E moved = (E) queue[s];
               queue[s] = null;
               siftDown(i, moved);
               if (queue[i] == moved) {
                   siftUp(i, moved);
                   if (queue[i] != moved)
                       return moved;
               }
           }
           return null;
      

这里可以看到在Priority Queue里删除一个元素就不仅仅是从头或者尾删去一个元素，而是会关联到整个数据结构，
这是由于在堆的结构中一定要保证子节点大于父节点（才能以logn的时间输出最大值）
每删除一个非队尾的元素时，就要调用siftDown, siftUp两个方法来重新调整一些元素在堆中的位置。
具体过程在CSDN博客中很多篇图解里都有很清晰的讲解。本人由于对堆的理解并没有很深刻，暂时只能分析到这里。