package ru.oopcourse.kaminskiy.singlylinkedlist;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private static int count;

    public  SinglyLinkedList(){}

    public  SinglyLinkedList(int count, ListItem<T> head){
        this.head = head;
        this.count = count;
    }

    class ListItem<T> {
        private T data;
        private ListItem<T> next;

        public ListItem( T data, ListItem<T> next){
            this.data = data;
            this.next = next;
        }

        public ListItem() {}

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public ListItem<T> getNext() {
            return next;
        }

        public void setNext(ListItem<T> next) {
            this.next = next;
        }

        public int size() {
            return count;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public T getFirstElementValue(){
            if(head == null){
                throw new NoSuchElementException();
            }
            ListItem tmp = head;

            return (T) tmp.data;
        }

        public T removeFirstElement(){
            T tmp = getFirstElementValue();
            head = head.next;

            return tmp;
        }

        public boolean removeNodeByValue(int index) {
            if (index < 1 || index > size()) {
                return false;
            }
            ListItem p = head;
            if (head != null) {
                for (int i = 0; i < index; i++) {
                    if (p.getNext() == null) {
                        return false;
                    }
                    p = p.getNext();
                }
                //p.setNext(p.getNext().getNext());
                count--;
                return true;
            }
            return false;
        }

        public void addElementInFirst( T data) {
            if(head == null) {
                head = new ListItem(data, null);
            }
          //  head = new ListItem<T>(data, head);
        }

        public void addElementByIndex( T data, int index) {
           // ListItem<T> tmp = new ListItem<T>(data, head);
            ListItem p = head;
            if (p != null) {
                for (int i = 0; i < index && p.getNext() != null; i++) {
                    p = p.getNext();
                }
            }
            //tmp.setNext(p.getNext());

           // p.setNext(tmp);

            count++;
        }

        public void addElementInLast( T data) {
            if(head == null){
                addElementInFirst(data);
            } else {
                ListItem tmp = head;
                while (tmp.next != null){
                    tmp = tmp.next;
                }
                tmp.next = new ListItem<T>(data, null);
            }

        }
    }
}