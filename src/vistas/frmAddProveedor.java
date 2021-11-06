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
import java.awt.image.ImagingOpException;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;

public class frmAddProveedor extends JDialog implements MouseListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	int xMouse,yMouse;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel label;
	private JLabel lblNuevoProveedor;
	private JLabel lblCodigoDeProveedor;
	private JTextField textField;
	private JLabel lblNombre;
	private JTextField textField_1;
	private JLabel lblTelefono;
	private JTextField textField_2;
	private JLabel lblTelefono_1;
	private JTextField textField_3;
	private JLabel lblInfoExtra;
	private JButton button;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmAddProveedor dialog = new frmAddProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmAddProveedor() {
		setBounds(0, 0, 450, 350);
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
		
		label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(this);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH));
		label.setIcon(imgCerrar);
		panel_1.add(label);
		
		lblNuevoProveedor = new JLabel("NUEVO PROVEEDOR");
		lblNuevoProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoProveedor.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblNuevoProveedor.setBounds(129, 23, 191, 26);
		panel_1.add(lblNuevoProveedor);
		
		lblCodigoDeProveedor = new JLabel("Codigo de Proveedor:");
		lblCodigoDeProveedor.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCodigoDeProveedor.setBounds(10, 74, 158, 26);
		panel_1.add(lblCodigoDeProveedor);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(190, 75, 168, 26);
		panel_1.add(textField);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblNombre.setBounds(10, 110, 96, 29);
		panel_1.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(190, 112, 168, 26);
		panel_1.add(textField_1);
		
		lblTelefono = new JLabel("Telefono 1:");
		lblTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblTelefono.setBounds(10, 150, 96, 27);
		panel_1.add(lblTelefono);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(190, 152, 168, 26);
		panel_1.add(textField_2);
		
		lblTelefono_1 = new JLabel("Telefono 2:");
		lblTelefono_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblTelefono_1.setBounds(10, 190, 96, 24);
		panel_1.add(lblTelefono_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(190, 190, 168, 26);
		panel_1.add(textField_3);
		
		lblInfoExtra = new JLabel("Info Extra:");
		lblInfoExtra.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblInfoExtra.setBounds(10, 225, 96, 26);
		panel_1.add(lblInfoExtra);
		
		button = new JButton("GUARDAR");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		button.setBounds(130, 298, 158, 26);
		panel_1.add(button);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 225, 168, 62);
		panel_1.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label) {
			mouseClickedLabel(arg0);
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
		
		this.setLocation(x - xMouse, y - yMouse);
	}
	protected void mouseClickedLabel(MouseEvent arg0) {
		this.dispose();
	}
}
