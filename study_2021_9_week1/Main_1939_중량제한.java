package study_2021_9_week1;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.05
 * @summary 
 * BOJ-gold4  128MB/1s (KB/ms)
 * 섬 N개 (2~10,000)
 * 섬 간에 다리 있는 경우 존재
 * 한 번의 이동에서 옮길 수 있는 물품 중량 최댓값 구하기
 * 
 * N : 섬의 개수
 * M : 다리의 개수
 */
public class Main_1939_중량제한 {
	
	static class Island {
		int to, weight;
		public Island(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
	}
	static int N, M, max, left, right, mid, start, end;
	static List<Island>[] island;
	static boolean[] isVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		island = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			island[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			island[a].add(new Island(b, w));
			island[b].add(new Island(a, w));
			max = Math.max(max, w);
		}
		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		right = max;
		while(left<=right) {
			mid = (left+right)/2;
			isVisited = new boolean[N+1];
			if(check(start, end, mid)) {
				left = mid+1;
			}
			else right = mid-1;
		}
		System.out.println(right);
	}
	
	static Queue<Integer> que = new LinkedList<>();
	private static boolean check(int start, int end, int mid) {
		que.add(start);
		isVisited[start] = true;
		while(!que.isEmpty()) {
			int now = que.poll();
			if(now == end) return true;
			for (Island land : island[now]) {
				if(!isVisited[land.to] && mid <= land.weight) {
					isVisited[land.to] = true;
					que.add(land.to);
				}
			}
		}
		return false;
	}

}
