import java.util.Arrays;
import java.util.Scanner;

public class BJ2447 {
	static int[][] A;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int N = sc.nextInt();
//		int k = (int) (Math.log(N)/Math.log(3));
		int k=0;
		int temp = N;
		while (temp>1) {
			k++;
			temp /= 3;
		}
//		System.out.println(k);
		A = new int[N][N];
		for (int i=0; i<N; i++) {
			Arrays.fill(A[i], 1);
		}
		star(0, 0, k-1);
		for(int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (A[i][j] == 1) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void star(int i, int j, int k) {
		if (k<0) return;
		for (int a = (int) (i+Math.pow(3, k)); a<i+2*Math.pow(3, k); a++) {
			for (int b = (int) (j+Math.pow(3, k)); b<j+2*Math.pow(3, k); b++) {
				A[a][b] = 0;
			}
		}
		star(i, j, k-1);
		star(i, (int)(j+3*Math.pow(3, k-1)), k-1);
		star(i, (int)(j+6*Math.pow(3, k-1)), k-1);
		
		star((int)(i+3*Math.pow(3, k-1)), j, k-1);
		star((int)(i+3*Math.pow(3, k-1)), (int)(j+6*Math.pow(3, k-1)), k-1);
		
		star((int)(i+6*Math.pow(3, k-1)), j, k-1);
		star((int)(i+6*Math.pow(3, k-1)), (int) (j+3*Math.pow(3, k-1)), k-1);
		star((int)(i+6*Math.pow(3, k-1)), (int) (j+6*Math.pow(3, k-1)), k-1);
	}
}
