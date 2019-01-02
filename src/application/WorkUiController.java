package application;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import org.omg.CORBA.PUBLIC_MEMBER;

import database.Base;
import database.Book;
import database.Borrow;
import database.Locallist;
import database.Person;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import oracle.jrockit.jfr.tools.ConCatRepository;
import others.NeedMethod;
/**
 * 
 * @author 赖志卿
 *2019年1月2日下午12:04:18
 */
public class WorkUiController implements Initializable {

    private static final Class<WorkUiController> ObservableList = null;

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text rdname;

    @FXML
    private ComboBox<?> bf_local;

    @FXML
    private Text rdsex;

    @FXML
    private Text bdauthor;

    @FXML
    private TextField badd_id;
    
    @FXML
    private TextField badd_price;

    @FXML
    private Text bdlocal;

    @FXML
    private Button bfsearch;

    @FXML
    private TextField searchbooktext;

    @FXML
    private TextField rf_sex;

    @FXML
    private Button signout;

    @FXML
    private TextField borread_id;

    @FXML
    private Button research;

    @FXML
    private Text bdtype;

    @FXML
    private Text borread_name;

    @FXML
    private Text bd_time;

    @FXML
    private Button ra_bt;

    @FXML
    private Text re_type;

    @FXML
    private ComboBox<Locallist> badd_local;

    @FXML
    private TextField bdsearchtext;

    @FXML
    private Text re_sex;

    @FXML
    private Text borread_type;

    @FXML
    private TextField rdsearchtext;

    @FXML
    private Button bf_clear;

    @FXML
    private Text bdname;

    @FXML
    private TextField borbook_id;

    @FXML
    private Button rfsearch;

    @FXML
    private TextField ra_class;

    @FXML
    private Text rdtype;

    @FXML
    private Text borread_sex;

    @FXML
    private Text borread_time;

    @FXML
    private Text re_ticket;

    @FXML
    private Text borbook_time;

    @FXML
    private Text re_class;

    @FXML
    private TextField rf_name;

    @FXML
    private ComboBox<Locallist> ra_type;

    @FXML
    private Button bf_change;

    @FXML
    private Button searchbook;

    @FXML
    private Button ba_bt;

    @FXML
    private Button rf_clear;

    @FXML
    private TextField add_name1;

    @FXML
    private TextField researchtext;

    @FXML
    private TableColumn<?, ?> bro_book_id;

    @FXML
    private Button rddelete;

    @FXML
    private Button rf_bt;

    @FXML
    private TextField badd_name;

    @FXML
    private TextField bfsearchtext;

    @FXML
    private Button rf_password;

    @FXML
    private Text rdclass;

    @FXML
    private Text re_name;

    @FXML
    private ComboBox<Locallist> ra_sex;

    @FXML
    private Text borbook_press;

    @FXML
    private Text re_count;

    @FXML
    private TextField ra_id;

    @FXML
    private TextField rf_type;

    @FXML
    private TextField bf_author;

    @FXML
    private Text bdprice;

    @FXML
    private TextField ra_name;

    @FXML
    private TextField bf_press;

    @FXML
    private TextField bf_id;
    
    @FXML
    private TextField bf_name;

    @FXML
    private TextField bf_price;

    @FXML
    private TextField badd_author;

    @FXML
    private Text bdpress;
    @FXML
    private TextField rf_class;

    @FXML
    private TextField badd_press;

    @FXML
    private Text borbook_name;

    @FXML
    private TextField rf_id;

    @FXML
    private TextField badd_type;

    @FXML
    private Text bdID;

    @FXML
    private Button rdsearch;

    @FXML
    private Button bdsearch;

    @FXML
    private TextField bf_type;

    @FXML
    private Text rdid;

    @FXML
    private Button ra_clear;

    @FXML
    private TextField rfsearchtext;

    @FXML
    private TableColumn<?, ?> endTime;

    @FXML
    private TableColumn<?, ?> renew;

    @FXML
    private Button ba_clear;

    @FXML
    private Button bd_bt;

    @FXML
    private Text borbook_keep;

    @FXML
    private Text re_bor;

    @FXML
    private TableColumn<?, ?> bor_book_id;
    @FXML
    private DatePicker batime;
    @FXML
    private DatePicker bftime;
    
	@FXML
	private TableView<Book> bookview;
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
	private TableColumn<Book, String> time;
	@FXML
	private TableColumn<Book, Double> price;
	@FXML
	private TableColumn<Book, String> local;

