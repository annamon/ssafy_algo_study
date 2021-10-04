package study_2021_9_week5;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.10.03
 * @summary 
 * BOJ-gold5  128MB/1s (KB/ms)
 * 조별 6개국 구성, 각 국가별 5번 경기
 * 각 나라의 승, 무승부, 패 수가 가능한 결과인지 판별
 * 4개 결과, 가능한 경우 1, 불가능한 경우 0 출력
 */
public class Main_6987_월드컵 {

	static int w, d, l;
	static int[] win, draw, lose; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			win = new int[6];
			draw = new int[6];
			lose = new int[6];
			w = 0;
			d = 0;
			l = 0;
			for (int i = 0; i < 6; i++) {
				win[i] = Integer.parseInt(st.nextToken());
				draw[i] = Integer.parseInt(st.nextToken());
				lose[i] = Integer.parseInt(st.nextToken());
				w += win[i];
				d += draw[i];
				l += lose[i];
			}
			//전체 경기 수 30아니거나 승패 수가 다르거나 무승부 수가 짝수가 아닌 경우 불가능
			if(w+d+l!=30 || w!=l || d%2!=0) {
				System.out.print("0 ");
			}
			//그 외 가능 판별
			else {
				if(check()) System.out.print("1 ");
				else System.out.print("0 ");
			}
		}
	}
	
	//가능한지 판별
	private static boolean check() {
		for (int i = 0; i < 6; i++) {
			if(win[i]!=0) {
				for (int j = 5; j >= 0; j--) {
					//본인, 패 기록 없는 팀과 경기 불가능
					if(i==j || lose[j]==0) continue;
					//세상에 이렇게 풀면 안됨 ㅠ
					if(win[i]>lose[j]) {
						win[i] -= lose[j];
						lose[j] = 0;
					}
					else {
						lose[j] -= win[i];
						win[i] = 0;
						break;
					}
				}
				if(win[i]!=0) return false;
			}
		}
		//무승부 기록이 있는 경우
		if(d!=0) {
			for (int i = 0; i < 6; i++) {
				if(draw[i]!=0) {
					for (int j = 5; j>=0; j--) {
						if(i==j || draw[j]==0) continue;
						if(draw[i]>draw[j]) {
							draw[i] -= draw[j];
							draw[j] = 0;
						}
						else {
							draw[j] -= draw[i];
							draw[i] = 0;
							break;
						}
					}
					if(draw[i]!=0) return false;
				}
			}
		}
		return true;
	}

}
