import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ18870 {
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] inputArr = new int[N];
		arr = new int[N];
		
		for (int i=0; i<N; i++) {
			inputArr[i] = arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		quickSort(0, N-1);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int a=0;
		for (int i=0; i<N; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], a++);
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i=0; i<N; i++) {
			bw.append(map.get(inputArr[i])+" ");
		}
		bw.flush();
		bw.close();
	}
	
	public static void quickSort(int start, int end) {
		int part = partition(start, end);
		if (start < part-1)
			quickSort(start, part-1);
		if (part < end)
			quickSort(part, end);
	}
	
	public static int partition(int start, int end) {
		int mid = (start+end)/2;
		int pivot = arr[mid];
		while (start<=end) {
			while (arr[start]<pivot) start++;
			while (pivot<arr[end]) end--;
			if (start<=end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++; end--;
			}
		}
		return start;
	}
}