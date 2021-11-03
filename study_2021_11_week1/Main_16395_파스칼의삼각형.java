package study_2021_11_week1;

import java.util.*;

/**
 * @author anna
 * @date 2021.11.03
 * @summary 
 * BOJ-bronze1  256MB/1s (12976KB/112ms)
 * N번째 행에는 N개의 수
 * 첫 번쨰 행 1
 * 두 번째 행부터 양 끝은 1, 나머지는 바로ㅗ 위 행의 인접한 두 수의 합
 * N번째 행에 있는 K번째 수 출력 (N,K : 1~30)
 */
public class Main_16395_파스칼의삼각형 {

	static int N, K;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		K = scann.nextInt();
		dp = new int[31][31];
		dp[1][1] = 1;
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if(j==1 || j==i)dp[i][j] = 1;
				else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		System.out.println(dp[N][K]);
		scann.close();
	}

}
