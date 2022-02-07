package study_2021_12_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.12.19
 * @summary 
 * BOJ-silver1  512MB/2s (KB/ms)
 * 지도 두 줄, N칸
 * 안전한 칸1 = 이동 가능, 위험한 칸0 = 이동 불가능
 * 왼쪽 1번칸에서 시작
 * 세 가지 중 하나 해야함
 * 한칸 앞으로 이동 i=>i+1 / 뒤로 이동 i=>i-1 / 반대줄로 점프 i=>i+k
 * N번 칸보다 더 큰 칸으로 이동하는 경우 클리어
 * 1초에 한 칸씩 각 줄의 첫 칸 사라짐
 * 유저 먼저 움직이고 그 다음 칸 소멸
 * 칸 정보 주어진 경우 클리어할 수 있는가? 가능시1 불가능시0 출력
 * 
 * N, k : 1~100,000
 */
public class Main_15558_점프게임 {

	static int N, K;
	static int[] left, right;
	static boolean clear = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		left = new int[N+1];
		right = new int[N+1];
		//칸 정보 저장
		String s = br.readLine();
		for (int i = 1; i <= N; i++) {
			left[i] = s.charAt(i-1)-'0';
		}
		s = br.readLine();
		for (int i = 1; i <= N; i++) {
			right[i] = s.charAt(i-1)-'0';
		}
		find();
		if(clear) System.out.println(1);
		else System.out.println(0);
	}
	
	static Queue<int[]> que;
	private static void find() {
		que = new LinkedList<>();
		que.add(new int[] {0, 1, 1});
		while(!que.isEmpty()) {
			int line = que.peek()[0];
			int now = que.peek()[1];
			int remove = que.poll()[2];
			if(now>N) {
				clear = true;
				break;
			}
			//현재 왼쪽라인
			if(line==0) {
				if(left[now+1]==1) que.add(new int[] {line, now+1, remove+1});
				if(now-1>remove && left[now-1]==1) que.add(new int[] {line, now-1, remove+1});
				if(now+K<=N) {
					if(right[now+K]==1) que.add(new int[] {1, now+K, remove+1});
				}
				else {
					que.add(new int[] {1, now+K, remove+1});
				}
			}
			//현재 오른쪽라인
			else {
				if(right[now+1]==1) que.add(new int[] {line, now+1, remove+1});
				if(now-1>remove && right[now-1]==1) que.add(new int[] {line, now-1, remove+1});
				if(now+K<=N) {
					if(left[now+K]==1) que.add(new int[] {0, now+K, remove+1});
				}
				else {
					que.add(new int[] {1, now+K, remove+1});
				}
				
			}
		}
	}

}
