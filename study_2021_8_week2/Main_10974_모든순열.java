package study_2021_8_week2;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.08.13
 * @summary 
 * BOJ-silver3  256MB/1s (24328KB/268ms)
 * n 모든 수열 구하기
 * n : 1~8
 */
public class Main_10974_모든순열 {

	static int N;
	static int[] num;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		num = new int[N];
		isSelected = new boolean[N];
		nPr(0);
		System.out.println(sb);
	}
	
	private static void nPr(int cnt) throws Exception {
		if(cnt==N) {
			for(int i : num) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			num[cnt] = i+1;
			isSelected[i] = true;
			nPr(cnt+1);
			isSelected[i] = false;
		}
	}
}
