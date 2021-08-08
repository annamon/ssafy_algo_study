package study_2021_8_week1;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.08.08
 * @summary 
 * BOJ-gold4  128MB/1s (KB/ms)
 * 즐거운 단어 만들기
 * _ 적힌 곳에 알파벳 적기
 * 모음(AEIOU) 연속3번, 자음이 연속3번 나오지 않아야함.
 * L 반드시 포함할 것
 * 즐거운 단어 만드는 경우의 수 구하기
 * 
 * 단어 길이 최대 100
 * 밑줄 개수 최대 10
 */
public class Main_2922_즐거운단어 {

	static String s;
	static int con, vow, n, answer=1;
	static int[][] word;
	static boolean L;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		s = scann.next();
		word = new int[s.length()][2];
		for (int i = 0; i < s.length(); i++) {
			if(i==0 && s.charAt(0)=='_' && s.length()>=3) checkFirst();
			else if(i==s.length()-1 && s.charAt(s.length()-1)=='_') checkLast();
			else {
				check(i);
			}
		}
		if(!L) n--;
		System.out.println(L);
		System.out.println(n);
		for (int i = 0; i < 10; i++) {
			System.out.print(word[i]+" ");
		}
		if(n==0) System.out.println(0);
		else {
			for (int i = 0; i <= n; i++) {
				answer *= word[i];
			}
			System.out.println(answer);
		}
		scann.close();
	}
	
	//마지막 글자가 _인 경우
	private static void checkLast() {
		
	}

	//첫 글자가 _인 경우
	private static void checkFirst() {
		if(isVow(s.charAt(1)) && isVow(s.charAt(2))) {
			word[0][0] = 21;
			answer = 21;
		}
		else if(!isVow(s.charAt(1)) && s.charAt(1)!='_' 
				&& !isVow(s.charAt(2)) && s.charAt(2)!='_') {
			word[0][1] = 5;
			answer = 5;
		}
		else {
			word[0][0] = 21;
			word[0][1] = 5;
			answer = 26;
		}
	}

	private static void check(int i) {
		if(s.charAt(i-1)=='_' && s.charAt(i-1)=='_')
	}

	private static boolean isVow(char c) {
		return c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
	}

}
