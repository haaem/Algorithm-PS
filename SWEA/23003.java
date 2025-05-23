import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

class SWEA23003 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("red", 1);
		map.put("orange", 2);
		map.put("yellow", 3);
		map.put("green", 4);
		map.put("blue", 5);
		map.put("purple", 6);

		for (int test_case = 1; test_case <= T; test_case++) {
			int first = map.get(sc.next());
			int second = map.get(sc.next());
			if (first == second) {
				System.out.println("E");
			} else if (Math.abs(first - second) == 1 || (first == 1 && second == 6) || (first == 6 && second == 1)) {
				System.out.println("A");
			} else if (Math.abs(first - second) == 3) {
				System.out.println("C");
			} else {
				System.out.println("X");
			}
		}
	}
}