import java.util.ArrayList;
import java.util.Calendar;


/**
 * ���� ������ �����ϴ� control
 * @author songsh
 *
 */
public class BookStore
{
	/**
	 * booklist - å ������ ArrayList���� �����Ѵ�.
	 */
	ArrayList<Book> booklist=new ArrayList<Book>();
	/**
	 * å��ȣ�� �ο��ϱ� ���� �׹���
	 */
	int maxbookid=0;
	String lastdate="";
	
	public BookStore()
	{
		
	}
	/**
	 * book�� ������ �ؽ�Ʈ���Ͽ��� �о�´�.
	 */
	public void readBooks()
	{
		BookStoreFile bookfile=new BookStoreFile();
		booklist=bookfile.readBooks();
		if(booklist==null)
		{
			// ������ �ʱ�ȭ
			booklist=new ArrayList<Book>();
			this.lastdate="";
			this.maxbookid=0;
		}
		else
		{
			// ���������� ����� ���ڿ� ��ȣ�� �о ���ð� �ٸ��� bookid�� ó������ �ٽ� �����Ѵ�.
			Calendar c=Calendar.getInstance();
			int year=c.get(Calendar.YEAR);
			int month=c.get(Calendar.MONTH)+1;
			int date=c.get(Calendar.DATE);
			
			String today=new Integer(year).toString() + String.format("%02d",month) + String.format("%02d",date);
			
			this.lastdate=bookfile.lastdate;
			this.maxbookid=bookfile.maxbookid;
			if(!lastdate.equals(today))
			{
				this.lastdate=today;
				this.maxbookid=0;
			}
		}
	}
	/**
	 * book�� ������ �ؽ�Ʈ���Ͽ� ����.
	 */
	public void writeBooks()
	{
		BookStoreFile bookfile=new BookStoreFile();
		bookfile.writeBooks(lastdate,maxbookid,booklist);
	}
	/**
	 * bookid ä��
	 * @return �űԷ� �߰��� �ο��� åID : ����+��+��+"-"+�׹�2�ڸ�
	 */
	public String getBookId()
	{
		// TODO ��¥+"-"+maxbookid �� �ο��Ѵ�.
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH)+1;
		int date=c.get(Calendar.DATE);
		
		lastdate=new Integer(year).toString() + String.format("%02d",month) + String.format("%02d",date);
		String bookid=lastdate+"-"+ String.format("%02d", (maxbookid+1));
		return bookid;
	}
	/**
	 * booklist ��ü�� ��ȯ�Ѵ�.
	 * @return
	 */
	public ArrayList<Book> getBookList()
	{
		return booklist;
	}
	/**
	 * book �� �߰��Ѵ�.
	 * @param book �߰��� book ����
	 * @return ������ true ���и� false
	 */
	public boolean addBook(Book book)
	{		
		if(book.setBookid(getBookId()).equals("����"))
		{
			booklist.add(book);
			maxbookid++;
			return true;
		}
		return false;
	}
	/**
	 * book �� �����Ѵ�.
	 * @param book ������ book ����
	 * @return ������ true ���и� false
	 */
	public boolean updateBook(Book book)
	{
		int index=searchOption("bookid",book.getBookid());
	    if(index>=0)
	    {
			booklist.set(index, book);
			return true;
	    }
	    return false;

	}
	/**
	 * book �� �����Ѵ�.
	 * @param book ������ book ����
	 * @return ������ true ���и� false
	 */
	public boolean deleteBook(Book book)
	{
		int index=searchOption("bookid",book.getBookid());
	    if(index>=0)
	    {
			booklist.remove(index);
			return true;
	    }
	    return false;
	}
	/**
	 * book ������ �޾Ƽ� �뿩�� ���·� �����Ѵ�.
	 * @param book - ������ å����
	 * @return ������ true ���и� false
	 */
	public boolean rentBook(Book book)
	{
	    int index=searchOption("bookid",book.getBookid());
	    if(index>=0)
	    {
			book.setStatus("�뿩��");
			booklist.set(index, book);
			return true;
	    }
	    return false;

	}
	/**
	 * book ������ �޾Ƽ� �뿩���� ���·� �����Ѵ�.
	 * @param book - ������ å����
	 * @return ������ true ���и� false
	 */
	public boolean returnBook(Book book)
	{
		int index=searchOption("bookid",book.getBookid());
	    if(index>=0)
	    {
			book.setStatus("�뿩����");
			booklist.set(index, book);
			return true;
	    }
	    return false;
	}
	/**
	 * bookid�� �˻��� �����ϸ� Book ������ �Ѿ�´�.
	 * @param bookid - �˻��� ������ bookid
	 * @return �����ϸ� Book ��ü ���� �Ѿ���� ���н� null �� ��ȯ�ȴ�.
	 */
	public Book searchBook(String bookid)
	{
		int index=searchOption("bookid",bookid);
		Book book=null;
		if(index>=0)
		{
			book=booklist.get(index);
		}
		return book;
	}
	/**
	 * �˻� �ɼ�
	 * @param option - bookid, title, author �������� �˻��Ѵ�.
	 * @param keyword - �˻��� ���� �Է��Ѵ�.
	 * @return �����ϸ� index ���� �Ѿ���� ���н� -1 �� ��ȯ�ȴ�.
	 */
	private int searchOption(String option, String keyword)
	{
		// TODO �˻��ɼ�(bookid, title, author)
		int result=-1;

		if(option.equals("title"))
		{
			for(int index=0;index<booklist.size();index++)
			{
				Book book=booklist.get(index);
				if(keyword.equals(book.getTitle()))
				{
					result=index;
					break;
				}
			}
		}
		else if(option.equals("author"))
		{
			for(int index=0;index<booklist.size();index++)
			{
				Book book=booklist.get(index);
				if(keyword.equals(book.getAuthor()))
				{
					result=index;
					break;
				}
			}
		}
		else if(option.equals("bookid"))
		{
			for(int index=0;index<booklist.size();index++)
			{
				Book book=booklist.get(index);
				if(keyword.equals(book.getBookid()))
				{
					result=index;
					break;
				}
			}
		}
			
		return result;
	}
	
}
