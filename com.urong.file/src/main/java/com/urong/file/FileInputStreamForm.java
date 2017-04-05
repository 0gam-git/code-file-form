package com.urong.file;

import java.io.FileInputStream;

public class FileInputStreamForm {

	public static void main(String[] args) {
		// 바이트 단위로 파일읽기
		String filePath = System.getProperty("user.dir") + "/file/test.json";
		FileInputStream fileStream = null; // 파일 스트림
		int i = 0; // 한 바이트를 담을 변수

		try {
			fileStream = new FileInputStream(filePath);// 파일 스트림 생성

			do {
				i = fileStream.read(); // 한 바이트 읽기
				System.out.print((char) i);
			} while (i != -1);

		} catch (Exception e) {
			System.out.println("파일 입출력 에러!!" + e);
		} finally {
			try {
				fileStream.close();// 파일 닫기. 여기에도 try/catch가 필요하다.
			} catch (Exception e) {
				System.out.println("닫기 실패" + e);
			}
		}
	}
}
