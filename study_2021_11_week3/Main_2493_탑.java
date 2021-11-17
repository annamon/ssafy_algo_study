package study_2021_11_week3;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.11.17
 * @summary 
 * BOJ-gold5  128MB/1s (KB/ms)
 * 왼쪽에서 오른쪽으로 높은 탑에 신호 보내기
 * N : 탑 수, 1~500000
 */
public class Main_2493_탑 {

	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<int[]> top = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int now = Integer.parseInt(st.nextToken());
			while(!top.isEmpty()) {
				if(top.peek()[0] < now) top.pop();
				else {
					sb.append(top.peek()[1] + " ");
					break;
				}
			}
			if(top.isEmpty()) sb.append("0 ");
			top.push(new int[] {now, i});
		}
		System.out.println(sb);
	}

}
