import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ1427 {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		int size = N.length();
		int[] arr = new int[size];
		for (int i=0; i<size; i++) {
			arr[i] = Integer.parseInt(N.substring(i,i+1));
		}
		for (int i=1; i<size; i++) {
			int a = i;
			for (int j=i-1; j>=0; j--) {
				if (arr[j]<arr[a]) {
					int temp = arr[a];
					arr[a] = arr[j];
					arr[j] = temp;
					a = j;
				}
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i=0; i<size; i++) {
			bw.write(String.valueOf(arr[i]));
		}
		bw.flush();
		bw.close();
	}
}
