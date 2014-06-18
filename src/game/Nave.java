package game;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Nave {
	private int x,y;
	private int dx,dy;
	private int altura,largura;
	private Image imagem;
	private List<Missel>misseis;
	
	public Nave(){
		ImageIcon naveImg = new ImageIcon("src\\res\\nave.gif");
		imagem = naveImg.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		misseis	= new ArrayList<Missel>();
		this.x = 100;
		this.y = 100;
	}
	
	public void mover(){
		x += dx;
		y += dy;
		
		if(this.x < 1){
			x = 1;
		}
		
		if(this.x > 462){
			x = 462;
		}
		
		if(this.y < 1){
			y = 1;
		}
		
		if(this.y > 340){
			y = 340;
		}
	}
	
	
	public List<Missel> getMisseis() {
		return misseis;
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
	
	public void atirar(){
		this.misseis.add(new Missel(x+largura, y+altura/2));
	}
	
	public void keyPressed(KeyEvent tecla){
		
		int tecla_cod = tecla.getKeyCode();
		
		switch(tecla_cod){
			
			case(KeyEvent.VK_SPACE):atirar();
			break;
		
			case(KeyEvent.VK_UP):dy = -1;
			break;
			
			case(KeyEvent.VK_DOWN):dy = +1;
			break;
			
			case(KeyEvent.VK_LEFT):dx = -1;
			break;
			
			case(KeyEvent.VK_RIGHT):dx = +1;
			break;
		}
	}
	
	public void keyReleased(KeyEvent tecla){
		int tecla_cod = tecla.getKeyCode();
		
		switch(tecla_cod){
			
			case(KeyEvent.VK_UP):dy = 0;
			break;
			
			case(KeyEvent.VK_DOWN):dy = 0;
			break;
			
			case(KeyEvent.VK_LEFT):dx = 0;
			break;
			
			case(KeyEvent.VK_RIGHT):dx = 0;
			break;
		}
	}

}
