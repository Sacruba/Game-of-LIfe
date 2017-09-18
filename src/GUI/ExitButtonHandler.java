package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButtonHandler implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
}