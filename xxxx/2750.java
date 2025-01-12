import java.util.Scanner;

public class BJ2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// insertion sort
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i=1; i<N; i++) {
			int a = i;
			for (int j=i-1; j>=0; j--) {
				if (arr[a]<arr[j]) {
					int temp = arr[a];
					arr[a] = arr[j];
					arr[j] = temp;
					a=j;
				}
			}
		}
		for (int i=0; i<N; i++) {
			System.out.println(arr[i]);
		}
	}
}
