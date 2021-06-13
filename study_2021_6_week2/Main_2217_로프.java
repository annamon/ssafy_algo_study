package study_2021_6_week2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.13
 * @summary 
 * BOJ-silver4  192MB/2s (90172KB/832ms)
 * 로프마다 들 수 있는 물체 중량 다름
 * 여러 개의 로프를 병렬로 연결하면 각각의 로프에 걸리는 중량을 나눌 수 있다.
 * k개 로프 사용하여 중량 w 물체 들어올리면 각각 로프에 w/k만큼의 중량이 걸리게 된다.
 * 모든 로프를 사용해야 할 필요X
 * 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량?
 * 
 * N : 로프 개수 (1≤N≤100,000)
 * weight : 최대 중량 (≤10,000 자연수)
 */
public class Main_2217_로프 {

	static int N, answer;
	static int[] weight;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		weight = new int[N];
		for (int i = 0; i < N; i++) {
			weight[i] = scann.nextInt();
		}
		Arrays.sort(weight); //무게 오름차순 정렬
		for (int i = 0; i < N; i++) {
			int now = weight[i] * (N-i); //현재 고른 놈 기준으로 뒤 모든 로프에 무게 적용
			answer = Math.max(answer, now); //최대값 찾기
		}
		System.out.println(answer);
	}

}
