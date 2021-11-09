package study_2021_11_week2;

import java.util.*;

/**
 * @author anna
 * @date 2021.11.09
 * @summary 
 * BOJ-silver1  512MB/1s (12880KB/108ms)
 * 2^N x 2^N 배열 Z모양으로 탐색하기
 * r행 c열을 몇 번째로 방문하는지 출력
 * 
 * N : 1~15
 * r,c : 0~2^N-1
 */
public class Main_1074_Z {

	static int N, R, C, answer;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		R = scann.nextInt();
		C = scann.nextInt();
		int size = (int) Math.pow(2, N);
		find(size, R, C);
		System.out.println(answer);
		scann.close();
	}
	
	private static void find(int size, int r, int c) {
		if(size==1) return;
		if(r<size/2 && c<size/2) {
			find(size/2, r, c);
		}
		else if(r<size/2 && c>=size/2) {
			answer += size*size/4;
			find(size/2, r, c-size/2);
		}
		else if(r>=size/2 && c<size/2) {
			answer += (size*size/4)*2;
			find(size/2, r-size/2, c);
		}
		else {
			answer += (size*size/4)*3;
			find(size/2, r-size/2, c-size/2);
		}
		
	}

}
