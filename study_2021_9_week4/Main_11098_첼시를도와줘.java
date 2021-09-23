package study_2021_9_week4;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.23
 * @summary 
 * BOJ-bronze1  256MB/1s (15896KB/136ms)
 * 가장 비싼 선수 = 가장 좋은 선수
 * 선수 가격 C, 이름
 * 모든 선수 가격 서로 다르다.
 * 선수 이름은 20자 이하, 사이에 공백 있어서는 안 됨
 * 가장 비싼 선수 이름 출력
 * 
 * n : 테스트케이스 수, 1~100
 * p : 고려해야할 선수 수, 1~100
 */
public class Main_11098_첼시를도와줘 {

	static int N, P, max;
	static String answer;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			P = Integer.parseInt(br.readLine());
			max = 0;
			for (int p = 0; p < P; p++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken());
				if(c > max) {
					String name = st.nextToken();
					//이름이 20자보다 길거나 공백이 있는 경우 제외
					if(name.length()>20) continue;
					if(name.contains(" ")) continue;
					max = c;
					answer = name;
				}
			}
			System.out.println(answer);
		}
	}

}
