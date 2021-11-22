package study_2021_11_week4;

import java.util.*;
import java.io.*;

/**
 * @author anna
 * @date 2021.11.22
 * @summary 
 * BOJ-silver2  128MB/1s (KB/ms)
 * 두 사람의 촌수 구하기
 * 사람 수 N
 * 촌수 계산해야하는 두 사람의 번호 주어짐
 * 그 다음엔 부모 자식간의 관계 개수 m
 * 관계 줄줄
 * 앞이 부모, 뒤가 자식
 * 계산할 수 없는 경우 -1 출력
 */
public class Main_2644_촌수계산 {

	static int N, A, B;
	static int[][] map;
	static int[] d;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		A = scann.nextInt();
		B = scann.nextInt();
		map = new int[N+1][N+1];
		int M = scann.nextInt();
		for (int i = 0; i < M; i++) {
			int x = scann.nextInt();
			int y = scann.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}
		d = new int[N+1];
		find(A,B);
		if(d[B]==0) System.out.println("-1");
		else System.out.println(d[B]);
	}
	
	private static void find(int start, int end) {
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		while(!que.isEmpty()) {
			int t = que.poll();
			if(t==end) break;
			for (int i = 1; i <= N; i++) {
				if(map[t][i]==1 && d[i]==0) {
					d[i] = d[t]+1;
					que.add(i);
				}
			}
		}
		
	}

}
