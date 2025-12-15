import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class BJ5430 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String input = br.readLine();
			input = input.substring(1, input.length() - 1);
			if (n != 0) {
				boolean isReversed = false;
				boolean isError = false;
				String[] arr = input.split(",");
				LinkedList<String> lst = new LinkedList<String>(Arrays.asList(arr));
				for (int i = 0; i < p.length(); i++) {
					if (p.charAt(i) == 'R') {
						isReversed = !isReversed;
					} else { // p.charAt(i) == 'D'
						if (lst.size() == 0) {
							isError = true;
							break;
						}
						if (!isReversed)
							lst.pollFirst();
						else
							lst.pollLast();
					}
				}
				if (isError) {
					sb.append("error\n");
				} else {
					sb.append("[");
					int size = lst.size();
					if (!isReversed) {
						for (int i = 0; i < size; i++) {
							if (i == size - 1)
								sb.append(lst.pollFirst());
							else
								sb.append(lst.pollFirst()).append(",");
						}
					} else {
						for (int i = 0; i < size; i++) {
							if (i == size - 1)
								sb.append(lst.pollLast());
							else
								sb.append(lst.pollLast()).append(",");
						}
					}
					sb.append("]\n");
				}
			} else { // n == 0
				if (p.contains("D")) {
					sb.append("error\n");
				} else {
					sb.append("[]\n");
				}
			}
		}
		System.out.println(sb);
	}
}
