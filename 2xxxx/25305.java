import java.util.Scanner;

public class BJ25305 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i=1; i<N; i++) {
			int a = i;
			for (int j=i-1; j>=0; j--) {
				if (arr[j]<arr[a]) {
					int temp = arr[j];
					arr[j] = arr[a];
					arr[a] = temp;
				}
				a = j;
			}
		}
		System.out.println(arr[k-1]);
	}
}
