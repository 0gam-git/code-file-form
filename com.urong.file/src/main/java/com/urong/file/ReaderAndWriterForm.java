package com.urong.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ReaderAndWriterForm {

	final String inputFilePath = System.getProperty("user.dir") + "/file/test.json";
	final String outputFilePath = System.getProperty("user.dir") + "/file/output.json";

	public static void main(String[] args) {

	}

	// char 단위 읽어들이는
	private void test1() {
		FileReader fileReader = null;

		try {
			fileReader = new FileReader(inputFilePath);

			int i = 0;
			while (i != -1) {
				i = fileReader.read();
				System.out.print((char) i);
			}
		} catch (Exception e) {
			System.out.println("오류" + e);
		} finally {
			try {
				fileReader.close();
			} catch (Exception e) {
				System.out.println("파일 닫기 오류" + e);
			}
		}
	}

	// reader - buffered
	private void test2() {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(inputFilePath);
			bufferedReader = new BufferedReader(fileReader);

			String string = new String(); // 임시 변수

			do {
				// 한줄씩 읽기
				string = bufferedReader.readLine();
				System.out.println(string);
			} while (string != null); // 파일 끝이면 null을 반환한다.
		} catch (Exception e) {
			System.out.println("오류" + e);
		} finally {
			try {
				bufferedReader.close();
			} catch (Exception e) {
				System.out.println("파일 닫기 오류" + e);
			}
		}
	}

	// file copy(char) , bufferedReader, bufferedWriter
	private void test3() {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;

		try {
			fileReader = new FileReader(inputFilePath);
			bufferedReader = new BufferedReader(fileReader);
			// bufferedWriter = new BufferedWriter(new
			// FileWriter("src/ex0801/io/aaa.txt"));
			// true를 두번째 인수를 넣으면 이어서 저장됨.
			// 또 특별히 FileWriter 객체를 따로 생성하지 않고 바로 생성하여 파라메터로 넣어줌.
			bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath, true));

			String string = new String(); // 임시 변수

			do {
				// 한줄씩 읽기
				string = bufferedReader.readLine();

				// 끝이 아닌경우, 새 파일에 내용 복사하여 쓰기
				if (string != null) {
					bufferedWriter.write(string);
					bufferedWriter.newLine(); // 한줄 개행
					System.out.println(string);
				}
			} while (string != null); // 파일 끝이면 null을 반환한다.
		} catch (Exception e) {
			System.out.println("오류" + e);
		} finally {
			try {
				bufferedReader.close();
				bufferedWriter.close();
			} catch (Exception e) {
				System.out.println("파일 닫기 오류" + e);
			}
		}
	}

}
