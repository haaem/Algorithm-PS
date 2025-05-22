import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		String[] noDuplicate = Arrays.stream(arr).distinct().toArray(String[]::new);
		Arrays.sort(noDuplicate, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length()<o2.length()) {
					return -1;
				} else if (o1.length()>o2.length()) {
					return 1;
				} else {
					return o1.compareTo(o2);
				}
			}
		});
		for (int i=0; i<noDuplicate.length; i++) {
			System.out.println(noDuplicate[i]);
		}
	}
}
