import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2246 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Condo> arr = new ArrayList();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Condo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(arr);
		int count = 0;
		int min = Integer.MAX_VALUE;

		for (Condo c : arr) {
			if (c.C < min) {
				count++;
				min = c.C;
			}
		}

		System.out.println(count);
	}
}

class Condo implements Comparable<Condo> {
	int D, C;

	Condo(int D, int C) {
		this.D = D;
		this.C = C;
	}

	@Override
	public int compareTo(Condo o) {
		if (this.D == o.D) {
			return this.C - o.C;
		}
		return this.D - o.D;
	}
}