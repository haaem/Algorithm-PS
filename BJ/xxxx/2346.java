import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ2346 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> lst = new LinkedList<Integer>();
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			lst.add(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(1).append(" ");
		int step = arr[lst.pollFirst()];
		int index;
		while (!lst.isEmpty()) {
			if (step < 0) {
				int s = (-step - 1) % lst.size();
				for (int i = 0; i < s; i++) {
					lst.addFirst(lst.pollLast());
				}
				index = lst.pollLast();
			} else {
				for (int i = 0; i < (step - 1) % lst.size(); i++) {
					lst.addLast(lst.pollFirst());
				}
				index = lst.pollFirst();
			}
			sb.append(index + 1).append(" ");
			step = arr[index];
		}
		System.out.println(sb);
	}
}
