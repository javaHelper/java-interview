package com.example.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Edge case: if input is null or empty, return empty list
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Map: sorted string -> list of original strings
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Step 1: Convert to char array and sort
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            // Step 2: Create the key from sorted chars
            String key = new String(charArray);

            // Step 3: Get or create the list for this key
            List<String> list = map.getOrDefault(key, new ArrayList<>());

            // Step 4: Add the original string to the list
            list.add(str);

            // Step 5: Put the updated list back into the map
            map.put(key, list);
        }

        // Step 6: Return all the grouped lists
        return new ArrayList<>(map.values());
    }
}
