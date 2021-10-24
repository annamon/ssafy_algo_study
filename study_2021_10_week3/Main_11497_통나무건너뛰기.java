package study_2021_10_week3;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.10.24
 * @summary 
 * BOJ-silver1  256MB/1s (49864KB/432ms)
 * 통나무 원형으로 세우기
 * 인접한 통나무 높이 차 최소가 되도록
 * 난이도 = 인접한 두 통나무 간 놈이 차의 최댓값
 * 
 * T : 테스트케이스 수
 * N : 통나무 개수 5~10,000
 *
 */
public class Main_11497_통나무건너뛰기 {
	
	static int T, N;
	static int[] tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			tree = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(tree);
			int answer = 0;
			for (int i = 2; i < N; i++) {
				answer = Math.max(answer, Math.abs(tree[i]-tree[i-2]));
			}
			System.out.println(answer);
		}
	}

}
