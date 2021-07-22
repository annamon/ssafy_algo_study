package study_2021_7_week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author anna
 * @date 2021.07.22
 * @summary 
 * BOJ-silver2  128MB/1s (11556KB/80ms)
 * 지도 RxC
 * X땅 .바다
 * 50년이 지나면 인접한 3 or 4칸에 바다가 있는 땅은 모두 잠긴다.
 * 지도 크기 = 모든 섬을 포함하는 가장 작은 직사각형
 * 
 * R, C : (1≤R,C≤10)
 * map[][] : 원래 지도
 * newmap[][] : 50년 후 지도
 * landcheck[][] : 출력할 지도 범위 체크
 * land : 땅 목록
 * startr, startc, endr, endc : 시작 행, 열 범위
 */
public class Main_5212_지구온난화 {

	static int R, C;
	static char[][] map;
	static char[][] newmap;
	static int[][] landcheck;
	static Queue<int[]> land = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R+2][C+2];
		newmap = new char[R+2][C+2];
		landcheck = new int[Math.max(R+2, C+2)][2];
		for (int i = 1; i <= R; i++) {
			String s = br.readLine();
			for (int j = 1; j <= C; j++) {
				map[i][j] = s.charAt(j-1);
				newmap[i][j] = map[i][j];
				//땅인 곳 저장
				if(map[i][j]=='X') {
					land.add(new int[] {i, j});
					landcheck[i][0]++; //[][0] : 행마다 있는 땅 개수
					landcheck[j][1]++; //[][1] : 열마다 있는 땅 개수
				}
			}
		}
		after();
		print();
	}
	
	//지도 출력
	static int startr, startc, endr, endc;
	private static void print() {
		for (int i = 0; i < landcheck.length; i++) {
			//출력할 행 범위 지정
			if(landcheck[i][0]!=0) {
				if(startr==0) startr = i;
				endr = i;
			}
			//출력할 열 범위 지정
			if(landcheck[i][1]!=0) {
				if(startc==0) startc = i;
				endc = i;
			}
		}
		//지정 범위 지도 출력
		for (int i = startr; i <= endr; i++) {
			for (int j = startc; j <= endc; j++) {
				System.out.print(newmap[i][j]);
			}
			System.out.println();
		}
	}

	//50년 후 지도 만들기
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	private static void after() {
		while(!land.isEmpty()) {
			int r = land.peek()[0];
			int c = land.poll()[1];
			int count = 0;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(check(nr,nc)) count++;
			}
			//3면 이상이 바다인 경우 침수
			if(count>=3) {
				newmap[r][c]='.';
				landcheck[r][0]--;
				landcheck[c][1]--;
			}
		}
	}
	
	//범위 체크
	private static boolean check(int r, int c) {
		return r>=0 && r<R+2 && c>=0 && c<C+2 && map[r][c]!='X';
	}

}
