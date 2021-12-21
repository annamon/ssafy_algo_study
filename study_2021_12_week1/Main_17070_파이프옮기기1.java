package study_2021_12_week1;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.12.12
 * @summary 
 * BOJ-gold5  512MB/1s (KB/ms)
 * 파이프 벽 긁기 안 됨 = 빈 칸만 차지해야함
 * 동쪽, 남동쪽, 남쪽으로만 이동 가능
 * 빈칸0, 벽1 / N,N으로 이동
 * 
 * N : 집 크기 3~16
 */
public class Main_17070_파이프옮기기1 {

	static int N, answer;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		run();
		System.out.println(answer);
	}
	
	//type 1동 2남 3남동
	static Queue<int[]> que = new LinkedList<>();
	private static void run() {
		que.add(new int[] {0,1,1});
		while(!que.isEmpty()) {
			int r = que.peek()[0];
			int c = que.peek()[1];
			int type = que.poll()[2];
			if(r==N-1 && c==N-1) answer++;
			else {
				//출발 파이프 모양이 1
				if(type==1) {
					if(c+1<N) { //1파이프 놓기
						if(check1(r,c)) que.add(new int[] {r, c+1, type});
						if(r+1<N) { //3파이프 놓기
							if(check3(r, c)) que.add(new int[] {r+1, c+1, 3});
						}
					}
				}
				//출발 파이프 모양이 2
				else if(type==2) {
					if(r+1<N) { //2파이프 놓기
						if(check2(r,c)) que.add(new int[] {r+1, c, type});
						if(c+1<N) { //3파이프 놓기
							if(check3(r,c)) que.add(new int[] {r+1, c+1, 3});
						}
					}
				}
				else { //출발 파이프 모양이 3
					if(c+1<N) { //1파이프 놓기
						if(check1(r,c)) que.add(new int[] {r, c+1, type}); //1파이프 놓기
						if(r+1<N) if(check3(r,c)) que.add(new int[] {r+1, c+1, 3}); //3파이프 놓기
					}
					else if(r+1<N) {
						if(check2(r,c)) que.add(new int[] {r+1, c, 2}); //2파이프 놓기
					}
				}
			}
		}
	}
	        
	private static boolean check1(int R, int C) {
		if(map[R][C+1]==0) return true;
		else return false;
	}
	
	private static boolean check2(int R, int C) {
		if(map[R+1][C]==0) return true;
		else return false;
	}

	private static boolean check3(int R, int C) {
		boolean flag = true;
		if(map[R][C+1]==1 || map[R+1][C]==1 || map[R+1][C+1]==1) flag = false;
		return flag;
	}

}
