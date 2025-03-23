import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ24060 {
	static int[] A, tmp;
	static int N;
	static int K;
	static int a = 0;
	static int res=-1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N];
		tmp = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		mergeSort(0, N-1);
		System.out.println(res);
	}
	
	public static void mergeSort(int l, int r) {
		if (l < r) {
			int mid = (l+r)/2;
			mergeSort(l, mid);
			mergeSort(mid+1, r);
			merge(l, r, mid);
		}
	}
	
	public static void merge(int l, int r, int mid) {
		int i = l;
		int j = mid+1;
		int t = 0;
		while (i<=mid && j<=r) {
			if (A[i]<=A[j]) {
				tmp[t++] = A[i++];
			} else {
				tmp[t++] = A[j++];
			}
		}
		while (i<=mid) tmp[t++] = A[i++];
		while (j<=r) tmp[t++] = A[j++];
		i = l; t = 0;
		while (i<=r) {
			a++;
			if (a==K) {
				res = tmp[t];
				System.out.println(res);
				System.exit(0);
			}
			A[i++] = tmp[t++];
		}
	}
}
