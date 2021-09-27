package study_2021_9_week3;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.20
 * @summary 
 * BOJ-gold3  192MB/2s (136092KB/248ms)
 * 두 섬 잇는 다리 하나만 만들기, 가장 짧게
 * NxN 섬 여러개
 * 0 바다 1 육지
 * 
 * N : 지도 크기, 1~100
 */
public class Main_2146_다리만들기 {

	static int N, answer = Integer.MAX_VALUE;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//지도
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//섬 구분하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					island(i,j);
					landIndex++;
				}
			}
		}
		//다리 놓기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]!=0) {
					make(i, j);
				}
			}
		}
		//최소 다리 길이 출력
		System.out.println(answer);
	}
	

	//섬 구분하기
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	static Queue<int[]> land = new LinkedList<>();
	static int landIndex = 2;
	private static void island(int a, int b) {
		land.add(new int[] {a, b});
		map[a][b] = landIndex;
		while(!land.isEmpty()) {
			int r = land.peek()[0];
			int c = land.poll()[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(check(nr, nc)) {
					//이어진 땅인 경우 섬 구분
					if(map[nr][nc]==1) {
						map[nr][nc] = landIndex;
						land.add(new int[] {nr, nc});
					}
				}
			}
		}
	}

	//다리만들기
	static boolean[][] isVisited;
	private static void make(int a, int b) {
		isVisited = new boolean[N][N];
		land.clear();
		land.add(new int[] {a, b, 0});
		int nowLand = map[a][b]; //현재 섬 번호
		while(!land.isEmpty()) {
			int r = land.peek()[0];
			int c = land.peek()[1];
			int count = land.poll()[2];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(check(nr, nc)) {
					//방문한적 없고 바다인 경우 다리 놓기
					if(!isVisited[nr][nc] && map[nr][nc]==0) {
						land.add(new int[] {nr, nc, count+1});
						isVisited[nr][nc] = true;
					}
					//방문한적 없고 다른 섬인 경우 다리 완성
					else if(!isVisited[nr][nc] && map[nr][nc]!=nowLand) {
						answer = Math.min(answer, count);
						return;
					}
					//그 외 경우
					else continue;
				}
			}
		}
	}
	
	//범위 체크
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
