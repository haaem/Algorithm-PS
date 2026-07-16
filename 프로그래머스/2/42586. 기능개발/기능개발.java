import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int day = 1;
        Queue<int[]> q = new ArrayDeque();
        
        for (int i = 0; i < progresses.length; i++) {
            q.offer(new int[] {progresses[i], speeds[i]});
        }
        
        ArrayList<Integer> arr = new ArrayList();
        int count = 0;
        
        while (!q.isEmpty()) {
            int[] now = q.peek();
            if (now[0] + day * now[1] < 100) {
                day++;
                if (count > 0) {
                    arr.add(count);
                    count = 0;
                }
            } else {
                q.poll();
                count++;
            }
        }
        arr.add(count);
        
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}