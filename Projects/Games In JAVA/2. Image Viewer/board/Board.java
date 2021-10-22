package board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel
{
  private Image img;

  public Board()
  {
    initBoard();
  }

  private void initBoard()
  {
    loadImage();

    int w=img.getWidth(this);
    int h=img.getHeight(this);
    setPreferredSize(new Dimension(w,h));
  }

  private void loadImage()
  {
    ImageIcon ii = new ImageIcon("/Docs/Java Programs/resources/spaceship.png");
    img =ii.getImage();
  }

  @Override
  public void paintComponent(Graphics g)
  {
    g.drawImage(img,0,0,null);
  }
}
