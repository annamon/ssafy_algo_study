package study_2021_11_week4;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.11.25
 * @summary 
 * BOJ-silver3  128MB/2s (12248KB/92ms)
 * FIFO
 * 현재 큐의 가장 앞에 있는 문서의 중요도 확인하기
 * 나머지 문서 중 현재 문서보다 중요도가 높은 게 하나라도 있다면 뒤로 보내기
 * 숫자가 클수록 중요함
 * 중요도 : 1~9
 * 
 * N : 문서 개수 1~100
 */
public class Main_1966_프린터큐 {

	static int T, N, M, answer;
	static int[] count;
	static Queue<int[]> que;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			count = new int[10];
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			que = new LinkedList<>();
			for (int n = 0; n < N; n++) {
				int num = Integer.parseInt(st.nextToken());
				count[num]++;
				que.add(new int[] {n, num});
			}
			while(!que.isEmpty()) {
				int[] now = que.poll();
				boolean print = true;
				for (int i = now[1]+1; i <= 9; i++) {
					if(count[i]!=0) {
						que.add(now);
						print = false;
						break;
					}
				}
				if(print) {
					answer++;
					if(now[0]==M) {
						System.out.println(answer);
						break;
					}
					count[now[1]]--;
				}
			}
			
		}
	}

}
