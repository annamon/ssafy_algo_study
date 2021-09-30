package study_2021_9_week5;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.30
 * @summary 
 * BOJ-silver3  128MB/2s (KB/ms)
 * 랜선 N개 만들기
 * K개 랜선 가지고 있는데 길이 제각각
 * 같은 길이로 랜선 자르기
 * 최대 랜선 길이는?
 * 
 * K : 이미 가지고 있는 랜선 개수, 1~10,000
 * N : 필요한 랜선 개수, 1~1,000,000
 * 
 */
public class Main_1654_랜선자르기 {

	static int N, K;
	static long max, min, mid;
	static int[] line;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		line = new int[K];
		for (int i = 0; i < K; i++) {
			line[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, line[i]);
		}
		max++;
		while(min<max) {
			mid = (min+max)/2;
			long count = 0;
			for (int i = 0; i < K; i++) {
				count += line[i]/mid;
			}
			if(count<N) max = mid;
			else min = mid+1;
		}
		System.out.println(min-1);
	}

}
