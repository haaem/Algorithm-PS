import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2896 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int I = Integer.parseInt(st.nextToken());
		int J = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		float m = Math.min(Math.min((float) A / I, (float) B / J), (float) C / K);
		System.out.println((A - I * m) + " " + (B - J * m) + " " + (C - K * m));
	}
}
