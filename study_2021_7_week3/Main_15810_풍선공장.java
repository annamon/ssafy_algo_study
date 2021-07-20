package study_2021_7_week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author anna
 * @date 2021.07.20
 * @summary 
 * BOJ-silver2  256MB/1s (121508KB/728ms)
 * N명의 사람이 M개의 풍선 만들기
 * 사람마다 풍선 하나 만드는 시간 다름
 * 총 몇 분 걸리는가
 * 
 * N : 사람수 (1<N≤1,000,000)
 * M : 풍선수 (0<M≤1,000,000)
 * count : 풍선 만드는 개수
 * left : 최소시간
 * right : 최대시간
 * mid : 중간시간
 * time[] : 사람별 풍선 만드는 데 걸리는 시간 배열
 * 
 * long 타입 사용시 연산 주의하자.
 */
public class Main_15810_풍선공장 {

	static int N, M;
	static long count, left, right, mid;
	static int[] time;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		time = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time);
		left = 0L; //최소시간
		right = (long)time[0] * (long)M; //최대시간
		//적정 시간 찾기
		while(left<=right) {
			count = 0;
			mid = (left + right) / 2;
			//만들 수 있는 풍선 개수 구하기
			for (int i = 0; i < N; i++) count += mid / (long)time[i];
			//M보다 큰 경우 최대 범위 줄이기
			if(count>=M) right = mid -1;
			//M보다 작은 경우 최소 범위 늘리기
			else left = mid + 1;
		}
		System.out.println(left);
	}

}
