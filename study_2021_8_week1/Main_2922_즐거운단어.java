package study_2021_8_week1;

import java.util.Arrays;
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
	static int num;
	static long answer;
	static boolean L;
	static int[] funIndex = new int[10];
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		s = scann.next();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='_') {
				funIndex[num] = i;
				num++;
			}
			if(s.charAt(i)=='L') L=true;
		}
		check(sb.toString(), 0, L);
		System.out.println(answer);
		scann.close();
	}


	private static void check(String word, int i, boolean canL) {
		if(i==s.length()) {
			if(same(word, i)) return;
			if(!L && !canL) return;
			System.out.print(word+" ");
			long cnt = 1;
			int cntX = 0;
			int cntO = 0;
			for (int n = 0; n < num; n++) {
				if(word.charAt(funIndex[n])=='X') {
					cnt*=21;
					cntX++;
				}
				else {
					cnt*=5;
					cntO++;
				}
			}
			if(!L) {
				cnt /= 21;				
				if(cntX>1 && cntO!=0) {
					cnt *= cntX;
					int same = (int)Math.pow(2, cntX) - (cntX+1);
					same *= (int)Math.pow(5, cntO);
					cnt -= same;
				}
			}
			System.out.println(cnt);
			answer += cnt;
			return;
		}
		
		if(i>=3) if(same(word, i)) return;
		StringBuilder sb = new StringBuilder();
		sb.append(word);
		if(s.charAt(i)=='_') {
			check(sb.append('O').toString(), i+1, canL);
			sb.deleteCharAt(i);
			check(sb.append('X').toString(), i+1, true);
		}
		else if(isVow(s.charAt(i))) {
			check(sb.append('O').toString(), i+1, canL);
		}
		else check(sb.append('X').toString(), i+1, canL);
	}


	private static boolean same(String word, int i) {
		return word.charAt(i-1) == word.charAt(i-2) && word.charAt(i-2) == word.charAt(i-3);
	}


	private static boolean isVow(char c) {
		return c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
	}

}
