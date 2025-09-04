import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ20920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Word> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String w = br.readLine();
			if (w.length() >= M) {
				if (map.containsKey(w)) {
					map.get(w).count++;
				} else {
					map.put(w, new Word(w, 1));
				}
			}
		}
		PriorityQueue<Word> pq = new PriorityQueue<>();
		for (String s : map.keySet()) {
			pq.offer(map.get(s));
		}
		while (!pq.isEmpty()) {
			Word word = pq.poll();
			sb.append(word.val).append("\n");
		}
		System.out.println(sb);
	}
}

class Word implements Comparable<Word> {
	String val;
	int count;

	public Word(String val, int count) {
		this.val = val;
		this.count = count;
	}

	@Override
	public int compareTo(Word o) {
		if (this.count < o.count) {
			return 1;
		} else if (this.count > o.count) {
			return -1;
		}
		if (this.val.length() < o.val.length()) {
			return 1;
		} else if (this.val.length() > o.val.length()) {
			return -1;
		}
		return this.val.compareTo(o.val);
	}
}