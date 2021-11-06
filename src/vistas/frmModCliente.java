package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class frmModCliente extends JDialog implements MouseListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	int xMouse, yMouse;
	private JPanel panel_1;
	private JLabel label;
	private JLabel label_1;
	private JPanel panel_2;
	private JLabel lblDniDeCliente;
	private JTextField textField;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField textField_1;
	private JLabel lblApellido;
	private JTextField textField_2;
	private JLabel lblDni;
	private JTextField textField_3;
	private JLabel lblTelefono;
	private JTextField textField_4;
	private JButton button;
	private JLabel lblCorreo;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmModCliente dialog = new frmModCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmModCliente() {
		setBounds(0,0,450,350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
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
		
		label = new JLabel("MODIFICA PRODUCTO");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		label.setBounds(111, 11, 221, 26);
		panel_1.add(label);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(this);
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_SMOOTH));
		label_1.setIcon(imgCerrar);
		panel_1.add(label_1);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 46, 410, 51);
		panel_1.add(panel_2);
		
		lblDniDeCliente = new JLabel("DNI de Cliente");
		lblDniDeCliente.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblDniDeCliente.setBounds(10, 11, 146, 26);
		panel_2.add(lblDniDeCliente);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(179, 12, 168, 26);
		panel_2.add(textField);
		
		label_3 = new JLabel("");
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setBounds(357, 11, 31, 29);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscar=new ImageIcon(icoBuscar.getImage().getScaledInstance(label_3.getWidth(), label_3.getHeight(), Image.SCALE_SMOOTH));
		label_3.setIcon(imgBuscar);
		panel_2.add(label_3);
		
		label_4 = new JLabel("Nombre");
		label_4.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_4.setBounds(48, 105, 96, 29);
		panel_1.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(190, 105, 168, 26);
		panel_1.add(textField_1);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblApellido.setBounds(48, 145, 96, 27);
		panel_1.add(lblApellido);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(190, 142, 168, 29);
		panel_1.add(textField_2);
		
		lblDni = new JLabel("Dni");
		lblDni.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblDni.setBounds(48, 183, 96, 24);
		panel_1.add(lblDni);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(190, 183, 168, 26);
		panel_1.add(textField_3);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblTelefono.setBounds(48, 218, 96, 26);
		panel_1.add(lblTelefono);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(190, 218, 168, 26);
		panel_1.add(textField_4);
		
		button = new JButton("GUARDAR CAMBIOS");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		button.setBounds(132, 298, 188, 41);
		panel_1.add(button);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCorreo.setBounds(48, 255, 96, 26);
		panel_1.add(lblCorreo);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(190, 255, 168, 26);
		panel_1.add(textField_5);
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
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == panel) {
			mouseDraggedPanel(e);
		}
	}
	public void mouseMoved(MouseEvent e) {
	}
	protected void mouseDraggedPanel(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		
		this.setLocation(x - xMouse, y - yMouse);
	}
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		this.dispose();
	}
}
