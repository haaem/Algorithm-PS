import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
	static int[][] board;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			board = new int[9][9];

			for (int i = 0; i < 9; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < 9; j++)
					board[i][j] = Integer.parseInt(s[j]);
			}

			if (check())
				System.out.println("#" + tc + " 1");
			else
				System.out.println("#" + tc + " 0");
		}
	}

	static boolean check() {
		HashSet<Integer> set;
		for (int i = 0; i < 9; i++) {
			set = new HashSet<Integer>();
			for (int j = 0; j < 9; j++) {
				if (set.contains(board[i][j]))
					return false;
				else
					set.add(board[i][j]);
			}

			set = new HashSet<Integer>();
			for (int j = 0; j < 9; j++) {
				if (set.contains(board[j][i]))
					return false;
				else
					set.add(board[j][i]);
			}
		}

		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				set = new HashSet<Integer>();
				for (int a = 0; a < 3; a++) {
					for (int b = 0; b < 3; b++) {
						if (set.contains(board[i + a][j + b]))
							return false;
						else
							set.add(board[i + a][j + b]);
					}
				}
			}
		}

		return true;
	}
}