    @FXML
    void signOut(ActionEvent event) {
    	myapp.homeui();
		base.closedata();
    }
    @FXML
    void research_event(ActionEvent event) {
    	//读者还书button事件
    	Person person= base.getReaderMassage(researchtext.getText());
    	re_type.setText(person.getType());
    	re_name.setText(person.getName());
    	re_sex.setText(person.getSex());
    	re_class.setText(person.getSclass());
    	Borrow borrow=base.getStudentBorrow(researchtext.getText());
    	re_bor.setText(String.valueOf(borrow.getBorrowAlready()));
    	re_count.setText(String.valueOf(borrow.getBorrowUp()-borrow.getBorrowAlready()));
    	re_ticket.setText(String.valueOf(borrow.getTicket()));
    }
	Base base;
	Main myapp;
	void setapp(Main myapp)
	{
		this.myapp=myapp;
		this.base=myapp.getbase();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setLocalList();
		borrowbook();
		borrowreader();
		GetAllBook();
	
	}
	public void setLocalList() {
		ObservableList<Locallist> list=FXCollections.observableArrayList();//收集所有列，图书藏馆列		
		list.add(0,new Locallist("麦庐"));//向list添加列
		list.add(1,new Locallist("蛟桥"));//向list添加列
		list.add(2,new Locallist("麦庐蛟桥"));//向list添加列
		badd_local.setItems(list);//把所有收集的列添加显示到列表
		badd_local.getSelectionModel().select(0);
		
		ObservableList<Locallist> sex=FXCollections.observableArrayList();//性别列添加
		sex.add(0,new Locallist("男"));
		sex.add(1,new Locallist("女"));
		ra_sex.setItems(sex);
		
		ObservableList<Locallist> type=FXCollections.observableArrayList();
		type.add(0,new Locallist("学生"));
		type.add(1,new Locallist("教师"));
		ra_type.setItems(type);
	}
	
	public void borrowbook() {//搜索图书实时监听
		borbook_id.textProperty().addListener(new ChangeListener<String>() {//给borbook_id添加文本监听
			@Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				Date date=new Date();
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				Book book;
				book=base.getbook(borbook_id.getText());
				borbook_name.setText(book.getName());
				borbook_press.setText(book.getPress());
				borbook_time.setText(book.getTime());
				borbook_keep.setText(format.format(date));
            }
		});
	}
	
	public void borrowreader() {
		borread_id.textProperty().addListener(new ChangeListener<String>() {//给borbook_id添加文本监听
			@Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				Person person;
				person=base.getReaderMassage(borread_id.getText());
				Date newTime=new Date();
				Calendar calendar=Calendar.getInstance();
				calendar.setTime(newTime);
				calendar.add(calendar.MONTH, 1);
				newTime=calendar.getTime();
				SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
				borread_name.setText(person.getName());
				borread_type.setText(person.getType());
				borread_sex.setText(person.getSex());
				borread_time.setText(date.format(newTime));
            }
		});
	}
	
	@FXML
    void addbook(ActionEvent event) {
		NeedMethod method=new NeedMethod();
    	if(badd_author.getText().length()==0||badd_id.getText().length()==0||badd_name.getText().equals("")
    			||badd_press.getText().equals("")||badd_type.getText().equals("")||badd_price.getText().equals("")
    			||batime.getValue().toString().equals("")||badd_local.getValue()==null)
    		JOptionPane.showMessageDialog(null, "数据不完整","警告",JOptionPane.WARNING_MESSAGE);
    	else if (!method.isNum(badd_price.getText())) {
			JOptionPane.showMessageDialog(null, "价格为非数字类型","警告",JOptionPane.WARNING_MESSAGE);
    	}
    	else
    		base.addbook(addbook());

    }
	public Book addbook()
	{
		Book book=new Book();
		book.setAuthor(badd_author.getText());
		book.setBrand(badd_type.getText());
		book.setId(badd_id.getText());
		book.setName(badd_name.getText());
		book.setPress(badd_press.getText());
		book.setTime(batime.getValue().toString());
		book.setLocal(badd_local.getValue().toString());
		book.setPrice(Double.parseDouble(badd_price.getText()));
		return book;
	}
	  @FXML
	    void addread(ActionEvent event) {
		  if (ra_id.getText().equals("")||ra_name.getText().equals("")||ra_sex.getValue()==null||
				  ra_type.getValue()==null||ra_class.getText().equals("")) {
			  JOptionPane.showMessageDialog(null, "数据不完整","警告",JOptionPane.WARNING_MESSAGE);
		}
		  else {
			base.addread(addread());
		}
	    }
	  public Person addread() {
		Person person=new Person();
		person.setId(ra_id.getText());
		person.setName(ra_name.getText());
		person.setSex(ra_sex.getValue().toString());
		person.setType(ra_type.getValue().toString());
		person.setSclass(ra_class.getText());
		return person;
	}
	public void GetAllBook() {
		book_id.setCellValueFactory(new PropertyValueFactory<Book, String>("id"));//如果没有指定列添加的具体内容，默认添加toSting的内容
		book_name.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
		author.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		book_title.setCellValueFactory(new PropertyValueFactory<Book, String>("brand"));
		press.setCellValueFactory(new PropertyValueFactory<Book, String>("press"));
		time.setCellValueFactory(new PropertyValueFactory<Book, String>("time"));
		price.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));
		local.setCellValueFactory(new PropertyValueFactory<Book, String>("local"));
		ObservableList<Book> books=base.getallbook();
		bookview.setItems(books);
	}
	@FXML
	public void search(ActionEvent event) {
		ObservableList<Book> books=base.getalllinkesbook(searchbooktext.getText());	
		bookview.setItems(books);
	}
}
