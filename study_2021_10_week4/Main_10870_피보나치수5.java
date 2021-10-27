package study_2021_10_week4;

import java.util.*;

/**
 * @author anna
 * @date 2021.10.18
 * @summary 
 * BOJ-bronze2  256MB/1s (12820KB/112ms)
 * 피보나치 수
 * 0번째 : 0
 * 1번째 : 1
 * 그 이후 : 앞 두 수의 합
 * n번째 피보나치 수 구하기
 */
public class Main_10870_피보나치수5 {

	static int N;
	static int[] dp;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		dp = new int[N+1];
		dp[0] = 0;
		if(N>0) dp[1] = 1;
		if(N>1) {
			for (int i = 2; i <= N; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
		}
		System.out.println(dp[N]);			
		scann.close();
	}

}
