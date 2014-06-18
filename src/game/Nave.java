package game;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Nave {
	private int x,y;
	private int dx,dy;
	private Image imagem;
	
	public Nave(){
		ImageIcon naveImg = new ImageIcon("res\\nave.gif");
		imagem = naveImg.getImage();
		this.x = 100;
		this.y = 100;
	}
	
	public void mover(){
		x += dx;
		y += dy;
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
			
			case(KeyEvent.VK_RIGHT):dy = +1;
			break;
		}
	}
	
	public void KeyReleased(KeyEvent tecla){
		int tecla_cod = tecla.getKeyCode();
		
		switch(tecla_cod){
			
			case(KeyEvent.VK_UP):dy = 0;
			break;
			
			case(KeyEvent.VK_DOWN):dy = 0;
			break;
			
			case(KeyEvent.VK_LEFT):dx = 0;
			break;
			
			case(KeyEvent.VK_RIGHT):dy = 0;
			break;
		}
	}

}
