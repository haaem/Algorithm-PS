import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2897 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] parkinglot = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				parkinglot[i][j] = s.charAt(j);
			}
		}

		int[] count = new int[5];

		for (int i = 0; i < R - 1; i++) {
			for (int j = 0; j < C - 1; j++) {
				int c = 0;
				if (parkinglot[i][j] == '#' || parkinglot[i + 1][j] == '#' || parkinglot[i][j + 1] == '#'
						|| parkinglot[i + 1][j + 1] == '#')
					continue;
				if (parkinglot[i][j] == 'X')
					c++;
				if (parkinglot[i + 1][j] == 'X')
					c++;
				if (parkinglot[i][j + 1] == 'X')
					c++;
				if (parkinglot[i + 1][j + 1] == 'X')
					c++;
				count[c]++;
			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(count[i]);
		}
	}
}
