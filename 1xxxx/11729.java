import java.util.Scanner;

public class BJ11729 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sb.append((int)(Math.pow(2, N)-1)+"\n");
		hanoi(N, 1, 3);
		System.out.println(sb);
	}
	
	public static void hanoi(int n, int start, int end) {
		if (n==1) {
			sb.append(start+" "+end+"\n");
			return;
		}
		hanoi(n-1, start, 6-start-end);
		sb.append(start+" "+end+"\n");
		hanoi(n-1, 6-start-end, end);
	}
}