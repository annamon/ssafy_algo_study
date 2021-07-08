package study_2021_7_week1;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.07.08
 * @summary 
 * BOJ-gold5  512MB/1s (15704KB/144ms)
 * 그릇(무게0), 서로 다른 무게의 추 K개
 * 1~S(추 무게 총합) 중 양팔저울로 계산할 수 없는 무게 개수 구하기
 * 
 * K : 추 개수 (3≤k≤13)
 * S : 추 무게 총합
 * weight[] : 추 무게 배열 (1≤weight[i]≤200,000)
 * can[] : 계산 가능 여부 배열
 */
public class Main_17610_양팔저울 {

	static int K, S, answer;
	static int[] weight;
	static boolean[] can;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		K = scann.nextInt();
		weight = new int[K];
		//추 무게 배열, 무게 총합 구하기
		for (int i = 0; i < K; i++) {
			weight[i] = scann.nextInt();
			S += weight[i];
		}
		can = new boolean[S+1];
		//측정 가능 무게 확인하기
		check(0, 0);
		for (int i = 1; i <= S; i++) if(!can[i]) answer++;
		System.out.println(answer);
		scann.close();
	}

	//무게 측정하기
	private static void check(int cnt, int sum) {
		//추 다 고른 경우
		if(cnt==K) {
			if(sum>0) can[sum] = true;
			return;
		}
		check(cnt+1, sum); //추 사용 x
		check(cnt+1, sum + weight[cnt]); //추 그릇 저울에 올리기
		check(cnt+1, sum - weight[cnt]); //추 반대편 저울에 올리기
	}

}
