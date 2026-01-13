import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ23326 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		TreeSet<Integer> famous = new TreeSet<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			if (st.nextToken().charAt(0) == '1')
				famous.add(i);
		}
		int index = 0;
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			switch (Integer.parseInt(st.nextToken())) {
			case 1: {
				int i = Integer.parseInt(st.nextToken());
				if (famous.contains(i - 1))
					famous.remove(i - 1);
				else
					famous.add(i - 1);
				break;
			}
			case 2: {
				int x = Integer.parseInt(st.nextToken());
				index = (index + (x % N)) % N;
				break;
			}
			case 3: {
				if (famous.isEmpty()) {
					sb.append("-1\n");
				} else if (famous.contains(index)) {
					sb.append("0\n");
				} else {
					Integer next = famous.ceiling(index);
					if (next != null)
						sb.append(next - index).append("\n");
					else
						sb.append(N - index + famous.first()).append("\n");
				}
				break;
			}
			}
		}
		System.out.println(sb);
	}
}