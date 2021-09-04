package study_2021_9_week1;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.04
 * @summary 
 * BOJ-gold5  128MB/1s (11544KB/88ms)
 * 마지막 숫자 사이에 = 넣기
 * 나머지 숫자 사이에 + - 넣기
 * 0~20 까지만 가능
 * 상근이가 만들 수 있는 올바른 등식의 수 구하기
 * 
 * N : 숫자 개수, 3~100
 * number[] : 현재까지 계산된 식 가지수
 * next[] : 이번 숫자 포함하여 계산한 식 가지수 
 */
public class Main_5557_1학년 {

	static int N;
	static long[] number = new long[21], next;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//맨 처음 숫자 식 개수 넣기
		number[Integer.parseInt(st.nextToken())]++;
		//맨처음, 마지막 숫자 제외한 식 개수 찾기
		for (int n = 1; n < N-1; n++) {
			//이번 숫자
			int now = Integer.parseInt(st.nextToken());
			//이번 숫자 포함하여 계산한 식 가지수
			next = new long[21];
			for (int i = 0; i <= 20; i++) {
				//이전까지 계산된 식이 있는 경우
				if(number[i]!=0) {
					//이번 숫자 더하거나 뺀 값이 범위 만족하는 경우 next 배열에 개수 저장하기
					if(i+now >=0 && i+now <=20) next[i+now] += number[i];
					if(i-now >=0 && i-now <=20) next[i-now] += number[i];
				}
			}
			//next 배열 값을 number 배열로 옮기기
			for (int i = 0; i <= 20; i++) number[i] = next[i];
		}
		//맨 마지막 수를 index로 하는 number값이 정답
		System.out.println(number[Integer.parseInt(st.nextToken())]);
	}

}
