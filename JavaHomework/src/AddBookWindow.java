import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * AddBookWindow 은 도서를 등록하는 JPanel 클래스이다.
 * @author songsh
 *
 */
public class AddBookWindow extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	BookStore bookstore;
	public AddBookWindow(BookStore bookstore)
	{
		this.bookstore=bookstore;
		createWindow();
	}
	private void createWindow()
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
		
		btnSubmit=new JButton("Add");
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
			// 도서 정보를 등록한다. 
			Book book=new Book();
			book.setAuthor(tAuthor.getText());
			book.setISBN(tISBN.getText());
			book.setTitle(tTitle.getText());
			book.setPublishDate(tPublishdate.getText());
			book.setPubCompany(tPublishCompany.getText());
			bookstore.addBook(book);
			System.out.println(book.getBook());
		}
	}
}
