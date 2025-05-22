import java.util.Scanner;

public class BJ25501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i=0; i<N; i++) {
			int[] res = isPalindrome(sc.next());
			System.out.println(res[0]+" "+res[1]);
		}
	}
	
	public static int[] recursion(String s, int l, int r, int n) {
		if(l >= r) return new int[] {1, n+1};
        else if(s.charAt(l) != s.charAt(r)) return new int[]{0, n+1};
        else return recursion(s, l+1, r-1, n+1);
	}
	
	public static int[] isPalindrome(String s){
        return recursion(s, 0, s.length()-1, 0);
    }
}
