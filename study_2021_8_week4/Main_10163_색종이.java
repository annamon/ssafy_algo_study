package study_2021_8_week4;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.08.27
 * @summary 
 * BOJ-bronze1  64MB/1s (KB/ms)
 * 색종이 겹쳐 붙일 때 각 색종이별 보이는 면적 구하기
 * 
 * N : 색종이 수, 1~100
 * map[][] : 색종이 붙이는 공간
 * count[] : 색종이별 보이는 면적
 */
public class Main_10163_색종이 {

	static int N;
	static int[][] map = new int[1001][1001];
	static int[] count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			fill(i,x,y,w,h);
		}
		//색종이별 보이는 면적 세기
		count = new int[N+1];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if(map[i][j]!=0) {
					count[map[i][j]]++;
				}
			}
		}
		//출력
		for (int i = 1; i <= N; i++) {
			System.out.println(count[i]);
		}
	}
	
	//색종이 붙이기
	private static void fill(int i, int x, int y, int w, int h) {
		for (int a = x; a < x+w ; a++) {
			for (int b = y; b < y+h; b++) {
				map[b][a] = i;
			}
		}
	}

}
