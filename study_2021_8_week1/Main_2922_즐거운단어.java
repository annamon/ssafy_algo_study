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
 * 
 * 모음은 O 자음은 X로 표시
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
		//모든 문자 체크 완료
		if(i==s.length()) {
			//마지막 세 문자 같으면 리턴
			if(same(word, i)) return;
			//L이 없는 문자열이었고, 자음 넣을 칸이 없는 경우 리턴
			if(!L && !canL) return;
			System.out.print(word+" ");
			long cnt = 1; //만들 수 있는 글자 카운트 용
			int cntX = 0; //자음 칸 개수
			int cntO = 0; //모음 칸 개수
			for (int n = 0; n < num; n++) {
				//자음인 경우
				if(word.charAt(funIndex[n])=='X') {
					cnt*=21;
					cntX++;
				}
				//모음인 경우
				else {
					cnt*=5;
					cntO++;
				}
			}
			//기본 문자에 L이 없는 경우
			if(!L) {
				cnt /= 21; //자음 한 칸은 L 넣기				
				if(cntX>1 && cntO!=0) { //자음 칸이 2칸 이상이고, 모음이 0개가 아닌 경우
					cnt *= cntX;
					//중복 글자 빼기
					int same = (int)Math.pow(2, cntX) - (cntX+1);
					same *= (int)Math.pow(5, cntO);
					cnt -= same;
				}
			}
			System.out.println(cnt);
			answer += cnt;
			return;
		}
		
		//글자 개수 3개 이상인 경우 3연속 체크
		if(i>=3) if(same(word, i)) return;
		StringBuilder sb = new StringBuilder();
		sb.append(word);
		//지워진 글자인 경우
		if(s.charAt(i)=='_') {
			//모음 넣기
			check(sb.append('O').toString(), i+1, canL);
			sb.deleteCharAt(i);
			//자음 넣기
			check(sb.append('X').toString(), i+1, true);
		}
		//모음인 경우
		else if(isVow(s.charAt(i))) {
			check(sb.append('O').toString(), i+1, canL);
		}
		//자음인 경우
		else check(sb.append('X').toString(), i+1, canL);
	}

	//모음3연속 or 자음3연속 체크
	private static boolean same(String word, int i) {
		return word.charAt(i-1) == word.charAt(i-2) && word.charAt(i-2) == word.charAt(i-3);
	}

	//모음 체크
	private static boolean isVow(char c) {
		return c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
	}

}
