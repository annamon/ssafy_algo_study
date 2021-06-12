package study_2021_6_week2;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.12
 * @summary 
 * BOJ-silver1  128MB/2s (24072KB/256ms)
 * 포도주 선택시 다 마시고 원래 위치로
 * 연속 3잔 선택 불가
 * 포도주 양 주어짐
 * 1~n 번호 포도주 선택 (1≤n≤10,000) -> 최대로 마실 수 있는 포도주 양?
 */
public class Main_2156_포도주시식 {

	static int N;
	static int[] wine;
	static int[] choice; //메모
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		wine = new int[N];
		choice = new int[N];
		for (int n = 0; n < N; n++) {
			wine[n] = scann.nextInt();
		}
		//경우 나누기 : N=1,2,3이상
		//N이 1인 경우
		choice[0] = wine[0];
		//N이 2인 경우
		if(N>1) choice[1] = wine[0] + wine[1];
		//N이 3이상인 경우
		if(N>2) {
			//3번째 포도주 선택 최대값 구하기
			choice[2] = Math.max(choice[1], choice[0]+wine[2]); //선택x vs 1,3선택
			choice[2] = Math.max(choice[2], wine[1]+wine[2]); //앞선 결과 vs 2,3선택
			for (int i = 3; i < N; i++) {
				//현재 포도주 선택x(=이전 메모 이어받기) vs OXO(=전전o 전x 현재o)
				choice[i] = Math.max(choice[i-1], choice[i-2]+wine[i]);
				//앞선 선택 vs OXOO(=전전전o 전전x 전o 현재o)
				choice[i] = Math.max(choice[i], choice[i-3]+wine[i-1]+wine[i]);
			}
		}
		System.out.println(choice[N-1]);
	}

}
