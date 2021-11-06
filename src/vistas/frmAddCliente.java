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
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class frmAddCliente extends JDialog implements MouseListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	int xMouse, yMouse;
	private JPanel panel_1;
	private JLabel lblNuevoCliente;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblTelefono;
	private JButton button;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblCorreo;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmAddCliente dialog = new frmAddCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmAddCliente() {
		setBounds(0,0, 450, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBounds(0, 0, 450, 350);
		panel.setBackground(new Color(193,18,5));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 430, 350);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNuevoCliente = new JLabel("NUEVO CLIENTE");
		lblNuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoCliente.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblNuevoCliente.setBounds(129, 23, 191, 26);
		panel_1.add(lblNuevoCliente);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(this);
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_SMOOTH));
		label_1.setIcon(imgCerrar);
		panel_1.add(label_1);
		
		label_2 = new JLabel("Codigo");
		label_2.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_2.setBounds(48, 75, 96, 26);
		panel_1.add(label_2);
		
		label_3 = new JLabel("Nombre");
		label_3.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_3.setBounds(48, 112, 96, 29);
		panel_1.add(label_3);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblApellido.setBounds(48, 152, 96, 27);
		panel_1.add(lblApellido);
		
		lblDni = new JLabel("Dni");
		lblDni.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblDni.setBounds(48, 190, 96, 24);
		panel_1.add(lblDni);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblTelefono.setBounds(48, 225, 96, 26);
		panel_1.add(lblTelefono);
		
		button = new JButton("GUARDAR");
		button.setIcon(new ImageIcon(frmAddCliente.class.getResource("/img/check_40622.png")));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		button.setBounds(129, 298, 158, 41);
		panel_1.add(button);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(190, 225, 168, 26);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(190, 190, 168, 26);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(190, 152, 168, 26);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(190, 112, 168, 26);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(190, 75, 168, 26);
		panel_1.add(textField_4);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCorreo.setBounds(48, 262, 96, 26);
		panel_1.add(lblCorreo);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(190, 262, 168, 26);
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
		xMouse=arg0.getX();
		yMouse=arg0.getY();
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
		this.setLocation(x-xMouse, y-yMouse);
	}
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		this.dispose();
	}
}
