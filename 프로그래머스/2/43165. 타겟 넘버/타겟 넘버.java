class Solution {
    int[] numbers;
    int t, answer;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        t = target;
        
        dfs(0, 0);
        
        return answer;
    }
    
    
    void dfs(int depth, int res) {
        if (depth == numbers.length) {
            if (res == t)
                answer++;
            return;
        }
        dfs(depth + 1, res + numbers[depth]);
        dfs(depth + 1, res - numbers[depth]);
    }
}