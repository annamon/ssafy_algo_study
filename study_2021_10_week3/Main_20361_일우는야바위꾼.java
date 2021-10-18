package study_2021_10_week3;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.10.18
 * @summary 
 * BOJ-bronze3  1024MB/2s (37600KB/304ms)
 * N개 컵, X번째에 공 숨김
 * 컵 위치 바꾸기 K번 수행
 * 어느 위치에 있을까?
 * 
 * N : 3~200,000
 * X : 1~N
 * K : 1~100,000
 */
public class Main_20361_일우는야바위꾼 {

	static int N, X, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==X) X=b;
			else if(b==X) X=a;
		}
		System.out.println(X);
	}

}
