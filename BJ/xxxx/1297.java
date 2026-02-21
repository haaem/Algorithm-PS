import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1297 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		// (H*a)^2+(W*a)^2 = D^2;
		double a = Math.sqrt(Math.pow(D, 2) / (Math.pow(H, 2) + Math.pow(W, 2)));
		System.out.println((int) (H * a) + " " + (int) (W * a));
	}
}
