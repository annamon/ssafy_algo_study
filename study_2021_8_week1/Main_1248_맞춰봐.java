package study_2021_8_week1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author anna
 * @date 2021.08.08
 * @summary 
 * BOJ-gold3  128MB/2s (KB/ms)
 * -10 ~ 10 까지 수 사용
 * N개 숫자
 * S[i][j] : 숫자 i번째부터 j번째까지 합을 -, 0, +로 표시
 * symbol[][] : S와 같음. 구간 합 정보 표시
 * number[] : 규현이가 적은 N개의 수
 */
public class Main_1248_맞춰봐 {

	static int N;
	static char[][] symbol;
	static int[] number;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		String S = scann.next();
		symbol = new char[N][N];
		number = new int[N];
		int index = 0;
		//구간 합 정보 배열에 저장
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				symbol[i][j] = S.charAt(index);
				index++;
			}
		}
		check(0);
		scann.close();
	}
	
	//사용 가능한 수인지 체크
	private static void check(int index) {
		//N번째 숫자까지 완료한 경우 출력 후 종료
		if(index==N) {
			for (int i = 0; i < N; i++) {
				System.out.print(number[i]+" ");
			}
			System.exit(0);
		}
		
		//규현이가 쓸 수 있는 수의 범위 : -10~10
		for (int i = -10; i <= 10; i++) {
			//정답 배열에 일단 저장하고 (다음 숫자 계산을 위해)
			number[index] = i;
			//구간 합 조건을 만족하는지 체크
			if(canUse(index)) check(index+1);
		}
	}

	//구간합 조건 체크
	private static boolean canUse(int index) {
		int sum = 0;
		//index부터 시작하여 0 까지 구간합 모두 만족하는 경우 true
		for (int i = index; i >= 0; i--) {
			sum+= number[i];
			if(symbol[i][index]=='-' && sum>=0) return false;
			if(symbol[i][index]=='0' && sum!=0) return false;
			if(symbol[i][index]=='+' && sum<=0) return false;
		}
		return true;
	}

}
