import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int n = answers.length;
        
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] count = new int[3];
        for (int i = 0; i < n; i++) {
            if (answers[i] == a1[i % 5])
                count[0]++;
            if (answers[i] == a2[i % 8])
                count[1]++;
            if (answers[i] == a3[i % 10])
                count[2]++;
        }
        
        int max = 0;
        for (int a : count) {
            max = Math.max(a, max);
        }
        
        ArrayList<Integer> arr = new ArrayList();
        for (int i = 0; i < 3; i++) {
            if (count[i] == max)
                arr.add(i + 1);
        }
        
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}