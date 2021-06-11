package study_2021_6_week2;

import java.util.Scanner;

public class Solution_ssafy5_별헤는밤 {
	static int T, N, M, count=1, size;
	static int[][] sky;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			M = scann.nextInt();
			sky = new int[N][N];
			for (int i = 0; i < M; i++) {
				star(scann.nextInt(), scann.nextInt(), scann.nextInt(), count);
				if(!flag) count++;
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(sky[i][j]);
//				}
//				System.out.println();
//			}
			System.out.println("#"+t+" "+ count + " " +size);
		}
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	static boolean flag = false;
	private static void star(int r, int c, int bright, int count) {
		int cnt = 0;
		for (int i = r-(bright-1); i <= r+(bright-1); i++) {
			for (int j = c-cnt; j <= c+cnt; j++) {
				if(check(i,j)) {
					if(flag) {
						sky[i][j] = count;
					}else {						
						if(sky[i][j]== count) continue; //같은 별자리 이미 칠함
						else if(sky[i][j]!=0) { //다른 별이 있는 경우 하나의 별자리로 묶기
							flag = true;
							star(r, c, bright, sky[i][j]);
							return;
						}
						else { //그 외 경우 별 등록
							sky[i][j]=count;
						}
					}
				}
			}
			if(i<r) cnt++;
			else cnt--;
		}
	}
	
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
