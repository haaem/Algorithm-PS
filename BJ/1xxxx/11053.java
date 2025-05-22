import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = 1;
			for (int j=0; j<i; j++) {
				if(A[j]<A[i] && arr[i] < arr[j]+1) {
					arr[i] = arr[j] + 1;
				}
			}
		}
		int max = -1;
		for (int i=0; i<N; i++) {
			if (arr[i] > max) max = arr[i];
		}
		System.out.println(max);
	}
}