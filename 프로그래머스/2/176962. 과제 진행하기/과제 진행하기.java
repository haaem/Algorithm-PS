import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];
        
        PriorityQueue<Task> pq = new PriorityQueue();
        Stack<Task> s = new Stack();
        for (int i = 0; i < n; i++)
            pq.offer(new Task(plans[i][0], changeTime(plans[i][1]), Integer.parseInt(plans[i][2])));
        
        Task now = pq.poll();
        int index = 0;
        
        while (!pq.isEmpty()) {
            Task next = pq.poll();
            
            if (next.startTime - now.startTime < now.playTime)
                s.push(new Task(now.name, now.playTime - (next.startTime - now.startTime)));
            else {
                answer[index++] = now.name;
                int left = next.startTime - now.startTime - now.playTime;
                while (left > 0 && !s.isEmpty()) {
                    Task t = s.pop();
                    if (t.playTime <= left) {
                        answer[index++] = t.name;
                        left -= t.playTime;
                    } else {
                        s.push(new Task(t.name, t.playTime - left));
                        left = 0;
                    }
                }
            }
            
            now = next;
        }
        
        answer[index++] = now.name;
        while (!s.isEmpty())
            answer[index++] = s.pop().name;
        
        return answer;
    }
    
    int changeTime(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}

class Task implements Comparable<Task> {
    String name;
    int startTime, playTime;
    
    Task(String name, int startTime, int playTime) {
        this.name = name;
        this.startTime = startTime;
        this.playTime = playTime;
    }
    
    Task(String name, int playTime) {
        this.name = name;
        this.playTime = playTime;
    }
    
    @Override
    public int compareTo(Task o) {
        return this.startTime - o.startTime;
    }
}