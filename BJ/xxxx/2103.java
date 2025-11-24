import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ2103 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		TreeMap<Integer, ArrayList<Integer>> mapX = new TreeMap<>();
		TreeMap<Integer, ArrayList<Integer>> mapY = new TreeMap<>();

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			mapX.putIfAbsent(x, new ArrayList<Integer>());
			mapY.putIfAbsent(y, new ArrayList<Integer>());

			mapX.get(x).add(y);
			mapY.get(y).add(x);
		}

		long sum = 0;

		for (int k : mapX.keySet()) {
			ArrayList<Integer> arr = mapX.get(k);
			Collections.sort(arr);

			for (int i = 0; i < arr.size(); i += 2) {
				sum += arr.get(i + 1) - arr.get(i);
			}
		}

		for (int k : mapY.keySet()) {
			ArrayList<Integer> arr = mapY.get(k);
			Collections.sort(arr);

			for (int i = 0; i < arr.size(); i += 2) {
				sum += arr.get(i + 1) - arr.get(i);
			}
		}

		System.out.println(sum);
	}
}
