class Solution {
    public int[] solution(String[] wallpaper) {
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        
        int[] start = {n - 1, m - 1};
        int[] end = new int[2];
        
        for (int i = 0; i < n; i++) {
            String s = wallpaper[i];
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                if (c == '#') {
                    start[0] = Math.min(start[0], i);
                    start[1] = Math.min(start[1], j);
                    end[0] = Math.max(end[0], i + 1);
                    end[1] = Math.max(end[1], j + 1);
                }
            }
        }
        
        int[] answer = {start[0], start[1], end[0], end[1]};
        return answer;
    }
}