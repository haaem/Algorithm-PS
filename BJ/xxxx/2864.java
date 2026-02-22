import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2864 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		System.out.println((Integer.parseInt(A.replace('6', '5')) + Integer.parseInt(B.replace('6', '5'))) + " "
				+ (Integer.parseInt(A.replace('5', '6')) + Integer.parseInt(B.replace('5', '6'))));
	}
}