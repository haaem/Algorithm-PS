import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] up = new int[n];
        int[] down = new int[n];
        
        for (int i = 0; i < n; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        down[n - 1] = -1;
        Stack<Integer> deleted = new Stack();
        boolean[] removed = new boolean[n];
        
        for (int i = 0; i < cmd.length; i++) {
            String[] now =  cmd[i].split(" ");
            switch (now[0]) {
                case "U": {
                    int X = Integer.parseInt(now[1]);
                    while (X-- > 0)
                        k = up[k];
                    break;
                }
                case "D": {
                    int X = Integer.parseInt(now[1]);
                    while (X-- > 0)
                        k = down[k];
                    break;
                }
                case "C" : {
                    deleted.push(k);
                    removed[k] = true;
                    int u = up[k];
                    int d = down[k];
                    if (u != -1) down[u] = d;
                    if (d != -1) up[d] = u;
                    k = (d == -1) ? u : d;
                    break;
                }
                case "Z": {
                    int x = deleted.pop();
                    removed[x] = false;
                    int u = up[x];
                    int d = down[x];
                    if (u != -1) down[u] = x;
                    if (d != -1) up[d] = x;
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();            
        for (int i = 0; i < n; i++) {
            if (removed[i])
                sb.append("X");
            else
                sb.append("O");
        }
        return sb.toString();
    }
}