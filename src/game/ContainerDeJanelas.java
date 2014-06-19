package game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;


public class ContainerDeJanelas extends JFrame{
	public ContainerDeJanelas(){
		
		JMenuBar menu_bar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		
		JMenuItem sobre = new JMenuItem("Sobre");
		sobre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(null, "Jogo desenvolvido por Maickon Rangel.", "Informação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}); 
		
		menu.add(sobre);
		menu.add(new JSeparator());
		menu.add(sair);
		menu_bar.add(menu);
		setJMenuBar(menu_bar);
		
		
		add(new Fase());
		setTitle("Darth Invaders");
		setSize(500,420);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ContainerDeJanelas();
	}
}
