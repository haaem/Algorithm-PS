import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA6781 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String num = br.readLine();
			String color = br.readLine();
			int[] R = new int[10];
			int[] G = new int[10];
			int[] B = new int[10];
			for (int i = 0; i < 9; i++) {
				char c = color.charAt(i);
				int index = Integer.parseInt(num.substring(i, i + 1));
				switch (c) {
				case 'R': {
					R[index]++;
					break;
				}
				case 'G': {
					G[index]++;
					break;
				}
				case 'B': {
					B[index]++;
					break;
				}
				}
			}
			int count = 0;
			for (int i = 1; i <= 9; i++) {
				if (R[i] >= 3) {
					count++;
					R[i] -= 3;
				}
				if (G[i] >= 3) {
					count++;
					G[i] -= 3;
				}
				if (B[i] >= 3) {
					count++;
					B[i] -= 3;
				}
			}
			for (int i = 1; i <= 7; i++) {
				while (R[i] * R[i + 1] * R[i + 2] > 0) {
					count++;
					R[i]--;
					R[i + 1]--;
					R[i + 2]--;
				}
				while (G[i] * G[i + 1] * G[i + 2] > 0) {
					count++;
					G[i]--;
					G[i + 1]--;
					G[i + 2]--;
				}
				while (B[i] * B[i + 1] * B[i + 2] > 0) {
					count++;
					B[i]--;
					B[i + 1]--;
					B[i + 2]--;
				}
			}
			if (count >= 3) {
				System.out.println("#" + test_case + " Win");
			} else {
				System.out.println("#" + test_case + " Continue");
			}
		}
	}
}
