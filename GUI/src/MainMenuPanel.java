
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sorrow
 */
public class MainMenuPanel extends JPanel{
    private JButton jb1;
    private JButton jb2;
    private JButton jb3;
    
    public MainMenuPanel(){
        initComp();
    }
    
    private void initComp(){
        this.setLayout(new BorderLayout());
        ImageIcon ii1=new ImageIcon(MainMenuPanel.class.getResource("BG.jpg"));
        Image i1=ii1.getImage();
        i1=i1.getScaledInstance(480, 272, Image.SCALE_SMOOTH);
        ii1.setImage(i1);
        JLabel bg=new JLabel(ii1);
        
        this.add(bg);
        
        jb2 = new javax.swing.JButton();
        jb3 = new javax.swing.JButton();
        jb1 = new javax.swing.JButton();
        
        jb2.setText("Einstellungen");
        jb3.setText("Beenden");
        jb1.setText("Spiel starten");
        
        jb1.setBounds(160, 50, 150, 50);
        jb2.setBounds(160, 100, 150, 50);
        jb3.setBounds(160, 150, 150, 50);
        
        bg.add(jb1);
        bg.add(jb2);
        bg.add(jb3);
        
        jb3.addActionListener((e) -> {
            System.exit(0);
        });
    }
}
