import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ7785 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		TreeSet<String> attend = new TreeSet<String>(Collections.reverseOrder());
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String come = st.nextToken();
			if (come.equals("enter")) {
				attend.add(name);
			} else {
				attend.remove(name);
			}
		}
		Iterator<String> iterator = attend.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
