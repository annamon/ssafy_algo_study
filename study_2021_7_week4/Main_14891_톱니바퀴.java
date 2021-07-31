package study_2021_7_week4;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.08.1
 * @summary 
 * BOJ-gold5  512MB/2s (13132KB/124ms)
 * 톱니바퀴 A 회전할 때
 * A와 B가 맞닿은 극이 다르면 -> 반대방향 회전 / 극이 같으면 -> 정지 
 * 톱니바퀴 4개, 8개 정수, 시계방향 순서, N극 0, S극 1
 * 회전시킨 후 점수 합 출력
 * 점수 : S극, 1번 1, 2번 2, 3번 4, 4번 8점
 * 입력 : 회전시킨 톱니바퀴 번호, 방향(1:시계, -1:반시계)
 * 
 * K : 회전횟수
 * num : 회전할 톱니 번호
 * ccw : 회전 방향
 * answer : 정답
 * wheel[] : 톱니바퀴 4개 정보
 * beforePole[][] : 회전하기 전 톱니 index
 * pole[][] : 회전하고 난 후 톱니 index, [0]: 좌 / [1]: 우
 */
public class Main_14891_톱니바퀴 {
	
	static int K, num, cw, answer;
	static String[] wheel = new String[5];
	static int[][] beforePole = new int[5][2];
	static int[][] pole = new int[5][2];
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		for (int i = 1; i <= 4; i++) {
			wheel[i] = scann.nextLine();
		}
		pole[1][0] = pole[2][0] = pole[3][0] = pole[4][0] = 6; //좌
		pole[1][1] = pole[2][1] = pole[3][1] = pole[4][1] = 2; //우
		beforePole[1][0] = beforePole[2][0] = beforePole[3][0] = beforePole[4][0] = 6; //좌
		beforePole[1][1] = beforePole[2][1] = beforePole[3][1] = beforePole[4][1] = 2; //우
		K = scann.nextInt();
		//회전
		for (int t = 0; t < K; t++) {
			num = scann.nextInt();
			cw = scann.nextInt();
			turn(num, cw);
		}
		point(); //점수 계산
		System.out.println(answer);
	}

	//회전 로직
	private static void turn(int num, int ccw) {
		int n = num;
		int c = -ccw; //ccw=1인 경우 실제 톱니 index는 -1(-ccw) 된다.
		//고른 톱니바퀴 회전 (n번째)
		pole[n][0] += c;
		pole[n][1] += c;
		
		//고른 톱니의 오른편 톱니들 확인하기
		boolean can = true;
		while(true) {
			//고른 톱니가 4번째 톱니거나 더 이상 회전할 수 없다면 종료 
			if(n==4 || !can) break;
			//그 외 경우
			n++;
			//확인하려는 톱니(n)의 왼쪽0과 왼편 톱니(n-1)의 오른쪽1의 맞물리는 극이 같은 경우 -> 회전 중지
			if(wheel[n].charAt(beforePole[n][0]) == wheel[n-1].charAt(beforePole[n-1][1])) can = false;
			else { // 그 외 경우 n-1 톱니와 반대 방향으로 회전
				c *= -1;
				pole[n][0] += c;
				pole[n][1] += c;
			}
		}
		
		//고른 톱니의 왼편 톱니들 확인하기
		n = num;
		c = -ccw;
		can = true;
		while(true) {
			//고른 톱니가 1번째 톱니거나 더 이상 회전할 수 없다면 종료 
			if(n==1 || !can) break;
			//그 외 경우
			n--;
			//확인하려는 톱니(n)의 오른쪽1과 오른편 톱니(n+1) 왼쪽0과 맞물리는 극이 같은 경우 -> 회전 중지
			if(wheel[n+1].charAt(beforePole[n+1][0]) == wheel[n].charAt(beforePole[n][1])) can = false;
			else { // 그 외 경우 n+1 톱니와 반대 방향으로 회전
				c *= -1;
				pole[n][0] += c;
				pole[n][1] += c;
			}
		}
		//이전 극과 현재 극 배열 동기화
		sync();
	}
	
	//극 동기화
	private static void sync() {
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < 2; j++) {
				//톱니바퀴 index 조정
				if(pole[i][j]>=8) pole[i][j] %= 8;
				if(pole[i][j]<0) pole[i][j] +=8;
				beforePole[i][j] = pole[i][j];
			}
		}
	}
	
	//점수 계산
	private static void point() {
		for (int i = 1; i <= 4; i++) {
			int n = pole[i][1] - 2; //12시 방향 index = 톱니의 오른쪽-2
			//톱니바퀴 index 조정
			if(n>7) n%=8;
			if(n<0) n+=8;
			//S극인 경우 점수 계산
			if(wheel[i].charAt(n) == '1')
				answer += Math.pow(2, i-1);
		}
	}
}
