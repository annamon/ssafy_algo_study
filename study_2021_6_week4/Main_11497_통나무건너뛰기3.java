package study_2021_6_week4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.27
 * @summary 
 * BOJ-silver1  256MB/1s (213312KB/1272ms)
 * N개 통나무 원형으로 세우기
 * 인접한 통나무의 높이 차가 최소가 되도록
 * 
 * N : 통나무 개수 (5≤N≤10,000)
 * L : 통나무 높이 (1≤L≤100,000)
 */
public class Main_11497_통나무건너뛰기3 {

	static int T, N, answer;
	static int[] tree;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 0; t < T; t++) {
			N = scann.nextInt();
			tree = new int[N];
			answer = 0;
			for (int i = 0; i < N; i++) {
				tree[i] = scann.nextInt();
			}
			Arrays.sort(tree);
			for (int i = 2; i < N; i++) {
				answer = Math.max(answer, Math.abs(tree[i]-tree[i-2]));
			}
			System.out.println(answer);
		}
		scann.close();
	}

}
