package study_2021_6_week2;

import java.util.*;

/**
 * @author anna
 * @date 2021.06.10
 * @summary 
 * BOJ-silver4  128MB/2s (12892KB/116ms)
 * 
 * 병든 나이트가 N × M 크기 체스판의 가장 왼쪽아래 칸에 위치
 * 움직임 4가지 - 상2우1, 상1우2, 하1우2, 하2우1
 * 방문한 칸의 수를 최대로
 * 이동 횟수 4이상 : 4가지 다 사용
 * 이동 횟수 4미만 : 움직임 상관 없음
 * 
 * N : 세로 (≤20억 자연수)
 * M : 가로 (≤20억 자연수)
 * 
 * BFS로 푸니까 시간초과. 연산 터짐
 */
public class Main_1783_병든나이트 {
	
	static int N, M, answer;
	static Queue<int[]> move = new LinkedList<>();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		//이동 4가지 다 사용 가능한 최소 조건 만족시
		if(N>=3 && M>=7) {
			answer = 5 + (M-7);
		}
		//그 외 경우(이동4가지 다 사용 못 함, 방문칸 최대4)
		else {			
			//{r, c, 방문한 칸 수} / 체스판(1~N, 1~M) 맨왼쪽아래 시작지점
			move.add(new int[] {N, 1, 1});
			run();
		}
		System.out.println(answer);
	}
	
	static int[] dr = {-2,-1, 1, 2}; //위로이동
	static int[] dc = { 1, 2, 2, 1}; //오른쪽으로이동
	private static void run() {
		while(!move.isEmpty()) {
			int[] now = move.poll(); //현재 나이트위치
			boolean finish = true;   //더이상 갈 곳이 없는가
			for (int d = 0; d < 4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				if(check(nr,nc)) {   //가려는 곳이 체스판 범위 내이고
					if(now[2]==3) {  //여태 방문한 칸이 3칸 이상인 경우
						answer = 4;  //다음 이동이 최대임(4)
						return;
					}
					//여태 방문한 칸이 3칸 미만인 경우
					move.add(new int[] {nr, nc, now[2]+1});
					finish = false;
				}
			}
			if(finish) { //더이상 갈 곳이 없다면 방문칸 비교
				answer = Math.max(answer, now[2]);
			}
		}
	}
	
	//체스판 범위 체크
	private static boolean check(int r, int c) {
		return r>=1 && r<=N && c>=1 && c<=M;
	}

}
