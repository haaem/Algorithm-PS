import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4587 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		long M = Long.parseLong(st.nextToken()); // 분자
		long N = Long.parseLong(st.nextToken()); // 분모
		while (M != 0 && N != 0) {
			int a = 2;
			while (true) {
				if (M * a < N) {
					a++;
					continue;
				}
				long nN = N * a;
				long nM = M * a - N;

				if (nM == 0) {
					sb.append(a).append(" ");
					break;
				}

				long g = gcd(nM, nN);

				if (nN / g >= 1000000) {
					a++;
					continue;
				}

				M = nM / g;
				N = nN / g;
				sb.append(a).append(" ");
			}
			sb.append("\n");
			st = new StringTokenizer(br.readLine());
			M = Long.parseLong(st.nextToken());
			N = Long.parseLong(st.nextToken());
		}
		System.out.println(sb);
	}

	static long gcd(long a, long b) {
		while (b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
