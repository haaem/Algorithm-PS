import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ23808 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] arr = { "@   @", "@   @", "@@@@@", "@   @", "@@@@@" };
		for (int i = 0; i < 5; i++) {
			String s = arr[i];
			for (int j = 0; j < N; j++) {
				for (int h = 0; h < 5; h++) {
					char c = s.charAt(h);
					for (int k = 0; k < N; k++) {
						sb.append(c);
					}
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
