package study_2021_10_week2;

import java.util.*;

/**
 * @author anna
 * @date 2021.10.12
 * @summary 
 * BOJ-silver3  256MB/1s (12864KB/112ms)
 * 2xn 직사각형을 1x2, 2x1 타일로 채우는 방법의 수 구하기
 * 
 * N : 1~1,000
 */
public class Main_11726_2xn타일링 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int n = scann.nextInt();
		int[] dp = new int[n+1];
		dp[1] = 1;
		if(n>=2) {
			dp[2] = 2;
			for (int i = 3; i <= n; i++) {
				dp[i] = (dp[i-1]+dp[i-2])%10007;
			}
		}
		System.out.println(dp[n]);
		
	}

}
