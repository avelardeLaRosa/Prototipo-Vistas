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

public class frmModProduct extends JDialog implements MouseListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	int xMouse, yMouse;
	private JPanel panel_1;
	private JLabel lblModificaProductor;
	private JLabel label;
	private JPanel panel_2;
	private JLabel lblCodigoDeProducto;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel label_1;
	private JTextField textField_1;
	private JLabel lblCantidad;
	private JTextField textField_2;
	private JLabel label_3;
	private JTextField textField_3;
	private JLabel label_4;
	private JTextField textField_4;
	private JButton btnGuardarCambios;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmModProduct dialog = new frmModProduct();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmModProduct() {
		setBounds(0,0,450,350);
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
		
		lblModificaProductor = new JLabel("MODIFICA PRODUCTO");
		lblModificaProductor.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificaProductor.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblModificaProductor.setBounds(111, 11, 221, 26);
		panel_1.add(lblModificaProductor);
		
		label = new JLabel("");
		label.addMouseListener(this);
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
		label.setIcon(imgCerrar);
		panel_1.add(label);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 46, 410, 51);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		lblCodigoDeProducto = new JLabel("Codigo de Producto");
		lblCodigoDeProducto.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCodigoDeProducto.setBounds(10, 11, 146, 26);
		panel_2.add(lblCodigoDeProducto);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(179, 12, 168, 26);
		panel_2.add(textField);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setBounds(357, 11, 31, 29);
		panel_2.add(lblNewLabel);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscar=new ImageIcon(icoBuscar.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(imgBuscar);
		
		label_1 = new JLabel("Nombre");
		label_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_1.setBounds(48, 105, 96, 29);
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(190, 105, 168, 26);
		panel_1.add(textField_1);
		
		lblCantidad = new JLabel("Stock");
		lblCantidad.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCantidad.setBounds(48, 145, 96, 27);
		panel_1.add(lblCantidad);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(190, 142, 168, 29);
		panel_1.add(textField_2);
		
		label_3 = new JLabel("Precio");
		label_3.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_3.setBounds(48, 183, 96, 24);
		panel_1.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(190, 183, 168, 26);
		panel_1.add(textField_3);
		
		label_4 = new JLabel("Categoria");
		label_4.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_4.setBounds(48, 218, 96, 26);
		panel_1.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(190, 218, 168, 26);
		panel_1.add(textField_4);
		
		btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
		btnGuardarCambios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardarCambios.setIcon(null);
		btnGuardarCambios.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnGuardarCambios.setBounds(132, 276, 188, 41);
		panel_1.add(btnGuardarCambios);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == label) {
			mouseClickedLabel(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == panel) {
			mousePressedPanel(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mousePressedPanel(MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
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
	protected void mouseClickedLabel(MouseEvent e) {
		this.dispose();
	}
}
