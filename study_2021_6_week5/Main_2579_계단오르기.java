package study_2021_6_week5;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.28
 * @summary 
 * BOJ-silver3  128MB/1s (13244KB/128ms)
 * 1. 계단은 1칸 혹은 2칸 오를 수 있다.
 * 2. 연속으로 3칸은 불가능
 * 3. 마지막 계단은 무조건 밟아야 한다.
 * 총 점수 최대?
 * 
 * 계단 개수 300개 이하, 계단에 쓰여있는 점수 10,000이하 자연수
 */
public class Main_2579_계단오르기 {

	static int N;
	static int[] step, memo;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		step = new int[N+1];
		memo = new int[N+1];
		for (int i = 1; i <= N; i++) {
			step[i] = scann.nextInt();
		}
		memo[1] = step[1]; //첫번째 계단
		if(N>1) memo[2] = step[1] + step[2]; //두번째계단
		if(N>2) {
			//계단이 3개 이상인 경우
			for (int i = 3; i < N+1; i++) {
				//직전 계단을 밟고 올라오는 경우와 전전 계단을 밟고 올라오는 경우 비교
				memo[i] = Math.max(memo[i-3]+step[i-1]+step[i], memo[i-2]+step[i]);
			}
		}
		System.out.println(memo[N]);
		scann.close();
	}

}
