import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int H, W;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];

			for (int i = 0; i < H; i++)
				map[i] = br.readLine().toCharArray();

			int[] cur = { 0, 0 };
			int dir = 0;
			int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if ("^v<>".contains(String.valueOf(map[i][j]))) {
						cur[0] = i;
						cur[1] = j;
						switch (map[i][j]) {
						case '^': {
							dir = 0;
							break;
						}
						case 'v': {
							dir = 1;
							break;
						}
						case '<': {
							dir = 2;
							break;
						}
						case '>': {
							dir = 3;
							break;
						}
						}
					}
				}
			}

			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			char[] arr = s.toCharArray();
			for (char c : arr) {
				if (c == 'S') {
					int dy = dirs[dir][0];
					int dx = dirs[dir][1];
					int ny = cur[0] + dy, nx = cur[1] + dx;
					while (ny >= 0 && nx >= 0 && ny < H && nx < W) {
						if (map[ny][nx] == '*') {
							map[ny][nx] = '.';
							break;
						} else if (map[ny][nx] == '#')
							break;

						ny += dy;
						nx += dx;
					}
				} else if (c == 'U') {
					dir = 0;
					int y = cur[0];
					int x = cur[1];
					map[y][x] = '^';
					if (y >= 1 && map[y - 1][x] == '.') {
						map[y][x] = '.';
						cur[0] = y - 1;
						map[y - 1][x] = '^';
					}
				} else if (c == 'D') {
					dir = 1;
					int y = cur[0];
					int x = cur[1];
					map[y][x] = 'v';
					if (y < H - 1 && map[y + 1][x] == '.') {
						map[y][x] = '.';
						cur[0] = y + 1;
						map[y + 1][x] = 'v';
					}
				} else if (c == 'L') {
					dir = 2;
					int y = cur[0];
					int x = cur[1];
					map[y][x] = '<';
					if (x >= 1 && map[y][x - 1] == '.') {
						map[y][x] = '.';
						cur[1] = x - 1;
						map[y][x - 1] = '<';
					}
				} else if (c == 'R') {
					dir = 3;
					int y = cur[0];
					int x = cur[1];
					map[y][x] = '>';
					if (x < W - 1 && map[y][x + 1] == '.') {
						map[y][x] = '.';
						cur[1] = x + 1;
						map[y][x + 1] = '>';
					}
				}
			}

			for (int i = 0; i < H; i++) {
				sb.append(new String(map[i])).append("\n");
			}
		}

		System.out.println(sb);
	}
}