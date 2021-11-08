package study_2021_11_week1;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.11.07
 * @summary 
 * BOJ-gold4  512MB/1s (KB/ms)
 * 맨처음 모든 바이러스 비활성상태
 * 활성 : 4방 빈 칸 동시복제, 1초
 * 바이러스 M개 활성상태로 변경 원함
 * 연구소 크기 NxN, 빈 칸0, 벽1, 바이러스2로 이루어짐
 * 활성바이러스가 비활성바이러스 칸으로 가면 비활성이 활성으로 변함
 * 
 * N : 4~50
 * M : 1~10
 */
public class Main_17142_연구소3 {

	static int N, M, answer = Integer.MAX_VALUE;
	static List<int[]> list;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		list = new ArrayList<>();
		List<int[]> choice = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					list.add(new int[] {i,j});
				}
			}
		}
		nCr(0, 0, choice);
		if(!flag) System.out.println(-1);
		else System.out.println(answer);
	}
	
	private static void nCr(int cnt, int start, List<int[]> choice) {
		if(cnt==M) {
			virus(choice);
			return;
		}
		for (int i = start; i <= list.size(); i++) {
			choice.add(list.get(i));
			nCr(cnt+1, i+1, choice);
		}
	}

	static Queue<int[]> que;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	static boolean[][] visited;
	static boolean flag;
	private static void virus(List<int[]> choice) {
		visited = new boolean[N][N];
		que = new LinkedList<>();
		for (int i = 0; i < choice.size(); i++) {
			que.add(new int[] {choice.get(i)[0], choice.get(i)[1], 0});
		}
		int t = 0;
		while(que.isEmpty()) {
			int r = que.peek()[0];
			int c = que.peek()[1];
			int time = que.poll()[2];
			t = Math.max(answer, time);
			visited[r][c] = true;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(check(nr,nc)) {
					if(!visited[nr][nc]) {
						visited[nr][nc] = true;
						if(map[nr][nc]!=1) {
							que.add(new int[] {nr, nc, time+1});
						}
					}
				}
			}
		}
		boolean pass = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]!=1 && !visited[i][j]) {
					pass = false;
					break;
				}
			}
		}
		if(pass) {			
			answer = Math.min(answer, t);
			flag = true;
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	

}
