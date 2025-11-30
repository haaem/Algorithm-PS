import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16131 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] room = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			room[i] = i;
		}
		int happy = 0, seq = 0, now = 0;
		if (Math.abs(1 - A) <= B) {
			happy++;
			seq = 1;
			now = 1;
		}
		for (int i = 1; i < M; i++) {
			int[] score = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				score[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				score[j] -= Integer.parseInt(st.nextToken());
			}
			for (int j = 1; j < N; j++) {
				int a = score[room[j]];
				int b = score[room[j + 1]];
				boolean change = false;
				if (a >= 0 && b >= 0 && b >= a + 2) {
					change = true;
				} else if (b >= 0 && a < 0) {
					change = true;
				} else if (a < 0 && b < 0 && b >= a + 4) {
					change = true;
				}
				if (change) {
					int temp = room[j];
					room[j] = room[j + 1];
					room[j + 1] = temp;
					score[room[j]] -= 2;
					score[room[j + 1]] += 2;
				}
			}
			int one = -1, tar = -1;
			for (int j = 1; j <= N; j++) {
				if (room[j] == 1) {
					one = j;
				} else if (room[j] == A) {
					tar = j;
				}
			}
			if (Math.abs(one - tar) <= B) {
				happy++;
				now++;
				seq = Math.max(seq, now);
			} else {
				now = 0;
			}
		}
		System.out.println(happy + " " + seq);
	}
}
