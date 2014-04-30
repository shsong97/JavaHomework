import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * ����/DVD �뿩 �ý��� Client ����
 * �ű� ���� �԰�� ���� ������ ����ϰ� ���� �� ������ �����ϴ�.
 * �뿩������ ���� �뿩��û�� �ϸ� ����ID�� �Է��Ͽ� �뿩���Ѵ�.
 * �ݳ��ÿ��� ����ID�� ��ȸ�ؼ� �ݳ���û�� �Ѵ�.
 * �Է� ����� text field�� ���� �Է��ϰų� ���ڵ�� �о �Է��Ѵ�.
 * 
 * @version 1.0
 * @author songsh
 * @since 2014.04.04
 */
public class JavaBookStoreWindow extends JFrame implements ActionListener,ItemListener,WindowListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Menu Item
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;
	
	// Panel
	JPanel main;
	
	// Bookstore
	private BookStore bookstore=new BookStore();
	
	/**
	 * BookStore control�� �ٸ� ȭ�鿡 �Ѱ��ֱ� ���� �Լ�
	 * @return BookStore ��������
	 */
	public BookStore getStore()
	{
		return bookstore;
	}
	/**
	 * 1.ȭ��ũ��� ��ġ�� ���ϰ� ���� ��ư�� �����Ѵ�.<br>
	 * 2.�޴��� �����Ѵ�.<br>
	 */
	public JavaBookStoreWindow()
	{
		// TODO ȭ���� �׸���.
		super("�¶��� ���� �뿩��");
		
		// ȭ�� UI�� �ý��ۿ� �°� ����
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ȭ�� ũ�� ����
        setSize(1000, 600);
        setLocation(300,100);
        setResizable(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        // �޴� ����
        createMenu();
        
        // �г� ����
        createPanel();
        
        // ȭ�� ������
        setVisible(true);
        
        // ���Ͽ� ������ ������ �о�´�.
        bookstore.readBooks();
	}
	private void createPanel()
	{
		main=new JPanel();
		JLabel mainText=new JLabel("Main Title �Դϴ�.");
		main.add(mainText);
		add(main);
	}
	private void createMenu()
	{
		// �޴� ����
        menuBar = new JMenuBar();
        Font font=new Font("����", Font.BOLD, 15);
        //������� �޴�
        menu = new JMenu("����");
        menu.setFont(font);
        menuBar.add(menu);

        menuItem = new JMenuItem("�������");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // �̺�Ʈ ���
        menu.add(menuItem);

        menuItem = new JMenuItem("��������");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // �̺�Ʈ ���
        menu.add(menuItem);

        menuItem = new JMenuItem("��������");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // �̺�Ʈ ���
        menu.add(menuItem);

        //menu.addSeparator();
        

        //�뿩
        menu = new JMenu("�뿩");
        menu.setFont(font);
        menuBar.add(menu);
        
        menuItem = new JMenuItem("������ȸ");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // �̺�Ʈ ���
        menu.add(menuItem);

        menuItem = new JMenuItem("�����뿩");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // �̺�Ʈ ���
        menu.add(menuItem);
        
        menuItem = new JMenuItem("�����ݳ�");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // �̺�Ʈ ���
        menu.add(menuItem);
        
        //����
        menu = new JMenu("����");
        menu.setFont(font);
        menuBar.add(menu);
        
        menuItem = new JMenuItem("�뿩�� �����");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // �̺�Ʈ ���
        menu.add(menuItem);
        
        menuItem = new JMenuItem("����");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // �̺�Ʈ ���
        menu.add(menuItem);
        
        setJMenuBar(menuBar);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO �޴��� ���� ����� ó���Ѵ�. ��. ����, üũ �޴� 
		//String command="";
	}

	/**
	 * �޴��� ���ý� �����Ѵ�.<br>
	 * �޴� :<br>
	 * �������, ��������, ��������,<br>
	 * ������ȸ, �����뿩, �����ݳ�, <br>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO ���� ��� ȭ���� �����Ͽ� �ϱ��� �޴��� �ϼ��ϼ���.
		String command=e.getActionCommand();
		if(command.equals("�������"))
		{
			this.remove(main);
			main=new AddBookWindow(bookstore);
			add(main);
			this.validate();
		}
		else if(command.equals("��������"))
		{
			this.remove(main);
			main=new UpdateBookWindow(bookstore);
			add(main);
			this.validate();
		}
		else if(command.equals("��������"))
		{
			// ����.
		}
		else if(command.equals("������ȸ"))
		{
			// ����.
			this.remove(main);
			main=new ListBookWindow(bookstore);
			add(main);
			this.validate();
		}
		else if(command.equals("�����뿩"))
		{
			// ����.
		}
		else if(command.equals("�����ݳ�"))
		{
			// ����.
		}
		else if(command.equals("�뿩�� �����"))
		{
			HelpWindow j=new HelpWindow(command);
			j.setSize(400,300);
			j.setVisible(true);
		}
		else if(command.equals("����"))
		{
			// ���α׷� ����� ���Ͽ� ���� �����Ѵ�.
			bookstore.writeBooks();
			System.exit(0);
		}
	}
	
	/**
	 * ���� â
	 * @author songsh
	 *
	 */
	class HelpWindow extends JDialog implements ActionListener
	{
		/**
		 * dialog ���� ������ ���� ���̵�
		 */
		private static final long serialVersionUID = 3102569911259150777L;
		HelpWindow(String title)
		{
			this.setTitle(title);
			createWindow();
		}
		private void createWindow()
		{
			String message="�ڹ� �¶��� �뿩���� ������ ���, ����, �����ϴ� ��ɰ� ��ϵ� ������ �뿩/�ݳ��ϴ� �ý����Դϴ�.";
						
			setLayout(new BorderLayout());
			JTextArea title=new JTextArea();
			title.setText(message); // ���� �Է�
			title.setLineWrap(true); // ���ڸ� â�� �°� �����ٷ� �����ش�.
			JScrollPane scroll=new JScrollPane(); // ��ũ�� â
			scroll.getViewport().add(title); // ��ũ��â�� TextArea �߰�
			add(scroll,BorderLayout.CENTER);
			JButton closeButton=new JButton("Close");
			closeButton.addActionListener(this);
			add(closeButton,BorderLayout.SOUTH);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("Close"));
				dispose(); // ���� ��ư Ŭ���� HelpWindow ����
		}
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowClosed");
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO  ���α׷� ����� ���Ͽ� ���� �����Ѵ�.
		System.out.println("windowClosing");
		bookstore.writeBooks();
		System.exit(0);
		
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
