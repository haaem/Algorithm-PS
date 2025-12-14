import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ16159 {
	private static final String[] PATTERNS = { /* 0 */ "000000001100010010010010010010001100000000",
			/* 1 */ "000000000100001100000100000100000100000000", /* 2 */ "000000011110000010011110010000011110000000",
			/* 3 */ "000000011100000010000100000010011100000000", /* 4 */ "000000000100001100010100111110000100000000",
			/* 5 */ "000000011110010000011100000010010010001100", /* 6 */ "000000010000010000011110010010011110000000",
			/* 7 */ "000000011110000010000100000100000100000000", /* 8 */ "000000011110010010011110010010011110000000",
			/* 9 */ "011110010010010010011110000010000010000010" };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = s.length() / 6;
		boolean[][] board = new boolean[7][N * 6];
		for (int i = 0; i < N * 6; i++) {
			if (s.charAt(i) == '1')
				board[0][i] = true;
		}
		for (int i = 1; i < 7; i++) {
			s = br.readLine();
			for (int j = 0; j < N * 6; j++) {
				if (s.charAt(j) == '1')
					board[i][j] = true;
			}
		}

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 7; k++) {
					if (board[k][i * 6 + j])
						count++;
				}
			}
			// 10 6 14 9 11 13 12 8 16 15
			switch (count) {
			case 10:
				arr[i] = 0;
				break;
			case 6:
				arr[i] = 1;
				break;
			case 14:
				arr[i] = 2;
				break;
			case 9:
				arr[i] = 3;
				break;
			case 11:
				arr[i] = 4;
				break;
			case 13:
				arr[i] = 5;
				break;
			case 12:
				arr[i] = 6;
				break;
			case 8:
				arr[i] = 7;
				break;
			case 16:
				arr[i] = 8;
				break;
			case 15:
				arr[i] = 9;
				break;
			}
		}

//		System.out.println(Arrays.toString(arr));
		boolean found = nextPermutation(arr);
		if (!found) {
			System.out.println("The End");
		} else {
			StringBuilder sb = new StringBuilder();
			for (int k = 0; k < 7; k++) {
				for (int i = 0; i < N; i++) {
					int digit = arr[i];
					sb.append(PATTERNS[digit].substring(k * 6, k * 6 + 6));
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}
	}

	static boolean nextPermutation(int[] arr) {
		int N = arr.length;
		int i = N - 2;

		while (i >= 0 && arr[i] >= arr[i + 1]) {
			i--;
		}
		if (i < 0)
			return false;

		int j = N - 1;
		while (arr[i] >= arr[j]) {
			j--;
		}

		swap(arr, i, j);
		int k = N - 1;
		i++;
		while (i < k) {
			swap(arr, i++, k--);
		}
		return true;
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
