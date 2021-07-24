package study_2021_7_week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author anna
 * @date 2021.07.24
 * @summary 
 * BOJ-bronze2  128MB/2s (13256KB/128ms)
 * 난쟁이 9명 중에 7명 찾기
 * 7명 키의 합은 100
 * 정답이 여러개인 경우 아무거나 오름차순 출력
 * 
 * sum : 9난쟁이 키 총합
 * notSelected[] : 제외할 2난쟁이 index
 * dwarf : 9난쟁이 키 정보
 */
public class Main_2309_일곱난쟁이 {

	static int sum;
	static int[] notSelected = new int[2];
	static List<Integer> dwarf = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			int n = scann.nextInt();
			dwarf.add(n);
			sum+=n;
		}
		Collections.sort(dwarf); //오름차순 정렬
		check(0, 0);
	}
	
	//제거할 난쟁이 찾기
	private static void check(int cnt, int start) {
		//제외할 2난쟁이 선정완료
		if(cnt==2) {
			int checkSum = sum;
			for (int i = 0; i < 2; i++) checkSum -= dwarf.get(notSelected[i]);
			//두 명 제외하니 키 총합이 100이 된다면
			if(checkSum == 100) {
				//두 난쟁이 키 값 찾기
				int a = dwarf.get(notSelected[0]);
				int b = dwarf.get(notSelected[1]);
				//리스트에서 두 난쟁이 제거
				dwarf.remove(dwarf.indexOf(a));
				dwarf.remove(dwarf.indexOf(b));
				//출력 후 종료
				for (int i = 0; i < 7; i++) System.out.println(dwarf.get(i));
				System.exit(0);
			}
			return;
		}
		//9C2
		for (int i = start; i < 9; i++) {
			notSelected[cnt] = i;
			check(cnt+1, i+1);
		}
	}

}
