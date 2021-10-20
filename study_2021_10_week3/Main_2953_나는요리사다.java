package study_2021_10_week3;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.10.20
 * @summary 
 * BOJ-bronze3  128MB/1s (11472KB/76ms)
 * 최종 우승자와 점수 구하기
 */
public class Main_2953_나는요리사다 {

	static int winner, score;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; i <= 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			for (int n = 0; n < 4; n++) {
				sum += Integer.parseInt(st.nextToken());
			}
			if(score < sum) {
				score = sum;
				winner = i;
			}
		}
		System.out.println(winner + " " + score);
	}

}
