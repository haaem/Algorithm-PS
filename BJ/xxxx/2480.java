import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2480 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dice = new int[7];
		for (int i = 0; i < 3; i++) {
			dice[Integer.parseInt(st.nextToken())]++;
		}
		int target = -1;
		int rule = 3;
		for (int i = 1; i <= 6; i++) {
			if (dice[i] == 3) {
				target = i;
				rule = 1;
				break;
			} else if (dice[i] == 2) {
				target = i;
				rule = 2;
				break;
			} else if (dice[i] == 1) {
				target = i;
			}
		}
		if (rule == 1) {
			System.out.println(10000 + target * 1000);
		} else if (rule == 2) {
			System.out.println(1000 + target * 100);
		} else {
			System.out.println(target * 100);
		}
	}
}
