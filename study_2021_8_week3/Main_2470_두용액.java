package study_2021_8_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author anna
 * @date 2021.08.22
 * @summary 
 * BOJ-gold5  128MB/1s (31740KB/308ms)
 * 산성 용액 특성값 1~1,000,000,000
 * 알칼리성 용액 -1~-1,000,000,000
 * 두 용액 합성 = 합 0에 가까운 용액 만들기
 * 
 * N : 용액 수 2~100,000
 * answer : 0에 가까운 용액 최소값
 * L1, L2 : 정답 용액
 * liquid[] : 용액 특성값 정보
 */
public class Main_2470_두용액 {

	static int N, L1, L2, answer = Integer.MAX_VALUE;
	static int[] liquid;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		liquid = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(liquid); //오름차순 정렬
		int left = 0;
		int right = N-1;
		while(left<right) {
			int sum = liquid[left] + liquid[right];
			//용액 합 절댓값이 현재 정답보다 작은 경우
			if(Math.abs(sum) < answer) {
				L1 = liquid[left];
				L2 = liquid[right];
				answer = Math.abs(sum);
			}
			//합이 음수인 경우 왼쪽 포인터 한 칸 이동
			if(sum < 0) left++;
			//그 외 경우 오른쪽 포인터 한 칸 이동
			else right--;
		}
		System.out.println(L1 + " " + L2);
	}

}
