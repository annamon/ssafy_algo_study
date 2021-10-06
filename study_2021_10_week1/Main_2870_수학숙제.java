package study_2021_10_week1;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.10.06
 * @summary 
 * BOJ-silver4  128MB/1s (KB/ms)
 * 숫자와 알파벳 소문자로 이루어진 글자 N줄
 * 숫자 찾아서 비내림차순 정리
 * 숫자 앞에 0이 있는 경우 생략가능
 * 가장 큰 숫자 찾기
 * 
 * N : 줄 개수, 1~100
 * !!! NumberFormatException
 */
public class Main_2870_수학숙제 {

	static int N;
	static String s;
	static PriorityQueue<Long> number = new PriorityQueue<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			s = s.replaceAll("[a-z]", " ");
			StringTokenizer st = new StringTokenizer(s, " ");
			while(st.hasMoreTokens()) {
				String token = st.nextToken();
				if(token.equals("")) continue;
				number.add(Long.parseLong(token));
			}
		}
		int index = number.size();
		for (int i = 0; i < index; i++) {
			System.out.println(number.poll());
		}
	}

}
