import java.util.Scanner;

class BJ11811 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				int tmp = sc.nextInt();
				if (i==j) continue;
				a[i] = a[i]|tmp;
			}
		}
		for(int i=0; i<N; i++) {
			System.out.print(a[i]+" ");
		}
	}
}
