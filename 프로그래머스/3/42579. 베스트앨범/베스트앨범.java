import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, PriorityQueue<int[]>> map = new HashMap(); // 고유번호, 재생 횟수
        HashMap<String, Integer> count = new HashMap();
        int n = genres.length;
        for (int i = 0; i < n; i++) {
            String genre = genres[i];
            map.putIfAbsent(genre, new PriorityQueue<int[]>((a, b) -> {
                if (a[1] != b[1])
                    return b[1] - a[1];
                return a[0] - b[0];
            }));
            map.get(genre).offer(new int[] {i, plays[i]});
            count.putIfAbsent(genre, 0);
            count.put(genre, count.get(genre) + plays[i]);
        }
        List<String> order = new ArrayList(count.keySet());
        order.sort((a, b) -> count.get(b) - count.get(a));
        
        List<Integer> ans = new ArrayList();
        for (String s : order) {
            PriorityQueue<int[]> pq = map.get(s);
            int c = 0;
            while (!pq.isEmpty() && c < 2) {
                ans.add(pq.poll()[0]);
                c++;
            }
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}