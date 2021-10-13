package study_2021_10_week2;

/**
 * @author anna
 * @date 2021.10.13
 * @summary 
 * programmers-연습문제
 * P와 Y 개수 비교하기
 * 대소문자 구분 X
 * 같으면 true, 다르면 false 리턴
 */

public class Solution_문자열내p와y의개수 {
	class Solution {
	    boolean solution(String s) {
	        int origin = s.length();
	        s = s.replaceAll("(?i)[p]", "");
	        int p = s.length();
	        s = s.replaceAll("(?i)[y]", "");
	        int y = s.length();
	        if(origin-p == p-y) return true;
	        else return false;
	    }
	}

}
