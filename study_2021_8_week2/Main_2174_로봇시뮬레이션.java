package study_2021_8_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.08.14
 * @summary 
 * BOJ-gold5  128MB/2s (KB/ms)
 * 
 */
public class Main_2174_로봇시뮬레이션 {

	static class Robot {
		int X;
		int Y;
		int direction;
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
	static String[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		field = new int[B+1][A+1];
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		robots = new Robot[N+1];
		input = new String[M];
		for (int i = 1; i <= N; i++) {
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
			field[y][x] = i;
		}
		for (int i = 0; i < M; i++) input[i] = br.readLine();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(input[i], " ");
			simulation(Integer.parseInt(st.nextToken()), st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		System.out.println("OK");
	}
	
	static int[] dx = {0, 1, 0,-1};
	static int[] dy = {1, 0,-1, 0};
	private static void simulation(int num, String count, int order) {
		Robot now = robots[num];
		int d = now.getDirection();
		if(count.equals("L")) {
			d -= order;
			if(d<0) d = 4-(-d % 4);
			now.setDirection(d);
		}
		else if(count.equals("R")) {
			d += order;
			if(d>3) d %= 4;
			now.setDirection(d);
		}
		else {
			int cnt = order;
			int x = now.getX();
			int y = now.getY();
			field[y][x] = 0;
			while(cnt>0) {
				x += dx[d];
				y += dy[d];
				if(x<1 || x>A || y<1 || y>B) {
					System.out.println("Robot "+ num + " crashes into the wall");
					System.exit(0);
				}
				else if(field[y][x]!=0) {
					System.out.println("Robot " + num + " crashes into robot " + field[y][x]);
					System.exit(0);
				}
				else cnt--;
			}
			field[y][x] = num;
			now.setX(x);
			now.setY(y);
		}
		robots[num] = now;
	}

}
