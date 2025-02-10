import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        s = s.substring(2, s.length() - 2);
        s = s.replaceAll("},\\{", "-");
        String[] nTuple = s.split("-");
        
        for (String tuple : nTuple) {
            String[] split = tuple.split(",");
            for (String s1 : split) {
                int num = Integer.parseInt(s1);
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
        }
        
        int[] answer = new int[map.size()];
        int length = answer.length;
        
        for (Integer i : map.keySet()) {
            int count = map.get(i);
            answer[length - count] = i;
        }
        
        return answer;
    }
}