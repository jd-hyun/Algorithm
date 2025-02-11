import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String name : participant) {
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }
        }
        
        for (String name : completion) {
            if (map.containsKey(name)) {
                map.put(name, map.get(name) - 1);
                if (map.get(name) == 0) {
                    map.remove(name);
                }
            }
        }
        
        String answer = "";
        Set<String> set = map.keySet();
        for (String name : set) {
            answer = name;
        }
        return answer;
    }
}