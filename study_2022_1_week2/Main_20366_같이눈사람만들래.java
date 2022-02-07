package study_2022_1_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.1.17
 * @summary 
 * BOJ-gold3  1024MB/2s
 * 눈덩이 N개, 지름 H
 * 1눈사람 = 2눈덩이
 * 아래 눈덩이는 위 눈덩이보다 커야함
 * 눈사람 키 = 두 눈덩이 지름 합
 * 엘사와 안나 눈사람 키차이 가장 작은 경우 출력
 * 
 * N : 4~600
 * H : 1~10^9
 */
public class Main_20366_같이눈사람만들래 {

	static int N, answer = Integer.MAX_VALUE;
	static int[] snow;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		snow = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			snow[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(snow);
		for (int i = 0; i < args.length; i++) {
			
		}
	}

}
