package study_2021_6_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author anna
 * @date 2021.06.26
 * @summary 
 * BOJ-gold4  128MB/1s (24348KB/328ms)
 * 보드 RxC (1≤R,C≤100)
 * 1. 종수 8방 움직임 or 제자리
 * 2. 이동한 곳에 미친 아두이노 있을 경우 lose
 * 3. 미친 아두이노 8방 이동 (종수와 가장 가까운 방향으로)
 * 4. 이동한 곳에 종수가 있을 경우 lose
 * 5. 미친 아두이노 2개 이상 같은 칸인 경우 폭발로 파괴
 * . 빈칸, R 미친아두이노, I 종수 위치
 * 보드 상태 출력, 중간에 게임이 끝나는 경우 kraj X 출력 (X 종수 이동 횟수)
 * 
 * count : 종수 이동 횟수
 * robots[][] : 게임 필드
 * overlap[][] : 미친아두이노 중복 확인
 * arduino : 현재 남은 미친아두이노
 */
public class Main_8972_미친아두이노 {
	
	static class position {
		int r, c;
		public position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int R, C, count;
	static position me;
	static String move;
	static char[][] robots;
	static int[][] overlap;
	static List<position> arduino = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		robots = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				robots[i][j] = s.charAt(j);
				if(robots[i][j]=='I') me = new position(i,j);
				if(robots[i][j]=='R') arduino.add(new position(i,j));
			}
		}
		move = br.readLine();
		//게임진행
		for (int i = 0; i < move.length(); i++) {
			meMove(move.charAt(i)-48);
			arduinoMove();
		}
		//출력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(robots[i][j]);
			}
			System.out.println();
		}
	}

	//종수 이동
	static int[] dr = {0, 1, 1, 1, 0, 0, 0,-1,-1,-1};
	static int[] dc = {0,-1, 0, 1,-1, 0, 1,-1, 0, 1};
	private static void meMove(int move) {
		robots[me.r][me.c] = '.';
		count++;
		me.r += dr[move];
		me.c += dc[move];
		//미.아 만난 경우
		if(robots[me.r][me.c]=='R') {
			System.out.println("kraj " + count);
			System.exit(0);
		}
		//아닌 경우
		else robots[me.r][me.c]='I';
	}
	
	//미친아두이노 이동
	private static void arduinoMove() {
		overlap = new int[R][C]; //미.아 중복 확인용 배열 만들기
		//미.아 이동
		for (int i = 0; i < arduino.size(); i++) {
			whereToGo(arduino.get(i)); 
		}
		arduino.clear(); //현재 아두이노 목록 초기화
		Bomb(); //중복 아두이노 터트리기
	}
	
	//미친아두이노 어디로 이동할 것인가
	private static void whereToGo(position a) {
		int min = 999;
		int nr = 0, nc = 0;
		//미.아 이동 방향 설정
		for (int i = 1; i <= 9; i++) {
			if(i==5) continue; //제자리 금지
			//종수와 가장 가까워지는 칸으로 이동
			int dis = Math.abs(me.r-(a.r+dr[i])) + Math.abs(me.c-(a.c+dc[i]));
			if((dis<min) && check(a.r+dr[i], a.c+dc[i])) {
				min = dis;
				nr = a.r + dr[i];
				nc = a.c + dc[i];
			}
		}
		//이동했는데 종수 만난 경우 종료
		if(robots[nr][nc]=='I') {
			System.out.println("kraj " + count);
			System.exit(0);
		}
		//그 외 경우
		robots[a.r][a.c] = '.';
		overlap[nr][nc]++;
	}
	
	//미친아두이노 중복시 터트리기
	private static void Bomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				//1인 경우 아두이노 목록에 추가
				if(overlap[i][j]==1) {
					robots[i][j]='R';
					arduino.add(new position(i,j));
				}
				//2이상인 경우 터트리기(robots 필드에 R 표시x)
				if(overlap[i][j]>=2) continue;
			}
		}
	}

	//범위체크
	private static boolean check(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}

}
