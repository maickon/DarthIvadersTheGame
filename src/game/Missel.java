package game;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Missel {
	
	private int x,y;
	private int dx,dy;
	private Image imagem;
	private boolean isVisivel;
	
	private static final int LARGURA_TELA = 500;
	private static final int VELOCIDADE = 2;
	
	public Missel(int x, int y){
		this.x = x;
		this.y = y;
		
		ImageIcon referenciaImg = new ImageIcon("src\\res\\missel.png");
		imagem = referenciaImg.getImage();
		isVisivel = true;
	}
	
	
	public boolean isVisivel() {
		return isVisivel;
	}


	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public Image getImagem() {
		return imagem;
	}

	public void mover(){
		this.x += VELOCIDADE;
		if(this.x > LARGURA_TELA){
			isVisivel = false;
		}
	}

}
