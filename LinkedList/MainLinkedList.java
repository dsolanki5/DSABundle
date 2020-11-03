package LinkedList;

import java.util.Arrays;

public class MainLL {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addFirst(40);
        //ll.addFirst(100);

        System.out.println(ll.indexOf(40));
        System.out.println(ll.contains(10));
//        ll.printLL();
        ll.removeFirst();
//        ll.removeLast();
//        ll.removeFirst();
        ll.removeLast();
        ll.printLL();
        System.out.println("\nSize: "+ll.getSize());

        int[] llArray = ll.toArray();
        System.out.println("Array:\n"+ Arrays.toString(llArray));
        ll.reverseLinkedList();
        ll.printLL();

        System.out.println("Get kth node: "+ll.getKthFromEnd(3));

    }
}
