package com.example.geeksforgeeks.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerOfAnElection {

    public List<String> winner(List<String> arr) {
        String winner = "";
        int maxVotes = 0;

        Map<String, Integer> map = new HashMap<>();
        for (String candidate : arr) {
            int votes = map.getOrDefault(candidate, 0) + 1;
            map.put(candidate, votes);

            if (votes > maxVotes) {
                maxVotes = votes;
                winner = candidate;
            } else if (votes == maxVotes && candidate.compareTo(winner) < 0) {
                winner = candidate;
            }
        }
        return Arrays.asList(winner, String.valueOf(maxVotes));
    }

    static void main() {
        WinnerOfAnElection sol = new WinnerOfAnElection();
        System.out.println(sol.winner(
                Arrays.asList("john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john")));
    }
}
