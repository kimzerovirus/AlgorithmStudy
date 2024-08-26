package me.kzv.datastructure.set;

import java.util.HashSet;

public class HashSetTest {
    /**
     * 저장된 값을 index 로 관리하지 않음
     * 값을 넣는 순서와 상관없이 저장됨
     * 세트 안에 이미 존재하는 값이면 저장되지 않음 (중복 허용x)
     */
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        // 1. add
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println(set);

        // 2. remove
        set.remove(3);
        System.out.println(set);

        // 3. size
        System.out.println(set.size());

        // 4. contains
        System.out.println(set.contains(1));

        // 5. forEach
        for (Integer s : set) {
            System.out.println(s);
        }
    }
}
