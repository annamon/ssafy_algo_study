package study_2021_10_week3;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.10.19
 * @summary 
 * BOJ-bronze2  128MB/2s (12952KB/112ms)
 * 가장 많이 나온 글자 출력하기
 */
public class Main_1371_가장많은글자 {

	static String s;
	public static void main(String[] args) throws Exception {
		Scanner scann = new Scanner(System.in);
        int alpha[] = new int[26];
        int max = 0;
        while(scann.hasNextLine()){
            String line = scann.nextLine();
            for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) != ' '){
                    alpha[line.charAt(i) - 'a']++;
                    if(max < alpha[line.charAt(i) - 'a']){
                        max = alpha[line.charAt(i) - 'a'];
                    }
                }
            }
        }
        for(int i = 0; i < 26; i++){
            if(alpha[i] == max) System.out.print((char)(i + 'a'));
        }
        scann.close();
	}

}
