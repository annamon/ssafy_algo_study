package study_2021_6_week4;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.23
 * @summary 
 * BOJ-silver2  256MB/1s (300312KB/1120ms)
 * 1~N으로 이루어진 순열
 * 인덱스 -> 도착지점 
 * 처음 시작으로 돌아오는 것 : 순열 사이클
 * 사이클 개수 구하기
 * 
 * T : 테스트케이스 수
 * N : 순열 크기 (2≤N≤1,000)
 * cycle : 순열 사이클 수
 * permu : 순열 배열
 * visited : 방문처리 배열
 */
public class Main_10451_순열사이클 {

	static int T, N, cycle;
	static int[] permu;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 0; t < T; t++) {
			N = scann.nextInt();
			permu = new int[N+1];
			visited = new boolean[N+1];
			cycle = 0;
			for (int i = 1; i <= N; i++) {
				permu[i] = scann.nextInt();
			}
			for (int i = 1; i <= N; i++) {
				if(visited[i]) continue; //방문한 경우 패스
				check(i, i);  //미방문시 검사
			}
			System.out.println(cycle);
		}
		scann.close();
	}
	
	private static void check(int now, int start) {
		//사이클 처음 시작점으로 돌아온 경우
		if(permu[now]==start) {
			cycle++;
			visited[now] = true;
			return;
		}
		//방문처리
		visited[now] = true;
		//다음 지역 방문
		check(permu[now], start);
	}

}
