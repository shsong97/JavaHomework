import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Console(도스창)에서 수행하는 화면
 * @author songsh
 *
 */
public class JavaBookStoreConsole {
	
	BookStore store=new BookStore();
	
	public void main()
	{
		System.out.println("Java Book Store에 오신걸 환영합니다.");
		
		int menuSelect=-1;
		Scanner sc=new Scanner(System.in);
		
		
		while(menuSelect!=0)
		{
			MenuSelect();
			menuSelect=sc.nextInt();
			switch(menuSelect)
			{
			case 1:
				addBook();
				break;
			case 2:
				updateBook();
				break;
			case 3:
				deleteBook();
				break;
			case 4:
				listBook();
				break;
			case 5:
				rentBook();
				break;
			case 6:
				returnBook();
				break;
			default:
				break;
			}
			
		}
		System.out.println("안녕히 가세요!!!");
		sc.close();
	}
	/**
	 * 콘솔에서 사용하는 메뉴 선택 기능함수
	 */
	private void MenuSelect()
	{
		System.out.println("**************************************************");
		System.out.println("Menu를 선택해주세요.");
		System.out.println("1.도서등록");
		System.out.println("2.도서수정");
		System.out.println("3.도서삭제");
		System.out.println("4.도서조회");
		System.out.println("5.도서대여");
		System.out.println("6.도서반납");
		System.out.println("0.종료");
		System.out.println("**************************************************");
		System.out.print("선택 : ");
		
	}
	/**
	 * Console 에서 책 정보를 읽어서 Book 정보를 반환한다.
	 * @param book 등록할 책 정보
	 * @return book값이 반환된다.
	 */
	private Book inputBook(Book book)
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("Title : ");
			book.setTitle(in.readLine());
			
			System.out.print("Author : ");
			book.setAuthor(in.readLine());
			
			System.out.print("PublishCompany : ");
			book.setPubCompany(in.readLine());
			
			System.out.print("Publish Date : ");
			book.setPublishDate(in.readLine());
			
			System.out.print("ISBN : ");
			book.setISBN(in.readLine());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return book;
	}
	/**
	 * Console 에서 책정보를 등록한다.
	 */
	public void addBook()
	{
		Book book = new Book();
		
		if(book.setBookid(store.getBookId()).equals("정상"))
		{
			book=inputBook(book);
			store.addBook(book);
			System.out.println("도서를 추가하였습니다.");
		}
		else
		{
			System.out.println("도서 등록중 에러가 발생했습니다.");
		}
	}
	/**
	 * Console 에서 책정보를 수정한다.
	 */
	public void updateBook()
	{
		System.out.print("수정 도서번호를 입력하세요 : ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String bookid="";
		Book book=null;
	    try {
	    	bookid = in.readLine();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    book=store.searchBook(bookid);
	    if(book!=null)
	    {
			System.out.println(book.getBook());
			book=inputBook(book);
			store.updateBook(book);
			System.out.println("도서를 수정하였습니다.");
	    }
	    else
	    {
	    	System.out.println("도서를 찾지 못했습니다.");
	    }

	}
	/**
	 * Console 에서 책정보를 삭제한다.
	 */
	public void deleteBook()
	{
		System.out.print("삭제 도서번호를 입력하세요 : ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String bookid="";
		Book book=null;
	    try {
	    	bookid = in.readLine();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    book=store.searchBook(bookid);
	    if(book!=null)
	    {
	    	System.out.println(book.getBook());
			store.deleteBook(book);
			System.out.println("도서를 삭제하였습니다.");
	    }
	    else
	    {
	    	System.out.println("도서를 찾지 못했습니다.");
	    }
	}
	/**
	 * Console 에서 책 전체 정보를 조회한다.
	 */
	public void listBook()
	{
		ArrayList<Book> booklist=store.getBookList();
		for(int index=0;index<booklist.size();index++)
		{
			Book book=booklist.get(index);
			System.out.println(book.getBook());
		}
		System.out.println("도서를 조회하였습니다.");
	}
	/**
	 * Console 에서 책의 대여상태를 대여중으로 변경한다.
	 */
	public void rentBook()
	{
		System.out.print("빌릴 도서번호를 입력하세요 : ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String bookid="";
		Book book=null;
	    try {
	    	bookid = in.readLine();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    book=store.searchBook(bookid);
	    if(book!=null)
	    {
	    	System.out.println(book.getBook());
	    	store.rentBook(book);
			System.out.println("도서를 대여하였습니다.");
	    }
	    else
	    {
	    	System.out.println("도서를 찾지 못했습니다.");
	    }

	}
	/**
	 * Console 에서 책의 대여상태를 대여가능으로 변경한다.
	 */
	public void returnBook()
	{
		System.out.print("반납 도서번호를 입력하세요 : ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String bookid="";
		Book book=null;
	    try {
	    	bookid = in.readLine();
	    	
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    book=store.searchBook(bookid);
	    if(book!=null)
	    {
	    	System.out.println(book.getBook());
	    	store.returnBook(book);
			System.out.println("도서를 반납하였습니다.");
	    }
	    else
	    {
	    	System.out.println("도서를 찾지 못했습니다.");
	    }

	}
	
}
