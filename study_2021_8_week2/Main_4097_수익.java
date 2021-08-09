package study_2021_8_week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author anna
 * @date 2021.08.10
 * @summary 
 * BOJ-silver2  256MB/1s (80696KB/464ms)
 * 창업한지 N일, 매일 수익 기록
 * 가장 돈을 많이 번 구간 -> 금액 구하기
 * 마지막 입력에 0 -> 종료
 * 
 * N : 날짜, 1~250,000
 * P[] : 그 날의 수익 -10,000~10,000
 */
public class Main_4097_수익 {

	static int N, answer;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			N = Integer.parseInt(br.readLine());
			//입력 0인 경우 종료
			if(N==0) break;
			dp = new int[N];
			//1일차 기록
			dp[0] = Integer.parseInt(br.readLine());
			answer = dp[0];
			//그 후 기록
			for (int i = 1; i < N; i++) {
				int num = Integer.parseInt(br.readLine());
				//어제까지의 최고 수익 + 오늘의 수익 vs 오늘의 수익
				dp[i] = Math.max(dp[i-1]+num, num);
				answer = Math.max(dp[i], answer); //최대값 갱신
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
