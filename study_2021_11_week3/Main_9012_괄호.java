package study_2021_11_week3;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.11.15
 * @summary 
 * BOJ-silver4  128MB/1s (11708KB/92ms)
 * VPS : 괄호 모양이 올바른 문자열
 * 올바르면 YES, 아니면 NO 출력
 * 
 */
public class Main_9012_괄호 {

	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String word = br.readLine();
			Stack<Character> vps = new Stack<>();
			for (int i = 0; i < word.length(); i++) {
				if(vps.isEmpty()) vps.push(word.charAt(i));
				else if(word.charAt(i)==')' && vps.peek()=='(') vps.pop();
				else vps.push(word.charAt(i));
			}
			if(vps.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
