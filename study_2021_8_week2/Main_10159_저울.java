package study_2021_8_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.08.15
 * @summary 
 * BOJ-gold3  256MB/1s (20856KB/264ms)
 * 물건 번호 1~N
 * 양팔저울 측정 M회
 * 측정 결과 무게 : 왼쪽 > 오른쪽
 * 각 물건마다 비교 결과를 알 수 없는 물건의 개수 출력
 * 
 * N : 5~100
 * M : 0~2000
 * answer : 비교할 수 없는 물건 수
 * isCompared[][] : 비교 기록, [a][b]=-1 : a보다 b가 가벼움, 1:무거움
 * heavy : 현재 물건 기준 무거운 물건 큐
 * light : 현재 물건 기준 가벼운 물건 큐
 * visited[] : 물건 비교 현황 기록
 */
public class Main_10159_저울 {

	static int N, M, answer;
	static int[][] isCompared;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		isCompared = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			isCompared[a][b] = -1; //a보다 b가 가벼움
			isCompared[b][a] = 1;  //b보다 a가 무거움
		}
		for (int i = 1; i <= N; i++) {
			check(i);
		}
	}
	
	static Queue<Integer> heavy = new LinkedList<>();
	static Queue<Integer> light = new LinkedList<>();
	static boolean[] visited;
	private static void check(int number) {
		visited = new boolean[N+1]; //방문처리용
		visited[number] = true; //현재 물건은 체크x
		//무게 비교 내역 분류
		for (int i = 1; i <= N; i++) {
			if(isCompared[number][i]==1) heavy.add(i);
			if(isCompared[number][i]==-1) light.add(i);
		}
		//무거운 물건 찾기
		while(!heavy.isEmpty()) {
			int now = heavy.poll();
			visited[now] = true; //비교 물건 체크
			for (int i = 1; i <= N; i++) {
				//현재 물건보다 무겁고 체크한적 없으면 큐에 넣기 
				if(isCompared[now][i]==1 && !visited[i]) heavy.add(i);
			}
		}
		//가벼운 물건 찾기
		while(!light.isEmpty()) {
			int now = light.poll();
			visited[now] = true; //비교 물건 체크
			for (int i = 1; i <= N; i++) {
				//현재 물건보다 가볍고 체크한적 없으면 큐에 넣기 
				if(isCompared[now][i]==-1 && !visited[i]) light.add(i);
			}
		}
		//체크 기록 확인
		answer = N;
		for (int i = 1; i <= N; i++) {
			if(visited[i]) answer--;
		}
		System.out.println(answer);
	}

}
