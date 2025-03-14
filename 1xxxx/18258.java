import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ18258 {
	public static void main(String[] args) throws IOException {
		Queue queue = new Queue();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String func = st.nextToken();
			switch (func) {
				case "push":
					int val = Integer.parseInt(st.nextToken());
					queue.push(val);
					break;
				case "pop":
					bw.append(queue.pop()+"\n");
					break;
				case "size":
					bw.append(queue.size()+"\n");
					break;
				case "empty":
					int res;
					if (queue.size() == 0)
						res = 1;
					else
						res = 0;
					bw.append(res+"\n");
					break;
				case "front":
					bw.append(queue.first()+"\n");
					break;
				case "back":
					bw.append(queue.last()+"\n");
			}
		}
		br.close(); bw.flush(); bw.close();
	}
}

class Queue {
	int[] num;
	int startIndex;
	int endIndex;
	int size;
	
	public Queue() {
		num = new int[2000000];
		startIndex = endIndex = size = 0;
	}
	
	public void push(int value) {
		num[endIndex++] = value;
		size++;
	}
	
	public int pop() {
		if (size == 0) {
			return -1;
		}
		size--;
		return num[startIndex++];
	}
	
	public int size() {
		return size;
	}
	
	
	public int first() {
		if (size == 0) {
			return -1;
		}
		return num[startIndex];
	}
	
	public int last() {
		if (size == 0) {
			return -1;
		}
		return num[endIndex-1];
	}
}
