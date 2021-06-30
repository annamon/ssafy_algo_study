package study_2021_6_week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author anna
 * @date 2021.06.29
 * @summary 
 * BOJ-silver1  128MB/1s (12256KB/116ms)
 * 안정적인 문자열 만들기 위한 최소 연산 수?
 * 1. 빈 문자열 안정적
 * 2. S가 안정적이라면 {S}도 안정적
 * 3. S, T 안정적이라면 ST도 안정적
 * 입력 마지막줄 - 한 개 이상
 * 
 * S : 문자열. 길이2000이하, 짝수
 * T : 테스트케이스 번호
 * stable : 안정적인지 체크하기 위한 스택
 * count : 연산 수
 * i : index
 */
public class Main_4889_안정적인문자열 {

	static int T;
	static String S;
	static Stack<Character> stable = new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			S = br.readLine();
			stable.clear();
			//-인 경우 종료
			if(S.charAt(0)=='-') break;
			//그 외 스택에 맨 앞 문자 넣기
			else stable.add(S.charAt(0));
			int count=0, i=1;
			
			//안정적인 문자열 제외하기
			while(i<S.length()) {
				if(!stable.isEmpty() && stable.peek()=='{' && S.charAt(i)=='}') stable.pop();
				else stable.add(S.charAt(i));
				i++;
			}
			//연산 시작
			i = 0;
			while(!stable.isEmpty()) {
				char s1 = stable.pop();
				char s2 = stable.pop();
				if(s1=='{' && s2=='}') count+=2; //}{인 경우 연산 2번
				else count++; //}}, {{인 경우 연산 1번
			}
			T++;
			System.out.println(T + ". " +count);
		}
	}
}
