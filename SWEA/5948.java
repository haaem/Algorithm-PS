import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
 
public class Solution {
    static int[] input;
    static HashSet<Integer> sum;
 
    public static void main(String args[]) throws Exception {
 
        // System.setIn(new FileInputStream("res/input.txt"));
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            input = new int[7];
            for (int i = 0; i < 7; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            sum = new HashSet<>();
            dfs(0, 0, new int[3]);
//          for (int a : sum) {
//              System.out.print(a + " ");
//          }
//          System.out.println();
            Integer[] temp = sum.toArray(new Integer[0]);
            Arrays.sort(temp, Collections.reverseOrder());
            System.out.println("#" + test_case + " " + temp[4]);
        }
    }
 
    public static void dfs(int depth, int start, int[] target) {
        if (depth == 3) {
            int s = 0;
            for (int a : target) {
                s += a;
            }
            sum.add(s);
            return;
        }
        for (int i = start; i < 7; i++) {
            target[depth] = input[i];
            dfs(depth + 1, i + 1, target);
        }
    }
}