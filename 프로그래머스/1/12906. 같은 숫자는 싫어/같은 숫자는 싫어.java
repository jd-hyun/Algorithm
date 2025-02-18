import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        int length = arr.length;
        
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else {
                if (stack.peek() != arr[i]) {
                    stack.push(arr[i]);
                }
            }
        }
        
        int[] answer = new int[stack.size()];
        
        while (!stack.isEmpty()) {
            int num = stack.pop();
            answer[stack.size()] = num;
        }

        return answer;
    }
}