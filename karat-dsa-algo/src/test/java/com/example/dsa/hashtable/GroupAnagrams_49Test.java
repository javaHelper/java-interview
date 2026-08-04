package com.example.dsa.hashtable;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupAnagrams_49Test {
    GroupAnagrams_49 sol = new GroupAnagrams_49();

    @Test
    void GroupAnagrams1(){
        List<List<String>> lists = sol.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        List<List<String>> expected = List.of(
                List.of("eat", "tea", "ate"),
                List.of("bat"),
                List.of("tan", "nat")
        );

        assertThat(lists).isNotEmpty()
                .containsExactlyInAnyOrderElementsOf(expected);
    }
}
