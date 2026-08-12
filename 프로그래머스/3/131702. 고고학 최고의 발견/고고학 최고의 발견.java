class Solution {
    int[][] map;
    int n;
    int[] dy = {0, -1, 1, 0, 0};
    int[] dx = {0, 0, 0, -1, 1};
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] clockHands) {
        n = clockHands.length;
        restore(clockHands);
        dfs(0, 0);
        return answer;
    }
    
    void dfs(int index, int count) {
        if (index == n) {
            next(count);
            return;
        }
        
        // 0, 1, 2, 3번 돌리기
        for (int i = 0; i < 4; i++) {
            // 실제로 돌리기
            turn(0, index, i);
            
            // 다음 index
            dfs(index + 1, count + i);
            
            // 복구
            turn(0, index, (4 - i) % 4);
        }
    }
    
    void next(int count) {
        int[][] backup = new int[n][n];
        for (int i = 0; i < n; i++) 
            backup[i] = map[i].clone();
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int t = (4 - map[i - 1][j]) % 4;
                turn(i, j, t);
                count += t;
            }
        }
        
        if (check())
            answer = Math.min(answer, count);
        restore(backup);
    }
    
    boolean check() {
        for (int i = 0; i < n; i++) {
            if (map[n - 1][i] != 0)
                return false;
        }
        return true;
    }
    
    void turn(int y, int x, int c) {
        for (int a = 0; a < 5; a++) {
            int ny = y + dy[a];
            int nx = x + dx[a];
            
            if (ny < 0 || nx < 0 || ny >= n || nx >= n)
                continue;
            
            map[ny][nx] = (map[ny][nx] + c) % 4;
        }
    }
    
    void restore(int[][] arr) {
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = arr[i].clone();
        }
    }
}