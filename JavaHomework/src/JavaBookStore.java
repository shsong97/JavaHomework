
/**
 * 자바로 구현한 책 대여점 시스템입니다. 
 * 본 프로젝트의 목적은 자바 개발 스킬 및 객체 지향 언어의 개념을 이해하기 위한 프로젝트로
 * 콘솔 화면으로 구현을 하고 시스템을 확정하여 윈도우, 웹으로 개발을 진행합니다.
 * 
 * @author songsh
 *
 */
public class JavaBookStore {
	/**
	 * 메인 함수 : <br>
	 * 1. 콘솔(도스창)에서 대여점 구현<br>
	 * 2. 윈도우 화면으로 구현<br>
	 * 3. 웹으로 구현<br>
	 * @param args
	 */
	public static void main(String[] args)
	{
		//1.Console 실행
		//new JavaBookStoreConsole().main();
		//2.Swing 실행
		new JavaBookStoreWindow();
	}
	
}
