import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ11387 {
	static long[][] stat = new long[2][5];
	static long[][] weapon = new long[2][5];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				stat[i][j] = Long.parseLong(st.nextToken());
			}
		}
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				weapon[i][j] = Long.parseLong(st.nextToken());
			}
		}
		BigInteger cri = calculate(0);
		BigInteger pabo = calculate(1);

		reverse(0);
		reverse(1);
		equipped(0);
		equipped(1);

		BigInteger finalCri = calculate(0);
		BigInteger finalPabo = calculate(1);
		int res = finalCri.compareTo(cri);
		switch (res) {
		case -1: {
			System.out.println("-");
			break;
		}
		case 0: {
			System.out.println("0");
			break;
		}
		case 1: {
			System.out.println("+");
			break;
		}
		}
		res = finalPabo.compareTo(pabo);
		switch (res) {
		case -1: {
			System.out.println("-");
			break;
		}
		case 0: {
			System.out.println("0");
			break;
		}
		case 1: {
			System.out.println("+");
			break;
		}
		}
	}

	static void reverse(int index) {
		for (int i = 0; i < 5; i++) {
			stat[index][i] -= weapon[index][i];
		}
	}

	static void equipped(int index) {
		for (int i = 0; i < 5; i++) {
			stat[index][i] += weapon[Math.abs(index - 1)][i];
		}
	}

	static BigInteger calculate(int index) {
		long attack = stat[index][0];
		long power = stat[index][1];
		long critStat = stat[index][2];
		long critDamage = stat[index][3];
		long speed = stat[index][4];

		BigInteger val = BigInteger.valueOf(attack);
		val = val.multiply(BigInteger.valueOf(100 + power));
		long critPart = 10000 - 100 * Math.min(100, critStat) + Math.min(100, critStat) * critDamage;
		val = val.multiply(BigInteger.valueOf(critPart));
		val = val.multiply(BigInteger.valueOf(100 + speed));
		return val;
	}
}
