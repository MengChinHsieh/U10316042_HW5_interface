import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BeanGame extends JFrame{ 
  final static int NUMBER_OF_SLOTS = 10;
	final static int NUMBER_OF_ROWS = NUMBER_OF_SLOTS - 2;
	
	JLabel Test = new JLabel();//建立JLabel 
	private int shift = 0;
 	private int moveCount = 0;
  	private int position = 0;
 	
  	private BeanMachinePanel paintPanel = new BeanMachinePanel();
	
  	//Displaying the move message
  	private Timer timer = new Timer(100, new ActionListener(){
   	@Override
   	public void actionPerformed(ActionEvent e){
      		moveCount++;
      		}
    	}
  	);
  
  	public BeanGame(){
		  add(paintPanel);	
    	  	timer.start();
  	  }

  	class BeanMachinePanel extends JPanel{
    	final static int LENGHT_OF_1 =50;//彈珠檯的長度
    	final static int LENGHT_OF_2 =40;//彈珠檯的寬度
    	final static int RADIUS = 10;//球的半徑
    	final static int LENGTH_OF_SLOTS = 40;
    	final static int LENGTH_OF_OPENNING = 15;
    	final static int FIRST_NAIL = 1;
    	final static int RED_BALL_START = FIRST_NAIL - RADIUS;
    
   	@Override
    	protected void paintComponent(Graphics g){
      		super.paintComponent(g);

      		int y = FIRST_NAIL;
      		int xCenter = getWidth() / 2;

      
      	// Draw pegs in multiple lines
      	g.setColor(Color.ORANGE);
      	for (int i = 0; i < NUMBER_OF_ROWS; i++){
        	y += LENGHT_OF_2;
        	for (int k = 0; k <= i; k++){
          	g.fillOval(xCenter - i * LENGHT_OF_1 / 2 + k * LENGHT_OF_1 - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
        	}
      	}
      
      	// Draw vertical lines for slots
      	g.setColor(Color.BLACK);
      	y = y + RADIUS;
      	for (int i = 0; i < NUMBER_OF_SLOTS; i++){
        	int x = xCenter - (NUMBER_OF_ROWS - 1) * LENGHT_OF_1 / 2 + (i - 1) * LENGHT_OF_1;
        	g.drawLine(x, y, x, y + LENGTH_OF_SLOTS);
      	}
      
      	// Draw a horizontal line for bottom
      	g.drawLine(xCenter - (NUMBER_OF_ROWS - 1) * LENGHT_OF_1 / 2 - LENGHT_OF_1, y + LENGTH_OF_SLOTS, 
        	xCenter - (NUMBER_OF_ROWS - 1) * LENGHT_OF_1 / 2 + NUMBER_OF_ROWS * LENGHT_OF_1, y + LENGTH_OF_SLOTS);
      	// Draw two side lines
      	g.drawLine(xCenter +LENGHT_OF_1 / 2, FIRST_NAIL + RADIUS, xCenter - (NUMBER_OF_ROWS - 1) * LENGHT_OF_1 / 2 + NUMBER_OF_ROWS * LENGHT_OF_1, y);
      	g.drawLine(xCenter -LENGHT_OF_1 / 2, FIRST_NAIL + RADIUS, xCenter - (NUMBER_OF_ROWS - 1) * LENGHT_OF_1 / 2 - LENGHT_OF_1, y);
      	// Draw two vertical lines for the openning
      	g.drawLine(xCenter - LENGHT_OF_1 / 2, FIRST_NAIL + RADIUS, xCenter - LENGHT_OF_1 / 2,FIRST_NAIL - LENGTH_OF_OPENNING);
      	g.drawLine(xCenter + LENGHT_OF_1 / 2, FIRST_NAIL + RADIUS, xCenter + LENGHT_OF_1 / 2,FIRST_NAIL - LENGTH_OF_OPENNING);
      

    }
  }

  	public static void main(String[] args){
					
				
		JFrame frame = new BeanGame();
    		frame.setTitle("BeanGame");
   	 	frame.setSize(500, 500);
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setLocationRelativeTo(null);
    		frame.setVisible(true);
  	}
}
