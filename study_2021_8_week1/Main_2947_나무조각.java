package study_2021_8_week1;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.08.04
 * @summary 
 * BOJ-silver5  128MB/1s (12816KB/116ms)
 * 나무조각 5개, 각각 1~5
 * 버블소트
 * 12345 될 때 까지 반복
 */
public class Main_2947_나무조각 {

	static int[] num = new int[5];
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			num[i] = scann.nextInt();
		}
		while(true) {
			//12345 순인지 체크
			boolean right = true;
			for (int i = 0; i < 4; i++) {
				//나무토막 위치 바꾸기
				if(num[i] > num[i+1]) {
					int temp = num[i];
					num[i] = num[i+1];
					num[i+1] = temp;
					for(int n : num) System.out.print(n+" ");
					System.out.println();
					if(num[i]!=i+1) right = false;
				}
			}
			if(right) break;
		}
		scann.close();
	}

}
