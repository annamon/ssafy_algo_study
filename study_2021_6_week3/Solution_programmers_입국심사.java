package study_2021_6_week3;

import java.util.Arrays;

/**
 * @author anna
 * @date 2021.06.19
 * @summary 
 * programmers
 * 한 심사대에서 한 명만 심사 가능
 * 가장 빨리 끝나는 곳에서 이어서 심사
 * 모든 사람 심사 받는데 걸리는 시간 최솟값 구하기
 * 
 * 입국 심사 기다리는 사람 n명 (1,000,000,000명 이하)
 * 심사 걸리는 시간 times (1,000,000,000분 이하)
 * 심사관 (100,000명 이하)
 */
public class Solution_programmers_입국심사 {

	 public long solution(int n, int[] times) {
	        Arrays.sort(times);
	        long left = 1;
	        long right = times[times.length-1] * n;
	        long answer = right;
	        while (left <= right) {
	            long count = 0; //심사인원수
	            long mid = (left + right) / 2;
	            //심사처리
	            for (int i = 0; i<times.length; i++) {
	                count += mid / times[i];
	            }
	            //시간추가 
	            if (count < n) {
	                left = mid + 1;
	            }
	            //시간줄이기
	            else {
	                if (mid < answer) {
	                    answer = mid;
	                }
	                right = mid - 1;
	            }
	        }
	        return answer;
	    }
}