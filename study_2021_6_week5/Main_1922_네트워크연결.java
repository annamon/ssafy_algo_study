package study_2021_6_week5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author anna
 * @date 2021.07.03
 * @summary 
 * BOJ-gold4  256MB/2s (226136KB/1300ms)
 * 모든 컴퓨터 최소 비용으로 연결하기
 * 입력 : a컴퓨터, b컴퓨터, 비용(1≤c≤10,000) 
 * a, b 같을 수 있음
 * 
 * N : 컴퓨터 수 (1≤N≤1000)
 * M : 연결할 수 있는 선 수 (1≤M≤100,000)
 * 
 * MST로 풀기
 * line : 컴퓨터1, 컴퓨터2, 비용 -> 비용순으로 정렬
 * parents[] : union시 사용할 부모 배열
 * network[] : 간선 정보 배열
 */
public class Main_1922_네트워크연결 {

	static class line implements Comparable<line> {
		int com1, com2, cost;
		public line(int com1, int com2, int cost) {
			super();
			this.com1 = com1;
			this.com2 = com2;
			this.cost = cost;
		}
		@Override
		public int compareTo(line o) {
			return this.cost - o.cost;
		}
	}
	
	static int N, M, answer, count;
	static int[] parents;
	static line[] network;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		//간선 정보 저장
		network = new line[M];
		for (int i = 0; i < M; i++) {
			network[i] = new line(scann.nextInt(), scann.nextInt(), scann.nextInt());
		}
		Arrays.sort(network);
		//유니온 준비
		make();
		for (int i = 0; i < M; i++) {
			//유니온 가능하다 = 간선 채택
			if(union(network[i].com1, network[i].com2)) {
				answer += network[i].cost; //비용 더하기
				if(++count == N-1) break; //mst 조건인 간선(정점-1) 모두 고르면 종료
			}
		}
		System.out.println(answer);
		scann.close();
	}
	
	//부모배열 만들기 : 부모 = 자기 자신으로 초기화
	private static void make() {
		parents = new int[N+1]; //index 0제외 N까지
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	//부모찾기
	private static int findSet(int a) {
		if(parents[a] == a) return a;	 //자기자신이 부모인경우
		else return findSet(parents[a]); //그외 경우 부모 찾아서 리턴
	}

	private static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		//컴a와 컴b 연결시 사이클 이루어지는 경우
		if(rootA == rootB) return false;
		//사이클 이루어지지 않는 경우
		else {
			//컴b의 부모 = a 부모
			parents[rootB] = rootA;
			return true;
		}
	}
}
