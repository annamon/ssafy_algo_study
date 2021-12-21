package study_2021_12_week1;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.12.19
 * @summary 
 * BOJ-silver1  512MB/1s (11652KB/76ms)
 * 주사위 조작해 내가 원하는 수 나오게 하면 최소 몇 번만에 도착할까?
 * 1~6 적혀있음
 * 게임 크기 10x10, 100개칸
 * 주사위 굴려 나온 수만큼 이동
 * i번칸, 나온 수 n => i+n번 칸으로 이동
 * 100 넘어가면 이동 불가
 * 뱀 있는 칸 도착시 뱀 따라 내려가게 됨
 * 1번칸에서 100번칸까지 이동
 * 
 * N : 사다리 수, 1~15
 * M : 뱀 수, 1~15
 * x, y : 사다리 정보. x번칸 도착시 y번 칸으로 이동
 * u, v : 뱀 정보. u번 도착시 v번으로 이동
 */
public class Main_16928_뱀과사다리게임 {

	static int N, M, answer;
	static int[] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[101];
		visited = new boolean[101];
		//뱀, 사다리 정보 기록
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from] = to;
		}
		game();
		System.out.println(answer);
	}
	
	//게임 시작
	static Queue<int[]> que;
	private static void game() {
		que = new LinkedList<>();
		visited[1] = true; //출발지
		que.add(new int[] {1, 0});
		while(!que.isEmpty()) {
			int now = que.peek()[0];
			int count = que.poll()[1];
			if(now==100) { //목적지 도착시 종료
				answer = count;
				break;
			}
			//현재 위치에서 주사위 1~6 모두 고려
			for (int i = 1; i <= 6; i++) {
				int next = now + i;
				if(next > 100) continue; //목적지 초과
				if(visited[next]) continue; //이미 방문한 곳
				//그 외 이동
				visited[next] = true;
				if(map[next]!=0) { //뱀이나 사다리 있는 경우
					next = map[next];
					visited[map[next]] = true;
				}
				que.add(new int[] {next, count+1});
			}
		}
	}

}
