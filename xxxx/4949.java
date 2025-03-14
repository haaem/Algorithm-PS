import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class BJ4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<String> stack;
		String result;
		HashSet<String> preList = new HashSet<String>(Arrays.asList("(", "["));
		HashSet<String> sufList = new HashSet<String>(Arrays.asList(")", "]"));
		String sentence = br.readLine();
		while (!sentence.equals(".")) {
			result = "yes";
			stack = new LinkedList<String>();
			for (int i=0; i<sentence.length(); i++) {
				String c = sentence.substring(i,i+1);
				if (c.equals(".")) {
					if (!stack.isEmpty()) {
						result = "no";
					}
					break;
				}
				if (preList.contains(c)) {
					stack.addLast(c);
				} else if (sufList.contains(c)) {
					if (stack.isEmpty()) {
						result = "no";
						break;
					}
					if (c.equals(")")) {
						if (stack.getLast().equals("(")) {
							stack.pollLast();
						} else {
							result = "no";
							break;
						}
					} else if (c.equals("]")) {
						if (stack.getLast().equals("[")) {
							stack.pollLast();
						} else {
							result = "no";
							break;
						}
					}
				}
			}
			bw.append(result+"\n");
			sentence = br.readLine();
		}
		br.close();
		bw.flush(); bw.close();
	}
}
