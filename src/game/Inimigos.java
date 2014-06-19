package game;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Inimigos {

	private int x,y;
	private int largura,altura;
	private Image imagem;
	private boolean isVisivel;

	private static final int LARGURA_TELA = 500;
	private static final int VELOCIDADE = 3;

	public Inimigos(int x, int y){
		this.x = x;
		this.y = y;

		ImageIcon referenciaImg = new ImageIcon("res\\inimigo_1.gif");
		imagem = referenciaImg.getImage();
		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
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
		if(this.x < 0){
			this.x = LARGURA_TELA;
		}else{
			this.x -= VELOCIDADE;
		}
	}

	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}
}