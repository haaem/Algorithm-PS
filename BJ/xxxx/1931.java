import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1931 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<Meeting> pq = new PriorityQueue<Meeting>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int count = 0;
		int time = 0;
		while (!pq.isEmpty()) {
			Meeting m = pq.poll();
			if (m.start >= time) {
				time = m.end;
				count++;
			}
		}
		System.out.println(count);
	}
}

class Meeting implements Comparable<Meeting> {
	int start, end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		if (this.end == o.end) {
			return this.start - o.start;
		}
		return this.end - o.end;
	}
}