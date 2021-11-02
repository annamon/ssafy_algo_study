package study_2021_11_week1;

import java.util.*;

/**
 * @author anna
 * @date 2021.11.02
 * @summary 
 * BOJ-bronze1  128MB/1s (12900KB/112ms)
 * 피보나치 0,1로 시작
 * 0번째 피보나치 = 0, 1번째 피보나치 = 1
 * n번째 피보나치 구하기
 */
public class Main_2748_피보나치수2 {

	static int N;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		long[] dp = new long[N+1];
		dp[1] = 1;
		if(N>1) dp[2] = 1;
		if(N>2) {
			for (int i = 3; i <= N; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
		}
		System.out.println(dp[N]);
		scann.close();
	}

}
