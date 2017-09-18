package GUI;

import javax.swing.*;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color.*;





public class MainFrame extends JFrame{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    
    private Stage stage;
    private Scene scene;
    
    private JLabel generations;
    private JTextField generationsTF;
    private JTextField[][] table;
    private JButton calculateB, exitB;
    private JPanel[] menu;
    
    //Button handlers:
    private CalculateButtonHandler cbHandler;
    private ExitButtonHandler ebHandler;


    
    public MainFrame()
    {

        generations = new JLabel("Generations: ", SwingConstants.RIGHT);
        generationsTF = new JTextField(10);
    	
        menu = new JPanel[10];
        table = new JTextField[10][10];
        
        for (int i = 0; i < table.length; i++) {
        		menu[i] = new JPanel();
        	}
         
        //SPecify handlers for each button and add (register) ActionListeners to each button.
        calculateB = new JButton("Calculate");
        cbHandler = new CalculateButtonHandler();
        calculateB.addActionListener(cbHandler);
   
        exitB = new JButton("Exit");
        ebHandler = new ExitButtonHandler();
        exitB.addActionListener(ebHandler);
         
        setTitle("The Game of Life");
        
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(10, 11));
        
        menu[1].add(generations);
        menu[2].add(generationsTF);
        menu[3].add(calculateB);
        menu[9].add(exitB);
        
        for (int i = 0; i < table.length; i++) {
        		pane.add(menu[i]);
    		for (int j = 0; j < table[i].length; j++){
    			table[i][j] = new JTextField(5);
    			pane.add(table[i][j]);
    			table[i][j].setText("Dead");
    			//table[i][j].setBackground(new Color(255, 0, 0) );
    			}
    		}      
         
         
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private class CalculateButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           
        }
    }
     
    public class ExitButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }

}

