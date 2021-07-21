package study_2021_7_week3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author anna
 * @date 2021.07.21
 * @summary 
 * BOJ-silver1  128MB/1s (12892KB/120ms)
 * 주사위 N^3개로 정육면체 만들기
 * 5개의 면에 적힌 수 합 최소 구하기
 * 
 * N : 주사위 수 1~1,000,000
 * one : 1면인 주사위 개수
 * two : 2면인 주사위 개수
 * three : 3면인 주사위 개수
 * min1 : 1면인 주사위들의 총합
 * min2 : 2면인 주사위들의 총합
 * min3 : 3면인 주사위들의 총합
 * answer : 정답
 * number[] : 주사위에 적힌 수
 * comb[] : 3면 고를때 A, F 제외한 붙어있는 면 인덱스 배열
 */
public class Main_1041_주사위 {
	
	static long N, one, two, three, min1, min2, min3, answer;
	static int[] number;
	static int[][] comb = {{1,2}, {1,3}, {2,4}, {3,4}};
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextLong();
		number = new int[6];
		for (int i = 0; i < 6; i++) {
			number[i] = scann.nextInt();
		}
		//주사위 1개인 경우
		if(N==1) {
			Arrays.sort(number);
			for (int i = 0; i < 5; i++) {
				answer += number[i];
			}
		}
		//주사위 2개 이상인 경우
		else {
			//각 면 개수당 주사위 수
			three = 4;
			two = (N-2)*4 + (N-1)*4;
			one = (N-2)*(N-1)*4 + (N-2)*(N-2);
			//3면 최대 구하기
			int n = Integer.MAX_VALUE;
			for (int i = 0; i < 4; i++) {
				n = Math.min(n, number[comb[i][0]] + number[comb[i][1]]);
			}
			n = Math.min(n + number[0], n + number[5]);
			min3 = three * n;
			//2면 최대 구하기
			n = Integer.MAX_VALUE;
			for (int i = 0; i <= 4; i++) {
				for (int j = i+1; j <= 5; j++) {
					if((i==0&&j==5) || (i==1&&j==4) || (i==2&&j==3)) continue;
					n = Math.min(n, number[i] + number[j]);
				}
			}
			min2 = two * n;
			//1면 최대 구하기
			Arrays.sort(number);
			min1 = one * number[0];
			//정답
			answer = min1 + min2 + min3;
		}
		System.out.println(answer);	
	}

}
