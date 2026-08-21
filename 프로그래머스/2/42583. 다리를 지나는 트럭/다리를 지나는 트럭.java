import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> q = new ArrayDeque(); // 시작 초, 무게
        int sum = 0;
        int index = 0;
        int n = truck_weights.length;
        int answer = 0; // 초
        
        while (true) {
            answer++;
            if (!q.isEmpty()) {
                int[] first = q.peek();
                if (answer - first[0] == bridge_length) {
                    sum -= first[1];
                    q.poll();
                }
            }
            
            if (q.isEmpty() && index == n)
                break;
            
            if (index < n) {
                if (q.size() < bridge_length && sum + truck_weights[index] <= weight) {
                    q.offer(new int[] {answer, truck_weights[index]});
                    sum += truck_weights[index++];
                }
            }
        }
        
        return answer;
    }
}