package com.biz.grade.exec;

import java.util.Scanner;

import com.biz.grade.service.ScoreService;
import com.biz.grade.service.ScoreServiceImplV1;
import com.biz.grade.service.StudentServiceImplV1;

public class ScoreEx_01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		ScoreService scService = new ScoreServiceImplV1();
		ScoreService stService = new StudentServiceImplV1();


		while (true) {

			System.out.println("==================================");
			System.out.println("성적관리 프로그램 V1");
			System.out.println("==================================");
			System.out.println("1. 학생정보입력");
			System.out.println("2. 성적정보입력");
			System.out.println("3. 학생명부 출력");
			System.out.println("4. 종합성적표 출력");
			System.out.println("-1. 업무종료");
			System.out.println("==================================");
			System.out.print("업무선택 >> ");

			String strMenu = scan.nextLine();
			int intMenu = 0;
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (Exception e) {
				System.out.println("메뉴선택은 숫자로만 입력하세요");
				continue;
			}
			if (intMenu == -1) {
				break;
			} else if (intMenu < 1 || intMenu > 3) {
				System.out.println("선택된 업무가 없습니다");
				continue;
			}

			if (intMenu == 1) {
				// 학생정보입력
				stService.studentInput();
			} else if (intMenu == 2) {
				// 성적입력
				scService.scoreInput();
			} else if (intMenu == 3) {
				// 학생명부 출력
				stService.listScore();
			}
		}
	}
}