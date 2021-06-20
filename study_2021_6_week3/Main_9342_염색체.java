package study_2021_6_week3;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.18
 * @summary 
 * BOJ-silver4  64MB/2s (12884KB/116ms)
 * A,B,C,D,E,F 0or1개로 시작
 * 그 다음 A, F, C 각각 n개
 * 그 다음 A,B,C,D,E,F 0or1개 끝
 * 규칙 지키는 경우 Infected! 아닌 경우 Good 출력
 * 
 * T : 테케 개수  (≤20)
 * 알파벳 최대 200개
 * chromosome : 규칙 염색체 (정규식)
 */
public class Main_9342_염색체 {

	static int T;
	static String st, chromosome = "^[A-F]?A+F+C+[A-F]?$";
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 0; t < T; t++) {
			st = scann.next();
			if(st.matches(chromosome)) System.out.println("Infected!");
			else System.out.println("Good");
		}
	}
	
/*	100%에서 틀린 코드. 정규식으로 풀기
	static boolean rule;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 0; t < 15; t++) {
			chromosome = scann.next();
			rule = check(chromosome);
			if(rule) System.out.println("Infected!");
			else System.out.println("Good");
		}
	}
	private static boolean check(String ch) {
		if(!abcdef(ch.charAt(0))) return false;
		if(!abcdef(ch.charAt(ch.length()-1))) return false;
		int A = ch.indexOf('A');
		int F = ch.indexOf('F');
		int C = ch.indexOf('C');
		if(!(A<F && F<C)) return false;
		int lastA = ch.lastIndexOf('A');
		int lastF = ch.lastIndexOf('F');
		if(!(lastA+1 == F && lastF+1 == C)) return false;
		return true;
	}
	private static boolean abcdef(char c) {
		return c=='A' || c=='B' || c=='C' || c=='D' || c=='E' || c=='F';
	}*/
}