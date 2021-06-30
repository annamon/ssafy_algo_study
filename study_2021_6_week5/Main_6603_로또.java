package study_2021_6_week5;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.30
 * @summary 
 * BOJ-silver2  128MB/1s (19288KB/340ms)
 * 49가지 수 중 k개 골라 집합 S만들기
 * 집합S의 수만 가지고 번호 6개 선택하기
 * S, k 주어졌을 때 수 고르는 모든 방법 출력
 * 입력이 0인 경우 종료
 * 
 * K : (6<k<13)
 * S[] : 집합, 오름차순
 * lotto[] : 6가지 번호 고른 것
 */
public class Main_6603_로또 {

	static int K;
	static int[] S, lotto;
	public static void main(String[] args) {
	Scanner scann = new Scanner(System.in);
		while(true) {
			K = scann.nextInt();
			if(K==0) break; //0인경우 종료
			S = new int[K];
			lotto = new int[6];
			for (int i = 0; i < K; i++) {
				S[i] = scann.nextInt();
			}
			choice(0, 0);
			System.out.println();
		}
		scann.close();
	}
	private static void choice(int start, int cnt) {
		//로또 숫자 6개 다 고르면 출력
		if(cnt==6) {
			for(int a : lotto) System.out.print(a+" ");
			System.out.println();
			return;
		}
		//조합 숫자 6개 고르기
		for (int i = start; i < S.length; i++) {
			lotto[cnt] = S[i];
			choice(i+1, cnt+1);
		}
	}

}
