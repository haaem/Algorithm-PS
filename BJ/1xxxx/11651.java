import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ11651 {
	static int[][] coordinate;
	static int[][] sorted;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		coordinate = new int[N][2];
		sorted = new int[N][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			coordinate[i][0] = Integer.parseInt(st.nextToken());
			coordinate[i][1] = Integer.parseInt(st.nextToken());
		}
		mergeSort(0,  N-1);
		for (int i=0; i<N; i++) {
			bw.write(coordinate[i][0]+" "+coordinate[i][1]+"\n");
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
		int j = mid+1;
		int index = start;
		
		while (i<=mid && j<=end) {
			if(coordinate[i][1]<coordinate[j][1]) {
				sorted[index][0] = coordinate[i][0];
				sorted[index][1] = coordinate[i][1];
				index++; i++;
			} else if(coordinate[i][1]>coordinate[j][1]) {
				sorted[index][0] = coordinate[j][0];
				sorted[index][1] = coordinate[j][1];
				index++; j++;
			} else {
				if (coordinate[i][0]<coordinate[j][0]) {
					sorted[index][0] = coordinate[i][0];
					sorted[index][1] = coordinate[i][1];
					index++; i++;
				} else {
					sorted[index][0] = coordinate[j][0];
					sorted[index][1] = coordinate[j][1];
					index++; j++;
				}
			}
		}
		
		if (i<=mid) {
			while (i<=mid) {
				sorted[index][0] = coordinate[i][0];
				sorted[index][1] = coordinate[i][1];
				index++; i++;
			}
		}
		
		if (j<=end) {
			while (j<= end) {
				sorted[index][0] = coordinate[j][0];
				sorted[index][1] = coordinate[j][1];
				index++; j++;
			}
		}
		
		for (int a = start; a <= end; a++) {
			coordinate[a][0] = sorted[a][0];
			coordinate[a][1] = sorted[a][1];
		}
	}
}
