class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for (int i = 1; i <= Math.sqrt(total); i++) {
            if (total % i == 0) {
                int row = i;
                int col = total / i;
                if ((row - 2) * (col - 2) == yellow)
                    return new int[] {col, row};
            }
        }
        return new int[] {-1, -1};
    }
}