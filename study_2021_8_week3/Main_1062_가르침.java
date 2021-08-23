package study_2021_8_week3;

import java.util.*;

/**
 * @author anna
 * @date 2021.08.22
 * @summary 
 * BOJ-gold4  512MB/1s (14564KB/292ms)
 * K개 글자 가르침
 * K개 글자로만 이루어진 단어 읽을 수 있다.
 * 어떤 K개 글자를 가르쳐야 읽을 수 있는 단어 개수가 최대가 될까?
 * N개 단어, anta로 시작, tica로 끝
 * 단어 길이 8~15, 중복 x
 * 
 * N : 1~50
 * K : 0~26
 * word[] : anta, tica를 뺀 글자 목록
 * isSelected[] : 알파벳 26자 중 읽을 수 있는 알파벳
 * answer : 읽을 수 있는 단어 수
 */
public class Main_1062_가르침 {
	
	static int N, K, answer;
	static String[] word;
	static boolean[] isSelected = new boolean[26];
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		K = scann.nextInt();
		word = new String[N];
		if(K==26) answer = N; //모든 알파벳 읽을 수 있는 경우
		else if(K<5) answer = 0; //a, n, t, i, c 5개 못 읽는 경우
		else {	//그 외 경우
			for (int i = 0; i < N; i++) {
				String w = scann.next();
				//anta, tica 자른 문자열 
				word[i] = w.substring(4,w.length() - 4);
			}
			//anti, tica 읽을 수 있도록 true 처리
			isSelected['a'-97] = true;
			isSelected['n'-97] = true;
			isSelected['t'-97] = true;
			isSelected['i'-97] = true;
			isSelected['c'-97] = true;
			check(0,0); //조합
		}
		System.out.println(answer);
		scann.close();
	}
	
	//알파벳 조합
	private static void check(int cnt, int start) {
		//a,n,t,i,c 외 알파벳 선택 완료
		if(cnt==K-5) {
			int n = 0;
			for (int i = 0; i < N; i++) {
				boolean canRead = true;
				for (int j = 0; j < word[i].length(); j++) {
					//읽을 수 없는 알파벳이 나온 경우 -> 읽을 수 없는 단어
					if(!isSelected[word[i].charAt(j)-97]) {
						canRead = false;
						break;
					}
				}
				//읽을 수 있는 경우에만 카운트
				if(canRead) n++;
			}
			answer = Math.max(answer, n);
			return;
		}
		
		//26개 알파벳 중 K-5개 고르기
		for (int i = start; i < 26; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			check(cnt+1, i+1);
			isSelected[i] = false;
		}
	}

}
