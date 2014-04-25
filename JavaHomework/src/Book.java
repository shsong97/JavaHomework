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
	 * ��ü�� �����ϱ� ���� serial��ȣ�̴�. ����� ���� ���簪�� �ٸ��� �о�ö� �����Ѵ�.
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
	/**
	 * å���̵��� ��ȯ�Ѵ�
	 * @return å���̵�
	 */
	public String getBookid() {
		return bookid;
	}

	/**
	 * �ű� ������ �԰� �Ǹ� ������� �Ϸ� ��ȣ�� ����Ѵ�.
	 * ����) 20140404-99 
	 * @param bookid �������(8�ڸ�) + "-" + �Ϸù�ȣ(2�ڸ�) ���� ä���Ѵ�.
	 * @return ��ϵǸ� "����" �׷��� ������ �����޼����� ���´�.
	 */
	public String setBookid(String bookid) {
		if(bookid.length()==10)
			return "Book id �ڸ����� ���� �ʽ��ϴ�";
		this.bookid = bookid;
		return "����";
	}

	/**
	 * å ������ ��ȯ�Ѵ�
	 * @return ����
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * ���´� "�뿩����" �Ǵ� "�뿩��" �ΰ��� ���¸� ������.
	 * @return ���°�
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ���´� "�뿩����" �Ǵ� "�뿩��" �ΰ��� ���¸� ������.
	 * @param status ���°�
	 */
	public void setStatus(String status) {
		// TODO ����üũ : ���� ���´� �뿩��, �뿩���� �� �ִ�.
		this.status = status;
	}

	/**
	 * �۰����� ��ȯ�ȴ�
	 * @return �۰���
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * �۰����� �����Ѵ�.
	 * @param author �۰���
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * �������� ��ȯ�Ѵ�
	 * @return ������
	 */
	public String getPublishDate() {
		// TODO ��¥ üũ validation �ʿ�
		return publishDate;
	}

	/**
	 * �������� ����Ѵ�
	 * @param publishDate ������
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * å�� ������ ���ڿ��� ��ȯ�Ѵ�
	 * @return å����
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
	 * ISBN�� ��ȯ�Ѵ�
	 * @return ISBN
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * å�� ���������� ISBN�� �����Ѵ�.
	 * ���̸� üũ�Ͽ�  13�ڸ��� �ƴϸ� ��ȿ�� ��ȣ�� �ƴϴ�.
	 * @param ISBN å������ȣ
	 */
	public void setISBN(String ISBN) {
		// TODO ISBN �ڸ��� üũ 13�ڸ����� �Ѵ�. (��. 9788925550633, 9788952227829 )
		this.ISBN = ISBN;
	}

	/**
	 * ���ǻ���� ��ȯ�Ѵ�
	 * @return ���ǻ��
	 */
	public String getPubCompany() {
		return pubCompany;
	}

	/**
	 * ���ǻ���� ����Ѵ�
	 * @param pubCompany ���ǻ�
	 */
	public void setPubCompany(String pubCompany) {
		this.pubCompany = pubCompany;
	}
}
