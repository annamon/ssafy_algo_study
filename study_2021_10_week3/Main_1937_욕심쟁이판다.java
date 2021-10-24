package study_2021_10_week3;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.10.24
 * @summary 
 * BOJ-gold3  256MB/2s (40424KB/452ms)
 * NxN 대나무숲
 * 대나무 다 먹으면 상하좌우 중 한 곳으로 판다 이동
 * 이동하는 곳이 이전보다 대나무 많아야함
 * 어느 곳에 처음 풀어둘지, 최대한 많은 칸 방문할지
 * 
 * N : 대나무 숲 크기 1~500
 * 
 */
public class Main_1937_욕심쟁이판다 {
	
	static int N, answer;
	static int[][] map;
	static int[][] step;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		step = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer = Math.max(answer, move(i,j));
			}
		}
		System.out.println(answer);
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	private static int move(int r, int c) {
		if(step[r][c]!=0) {
			return step[r][c];
		}
		step[r][c] = 1;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(check(nr,nc)) {
				if(map[nr][nc]>map[r][c]) {
					step[r][c] = Math.max(step[r][c], move(nr,nc)+1);
				}
			}
		}
		return step[r][c];
	}
	
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
