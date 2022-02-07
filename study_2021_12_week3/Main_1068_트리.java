package study_2021_12_week3;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.12.27
 * @summary 
 * BOJ-gold5  128MB/2s (KB/ms)
 * 트리 주어졌을 때 노드 하나 지움
 * 남은 트리의 노드 개수 구하기
 * -1은 루트
 * 
 * N : 노드 개수, 1~50
 */
public class Main_1068_트리 {

	static int N, R, D, answer;
	static List<Integer>[] tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new List[N];
		//각 노드별 자식 리스트 만들기
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) R = i; //루트노드 인덱스 찾기
			else tree[parent].add(i);
		}
		D = Integer.parseInt(br.readLine());
		check();
		System.out.println(answer);
	}
	
	private static void check() {
		Queue<Integer> que = new LinkedList<>();
		boolean[] visited = new boolean[N];
		que.add(R);
		visited[R] = true;
		while(!que.isEmpty()) {
			int now = que.poll();
			if(now==D) continue; //삭제할 노드이면 현재 노드발 탐색 끝
			//리프노드거나 삭제할 노드의 부모인 노드이면 카운트
			if(tree[now].size()==0 ||
					(tree[now].contains(D) && tree[now].size()==1)) answer++;
			//탐색한 노드의 자식 탐색
			for (int i = 0; i < tree[now].size(); i++) {
				int next = tree[now].get(i);
				//이미 방문한 노드인 경우 더이상 하위 탐색 X
				if(visited[next]) continue;
				else {
					visited[next] = true;
					que.add(next);
				}
			}
		}
	}

}
