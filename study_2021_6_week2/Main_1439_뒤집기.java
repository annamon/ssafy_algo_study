package study_2021_6_week2;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.11
 * @summary 
 * BOJ-silver5  128MB/2s (13380KB/124ms)
 * 문자열 S에 있는 모든 숫자를 전부 같게 만들기
 * S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것
 * 1을 0으로, 0을 1로
 * 행동의 최소 횟수?
 * 
 * count : 뒤집기 횟수
 * s : 문자열
 * standard : 기준
 * now : 현재 문자
 * next : 다음 문자
 */
public class Main_1439_뒤집기 {

	static int count;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		String s = scann.nextLine();
		char standard = s.charAt(0); //기준을 설정해두면 0->1 혹은 1->0 중 한 가지의 경우에만 카운트한다.
		char now = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			char next = s.charAt(i);
			if(now != next) {
				if(now==standard) count++;
				now = next;
			}else continue;
		}
		System.out.println(count);
	}
}
