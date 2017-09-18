package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Main.GameOfLife;


public class MainFrame extends JFrame{
	
	private GameOfLife game;

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    
    private JLabel generations;
    private JTextField generationsTF;
    private JTextField[][] table;
    private JButton calculateB, exitB;
    private JPanel[] menu;
    
    //Button handlers:
    private CalculateButtonHandler cbHandler;
    private ExitButtonHandler ebHandler;


    
    public MainFrame(GameOfLife theGame)
    {
    	
    	game = theGame;

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
    			table[i][j].setBackground(new Color(255, 100, 100));
    			table[i][j].setHorizontalAlignment(JTextField.CENTER);
    			table[i][j].setEnabled(false);
    			table[i][j].setDisabledTextColor(new Color(0, 0, 0));
    			}
    		}
        
        table[1][2].setText("Alive");
        table[3][2].setText("Alive");
        table[2][1].setText("Alive");
        table[3][3].setText("Alive");
        table[4][4].setText("Alive");
        
        table[1][2].setBackground(new Color(100, 255, 100));
        table[3][2].setBackground(new Color(100, 255, 100));
        table[2][1].setBackground(new Color(100, 255, 100));
        table[3][3].setBackground(new Color(100, 255, 100));
        table[4][4].setBackground(new Color(100, 255, 100));
        
         
         
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private class CalculateButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           boolean[][] currentPopulation = new boolean[table.length][table[1].length];
           boolean[][] newPopulation;
           
           for (int i = 0; i < table.length; i++) {
       			for (int j = 0; j < table[i].length; j++){
       				if (table[i][j].getText().equals("Alive")){
       					currentPopulation[i][j] = true;
       				}
       				else
       				{
       					currentPopulation[i][j] = false;
       				}
       			}
           }
           
           newPopulation = game.gameOfLife(currentPopulation, Integer.parseInt(generationsTF.getText()));
            	
           for (int i = 0; i < newPopulation.length; i++) {
       			for (int j = 0; j < newPopulation[i].length; j++){
       				if (newPopulation[i][j]){
       					table[i][j].setText("Alive");
       			        table[i][j].setBackground(new Color(100, 255, 100));
       				}
       				else
       				{
       					table[i][j].setText("Dead");
       	    			table[i][j].setBackground(new Color(255, 100, 100));
       				}
       			}
           }
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

