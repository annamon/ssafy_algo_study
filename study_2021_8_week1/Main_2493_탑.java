package study_2021_8_week1;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.08.06
 * @summary 
 * BOJ-gold5  128MB/1.5s (150568KB/608ms)
 * 탑은 왼쪽 방향으로 레이저 발사
 * 레이저는 하나의 탑에서만 수신 가능
 * 레이저 맞는 곳의 자리 출력
 * 맞지 않으면 0 출력
 * 탑 높이는 서로 다름\
 * 
 * 풀이1 : 스택 이용
 * 풀이2 : 재귀 이용
 * print 보다 StringBuilder 사용하자
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
				//스택 내 탑 높이가 더 낮으면 제거
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
/*public class Main_2493_탑 {

	static int N;
	static int[] top;
	static int[] memo;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		top = new int[N+1];
		memo = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			top[i] = Integer.parseInt(st.nextToken());
		}
		memo[1] = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(memo[1] + " ");
		if(N>1) {
			for (int i = 2; i <= N; i++) {
                memo[i] = check(i, i-1);
                sb.append(memo[i] + " ");
            }
		}
        System.out.print(sb);
	}
	
	private static int check(int me, int compare) {
		//비교하는 탑이 더 큰 경우 경우
		if(top[compare]>top[me]) return compare;
		//비교하는 탑의 수신이 0인 경우
		if(memo[compare]==0) return 0;
		//그 외 경우
		return check(me, memo[compare]);
	}
}*/
