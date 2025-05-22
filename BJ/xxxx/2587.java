import java.util.Scanner;

public class BJ2587 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int total = 0;
		for (int i=0; i<5; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		for (int i=1; i<5; i++) {
			int n = i;
			for (int j=i-1;j>=0; j--) {
				if (arr[n]<arr[j]) {
					int temp = arr[n];
					arr[n] = arr[j];
					arr[j] = temp;
				}
				n = j;
			}
		}
		System.out.println((int)(total/5));
		System.out.println(arr[2]);
	}
}
