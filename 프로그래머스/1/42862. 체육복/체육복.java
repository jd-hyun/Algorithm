import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> set = new HashSet<>();
        
        for (int i : reserve) {
            set.add(i);
        }
        
        int answer = n - lost.length;
        List<Integer> list = new ArrayList<>();
        
        for (int i : lost) {
            if (set.contains(i)) {
                answer++;
                set.remove(i);
            } else {
                list.add(i);
            }
        }
        
        Collections.sort(list);
        
        for (Integer i : list) {
            if (set.isEmpty()) {
                break;
            }
    
            if (set.contains(i - 1)) {
                answer++;
                set.remove(i - 1);
            } else if (set.contains(i + 1)) {
                answer++;
                set.remove(i + 1);
            }
        }
        
        return answer;
    }
}