class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int play = strToInt(play_time);
        int adv = strToInt(adv_time);
        
        long[] sum = new long[play + 1];
        for (String log : logs) {
            String[] s = log.split("-");
            int start = strToInt(s[0]);
            int end = strToInt(s[1]);
            
            sum[start] += 1;
            sum[end] -= 1; 
        }
        
        // 버킷 풀기
        for (int i = 1; i < sum.length; i++) 
            sum[i] += sum[i - 1];
        
        // 누적합
        for (int i = 1; i < sum.length; i++) 
            sum[i] += sum[i - 1];
        
        long max = sum[adv];
        int s = 0;
        for (int i = 1; i < sum.length - adv; i++) {
            long temp = sum[i + adv - 1] - sum[i - 1];
            if (temp > max) {
                max = temp;
                s = i;
            }
        }
        
        return longToString(s);
    }
    
    int strToInt(String time) {
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 3600 + Integer.parseInt(s[1]) * 60 + Integer.parseInt(s[2]);
    }
    
    String longToString(long time) {
        long sec = time % 60;
        time /= 60;
        long min = time % 60;
        long hour = time / 60;
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
}