package study_2021_7_week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author anna
 * @date 2021.07.14
 * @summary 
 * BOJ-gold4  512MB/1s (KB/ms)
 * NxN 맵
 * 승객 M명, 한 명씩 태워 목적지로 이동하기
 * 승객 고르는 기준 : 최단 거리가 가장 짧은 승객
 * 중복되는 경우 행 번호, 열 번호 작은 순으로 먼저
 * 이동시 연료 1 소모, 목적지 도착시 소모한 연료의 2배 충전
 * 이동중 연료 바닥나는 경우 영업 종료
 * 
 * N : 2≤N≤20
 * M : 1≤M≤N2
 * oil : 초기 연료, 1≤oil≤500,000
 * 시간초과 미해결
 */
public class Main_19238_스타트택시 {

	static int N, M, oil;
	static int[][] map;
	static place me, next;
	static List<place> customer = new ArrayList<>();
	static class place implements Comparable<place>{
		int fromR, fromC, toR, toC, distance;
		public place(int fromR, int fromC, int toR, int toC, int distance) {
			super();
			this.fromR = fromR;
			this.fromC = fromC;
			this.toR = toR;
			this.toC = toC;
			this.distance = distance;
		}
		@Override
		public int compareTo(place o) {
			int d = this.distance - o.distance;
			if(d==0) {
				int r = this.fromR - o.fromR;
				return r==0? this.fromC - o.fromC : r;
			}
			else return d;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		oil = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		me = new place(0,0,0,0,0);
		st = new StringTokenizer(br.readLine(), " ");
		me.fromR = Integer.parseInt(st.nextToken());
		me.fromC = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			customer.add(new place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0));
		}
		run();
		System.out.println(oil);
		
	}
	
	private static void run() {
		while(!customer.isEmpty()) {
			whoIsNext();
			Collections.sort(customer);
			next = customer.get(0);
			oil -= next.distance;
			checkOil();
			go();
		}
	}

	private static void checkOil() {
		if(oil<0) {
			System.out.println(-1);
			System.exit(0);
		}
	}

	static Queue<int[]> goTo = new LinkedList<>();
	private static void go() {
		visited = new boolean[N+1][N+1];
		goTo.clear();
		goTo.add(new int[] {next.fromR, next.fromC, 0});
		while(!goTo.isEmpty()) {
			int[] nowGo = goTo.poll();
			if(nowGo[0] == next.toR && nowGo[1] == next.toC) {
				me.fromR = next.toR;
				me.fromC = next.toC;
				oil -= nowGo[2];
				checkOil();
				oil += nowGo[2]*2;
				customer.remove(0);
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = nowGo[0] + dr[d];
				int nc = nowGo[1] + dc[d];
				if(check(nr,nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					goTo.add(new int[] {nr, nc, nowGo[2]+1});
				}
			}
		}
	}

	static int min;
	static boolean canGo;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	static Queue<int[]> checkD = new LinkedList<>();
	private static void whoIsNext() {
		for (int i = 0; i < customer.size(); i++) {
			canGo = false;
			visited = new boolean[N+1][N+1];
			min = 9999;
			checkD.clear();
			place nowCustomer = customer.get(i); //손님
			checkD.add(new int[] {me.fromR, me.fromC, 0}); //택시위치
			while(!checkD.isEmpty()) {
				int[] nowMe = checkD.poll();
				if(nowMe[0] == nowCustomer.fromR && nowMe[1]==nowCustomer.fromC) {
					customer.get(i).distance = nowMe[2];
					canGo = true;
					min = Math.min(min, nowMe[2]);
					break;
				}
				for (int d = 0; d < 4; d++) {
					int nr = nowMe[0] + dr[d];
					int nc = nowMe[1] + dc[d];
					if(check(nr, nc) && !visited[nr][nc]){
						if(nowMe[2]+1 > min) continue;
						visited[nr][nc] = true;
						checkD.add(new int[] {nr, nc, nowMe[2]+1});
					}
				}
			}
		}
		if(!canGo) {
			System.out.println(-1);
			System.exit(0);
		}
	}

	private static boolean check(int r, int c) {
		return r>=1 && r<=N && c>=1 && c<=N && map[r][c]==0;
	}

}

