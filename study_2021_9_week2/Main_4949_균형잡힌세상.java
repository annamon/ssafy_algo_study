package study_2021_9_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.08
 * @summary 
 * BOJ-silver4  128MB/1s (30052KB/616ms)
 * 균형 맞추기
 * 짝인 경우 : ( ), [ ]
 * 맨 마지막에 . 하나인 경우 : 입력 종료
 * 
 * balance : 균형 맞출 수 있는지 확인용
 * word : 괄호 저장할 스택
 */
public class Main_4949_균형잡힌세상 {
	
	static boolean balance;
	static Stack<Character> word = new Stack<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			//.인 경우 입력 종료
			if(s.equals(".")) break;
			//괄호 제외한 모든 문자 없애기
			s = s.replaceAll("[^\\(\\)\\[\\]]", "");
			word.clear();
			balance = true;
			//균형 맞는지 체크하기
			for (int i = 0; i < s.length(); i++) {
				//균형이 맞지 않는 경우 체크 종료
				if(!balance) break;
				//현재 문자가 ( 혹은 [ 인 경우
				if(s.charAt(i)=='(' || s.charAt(i)=='[') word.push(s.charAt(i));
				//현재 문자가 ) 인 경우
				else if(s.charAt(i)==')') {
					if(!word.isEmpty() && word.peek()=='(') word.pop();
					else balance = false;
				}
				//현재 문자가 ] 인 경우
				else {
					if(!word.isEmpty() && word.peek()=='[') word.pop();
					else balance = false;
				}
			}
			//모든 문자 체크 후 스택에 남아있는 경우
			if(!word.isEmpty()) balance = false;
			//균형 여부에 따라 정답 출력
			if(!balance) System.out.println("no");
			else System.out.println("yes");
		}
	}

}
