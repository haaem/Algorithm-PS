import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1991 {
	public static HashMap<Character, char[]> tree;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		tree = new HashMap<Character, char[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char node = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			tree.put(node, new char[] { left, right });
		}
		sb = new StringBuilder();
		preorder('A');
		sb.append("\n");
		inorder('A');
		sb.append("\n");
		postorder('A');
		sb.append("\n");
		System.out.println(sb);
	}

	public static void preorder(char c) {
		sb.append(c);
		if (tree.get(c)[0] != '.') {
			preorder(tree.get(c)[0]);
		}
		if (tree.get(c)[1] != '.') {
			preorder(tree.get(c)[1]);
		}
	}

	public static void inorder(char c) {
		if (tree.get(c)[0] != '.') {
			inorder(tree.get(c)[0]);
		}
		sb.append(c);
		if (tree.get(c)[1] != '.') {
			inorder(tree.get(c)[1]);
		}
	}

	public static void postorder(char c) {
		if (tree.get(c)[0] != '.') {
			postorder(tree.get(c)[0]);
		}
		if (tree.get(c)[1] != '.') {
			postorder(tree.get(c)[1]);
		}
		sb.append(c);
	}
}