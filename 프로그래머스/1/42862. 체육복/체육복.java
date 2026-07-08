import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < reserve.length; i++) {
            set.add(reserve[i]);
        }
        
        int c = 0;
        int size = lost.length;
        
        HashSet<Integer> lostSet = new HashSet();
        
        for (int l : lost) {
            if (set.contains(l)) {
                set.remove(l);
                c++;
            } else {
                lostSet.add(l);
            }
        }
        
        for (int l : lostSet) {
            if (set.contains(l - 1)) {
                set.remove(l - 1);
                c++;
            } else if (set.contains(l + 1)) {
                set.remove(l + 1);
                c++;
            }
        }
        
        return n - size + c;
    }
}