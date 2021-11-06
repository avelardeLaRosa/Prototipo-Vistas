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
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class frmAddUsuario extends JDialog implements MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNuevoUsuario;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblUsuario;
	private JLabel lblClave;
	private JLabel lblFechaRegistro;
	private JButton button;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel label_7;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmAddUsuario dialog = new frmAddUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmAddUsuario() {
		setBounds(0, 0, 450, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(193,18,5));
		panel.setBounds(0, 0, 450, 350);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 430, 350);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNuevoUsuario = new JLabel("NUEVO USUARIO");
		lblNuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblNuevoUsuario.setBounds(129, 23, 191, 26);
		panel_1.add(lblNuevoUsuario);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCodigo.setBounds(26, 75, 96, 26);
		panel_1.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblNombre.setBounds(26, 112, 96, 29);
		panel_1.add(lblNombre);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblApellido.setBounds(26, 152, 96, 27);
		panel_1.add(lblApellido);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblUsuario.setBounds(26, 190, 96, 24);
		panel_1.add(lblUsuario);
		
		lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblClave.setBounds(26, 225, 96, 26);
		panel_1.add(lblClave);
		
		lblFechaRegistro = new JLabel("Fecha Registro:");
		lblFechaRegistro.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblFechaRegistro.setBounds(26, 262, 118, 26);
		panel_1.add(lblFechaRegistro);
		
		button = new JButton("GUARDAR");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(frmAddUsuario.class.getResource("/img/Accept256_25070.png")));
		button.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		button.setBounds(129, 304, 158, 35);
		panel_1.add(button);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(190, 225, 168, 26);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(190, 190, 168, 26);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(190, 152, 168, 26);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(190, 112, 168, 26);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(190, 75, 168, 26);
		panel_1.add(textField_5);
		
		label_7 = new JLabel("");
		label_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_7.addMouseListener(this);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_7.getWidth(), label_7.getHeight(), Image.SCALE_SMOOTH));
		label_7.setIcon(imgCerrar);
		panel_1.add(label_7);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(190, 262, 166, 26);
		panel_1.add(dateChooser);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_7) {
			mouseClickedLabel_7(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedLabel_7(MouseEvent arg0) {
		this.dispose();
	}
}
