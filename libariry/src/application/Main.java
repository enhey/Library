package application;

import java.io.IOException;

import com.sun.imageio.plugins.common.ImageUtil;

import database.Base;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
/**
 * 
 * @author 赖志卿
 *2018年10月11日下午6:00:20
 */
public class Main extends Application {
	private Stage mainstage;
	Base base;
	@Override	
	public void start(Stage primaryStage) throws Exception {
			mainstage=primaryStage;
			mainstage.setResizable(false);//窗口大小可变			
			mainstage.getIcons().add(new Image("/images/juflogo.jpg"));
			mainstage.setTitle("江西财经大学图书馆管理系统");			
			mainstage.setWidth(1200);
			mainstage.setHeight(800);
			homeui();			
			primaryStage.show();			

}
	public void homeui() {
		try {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("lib.fxml"));
		Parent root=loader.load();
		libController controller=loader.getController();
		controller.setapp(this);
		Scene scene=new Scene(root,1200,800);						
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		mainstage.setScene(scene);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void toworkui(Base base)
	{
		try {			
			this.base=base;
			WorkUiController controller = new WorkUiController();
			FXMLLoader loader=new FXMLLoader(getClass().getResource("workui.fxml"));
			loader.setController(controller);
			controller.setapp(this);
			Parent root=loader.load();
			Scene scene=new Scene(root,1200,800);			
			mainstage.setScene(scene);
			mainstage.show();	
		} catch (IOException e) {
			System.out.println("add work ui is wrong");
			// TODO: handle exception
		}
		
	}
	
	public void toreadui(Base base) {		
		try {
			this.base=base;
			readuiController controller = new readuiController();
			FXMLLoader loader=new FXMLLoader(getClass().getResource("readui.fxml"));
			loader.setController(controller);
			//readuiController controller=loader.getController();
			//FXMLLoader loader = new FXMLLoader();
			//loader.setLocation(getClass().getResource("readui.fxml"));
			controller.setapp(this);
			Parent root=loader.load();
			
			
			Scene scene=new Scene(root,1200,800);			
			mainstage.setScene(scene);
			mainstage.show();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Base getbase() {
		return base;
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
