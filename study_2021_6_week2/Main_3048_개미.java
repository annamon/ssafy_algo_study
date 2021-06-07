package study_2021_6_week2;

import java.util.Scanner;

/**
 * 
 * @author anna
 * 2021.06.08
 * BOJ - silver 4
 * 128MB / 1s
 *
 * 1초에 한번씩 개미는 서로를 뛰어 넘는다. 
 * 자신의 앞에 반대 방향으로 움직이던 개미가 있는 경우에만 점프
 * T초가 지난 후에 개미의 순서
 * 
 * A : 첫 번째 그룹의 개미 수
 * B : 두 번째 그룹의 개미 수
 * T : 시간
 * antA, antB : 개미 문자
 * ants : 전체 개미 배치 배열
 */
public class Main_3048_개미 {

	static int A, B, T;
	static String antA, antB;
	static int[] ants;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		A = scann.nextInt();
		B = scann.nextInt();
		antA = scann.next();
		antB = scann.next();
		T = scann.nextInt();
		
		ants = new int[A+B];
		for (int i = 0; i < A; i++) { // A그룹 개미 순서대로 A~1까지 번호 부여
			ants[i] = A-i;
		}
		for (int i = 0; i < B; i++) { // B그룹 개미 순서대로 A+1~A+B까지 번호 부여
			ants[A+i] = A+i+1;
		}
		
		for (int t = 0; t < T; t++) {
			jump();
		}
		
		for (int i = 0; i < A+B; i++) {
			if(ants[i] <= A) {
				System.out.print(antA.charAt(ants[i]-1));
			}
			else {
				System.out.print(antB.charAt(ants[i]-A-1));
			}
		}
	}
	
	private static void jump() {
		int index = 0; // 현재 index
		while(index<A+B) {
			if(ants[index]<A+1 && index+1<ants.length) {  // 현재 index의 개미가 A그룹이고 다음 개미가 존재하면
				if(ants[index+1] > A) {				    // 다음 개미가 B그룹 개미라면 (번호가 A보다 크면 B그룹 개미임)
					int temp = ants[index];				// 개미 자리 바꾸기
					ants[index] = ants[index+1];
					ants[index+1] = temp;
					index++;							// 현재 개미와 다음 개미의 자리를 바꿨으니 이다음 검사할 개미는 현재 index+2임
				}
			}
			index++; // 그 외 경우 다음 index
		}
	}

}
