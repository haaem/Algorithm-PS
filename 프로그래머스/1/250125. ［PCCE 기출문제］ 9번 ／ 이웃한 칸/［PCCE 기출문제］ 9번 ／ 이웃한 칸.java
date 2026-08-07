class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int answer = 0;
        
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        
        String color = board[h][w];
        for (int a = 0; a < 4; a++) {
            int h_check = h + dh[a];
            int w_check = w + dw[a];
                    
            if (h_check < 0 || h_check >= n || w_check < 0 || w_check >= n)
                continue;
                    
            if (!board[h_check][w_check].equals(color))
                continue;
            
            answer++;
        }
        
        return answer;
    }
}