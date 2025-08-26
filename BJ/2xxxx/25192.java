import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ25192 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> name = new HashSet<String>();
		int count = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if (input.equals("ENTER")) {
				name = new HashSet<String>();
			} else {
				if (!name.contains(input)) {
					count++;
					name.add(input);
				}
			}
		}
		System.out.println(count);
	}
}
