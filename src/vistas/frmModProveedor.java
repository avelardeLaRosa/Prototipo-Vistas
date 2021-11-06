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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class frmModProveedor extends JDialog implements MouseListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	int xMouse,yMouse;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblModificaProveedor;
	private JLabel label_1;
	private JPanel panel_2;
	private JLabel lblCodigoDeProveedor;
	private JTextField txtCodigoProveedor;
	private JLabel label_3;
	private JLabel lblNombre;
	private JTextField textField_1;
	private JLabel lblTelefono;
	private JTextField textField_2;
	private JLabel lblTelefono_1;
	private JLabel lblInfoExtra;
	private JTextField textField_4;
	private JButton button;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmModProveedor dialog = new frmModProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmModProveedor() {
		setBounds(0, 0, 450, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(193,18,5));
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBounds(0, 0, 450, 350);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 430, 350);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblModificaProveedor = new JLabel("MODIFICA PROVEEDOR");
		lblModificaProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificaProveedor.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblModificaProveedor.setBounds(111, 11, 221, 26);
		panel_1.add(lblModificaProveedor);
		
		label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(this);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_1.getWidth(),label_1.getHeight() , Image.SCALE_SMOOTH));
		label_1.setIcon(imgCerrar);
		panel_1.add(label_1);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 46, 410, 51);
		panel_1.add(panel_2);
		
		lblCodigoDeProveedor = new JLabel("Codigo de Proveedor:");
		lblCodigoDeProveedor.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCodigoDeProveedor.setBounds(10, 11, 162, 26);
		panel_2.add(lblCodigoDeProveedor);
		
		txtCodigoProveedor = new JTextField();
		txtCodigoProveedor.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtCodigoProveedor.setColumns(10);
		txtCodigoProveedor.setBounds(179, 12, 168, 26);
		panel_2.add(txtCodigoProveedor);
		
		label_3 = new JLabel("");
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setBounds(357, 11, 31, 29);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscar=new ImageIcon(icoBuscar.getImage().getScaledInstance(label_3.getWidth(),label_3.getHeight() , Image.SCALE_SMOOTH));
		label_3.setIcon(imgBuscar);
		panel_2.add(label_3);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblNombre.setBounds(48, 105, 96, 29);
		panel_1.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(190, 105, 168, 26);
		panel_1.add(textField_1);
		
		lblTelefono = new JLabel("Telefono 1:");
		lblTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblTelefono.setBounds(48, 145, 96, 27);
		panel_1.add(lblTelefono);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(190, 142, 168, 29);
		panel_1.add(textField_2);
		
		lblTelefono_1 = new JLabel("Telefono 2:");
		lblTelefono_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblTelefono_1.setBounds(48, 183, 96, 24);
		panel_1.add(lblTelefono_1);
		
		lblInfoExtra = new JLabel("Info Extra:");
		lblInfoExtra.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblInfoExtra.setBounds(48, 218, 96, 26);
		panel_1.add(lblInfoExtra);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(190, 183, 168, 26);
		panel_1.add(textField_4);
		
		button = new JButton("GUARDAR CAMBIOS");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		button.setBounds(132, 276, 188, 41);
		panel_1.add(button);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 218, 168, 41);
		panel_1.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
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
		
		this.setLocation(x - xMouse, y - yMouse);
	}
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		this.dispose();
	}
}
