package study_2021_11_week5;

import java.util.*;
import java.io.*;

/**
 * @author anna
 * @date 2021.12.05
 * @summary 
 * BOJ-gold4  128MB/1s (KB/ms)
 * 기관차 고장시 소형 기관차 3대 출동
 * 소형 기관차가 끌 수 있는 객차 수 미리 정하기
 * 3대는 같은 객차 수 끌고가기 가능
 * 최대한 많은 손님 목적지까지
 * 다른 객차로 손님 이동 불가
 * 번호가 연속적으로 이어진 객차 끌기
 * 
 * N : 객차 수 ~50,000
 */
public class Main_2616_소형기관차 {

	static int N, K, answer;
	static int[] train, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		train = new int[N];
		for (int i = 0; i < N; i++) {
			train[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N];
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < N-K; i++) {
			for (int j = 0; j < K; j++) {
				dp[i] += train[i+j];
			}
		}
		Arrays.sort(dp);
		for (int i = 0; i < K; i++) {
			answer += dp[N-1-i];
		}
		System.out.println(answer);
	}

}
