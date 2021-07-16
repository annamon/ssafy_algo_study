package study_2021_7_week2;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.07.16
 * @summary 
 * BOJ-silver3  512MB/1s (59332KB/2136ms)
 * 1~N 자연수 중 중복없이 M개 고른 수열 전부 출력
 * 사전순으로 증가
 * 
 * N,M : (1≤M≤N≤8)
 * num[] : M개 고른 수열
 * isSelected[] : 선택처리
 */
public class Main_15649_N과M1 {

	static int N, M;
	static boolean[] isSelected;
	static int[] num;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		isSelected = new boolean[N+1];
		num = new int[M];
		nPr(0);
		scann.close();
	}
	
	//수열 코드
	private static void nPr(int cnt) {
		//M개 다 고른 경우 출력
		if(cnt==M) {
			for(int i:num) System.out.print(i+" ");
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			num[cnt] = i;
			isSelected[i] = true;
			nPr(cnt+1);
			isSelected[i] = false;
		}
	}

}
