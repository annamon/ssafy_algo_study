package study_2021_6_week3;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.14
 * @summary 
 * BOJ-silver5  128MB/2s (12796KB/104ms)
 * 폴리오미노 AAAA BB 무한개
 * .와X로 이루어진 보드판
 * 겹침 없이 폴리오미노로 X 다 덮기, .는 덮으면 안 됨
 * 사전순으로 답 출력
 * 폴리오미노로 모두 덮은 보드판 출력
 * 
 * board : 보드판 크기 최대 500
 * answer : 정답
 * countX : X 개수
 * can : 폴리오미노로 덮을 수 있는가
 */
public class Main_1343_폴리오미노 {

	static String board;
	static StringBuilder answer = new StringBuilder();
	static int countX;
	static boolean can = true;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		board = scann.next();
		for (int i = 0; i < board.length(); i++) {
			if(!can) break;
			//현재 문자가 X인 경우
			if(board.charAt(i) == 'X') {
				countX++;
			}
			//현재 문자가 .인 경우
			else if(board.charAt(i)=='.') {
				polyomino();
				answer.append('.');
			}
		}
		//마지막에 X가 나왔다면 점검하기
		if(countX!=0) polyomino();
		//결과 출력
		if(!can) System.out.println(-1);
		else System.out.println(answer);
	}

	//폴리오미노
	private static void polyomino() {
		//.이전 X 개수가 홀수인 경우
		if(countX%2==1) can = false;
		//그 외의 경우 counX 4로 나눈 몫만큼 AAAA 붙이기
		for (int i = 0; i < countX/4; i++) {
			answer.append("AAAA");
		}
		//나머지가 있는 경우 BB 붙이기
		if(countX%4==2) answer.append("BB");
		countX = 0; //X 개수 초기화
	}
}