import javax.swing.JFrame;
import java.lang.*;

public class CalculatorApp {

	public static void main(String[] args) {
		Window f = new Window("Array Matrix Calculator"); 
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(920, 650);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		
	}

}
