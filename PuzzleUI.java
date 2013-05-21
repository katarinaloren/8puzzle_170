import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class PuzzleUI implements ActionListener{
	public static JFrame jf;
	public static JPanel jp;
	public static JPanel jc;
	public static JButton[][] panels;
	public static Toolkit tool = Toolkit.getDefaultToolkit();
	public static Image one = tool.getImage("1.png");
	public static Image two = tool.getImage("2.png");
	public static Image three = tool.getImage("3.png");
	public static Image four = tool.getImage("4.png");
	public static Image five = tool.getImage("5.png");
	public static Image six = tool.getImage("6.png");
	public static Image seven = tool.getImage("7.png");
	public static Image eight = tool.getImage("8.png");
	public static int place=0;
	public static ArrayList<int [][]> arraystat;
	
	public PuzzleUI(){
	}
	
	public void Show(ArrayList<int[][]> Array){
	System.out.println("HERE GOES NOTHING!");
	arraystat=Array;
	int size=arraystat.size();

	
	int [][]arrays = new int[3][3];
	System.out.println(size);
	
	for(int i=0;i<size;i++){
		arrays=Array.get(i);
		
		
		for(int j=0;j<3;j++){
			for(int k=0;k<3;k++){
				System.out.print(arrays[j][k]);
			}
				System.out.println();
		}
				System.out.println();
	}
	
	jf = new JFrame("Lights Out Solver");
	jc = new JPanel();
	jp = new JPanel(new GridLayout(4,3));
	panels = new JButton[3][3];
	JButton solve =  new JButton("next");
	solve.addActionListener(this);
	
	
	arrays=Array.get(place);
	jp=AddPanel(arrays);
	
	jp.add(solve);
	jf.setPreferredSize(new Dimension(500, 800));
	jf.add(jp);
	jf.pack();
	jf.setVisible(true); 
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	
	}
	
	public JPanel AddPanel(int [][]arrays){
	System.out.println("hfasdks");
	for(int i=0; i<3;i++){
			for (int j=0; j<3;j++){
				panels[i][j] = new JButton();
				
				if(arrays[i][j]==0){
				panels[i][j].setBackground(Color.WHITE);
				panels[i][j].setIcon(new ImageIcon(one));
				jp.add(panels[i][j]);
				}
				
				if(arrays[i][j]==1){
				panels[i][j].setBackground(Color.WHITE);
				panels[i][j].setIcon(new ImageIcon(two));
				jp.add(panels[i][j]);
				}
				
				if(arrays[i][j]==2){
				panels[i][j].setBackground(Color.WHITE);
				panels[i][j].setIcon(new ImageIcon(three));
				jp.add(panels[i][j]);
				}
				
				if(arrays[i][j]==3){
				panels[i][j].setBackground(Color.WHITE);
				panels[i][j].setIcon(new ImageIcon(four));
				jp.add(panels[i][j]);
				}
				
				if(arrays[i][j]==4){
				panels[i][j].setBackground(Color.WHITE);
				panels[i][j].setIcon(new ImageIcon(five));
				jp.add(panels[i][j]);
				}
				
				if(arrays[i][j]==5){
				panels[i][j].setBackground(Color.WHITE);
				panels[i][j].setIcon(new ImageIcon(six));
				jp.add(panels[i][j]);
				}
				
				if(arrays[i][j]==6){
				panels[i][j].setBackground(Color.WHITE);
				panels[i][j].setIcon(new ImageIcon(seven));
				jp.add(panels[i][j]);
				}
				
				if(arrays[i][j]==7){
				panels[i][j].setBackground(Color.WHITE);
				panels[i][j].setIcon(new ImageIcon(eight));
				jp.add(panels[i][j]);
				}
				
							
				else{
				panels[i][j].setBackground(Color.BLACK);
				jp.add(panels[i][j]);
				}
			}
		}
		
		return jp;
	}
	
	public void actionPerformed(ActionEvent e) {
			int arrays[][] = new int[3][3];
			System.out.println("HELLO!");
			if(place < arraystat.size()){
			jp.removeAll(); 
			JButton solve =  new JButton("next");
			solve.addActionListener(this);
			place++;
			arrays=arraystat.get(place);
			jp=AddPanel(arrays);
			jf.setPreferredSize(new Dimension(500, 800));
			
			jp.add(solve);
			jf.add(jp);
			jf.pack();
			jf.setVisible(true); 
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
	}
	
	
}//end of UI