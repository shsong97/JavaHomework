import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Console(����â)���� �����ϴ� ȭ��
 * @author songsh
 *
 */
public class JavaBookStoreConsole {
	
	BookStore store=new BookStore();
	
	public void main()
	{
		System.out.println("Java Book Store�� ���Ű� ȯ���մϴ�.");
		
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
		System.out.println("�ȳ��� ������!!!");
		sc.close();
	}
	/**
	 * �ֿܼ��� ����ϴ� �޴� ���� ����Լ�
	 */
	private void MenuSelect()
	{
		System.out.println("**************************************************");
		System.out.println("Menu�� �������ּ���.");
		System.out.println("1.�������");
		System.out.println("2.��������");
		System.out.println("3.��������");
		System.out.println("4.������ȸ");
		System.out.println("5.�����뿩");
		System.out.println("6.�����ݳ�");
		System.out.println("0.����");
		System.out.println("**************************************************");
		System.out.print("���� : ");
		
	}
	/**
	 * Console ���� å ������ �о Book ������ ��ȯ�Ѵ�.
	 * @param book ����� å ����
	 * @return book���� ��ȯ�ȴ�.
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
	 * Console ���� å������ ����Ѵ�.
	 */
	public void addBook()
	{
		Book book = new Book();
		
		if(book.setBookid(store.getBookId()).equals("����"))
		{
			book=inputBook(book);
			store.addBook(book);
			System.out.println("������ �߰��Ͽ����ϴ�.");
		}
		else
		{
			System.out.println("���� ����� ������ �߻��߽��ϴ�.");
		}
	}
	/**
	 * Console ���� å������ �����Ѵ�.
	 */
	public void updateBook()
	{
		System.out.print("���� ������ȣ�� �Է��ϼ��� : ");
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
			System.out.println("������ �����Ͽ����ϴ�.");
	    }
	    else
	    {
	    	System.out.println("������ ã�� ���߽��ϴ�.");
	    }

	}
	/**
	 * Console ���� å������ �����Ѵ�.
	 */
	public void deleteBook()
	{
		System.out.print("���� ������ȣ�� �Է��ϼ��� : ");
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
			System.out.println("������ �����Ͽ����ϴ�.");
	    }
	    else
	    {
	    	System.out.println("������ ã�� ���߽��ϴ�.");
	    }
	}
	/**
	 * Console ���� å ��ü ������ ��ȸ�Ѵ�.
	 */
	public void listBook()
	{
		ArrayList<Book> booklist=store.getBookList();
		for(int index=0;index<booklist.size();index++)
		{
			Book book=booklist.get(index);
			System.out.println(book.getBook());
		}
		System.out.println("������ ��ȸ�Ͽ����ϴ�.");
	}
	/**
	 * Console ���� å�� �뿩���¸� �뿩������ �����Ѵ�.
	 */
	public void rentBook()
	{
		System.out.print("���� ������ȣ�� �Է��ϼ��� : ");
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
			System.out.println("������ �뿩�Ͽ����ϴ�.");
	    }
	    else
	    {
	    	System.out.println("������ ã�� ���߽��ϴ�.");
	    }

	}
	/**
	 * Console ���� å�� �뿩���¸� �뿩�������� �����Ѵ�.
	 */
	public void returnBook()
	{
		System.out.print("�ݳ� ������ȣ�� �Է��ϼ��� : ");
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
			System.out.println("������ �ݳ��Ͽ����ϴ�.");
	    }
	    else
	    {
	    	System.out.println("������ ã�� ���߽��ϴ�.");
	    }

	}
	
}
