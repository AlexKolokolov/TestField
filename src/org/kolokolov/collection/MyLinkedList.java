package org.kolokolov.collection;

public class MyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;
    
    public boolean add(E element) {
        Node<E> newNode = new Node<>(last, null, element);
        if (last != null) {
            last.next = newNode;
        }
        last = newNode;
        if (first == null) {
            first = newNode;
        }
        size++;
        return true;
    }
    
    public boolean add(int n, E element) {
        checkIndex(n);
        if (n == 0) {
            addFirst(element);
        } else {
            Node<E> nNode = getNode(n);
            Node<E> newNode = new Node<>(nNode.prev, nNode, element);
            newNode.prev.next = newNode;
            nNode.prev = newNode;
            size++;
        }
        return true;
    }
    
    public boolean addFirst(E element) {
        Node<E> newNode = new Node<>(null, first, element);
        first.prev = newNode;
        first = newNode;
        size++;
        return true;
    }
    
    public E get(int n) {
        checkIndex(n);
        return getNode(n).value;
    }
    
    private Node<E> getNode(int n) {
        Node<E> node = null;
        if (n <= size / 2) {
            node = first;
            while (n > 0) {
                node = node.next;
                n--;
            }
        } else {
            node = last;
            while (n < size - 1) {
                node = node.prev;
                n++;
            }
        }
        return node;
    }
    
    private void checkIndex(int n) {
        if (n < 0 || n >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if (size != 0) {
            Node<E> node = first;
            result.append(node.value);
            do {
                if (node != last) {
                    result.append(", ");
                }
                node = node.next;
                result.append(node.value);
            } while (node != last);
        }
        return result.append("]").toString();
    }
    
    public int size() {
        return this.size;
    }
    
    
    private static class Node<E> {
        private Node<E> prev;
        private Node<E> next;
        private E value;
        
        private Node(Node<E> prev, Node<E> next, E value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
    
    public static void main(String[] args) {
        MyLinkedList<String> strings = new MyLinkedList<>();
        
        strings.add("aaa");
        strings.add("bbb");
        strings.add("ccc");
        strings.add("ddd");
        strings.add("eee");
        strings.add("fff");
        strings.add("ggg");
        
        System.out.println(strings.size());
        
        System.out.println(strings);
        
        System.out.println(strings.get(1));
        System.out.println(strings.get(6));
        
        strings.add(3, "WWW");
        
        System.out.println(strings);
        
        strings.add(7, "WWW");
        strings.add(0, "WWW");
        
        System.out.println(strings);
        
        strings.addFirst("new first element");
        
        System.out.println(strings);
    }

}
