import java.util.ArrayList;
import java.util.Calendar;


/**
 * 도서 정보를 관리하는 control
 * @author songsh
 *
 */
public class BookStore
{
	/**
	 * booklist - 책 정보를 ArrayList에서 관리한다.
	 */
	ArrayList<Book> booklist=new ArrayList<Book>();
	/**
	 * 책번호를 부여하기 위한 항번값
	 */
	int maxbookid=0;
	
	public BookStore()
	{
		
	}
	public void readBooks()
	{
		BookStoreFile bookfile=new BookStoreFile();
		booklist=bookfile.readBooks();
		if(booklist==null)
			booklist=new ArrayList<Book>();
	}
	public void writeBooks()
	{
		BookStoreFile bookfile=new BookStoreFile();
		bookfile.writeBooks(booklist);
	}
	/**
	 * bookid 채번
	 * @return 신규로 추가시 부여할 책ID : 연도+월+일+"-"+항번2자리
	 */
	public String getBookId()
	{
		// TODO 날짜+"-"+maxbookid 로 부여한다.
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH)+1;
		int date=c.get(Calendar.DATE);
		
		String today=new Integer(year).toString() + String.format("%02d",month) + String.format("%02d",date);
		String bookid=today+"-"+ String.format("%02d", (maxbookid+1));
		return bookid;
	}
	public ArrayList<Book> getBookList()
	{
		return booklist;
	}
	/**
	 * book 을 추가한다.
	 * @param book 추가할 book 정보
	 * @return 성공시 true 실패면 false
	 */
	public boolean addBook(Book book)
	{		
		if(book.setBookid(getBookId()).equals("정상"))
		{
			booklist.add(book);
			maxbookid++;
			return true;
		}
		return false;
	}
	/**
	 * book 을 수정한다.
	 * @param book 수정할 book 정보
	 * @return 성공시 true 실패면 false
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
	 * book 을 삭제한다.
	 * @param book 삭제할 book 정보
	 * @return 성공시 true 실패면 false
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
	 * book 정보를 받아서 대여중 상태로 변경한다.
	 * @param book - 변경할 책정보
	 * @return 성공시 true 실패면 false
	 */
	public boolean rentBook(Book book)
	{
	    int index=searchOption("bookid",book.getBookid());
	    if(index>=0)
	    {
			book.setStatus("대여중");
			booklist.set(index, book);
			return true;
	    }
	    return false;

	}
	/**
	 * book 정보를 받아서 대여가능 상태로 변경한다.
	 * @param book - 변경할 책정보
	 * @return 성공시 true 실패면 false
	 */
	public boolean returnBook(Book book)
	{
		int index=searchOption("bookid",book.getBookid());
	    if(index>=0)
	    {
			book.setStatus("대여가능");
			booklist.set(index, book);
			return true;
	    }
	    return false;
	}
	/**
	 * bookid로 검색시 성공하면 Book 정보가 넘어온다.
	 * @param bookid - 검색할 고유의 bookid
	 * @return 성공하면 Book 객체 값이 넘어오고 실패시 null 이 반환된다.
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
	 * 검색 옵션
	 * @param option - bookid, title, author 세가지로 검색한다.
	 * @param keyword - 검색할 값을 입력한다.
	 * @return 성공하면 index 값이 넘어오고 실패시 -1 이 반환된다.
	 */
	private int searchOption(String option, String keyword)
	{
		// TODO 검색옵션(bookid, title, author)
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
