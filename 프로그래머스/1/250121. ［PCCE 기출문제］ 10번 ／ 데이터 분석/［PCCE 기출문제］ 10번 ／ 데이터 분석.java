import java.util.*;

class Solution {
    private int extIndex;
    private int sortIndex;
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        extIndex = 0;
        sortIndex = 0;
        switch (ext) {
            case "date":
                extIndex = 1;
                break;
            case "maximum":
                extIndex = 2;
                break;
            case "remain":
                extIndex = 3;
                break;
        }
        switch (sort_by) {
            case "date":
                sortIndex = 1;
                break;
            case "maximum":
                sortIndex = 2;
                break;
            case "remain":
                sortIndex = 3;
                break;
        }
        int length = data.length;
        List<int[]> list = new ArrayList<>();
        
        for (int[] arr : data) {
            if (arr[extIndex] < val_ext) {
                list.add(arr);
            }
        }
        
        Collections.sort(list, (o1, o2) -> o1[sortIndex] - o2[sortIndex]);
        
        int[][] answer = new int[list.size()][4];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}