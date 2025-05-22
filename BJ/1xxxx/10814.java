import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ10814 {
	static String[][] arr;
	static String[][] sorted;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new String[N][2];
		sorted = new String[N][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		mergeSort(0, N-1);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i=0; i<N; i++) {
			bw.append(arr[i][0] + " " + arr[i][1] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void mergeSort(int start, int end) {
		if (start<end) {
			int mid = (start+end)/2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			merge(start, mid, end);
		}
	}
	
	public static void merge(int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int index = i;
		while (i<=mid && j<=end) {
			if (Integer.parseInt(arr[i][0]) <= Integer.parseInt(arr[j][0])) {
				sorted[index][0] = arr[i][0];
				sorted[index++][1] = arr[i++][1];
			} else {
				sorted[index][0] = arr[j][0];
				sorted[index++][1] = arr[j++][1];
			}
		}
		
		while (i <= mid) {
			sorted[index][0] = arr[i][0];
			sorted[index++][1] = arr[i++][1];
		}
		
		while (j <= end) {
			sorted[index][0] = arr[j][0];
			sorted[index++][1] = arr[j++][1];
		}
		
		for (int a = start; a <= end; a++) {
			arr[a][0] = sorted[a][0];
			arr[a][1] = sorted[a][1];
		}
	}
}
