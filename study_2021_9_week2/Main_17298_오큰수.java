package study_2021_9_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.10
 * @summary 
 * BOJ-gold4  512MB/1s (198936KB/948ms)
 * 오큰수 : 현재 수보다 오른쪽에 있고, 현재 수보다 크고, 가장 왼쪽에 있는 수
 * 오큰수가 없는 경우 -1 출력
 * 
 * N : 수열 크기, 1~1,000,000
 * number[] : 현재 수 배열 -> 오큰수 저장
 */
public class Main_17298_오큰수 {

	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] number = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> index = new Stack<>();
		for (int i = 0; i < N; i++) {
			//저장된 인덱스가 현재 수보다 작다면 값 갱신
			while (!index.isEmpty() && number[index.peek()] < number[i]) {
				number[index.pop()] = number[i];
			}
			//현재 인덱스 스택에 저장
			index.push(i);
		}
		//오큰수 없으므로 -1
		while (!index.isEmpty()) number[index.pop()] = -1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(number[i]).append(" ");
		}
		
		System.out.println(sb);
	}

}
