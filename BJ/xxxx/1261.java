import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1261 {
	static int N, M;
	static int[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
				visited[i][j] = 10000;
			}
		}
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(0, 0, 0));
		visited[0][0] = 0;
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			for (int a = 0; a < 4; a++) {
				int ni = now.i + di[a];
				int nj = now.j + dj[a];

				if (ni < 0 || nj < 0 || ni >= N || nj >= M)
					continue;

				if (map[ni][nj] == 1) {
					if (visited[ni][nj] > now.c + 1) {
						visited[ni][nj] = now.c + 1;
						pq.offer(new Node(ni, nj, now.c + 1));
					}
				} else {
					if (visited[ni][nj] > now.c) {
						visited[ni][nj] = now.c;
						pq.offer(new Node(ni, nj, now.c));
					}
				}
			}
		}
		System.out.println(visited[N - 1][M - 1]);
	}
}

class Node implements Comparable<Node> {
	int i, j, c;

	Node(int i, int j, int c) {
		this.i = i;
		this.j = j;
		this.c = c;
	}

	@Override
	public int compareTo(Node o) {
		return this.c - o.c;
	}
}
