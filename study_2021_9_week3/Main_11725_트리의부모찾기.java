package study_2021_9_week3;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.15
 * @summary 
 * BOJ-silver2  256MB/1s (70136KB/580ms)
 * 루트 없는 트리.
 * 트리의 루트를 1이라 정했을 때 각 노드의 부모 구하기
 * 
 * N : 노드 개수, 2~100,000
 * line[] : 각 노드 별 연결된 노드 번호
 * parent[] : 각 노드의 부모 번호
 * isVisited[] : 방문처리용
 */
public class Main_11725_트리의부모찾기 {

	static int N;
	static List<Integer>[] line;
	static int[] parent;
	static boolean[] isVisited;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		isVisited = new boolean[N+1];
		//간선 정보 저장
		line = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			line[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			line[a].add(b);
			line[b].add(a);
		}
		//부모 찾기
		for (int i = 1; i <= N; i++) {			
			check(i);
		}
		//부모 출력
		for (int i = 2; i <= N; i++) {
			bw.append(String.valueOf(parent[i]));
			bw.newLine();
		}
		bw.flush();
	}
	
	//부모 찾기
	private static void check(int n) {
		if(isVisited[n]) return;
		isVisited[n] = true;
		//연결된 노드 확인
		for (int i : line[n]) {
			if(!isVisited[i]) {
				parent[i] = n;
				check(i);
			}
		}
	}

}
