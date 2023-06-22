package me.kzv.datastructure.arrayList;

public class ArrayList<T> {
    private int capacity = 100;
    private Object[] arr = new Object[capacity];
    private int size = 0;

    void add(Object o) {
        if (this.size >= this.arr.length) {
            Object[] newArr = new Object[this.size * 2];
            System.arraycopy(this.arr, 0, newArr, 0, this.arr.length);
            this.arr = newArr;
        }
        arr[this.size] = o;
        this.size++;
    }

    void remove(int idx) {
        System.arraycopy(this.arr, idx + 1, this.arr, idx, this.arr.length - idx - 1);
        this.size--;
    }

    T get(int idx) {
        if (idx >= this.size) return null;
        return (T) this.arr[idx];
    }

    boolean contains(Object o) {
        for (Object el : arr) {
            if (el.equals(o)) return true;
        }
        return false;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    int size() {
        return this.size;
    }

    Iterator iterator() {
        return new Iterator();
    }

    class Iterator {
        private int nextIdx = 0;

        boolean hasNext(){
            return this.nextIdx < size;
        }

        T next(){
            T item = get(nextIdx);
            nextIdx++;
            return item;
        }
    }
}


