import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ14888 {
	static int N, count;
	static int[] A;
	static int[] op;
	static int[] selected;
	static int max, min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		op = new int[4];
		st = new StringTokenizer(br.readLine());
		count = 0;
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
			count += op[i];
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		selected = new int[count];
		backtracking(0);
		System.out.println(max);
		System.out.println(min);
	}

	static void backtracking(int depth) {
		if (depth == count) {
			int val = calculate();
			max = Math.max(max, val);
			min = Math.min(min, val);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;
				selected[depth] = i;
				backtracking(depth + 1);
				op[i]++;
			}
		}
	}

	static int calculate() {
		LinkedList<Integer> lst = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			lst.add(A[i]);
		}
		int index = 0;
		while (lst.size() > 1) {
			int a = lst.poll();
			int b = lst.poll();
			switch (selected[index]) {
			case 0: {
				lst.addFirst(a + b);
				break;
			}
			case 1: {
				lst.addFirst(a - b);
				break;
			}
			case 2: {
				lst.addFirst(a * b);
				break;
			}
			case 3: {
				lst.addFirst(a / b);
				break;
			}
			}
			index++;
		}
		return lst.poll();
	}
}
