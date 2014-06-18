package game;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Nave {
	private int x,y;
	private int dx,dy;
	private Image imagem;
	
	public Nave(){
		ImageIcon naveImg = new ImageIcon("src\\res\\nave.gif");
		imagem = naveImg.getImage();
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
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImagem() {
		return imagem;
	}
	
	public void keyPressed(KeyEvent tecla){
		
		int tecla_cod = tecla.getKeyCode();
		
		switch(tecla_cod){
			
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
