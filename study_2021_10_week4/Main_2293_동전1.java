package study_2021_10_week4;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.10.28
 * @summary 
 * BOJ-silver1  4MB/0.5s (11796KB/88ms)
 * n가지 종류의 동전 있음
 * 적당히 사용해서 합이 k원이 되도록 만들기
 * 경우의 수 구하기
 * 
 * n : 1~100
 * k : 1~10,000
 */
public class Main_2293_동전1 {

	static int N, K;
	static int[] coin, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coin = new int[N+1];
		dp = new int[K+1];
		dp[0] = 1;
		for (int i = 1; i <= N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			for (int j = coin[i]; j <= K; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}
		System.out.println(dp[K]);
	}

}
