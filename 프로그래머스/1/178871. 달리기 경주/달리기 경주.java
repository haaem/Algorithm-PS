import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < players.length; i++) 
            map.put(players[i], i);
        
        for (String s : callings) {
            int ranking = map.get(s);
            
            String temp = players[ranking - 1];
            players[ranking - 1] = s;
            players[ranking] = temp;
            
            map.put(s, ranking - 1);
            map.put(temp, ranking);
        }

        return players;
    }
}