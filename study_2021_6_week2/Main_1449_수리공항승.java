package study_2021_6_week2;

import java.util.*;

/**
 * @author anna
 * @date 2021.06.09
 * @summary 
 * BOJ-silver3  128MB/2s (12948KB/120ms)
 * 길이 L인 테이프 무한개
 * 물이 새는 위치 좌우 +0.5만큼 간격 포함하여 붙이기
 * 테이프 자르기 불가능, 겹치기 가능
 * 
 * N : 물이 새는 곳 개수 (≤1,000 자연수)
 * L : 테이프 길이 (≤1,000 자연수)
 * 
 * pipe : 물이 새는 곳 위치 (≤1,000 자연수)
 * count : 테이프 개수
 */
public class Main_1449_수리공항승 {
	
	static int N, L, count;
	static double start, end;
	static int[] pipe;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		L = scann.nextInt();
		pipe = new int[N];
		for (int i = 0; i < N; i++) {
			pipe[i] = scann.nextInt();
		}
		Arrays.sort(pipe);
		// 처음 물이 새는 곳에 테이프 붙이기
		start = pipe[0]-0.5;
		end = start + L;
		count = 1;
		
		// 물이 새는 곳 범위 : pipe[i]-0.5  ~  pipe[i]+0.5
		for (int i = 1; i < N; i++) {
			// 1. 현재 테이프가 물이 새는 곳 범위 다 막는 경우
			if(end >= pipe[i]+0.5) continue;
			// 2. 현재 테이프가 물이 새는 곳 범위 내에서 끝나는 경우
			else if(end>= pipe[i]-0.5 && end <= pipe[i]+0.5 ) {
				start = end;
				end = start + L;
				count++;
			}
			// 3. 현재 테이프가 물이 새는 곳 범위에 미치지 못 하는 경우
			else {
				start = pipe[i]-0.5;
				end = start + L;
				count++;
			}
		}
		System.out.println(count);
	}

}
