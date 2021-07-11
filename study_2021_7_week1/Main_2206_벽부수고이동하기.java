package study_2021_7_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author anna
 * @date 2021.07.11
 * @summary 
 * BOJ-gold4  192MB/2s (105720KB/536ms)
 * NxM 맥, 0 이동가능, 1 벽
 * 1,1에서 NxM으로 이동
 * 벽 1개 부수기 가능
 * 최단 거리 출력, 도착 불가시 -1 출력
 * 
 * N, M : 맵 크기 (1≤ N,M ≤1,000)
 * map[][] : 맵
 * visited[][] : 벽 부수기 불가능 경우 방문 처리
 * visitedB[][] : 벽 부수기 가능 방문 처리
 */
public class Main_2206_벽부수고이동하기 {

	static int N, M, answer=Integer.MAX_VALUE;
	static char[][] map;
	static boolean[][] visited, visitedB;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		visitedB = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		visited[0][0]= true;
		visitedB[0][0]= true;
		run();
		if(answer==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	static Queue<int[]> que = new LinkedList<>();
	private static void run() {
		//r,c,bomb,count
		que.add(new int[] {0,0,1,1});
		while(!que.isEmpty()) {
			int r = que.peek()[0];
			int c = que.peek()[1];
			int bomb = que.peek()[2];
			int count = que.poll()[3];
			//도착한 경우
			if(r==N-1 && c==M-1) {
				answer = count;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				//이동 가능 체크
				if(check(nr,nc)) {
					//벽 부수기 불가능
					if(bomb==0) {
						//벽o
						if(map[nr][nc]=='1') continue;
						//벽x, 방문한 적x
						if(map[nr][nc]=='0' && !visited[nr][nc]) {
							visited[nr][nc]=true;
							que.add(new int[] {nr,nc,bomb,count+1});
						}
					}
					//벽 부수기 가능
					else {
						//벽o
						if(map[nr][nc]=='1') {
							if(!visitedB[nr][nc]) { //방문한 적 없는 경우
								visitedB[nr][nc]=true; //벽 부수고 방문처리
								que.add(new int[] {nr,nc,0,count+1});
							}
						}
						//벽x
						else {
							if(!visitedB[nr][nc]) { //방문한 적 없는 경우
								visitedB[nr][nc] = true; //방문처리
								que.add(new int[] {nr,nc,bomb,count+1});
							}
						}
					}
				}
			}
		}
	}
	
	//범위체크
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
