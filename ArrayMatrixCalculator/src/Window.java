import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.omg.CORBA.SystemException;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;
public class Window extends JFrame{
	JToolBar toolBar;
	JButton b1, b2, b3, b4, b5, b6, b7, b8;
	JLabel l1, l2, l3;
	JTextArea t1, t2, t3;
	JPanel p1;
	int i, k;
	String a, b;
	eHandler handler = new eHandler();
	String arrString3 = "";
	public Window(String s){
		super(s);
		toolBar = new JToolBar("Basic functions");
		toolBar.setFloatable(false);
		add(toolBar, BorderLayout.PAGE_START);
		b1 = new JButton("Add single number");
		b5 = new JButton("Add an array/matrix");
		b2 = new JButton("Multiply with single number");
		b3 = new JButton("Multiply with matrix");
		b4 = new JButton("Load 1 matrix/array");
		b6 = new JButton("Load 2 matrix/array");
		b7 = new JButton("Save the result");
		b8 = new JButton("INFO");
		toolBar.add(b8);
		toolBar.add(b1);
		toolBar.add(b5);
		toolBar.add(b2);
		toolBar.add(b3);
		toolBar.add(b4);
		toolBar.add(b6);
		toolBar.add(b7);
		p1 = new JPanel();
		p1.setLayout(new GridLayout(6, 0, 0, 0)); // Grid Layout
		l1 = new JLabel("Operand 1");
		t1 = new JTextArea();
		l2 = new JLabel("Operand 2");
		t2 = new JTextArea();
		l3 = new JLabel("Result");
		t3 = new JTextArea();
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		add(p1);
		b1.addActionListener(handler);
		b2.addActionListener(handler);
		b5.addActionListener(handler);
		b3.addActionListener(handler);
		b4.addActionListener(handler);
		b6.addActionListener(handler);
		b7.addActionListener(handler);
		b8.addActionListener(handler);
	}
	public class eHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == b1) {
				String arrString = t1.getText(); 	
				String arrString2 = t2.getText(); 	
				boolean size = true;
				try {	
					String[] strOne = arrString.split("\n");
					String[][] strTwo = new String[ strOne.length ][];
					int num = Integer.parseInt(arrString2);
					for( int i = 0; i < strTwo.length; i++ )
					{
						strTwo[i] = strOne[i].split("\t");
					}			
					for(int i=0; i<strTwo.length; i++)
					{
						if(strTwo[0].length!=strTwo[i].length)
							size = false;
					}
					Matrix arr = new Matrix(strTwo.length, strTwo[0].length);
					arr.loadStr(strTwo);
					if(size)
					{
						String res = arr.addNum(num);
						t3.setText(res);
					}
					else
					{
						t3.setText("Error");
						JOptionPane.showMessageDialog(null, "Something went Wrong. Check your data!\nHint: you can use only Tab/Enter to separate columns/rows", "Error message", JOptionPane.OK_CANCEL_OPTION);
					}
				}catch(Exception er)
				{
					t3.setText("Error");
					JOptionPane.showMessageDialog(null, "Something went Wrong. Check your data!\nHint: you can use only Tab/Enter to separate columns/rows", "Error message", JOptionPane.OK_CANCEL_OPTION);
				}
			}
			if(e.getSource() == b2) {
				String arrString = t1.getText(); 	
				String arrString2 = t2.getText(); 	
				boolean size = true;
				try {	
					String[] strOne = arrString.split("\n");
					String[][] strTwo = new String[ strOne.length ][];
					int num = Integer.parseInt(arrString2);
					for( int i = 0; i < strTwo.length; i++ )
					{
						strTwo[i] = strOne[i].split("\t");
					}
					for(int i=0; i<strTwo.length; i++)
					{
						if(strTwo[0].length!=strTwo[i].length)
							size = false;
					}
					Matrix arr = new Matrix(strTwo.length, strTwo[0].length);
					arr.loadStr(strTwo);				
					if(size)
					{
						String res = arr.mulNum(num);
						t3.setText(res);
					}
					else
					{
						t3.setText("Error");
						JOptionPane.showMessageDialog(null, "Something went Wrong. Check your data!\nHint: you can use only Tab/Enter to separate columns/rows", "Error message", JOptionPane.OK_CANCEL_OPTION);
					}
				}catch(Exception er)
				{
					t3.setText("Error");
					JOptionPane.showMessageDialog(null, "Something went Wrong. Check your data!\nHint: you can use only Tab/Enter to separate columns/rows", "Error message", JOptionPane.OK_CANCEL_OPTION);
				}
			}
			if(e.getSource() == b5) {
				String arrString = t1.getText(); 	
				String arrString2 = t2.getText(); 	
				boolean size = true;
				try {	
					String[] strOne = arrString.split("\n");
					String[][] strTwo = new String[ strOne.length ][];
					String[] strOne2 = arrString2.split("\n");
					String[][] strTwo2 = new String[ strOne2.length ][];
					for( int i = 0; i < strTwo.length; i++ )
					{
						strTwo[i] = strOne[i].split("\t");
					}
					for( int i = 0; i < strTwo2.length; i++ )
					{
						strTwo2[i] = strOne2[i].split("\t");
					}
					Matrix ar1 = new Matrix(strTwo.length, strTwo[0].length);
					Matrix ar2 = new Matrix(strTwo2.length, strTwo2[0].length);
					ar1.loadStr(strTwo);
					ar2.loadStr(strTwo2);
					for(int i=0; i<strTwo.length; i++)
					{
						if(strTwo[0].length!=strTwo[i].length)
							size = false;
						if(strTwo[0].length!=strTwo2[i].length)
							size = false;
					}
					for(int i=0; i<strTwo2.length; i++)
					{
						if(strTwo2[0].length!=strTwo2[i].length)
							size = false;
						if(strTwo2[0].length!=strTwo[i].length)
							size = false;
					}				
					if(size)
					{
						String res = ar1.addArray(ar2);
						t3.setText(res);
					}
					else
					{
						t3.setText("Error");
						JOptionPane.showMessageDialog(null, "Something went Wrong. Check your data!\nHint: you can use only Tab/Enter to separate columns/rows", "Error message", JOptionPane.OK_CANCEL_OPTION);
					}
				}catch(Exception er)
				{
					t3.setText("Error");
					System.out.print(er);
					JOptionPane.showMessageDialog(null, "Something went Wrong. Check your data!\nHint: you can use only Tab/Enter to separate columns/rows", "Error message", JOptionPane.OK_CANCEL_OPTION);
				}
			}
			if(e.getSource() == b3) {
				String arrString = t1.getText(); 	
				String arrString2 = t2.getText(); 	
				boolean size = true;
				try {	
					String[] strOne = arrString.split("\n");
					String[][] strTwo = new String[ strOne.length ][];
					String[] strOne2 = arrString2.split("\n");
					String[][] strTwo2 = new String[ strOne2.length ][];
					for( int i = 0; i < strTwo.length; i++ )
					{
						strTwo[i] = strOne[i].split("\t");
					}
					for( int i = 0; i < strTwo2.length; i++ )
					{
						strTwo2[i] = strOne2[i].split("\t");
					}
					Matrix a1 = new Matrix(strOne.length, strTwo[0].length);
					Matrix a2 = new Matrix(strOne2.length, strTwo2[0].length);
					Matrix res = new Matrix(strTwo.length, strTwo2[0].length);
					a1.loadStr(strTwo);
					a2.loadStr(strTwo2);
					if(size)
					{
						res.mulArray(a1, a2);
						t3.setText(res.toString());	
					}	
					else
					{
						t3.setText("Error");
						JOptionPane.showMessageDialog(null, "1Something went Wrong. Check your data!\nHint: you can use only Tab/Enter to separate columns/rows", "Error message", JOptionPane.OK_CANCEL_OPTION);
					}
				}catch(Exception er)
				{
					t3.setText("Error");
					System.out.println(er);
					JOptionPane.showMessageDialog(null, "Something went Wrong. Check your data!\nHint: you can use only Tab/Enter to separate columns/rows", "Error message", JOptionPane.OK_CANCEL_OPTION);
				}
			}
			if(e.getSource() == b4) {
				try {
					BufferedReader br = null;
					String line;
					String text1 = "";
					File dir = new File("C:\\Users\\Asus\\Desktop\\matrix");
					if(!dir.exists())
					{
						dir.mkdir();
					}
					JFileChooser fileChooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        "TXT files only", "txt");
					fileChooser.setCurrentDirectory(new File("C:\\Users\\Asus\\Desktop\\matrix"));
					fileChooser.setFileFilter(filter);
					int i = fileChooser.showOpenDialog(toolBar);
					File file = fileChooser.getSelectedFile();
					try {
						br = new BufferedReader(new FileReader(file));
						while((line = br.readLine()) != null) {
							text1 += line + "\n";
							t1.setText(text1);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Error", "Error message", JOptionPane.OK_CANCEL_OPTION);
					}finally {
						try {
							br.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}	
				catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Error", "Error message", JOptionPane.OK_CANCEL_OPTION);
				}
			}
			if(e.getSource() == b6) {
				try {
					BufferedReader br = null;
					String line;
					String text1 = "";
					File dir = new File("C:\\Users\\Asus\\Desktop\\matrix");
					if(!dir.exists())
					{
						dir.mkdir();
					}
					JFileChooser fileChooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        "TXT files only", "txt");
					fileChooser.setCurrentDirectory(new File("C:\\Users\\Asus\\Desktop\\matrix"));
					fileChooser.setFileFilter(filter);
					fileChooser.showOpenDialog(toolBar);
					File file = fileChooser.getSelectedFile();
					try {
						br = new BufferedReader(new FileReader(file));
						while((line = br.readLine()) != null) {
							text1 += line + "\n";
							t2.setText(text1);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Error", "Error message", JOptionPane.OK_CANCEL_OPTION);
					}finally {
						try {
							br.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}	
				catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Error", "Error message", JOptionPane.OK_CANCEL_OPTION);
				}
			}
			if(e.getSource() == b7) {
				try {
					File dir = new File("C:\\Users\\Asus\\Desktop\\matrix");
					if(!dir.exists())
					{
						dir.mkdir();
					}
					JFileChooser fileChooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        "TXT files only", "txt");
					fileChooser.setCurrentDirectory(new File("C:\\Users\\Asus\\Desktop\\matrix"));
					fileChooser.setFileFilter(filter);
					fileChooser.showSaveDialog(toolBar);
					try ( FileWriter fw = new FileWriter(fileChooser.getSelectedFile()) ) {
		                fw.write(arrString3);
		            }
		            catch ( IOException er2 ) {
		                System.out.println("Error");
		            }
				}	
				catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Error", "Error message", JOptionPane.OK_CANCEL_OPTION);
				}	
			}
			if(e.getSource() == b8) {
				JOptionPane.showMessageDialog(null, "How to use:\n1. To separate columns use Tab\n2. To separate rows use Enter\n3. You can save the result by clicking 'Save the result'\n4. You can load array/matrix from .txt file by clicking 'Load 1/2 array/matrix'.\nIMPORTANT: The text in the file must be also separated by Tab and Enter!", "INFO", JOptionPane.OK_CANCEL_OPTION);
			}
		}
	}
}
