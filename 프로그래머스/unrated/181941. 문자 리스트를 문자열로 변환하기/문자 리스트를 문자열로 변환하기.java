class Solution {
    public String solution(String[] arr) {
        String answer = "";
        int length = arr.length;
        
        for (int i = 0; i < length; i++) {
            answer += arr[i];
        }
        return answer;
    }
}