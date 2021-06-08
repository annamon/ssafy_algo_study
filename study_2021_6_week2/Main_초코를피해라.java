package study_2021_6_week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author anna
 * @date 2021.06.08
 * @summary 
 * 제작문제  256MB/1s (KB/ms)
 * 초코의 활동영역 1초마다 상하좌우 1칸씩 넓어짐
 * 활동영역에서 츄르 발견시 개당 1초 멈춤
 * 교수님 1초마다 상하좌우중 1칸 이동 가능
 * 벽 이동 불가
 * 초코에게 들키지 않고 탈출시 yes 실패시 no
 * 
 * C : 초코 위치
 * M : 교수님 위치
 * * : 츄르
 * X : 벽
 * . : 빈 공간
 * E : 탈출구
 * T : 테스트케이스 수
 * N : 지도 크기
 */
public class Main_초코를피해라 {
	
	static class position {
		int r;
		int c;
		public position() {
			super();
		}
		public position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
	}
	
	static int T, N, chur;
	static String answer;
	static char[][] map;
	static Queue<position> choco, professor;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			choco = new LinkedList<>();
			professor = new LinkedList<>();
			answer = "no";
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
					if(map[i][j]=='C') {
						choco.offer(new position(i, j));
					}
					else if (map[i][j]=='M') {
						professor.offer(new position(i, j));
					}
				}
			}
			run();
			System.out.println("#"+ t + " " + answer);
		}
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	private static void run() {
		// while문 1번 돌기 = 1초
		while(!professor.isEmpty()) {
			if(answer.equals("yes")) return; // 탈출 성공시 종료
			if(chur==0) runChoco();		// 츄르 없으면 초코 영역 확장
			else chur--;				// 츄르 있으면 1초씩 쉬기
			runProfessor();				// 교수님 도망가기
		}
	}
	
	// 교수님 도망가기
	private static void runProfessor() {
		int count = professor.size();
		while(count>0) {			
			position nowProfessor = professor.poll();  // 현재 교수님 위치
			for (int d = 0; d < 4; d++) {			   // 사방탐색
				int nr = nowProfessor.getR() + dr[d];
				int nc = nowProfessor.getC() + dc[d];
				// 이동 가능한 곳인지 체크
				if(check(nr,nc)) {
					if(map[nr][nc]=='E') {	 // 탈출구면 성공
						answer = "yes";
						return;
					}
					else if(map[nr][nc]=='M') continue; // 이미 방문한 곳이면 패스
					else {	// 그 외 경우 방문처리, 큐에 넣기
						map[nr][nc] = 'M';
						professor.offer(new position(nr, nc));
					}
				}
			}
			count--;
		}
	}

	// 초코 영역 확장
	private static void runChoco() {
		int count = choco.size();
		while(count>0) {			
			position nowChoco = choco.poll();
			// 초코 사방탐색
			for (int d = 0; d < 4; d++) {
				int nr = nowChoco.getR() + dr[d];
				int nc = nowChoco.getC() + dc[d];
				// 영역 확장 가능한 곳인지 체크
				if(check(nr,nc)) {
					if(map[nr][nc]=='*') chur++;		// 츄르 발견시 츄르 개수 카운트
					choco.offer(new position(nr, nc));  // 큐에 넣기
					map[nr][nc] = 'C';	// 활동영역 표시
				}
			}
			count--;
		}
	}
	
	// 이동 가능 범위 체크
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N && map[r][c]!='X' && map[r][c]!='C';
	}

}
