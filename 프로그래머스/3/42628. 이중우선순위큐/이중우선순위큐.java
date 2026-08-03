import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap();
        StringTokenizer st;
        
        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            
            switch (st.nextToken()) {
                case "I": {
                    int num = Integer.parseInt(st.nextToken());
                    map.putIfAbsent(num, 0);
                    map.put(num, map.get(num) + 1);
                    break;
                }
                case "D": {
                    int num = Integer.parseInt(st.nextToken());
                    if (map.isEmpty())
                        continue;
                    
                    int key, size;
                    if (num == 1) {
                        key = map.floorKey(Integer.MAX_VALUE);
                        size = map.get(key);
                    } else {
                        key = map.ceilingKey(Integer.MIN_VALUE);
                        size = map.get(key);
                    }
                    
                    if (size > 1) 
                        map.put(key, size - 1);
                    else 
                        map.remove(key);
                    break;
                }
            }
        }
        
        if (map.isEmpty()) {
            return new int[] {0, 0};
        } else {
            int min = map.ceilingKey(Integer.MIN_VALUE);
            int max = map.floorKey(Integer.MAX_VALUE);
            return new int[] {max, min};
        }
    }
}