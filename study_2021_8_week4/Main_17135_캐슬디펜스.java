package study_2021_8_week4;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.08.23
 * @summary 
 * BOJ-gold4  512MB/1s (13056KB/160ms)
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
 * answer : 처치한 최대 적의 수
 * map[][] : 입력 맵 배열
 * archerPlace[] : 궁수 위치 조합용
 * archer[3] : 궁수 3명 배정된 열 정보
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
	
	//궁수 배치 조합
	private static void check(int start, int cnt) {
		if(cnt==3) {
			shoot(); //공격
			return;
		}
		for (int i = start; i <= M; i++) {
			if(archerPlace[i]) continue;
			archerPlace[i] = true;
			archer[cnt] = i;
			check(i+1, cnt+1);
			archerPlace[i] = false;
		}
	}

	//공격
	private static void shoot() {
		int[][] nowMap = new int[N+1][M+1]; //공격 현황 배열
		int count = 0; //처치한 적의 수
		int archerLine = N+1; //현재 궁수 행
		//궁수 N+1행부터 2행까지 이동
		while(archerLine>1) {
			//궁수별 공격
			for (int i = 0; i < 3; i++) {
				int nr = 0;
				int nc = 0;
				int min = Integer.MAX_VALUE;
				//1열 맨아래행부터 공격
				for (int c = 1; c <= M; c++) {
					for (int r = archerLine-1; r > 0; r--) {
						//적이 있는 위치이고, 이전 판에 죽인 적이 아니라면(다른 궁수와 같이 지목 가능)
						if(map[r][c]=='1' && nowMap[r][c]<=archerLine) {
							//적과의 거리 계산
							int d = Math.abs(archerLine-r) + Math.abs(archer[i]-c);
							if(d>D) break; //닿을 수 없는 적인 경우 해당 열에서 더이상 공격할 수 없다.
							if(d<=D && d<min) { //닿을 수 있는 적, 현재 가장 가까운 적인 경우
								min = d;
								nr = r;
								nc = c;
							}
						}
					}
				}
				//적 탐색 완료 - 아직 죽인 적 없는 경우 적 제거하기
				if(map[nr][nc]=='1' && nowMap[nr][nc]==0) {
					count++;
					nowMap[nr][nc] = archerLine;
				}
			}
			archerLine--; //궁수 이동
		}
		answer = Math.max(answer, count);
	}

}
