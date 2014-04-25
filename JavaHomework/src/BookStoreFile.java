import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class BookStoreFile {

	private String filename="d:\\test.txt";
	public void Test()
	{
		// sample test
		try {
			Book b=new Book();
			b.setBookid("20140425-01");
			b.setAuthor("author");
			b.setTitle("title");
			b.setISBN("ISBN");
			b.setPubCompany("pubCompany");
			b.setPublishDate("publishDate");
			b.setStatus("status");
			
			FileOutputStream fileOut=new FileOutputStream(filename);
			ObjectOutputStream out=new ObjectOutputStream(fileOut);
			out.writeObject(b);
			out.close();
			fileOut.close();
			System.out.println("Serialized data");
			
			FileInputStream fileIn=new FileInputStream(filename);
			ObjectInputStream in=new ObjectInputStream(fileIn);
			Book rbook=(Book)in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Desieialized data");
			System.out.println(rbook.getBook());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		BookStoreFile file=new BookStoreFile();
		file.Test();
	}
}
