package study_2021_7_week1;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.07.08
 * @summary 
 * BOJ-bronze2  128MB/2s (28724KB/336ms)
 * 단어 개수 세기. 중복 단어 허용
 * 
 * s : 문자열 (길이 1,000,000 이하)
 * before : 이전 문자
 * now : 현재 문자
 * answer : 단어 개수
 */
public class Main_1152_단어의개수 {

	static int answer;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		String s = scann.nextLine();
		char before = s.charAt(0);
		if(before!=' ') answer++; //맨처음 공백이 아니면 단어 개수 +1
		for (int i = 1; i < s.length(); i++) {
			char now = s.charAt(i);
			//새 단어 시작하면 정답 +1
			if(before==' '&& now!=' ') {
				answer++;
				before = now;
			}
			//단어가 끝나는 경우
			else if(before!=' '&& now==' ') before = now;
			//그 외 경우 무시
			else continue;
		}
		System.out.println(answer);
		scann.close();
	}

}
