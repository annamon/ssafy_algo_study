package study_2021_6_week3;

import java.util.*;

/**
 * @author anna
 * @date 2021.06.16
 * @summary 
 * BOJ-silver1  256MB/2s (169060KB/1352ms)
 * N개 회의 모두 진행할 수 있는 최소 회의실 개수?
 * 회의 시작시간, 끝나는 시간 주어짐 (≤2^31−1, or 0)
 * 회의 시작 후 중단 불가, 회의 끝남과 동시에 다음 회의 진행 가능
 * 
 * N : 배열 크기
 * Meeting : 회의 시작, 끝 시간 이너클래스
 * room : 회의 시간순 배열
 * sameTime : 사용중인 회의실의 끝나는 시간 큐
 * count : 최대 회의실 수
 */
public class Main_19598_최소회의실개수 {

	//회의
	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;
		public Meeting() {
			super();
		}
		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		//시작 시간 -> 끝나는 시간 순으로 정렬
		@Override
		public int compareTo(Meeting o) {
			int dif = this.start - o.start;
			return dif==0? this.end - o.end : dif;
		}
	}
	
	static int N, count=1;
	static Meeting[] room;
	static PriorityQueue<Integer> sameTime = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		room = new Meeting[N];
		for (int i = 0; i < N; i++) {
			room[i] = new Meeting(scann.nextInt(), scann.nextInt());
		}
		//회의 시간순으로 정렬
		Arrays.sort(room);
		
		for (int i = 0; i < N; i++) {
			Meeting now = room[i];
			if(!sameTime.isEmpty()) {
				while(!sameTime.isEmpty()) {
					//사용중인 회의실 끝나는 시간과 현재 회의 시작시간 비교
					int end = sameTime.peek();
					//회의실 끝나는 시간과 시작시간이 같을 경우 그 회의실 비우고 새 회의 시작.
					if(end == now.start) {
						sameTime.remove();
						sameTime.add(now.end); //새 회의 끝나는 시간 넣기
						break;
					}
					//끝나는 시간이 시작시간보다 이른 경우 회의실 비우기
					else if(end < now.start)  sameTime.remove();
					//그 외 경우 회의실 추가
					else {
						addQueue(now.end);
						break;
					}
				}
			}
			else addQueue(now.end);
		}
		System.out.println(count);
	}
	
	//회의실 추가하기
	private static void addQueue(int endTime) {	
		sameTime.add(endTime);
		//동시 사용중인 회의실 개수 세기
		if(sameTime.size() > count) count = sameTime.size();
	}
}
