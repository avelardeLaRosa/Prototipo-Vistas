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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import java.awt.Button;
import javax.swing.UIManager;

public class frmVenta extends JDialog implements MouseListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel pnVenta;
	int xmouse,ymouse;
	private JLabel lbl_Cerrar;
	private JLabel lblVentaDeProductos;
	private JPanel panel;
	private JLabel lblCodigoDeProducto;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblCantidad;
	private JTextField textField_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblCajeroDeTurno;
	private JLabel lblNombreDeCajero;
	private JLabel lblHora;
	private JSeparator separator;
	private JLabel lblMonto;
	private JButton btnNewButton;
	private Button button;
	private Button button_1;
	private Button button_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmVenta dialog = new frmVenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmVenta() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		pnVenta = new JPanel();
		pnVenta.setBackground(UIManager.getColor("text"));
		pnVenta.addMouseMotionListener(this);
		pnVenta.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnVenta.addMouseListener(this);
		pnVenta.setBounds(0, 0, 687, 480);
		contentPanel.add(pnVenta);
		pnVenta.setLayout(null);
		
		lbl_Cerrar = new JLabel("");
		lbl_Cerrar.addMouseListener(this);
		lbl_Cerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_Cerrar.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		lbl_Cerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Cerrar.setBounds(646, 11, 31, 24);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(lbl_Cerrar.getWidth(), lbl_Cerrar.getHeight(), Image.SCALE_SMOOTH));
		lbl_Cerrar.setIcon(new ImageIcon(frmVenta.class.getResource("/img/leftarrow_theapplication_izquierda_4435.png")));
		pnVenta.add(lbl_Cerrar);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 48, 687, 46);
		panel.setBackground(new Color(216, 65, 59));
		pnVenta.add(panel);
		panel.setLayout(null);
		
		lblVentaDeProductos = new JLabel("VENTA DE PRODUCTOS");
		lblVentaDeProductos.setBounds(10, 11, 234, 29);
		panel.add(lblVentaDeProductos);
		lblVentaDeProductos.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		
		lblCodigoDeProducto = new JLabel("Codigo de Producto");
		lblCodigoDeProducto.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		lblCodigoDeProducto.setBounds(10, 105, 140, 17);
		pnVenta.add(lblCodigoDeProducto);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		textField.setBounds(153, 100, 150, 25);
		pnVenta.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(310, 100, 31, 25);
		ImageIcon icoAdd=new ImageIcon(getClass().getResource("/img/add_icon-icons.com_74429.png"));
		ImageIcon imgAdd=new ImageIcon(icoAdd.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(imgAdd);
		pnVenta.add(lblNewLabel);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		lblCantidad.setBounds(374, 105, 74, 17);
		pnVenta.add(lblCantidad);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(442, 101, 150, 25);
		pnVenta.add(textField_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 140, 687, 211);
		scrollPane.setBorder(new LineBorder(new Color(0,0,0)));
		pnVenta.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0,0,0)));
		scrollPane.setViewportView(table);
		
		lblCajeroDeTurno = new JLabel("Cajero de Turno:");
		lblCajeroDeTurno.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblCajeroDeTurno.setBounds(10, 440, 120, 29);
		pnVenta.add(lblCajeroDeTurno);
		
		lblNombreDeCajero = new JLabel("Nombre de cajero");
		lblNombreDeCajero.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblNombreDeCajero.setBounds(138, 440, 140, 29);
		pnVenta.add(lblNombreDeCajero);
		
		lblHora = new JLabel("hORA");
		lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHora.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblHora.setBounds(557, 440, 120, 29);
		pnVenta.add(lblHora);
		
		separator = new JSeparator();
		separator.setBackground(Color.RED);
		separator.setBounds(0, 440, 687, 11);
		pnVenta.add(separator);
		
		lblMonto = new JLabel("MONTO$");
		lblMonto.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblMonto.setBounds(557, 378, 120, 29);
		pnVenta.add(lblMonto);
		
		btnNewButton = new JButton("COBRAR");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		btnNewButton.setBounds(430, 371, 106, 45);
		pnVenta.add(btnNewButton);
		
		button = new Button("Cancelar Venta");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBackground(new Color(240, 128, 128));
		button.setForeground(Color.BLACK);
		button.setBounds(10, 385, 120, 22);
		pnVenta.add(button);
		
		button_1 = new Button("Quitar Producto");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(new Color(240, 128, 128));
		button_1.setBounds(153, 385, 120, 22);
		pnVenta.add(button_1);
		
		button_2 = new Button("Modificar Cantidad");
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setForeground(Color.BLACK);
		button_2.setBackground(new Color(240, 128, 128));
		button_2.setBounds(291, 385, 120, 22);
		pnVenta.add(button_2);
		setUndecorated(true);
		setBounds(0,0,687,480);
		setLocationRelativeTo(null);
		
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lbl_Cerrar) {
			mouseClickedLbl_Cerrar(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == pnVenta) {
			mousePressedPanel(arg0);
		}
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mousePressedPanel(MouseEvent arg0) {
		xmouse = arg0.getX();
		ymouse = arg0.getY();
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == pnVenta) {
			mouseDraggedPanel(arg0);
		}
	}
	public void mouseMoved(MouseEvent arg0) {
	}
	protected void mouseDraggedPanel(MouseEvent arg0) {
		int x = arg0.getXOnScreen();
		int y = arg0.getYOnScreen();
		
		this.setLocation(x - xmouse, y - ymouse);
	}
	protected void mouseClickedLbl_Cerrar(MouseEvent arg0) {
		this.dispose();
		frmPrincipalEmp pri=new frmPrincipalEmp();
		pri.setVisible(true);
		pri.setLocationRelativeTo(null);
	}
}
