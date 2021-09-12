package study_2021_9_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.12
 * @summary 
 * BOJ-gold5  256MB/1s (117272KB/2540ms)
 * 시작점에서 다른 모든 정점으로의 최단 거리 구하기
 * 간선 가중치 10이하 자연수
 * 정점 사이 여러 간선 존재 가능
 * 경로 미존재시 INF 출력
 * 
 * V : 정점 개수, 1~20,000
 * E : 간선 개수, 1~300,000
 * K : 시작 정점 번호, 1~V
 * w : 가중치, 1~10
 */
public class Main_1753_최단경로 {

	static class Edge{
		int v; //도착점
		int w; //가중치
		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
	}
	
	static int V, E, K;
	static int[] distance;
	static boolean[] check;
	static List<Edge>[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		//간선 정보 저장
		arr = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			arr[i]=new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[u].add(new Edge(v, w));
		}
		
		check = new boolean[V+1]; //방문처리
		distance = new int[V+1]; //거리 저장용
		Arrays.fill(distance, Integer.MAX_VALUE);		
		distance[K] = 0;
		for (int i = 1; i <= V; i++) {
			int min = Integer.MAX_VALUE;
			int w = -1;
			for (int j = 1; j <= V; j++) {
				if(!check[j] && distance[j] < min){
					min = distance[j];
					w = j;
				}
			}
			if(w==-1) break;
			check[w] = true;
			
			for (Edge next: arr[w]) {
				int v = next.v;
				if(!check[v] && distance[v] > distance[w]+next.w){
					distance[v] = distance[w]+next.w;
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if(distance[i]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}

}
