package study_2022_2_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.2.7
 * @summary 
 * BOJ-gold5  256MB/1s (11836KB/100ms)
 * 
 * 세로 H 가로 W 1~500
 * 고이는 빗물 총량 계산하기
 * 전혀 고이지 않는 경우 0 출력
 */
public class Main_14719_빗물 {

	static int H, W, answer;
	static int[] block;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		//블럭 높이 저장
		block = new int[W];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		//현재 블럭 기준으로 좌우에 큰 블럭이 있는지 확인
		for (int i = 1; i < W-1; i++) {
			int now = block[i];
			int left = 0;
			int right = 0;
			for (int l = 0; l < i; l++) {
				left = Math.max(left, block[l]);
			}
			for (int r = i+1; r < W; r++) {
				right = Math.max(right, block[r]);
			}
			//물이 고이는 블럭인 경우 고이는 양 계산
			if(now<left && now<right) {
				answer += (Math.min(left, right) - now);
			}
		}
		System.out.println(answer);
	}

}
