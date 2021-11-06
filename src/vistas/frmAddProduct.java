package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmAddProduct extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	int xMouse, yMouse;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblPrecioVenta;
	private JLabel lblPrecio;
	private JLabel lblCategoria;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNuevoProducto;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmAddProduct dialog = new frmAddProduct();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmAddProduct() {
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
		panel_1.setBounds(20, 0, 409, 350);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(this);
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(375, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(imgCerrar);
		panel_1.add(lblNewLabel);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCodigo.setBounds(27, 75, 96, 26);
		panel_1.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblNombre.setBounds(27, 112, 96, 29);
		panel_1.add(lblNombre);
		
		lblPrecioVenta = new JLabel("Stock");
		lblPrecioVenta.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblPrecioVenta.setBounds(27, 152, 96, 27);
		panel_1.add(lblPrecioVenta);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblPrecio.setBounds(27, 190, 96, 24);
		panel_1.add(lblPrecio);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCategoria.setBounds(27, 225, 96, 26);
		panel_1.add(lblCategoria);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField.setBounds(169, 75, 168, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(169, 112, 168, 26);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(169, 152, 168, 26);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(169, 190, 168, 26);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(169, 225, 168, 26);
		panel_1.add(textField_4);
		
		lblNuevoProducto = new JLabel("NUEVO PRODUCTO");
		lblNuevoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoProducto.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblNuevoProducto.setBounds(108, 23, 191, 26);
		panel_1.add(lblNuevoProducto);
		
		btnNewButton = new JButton("GUARDAR");
		btnNewButton.addActionListener(this);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnNewButton.setIcon(new ImageIcon(frmAddProduct.class.getResource("/img/check_40622.png")));
		btnNewButton.setBounds(123, 284, 158, 41);
		panel_1.add(btnNewButton);
		setUndecorated(true);
		setBounds(0,0,450,350);
		setLocationRelativeTo(null);
		
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblNewLabel) {
			mouseClickedLblNewLabel(e);
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
	protected void mouseClickedLblNewLabel(MouseEvent e) {
		this.dispose();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
	}
}
