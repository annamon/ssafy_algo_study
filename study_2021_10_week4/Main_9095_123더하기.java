package study_2021_10_week4;

import java.util.*;

/**
 * @author anna
 * @date 2021.10.26
 * @summary 
 * BOJ-silver3  512MB/1s (12824KB/116ms)
 * n 주어졌을 때 1,2,3의 합으로 나타내는 방법의 수 구하기
 * n : 1~10
 */
public class Main_9095_123더하기 {

	static int T, N;
	static int[] dp;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= 10; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		T = scann.nextInt();
		for (int t = 0; t < T; t++) {
			N = scann.nextInt();
			System.out.println(dp[N]);
		}
		scann.close();
	}

}
