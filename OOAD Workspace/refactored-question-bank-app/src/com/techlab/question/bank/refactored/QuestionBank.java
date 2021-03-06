package com.techlab.question.bank.refactored;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class QuestionBank {

	private String questionBankCSVFilePath;
	private List<Question> questionList;

	public QuestionBank() {
		questionBankCSVFilePath = "D:\\KUNTAN\\SwabhavRepository\\OOAD Workspace\\"
				+ "refactored-question-bank-app\\data\\questionBank.csv";
		questionList = new ArrayList();
		initQuestions();
	}

	public void initQuestions() {

		List<Option> optionList1 = new ArrayList();
		Question question1 = new Question("What is capital of Maharashtra?", optionList1, 0);
		optionList1.add(new Option("1. Mumbai"));
		optionList1.add(new Option("2. Thane"));
		optionList1.add(new Option("3. Nagpur"));
		optionList1.add(new Option("4. Kolhapur"));
		questionList.add(question1);

		List<Option> optionList2 = new ArrayList();
		Question question2 = new Question("What is capital of Andra Pradesh?", optionList2, 1);
		optionList2.add(new Option("1. Thane"));
		optionList2.add(new Option("2. Amaravati"));
		optionList2.add(new Option("3. Nagpur"));
		optionList2.add(new Option("4. Kolhapur"));
		questionList.add(question2);

		List<Option> optionList3 = new ArrayList();
		Question question3 = new Question("What is capital of Gujrat?", optionList3, 2);
		optionList3.add(new Option("1. Thane"));
		optionList3.add(new Option("2. Nagpur"));
		optionList3.add(new Option("3. Gandhinagar"));
		optionList3.add(new Option("4. Kolhapur"));
		questionList.add(question3);

		List<Option> optionList4 = new ArrayList();
		Question question4 = new Question("What is capital of Rajasthan?", optionList4, 3);
		optionList4.add(new Option("1. Thane"));
		optionList4.add(new Option("2. Nagpur"));
		optionList4.add(new Option("3. Kolhapur"));
		optionList4.add(new Option("4. Jaipur"));
		questionList.add(question4);

		List<Option> optionList5 = new ArrayList();
		Question question5 = new Question("What is capital of Bihar?", optionList5, 0);
		optionList5.add(new Option("1. Patna"));
		optionList5.add(new Option("2. Thane"));
		optionList5.add(new Option("3. Nagpur"));
		optionList5.add(new Option("4. Kolhapur"));
		questionList.add(question5);

		List<Option> optionList6 = new ArrayList();
		Question question6 = new Question("What is capital of Karnatak?", optionList6, 1);
		optionList6.add(new Option("1. Thane"));
		optionList6.add(new Option("2. Bengaluru"));
		optionList6.add(new Option("3. Nagpur"));
		optionList6.add(new Option("4. Kolhapur"));
		questionList.add(question6);

		List<Option> optionList7 = new ArrayList();
		Question question7 = new Question("What is capital of Goa?", optionList7, 2);
		optionList7.add(new Option("1. Thane"));
		optionList7.add(new Option("2. Nagpur"));
		optionList7.add(new Option("3. Panaji"));
		optionList7.add(new Option("4. Kolhapur"));
		questionList.add(question7);

		List<Option> optionList8 = new ArrayList();
		Question question8 = new Question("What is capital of Madhya Pradesh?", optionList8, 3);
		optionList8.add(new Option("1. Thane"));
		optionList8.add(new Option("2. Nagpur"));
		optionList8.add(new Option("3. Kolhapur"));
		optionList8.add(new Option("4. Bhopal"));
		questionList.add(question8);

		List<Option> optionList9 = new ArrayList();
		Question question9 = new Question("What is capital of Uttar Pradesh?", optionList9, 0);
		optionList9.add(new Option("1. Lucknow"));
		optionList9.add(new Option("2. Thane"));
		optionList9.add(new Option("3. Nagpur"));
		optionList9.add(new Option("4. Kolhapur"));
		questionList.add(question9);

		List<Option> optionList10 = new ArrayList();
		Question question10 = new Question("What is capital of West Bengal?", optionList10, 1);
		optionList10.add(new Option("1. Thane"));
		optionList10.add(new Option("2. Kolkata"));
		optionList10.add(new Option("3. Nagpur"));
		optionList10.add(new Option("4. Kolhapur"));
		questionList.add(question10);

	}

	public List<Question> getRandomQuestionsAsPerDemand(int newDemand) {
		List<Question> demandedQuestionList = new ArrayList();
		Random random = new Random();
		for (int i = 0; i < newDemand; i++) {
			Question question = questionList.get(random.nextInt(questionList.size()));
			demandedQuestionList.add(question);
		}
		return demandedQuestionList;
	}

	public Question getQuestionByUUID(UUID newUUID) {
		int indexOfTargetQuestion = 0;
		for (Question question : questionList) {
			if (question.getUUId() == newUUID) {
				indexOfTargetQuestion = questionList.indexOf(question);
			}
		}
		return questionList.get(indexOfTargetQuestion);
	}

	public void addCustomeQuestion(Question newQuestion) {
		questionList.add(newQuestion);
	}

	/*
	 * public void analyseTest(List<Question> newQuestionOptionList) {
	 * 
	 * int correctAnswerCount = 0; printQuestionsWithOptions(newQuestionOptionList);
	 * int answerIndex = takeAnswerOptionInput(); for (Question question :
	 * newQuestionOptionList) { correctAnswerCount = correctAnswerCount +
	 * getCorrectAnswerCount(question, answerIndex); }
	 * System.out.println("Correct answers out of " + newQuestionOptionList.size() +
	 * " : " + correctAnswerCount); }
	 */

	public void appearForMCQTest(List<Question> newQuestionOptionList) {

		int correctAnswerCount = 0;
		for (Question question : newQuestionOptionList) {
			System.out.println(question.getQuestion());
			List<Option> optionList = question.getOptionList();
			printOptions(optionList);
			int answerIndex = takeAnswerOptionInput();
			correctAnswerCount = correctAnswerCount + getCorrectAnswerCount(question, answerIndex);
		}
		System.out.println("Correct answers out of " + newQuestionOptionList.size() + " : " + correctAnswerCount);
		System.out.println("Your score is : " + calcScore(correctAnswerCount, newQuestionOptionList.size()));
	}

	private double calcScore(int correctAnswers, int totalAnswers) {
		return (correctAnswers / totalAnswers) * 100;
	}

	private void printOptions(List<Option> optionList) {

		for (Option option : optionList) {
			System.out.println(option.getOption());
		}
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public int getCorrectAnswerCount(Question newQuestion, int answerOptionIndex) {

		if (answerOptionIndex - 1 == newQuestion.getAnswerOptionIndex()) {
			return 1;
		}
		return 0;
	}

	public int takeAnswerOptionInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter answer option : ");
		return sc.nextInt();
	}

	public void addQuestionsFromCSV(List<Question> newQuestionList) throws IOException {

		FileReader fr = new FileReader(new File(questionBankCSVFilePath));
		BufferedReader br = new BufferedReader(fr);
		String singleQuestion;
		while ((singleQuestion = br.readLine()) != null) {
			String[] questionComponents = singleQuestion.split(",");
			List<Option> newOptionList = new ArrayList();
			newOptionList.add(new Option(questionComponents[1]));
			newOptionList.add(new Option(questionComponents[2]));
			newOptionList.add(new Option(questionComponents[3]));
			newOptionList.add(new Option(questionComponents[4]));
			String answerOptionInString = questionComponents[5].trim();
			int answerOption = Integer.parseInt(answerOptionInString);
			Question newQuestion = new Question(questionComponents[0], newOptionList, answerOption);
			newQuestionList.add(newQuestion);
		}
		br.close();
	}
}
