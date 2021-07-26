package study_2021_7_week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/**
 * @author anna
 * @date 2021.07.25
 * @summary 
 * BOJ-gold4  128MB/1s (14516KB/276ms)
 * 입력받은 영단어 철자들로 만들 수 있는 모든 단어 출력하기
 * 같은 단어가 여러 번 만들어지는 경우 한 번만 출력
 * 알파벳 순서로 출력
 * 애너그램 수 10만개 이하, 단어 길이 20이하
 * 
 * N : 테스트케이스 수
 * L : 단어 길이
 * word[] : 단어 배열, 아스키코드 저장
 * 조합 메모리초과, np로 풀기
 */
public class Main_6443_애너그램 {

	static int N, L;
	static String s;
	static int[] word;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			L = s.length();
			word = new int[L];
			for (int j = 0; j < L; j++) word[j] = s.charAt(j);
			Arrays.sort(word); //오름차순
			//next Permutation 
			do {
				for(int n : word) bw.write((char)n);
				bw.newLine();
			} while (np(L-1));
		}
		bw.flush();
	}
	
	//NP
	private static boolean np(int size) {
		int i = size;
		while(i>0 && word[i-1]>=word[i]) i--;
		if(i==0) return false;
		int j = size;
		while(word[i-1] >= word[j]) j--;
		int temp = word[i-1];
		word[i-1] = word[j];
		word[j] = temp;
		int k = size;
		while(i<k) {
			temp = word[i];
			word[i] = word[k];
			word[k] = temp;
			i++;
			k--;
		}
		return true;
	}
	
/*	조합으로 풀기 : 메모리 초과
	static int N, L;
	static String s;
	static TreeSet<String> anagram = new TreeSet<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			L = s.length();
			boolean[] isSelected = new boolean[L];
			make(0, isSelected, "");
			for(String word : anagram) {
				bw.write(word);
				bw.newLine();
			}
			anagram.clear();
		}
		bw.flush();
	}

	private static void make(int cnt, boolean[] isSelected, String word) {
		if(cnt==L) {
			anagram.add(word);
			return;
		}
		for (int i = 0; i < L; i++) {
			if(isSelected[i]) continue;
			word += s.charAt(i);
			isSelected[i] = true;
			make(cnt+1, isSelected, word);
			word = word.substring(0, word.length()-1);
			isSelected[i] = false;
		}
	}
*/
}
