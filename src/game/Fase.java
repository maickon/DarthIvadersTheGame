package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener{
	
	private Image fundoImg;
	private Nave nave;
	private Timer tempo;

	public Fase(){
		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(new TecladoAdapter());
		ImageIcon referenciaImg = new ImageIcon("src\\res\\fundo.png");
		fundoImg = referenciaImg.getImage();
		nave = new Nave();
		tempo  = new Timer(5, this);
		tempo.start();
	}

	public void paint(Graphics g){
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundoImg, 0, 0, null);
		graficos.drawImage(nave.getImagem(), nave.getX(), nave.getY(), this);
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		nave.mover();
		repaint(); 
	}
	
	private class TecladoAdapter extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			nave.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			nave.keyReleased(e);
		}
		 
	}
}
