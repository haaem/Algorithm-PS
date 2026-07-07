class Solution {
    public int solution(int n, int w, int num) {
        int row = (num - 1) / w;
        int idx = (num - 1) % w;
        int col = (row % 2 == 0) ? idx : (w - 1 - idx);
        
        int topRow = (n - 1) / w;
        int topCount = n - topRow * w;
        
        if (topRow % 2 == 0) {
            if (col < topCount) {
                return topRow - row + 1;
            }
            return topRow - row;
        } else {
            if (col >= w - topCount) {
                return topRow - row + 1;
            }
            return topRow - row;
        }
    }
}