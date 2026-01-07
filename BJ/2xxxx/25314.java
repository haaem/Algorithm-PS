import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ25314 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = N / 4;
		for (int i = 0; i < count; i++) {
			System.out.print("long ");
		}
		System.out.println("int");
	}
}
