package study_2021_6_week2;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.07
 * @summary 
 * BOJ-bronze2  128MB/1s (12812KB/108ms)
 * 잔돈으로 500엔, 100엔, 50엔, 10엔, 5엔, 1엔
 * 거스름돈 개수가 가장 적게 잔돈을 준다.
 * 1000엔 지폐를 한장 냈을 때, 받을 잔돈에 포함된 잔돈의 개수
 * 
 * price : 지출해야하는 금액
 * change : 거스름돈
 * answer : 거스름돈 개수
 * money : 잔돈 배열
 */
public class Main_5585_거스름돈 {

	static int price, change, answer;
	static int[] money = {500, 100, 50, 10, 5, 1};
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		price = scann.nextInt();
		change = 1000 - price;
		for (int i = 0; i < money.length-1; i++) { // 잔돈 5엔까지 계산
			if(change>=money[i]) {
				answer += change/money[i];
				change = change%money[i];
			}
		}
		if(change!=0) answer += change; // 잔돈 1엔 계산
		System.out.println(answer);
	}

}
