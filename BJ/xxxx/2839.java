import java.util.Scanner;

public class BJ2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int five = N/5;
		int three;
		
		while (true) {
			if(five==0 && N%3!=0) {
				System.out.println(-1);
				System.exit(0);
			}
			if ((N-5*five)%3==0) {
				three = (N-5*five)/3;
				int bag = five+three;
				System.out.println(bag);
				break;
			}
			five--;
		}
	}
}
