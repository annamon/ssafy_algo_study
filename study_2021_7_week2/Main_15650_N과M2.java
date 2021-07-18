package study_2021_7_week2;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.07.17
 * @summary 
 * BOJ-silver3  512MB/1s (12900KB/124ms)
 * 1~N 자연수 중 중복없이 M개 고른 수열 전부 출력
 * 오름차순
 * 
 * N,M : (1≤M≤N≤8)
 * isSelected[] : 선택처리
 * 조합
 */
public class Main_15650_N과M2 {

	static int N, M;
    static int[] num;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
        num = new int[M];
		nCr(0, 1);
		scann.close();
	}
	
	//조합
	private static void nCr(int cnt, int start) {
		if(cnt==M) {
			for (int i : num) System.out.print(i+" ");
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
            num[cnt] = i;
			nCr(cnt+1, i+1);
		}
	}

}
