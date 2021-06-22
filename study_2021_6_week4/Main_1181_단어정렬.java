package study_2021_6_week4;

import java.util.*;

/**
 * @author anna
 * @date 2021.06.22
 * @summary 
 * BOJ-silver5  256MB/2s (34640KB/872ms)
 * 소문자로 이루어진 단어 정렬
 * 1. 길이가 짧은 것부터
 * 2. 길이가 같으면 사전 순으로
 * 같은 단어 여러 번 입력된 경우 한 번만 출력
 * 
 * N : 단어 개수  (1≤N≤20,000)
 * words : 단어 set
 */
public class Main_1181_단어정렬 {

	static class word implements Comparable<word>{
		String w;
		int length;
		public word() {
			super();
		}
		public word(String w, int length) {
			super();
			this.w = w;
			this.length = length;
		}
		//길이순 정렬 -> 같은 길이의 경우 사전순 정렬
		@Override
		public int compareTo(word o) {
			int dif = this.length - o.length;
			if(dif==0) {				
				for (int i = 0; i < this.length; i++) {
					if(this.w.charAt(i)==o.w.charAt(i)) continue;
					return (Integer) (this.w.charAt(i) - o.w.charAt(i));
				}
			}
			return dif;
		}
	}
	
	static int N;
	static TreeSet<word> words = new TreeSet<>();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		for (int i = 0; i < N; i++) {
			String s = scann.next();
			words.add(new word(s, s.length()));
		}
		for (word w : words) {
			System.out.println(w.w);
		}
		scann.close();
	}

}
