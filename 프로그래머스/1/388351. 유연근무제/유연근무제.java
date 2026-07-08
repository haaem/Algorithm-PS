class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        loop: for (int i = 0; i < schedules.length; i++) {
            int schehour = schedules[i] / 100;
            int schemin = schedules[i] % 100;
            
            for (int j = 0; j < 7; j++) {
                if ((startday + j) % 7 == 6 || (startday + j) % 7 == 0)
                    continue;
                
                int timehour = timelogs[i][j] / 100;
                int timemin = timelogs[i][j] % 100;
                
                if (schehour + 1 == timehour && schemin >= 50 && (schemin + 10) % 60 >= timemin)
                    continue;
                
                if (schedules[i] + 10 < timelogs[i][j])
                    continue loop;
            }
            answer++;
        }
        return answer;
    }
}