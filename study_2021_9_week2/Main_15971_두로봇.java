package study_2021_9_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.12
 * @summary 
 * BOJ-gold5  512MB/2s (76740KB/668ms)
 * N개 방, 1~N
 * 통로 N-1개, 서로 다른 두 방 이어줌
 * 통로 이용하여 두 방 이동 가능, 같은 통로 두 번 이상 지나지 않는 경로는 유일한 것
 * 통로 양 끝에 위치한 두 방은 통로 위에 있다 간주
 * 두 로봇이 서로 통신하기 위해 이동하는 거리 최소값 구하기
 * 
 * N : 방 개수, 1~100,000
 */
public class Main_15971_두로봇 {

	//간선 정보
	static class Info {
        int to;
        int cost;
        public Info(int to, int cost) {
        	super();
            this.to = to;
            this.cost = cost;
        }
    }
	
	static ArrayList<Info>[] map;
    static int N, robot1, robot2, answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		robot1 = Integer.parseInt(st.nextToken());
		robot2 = Integer.parseInt(st.nextToken());
		//간선 정보 저장
		map = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a =  Integer.parseInt(st.nextToken());
			int b =  Integer.parseInt(st.nextToken());
			int cost =  Integer.parseInt(st.nextToken());
			//양방향 통로
			map[a].add(new Info(b, cost));
			map[b].add(new Info(a, cost));
		}
		//최단 거리 찾기
		check();
		System.out.println(answer);
	}

	//최단 거리 찾기
	private static void check() {
		Queue<int[]> que = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        //현재 방, 여태까지 거리, 여태까지 이동한 통로 중 가장 값이 큰 통로
        que.add(new int[] {robot1, 0, 0});
        visited[robot1] = true;
        while(!que.isEmpty()) {
        	int[] now = que.poll();
        	//robot1이 robot2와 만난 경우
        	if(now[0]==robot2) {
        		//최소 값 = 총 이동 거리 - 가장 값 큰 통로
        		answer = Math.min(answer, now[1]-now[2]);
        	}
        	//이동 가능 통로 모두 고려
        	for(Info i : map[now[0]]) {
        		if(!visited[i.to]) {
        			visited[i.to] = true;
        			que.add(new int[] {i.to, now[1]+i.cost, Math.max(now[2], i.cost)});
        		}
        	}
        }
	}
	
}
