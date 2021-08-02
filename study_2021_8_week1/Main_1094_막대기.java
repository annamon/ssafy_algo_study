package study_2021_8_week1;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.08.02
 * @summary 
 * BOJ-silver5  128MB/2s (12896KB/120ms)
 * 막대 길이 64, 길이 X인 막대 만들기
 * 가진 막대 길이 모두 더하기.
 * 합이 X보다 큰 경우 아래 과정 반복
 * 길이 가장 짧은 거 반으로 자르기
 * 자른 막대 하나는 버리고 남은 막대 길이 합이 X보다 크거나 같으면 반복
 * 막대 몇 개를 풀로 붙여야 X 만들 수 있는가?
 * 
 * X : 1~64
 */
public class Main_1094_막대기 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int X = scann.nextInt();
		int answer = 0;
		while(X>0) {
			if(X%2==1) answer++;
			X /= 2;
		}
		System.out.println(answer);
	}

}
