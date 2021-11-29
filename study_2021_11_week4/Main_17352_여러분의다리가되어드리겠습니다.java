package study_2021_11_week4;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.11.29
 * @summary 
 * BOJ-gold5  512MB/1s (KB/ms)
 * 섬 1~N개
 * 다리로 이을 두 섬의 번호 출력하기
 * 여러 방법인 경우 하나만 출력
 * 
 */
public class Main_17352_여러분의다리가되어드리겠습니다 {

	static int N, a, b;
	static boolean[] island;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		island = new boolean[N+1];
		for (int n = 0; n < N-2; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			island[Integer.parseInt(st.nextToken())] = true;
			island[Integer.parseInt(st.nextToken())] = true;
		}
		for (int i = 1; i <= N; i++) {
			if(!island[i]) {
				if(a==0) a = i;
				else b = i;
			}
		}
		if(a==0 && b==0) System.out.println("1 2");
		else if(b==0) {
			if(a>1) System.out.println(a + " " + (a-1));
			else System.out.println(a + " " + (a+1));
		}
		else {
			System.out.println(a + " " + b);
		}
	}

}
