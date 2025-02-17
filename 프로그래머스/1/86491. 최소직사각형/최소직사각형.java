class Solution {
    public int solution(int[][] sizes) {
        int maxWeight = sizes[0][0];
        int maxHeight = sizes[0][1];
        
        for (int i = 1; i < sizes.length; i++) {
            int sum1 = Math.max(maxWeight, sizes[i][0]) + Math.max(maxHeight, sizes[i][1]);
            int sum2 = Math.max(maxWeight, sizes[i][1]) + Math.max(maxHeight, sizes[i][0]);
            
            if (sum1 > sum2) {
                maxWeight = Math.max(maxWeight, sizes[i][1]);
                maxHeight = Math.max(maxHeight, sizes[i][0]);
            } else {
                maxWeight = Math.max(maxWeight, sizes[i][0]);
                maxHeight = Math.max(maxHeight, sizes[i][1]);
            }
        }
        
        int answer = maxWeight * maxHeight;
        return answer;
    }
}