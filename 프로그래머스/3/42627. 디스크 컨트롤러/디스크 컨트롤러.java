import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> (o1[0] - o2[0]));
        int n = jobs.length;
        
        PriorityQueue<Job> pq = new PriorityQueue();
        
        int count = 0;
        int total = 0;
        int index = 0;
        int end = 0;
        
        while (count < n) {
            while (index < n && jobs[index][0] <= end) {
                pq.offer(new Job(index, jobs[index][0], jobs[index][1]));
                index++;
            }
            
            if (!pq.isEmpty()) {
                Job now = pq.poll();
                total += end + now.time - now.req;
                count++;
                end += now.time;
            } else {
                end++;
            }
        }
        
        return total / count;
    }
}

class Job implements Comparable<Job>{
    int num, req, time;
    
    Job(int num, int req, int time) {
        this.num = num;
        this.req = req;
        this.time = time;
    }
    
    @Override
    public int compareTo(Job o) {
        if (this.time != o.time)
            return this.time - o.time;
        if (this.req != o.req)
            return this.req - o.req;
        return this.num - o.num;
    }
}