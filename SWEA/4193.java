import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SWEA4193 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] sea = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					sea[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			boolean[][] visited = new boolean[N][N];
			int ans = -1;
			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(new Node(A, B, 0));
			visited[A][B] = true;
			while (!queue.isEmpty()) {
				Node now = queue.poll();
				if (now.x == C && now.y == D) {
					ans = now.val;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int x = now.x + dx[i];
					int y = now.y + dy[i];
					if (x < 0 || x >= N || y < 0 || y >= N)
						continue;
					if (sea[x][y] == 1 || visited[x][y])
						continue;
					if (sea[x][y] == 2) {
						if (now.val % 3 == 2) {
							visited[x][y] = true;
							queue.add(new Node(x, y, now.val + 1));
						} else {
							visited[now.x][now.y] = true;
							Node nowNode = new Node(now.x, now.y, now.val + 1);
							queue.add(nowNode);
						}
					} else {
						visited[x][y] = true;
						queue.add(new Node(x, y, now.val + 1));
					}
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}

class Node {
	int x, y;
	int val;

	public Node(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
}