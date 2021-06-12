package study_2021_6_week2;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.13
 * @summary 
 * BOJ-silver1  512MB/2s (159100KB/952ms)
 * 테트로미노 5가지 : ㅣ ㅁ L ㅜ 번개 (4칸)
 * NxM 종이 위에 테트로미노 하나
 * 테트로미노 회전, 대칭 가능
 * 테트로미노 면적 수 합 최대?
 * 
 * N세로 M가로 (4 ≤ N, M ≤ 500)
 * paper : 종이 칸 정보
 * tetrominoR, tetrominoC : 모든 테트로미노 경우 탐색 배열
 */
public class Main_14500_테트로미노 {
	static int N, M, answer;
	static int[][] paper;
	static int[][] tetrominoR = {
			{0,0,0}, {1,2,3}, {0,1,1}, //ㅡ ㅣ ㅁ
			{1,2,2}, {-1,-1,-1}, {0,1,2}, {0,0,-1}, //L
			{0,-1,-2}, {1,1,1}, {-1,-2,-2}, {0,0,1}, //L뒤집기
			{1,1,2}, {0,-1,-1}, {-1,-1,-2}, {0,1,1}, //번개+뒤집기
			{0,1,0}, {-1,0,1}, {0,-1,0}, {-1,0,1} //ㅜ
			};
	static int[][] tetrominoC = {
			{1,2,3}, {0,0,0}, {1,1,0}, //ㅡ ㅣ ㅁ
			{0,0,1}, {0,1,2}, {1,1,1}, {1,2,2}, //L
			{1,1,1}, {0,1,2}, {0,0,1}, {1,2,2}, //L뒤집기
			{0,1,1}, {1,1,2}, {0,1,1}, {1,1,2}, //번개+뒤집기
			{-1,0,1}, {0,-1,0}, {-1,0,1}, {0,1,0} //ㅜ
			};
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		paper = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				paper[i][j] = scann.nextInt();
			}
		}
		// 각 칸에 대해 테트로미노 진행
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {				
				find(i,j);
			}
		}
		System.out.println(answer);
	}
	
	// 테트로미노 
	private static void find(int startR, int startC) {
		// 19종류 전부 돌리기
		for (int i = 0; i < 19; i++) {
			int count = paper[startR][startC];
			boolean cango = true; //놓을 수 있는 테트로미노인가
			//탐색시작
			for (int d = 0; d < 3; d++) {
				int nr = startR + tetrominoR[i][d];
				int nc = startC + tetrominoC[i][d];
				if(check(nr,nc)) {
					count += paper[nr][nc]; //테트로미노 가능하면 합 더하기
				}else {
					cango = false; //테트로미노 불가능
					break;
				}
			}
			//테트로미노 가능인 경우에만 값 비교
			if(cango) answer = Math.max(answer, count);
		}
	}

	// 종이 범위 체크
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
	

}
