package application;

import java.net.URL;
import java.util.ResourceBundle;

import database.Base;
import database.Book;
import database.Borrow;
import database.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class readuiController implements Initializable {
	@FXML
	private AnchorPane pan;
	@FXML
	private TabPane tabmax;
	@FXML
	private Tab hotbook;
	@FXML
	private Pagination page1;
	@FXML
	private TableView<Book> bookview;
	@FXML
	private TableView<Book> hotbookview;
	@FXML
	private TableColumn<Book, String> book_id1;
	@FXML
	private TableColumn<Book, String> book_name1;
	@FXML
	private TableColumn<Book, String> author1;
	@FXML
	private TableColumn<Book, String> book_title1;
	@FXML
	private TableColumn<Book, String> press1;
	@FXML
	private TableColumn<Book, String> time1;
	@FXML
	private TableColumn<Book, Double> price1;
	@FXML
	private TableColumn<Book, String> local1;
	@FXML
	private Tab borsearch;
	@FXML
	private TextField searchtext;
	@FXML
	private Button search;
	@FXML
	private TableColumn<Book, String> book_id;
	@FXML
	private TableColumn<Book, String> book_name;
	@FXML
	private TableColumn<Book, String> author;
	@FXML
	private TableColumn<Book, String> book_title;
	@FXML
	private TableColumn<Book, String> press;
	@FXML
	private TableColumn<Book, String> outtime;
	@FXML
	private TableColumn<Book, Double> price;
	@FXML
	private TableColumn<Book, String> local;
	@FXML
	private Pagination page;
	@FXML
	private Tab personmasage;
	@FXML
	private Text student_id;
	@FXML
	private Text student_name;
	@FXML
	private Text student_sex;
	@FXML
    private Text student_sclass;
	@FXML
	private Text borrow;
	@FXML
	private Text count;
	@FXML
	private Text ticket;
	@FXML
	private TableColumn bor_book_id;
	@FXML
	private TableColumn bro_book_id;
	@FXML
	private TableColumn endTime;
	@FXML
	private TableColumn renew;
	@FXML
	private Button signOut;
	Base base;
	Main myapp;
	void setapp(Main myapp)
	{
		this.myapp=myapp;
		this.base=myapp.getbase();
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		book_id.setCellValueFactory(new PropertyValueFactory<Book, String>("id"));//如果没有指定列添加的具体内容，默认添加toSting的内容
		book_name.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
		author.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		book_title.setCellValueFactory(new PropertyValueFactory<Book, String>("brand"));
		press.setCellValueFactory(new PropertyValueFactory<Book, String>("press"));
		outtime.setCellValueFactory(new PropertyValueFactory<Book, String>("time"));
		price.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));
		local.setCellValueFactory(new PropertyValueFactory<Book, String>("local"));
		
		book_id1.setCellValueFactory(new PropertyValueFactory<Book, String>("id"));
		book_name1.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
		author1.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		book_title1.setCellValueFactory(new PropertyValueFactory<Book, String>("brand"));
		press1.setCellValueFactory(new PropertyValueFactory<Book, String>("press"));
		time1.setCellValueFactory(new PropertyValueFactory<Book, String>("time"));
		price1.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));
		local1.setCellValueFactory(new PropertyValueFactory<Book, String>("local"));
		setPersonMessage();
		SetAllBook();
		setBorrow();
		SetHotBook();
	}

	// Event Listener on Button[#search].onAction
	@FXML
	public void search(ActionEvent event) {
		ObservableList<Book> books=base.getalllinkesbook(searchtext.getText());	
		bookview.setItems(books);
	}
	public void SetAllBook() {
		ObservableList<Book> books=base.getallbook();
		bookview.setItems(books);
	}
	public void SetHotBook() {
		ObservableList<Book> books=base.gethotbook();
		hotbookview.setItems(books);
	}
	
	public void setPersonMessage() {
		Person person;
		person=base.getStudentMassage();
		student_id.setText(person.getId());
		student_name.setText(person.getName());
		student_sex.setText(person.getSex());
		student_sclass.setText(person.getSclass());
	}
	public void setBorrow() {
		Borrow borrow;
		borrow=base.getStudentBorrow();
		this.borrow.setText(String.valueOf(borrow.getBorrowAlready()));
		this.count.setText(String.valueOf(borrow.getBorrowUp()-borrow.getBorrowAlready()));
		this.ticket.setText(String.valueOf(borrow.getTicket()));
	}
	// Event Listener on Button[#signOut].onAction
	@FXML
	public void signOut(ActionEvent event) {
		// TODO Autogenerated
		myapp.homeui();
		base.closedata();
	}
	public void setbook() {
		
	}
}
