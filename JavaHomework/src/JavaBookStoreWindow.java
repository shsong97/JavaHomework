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
 * 도서/DVD 대여 시스템 Client 버전
 * 신규 도서 입고시 도서 정보를 등록하고 수정 및 삭제가 가능하다.
 * 대여점에서 고객이 대여요청을 하면 도서ID를 입력하여 대여를한다.
 * 반납시에도 도서ID로 조회해서 반납신청을 한다.
 * 입력 방법은 text field에 직접 입력하거나 바코드로 읽어서 입력한다.
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
	 * BookStore control을 다른 화면에 넘겨주기 위한 함수
	 * @return BookStore 참조변수
	 */
	public BookStore getStore()
	{
		return bookstore;
	}
	/**
	 * 1.화면크기와 위치를 정하고 종료 버튼을 생성한다.<br>
	 * 2.메뉴를 생성한다.<br>
	 */
	public JavaBookStoreWindow()
	{
		// TODO 화면을 그린다.
		super("온라인 도서 대여점");
		
		// 화면 UI를 시스템에 맞게 수정
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 화면 크기 설정
        setSize(1000, 600);
        setLocation(300,100);
        setResizable(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        // 메뉴 생성
        createMenu();
        
        // 패널 생성
        createPanel();
        
        // 화면 보여줌
        setVisible(true);
        
        // 파일에 정보가 있으면 읽어온다.
        bookstore.readBooks();
	}
	private void createPanel()
	{
		main=new JPanel();
		JLabel mainText=new JLabel("Main Title 입니다.");
		main.add(mainText);
		add(main);
	}
	private void createMenu()
	{
		// 메뉴 생성
        menuBar = new JMenuBar();
        Font font=new Font("굴림", Font.BOLD, 15);
        //도서등록 메뉴
        menu = new JMenu("도서");
        menu.setFont(font);
        menuBar.add(menu);

        menuItem = new JMenuItem("도서등록");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // 이벤트 등록
        menu.add(menuItem);

        menuItem = new JMenuItem("도서수정");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // 이벤트 등록
        menu.add(menuItem);

        menuItem = new JMenuItem("도서삭제");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // 이벤트 등록
        menu.add(menuItem);

        //menu.addSeparator();
        

        //대여
        menu = new JMenu("대여");
        menu.setFont(font);
        menuBar.add(menu);
        
        menuItem = new JMenuItem("도서조회");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // 이벤트 등록
        menu.add(menuItem);

        menuItem = new JMenuItem("도서대여");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // 이벤트 등록
        menu.add(menuItem);
        
        menuItem = new JMenuItem("도서반납");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // 이벤트 등록
        menu.add(menuItem);
        
        //도움말
        menu = new JMenu("도움말");
        menu.setFont(font);
        menuBar.add(menu);
        
        menuItem = new JMenuItem("대여점 사용방법");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // 이벤트 등록
        menu.add(menuItem);
        
        menuItem = new JMenuItem("종료");
        menuItem.setFont(font);
        menuItem.addActionListener(this); // 이벤트 등록
        menu.add(menuItem);
        
        setJMenuBar(menuBar);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO 메뉴의 상태 변경시 처리한다. 예. 라디오, 체크 메뉴 
		//String command="";
	}

	/**
	 * 메뉴를 선택시 수행한다.<br>
	 * 메뉴 :<br>
	 * 도서등록, 도서수정, 도서삭제,<br>
	 * 도서조회, 도서대여, 도서반납, <br>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 도서 등록 화면을 참고하여 하기의 메뉴를 완성하세요.
		String command=e.getActionCommand();
		if(command.equals("도서등록"))
		{
			this.remove(main);
			main=new AddBookWindow(bookstore);
			add(main);
			this.validate();
		}
		else if(command.equals("도서수정"))
		{
			this.remove(main);
			main=new UpdateBookWindow(bookstore);
			add(main);
			this.validate();
		}
		else if(command.equals("도서삭제"))
		{
			// 과제.
		}
		else if(command.equals("도서조회"))
		{
			// 과제.
			this.remove(main);
			main=new ListBookWindow(bookstore);
			add(main);
			this.validate();
		}
		else if(command.equals("도서대여"))
		{
			// 과제.
		}
		else if(command.equals("도서반납"))
		{
			// 과제.
		}
		else if(command.equals("대여점 사용방법"))
		{
			HelpWindow j=new HelpWindow(command);
			j.setSize(400,300);
			j.setVisible(true);
		}
		else if(command.equals("종료"))
		{
			// 프로그램 종료시 파일에 쓰고 종료한다.
			bookstore.writeBooks();
			System.exit(0);
		}
	}
	
	/**
	 * 도움말 창
	 * @author songsh
	 *
	 */
	class HelpWindow extends JDialog implements ActionListener
	{
		/**
		 * dialog 에서 생성된 고유 아이디값
		 */
		private static final long serialVersionUID = 3102569911259150777L;
		HelpWindow(String title)
		{
			this.setTitle(title);
			createWindow();
		}
		private void createWindow()
		{
			String message="자바 온라인 대여점은 도서를 등록, 수정, 삭제하는 기능과 등록된 도서를 대여/반납하는 시스템입니다.";
						
			setLayout(new BorderLayout());
			JTextArea title=new JTextArea();
			title.setText(message); // 글자 입력
			title.setLineWrap(true); // 글자를 창에 맞게 다음줄로 보여준다.
			JScrollPane scroll=new JScrollPane(); // 스크롤 창
			scroll.getViewport().add(title); // 스크롤창에 TextArea 추가
			add(scroll,BorderLayout.CENTER);
			JButton closeButton=new JButton("Close");
			closeButton.addActionListener(this);
			add(closeButton,BorderLayout.SOUTH);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("Close"));
				dispose(); // 종료 버튼 클릭시 HelpWindow 종료
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
		// TODO  프로그램 종료시 파일에 쓰고 종료한다.
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
