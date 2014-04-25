import java.io.Serializable;

/**
 * å ������ ��� �ִ� ��<br>
 * å ������ ��Ͻ� �뿩������ �ο��� ���� ���̵� �ִ�.<br>
 * ���� ���� �� �ݳ��� å�� ���� ���̵�� �˻��Ͽ� ���� �� �ݳ��� �̷������.<br>
 * 
 * @author songsh
 *
 */
public class Book implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8810852939226588983L;
	// member variable define
	/**
	 * bookid - �������(8�ڸ�) + "-" + �Ϸù�ȣ(2�ڸ�) ���� ä���Ѵ�. 
	 * �ű� ������ �԰� �Ǹ� ������� �Ϸ� ��ȣ�� ����Ѵ�.
	 * ����) 20140404-99 
	 */
	private String bookid="";
	private String title="";
	/**
	 * status - ���´� "�뿩����" �Ǵ� "�뿩��" �ΰ��� ���¸� ������.
	 */
	private String status="�뿩����";
	private String author="";
	private String publishDate="19000101";
	/**
	 * ISBN - ���ŵ����� ISBN ������ �Է��Ѵ�.
	 */
	private String ISBN="";
	/**
	 * pubCompany - ���ǻ�
	 */
	private String pubCompany="";
	
	
	// method define
	public String getBookid() {
		return bookid;
	}

	public String setBookid(String bookid) {
		if(bookid.length()==10)
			return "Book id �ڸ����� ���� �ʽ��ϴ�";
		this.bookid = bookid;
		return "����";
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
		// TODO ����üũ : ���� ���´� �뿩��, �뿩���� �� �ִ�.
		this.status = status;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishDate() {
		// TODO ��¥ üũ validation �ʿ�
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
		msg+="\nISBN : "+ISBN;
		msg+="\nPublish Date : "+publishDate;
		msg+="\nStatus : "+status;
		msg+="\n********************";
		msg+="\n";
		return msg;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		// TODO ISBN �ڸ��� üũ 13�ڸ����� �Ѵ�. (��. 9788925550633, 9788952227829 )
		this.ISBN = ISBN;
	}

	public String getPubCompany() {
		return pubCompany;
	}

	public void setPubCompany(String pubCompany) {
		this.pubCompany = pubCompany;
	}
}
