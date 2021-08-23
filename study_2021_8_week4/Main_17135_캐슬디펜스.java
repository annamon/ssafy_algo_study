package study_2021_8_week4;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.08.23
 * @summary 
 * BOJ-gold4  512MB/1s (KB/ms)
 * NxM 격자판, 각 칸에 적은 최대 하나
 * 격자판 밑에 성 있음
 * 0빈칸, 1적이 있는 칸
 * 성에 궁수 3명 배치, 1칸 최대 1궁수
 * 턴마다 궁수는 동시에 공격, 궁수당 한 명 공격 가능
 * 거리 D(|r1-r2|+|c1-c2|)이하인 적 중에 가장 가까운 적, 여럿인 경우 가장 왼쪽 적 공격
 * 공격받은 적은 게임에서 제외
 * 궁수 공격 끝나면 적 한칸 아래로 이동, 성으로 이동시 제외
 * 모든 적이 제외되면 게임 종료.
 * 제거할 수 있는 적의 최대 수?
 * 
 * N, M : 3~15
 * D : 거리, 1~10
 */
public class Main_17135_캐슬디펜스 {
	
	static int N, M, D, answer;
	static char[][] map;
	static boolean[] archerPlace;
	static int[] archer = new int[3];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		archerPlace = new boolean[M+1];
		map = new char[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		check(1,0);
		System.out.println(answer);
	}
	
	private static void check(int start, int cnt) {
		if(cnt==3) {
			shoot();
			return;
		}
		for (int i = start; i <= M; i++) {
			if(archerPlace[i]) continue;
			archerPlace[i] = true;
			check(i+1, cnt+1);
			archerPlace[i] = false;
		}
	}

	private static void shoot() {
		boolean[][] nowMap = new boolean[N+1][M+1];
		int index = 0;
		for (int i = 1; i <= M; i++) {
			if(archerPlace[i]) {
				archer[index] = i;
				index++;
			}
		}
		int count = 0;
		int archerLine = N+1;
		while(archerLine>1) {
			for (int i = 0; i < 3; i++) {
				int nr = 0;
				int nc = 0;
				int min = Integer.MAX_VALUE;
				for (int c = 1; c <= M; c++) {
					for (int r = archerLine-1; r > 0; r--) {
						if(map[r][c]=='1') {
							int d = Math.abs(archerLine-r) + Math.abs(archer[i]-c);
							if(d>D) break;
							if(d<=D && d<min) {
								min = d;
								nr = r;
								nc = c;
							}
						}
					}
				}
				if(map[nr][nc]=='1' && !nowMap[nr][nc]) {
					count++;
					nowMap[nr][nc] = true;
				}
			}
			archerLine--;
		}
		answer = Math.max(answer, count);
	}

}
