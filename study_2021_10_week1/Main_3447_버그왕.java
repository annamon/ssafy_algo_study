package study_2021_10_week1;

import java.io.*;

/**
 * @author anna
 * @date 2021.10.07
 * @summary 
 * BOJ-bronze1  128MB/1s (11564KB/80ms)
 * BUG 없애기
 */
public class Main_3447_버그왕 {

	static String s, ns;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while((s=br.readLine())!=null) {
			while(true) {
				ns = s.replaceAll("BUG", "");
				if(s.equals(ns)) {
					System.out.println(s);
					break;
				}
				s = ns;
			}
		}
		br.close();
	}
}
