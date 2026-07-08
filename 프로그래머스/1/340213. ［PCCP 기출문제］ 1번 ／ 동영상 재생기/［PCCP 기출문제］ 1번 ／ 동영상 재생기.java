class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int total_len = Integer.parseInt(video_len.substring(0, 2)) * 60 + Integer.parseInt(video_len.substring(3));
        int now = Integer.parseInt(pos.substring(0, 2)) * 60 + Integer.parseInt(pos.substring(3));
        int op_s = Integer.parseInt(op_start.substring(0, 2)) * 60 + Integer.parseInt(op_start.substring(3));
        int op_e = Integer.parseInt(op_end.substring(0, 2)) * 60 + Integer.parseInt(op_end.substring(3));
        
        if (now >= op_s && now <= op_e)
            now = op_e;
        
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "prev" : {
                    now -= 10;
                    if (now < 0)
                        now = 0;
                    break;
                }
                case "next" : {
                    now += 10;
                    if (now > total_len)
                        now = total_len;
                    break;
                }
            }
            if (now >= op_s && now <= op_e)
                now = op_e;
        }
        
        String answer = String.format("%02d:%02d", now / 60, now % 60);
        
        return answer;
    }
}