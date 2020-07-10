package com.biz.grade.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.grade.vo.StudentVO;

public class StudentServiceImplV1 implements ScoreService {

	protected List<StudentVO> studentList;
	protected Scanner scan;

	public StudentServiceImplV1() {
		studentList = new ArrayList<StudentVO>();
	}

	@Override
	public boolean studentInput() {
		scan = new Scanner(System.in);

		System.out.println("번호(END:입력종료) >> ");
		String strNum = scan.nextLine();

		if (strNum.equals("END")) {
			System.out.println("입력값: " + strNum);
			System.out.println("입력 종료");
			return false;
		}

		System.out.println("이름 입력 >>");
		String strName = scan.nextLine();

		System.out.println("학년을 입력하세요");
		String strGrade = scan.nextLine();

		int intGrade = 0;

		try {
			intGrade = Integer.valueOf(strGrade);
		} catch (Exception e) {
			System.out.println("학년은 숫자로 써주세요");
			return true;
		}

		if (intGrade < 1 || intGrade > 4) {
			System.out.println("학년은 1 ~ 4 까지만 가능");
			return true;
		}

		System.out.println("학과 입력 >> ");
		String strDept = scan.nextLine();

		StudentVO stVO = new StudentVO();
		stVO.setNum(strNum);
		stVO.setName(strName);
		stVO.setGrade(intGrade);
		stVO.setDept(strDept);

		studentList.add(stVO);

		return true;
	}

	@Override
	public void listScore() {

		StudentVO stVO;
		System.out.println("===============================");
		System.out.println("학생 정보 일람");
		System.out.println("-------------------------------");
		System.out.println("번호\t이름\t학년\t학과");
		System.out.println("-------------------------------");

		int size = studentList.size();
		for (int i = 0; i < size; i++) {
			stVO = studentList.get(i);
			System.out.print(stVO.getNum() + "\t");
			System.out.print(stVO.getName() + "\t");
			System.out.print(stVO.getGrade() + "\t");
			System.out.print(stVO.getDept() + "\n");

		}
		System.out.println("-------------------------------");
	}



	@Override
	public void calcSum() {
		
	}		

	@Override
	public void calcAvg() {
		
	}
	
	@Override
	public boolean scoreInput() {
		// TODO Auto-generated method stub
		return false;
	}
}
