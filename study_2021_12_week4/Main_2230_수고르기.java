package study_2021_12_week4;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.1.1
 * @summary 
 * BOJ-gold5  128MB/1s
 * N개의 정수로 이루어진 수열 A[1],...,A[N]
 * 수열에서 두 수 골랐을 때 차이가  M 이상이면서 제일 작은 경우 구하기
 * 두 수 같을 수 있음
 * N : 1~100,000
 * M : 0~2,000,000,000
 */
public class Main_2230_수고르기 {

	static int N, M, L, R, answer=Integer.MAX_VALUE;
	static int[] A;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(A);
		while(R<N) {
			if(A[R]-A[L]==M) { //차이가 M인 경우 = 최소
				answer = M;
				break;
			}
			else if(A[R]-A[L]<M) { //왼쪽 포인터 이동
				R++;
			}
			else { //오른쪽 포인터 이동
				answer = Math.min(answer,A[R]-A[L]);
				L++;
			}
		}
		System.out.println(answer);
	}

}
