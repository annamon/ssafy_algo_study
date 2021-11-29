package study_2021_11_week4;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.11.29
 * @summary 
 * BOJ-gold5  512MB/1s (90080KB/584ms)
 * 섬 1~N개
 * 다리로 이을 두 섬의 번호 출력하기
 * 여러 방법인 경우 하나만 출력
 * 
 * N : 2~300,000
 */
public class Main_17352_여러분의다리가되어드리겠습니다 {

	static int N;
	static int[] island;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//유니온파인드 부모
		island = new int[N+1];
		for (int i = 1; i <= N; i++) {
			island[i] = i;
		}
		//다리 잇기
		for (int n = 0; n < N-2; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		//연결확인
		for (int i = 2; i <= N; i++) {
			if(!isConnect(1, i)) {
				System.out.println(1 + " " + i);
				break;
			}
		}
	}
	
	//두 섬 대표 통합
	private static void union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		if(parentX != parentY) island[parentY] = island[parentX];
		return;
	}

	//연결 확인
	private static boolean isConnect(int x, int y) {
		return find(x)==find(y);
	}
	
	//대표 찾기
	private static int find(int x) {
		if(x==island[x]) return island[x];
		else return island[x] = find(island[x]);
	}
}
