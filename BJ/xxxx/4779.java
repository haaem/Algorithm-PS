import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ4779 {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		while ((st = br.readLine()) != null && !st.isEmpty()){
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(st);
			arr = new int[(int)Math.pow(3, N)];
			Arrays.fill(arr, 1);
			Cantor(0, N);
			for (int i=0; i<Math.pow(3, N); i++) {
				if (arr[i] == 1) {
					sb.append("-");
				} else {
					sb.append(" ");
				}
			}
			System.out.println(sb);
		}
	}
	
	public static void Cantor(int s, int n) {
		if (n<=0) return;
		for (int i=s+(int)Math.pow(3, n-1); i<s+2*Math.pow(3, n-1); i++) {
			arr[i] = 0;
		}
		Cantor(s, n-1);
		Cantor((int) (s+2*Math.pow(3, n-1)), n-1);
	}
}
