package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class frmCajaCierre extends JDialog implements MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblCierreDeCaja;
	private JLabel label_1;
	private JTextField textField;
	private JLabel label_2;
	private JButton button;
	private JButton button_1;
	private JLabel label_3;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmCajaCierre dialog = new frmCajaCierre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmCajaCierre() {
		setBounds(0, 0, 477, 340);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(193, 18, 5));
		panel.setBounds(0, 0, 477, 340);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 457, 340);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblCierreDeCaja = new JLabel("CIERRE DE CAJA");
		lblCierreDeCaja.setHorizontalAlignment(SwingConstants.LEFT);
		lblCierreDeCaja.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblCierreDeCaja.setBounds(10, 68, 207, 26);
		panel_1.add(lblCierreDeCaja);
		
		label_1 = new JLabel("CANTIDAD:");
		label_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_1.setBounds(10, 105, 96, 29);
		panel_1.add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(10, 145, 168, 26);
		panel_1.add(textField);
		
		label_2 = new JLabel("COMENTARIOS:");
		label_2.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_2.setBounds(10, 192, 168, 29);
		panel_1.add(label_2);
		
		button = new JButton("Guardar");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(frmCajaCierre.class.getResource("/img/Accept256_25070.png")));
		button.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		button.setBounds(306, 128, 141, 43);
		panel_1.add(button);
		
		button_1 = new JButton("Cancelar");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setIcon(new ImageIcon(frmCajaCierre.class.getResource("/img/delete_unapprove_discard_remove_x_red_icon-icons.com_55984.png")));
		button_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		button_1.setBounds(306, 208, 141, 43);
		panel_1.add(button_1);
		
		label_3 = new JLabel("");
		label_3.addMouseListener(this);
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(423, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_3.getWidth(), label_3.getHeight(), Image.SCALE_SMOOTH));
		label_3.setIcon(imgCerrar);
		panel_1.add(label_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 232, 221, 82);
		panel_1.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == label_3) {
			mouseClickedLabel_3(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedLabel_3(MouseEvent e) {
		this.dispose();
	}
}
