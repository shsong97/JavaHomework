import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class UpdateBookWindow extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lBookId;
	JTextField tBookId;
	
	JLabel lTitle;
	JLabel lAuthor;
	JLabel lPublishdate;
	JLabel lPublishCompany;
	JLabel lISBN;
	
	JTextField tTitle;
	JTextField tAuthor;
	JTextField tPublishdate;
	JTextField tPublishCompany;
	JTextField tISBN;
	
	JButton btnSubmit;
	JButton btnSearch;
	
	BookStore bookstore;
	public UpdateBookWindow(BookStore bookstore)
	{
		this.bookstore=bookstore;
		createWindow();
		
	}
	public void createWindow()
	{
		setLayout(new BorderLayout());
		JPanel j=new JPanel();
		GridLayout g=new GridLayout(0,2,10,10);
		/* rows - the rows, with the value zero meaning any number of rows
			cols - the columns, with the value zero meaning any number of columns
			hgap - the horizontal gap
			vgap - the vertical gap */
		
		j.setLayout(g);
		lTitle=new JLabel("Title : ");
		lAuthor=new JLabel("Author : ");
		lPublishCompany=new JLabel("Publisher : ");
		lPublishdate=new JLabel("Publishdate : ");
		lISBN=new JLabel("ISBN : ");
		
		tTitle=new JTextField(30);
		tAuthor=new JTextField(30);
		tPublishCompany=new JTextField(30);
		tPublishdate=new JTextField(30);
		tISBN=new JTextField(30);
		
		btnSubmit=new JButton("Update");
		btnSubmit.setActionCommand("submit");
		btnSubmit.addActionListener(this);
		
		j.add(lTitle);
		j.add(tTitle);
		j.add(lAuthor);
		j.add(tAuthor);
		j.add(lPublishCompany);
		j.add(tPublishCompany);
		j.add(lPublishdate);
		j.add(tPublishdate);
		j.add(lISBN);
		j.add(tISBN);

		JPanel north=new JPanel();
		btnSearch=new JButton("Search");
		btnSearch.setActionCommand("search");
		btnSearch.addActionListener(this);
		lBookId=new JLabel("BookId : ");
		tBookId=new JTextField(30);
		north.add(lBookId);
		north.add(tBookId);
		north.add(btnSearch);
		add(north,BorderLayout.NORTH);
		add(j,BorderLayout.CENTER);		
		add(btnSubmit,BorderLayout.SOUTH);
		//pack();
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String command=ae.getActionCommand();
		if(command.equals("submit"))
		{
			// 도서 정보를 수정한다. 
			Book book=new Book();
			book.setBookid(tBookId.getText());
			book.setAuthor(tAuthor.getText());
			book.setISBN(tISBN.getText());
			book.setTitle(tTitle.getText());
			book.setPublishDate(tPublishdate.getText());
			book.setPubCompany(tPublishCompany.getText());
			bookstore.updateBook(book);
			System.out.println(book.getBook());
		}
		else if(command.equals("search"))
		{
			// 도서 정보를 검색한다. 
			Book book=bookstore.searchBook(tBookId.getText());
			if(book!=null)
			{
				tAuthor.setText(book.getAuthor());
				tISBN.setText(book.getISBN());
				tTitle.setText(book.getTitle());
				tPublishdate.setText(book.getPublishDate());
				tPublishCompany.setText(book.getPubCompany());
				System.out.println(book.getBook());
			}
			else
			{
				System.out.println("검색한 도서가 없습니다");
			}
		}
	}
}
