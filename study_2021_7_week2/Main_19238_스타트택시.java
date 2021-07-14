package study_2021_7_week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author anna
 * @date 2021.07.14
 * @summary 
 * BOJ-gold4  512MB/1s (19238KB/160ms)
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
 * map[] : NxN 배열, 0:빈칸, 1:벽, 2이상:손님
 * me : 현재 택시 위치 정보
 * next : 현재 손님 위치, 목적지 정보
 * customer : 손님 리스트
 * cnt : 남은 손님 수
 * min : 가장 가까운 손님까지의 거리
 * visited[][] : 방문처리
 * goTo : 택시 이동 큐
 * nextList : 가장 가까운 손님 목록
 * arrive : 목적지로 갈 수 있는가
 * 
 * 시간초과 해결
 */
public class Main_19238_스타트택시 {

	static class place implements Comparable<place>{
		int fromR, fromC, toR, toC, distance;
		public place(int fromR, int fromC) {
			super();
			this.fromR = fromR;
			this.fromC = fromC;
		}
		public place(int fromR, int fromC, int distance) {
			super();
			this.fromR = fromR;
			this.fromC = fromC;
			this.distance = distance;
		}
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
	
	static int N, M, oil;
	static int[][] map;
	static place me, next;
	static List<place> customer = new ArrayList<>();
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
		me = new place(0,0); //초기화
		st = new StringTokenizer(br.readLine(), " ");
		me.fromR = Integer.parseInt(st.nextToken());
		me.fromC = Integer.parseInt(st.nextToken());
		int number = 2; //손님 정보 저장 위해 2부터 시작
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			customer.add(new place(r, c,
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0));
			map[r][c] = number; //지도에 손님 표시
			number++;
		}
		run();
		System.out.println(oil);
	}
	
	static int cnt;
	private static void run() {
		cnt = M; //남은 손님 수
		while(cnt>0) {
			whoIsNext(); //가장 가까운 손님 찾기
			//거리 동일한 손님이 여러 명 존재할 수 있다.
			//여러명인 경우 가장 가깝고, 행 빠르고, 열 빠른 손님 태우기
			Collections.sort(nextList);
			next = nextList.get(0);
			//손님 위치 도착
			oil -= next.distance;
			map[next.fromR][next.fromC] = 0;
			if(oil<0) end(); //기름체크
			go();  //목적지 이동
			cnt--; //남은 손님 수 줄이기
		}
	}

	//손님 태우기
	static int min;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	static Queue<place> goTo = new LinkedList<>();
	static List<place> nextList = new ArrayList<>();
	private static void whoIsNext() {
		min = 99999;
		visited = new boolean[N+1][N+1];
		nextList.clear();
		goTo.clear();
		goTo.add(new place(me.fromR, me.fromC, 0)); //현재 택시 위치
		while(!goTo.isEmpty()) {
			place nowMe = goTo.poll();
			//현재 기준 가장 가까운 승객까지의 거리보다 멀리 가면 종료
			if(nowMe.distance>min) break;
			//현재 기준 가장 가까운 승객까지의 거리와 같거나 가까운 손님 발견시
			if(map[nowMe.fromR][nowMe.fromC]>1) {
				//누가 더 가까운지 체크
				min = Math.min(min, nowMe.distance);
				//리스트 index 값 = map에 표시해둔 값-2
				int index = map[nowMe.fromR][nowMe.fromC]-2;
				//거리 정보 저장해서 가장 가까운 손님 목록에 추가
				place n = customer.get(index);
				n.distance = nowMe.distance;
				nextList.add(n);
			}
			//손님 미발견시 사방탐색
			else {				
				for (int d = 0; d < 4; d++) {
					int nr = nowMe.fromR + dr[d];
					int nc = nowMe.fromC + dc[d];
					if(check(nr,nc) && !visited[nr][nc]) {
						visited[nr][nc] = true; //방문처리
						goTo.add(new place(nr, nc, nowMe.distance+1));
					}
				}
			}
		}
		//태울 수 있는 손님이 없는 경우 종료
		if(nextList.isEmpty()) end();
	}
	
	//목적지로 이동하기
	static boolean arrive;
	private static void go() {
		arrive = false;
		visited = new boolean[N+1][N+1];
		goTo.clear();
		//현재 손님 태운 위치에서 시작
		goTo.add(new place (next.fromR, next.fromC, 0));
		while(!goTo.isEmpty()) {
			place nowGo = goTo.poll();
			//목적지에 도착한 경우
			if(nowGo.fromR == next.toR && nowGo.fromC == next.toC) {
				//택시 위치 갱신
				me.fromR = next.toR;
				me.fromC = next.toC;
				oil -= nowGo.distance; //이동시 소모된 연료 계산
				if(oil<0) end(); //이동중 연료 소진인 경우 종료
				oil += nowGo.distance*2; //연료 충전
				arrive = true; //도착 성공
				break;
			}
			//도착하지 못 한 경우 사방탐색
			for (int d = 0; d < 4; d++) {
				int nr = nowGo.fromR + dr[d];
				int nc = nowGo.fromC + dc[d];
				if(check(nr,nc) && !visited[nr][nc]) {
					visited[nr][nc] = true; //방문처리
					goTo.add(new place(nr, nc, nowGo.distance+1));
				}
			}
		}
		//택시로 갈 수 없는 목적지인 경우 종료
		if(!arrive) end();
	}

	//이동 가능한 배열 범위 체크
	private static boolean check(int r, int c) {
		return r>=1 && r<=N && c>=1 && c<=N && map[r][c]!=1;
	}

	//종료 메소드
	private static void end() {
		System.out.println(-1);
		System.exit(0);
	}
}
