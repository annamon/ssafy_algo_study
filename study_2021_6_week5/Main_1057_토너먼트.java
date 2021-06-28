package study_2021_6_week5;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.29
 * @summary 
 * BOJ-silver3  512MB/1s (12900KB/112ms)
 * 토너먼트 번호 1~N, 인접한 번호끼리 대결
 * 홀수명일 경우 마지막 번호 부전승
 * 승리한 사람 순으로 다시 번호 매기기
 * 김지민, 임한수는 만나기 전까지 무조건 승리
 * 김지민과 임한수가 서로 몇 라운드에서 대결하는가?
 * 
 * N : 참가자 수, (2≤N≤100,000)
 * kim : 김지민 번호
 * lim : 임한수 번호
 * first : 김지민과 임한수 중 앞번호
 * second : 김지민과 임한수 중 뒷번호
 * round : 라운드 수
 */
public class Main_1057_토너먼트 {

	static int N, kim, lim, first, second, round = 1;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		kim = scann.nextInt();
		lim = scann.nextInt();
		first = Math.min(kim, lim);
		second = Math.max(kim, lim);
		while(true) {
			//앞번호가 홀수, 뒷번호가 앞+1이면 둘이 대결
			if(first%2==1 && second == first+1) break;
			//앞번호가 순서 1번 되기 전까지 라운드마다 번호 줄이기
			if(first!=1) {
				if(first%2==1) first++; //홀수인 경우 +1
				first /= 2; //다음 라운드 번호
			}
			//뒷번호 라운드마다 번호 줄이기
			if(second%2==1) second++; //홀수인 경우 +1
			second /= 2; //다음 라운드 번호
			round++; //라운드 카운트
		}
		System.out.println(round);
	}

}
