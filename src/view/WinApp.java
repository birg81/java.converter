package view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class WinApp {
	private JFrame frame;
	private JLabel lab2, lab10, lab8, lab16;
	private JTextField txt2, txt8, txt10, txt16;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				WinApp window = new WinApp();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public WinApp() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 2, 0, 0));

		txt2 = new JTextField();
		txt2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int n = !txt2.getText().isBlank() ? Integer.parseInt(txt2.getText(), 2) : 0;
				txt8.setText("%o".formatted(n));
				txt10.setText("%d".formatted(n));
				txt16.setText("%x".formatted(n));
			}
		});
		txt2.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(txt2);
		lab2 = new JLabel("binario");
		frame.getContentPane().add(lab2);

		txt8 = new JTextField();
		txt8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int n = !txt8.getText().isBlank() ? Integer.parseInt(txt8.getText(), 8) : 0;
				txt2.setText(Integer.toBinaryString(n));
				txt10.setText("%d".formatted(n));
				txt16.setText("%x".formatted(n));
			}
		});
		txt8.setHorizontalAlignment(SwingConstants.RIGHT);

		frame.getContentPane().add(txt8);
		lab8 = new JLabel("ottale");
		frame.getContentPane().add(lab8);

		txt10 = new JTextField();
		txt10.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int n = !txt10.getText().isBlank() ? Integer.parseInt(txt10.getText()) : 0;
				txt2.setText(Integer.toBinaryString(n));
				txt8.setText("%o".formatted(n));
				txt16.setText("%x".formatted(n));
			}
		});
		txt10.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(txt10);
		lab10 = new JLabel("dec");
		frame.getContentPane().add(lab10);

		txt16 = new JTextField();
		txt16.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int n = !txt16.getText().isBlank() ? Integer.parseInt(txt16.getText(), 16) : 0;
				txt2.setText(Integer.toBinaryString(n));
				txt8.setText("%o".formatted(n));
				txt10.setText("%d".formatted(n));
			}
		});
		txt16.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(txt16);
		lab16 = new JLabel("hex");
		frame.getContentPane().add(lab16);
	}
}