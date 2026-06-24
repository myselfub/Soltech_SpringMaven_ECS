package kw.ecs.zz.util;

import java.io.File;
import java.io.IOException;

import kw.fw.exception.ProcessException;

/**
 * 파일 체크 유틸리티
 * 
 * @ClassName FileCheckUtil.java
 * @Description  FileCheckUtil.java Class 
 * @Modification Information
 * <pre>
 *    수정일   수정자                   수정내용
 *  ----------   --------------------    -------------------------------
 *  2017. 12. 26.    60001234  강만석      최초생성
 * </pre>
 * @author K-water 업무시스템 혁신사업 : 공통팀 강만석 
 * @since  2017. 12. 26.
 * @version 1.0
 * <pre>Copyright (C) 2017 by Unlimited K-water, All right reserved. </pre>
 */
public class FileCheckUtil {
	
	/**
	 * 상대디렉토리 경로 조작(Path Traversal)을 방지한다.
	 * 예를 들면 경로에 ../../etc/passwd 등 상위경로로 가는 항목이 있다거나
	 * 환경파일 등에 접근하는 것을 방지한다.
	 * 
	 * @param totalPath
	 * @throws ProcessException
	 */
	public static boolean checkFilePathTraversal(String totalPath) throws RuntimeException, IOException {
		File file = new File(totalPath);
		return checkFilePathTraversal(file);
	}
	
	/**
	 * 상대디렉토리 경로 조작(Path Traversal)을 방지한다.
	 * 예를 들면 경로에 ../../etc/passwd 등 상위경로로 가는 항목이 있다거나
	 * 환경파일 등에 접근하는 것을 방지한다.
	 * 
	 * @param parent
	 * @param child
	 * @throws ProcessException
	 */
	public static boolean checkFilePathTraversal(String parent, String child) throws RuntimeException, IOException {
		File file = new File(parent, child);
		return checkFilePathTraversal(file);
	}
	
	/**
	 * 상대디렉토리 경로 조작(Path Traversal)을 방지한다.
	 * 예를 들면 경로에 ../../etc/passwd 등 상위경로로 가는 항목이 있다거나
	 * 환경파일 등에 접근하는 것을 방지한다.
	 * 
	 * @param file
	 * @throws ProcessException
	 */
	public static boolean checkFilePathTraversal(File file) throws RuntimeException, IOException {
		
		String[] configDirs = {"/etc/", "/bin", "/sbin", "/var", "/usr", "/opt"};
		String[] containsDirs = {"/WEB-INF/"};
		
		String absolutePath = file.getAbsolutePath();				// 일반 절대경로
		String canonicalPath = file.getCanonicalPath();			// /../../ 등을 제외한 절대경로

		/* 1. 시스템 폴더에 접근하는지 확인 */
		for (String configDir : configDirs) {
			if (canonicalPath.startsWith(configDir)) {
				throw new RuntimeException(configDir + " : 접근 금지된 경로입니다.");
			}
		}
		
		/* 2. WAS 환경파일에 접근하는지 확인 */
		for (String containsDir : containsDirs) {
			if (canonicalPath.contains(containsDir)) {
				throw new RuntimeException(containsDir + " : 접근 금지된 경로입니다.");
			}
		}
		
		/* 3. /../../ 등을 포함한 경로와 포함하지 않은 경로를 비교하여 다르면 튕겨냄 */
		if (!absolutePath.equals(canonicalPath)) {
			throw new RuntimeException("디렉토리 경로 조작이 감지되었습니다.");
		}
		
		return true;
	}
}
