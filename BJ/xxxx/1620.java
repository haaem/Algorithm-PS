import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1620 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> pok = new HashMap<String, Integer>();
		HashMap<Integer, String> rev = new HashMap<Integer, String>();
		for (int i=1; i<=N; i++) {
			String name = br.readLine();
			pok.put(name, i);
			rev.put(i, name);
		}
		for (int i=0; i<M; i++) {
			String input  = br.readLine();
			try {
				int num = Integer.parseInt(input);
				bw.append(rev.get(num)+"\n");
			} catch (Exception e) {
				bw.append(pok.get(input)+"\n");
			}
		}
		br.close();
		bw.flush(); bw.close();
	}
}
