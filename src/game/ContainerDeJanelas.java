package game;
import javax.swing.JFrame;


public class ContainerDeJanelas extends JFrame{
	public ContainerDeJanelas(){
		add(new Fase());
		setTitle("Spacers");
		setSize(500,400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ContainerDeJanelas();
	}
}
