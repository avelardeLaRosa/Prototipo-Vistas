package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class frmCajaApertura extends JDialog implements MouseListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	int xMouse,yMouse;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel label_1;
	private JLabel lblEntrada;
	private JLabel lblCantidad;
	private JTextField textField;
	private JLabel lblComentarios;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnGuardar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmCajaApertura dialog = new frmCajaApertura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmCajaApertura() {
		setBounds(100, 100, 477, 340);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(193, 18, 5));
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBounds(0, 0, 477, 340);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 457, 340);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(this);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(423, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_1.getWidth(),label_1.getHeight() ,Image.SCALE_SMOOTH));
		label_1.setIcon(imgCerrar);
		panel_1.add(label_1);
		
		lblEntrada = new JLabel("APERTURA DE CAJA");
		lblEntrada.setHorizontalAlignment(SwingConstants.LEFT);
		lblEntrada.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblEntrada.setBounds(10, 68, 207, 26);
		panel_1.add(lblEntrada);
		
		lblCantidad = new JLabel("CANTIDAD:");
		lblCantidad.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCantidad.setBounds(10, 105, 96, 29);
		panel_1.add(lblCantidad);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(10, 145, 168, 26);
		panel_1.add(textField);
		
		lblComentarios = new JLabel("COMENTARIOS:");
		lblComentarios.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblComentarios.setBounds(10, 192, 168, 29);
		panel_1.add(lblComentarios);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 232, 256, 85);
		panel_1.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setIcon(new ImageIcon(frmCajaApertura.class.getResource("/img/Accept256_25070.png")));
		btnGuardar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnGuardar.setBounds(306, 128, 141, 43);
		panel_1.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(frmCajaApertura.class.getResource("/img/delete_unapprove_discard_remove_x_red_icon-icons.com_55984.png")));
		btnCancelar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnCancelar.setBounds(306, 208, 141, 43);
		panel_1.add(btnCancelar);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_1) {
			mouseClickedLabel_1(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == panel) {
			mousePressedPanel(arg0);
		}
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mousePressedPanel(MouseEvent arg0) {
		xMouse = arg0.getX();
		yMouse = arg0.getY();
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == panel) {
			mouseDraggedPanel(arg0);
		}
	}
	public void mouseMoved(MouseEvent arg0) {
	}
	protected void mouseDraggedPanel(MouseEvent arg0) {
		int x = arg0.getXOnScreen();
		int y = arg0.getYOnScreen();
		this.setLocation(x-xMouse,y-yMouse);
	}
	
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		this.dispose();
	}
}
