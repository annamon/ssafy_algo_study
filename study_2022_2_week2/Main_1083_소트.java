package study_2022_2_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.2.7
 * @summary 
 * BOJ-gold4  128MB/2s
 * 
 * 크기가 N인 배열 A가 있다.
 * 배열에 있는 모든 수는 서로 다름
 * 연속된 두 개의 원소만 교환 가능
 * 교환은 최대 S번 가능.
 * 소트한 결과가 사전순으로 가장 뒷서는 것 출력
 * 
 * N : ~50
 * S : 1000,000 이하 정수
 * 
 */
public class Main_1083_소트 {

	static int N, S, index;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		S = Integer.parseInt(br.readLine());
		while(S>0) {
			if(index==N-1) index=0;
			if(arr[index]<arr[index+1]) {
				int temp = arr[index];
				arr[index] = arr[index+1];
				arr[index+1] = temp;
				S--;
				index=0;
			}
			else index++;			
		}
		for (int i = 0; i < N; i++) {			
			System.out.print(arr[i]+" ");
		}
	}

}
