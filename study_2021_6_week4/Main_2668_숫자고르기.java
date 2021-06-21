package study_2021_6_week4;

import java.util.*;

/**
 * @author anna
 * @date 2021.06.21
 * @summary 
 * BOJ-gold5  128MB/1s (12996KB/128ms)
 * 2xN 표
 * 첫 줄 1~N 순서대로
 * 둘째 줄 1~N 랜덤
 * 첫 줄에서 뽑은 수 집합과 둘째 줄 수 집합이 같은 최대 수 찾기.
 * 
 * N : (1≤N≤100)
 * number : 찾을 숫자
 * table : 숫자 표
 * check : 방문처리
 * answer : 정답 수
 */
public class Main_2668_숫자고르기 {

	static int N, number;
	static int[] table;
	static boolean[] check;
	static List<Integer> answer = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		table = new int[N+1];
		check = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			//둘째줄 입력받기, 첫째줄은 index로 사용
			table[i] = scann.nextInt(); 
		}
		for (int i = 1; i <= N; i++) {
			//방문처리
			check[i] = true;
			//현재 index가 둘째줄에 있는지 확인
			number = i;
			dfs(i);
			//방문처리 해제
			check[i] = false;
		}
		
		Collections.sort(answer);
		System.out.println(answer.size());
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}
	
	private static void dfs(int i) {
		//시작 index 찾은 경우 리스트에 넣기
		if(table[i]==number) {
			answer.add(number);
			return;
		}
		//방문하지 않았으면 방문처리, 계속 탐색
		if(!check[table[i]]) {
			check[table[i]] = true;
			dfs(table[i]);
			check[table[i]] = false;
		}
	}
	
	
}
