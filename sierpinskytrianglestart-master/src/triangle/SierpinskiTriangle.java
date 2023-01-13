package src.triangle;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SierpinskiTriangle {
	public static int SIZE = 1000;

	JFrame frame;
	JPanel panel;

	@SuppressWarnings("serial")
	public void display() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				paintSierpinskiTriangle(g, getSize());


			}
		};
		panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				panel.repaint();
			}
		});
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setSize(SIZE, SIZE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SierpinskiTriangle triangle = new SierpinskiTriangle();

		triangle.display();

	}

	public void paintSierpinskiTriangle(Graphics g, Dimension size) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.white);
		g2.clearRect(0, 0, size.width, size.height);
		g2.draw3DRect(20, 20, size.width - 40, size.height - 40, true);


		Point p1 = new Point(size.width/2,10);
		Point p2 = new Point(size.width-10, size.height-10);
		Point p3 = new Point(10, size.height-10);


displayTriangles(g,5,p1,p2,p3);
	}
	private static void displayTriangles(Graphics g, int order,
										 Point p1, Point p2, Point p3) {
		float hue = (float) Math.random();
		int rgb = Color.HSBtoRGB(hue,0.5f,0.5f);
		g.setColor(new Color(rgb));

		if (order == 0) {


			g.drawLine(p1.x, p1.y, p2.x, p2.y);
			g.drawLine(p1.x, p1.y, p3.x, p3.y);
			g.drawLine(p2.x, p2.y, p3.x, p3.y);

			int[]x = {p1.x,p2.x,p3.x};
			int[]y = {p1.y,p2.y,p3.y};
			g.drawPolygon(x,y,3);
			g.fillPolygon(x,y,3);


		} else {
			Point p12 = midPoint(p1, p2);
			Point p23 = midPoint(p2, p3);
			Point p31 = midPoint(p3, p1);

			displayTriangles(g, order - 1, p1, p12, p31);
			displayTriangles(g, order - 1, p12, p2, p23);
			displayTriangles(g, order - 1, p31, p23, p3);
		}
	}
	private static Point midPoint(Point p1, Point p2) {
		return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
	}

}
