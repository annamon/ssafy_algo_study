package study_2021_10_week2;

/**
 * @author anna
 * @date 2021.10.14
 * @summary 
 * programmers-연습문제
 * 맨 뒤 4자리 제외하고 *로 가리기
 */
public class Solution_핸드폰번호가리기 {
	class Solution {
	    public String solution(String phone_number) {
	        String star = "****************";
	        int n = phone_number.length();
	        String answer = star.substring(0, n-4) + phone_number.substring(n-4, n);
	        return answer;
	    }
	}
}
