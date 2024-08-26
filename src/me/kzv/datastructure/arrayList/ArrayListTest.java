package me.kzv.datastructure.arrayList;

import java.util.stream.IntStream;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> myArrayList = new ArrayList<>();

        IntStream.rangeClosed(1, 100).forEach(myArrayList::add);

        System.out.println(myArrayList.size());
        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.get(99));

        myArrayList.remove(0);
        System.out.println();

        System.out.println(myArrayList.size());
        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.get(99));
        System.out.println(myArrayList.get(98));
        System.out.println(myArrayList.get(97));
        int get96 = myArrayList.get(96);
        System.out.println(get96);

        boolean contains = myArrayList.contains(get96);
        System.out.println(contains);
        System.out.println(myArrayList.isEmpty());

        ArrayList<Integer>.Iterator it = myArrayList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
