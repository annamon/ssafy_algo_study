package study_2021_12_week1;

import java.util.*;

/**
 * @author anna
 * @date 2021.12.06
 * @summary 
 * BOJ-bronze2  256MB/1s (12856KB/116ms)
 * N개의 숫자 합 출력
 */
public class Main_11720_숫자의합 {

	static String S;
	static int N, answer;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		S = scann.next();
		for (int i = 0; i < N; i++) {
			answer += (int)(S.charAt(i))-48;
		}
		System.out.println(answer);
	}

}
