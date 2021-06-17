package study_2021_6_week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author anna
 * @date 2021.06.17
 * @summary 
 * BOJ-silver1  128MB/1s (11656KB/96ms)
 * 1:집  0:집없음
 * 상하좌우 중 맞닿은 곳이 있으면 연결된 것
 * 단지 수, 단지에 속하는 집의 수 오름차순으로 출력
 * 
 * N : 지도 크기 (≤N≤25)
 * map : 지도
 * complex : 단지 수
 * count : 단지내 집 수
 * house : 현재 단지 집 파악위한 큐
 * complexCnt : 단지내 집 수 정렬 큐
 */
public class Main_2667_단지번호붙이기 {

	static int N;
	static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String now = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = now.charAt(j);
				//o:방문, x:미방문
				if(map[i][j]=='0') map[i][j] = 'o';
				if(map[i][j]=='1') map[i][j] = 'x';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='o') continue; //방문한 곳은 넘어가기
				else {	
					map[i][j] = 'o'; //방문처리
					house.add(new int[] {i,j}); //큐에 방문 시작지점 넣기
					bfs(); //탐색
				}
			}
		}
		System.out.println(complex);
		while(!complexCnt.isEmpty()) {
			System.out.println(complexCnt.poll());
		}
	}
	
	static int complex, count;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	static Queue<int[]> house = new LinkedList<>();
	static PriorityQueue<Integer> complexCnt = new PriorityQueue<>(); 
	private static void bfs() {
		complex++;
		count = 0;
		while(!house.isEmpty()) {
			int r = house.peek()[0];
			int c = house.poll()[1];
			count++;
			//사방탐색
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(check(nr,nc)) { //방문가능한 곳이면 큐에 넣고 방문처리
					house.add(new int[] {nr,nc});
					map[nr][nc] = 'o';
				}
			}
		}
		//단지 조사 끝나면 단지 수 넣기
		complexCnt.add(count);
	}
	
	//방문 가능 범위
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N && map[r][c]=='x';
	}
}
