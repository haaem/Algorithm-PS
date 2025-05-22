import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ2751 {
	static int[] arr;
	static int[] sortedArr;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		sortedArr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		sort(0,N-1);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i=0; i<N; i++) {
			bw.write(arr[i]+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void sort(int start, int end) {
		if (start<end) {
			int mid = (start+end)/2;
			sort(start, mid);
			sort(mid+1, end);
			merge(start, mid, end);
		}
	}
	
	public static void merge(int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int index = i;
		while (i<=mid && j<=end) {
			if (arr[i]<=arr[j]) {
				sortedArr[index++] = arr[i++];
			} else {
				sortedArr[index++] = arr[j++];
			}
		}
		
		if (i<mid+1) {
			while (i<mid+1) {
				sortedArr[index++] = arr[i++];
			}
		}
		
		if (j<=end) {
			while (j<= end) {
				sortedArr[index++] = arr[j++];
			}
		}
		for (int a = start; a <= end; a++) {
			arr[a] = sortedArr[a];
		}
	}
}
