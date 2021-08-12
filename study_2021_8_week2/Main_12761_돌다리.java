package study_2021_8_week2;

import java.util.*;

/**
 * @author anna
 * @date 2021.08.12
 * @summary 
 * BOJ-silver2  128MB/1s (18300KB/172ms)
 * 돌 번호 0~100,000
 * 동규 N번 돌 위에, 주미 M번 위에 있음
 * 스카이콩콩 힘 A, B (2~30)
 * 한 턴에 +1, -1, A, -A, B, -B, 현재위치xA, 현재위치xB 이동 가능
 * 가장 빠르게 만날 점프 횟수?
 * 
 * Stone : place 현재위치, count 이동횟수
 * visited[] : 방문처리
 */
public class Main_12761_돌다리 {

	static class Stone {
		int place;
		int count;
		public Stone(int now, int count) {
			super();
			this.place = now;
			this.count = count;
		}
	}
	static int A, B, N, M, answer=Integer.MAX_VALUE;
	static boolean[] visited = new boolean[100001];
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		A = scann.nextInt();
		B = scann.nextInt();
		N = scann.nextInt();
		M = scann.nextInt();
		jump();
		System.out.println(answer);
		scann.close();
	}
	
	private static void jump() {
		Queue<Stone> que = new LinkedList<>();
		que.add(new Stone(N, 0)); //동규 시작
		visited[N] = true;
		while(!que.isEmpty()) {
			Stone now = que.poll();
			if(now.place == M) { //주미에게 도착시
				answer = Math.min(answer, now.count);
				return;
			}
			//8가지 경우 점프하기
			for (int d = 0; d < 8; d++) {
				int nr = now.place;
				switch (d) {
				case 0: nr += 1; break;
				case 1: nr -= 1; break;
				case 2: nr += A; break;
				case 3: nr -= A; break;
				case 4: nr += B; break;
				case 5: nr -= B; break;
				case 6: nr *= A; break;
				case 7: nr *= B; break;
				}
				//점프 가능한 경우
				if(nr>=0 && nr<=100000 && !visited[nr]) {
					que.add(new Stone(nr, now.count+1));
					if(nr!=M) visited[nr] = true;
				}
			}
		}
	}

}
