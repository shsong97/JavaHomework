import java.io.Serializable;

/**
 * 책 정보를 담고 있는 모델<br>
 * 책 정보를 등록시 대여점에서 부여한 고유 아이디가 있다.<br>
 * 도서 대출 및 반납은 책의 고유 아이디로 검색하여 대출 및 반납이 이루어진다.<br>
 * 
 * @author songsh
 *
 */
public class Book implements Serializable
{
	/**
	 * 객체를 저장하기 위한 serial번호이다. 저장된 값과 현재값이 다르면 읽어올때 실패한다.
	 */
	private static final long serialVersionUID = -8810852939226588983L;
	// member variable define
	/**
	 * bookid - 등록일자(8자리) + "-" + 일련번호(2자리) 으로 채번한다. 
	 * 신규 도서가 입고 되면 등록일자 일련 번호로 등록한다.
	 * 예시) 20140404-99 
	 */
	private String bookid="";
	private String title="";
	/**
	 * status - 상태는 "대여가능" 또는 "대여중" 두가지 상태를 가진다.
	 */
	private String status="대여가능";
	private String author="";
	private String publishDate="19000101";
	/**
	 * ISBN - 구매도서의 ISBN 정보를 입력한다.
	 */
	private String ISBN="";
	/**
	 * pubCompany - 출판사
	 */
	private String pubCompany="";
	
	
	// method define
	/**
	 * 책아이디값을 반환한다
	 * @return 책아이디
	 */
	public String getBookid() {
		return bookid;
	}

	/**
	 * 신규 도서가 입고 되면 등록일자 일련 번호로 등록한다.
	 * 예시) 20140404-99 
	 * @param bookid 등록일자(8자리) + "-" + 일련번호(2자리) 으로 채번한다.
	 * @return 등록되면 "정상" 그렇지 않으면 에러메세지가 나온다.
	 */
	public String setBookid(String bookid) {
		if(bookid.length()==10)
			return "Book id 자리수가 맞지 않습니다";
		this.bookid = bookid;
		return "정상";
	}

	/**
	 * 책 제목을 반환한다
	 * @return 제목
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 상태는 "대여가능" 또는 "대여중" 두가지 상태를 가진다.
	 * @return 상태값
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 상태는 "대여가능" 또는 "대여중" 두가지 상태를 가진다.
	 * @param status 상태값
	 */
	public void setStatus(String status) {
		// TODO 에러체크 : 현재 상태는 대여중, 대여가능 만 있다.
		this.status = status;
	}

	/**
	 * 작가명이 반환된다
	 * @return 작가명
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * 작가명을 설정한다.
	 * @param author 작가명
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * 출판일을 반환한다
	 * @return 출판일
	 */
	public String getPublishDate() {
		// TODO 날짜 체크 validation 필요
		return publishDate;
	}

	/**
	 * 출판일을 등록한다
	 * @param publishDate 출판일
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * 책의 정보를 문자열로 반환한다
	 * @return 책정보
	 */
	public String getBook()
	{
		String msg="";
		msg+="\n********************";
		msg+="\nBook ID : "+bookid;
		msg+="\nTitle : "+title;
		msg+="\nAuthor : "+author;
		msg+="\nISBN : "+ISBN;
		msg+="\nPublish Date : "+publishDate;
		msg+="\nStatus : "+status;
		msg+="\n********************";
		msg+="\n";
		return msg;
	}

	/**
	 * ISBN을 반환한다
	 * @return ISBN
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * 책의 고유정보인 ISBN을 설정한다.
	 * 길이를 체크하여  13자리가 아니면 유효한 번호가 아니다.
	 * @param ISBN 책고유번호
	 */
	public void setISBN(String ISBN) {
		// TODO ISBN 자리수 체크 13자리여야 한다. (예. 9788925550633, 9788952227829 )
		this.ISBN = ISBN;
	}

	/**
	 * 출판사명을 반환한다
	 * @return 출판사명
	 */
	public String getPubCompany() {
		return pubCompany;
	}

	/**
	 * 출판사명을 등록한다
	 * @param pubCompany 출판사
	 */
	public void setPubCompany(String pubCompany) {
		this.pubCompany = pubCompany;
	}
}
