package study_2021_9_week5;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.28
 * @summary 
 * BOJ-silver3  256MB/1s (175256KB/860ms)
 * 높이 H 나무 자르기
 * 자른 토막 가져감, H 최대?
 * 
 * N : 나무 수 1~1,000,000
 * M : 원하는 나무 길이 1~2,000,000,000
 */
public class Main_2805_나무자르기 {

	static int N, M;
	static int[] tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);
		long left = 0;
		long right = tree[N-1];
		//나무 자르기
		while(left <= right) {
			long mid = (left+right)/2;
			long sum = 0;
			for(int t : tree) {
				if(t > mid) {
					sum += t - mid;
				}
				//자른 나무 총합이 원하는 값보다 큰 경우 종료
				if(sum>M) break;
			}
			//높이 조정
			if(sum>=M) left = mid+1;
			else right = mid-1;
		}
		System.out.println(right);
	}

}
