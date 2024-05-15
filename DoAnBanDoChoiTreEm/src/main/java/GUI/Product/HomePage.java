/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class HomePage extends JPanel {
    private JPanel buttonPanel;
    private JPanel infoPanel;
    private JButton vehiclesButton;
    private JButton fashionButton;
    private JButton movieButton;
    private JButton assemblyButton;
    private JButton robotButton;
    private JButton allProductButton;

    public HomePage() {
        super();
        setLayout(new BorderLayout());

        buttonPanel = new JPanel(new GridLayout(6, 1));
        infoPanel = new JPanel(new CardLayout());

        vehiclesButton = new JButton("VEHICLE");
        fashionButton = new JButton("FASHION");
        movieButton = new JButton("MOVIE");
        assemblyButton = new JButton("ASSEMBLY");
        robotButton = new JButton("ROBOT");
        allProductButton = new JButton("ALL PRODUCT");

        buttonPanel.add(vehiclesButton);
        buttonPanel.add(fashionButton);
        buttonPanel.add(movieButton);
        buttonPanel.add(assemblyButton);
        buttonPanel.add(robotButton);
        buttonPanel.add(allProductButton);

        add(buttonPanel, BorderLayout.EAST);
        add(infoPanel, BorderLayout.CENTER);

        vehiclesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) infoPanel.getLayout();
                cardLayout.show(infoPanel, "vehiclesPanel");
            }
        });

        fashionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) infoPanel.getLayout();
                cardLayout.show(infoPanel, "fashionPanel");
            }
        });
        
        movieButton.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){
                CardLayout cardLayout = (CardLayout) infoPanel.getLayout();
                cardLayout.show(infoPanel, "moviePanel");
            }
        });
        
        assemblyButton.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){
                CardLayout cardLayout = (CardLayout) infoPanel.getLayout();
                cardLayout.show(infoPanel, "assemblyPanel");
            }
        });
        
        robotButton.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){
                CardLayout cardLayout = (CardLayout) infoPanel.getLayout();
                cardLayout.show(infoPanel, "robotPanel");
            }
        });
        
        allProductButton.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){
                CardLayout cardLayout = (CardLayout) infoPanel.getLayout();
                cardLayout.show(infoPanel, "allProductPanel");
            }
        });
        
        infoPanel.add(new VehicleGUI(), "vehiclesPanel");
        infoPanel.add(new FashionGUI(), "fashionPanel");
        infoPanel.add(new MovieGUI(), "moviePanel");
        infoPanel.add(new AssemblyGUI(), "assemblyPanel");
        infoPanel.add(new RoBotGUI(), "robotPanel");
        infoPanel.add(new ProductGUI(), "allProductPanel");

    }
    
    
}
