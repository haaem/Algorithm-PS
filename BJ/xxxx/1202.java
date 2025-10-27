import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1202 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Jewel[] jewels = new Jewel[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int[] C = new int[K];
		for (int i = 0; i < K; i++) {
			C[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(C);
		// 시간 초과남
//		long sum = 0;
//		while (C.size() > 0 && !pq.isEmpty()) {
//			Jewel jewel = pq.poll();
//			int w = jewel.weight;
//			int index = -1;
//			for (int i = 0; i < C.size(); i++) {
//				if (C.get(i) >= w) {
//					index = i;
//					break;
//				}
//			}
//			if (index != -1) {
//				C.remove(index);
//				sum += jewel.price;
//			}
//		}
		Arrays.sort(jewels, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				if (o1.weight == o2.weight)
					return o2.price - o1.price;
				return o1.weight - o2.weight;
			}
		});
		PriorityQueue<Jewel> pq = new PriorityQueue<>();
		long sum = 0;
		for (int i = 0, j = 0; i < K; i++) {
			while (j < N && jewels[j].weight <= C[i]) {
				pq.offer(jewels[j++]);
			}
			if (!pq.isEmpty())
				sum += pq.poll().price;
		}
		System.out.println(sum);
	}
}

class Jewel implements Comparable<Jewel> {
	int weight, price;

	public Jewel(int w, int p) {
		this.weight = w;
		this.price = p;
	}

	@Override
	public int compareTo(Jewel o) {
		if (this.price == o.price)
			return this.weight - o.price;
		return o.price - this.price;
	}
}