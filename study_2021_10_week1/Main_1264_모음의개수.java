package study_2021_10_week1;

import java.io.*;

/**
 * @author anna
 * @date 2021.10.04
 * @summary 
 * BOJ-bronze2  128MB/1s (11632KB/88ms)
 * 모음 개수 세는 프로그램 작성
 * 각 줄마다 대소문자, . ! ? 공백으로 이루어짐
 * 최대 255글자
 * 입력 끝 = #
 */
public class Main_1264_모음의개수 {

	static String sentence;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			sentence = br.readLine();
			if(sentence.equals("#")) break;
			int before = sentence.length();
			sentence = sentence.replaceAll("(?i)[aeiou]", "");
			int after = sentence.length();
			System.out.println(before - after);
			
		}
		
	}

}
