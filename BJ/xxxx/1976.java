import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1976 {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] board = new int[N+1][N+1];
		StringTokenizer st;
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		parent = new int[N+1];
		for (int i=1; i<=N; i++) {
			parent[i] = i;
		}
		for (int i=1; i<=N; i++) {
			for (int j=i; j<=N; j++) {
				if (board[i][j] == 1) {
					union(i, j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int world = find(Integer.parseInt(st.nextToken()));
		boolean res = true;
		for (int i=0; i<M-1; i++) {
			if (world != find(Integer.parseInt(st.nextToken()))) {
				res = false; break;
			}
		}
		if (res) System.out.println("YES");
		else System.out.println("NO");
	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if (A != B) {
			parent[B] = A;
		}
	}
}
