package com.example.tree.treefundamentals;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DestinationCity_1436 {
    public String destCity(List<List<String>> paths) {
        Set<String> sources = paths.stream()
                .map(path -> path.get(0))
                .collect(Collectors.toSet());

        return paths.stream()
                .map(path -> path.get(1))
                .filter(dest -> !sources.contains(dest))
                .findFirst()
                .orElse("");
    }

    public static void main(String[] args) {
        DestinationCity_1436 x = new DestinationCity_1436();
        System.out.println(x.destCity(List.of(
                List.of("London", "New York"),
                List.of("New York", "Lima"),
                List.of("Lima", "Sao Paulo")
        )));

        System.out.println(x.destCity(List.of(
                List.of("B","C"),
                List.of("D","B"),
                List.of("C","A")
        )));

        System.out.println(x.destCity(List.of(
                List.of("A","Z")
        )));
    }
}
