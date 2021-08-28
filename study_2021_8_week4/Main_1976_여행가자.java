package study_2021_8_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author anna
 * @date 2021.08.28
 * @summary 
 * BOJ-gold4  128MB/2s (15864KB/156ms)
 * 도시 N개, 도시간에 길 있을수도 없을수도
 * 여행 일정 주어졌을 때 가능한 경로인지 알아보자.
 * 같은 도시 여러 번 방문 가능
 * 1 연결, 0 연결x, 양방향, 도시 번호 1~N
 * 경로 가능시 YES, 불가능시 NO 출력
 * 
 * N : 200이하
 * M : 여행 계획에 속한 도시 수, 1000이하
 * map[][] : 도시 연결 정보
 * parent[] : 대표 정보
 * route[] : 이동 경로
 */
public class Main_1976_여행가자 {

	static int N, M;
	static int[][] map;
	static int[] parent, route;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		//각 도시별 대표 설정
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		//도시 연결 정보
		map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) union(i,j); //대표 통합
			}				
		}
		//이동 경로
		route = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
		//이동 경로 연결 확인
		for (int i = 0; i < M-1; i++) {
			if(!isConnect(route[i], route[i+1])) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}
	
	//두 도시 대표 통합
	private static void union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		if(parentX!=parentY) parent[parentY] = parentX;
		return;
	}

	//연결 확인
	private static boolean isConnect(int x, int y) {
		return find(x)==find(y);
	}

	//대표 찾기
	private static int find(int x) {
		if(x==parent[x]) return parent[x];
		else return parent[x] = find(parent[x]);
	}

}
