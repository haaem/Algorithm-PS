import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] score = new int[N];
		score[0] = arr[0];
		if (N == 1) {
			System.out.println(score[0]);
			System.exit(0);
		}
		score[1] = arr[0] + arr[1];
		if (N == 2) {
			System.out.println(score[1]);
			System.exit(0);
		}
		score[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
		if (N == 3) {
			System.out.println(score[2]);
			System.exit(0);
		}
		for (int i = 3; i < N; i++) {
			score[i] = Math.max(score[i - 2] + arr[i], score[i - 3] + arr[i - 1] + arr[i]);
		}
		System.out.println(score[N - 1]);
	}
}
