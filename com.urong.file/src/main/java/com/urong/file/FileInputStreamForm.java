package com.urong.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileInputStreamForm {

	final String inputFilePath = System.getProperty("user.dir") + "/file/test.json";
	final String outputFilePath = System.getProperty("user.dir") + "/file/output.json";

	public static void main(String[] args) {

	}

	// 바이트 단위로 파일읽기
	private void test1() {

		// 파일 스트림
		FileInputStream fileStream = null;
		int i = 0; // 한 바이트를 담을 변수

		try {
			// 파일 스트림 생성
			fileStream = new FileInputStream(inputFilePath);

			do {
				// 한 바이트 읽기
				i = fileStream.read();
				System.out.print((char) i);
			} while (i != -1);

		} catch (Exception e) {
			System.out.println("파일 입출력 에러!!" + e);
		} finally {
			try {
				// 파일 닫기. 여기에도 try/catch가 필요하다.
				fileStream.close();
			} catch (Exception e) {
				System.out.println("닫기 실패" + e);
			}
		}
	}

	// 바이트 단위로 파일읽기
	private void test2() {
		// 파일 스트림
		FileInputStream fileStream = null;

		try {
			// 파일 스트림 생성
			fileStream = new FileInputStream(inputFilePath);

			// 파일 내용을 담을 버퍼(?) 선언
			byte[] readBuffer = new byte[fileStream.available()];
			while (fileStream.read(readBuffer) != -1) //
			{
			}

			System.out.println(new String(readBuffer)); // 출력

		} catch (Exception e) {
			System.out.println("파일 입출력 에러!!" + e);
		} finally {
			try {
				// 파일 닫기. 여기에도 try/catch가 필요하다.
				fileStream.close();
			} catch (Exception e) {
				System.out.println("닫기 실패" + e);
			}
		}
	}

	// 바이트 단위로 파일읽기
	private void test3() {

		FileInputStream inputStream = null; // 파일 읽기 스트림
		FileOutputStream outputStream = null; // 파일 쓰기 스트림

		try {

			// 파일 입력 스트림 생성
			inputStream = new FileInputStream(inputFilePath);

			// 파일 출력 스트림 생성
			outputStream = new FileOutputStream(outputFilePath);

			// 파일 내용을 담을 버퍼(?) 선언
			byte[] readBuffer = new byte[1024];
			while (inputStream.read(readBuffer, 0, readBuffer.length) != -1) {
				// 버퍼 크기만큼 읽을 때마다 출력 스트림에 써준다.
				outputStream.write(readBuffer);
			}

		} catch (Exception e) {
			System.out.println("파일 입출력 에러!!" + e);
		} finally {
			try {
				// 파일 닫기. 여기에도 try/catch가 필요하다.
				inputStream.close();
				outputStream.close();
			} catch (Exception e) {
				System.out.println("닫기 실패" + e);
			}
		}
	}

	// 바이트 단위로 파일읽기
	private void test4() {

		// 파일 스트림
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;

		// 버퍼 스트림
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;

		try {
			// 파일 입력 스트림 생성
			inputStream = new FileInputStream(inputFilePath);
			// 파일 출력 스트림 생성
			bufferedInputStream = new BufferedInputStream(inputStream);

			outputStream = new FileOutputStream(outputFilePath);
			bufferedOutputStream = new BufferedOutputStream(outputStream);

			// 파일 내용을 담을 버퍼(?) 선언
			byte[] readBuffer = new byte[1024];
			while (bufferedInputStream.read(readBuffer, 0, readBuffer.length) != -1) {
				// 버퍼 크기만큼 읽을 때마다 출력 스트림에 써준다.
				bufferedOutputStream.write(readBuffer);
			}

		} catch (Exception e) {
			System.out.println("파일 입출력 에러!!" + e);
		} finally {
			try {
				// 파일 닫기. 여기에도 try/catch가 필요하다.
				// 보조스트림을 닫으면 원스트림도 닫힌다.
				bufferedInputStream.close();
				bufferedOutputStream.close();
			} catch (Exception e) {
				System.out.println("닫기 실패" + e);
			}
		}
	}

	// BufferedInputStream
	private void test5() {

		BufferedInputStream bs = null;

		try {
			bs = new BufferedInputStream(new FileInputStream(inputFilePath));
			byte[] b = new byte[bs.available()]; // 임시로 읽는데 쓰는 공간
			System.out.println(b.length);
			while (bs.read(b) != -1) {
			}

			System.out.println(new String(b)); // 필요에 따라 스트링객체로 변환

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				bs.close(); // 반드시 닫는다.
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void test6() {
		BufferedOutputStream bs = null;

		try {
			bs = new BufferedOutputStream(new FileOutputStream(outputFilePath));
			// bs.write(text.getText().getBytes()); // Byte형으로만 넣을 수 있음
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				bs.close(); // 반드시 닫는다.
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
