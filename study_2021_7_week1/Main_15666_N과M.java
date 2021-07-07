package study_2021_7_week1;

import java.util.*;

/**
 * @author anna
 * @date 2021.07.07
 * @summary 
 * BOJ-silver2  512MB/2s (18648KB/496ms)
 * N개 자연수 중에 M개 고른 수열 만들기
 * 같은 수 여러번 고르기 가능
 * 고른 수열은 비내림차순이어야함 (A1≤A2)
 * 중복되는 수열은 한 번만 출력
 * 
 * N : 전체 수 개수
 * M : 고를 개수  (1≤ M≤N ≤8)
 * number : 전체 수 (중복제거)
 * selected[] : 고른 수
 */
public class Main_15666_N과M {
	
	static int N, M;
	static List<Integer> number = new ArrayList<>();
	static int[] selected;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		selected = new int[M];
		//전체 수 중복 제거
		for (int i = 0; i < N; i++) {
			int n = scann.nextInt();
			if(!number.contains(n)) number.add(n);
		}
		Collections.sort(number); //오름차순 정렬
		choice(0, 0);
		scann.close();
	}
	
	//중복조합
	private static void choice(int start, int cnt) {
		//M개 다 고른 경우 출력
		if(cnt==M) {
			for (int i : selected) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		//중복 조합을 위한 코드, i=start인 이유: 현재 수부터 또 고를 수 있게 하기 위해
		for (int i = start; i < number.size(); i++) {
			selected[cnt] = number.get(i);
			choice(i, cnt+1);
		}
	}

}
