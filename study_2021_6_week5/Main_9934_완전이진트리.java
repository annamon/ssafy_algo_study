package study_2021_6_week5;

import java.util.*;

/**
 * @author anna
 * @date 2021.07.02
 * @summary 
 * BOJ-silver1  128MB/1s (16688KB/188ms)
 * 깊이 K인 완전 이진트리 2^K -1개 노드로 이루어짐
 * 마지막 레벨 제외 모든 집은 왼쪽 자식, 오른쪽 자식 다 가짐
 * 상근이 방문한 빌딩 순서대로 출력
 * 
 * K : 깊이 K (1≤K≤10)
 * N : 전체 배열 길이
 * building[] : 입력 배열
 * visited : 방문 순서
 */
public class Main_9934_완전이진트리 {

	static int K, N;
	static int[] building;
	static Queue<int[]> visited = new LinkedList<>();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		K = scann.nextInt();
		N = (int)Math.pow(2, K)-1;
		building = new int[N];
		for (int i = 0; i < building.length; i++) {
			building[i] = scann.nextInt();
		}
		int i = K-1;
		//첫 장소 큐에 넣기
		visited.add(new int[] {0, N-1});
		while(!visited.isEmpty()) {
			//마지막 레벨까지 완료시 방문 종료
			if(i<0) break;
			//방문시작
			int size = visited.size();
			while(size>0) {
				int start = visited.peek()[0];
				int end = visited.poll()[1];
				int mid = (start + end) /2;
				//가운데 장소 방문
				System.out.print(building[mid]+" ");
				//현재 장소 기준 왼쪽 범위
				if(start>=0) visited.add(new int[] {start, mid-1});
				//현재 장소 기준 오른쪽 범위
				if(end<N) visited.add(new int[] {mid+1, end});
				size--;
			}
			i--;
			System.out.println();
		}
	}
}