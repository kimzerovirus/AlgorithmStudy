package me.kzv.datastructure.map;

import java.util.HashMap;

public class HashMapTest {
    // key - value
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // 1. put
        map.put("korea", 1);
        map.put("america", 2);
        map.put("japan", 3);

        System.out.println(map);

        // 2. remove
        map.remove("japan");
        System.out.println(map);

        // 3. get
        System.out.println(map.get("korea"));

        // 4. size
        System.out.println(map.size());

        // 5. contains
        System.out.println(map.containsKey("korea"));
        System.out.println(map.containsValue(1));

        // 6. keySet
        System.out.println(map.keySet());

        // 7. values
        System.out.println(map.values());

        // 8. forEach
        for (String s : map.keySet()) {
            System.out.println(s);
        }

    }
}
