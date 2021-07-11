package study_2021_7_week2;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.07.12
 * @summary 
 * BOJ-silver5  512MB/2s (12760KB/112ms)
 * 피카츄는 pi, ka, chu만 발음 가능
 * 피카츄가 말할 수 있는 문자열인가?
 * YES or NO 출력
 * 
 * S : 문자열, 길이 5,000이하
 * StringIndexOutOfBounds 주의
 */
public class Main_14405_피카츄 {

	static String S;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		S = scann.nextLine();
		S = S.replaceAll("pi|ka|chu", "");
//		S = S.replace("pi", "").replace("ka", "").replace("chu", ""); 틀림
		System.out.println(S);
		if(S.equals("")) System.out.println("YES");
		else System.out.println("NO");
		scann.close();
		
		/*
		int i = 0;
		while(i<S.length()) {
			if(S.charAt(i)=='p' && i+1< S.length()) {
				if(S.charAt(i+1)=='i') i+=2;
				else break;
			}
			else if(S.charAt(i)=='k' && i+1< S.length()) {
				if(S.charAt(i+1)=='a') i+=2;
				else break;
			}
			else if(S.charAt(i)=='c' && i+2< S.length()) {
				if(S.charAt(i+1)=='h' && S.charAt(i+2)=='u') i+=3;
				else break;
			}
			else break;
		}
		if(i>=S.length()) System.out.println("YES");
		else System.out.println("NO");
		*/
	}

}
