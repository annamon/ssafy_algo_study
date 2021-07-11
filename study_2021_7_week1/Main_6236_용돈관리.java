package study_2021_7_week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author anna
 * @date 2021.07.11
 * @summary 
 * BOJ-silver3  128MB/1s (19848KB/236ms)
 * N일 동안 쓸 금액
 * K원 M번 인출
 * 남은 금액 넣고 K원 인출 가능
 * 최소 금액 K?
 * 
 * N, M : (1≤N≤100,000 // 1≤M≤N)
 * K : 최소금액
 * min : 이분탐색 왼쪽, 시작은 돈 배열 최대값
 * max : 이분탐색 오른쪽, 시작은 돈 총합
 * money[] : 매일 쓸 돈 배열
 */
public class Main_6236_용돈관리 {

	static int N, M, K, min, max;
	static int[] money;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		money = new int[N];
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
			min = Math.max(min, money[i]);
			max += money[i];
		}
		check();
		System.out.println(K);
	}
	
	private static void check() {
		K = max; //처음 시작은 최대값
		while(min<=max) {			
			int mid = (min+max)/2;
			int count = 0; //인출 횟수
			int sum = 0; //인출 전까지 총합
			for (int i = 0; i < N; i++) {
				sum += money[i];
				if(sum>mid) {
					count++;
					sum = money[i]; //남은돈=이번에 쓴 돈
				}
			}
			//인출 다 하고 마지막에 돈이 남은 경우
			if(sum>0) count++;
			//인출 횟수 초과시 최소 구간 줄이기
			if(count>M) min = mid+1;
			//인출 횟수 만족시 최대 구간 줄이기
			else {
				K = Math.min(K, mid);
				max = mid-1;
			}
		}
	}

}
