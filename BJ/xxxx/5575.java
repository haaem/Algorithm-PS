import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5575 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[6];
			for (int j = 0; j < 6; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int sum = arr[3] * 3600 + arr[4] * 60 + arr[5] - (arr[0] * 3600 + arr[1] * 60 + arr[2]);
			sb.append(sum / 3600).append(" ");
			sum %= 3600;
			sb.append(sum / 60).append(" ");
			sum %= 60;
			sb.append(sum).append("\n");
		}

		System.out.println(sb);
	}
}
