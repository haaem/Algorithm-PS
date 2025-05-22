import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ28278 {
	public static void main(String[] args) throws IOException {
		LinkedList<Integer> lst = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int func = Integer.parseInt(st.nextToken());
			switch (func) {
				case 1:
					int X = Integer.parseInt(st.nextToken());
					lst.addLast(X);
					break;
				case 2:
					if (lst.size() != 0) {
						bw.append(lst.pollLast()+"\n");
					} else {
						bw.append("-1\n");
					}
					break;
				case 3:
					bw.append(lst.size()+"\n");
					break;
				case 4:
					if (lst.size() != 0) {
						bw.append("0\n");
					} else {
						bw.append("1\n");
					}
					break;
				case 5:
					if (lst.size() != 0) {
						bw.append(lst.getLast()+"\n");
					} else {
						bw.append("-1\n");
					}
					break;
			}
		}
		br.close();
		bw.flush(); bw.close();
	}
}
