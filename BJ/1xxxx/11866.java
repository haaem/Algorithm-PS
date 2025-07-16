import java.util.LinkedList;
import java.util.Scanner;

public class BJ11866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		LinkedList<Integer> lst = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			lst.add(i);
		}
		int[] res = new int[N];
		int index = 0;
		while (!lst.isEmpty()) {
			for (int i = 0; i < K; i++) {
				if (i == K - 1) {
					res[index++] = lst.pollFirst();
				} else {
					int temp = lst.pollFirst();
					lst.add(temp);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < N; i++) {
			if (i == N - 1) {
				sb.append((res[i] + 1) + ">");
			} else {
				sb.append((res[i] + 1) + ", ");
			}
		}
		System.out.println(sb);
	}
}