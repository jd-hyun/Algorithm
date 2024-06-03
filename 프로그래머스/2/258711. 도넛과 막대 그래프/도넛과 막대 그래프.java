import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int n = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] edge : edges) {
            n = Math.max(n, Math.max(edge[0], edge[1]));

            if (map.containsKey(edge[1])) {
                map.put(edge[1], map.get(edge[1]) + 1);
            }

            if (!map.containsKey(edge[1])) {
                map.put(edge[1], 1);
            }
        }
        
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        int[] answer = new int[4];

         for (int i = 1; i <= n; i++) {
            if (graph.get(i).size() >= 2 && !map.containsKey(i)) {
                answer[0] = i;
            } else if (graph.get(i).size() == 0 && map.containsKey(i) && map.get(i) >= 1) {
                answer[2]++;
            } else if (graph.get(i).size() == 2 && map.containsKey(i) && map.get(i) >= 2) {
                answer[3]++;
            }
        }

        answer[1] = graph.get(answer[0]).size() - answer[2] - answer[3];

        return answer;
    }
}