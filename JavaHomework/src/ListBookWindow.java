import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ListBookWindow extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7980526411532263066L;
	JButton btnSubmit;
	JTextArea list;
	BookStore bookstore;
	ListBookWindow(BookStore bookstore)
	{
		setLayout(new BorderLayout());
		list=new JTextArea();
		list.setLineWrap(true);
		JScrollPane scroll=new JScrollPane();
		scroll.getViewport().add(list);
		add(scroll,BorderLayout.CENTER);
		btnSubmit=new JButton("List");
		btnSubmit.addActionListener(this);
		add(btnSubmit,BorderLayout.NORTH);
		this.bookstore=bookstore;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String msg="";
		for(Book b:bookstore.getBookList())
		{
			msg+=b.getBook();
		}
		list.setText(msg);
	}
}
