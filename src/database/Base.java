package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
	String id;
	private static Connection con;
	public boolean logindata(String id,String password,int flag){		
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;DatabaseName=library";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"sa","lzq6z18");
			Statement statement1=con.createStatement();
			Statement statement2=con.createStatement();
			String jid="select reader_id from reader where reader_id='"+id+"'";
			String jpassword="select reader_password from reader where reader_password='"+password+"'";
			if(flag==0)
			{
				jid="select work_id from work where work_id='"+id+"'";
				jpassword="select work_password from work where work_password='"+password+"'";
			}
			ResultSet dateid=statement1.executeQuery(jid);
			ResultSet datepassword=statement2.executeQuery(jpassword);
			if(dateid.next()&&datepassword.next())
				{this.id=id;
				return true;}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	public void closedata() {
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Book getbook(String id) {
		Book book=null;
		try {
			String sql="select * from book where id='"+id+"'";
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			book=new Book();
			while (result.next()) {
				book.setId(result.getString("id"));
				book.setName(result.getString("name"));
				book.setAuthor(result.getString("author"));
				book.setBrand(result.getString("brand"));
				book.setPress(result.getString("press"));
				book.setTime(result.getDate("outtime").toString());
				book.setPrice(result.getFloat("price"));
				book.setLocal(result.getString("local"));				
			}
			return book;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("查询获取图书失败");
		}
		return book;
	}
	public Person getStudentMassage() {
		Person person=new Person();
		try {
			String sql="select * from reader_detail where read_id='"+id+"'";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				person.setId(result.getString("read_id"));
				person.setName(result.getString("name"));
				person.setSex(result.getString("sex"));
				person.setSclass(result.getString("sclass"));
				person.setType(result.getString("type"));
			}
			return person;
		} catch (Exception e) {
			return person;
			// TODO: handle exception
		}
	}
	public Person getReaderMassage(String id) {
		Person person=new Person();
		try {
			String sql="select * from reader_detail where read_id='"+id+"'";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				person.setId(result.getString("read_id"));
				person.setName(result.getString("name"));
				person.setSex(result.getString("sex"));
				person.setSclass(result.getString("sclass"));
				person.setType(result.getString("type"));
			}
			return person;
		} catch (Exception e) {
			return person;
			// TODO: handle exception
		}
	}
	public Borrow getStudentBorrow() {
		 Borrow borrow=new Borrow();
		try {
			String sql="select * from borrow where id='"+id+"'";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				borrow.setBorrowAlready(result.getInt("borrowAlready"));
				borrow.setBorrowUp(result.getInt("borrowUp"));
				borrow.setId(result.getString("id"));
				borrow.setTicket(result.getFloat("ticket"));
			}
			return borrow;
		} catch (Exception e) {
			return borrow;
			// TODO: handle exception
		}
	}
	public Borrow getStudentBorrow(String id) {
		 Borrow borrow=new Borrow();
		try {
			String sql="select * from borrow where id='"+id+"'";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				borrow.setBorrowAlready(result.getInt("borrowAlready"));
				borrow.setBorrowUp(result.getInt("borrowUp"));
				borrow.setId(result.getString("id"));
				borrow.setTicket(result.getFloat("ticket"));
			}
			return borrow;
		} catch (Exception e) {
			return borrow;
			// TODO: handle exception
		}
	}
	public ObservableList<Book> getalllinkesbook(String bookName) {
		final ObservableList<Book> books=FXCollections.observableArrayList();//创建一个收集所有列的容器
		Book book;
		try {
			String sql=" select * from book where id like '%"+bookName+"%' "
					+ "or author like '%"+bookName+"%'"
					+ "or press like '%"+bookName+"%'"
					+ " or brand like '%"+bookName+"%'"
					+ "or name like '%"+bookName+"%'";
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(sql);						
			while (result.next()) {
				book=new Book();
				book.setId(result.getString("id"));
				book.setName(result.getString("name"));
				book.setAuthor(result.getString("author"));
				book.setBrand(result.getString("brand"));
				book.setPress(result.getString("press"));
				book.setTime(result.getDate("outtime").toString());
				book.setPrice(result.getDouble("price"));
				book.setLocal(result.getString("local"));
				books.add(book);//向收集容器中添加列
			}			
			return books;//返回收集容器
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取图书出错");
		}
		return books;
	}
	public ObservableList<Book> getallbook() {
		final ObservableList<Book> books=FXCollections.observableArrayList();
		Book book;
		try {
			String sql=" select * from book";
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(sql);						
			while (result.next()) {
				book=new Book();
				book.setId(result.getString("id"));
				book.setName(result.getString("name"));
				book.setAuthor(result.getString("author"));
				book.setBrand(result.getString("brand"));
				book.setPress(result.getString("press"));
				book.setTime(result.getDate("outtime").toString());
				book.setPrice(result.getDouble("price"));
				book.setLocal(result.getString("local"));
				books.add(book);
			}			
			return books;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取全部图书出错");
		}
		return books;
	}
	public ObservableList<Book> gethotbook() {
		final ObservableList<Book> books=FXCollections.observableArrayList();
		Book book;
		try {
			String sql=" select * from book order by freuency desc";
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(sql);						
			while (result.next()) {
				book=new Book();
				book.setId(result.getString("id"));
				book.setName(result.getString("name"));
				book.setAuthor(result.getString("author"));
				book.setBrand(result.getString("brand"));
				book.setPress(result.getString("press"));
				book.setTime(result.getDate("outtime").toString());
				book.setPrice(result.getDouble("price"));
				book.setLocal(result.getString("local"));
				books.add(book);
			}			
			return books;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取全部图书出错");
		}
		return books;
	}
	
	public void addbook(Book book) {
		try {
			String sql="insert into book values('"+book.getId()+"','"+book.getName()+"',"
					+ "'"+book.getAuthor()+"','"+book.getBrand()+"','"+book.getPress()+"',"
							+ "'"+book.getTime()+"',"+book.getPrice()+",'"+book.getLocal()+"',"+book.getFreuency()+")";
			Statement stmt=con.createStatement();
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			if(e.getMessage().equals("违反了 PRIMARY KEY 约束 'PK__book__3213E83F0EA330E9'。不能在对象 'dbo.book' 中插入重复键。"))
				JOptionPane.showMessageDialog(null, "已存在该图书,添加失败");
			else
				JOptionPane.showMessageDialog(null, "添加失败");
			System.out.println("添加图书失败");
		}
	}
	
	public void addread(Person person) {
		try {
			String sql="insert into reader_detail values('"+person.getId()+"','"+person.getName()+"','"+person.getSex()+"',"
					+ "'"+person.getSclass()+"','"+person.getType()+"')";
			Statement stmt=con.createStatement();
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			if(e.getMessage().equals("违反了 PRIMARY KEY 约束 'PK__reader_d__EE06FA1B07020F21'。不能在对象 'reader_detail' 中插入重复键。"))
				JOptionPane.showMessageDialog(null, "已存在该读者,添加失败");
			else
				JOptionPane.showMessageDialog(null, "添加失败");
		}
	}

}
