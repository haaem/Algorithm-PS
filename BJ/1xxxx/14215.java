import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14215 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] l = new int[3];
		for (int i = 0; i < 3; i++) {
			l[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(l);
		if (l[0] + l[1] > l[2]) {
			System.out.println(l[0] + l[1] + l[2]);
		} else {
			System.out.println((l[0] + l[1]) * 2 - 1);
		}
	}
}
