package org.kolokolov.collection;

public class MyArrayList<E> {
    private Object[] data = new Object[4];
    
    private int size;
    
    public boolean add(E e) {
        ensureCapasity();
        data[size++] = e;
        return true;
    }
    
    public boolean add(int n, E e) {
        ensureCapasity();
        int shiftRange = size - n;
        System.arraycopy(data, n, data, n + 1, shiftRange);
        data[n] = e;
        size++;
        return true;
    }
    
    private void ensureCapasity() {
        int dataLength = data.length;
        if (size + 1 > dataLength) {
            System.out.println("Array size " + dataLength + " is not enough. Increasing array size.");
            Object[] temp = new Object[dataLength * 2];
            System.arraycopy(data, 0, temp, 0, size);
            data = temp;
        }
    }
    
    public int size() {
        return this.size;
    }
    
    @SuppressWarnings("unchecked")
    public E get(int n) {
        checkBounds(n);
        return (E) data[n];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) result.append(", ");
            else result.append("]");
        }
        return result.toString();
    }
    
    public boolean remove(int n) {
        checkBounds(n);
        int shiftRange = size - n - 1;
        System.arraycopy(data, n + 1, data, n, shiftRange);
        size--;
        return true;
    }
    
    private void checkBounds(int n) {
        if (n < 0 || n > size - 1) throw new IndexOutOfBoundsException();
    }

    public static void main(String[] args) {
        MyArrayList<String> strings = new MyArrayList<>();
        System.out.println(strings.size());
        strings.add("Mercury");
        System.out.println(strings);
        System.out.println(strings.size());
        strings.add("Venus");
        strings.add("Earth");
        strings.add("Mars");
        strings.add("Jupiter");
        System.out.println(strings.size());
        
        System.out.println(strings);
        
        strings.remove(3);
        
        System.out.println(strings);
        strings.add("Saturn");
        strings.add("Uranus");
        strings.add("Neptune");
        
        System.out.println(strings);
        
        strings.add(3, "Mars");
        
        System.out.println(strings);
        
        strings.add(0, "Sun");
        
        System.out.println(strings);
        
    }
}
