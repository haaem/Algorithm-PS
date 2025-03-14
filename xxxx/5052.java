import java.util.Scanner;

public class Bj5052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i=0; i<N; i++) {
			Trie trie = new Trie();
			int M = sc.nextInt();
			String[] lst = new String[M];
			for (int j=0; j<M; j++) {
				String num = sc.next();
				trie.insert(num);
				lst[j] = num;
			}
			boolean res = true;
			for (String num : lst) {
				if (!trie.isPrefix(num)) {
					res = false; break;
				}
			}
			if (res) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}

class Trie {
	TrieNode root;
	
	public Trie() {
		root = new TrieNode(false);
	}
	
	void insert(String num) {
		TrieNode current = root;
		for (int i=0; i<num.length(); i++) {
			if (current.children[(int) num.charAt(i)-'0'] == null) {
				current.children[(int) num.charAt(i)-'0'] = new TrieNode(false);
			}
			current = current.children[(int) num.charAt(i)-'0'];
			if (i==num.length()-1) {
				current.isLast = true;
			}
		}
	}
	
	boolean isPrefix(String num) {
		TrieNode current = root;
		for (int i=0; i<num.length(); i++) {
			current = current.children[(int) num.charAt(i)-'0'];
			if (i != num.length()-1 && current.isLast) {
				return false;
			}
		}
		return true;
	}
}

class TrieNode {
	boolean isLast;
	TrieNode[] children = new TrieNode[10];
	
	public TrieNode(boolean isLast) {
		this.isLast = isLast;
	}
}