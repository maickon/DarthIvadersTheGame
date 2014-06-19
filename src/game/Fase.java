package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {

	private Image fundoImg;
	private Nave nave;
	private Timer tempo;
	private boolean emJogo;
	private List<Inimigos> inimigos;

	private int[][] coordenadas = { 
			{ 2380, 29 }, { 2600, 59 }, { 1380, 89 },
			{ 780, 109 }, { 580, 139 }, { 880, 239 }, { 790, 259 },
			{ 760, 50 }, { 790, 150 }, { 1980, 209 }, { 560, 45 }, { 510, 70 },
			{ 930, 159 }, { 590, 80 }, { 530, 60 }, { 940, 59 }, { 990, 30 },
			{ 920, 200 }, { 900, 259 }, { 660, 50 }, { 540, 90 }, { 810, 220 },
			{ 860, 20 }, { 740, 180 }, { 820, 128 }, { 490, 170 }, { 700, 30 },
			{ 920, 300 }, { 856, 328 }, { 456, 320 } 
			};

	public Fase() {

		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(new TecladoAdapter());
		
		ImageIcon referenciaImg = new ImageIcon("res\\fundo.png");
		fundoImg = referenciaImg.getImage();
		nave = new Nave();
		inicializaInimigos();
		emJogo = true;
		
		tempo = new Timer(7, this);
		tempo.start();
	}

	public void inicializaInimigos() {
		inimigos = new ArrayList<Inimigos>();
		for (int i=0; i< coordenadas.length; i++) {
			int x = coordenadas[i][0];
			int y = coordenadas[i][1];
			inimigos.add(new Inimigos(x, y));
		}
	}

	public void paint(Graphics g) {

		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundoImg, 0, 0, null);

		if(emJogo) {
			graficos.drawImage(nave.getImagem(), nave.getX(), nave.getY(), this);
			List<Missel> misseis = nave.getMisseis();
			for (int i = 0; i < misseis.size(); i++) {
				Missel m = (Missel) misseis.get(i);
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
			}

			for (int i = 0; i < inimigos.size(); i++) {
				Inimigos in = inimigos.get(i);
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
			}
			
			graficos.setColor(Color.white);
			graficos.drawString("INIMIGOS: "+inimigos.size(), 5, 15);
		}else{
			ImageIcon gameOver = new ImageIcon("res\\darth_vader_game_over_3.jpg");
			graficos.drawImage(gameOver.getImage(), 0, 0, null);
		}
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (inimigos.size() == 0) {
			emJogo = false;
		}
		List<Missel> misseis = nave.getMisseis();
		
		for (int i = 0; i < misseis.size(); i++) {
			Missel m = (Missel) misseis.get(i);
			if (m.isVisivel()) {
				m.mover();
			} else {
				misseis.remove(i);
			}
		}

		for (int i = 0; i < inimigos.size(); i++) {
			Inimigos in = inimigos.get(i);
			if (in.isVisivel()) {
				in.mover();
			} else {
				inimigos.remove(i);
			}
		}

		nave.mover();
		checarColisoes();
		repaint();
	}

	public void checarColisoes() {

		Rectangle formaNave = nave.getBounds();
		Rectangle formaInimigo;
		Rectangle formaMissel;

		for (int i = 0; i < inimigos.size(); i++) {

			Inimigos tempInimigo = inimigos.get(i);
			formaInimigo = tempInimigo.getBounds();

			if (formaNave.intersects(formaInimigo)) {
				nave.setVisivel(false);
				tempInimigo.setVisivel(false);
				emJogo = false;
			}
		}

		List<Missel> misseis = nave.getMisseis();

		for (int i = 0; i < misseis.size(); i++) {

			Missel tempMissel = misseis.get(i);
			formaMissel = tempMissel.getBounds();

			for (int j = 0; j < inimigos.size(); j++) {

				Inimigos tempInimigo = inimigos.get(j);
				formaInimigo = tempInimigo.getBounds();

				if (formaMissel.intersects(formaInimigo)) {

					tempInimigo.setVisivel(false);
					tempMissel.setVisivel(false);
				}
			}
		}
	}

	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			 
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				emJogo = true;
				nave = new Nave();
				inicializaInimigos();
			}
			nave.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			nave.keyReleased(e);
		}

	}
}
