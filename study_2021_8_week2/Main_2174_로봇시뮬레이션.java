package study_2021_8_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.08.14
 * @summary 
 * BOJ-gold5  128MB/2s (13036KB/92ms)
 * 땅 가로 A, 세로 B (A,B : 1~100)
 * 로봇 N개 (N : 1~100)
 * 로봇 초기 위치 x, y, 방향(NWES), 로봇 위치 서로 다름
 * 명령 M개 (M : 1~100)
 * 명령할 로봇 번호, 명령 종류, 반복 횟수(1~100) 
 * L : 현재 방향에서 왼쪽으로 90도 회전
 * R : 현재 방향에서 오른쪽으로 90도 회전
 * F : 현재 방향에서 앞으로 한 칸 이동
 * 범위 벗어난 경우 : Robot X crashes into the wall
 * 다른 로봇과 충돌한 경우 : Robot X crashes into robot Y
 * 그 외 : OK 출력
 */
public class Main_2174_로봇시뮬레이션 {

	static class Robot {
		int X;
		int Y;
		int direction; //방향
		public Robot(int x, int y, int direction) {
			super();
			X = x;
			Y = y;
			this.direction = direction;
		}
		public int getX() {return X;}
		public void setX(int x) {X = x;}
		public int getY() {return Y;}
		public void setY(int y) {Y = y;}
		public int getDirection() {return direction;}
		public void setDirection(int direction) {this.direction = direction;}
	}
	
	static int A, B, N, M;
	static Robot[] robots;
	static int[][] field;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken()); //가로
		B = Integer.parseInt(st.nextToken()); //세로
		field = new int[B+1][A+1];
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //로봇수
		M = Integer.parseInt(st.nextToken()); //명령수
		robots = new Robot[N+1];
		for (int i = 1; i <= N; i++) { //로봇 정보 저장
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = 0;
			switch (st.nextToken()) {
			case "N": d = 0; break;
			case "E": d = 1; break;
			case "S": d = 2; break;
			case "W": d = 3; break;
			}
			robots[i] = new Robot(x, y, d);
			field[y][x] = i; //필드에 로봇 번호 저장
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			simulation(Integer.parseInt(st.nextToken()), st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		System.out.println("OK");
	}
	
	//N E S W 순서
	static int[] dx = {0, 1, 0,-1};
	static int[] dy = {1, 0,-1, 0};
	private static void simulation(int num, String count, int order) {
		Robot now = robots[num];
		int d = now.getDirection();
		if(count.equals("L")) { //좌로 회전
			d -= order;
			if(d<0) d = 4-(-d % 4);
			if(d==4) d = 0;
			now.setDirection(d);
		}
		else if(count.equals("R")) { //우로 회전
			d += order;
			if(d>3) d %= 4;
			now.setDirection(d);
		}
		else { //이동
			int cnt = order;
			int x = now.getX();
			int y = now.getY();
			field[y][x] = 0; //이동 위해 기존 필드 값 0 기록
			while(cnt>0) {
				x += dx[d];
				y += dy[d];
				if(x<1 || x>A || y<1 || y>B) { //필드 벗어난 경우
					System.out.println("Robot "+ num + " crashes into the wall");
					System.exit(0);
				}
				else if(field[y][x]!=0) { //다른 로봇과 충돌한 경우
					System.out.println("Robot " + num + " crashes into robot " + field[y][x]);
					System.exit(0);
				}
				else cnt--;
			}
			//이동 완료
			field[y][x] = num; //필드에 기록
			now.setX(x);
			now.setY(y);
		}
		//로봇 새 정보 갱신
		robots[num] = now;
	}

}
