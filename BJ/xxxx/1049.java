import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1049 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int six = 1000;
		int one = 1000;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			six = Math.min(six, Integer.parseInt(st.nextToken()));
			one = Math.min(one, Integer.parseInt(st.nextToken()));
		}
		int money = 0;
		int s_count = N / 6;
		money = s_count * Math.min(six, one * 6);
		money += Math.min(six, (N % 6) * one);
		System.out.println(money);
	}
}
