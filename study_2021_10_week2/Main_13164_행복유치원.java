package study_2021_10_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.10.18
 * @summary 
 * BOJ-gold5  512MB/1s (67384KB/600ms)
 * N명 일렬로 줄 세우기, K개 조로 나누기
 * 조별로 인원수가 같을 필요는 없다.
 * 비용 합 최소 구하기
 * 
 * N : 원생 수, 1~300,000
 * K : 나눌 조 개수, 1~N
 */
public class Main_13164_행복유치원 {

	static int N, K;
	static long total;
	static int[] baby, diff;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		//원생 키 정보 저장
		baby = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			baby[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(baby); //오름차순 정렬
		//원생 키 차이 정보 저장
		diff = new int[N-1];
		for (int i = 0; i < N-1; i++) {
			diff[i] = baby[i+1] - baby[i];
		}
		Arrays.sort(diff); //키 차이 정렬
		//가장 큰 차이 K개 빼고 모두 더하기 = 총 비용임
		for (int i = 0; i < N-K; i++) {
			total += diff[i];
		}
		System.out.println(total);
	}

}
