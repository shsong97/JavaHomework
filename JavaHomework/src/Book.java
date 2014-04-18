/**
 * 책 정보를 담고 있는 모델<br>
 * 책 정보를 등록시 대여점에서 부여한 고유 아이디가 있다.<br>
 * 도서 대출 및 반납은 책의 고유 아이디로 검색하여 대출 및 반납이 이루어진다.<br>
 * 
 * @author songsh
 *
 */
public class Book
{
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
	public String getBookid() {
		return bookid;
	}

	public String setBookid(String bookid) {
		if(bookid.length()==10)
			return "Book id 자리수가 맞지 않습니다";
		this.bookid = bookid;
		return "정상";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		// TODO 에러체크 : 현재 상태는 대여중, 대여가능 만 있다.
		this.status = status;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishDate() {
		// TODO 날짜 체크 validation 필요
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	
	public String getBook()
	{
		String msg="";
		msg+="\n********************";
		msg+="\nBook ID : "+bookid;
		msg+="\nTitle : "+title;
		msg+="\nAuthor : "+author;
		msg+="\nPublish Date : "+publishDate;
		msg+="\nStatus : "+status;
		msg+="\n********************";
		msg+="\n";
		return msg;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		// TODO ISBN 자리수 체크 13자리여야 한다. (예. 9788925550633, 9788952227829 )
		ISBN = iSBN;
	}

	public String getPubCompany() {
		return pubCompany;
	}

	public void setPubCompany(String pubCompany) {
		this.pubCompany = pubCompany;
	}
}
