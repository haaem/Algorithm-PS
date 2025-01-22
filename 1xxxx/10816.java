import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashMap;

public class BJ10816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (map.containsKey(a)) {
				map.replace(a, map.get(a)+1);
			} else {
				map.put(a, 1);
			}
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		br.close();
		for (int i=0; i<M; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (map.containsKey(a)) {
				bw.append(map.get(a)+" ");
			} else {
				bw.append("0 ");
			}
		}
		bw.flush(); bw.close();
	}

}
