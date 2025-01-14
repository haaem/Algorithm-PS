import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ10989 {
	//counting sort
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		for (int i=0; i<N; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		for (int i=1; i<10001; i++) {
			int count = arr[i];
			while (count>0) {
				bw.write(i+"\n");
				count--;
			}
		}
		bw.flush();
		bw.close();
	}
}