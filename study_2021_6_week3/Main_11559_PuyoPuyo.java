package study_2021_6_week3;

import java.util.*;

/**
 * @author anna
 * @date 2021.06.18
 * @summary 
 * BOJ-gold5  256MB/1s (12828KB/108ms)
 * 필드 12x6
 * 뿌요 R G B P Y / 빈칸 .
 * 뿌요 아래로 떨어짐 (바닥/뿌요 나올때까지)
 * 뿌요 4개 이상 상하좌우 연결 시 삭제 - 1연쇄
 * 4개 이상 뿌요 그룹이 여러 개일 경우 동시에 삭제
 * 연쇄 몇 번?
 * 
 * count : 연쇄 횟수
 * field : 뿌요뿌요 맵
 * visited : 방문처리
 * puyos : 뿌요 bfs 큐
 * delete : 뿌요 터트릴 큐
 */
public class Main_11559_PuyoPuyo {

	static int count;
	static char[][] field;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		field = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String st = scann.next();
			for (int j = 0; j < 6; j++) {
				field[i][j] = st.charAt(j);
			}
		}
		puyo();
		System.out.println(count);
	}
	
	static Queue<int[]> puyos = new LinkedList<>();
	static Queue<int[]> delete = new LinkedList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	private static void puyo() {
		boolean yesBomb; //이번 판에 터트릴 것인지
		while(true) {
			visited = new boolean[12][6];
			yesBomb = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					//빈칸이거나 방문한 적 있는 뿌요 패스
					if(field[i][j]=='.' || visited[i][j]) continue;
					else {
						puyos.clear();
						delete.clear();
						//탐색큐와 삭제큐에 넣기
						puyos.add(new int[] {i,j});
						delete.add(new int[] {i,j});
						//방문처리
						visited[i][j] = true;
						while(!puyos.isEmpty()) {
							int r = puyos.peek()[0];
							int c = puyos.poll()[1];
							//사방탐색
							for (int d = 0; d < 4; d++) {
								int nr = r + dr[d];
								int nc = c + dc[d];
								//이어진 같은 뿌요의 경우
								if(check(nr,nc, field[i][j])) {
									puyos.add(new int[]{nr,nc});
									delete.add(new int[]{nr,nc});
									visited[nr][nc] = true;
								}
							}
						}
						//이어진 뿌요가 4개 이상인 경우
						if(delete.size()>=4) {
							yesBomb = true;
							bomb();
						}
						//이어진 뿌요가 4개 미만인 경우 처음 탐색한 뿌요 방문처리 취소
						else { 
							visited[i][j] = false; 
						}
					}
				}
			}
			//터트리기
			if(yesBomb) {
				count++;
				down();
			}
			//터트릴 것이 없으면 게임종료
			else break;
		}
	}

	//뿌요 아래로 떨어지기
	private static void down() {
		//열 기준으로 체크
		for (int j = 0; j < 6; j++) {
			boolean pass = false;
			for (int i = 11; i > 0; i--) {
				if(pass) continue;
				if(field[i][j]!='.') continue; //현재 고른 칸이 빈칸이면 패스
				else {
					//한 칸씩 위로 올라가며 탐색
					for (int k = i-1; k >= 0 ; k--) {
						//맨 윗칸까지 간 경우 해당 열은 더이상 내릴 뿌요가 없는 것 
						if(k==0 && field[k][j]=='.') pass=true;
						//뿌요 아래로 내리기
						if(field[k][j]!='.') {
							field[i][j] = field[k][j];
							field[k][j] = '.';
							break;
						}
					}
				}
			}
		}
	}

	//뿌요 터트리기
	private static void bomb() {
		int n = delete.size();
		for (int i = 0; i < n; i++) {
			int r = delete.peek()[0];
			int c = delete.poll()[1];
			field[r][c] = '.';
		}
	}
	
	//배열 범위 내, 같은 색, 방문한 적 없는지 체크
	private static boolean check(int r, int c, char color) {
		return r>=0 && r<12 && c>=0 && c<6 && field[r][c]==color && !visited[r][c];
	}
}
