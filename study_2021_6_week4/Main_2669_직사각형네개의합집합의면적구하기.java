package study_2021_6_week4;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.24
 * @summary 
 * BOJ-bronze1  128MB/1s (12908KB/116ms)
 * 4개 직사각형들이 차지하는 면적 구하기
 * 겹칠 수 있음
 * 왼쪽 아래 꼭짓점 x, y, 오른쪽 위 꼭짓점 x, y 좌표 주어짐
 * 좌표 1이상 100이하 정수
 */
public class Main_2669_직사각형네개의합집합의면적구하기 {

	static int answer;
	static int[][] square = new int[100][100];
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			int x1 = scann.nextInt();
			int y1 = scann.nextInt();
			int x2 = scann.nextInt();
			int y2 = scann.nextInt();
			fill(x1, y1, x2, y2);
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(square[i][j]==1) answer++;
			}
		}
		System.out.println(answer);
	}
	
	private static void fill(int x1, int y1, int x2, int y2) {
		for (int r = y1; r < y2; r++) {
			for (int c = x1; c < x2; c++) {
				if(square[r][c]==1) continue;
				square[r][c]=1;
			}
		}
	}

}
