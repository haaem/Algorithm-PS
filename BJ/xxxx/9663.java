import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9663 {
	static int[] board;
	static int N;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N];
		backtracking(0);
		System.out.println(res);
	}

	public static void backtracking(int depth) {
		if (depth == N) {
			res++;
			return;
		}
		for (int i = 0; i < N; i++) {
			board[depth] = i;
			if (possible(depth)) {
				backtracking(depth + 1);
			}
		}
	}

	public static boolean possible(int depth) {
		for (int i = 0; i < depth; i++) {
			if (board[depth] == board[i])
				return false;
		}
		for (int i = 0; i < depth; i++) {
			if (Math.abs(depth - i) == Math.abs(board[depth] - board[i]))
				return false;
		}
		return true;
	}
}
