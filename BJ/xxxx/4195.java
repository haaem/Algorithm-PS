import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ4195 {
	static int[] parent;
	static int[] count;
	static HashMap<String, Integer> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case<t; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int index = 0;
			parent = new int[2*n];
			count = new int[2*n];
			for (int i=0; i<2*n; i++) {
				parent[i] = i;
				count[i] = 1;
			}
			map = new HashMap<String, Integer>();
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				String name1 = st.nextToken();
				if (!map.containsKey(name1)) {
					map.put(name1, index++);
				}
				String name2 = st.nextToken();
				if (!map.containsKey(name2)) {
					map.put(name2, index++);
				}
				int p = union(map.get(name1), map.get(name2));
				System.out.println(count[p]);
			}
		}
	}
	
	public static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static int union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if (A==B) {
			return A;
		} else if (A<B) {
			parent[B] = A;
			count[A] += count[B];
			return A;
		} else {
			parent[A] = B;
			count[B] += count[A];
			return B;
		}
	}
}
