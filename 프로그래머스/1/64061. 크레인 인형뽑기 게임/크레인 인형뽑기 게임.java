import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int length = board.length;
        List<Stack<Integer>> stacks = new ArrayList<>(length);
        
        for (int i = 0; i < length; i++) {
            stacks.add(new Stack<>());
        }
        
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                if (board[j][i] == 0) break;
                stacks.get(i).push(board[j][i]);
            }
        }
        
        for (int i : moves) {
            if (!stacks.get(i - 1).isEmpty()) {
                int doll = stacks.get(i - 1).pop();
                
                if (!stack.isEmpty()) {
                    if (stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(doll);
                    }
                } else {
                    stack.push(doll);
                }
            }
        }
        return answer;
    }
}