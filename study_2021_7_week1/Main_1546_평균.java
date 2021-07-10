package study_2021_7_week1;

import java.util.*;

/**
 * @author anna
 * @date 2021.07.10
 * @summary 
 * BOJ-bronze1  128MB/2s (15944KB/168ms)
 * 점수 최댓값 M
 * 모든 점수 = 점수/M*100
 * 새로운 평균 구하기
 * 
 * N : 과목 개수, 1,000이하
 * max : 최고 점수
 * sum : 조작 점수 총합
 * score[] : 원점수 배열 
 */
public class Main_1546_평균 {

	static int N;
	static float max, sum;
	static int[] score; 
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		score = new int[N];
		for (int i = 0; i < N; i++) {
			score[i] = scann.nextInt();
		}
		Arrays.sort(score);
		max = score[N-1];
		for (int i = 0; i < N; i++) {			
			sum += (score[i]/max)*100;
		}
		System.out.println(sum/N);
		scann.close();
	}

}
