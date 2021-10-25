package study_2021_10_week4;

import java.util.*;

/**
 * @author anna
 * @date 2021.10.25
 * @summary 
 * BOJ-bronze1  128MB/1s (12864KB/108ms)
 * 3킬로, 5킬로
 * N킬로 배달시 봉지 몇 개 가져가면 되는가?
 * 만들 수 없다면 -1 출력
 * 
 * N : 3~5,000
 */
public class Main_2839_설탕배달 {

	static int N;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		int answer = 0;
		while(true) {
			if(N%5==0) {
				answer += N/5;
				System.out.println(answer);
				break;
			}
			else {
				N-=3;
				answer++;
			}
			if(N<0) {
				System.out.println("-1");
				break;
			}
		}
		scann.close();
	}

}
