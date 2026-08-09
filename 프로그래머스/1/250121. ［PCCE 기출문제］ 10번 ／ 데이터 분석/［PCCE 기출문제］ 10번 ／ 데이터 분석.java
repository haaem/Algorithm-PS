import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int ext_index = -1;
        switch (ext) {
            case "code":
                ext_index = 0;
                break;
            case "date":
                ext_index = 1;
                break;
            case "maximum":
                ext_index = 2;
                break;
            case "remain":
                ext_index = 3;
                break;
        }
        
        ArrayList<int[]> arr = new ArrayList();
        for (int i = 0; i < data.length; i++) {
            int[] now = data[i];
            if (now[ext_index] < val_ext) {
                arr.add(now);
            }
        }
        
        int sort = -1;
        switch (sort_by) {
            case "code":
                sort = 0;
                break;
            case "date":
                sort = 1;
                break;
            case "maximum":
                sort = 2;
                break;
            case "remain":
                sort = 3;
                break;
        }
        final int idx = sort;
        Collections.sort(arr, (a, b) -> a[idx] - b[idx]);
        
        int[][] answer = new int[arr.size()][];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}