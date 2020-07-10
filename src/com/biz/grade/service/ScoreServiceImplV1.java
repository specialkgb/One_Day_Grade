package com.biz.grade.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.grade.vo.ScoreVO;

public class ScoreServiceImplV1 implements ScoreService {

	protected List<ScoreVO> scoreList;
	protected Scanner scan;

	public ScoreServiceImplV1() {
		scoreList = new ArrayList<ScoreVO>();

	}

	@Override
	public boolean scoreInput() {
		scan = new Scanner(System.in);

		System.out.println("번호 입력 >> ");
		String strNum = scan.nextLine();

		System.out.println("국어점수 입력 >> ");
		int intKor = scan.nextInt();

		System.out.println("영어점수 입력 >> ");
		int intEng = scan.nextInt();

		System.out.println("수학점수 입력 >> ");
		int intMath = scan.nextInt();

		System.out.println("음악점수 입력 >> ");
		int intMusic = scan.nextInt();

		ScoreVO scVO = new ScoreVO();
		scVO.setNum(strNum);
		scVO.setKor(intKor);
		scVO.setEng(intEng);
		scVO.setMath(intMath);
		scVO.setMusic(intMusic);

		scoreList.add(scVO);

		return true;
	}

	@Override
	public void calcSum() {

		ScoreVO scVO;
		int size = scoreList.size();
		for (int i = 0; i < size; i++) {
			scVO = scoreList.get(i);
			int sum = scVO.getKor();
			sum += scVO.getEng();
			sum += scVO.getMath();
			sum += scVO.getMusic();

			scVO.setSum(sum);
		}
	}

	@Override
	public void calcAvg() {

		ScoreVO scVO;
		int size = scoreList.size();
		for (int i = 0; i < size; i++) {
			scVO = scoreList.get(i);

			int avg = (scVO.getSum() / size);
			scVO.setAvg(avg);
		}

	}

	@Override
	public void listScore() {

		ScoreVO scVO;
		System.out.println("====================================");
		System.out.println("성적 정보 일람");
		System.out.println("------------------------------------");
		System.out.println("번호\t국어\t영어\t수학\t음악");
		System.out.println("------------------------------------");

		int size = scoreList.size();

		for (int i = 0; i < size; i++) {
			scVO = scoreList.get(i);
			System.out.print(scVO.getNum() + "\t");
			System.out.print(scVO.getKor() + "\t");
			System.out.print(scVO.getEng() + "\t");
			System.out.print(scVO.getMath() + "\t");
			System.out.print(scVO.getMusic() + "\n");

		}
		System.out.println("------------------------------------");

	}

	@Override
	public boolean studentInput() {

		return false;
	}

}