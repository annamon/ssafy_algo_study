package study_2021_9_week5;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.20
 * @summary 
 * BOJ-silver4  128MB/2s (KB/ms)
 * 정수 N개 주어졌을 때 이 안에 X라는 정수가 존재하는지 알아보기
 * 
 * N : 주어진 숫자 개수 1~100,000
 * arr[] : 주어진 숫자 배열
 * M : 찾을 숫자 개수 1~100,000
 * number[] : 찾을 숫자 배열
 */
public class Main_1920_수찾기4 {

	static int N, M, left, right, mid;
	static int[] number, arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		M = Integer.parseInt(br.readLine());
		number = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			find(Integer.parseInt(st.nextToken()));
		}
		System.out.println(sb.toString());
	}
	
	private static void find(int now) throws Exception {
		boolean exist = false;
		left = 0;
		right = N-1;
		while(left<=right) {
			mid = (left+right)/2;
			if(now==arr[mid]) {
				exist = true;
				break;
			}
			if(now<arr[mid]) right = mid-1;
			else left = mid+1;
		}
		if(exist) sb.append(1);
		else sb.append(0);
		sb.append("\n");
	}
}
