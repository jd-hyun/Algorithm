import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        List<Map<String, Boolean>> list = new ArrayList<>(20);
        
        for (int i = 0; i < 20; i++) {
            list.add(new HashMap<>());
        }
        
        for (String phone : phone_book) {
            list.get(phone.length() - 1).put(phone, true);
        }
    
        boolean answer = true;
        
        for (int i = 1; i < 20; i++) {
            Map<String, Boolean> map = list.get(i);
            
            if (!map.isEmpty()) {
                for (String phone : map.keySet()) {
                    for (int j = 0; j < i; j++) {
                        if (list.get(j).containsKey(phone.substring(0, j + 1))) {
                            answer = false;
                            break;
                        }
                    }
                    
                    if (!answer) break;
                }
            }
            
            if (!answer) break;
        }
        return answer;
    }
}