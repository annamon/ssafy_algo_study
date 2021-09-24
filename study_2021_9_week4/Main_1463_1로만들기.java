package study_2021_9_week4;

import java.util.*;

/**
 * @author anna
 * @date 2021.09.24
 * @summary 
 * BOJ-silver3  128MB/1s (16852KB/132ms)
 * X가 3으로 나누어 떨어지면 3으로 나누기
 * X가 2로 나누어 떨어지면 2로 나누기
 * 1 빼기
 * 
 * X : 1~10^6
 */
public class Main_1463_1로만들기 {

	static int X;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		X = scann.nextInt();
		int[] dp = new int[X+1];
		if(X>1) dp[2] = 1;
		if(X>2) {
			dp[3] = 1;
			if(X>3) {
				for (int x = 4; x <= X; x++) {
					//3의 배수인 경우
					if(x%3==0) {
						dp[x] = Math.min(dp[x-1]+1, dp[x/3]+1);
						//6의 배수인 경우
						if(x%2==0) dp[x] = Math.min(dp[x], dp[x/2]+1);
					}
					//2의 배수인 경우
					else if(x%2==0) dp[x] = Math.min(dp[x-1]+1, dp[x/2]+1);
					//그외경우
					else dp[x] = dp[x-1]+1;
				}
			}
		}
		System.out.println(dp[X]);
		scann.close();
	}

}
