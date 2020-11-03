
package LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    private class Node{
        private Node next;
        private int value;

        public Node(int value){
            this.value = value;
        }
    }

    public void addLast(int value){
        var node = new Node(value);

        if(isEmpty())
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int value){
        var node = new Node(value);

        if(isEmpty())
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException("Linked list is empty");

        removeIfSingleNode();

        var node = first;
        while(node != null){
            if(node.next == last){
                last = node;
                node.next = null;
                size--;
            }
            node = node.next;
        }
    }

    public void removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException("Linked list is empty");

        removeIfSingleNode();

        var node = first.next;
        first.next = null;
        first = node;
        size--;
    }

    private void removeIfSingleNode() {
        if(first == last){
            last = first = null;
            size--;
            return;
        }
    }

    public int getSize(){
        return size;
    }

    public int indexOf(int value){
        if(isEmpty())
            throw new NoSuchElementException(" "+value);
y
        var node = first;
        int index = 0;
        while(node != null){
            if(node.value == value)
                return index;

            node = node.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int value){
        return indexOf(value) != -1;
    }

    public void printLL(){
        if(isEmpty())
            System.out.println("Empty-list");

        var node = first;
        while(node != null){
            System.out.print(node.value+" - ");
            node = node.next;
        }
        System.out.println();
    }

    public int[] toArray(){
        if(isEmpty())
            throw new NoSuchElementException("Linked list is empty");

        int[] array = new int[size];
        var node = first;
        int index = 0;
        while(node != null){
            array[index] = node.value;
            node = node.next;
            index++;
        }
        return array;
    }

    public void reverseLinkedList(){
        if(isEmpty() || first == last)
            return;

        var previous = first;
        var current = first.next;
         while(current != null) {
             var temp = current.next;
             current.next = previous;
             previous = current;
             current = temp;
         }
        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromEnd(int K){
        if(isEmpty() || K < 1)
            return -1;

        if(first == last & K==1)
            return first.value;

        var pointer1 = first;
        var pointer2 = first;
        int index = 1;
        while(pointer2.next != null){

            if(index >= K){
                pointer1 = pointer1.next;
            }
            index +=1; //3 30

            pointer2 = pointer2.next;
        }
        if(K > index)
            return -1;

        return pointer1.value;

    }
}
