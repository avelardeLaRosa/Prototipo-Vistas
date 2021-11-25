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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import java.awt.Button;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmVenta extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel pnVenta;
	int xmouse,ymouse;
	private JLabel lbl_Cerrar;
	private JLabel lblVentaDeProductos;
	private JLabel lblCodigoDeProducto;
	private JLabel lblCantidad;
	public static JTextField txtDni;
	private JLabel lblCajeroDeTurno;
	private JLabel lblNombreDeCajero;
	private JLabel lblHora;
	private JSeparator separator;
	private JLabel lblMonto;
	private JButton btnNewButton;
	private JLabel label_1;
	private JButton button_3;
	public static JTextField txtNombre;
	private JLabel lblNroBoleta;
	private JTextField textField_3;
	private JLabel lblFecha;
	private JTextField textField_4;
	private JLabel label_4;
	private JLabel lblProducto;
	public static JTextField txtCodPro;
	private JButton button_4;
	public static JTextField txtNomPro;
	public static JTextField txtPrecioPro;
	public static JTextField txtStockPro;
	private JLabel lblCantidad_1;
	private JTextField txtCantidadPro;
	private JButton button;
	private JLabel lblAgregarProducto;
	private JScrollPane scrollPane;
	private JTable tblVenta;
	private JButton btnVentaNueva;
	DefaultTableModel model=new DefaultTableModel();
	private JLabel lblDni;
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
		ImageIcon icoAdd=new ImageIcon(getClass().getResource("/img/add_icon-icons.com_74429.png"));
		
		lblCantidad = new JLabel("Nombre");
		lblCantidad.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblCantidad.setBounds(32, 112, 74, 17);
		pnVenta.add(lblCantidad);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtDni.setColumns(10);
		txtDni.setBounds(114, 73, 100, 21);
		pnVenta.add(txtDni);
		
		lblCajeroDeTurno = new JLabel("Cajero de Turno:");
		lblCajeroDeTurno.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblCajeroDeTurno.setBounds(10, 440, 120, 29);
		pnVenta.add(lblCajeroDeTurno);
		
		lblNombreDeCajero = new JLabel(frmLogin.u.getNombre()+" "+frmLogin.u.getApellido());
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
		lblMonto.setBounds(557, 391, 120, 29);
		pnVenta.add(lblMonto);
		
		btnNewButton = new JButton("COBRAR");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		btnNewButton.setBounds(430, 384, 106, 45);
		pnVenta.add(btnNewButton);
		
		lblVentaDeProductos = new JLabel("VENTA DE PRODUCTOS");
		lblVentaDeProductos.setBounds(228, 6, 220, 29);
		pnVenta.add(lblVentaDeProductos);
		lblVentaDeProductos.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		
		button_3 = new JButton("");
		button_3.addActionListener(this);
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.setBounds(233, 74, 31, 24);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscar=new ImageIcon(icoBuscar.getImage().getScaledInstance(button_3.getWidth(), button_3.getHeight(), Image.SCALE_SMOOTH));
		button_3.setIcon(imgBuscar);
		pnVenta.add(button_3);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(114, 109, 150, 23);
		pnVenta.add(txtNombre);
		
		lblNroBoleta = new JLabel("Nro. Boleta");
		lblNroBoleta.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblNroBoleta.setBounds(376, 77, 74, 17);
		pnVenta.add(lblNroBoleta);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(460, 73, 100, 21);
		pnVenta.add(textField_3);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblFecha.setBounds(376, 115, 74, 17);
		pnVenta.add(lblFecha);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(460, 112, 100, 20);
		pnVenta.add(textField_4);
		
		label_1 = new JLabel("");
		label_1.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		label_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Boleta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		label_1.setBounds(346, 46, 331, 100);
		pnVenta.add(label_1);
		
		lblProducto = new JLabel("Producto");
		lblProducto.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblProducto.setBounds(32, 167, 74, 17);
		pnVenta.add(lblProducto);
		
		txtCodPro = new JTextField();
		txtCodPro.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtCodPro.setColumns(10);
		txtCodPro.setBounds(114, 166, 100, 17);
		pnVenta.add(txtCodPro);
		
		lblCodigoDeProducto = new JLabel("");
		lblCodigoDeProducto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblCodigoDeProducto.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblCodigoDeProducto.setBounds(10, 46, 331, 100);
		pnVenta.add(lblCodigoDeProducto);
		
		button_4 = new JButton("");
		button_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_4.addActionListener(this);
		
		button_4.setBounds(228, 165, 31, 24);
		ImageIcon icoBuscar1=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscar1=new ImageIcon(icoBuscar1.getImage().getScaledInstance(button_4.getWidth(), button_4.getHeight(), Image.SCALE_SMOOTH));
		button_4.setIcon(imgBuscar1);
		pnVenta.add(button_4);
		
		txtNomPro = new JTextField();
		txtNomPro.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtNomPro.setColumns(10);
		txtNomPro.setBounds(269, 166, 151, 17);
		pnVenta.add(txtNomPro);
		
		txtPrecioPro = new JTextField();
		txtPrecioPro.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtPrecioPro.setColumns(10);
		txtPrecioPro.setBounds(430, 166, 100, 17);
		pnVenta.add(txtPrecioPro);
		
		txtStockPro = new JTextField();
		txtStockPro.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtStockPro.setColumns(10);
		txtStockPro.setBounds(556, 166, 100, 17);
		pnVenta.add(txtStockPro);
		
		lblCantidad_1 = new JLabel("Cantidad");
		lblCantidad_1.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblCantidad_1.setBounds(32, 197, 74, 17);
		pnVenta.add(lblCantidad_1);
		
		txtCantidadPro = new JTextField();
		txtCantidadPro.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtCantidadPro.setColumns(10);
		txtCantidadPro.setBounds(114, 194, 100, 17);
		pnVenta.add(txtCantidadPro);
		
		button = new JButton("");
		
		button.setBounds(296, 194, 31, 24);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icoAgregar=new ImageIcon(getClass().getResource("/img/add_icon-icons.com_74429.png"));
		ImageIcon imgAgregar=new ImageIcon(icoAgregar.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH));
		button.setIcon(imgAgregar);
		pnVenta.add(button);
		
		lblAgregarProducto = new JLabel("Agregar Producto");
		lblAgregarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarProducto.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblAgregarProducto.setBounds(337, 194, 128, 24);
		pnVenta.add(lblAgregarProducto);
		
		label_4 = new JLabel("");
		label_4.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		label_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		label_4.setBounds(10, 145, 667, 83);
		pnVenta.add(label_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 232, 667, 148);
		pnVenta.add(scrollPane);
		
		tblVenta = new JTable();
		model.addColumn("Codigo Prod.");
		model.addColumn("Descripcion");
		model.addColumn("Precio");
		model.addColumn("Cantidad");
		model.addColumn("Importe");
		tblVenta.setModel(model);
		tblVenta.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblVenta);
		
		btnVentaNueva = new JButton("Venta nueva");
		btnVentaNueva.setForeground(Color.BLACK);
		btnVentaNueva.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		btnVentaNueva.setBounds(10, 394, 140, 24);
		pnVenta.add(btnVentaNueva);
		
		lblDni = new JLabel("Dni");
		lblDni.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblDni.setBounds(32, 77, 74, 17);
		pnVenta.add(lblDni);
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_3) {
			actionPerformedButton_3(e);
		}
		if (e.getSource() == button_4) {
			actionPerformedButton_4(e);
		}
	}
	protected void actionPerformedButton_4(ActionEvent e) {
		DlgProducto pro=new DlgProducto();
		pro.setVisible(true);
		pro.setLocationRelativeTo(this);
	}
	protected void actionPerformedButton_3(ActionEvent e) {
		DlgCliente cli=new DlgCliente();
		cli.setVisible(true);
		cli.setLocationRelativeTo(this);
	}
}
