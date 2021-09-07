package study_2021_9_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.07
 * @summary 
 * BOJ-silver3  512MB/2s (116812KB/792ms)
 * 영어 소문자만 기록 가능, 최대 600,000글자 입력
 * L : 커서 왼쪽으로 한 칸 옮김 (맨 앞이면 무시)
 * D : 커서 오른쪽으로 한 칸 옮김 (맨 뒤면 무시)
 * B : 커서 왼쪽 문자 삭제 (맨 앞이면 무시)
 * P $ : 커서 왼쪽에 $ 추가
 * 모든 명령어 수행 후 편집기에 입력된 문자열 구하기
 * 명령어 수행 전에는 커서는 문장 맨 뒤에 있음
 * 
 * N : 문자열 길이, 100,000이하
 * M : 입력할 명령어 개수, 1~500,000
 */
public class Main_1406_에디터 {

	static int M;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> left = new Stack<>();  //커서 왼쪽 문자
		Stack<Character> right = new Stack<>(); //커서 오른쪽 문자
		//입력 문자열 = 커서 왼쪽
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			left.push(s.charAt(i));
		}
		//명령 수행
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()) {
			case "L": //커서 왼쪽 이동 -> 왼쪽 스택에서 오른쪽 스택으로 문자 하나 옮기기
				if(!left.isEmpty()) right.push(left.pop());
				break;
			case "D": //커서 오른쪽 이동 -> 오른쪽 스택에서 왼쪽 스택으로 문자 하나 옮기기
				if(!right.isEmpty()) left.push(right.pop());
				break;
			case "B": //커서 기준 왼쪽 문자 삭제 -> 왼쪽 스택 하나 삭제
				if(!left.isEmpty()) left.pop();
				break;
			case "P": //커서 기준 왼쪽에 문자 추가 -> 왼쪽 스택 하나 추가
				left.push(st.nextToken().charAt(0));
				break;
			}
		}
		//커서 왼쪽에 있는 문자 오른쪽으로 옮기기
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		//출력하기
		while(!right.isEmpty()) {
			bw.write(right.pop());
		}
		bw.flush();
	}

}
