class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int friendsLength = friends.length;
        int[][] giftInformation = new int[friendsLength][friendsLength];
        int[][] indices = new int[friendsLength][2];
        
        int giftsLength = gifts.length;
        for (int i = 0; i < giftsLength; i++) {
            String[] split = gifts[i].split(" ");
            String give = split[0];
            String take = split[1];
            
            for (int row = 0; row < friendsLength; row++) {
                if (friends[row].equals(give)) {
                    indices[row][0]++;
                    for (int col = 0; col < friendsLength; col++) {
                        if (friends[col].equals(take)) {
                            indices[col][1]++;
                            giftInformation[row][col]++;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        
        for (int row = 0; row < friendsLength; row++) {
            int count = 0;
            for (int col = 0; col < friendsLength; col++) {
                if (giftInformation[row][col] > 0) {
                    if (giftInformation[row][col] > giftInformation[col][row]) {
                        count += 1;
                    }
                    else if (giftInformation[row][col] == giftInformation[col][row]) {
                        if ((indices[row][0] - indices[row][1]) > (indices[col][0] - indices[col][1])) {
                            count += 1;
                        } 
                    }
                }
                else if (giftInformation[row][col] == 0) {
                    if (giftInformation[col][row] == 0) {
                        if ((indices[row][0] - indices[row][1]) > (indices[col][0] - indices[col][1])) {
                            count += 1;
                        } 
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
}