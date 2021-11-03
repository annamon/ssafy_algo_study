package study_2021_10_week4;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.10.31
 * @summary 
 * BOJ-gold5  512MB/1s (KB/ms)
 * 두 용액 섞어 0에 가깝게 만들기
 * 가장 가까운 수 구하기
 * 
 * N : 용액 종류, 2~100,000
 */
public class Main_14921_용액합성하기 {

	static int N, L, R, answer = Integer.MAX_VALUE;
	static int[] liquid;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		liquid = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(liquid);
		for (int i = 0; i < N; i++) {
			L = i;
			R = N-1;
			while(true) {
				if(L==R) break;
//				System.out.println(L +" "+ R);
				if(Math.abs(liquid[L]+liquid[R])<Math.abs(answer)) {
					answer = liquid[L] + liquid[R];
				}
				R--;
			}
		}
		System.out.println(answer);
	}

}
