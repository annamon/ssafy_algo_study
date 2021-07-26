package study_2021_7_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author anna
 * @date 2021.07.26
 * @summary 
 * BOJ-bronze1  128MB/0.15s (11504KB/76ms)
 * 달팽이가 높이 V미터 막대 오른다
 * 낮에는 A미터 오르고 밤에는 B미터 미끄러짐
 * 막대 올라가려면 며칠 걸리는가
 * 
 * double로 하는 이유: ceil이 double용이다.
 */
public class Main_2869_달팽이는올라가고싶다 {

	static int A, B, V;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken()); 
		V = Integer.parseInt(st.nextToken());
		System.out.println((int)Math.ceil((double)(V-A)/(double)(A-B)) + 1);
	}
}
