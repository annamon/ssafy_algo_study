package study_2021_6_week2;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.11
 * @summary 
 * 싸피 제작문제4  256MB/6s (KB/ms)
 * 금고는 시계방향으로 돌릴 때와 반시계방향으로 돌릴 때 소요되는 시간이 다르다.
 * 1번 자물쇠 : 시계방향 1초, 반시계 1초
 * 2번 자물쇠 : 시계방향 3초, 반시계 2초
 * 3번 자물쇠 : 시계방향 5초, 반시계 4초
 * 4번 자물쇠 : 시계방향 7초, 반시계 6초
 * 초기 비밀번호와 정답 비밀번호가 주어졌을 때 맞춰지는 데 필요한 최소 소요 시간?
 * 
 * T : 테스트케이스
 * now : 초기 비밀번호
 * answer : 정답 비밀번호
 * cwt, cw : 시계방향 이동
 * ccwt, ccw : 반시계방향 이동
 * time : 걸린 시간
 * 
 * 주의! 시계방향으로 돌리면 알파벳은 줄어듦
 */
public class Solution_ssafy4_금고털기 {

	static String now, answer;
	static int T, time, cwt, ccwt;
	static int[] cw = {1,3,5,7};
	static int[] ccw = {1,2,4,6};
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			now = scann.next();
			answer = scann.next();
			time = 0;
			for (int i = 0; i < 4; i++) {
				char pw1 = now.charAt(i);
				char pw2 = answer.charAt(i);
				int dif = pw1 - pw2;
				// 제자리
				if(dif==0) continue;
				// 정답이 초기보다 왼쪽에 있을 때
				else if(dif>0) {
					cwt = dif * cw[i];
					ccwt = (26 - dif) * ccw[i];
				}
				// 정답이 초기보다 오른쪽에 있을 때
				else {
					cwt = (26 - Math.abs(dif)) * cw[i];
					ccwt = Math.abs(dif) * ccw[i];
				}
				time += Math.min(cwt, ccwt);
			}
			System.out.println("#"+t+" "+time);
		}
	}

}
