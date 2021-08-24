package study_2021_8_week4;

import java.util.*;

/**
 * @author anna
 * @date 2021.08.24
 * @summary 
 * BOJ-silver1  256MB/2s (13956KB/444ms)
 * 행운의 문자열 = 인접한 모든 문자가 같지 않은 문자열
 * 서로 다른 행운의 문자열 몇 개 만들 수 있는가?
 * 
 * word : 입력 문자열. 길이 최대 10, 소문자
 * answer : 정답 개수
 * index[] : 문자 순열
 * isSelected[] : 문자 선택처리용
 * alpha[] : 중복 알파벳 카운트
 */
public class Main_1342_행운의문자열 {

	static int answer;
	static String word;
	static int[] index, alpha = new int[26];
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		word = scann.next();
		index = new int[word.length()];
		isSelected = new boolean[word.length()];
		//알파벳 중복 개수 세기
		for (int i = 0; i < word.length(); i++) {
			alpha[word.charAt(i)-'a']++;
		}
		//행운의 문자열 찾기
		check(0);
		//중복되는 행운의 문자열 제거
		for (int i = 0; i < 26; i++) {
			if(alpha[i]>1) checkRepeated(alpha[i]);
		}
		System.out.println(answer);
		scann.close();
	}
	
	//중복되는 행운의 문자열 제거
	private static void checkRepeated(int num) {
		int factorial = 1;
		int n = 2;
		//알파벳 개수 팩토리얼로 나누기
		while(n<=num) {
			factorial *= n;
			n++;
		}
		answer /= factorial;
	}

	//행운의 문자열 찾기
	private static void check(int cnt) {
		if(cnt==word.length()) {
			//인접 문자 체크
			for (int i = 1; i < word.length(); i++) {
				if(word.charAt(index[i-1])==word.charAt(index[i])) return;
			}
			answer++;
			return;
		}
		//순열
		for (int i = 0; i < word.length(); i++) {
			if(isSelected[i]) continue;
			index[cnt] = i;
			isSelected[i] = true;
			check(cnt+1);
			isSelected[i] = false;
		}
	}

}
