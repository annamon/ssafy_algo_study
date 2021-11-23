package study_2021_11_week4;

import java.io.*;

/**
 * @author anna
 * @date 2021.11.23
 * @summary 
 * BOJ-bronze1  128MB/1s (11300KB/76ms)
 * 뒤에서부터 읽어도 똑같다면~ 팰린드롬
 * 무의미한 0이 앞에 올 수 없다.
 * 마지막줄 0이면 끝!
 * 팰린드롬수이면 yes, 아니면 no 출력
 */
public class Main_1259_팰린드롬수 {

	static String s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			s = br.readLine();
			if(s.equals("0")) break;
			int L = 0;
			int R = s.length()-1;
			boolean right = true;
			while(L<R) {
				if(s.charAt(L)!=s.charAt(R)) {
					System.out.println("no");
					right = false;
					break;
				}
				L++;
				R--;
			}
			if(right) System.out.println("yes");
		}
	}

}
