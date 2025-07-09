import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> setA = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			setA.add(br.readLine());
		}
		TreeSet<String> setB = new TreeSet<String>();
		for (int i = 0; i < M; i++) {
			String a = br.readLine();
			if (setA.contains(a))
				setB.add(a);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = setB.size();
		bw.append(size + "\n");
		for (int i = 0; i < size; i++) {
			bw.append(setB.pollFirst() + "\n");
		}
		bw.flush();
		bw.close();
	}
}
