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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Hilos.HiloHora;
import Hilos.HiloHoraVenta;
import controlador.GestionVentasDAO;
import entidad.CabeceraVenta;
import entidad.DetalleVenta;

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
	public static JTextField txtId;
	private JLabel lblCajeroDeTurno;
	private JLabel lblNombreDeCajero;
	public static JLabel lblHora;
	private JSeparator separator;
	private JLabel lblMonto;
	private JButton btnNewButton;
	private JLabel label_1;
	private JButton button_3;
	public static JTextField txtNombre;
	private JLabel lblNroBoleta;
	private JTextField txtNroBoleta;
	private JLabel lblFecha;
	private JTextField txtFecha;
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
	GestionVentasDAO gv=new GestionVentasDAO();
	ArrayList<DetalleVenta>detVenta=new ArrayList<DetalleVenta>();
	private JLabel lblDni;
	public static double importeTotal;
	private JLabel lblCaja;
	private JLabel lblNroCaja;
	private JLabel lblS;
	public static JTextField txtDNI;
	private JLabel lblStock;
	private JButton btnBorrarProducto;
	int fila;
	private JButton button_1;
	private JLabel lblBorrarProducto;
	public static String numBol;
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
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtId.setColumns(10);
		txtId.setBounds(85, 76, 21, 21);
		pnVenta.add(txtId);
		
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
		lblHora.setBounds(517, 440, 160, 29);
		pnVenta.add(lblHora);
		
		separator = new JSeparator();
		separator.setBackground(Color.RED);
		separator.setBounds(0, 440, 687, 11);
		pnVenta.add(separator);
		
		lblMonto = new JLabel("S/.0.00");
		lblMonto.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblMonto.setBounds(557, 391, 120, 29);
		pnVenta.add(lblMonto);
		
		btnNewButton = new JButton("COBRAR");
		btnNewButton.addActionListener(this);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		btnNewButton.setBounds(430, 384, 106, 45);
		pnVenta.add(btnNewButton);
		
		lblVentaDeProductos = new JLabel("VENTA DE PRODUCTOS");
		lblVentaDeProductos.setBounds(228, 6, 237, 29);
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
		txtNombre.setEditable(false);
		
		txtNombre.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(114, 109, 150, 20);
		pnVenta.add(txtNombre);
		
		lblNroBoleta = new JLabel("Nro. Boleta");
		lblNroBoleta.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblNroBoleta.setBounds(376, 77, 74, 17);
		pnVenta.add(lblNroBoleta);
		
		txtNroBoleta = new JTextField();
		txtNroBoleta.setEditable(false);
		txtNroBoleta.setText(generarNroBoleta());
		txtNroBoleta.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtNroBoleta.setColumns(10);
		txtNroBoleta.setBounds(460, 73, 100, 21);
		pnVenta.add(txtNroBoleta);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblFecha.setBounds(376, 115, 74, 17);
		pnVenta.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setText(fechaActual());
		txtFecha.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtFecha.setColumns(10);
		txtFecha.setBounds(460, 112, 100, 20);
		pnVenta.add(txtFecha);
		
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
		txtCodPro.setEditable(false);
		txtCodPro.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtCodPro.setColumns(10);
		txtCodPro.setBounds(321, 167, 21, 17);
		pnVenta.add(txtCodPro);
		
		button_4 = new JButton("");
		button_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_4.addActionListener(this);
		
		button_4.setBounds(280, 163, 31, 24);
		ImageIcon icoBuscar1=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscar1=new ImageIcon(icoBuscar1.getImage().getScaledInstance(button_4.getWidth(), button_4.getHeight(), Image.SCALE_SMOOTH));
		button_4.setIcon(imgBuscar1);
		pnVenta.add(button_4);
		
		txtNomPro = new JTextField();
		txtNomPro.setEditable(false);
		txtNomPro.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtNomPro.setColumns(10);
		txtNomPro.setBounds(114, 167, 151, 19);
		pnVenta.add(txtNomPro);
		
		txtPrecioPro = new JTextField();
		txtPrecioPro.setEditable(false);
		txtPrecioPro.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtPrecioPro.setColumns(10);
		txtPrecioPro.setBounds(396, 167, 74, 19);
		pnVenta.add(txtPrecioPro);
		
		txtStockPro = new JTextField();
		txtStockPro.setEditable(false);
		txtStockPro.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtStockPro.setColumns(10);
		txtStockPro.setBounds(560, 167, 66, 19);
		pnVenta.add(txtStockPro);
		
		lblCantidad_1 = new JLabel("Cantidad");
		lblCantidad_1.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblCantidad_1.setBounds(32, 197, 74, 17);
		pnVenta.add(lblCantidad_1);
		
		txtCantidadPro = new JTextField();
		txtCantidadPro.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		txtCantidadPro.setColumns(10);
		txtCantidadPro.setBounds(114, 197, 48, 20);
		pnVenta.add(txtCantidadPro);
		
		button = new JButton("");
		button.addActionListener(this);
		
		button.setBounds(180, 194, 31, 24);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icoAgregar=new ImageIcon(getClass().getResource("/img/add_icon-icons.com_74429.png"));
		ImageIcon imgAgregar=new ImageIcon(icoAgregar.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH));
		button.setIcon(imgAgregar);
		pnVenta.add(button);
		
		lblAgregarProducto = new JLabel("Agregar Producto");
		lblAgregarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarProducto.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblAgregarProducto.setBounds(210, 194, 128, 24);
		pnVenta.add(lblAgregarProducto);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 244, 667, 136);
		pnVenta.add(scrollPane);
		
		tblVenta = new JTable();
		tblVenta.addMouseListener(this);
		model.addColumn("Codigo Prod.");
		model.addColumn("Id Vendedor");
		model.addColumn("Descripcion");
		model.addColumn("Precio");
		model.addColumn("Cantidad");
		model.addColumn("Importe");
		tblVenta.setModel(model);
		tblVenta.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblVenta);
		
		btnVentaNueva = new JButton("Venta nueva");
		btnVentaNueva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVentaNueva.addActionListener(this);
		btnVentaNueva.setForeground(Color.BLACK);
		btnVentaNueva.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		btnVentaNueva.setBounds(10, 394, 140, 24);
		pnVenta.add(btnVentaNueva);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblDni.setBounds(32, 77, 74, 17);
		pnVenta.add(lblDni);
		
		lblCodigoDeProducto = new JLabel("");
		lblCodigoDeProducto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblCodigoDeProducto.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblCodigoDeProducto.setBounds(10, 46, 331, 100);
		pnVenta.add(lblCodigoDeProducto);
		
		lblCaja = new JLabel("CAJA");
		lblCaja.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblCaja.setBounds(320, 440, 41, 29);
		pnVenta.add(lblCaja);
		
		lblNroCaja = new JLabel("1");
		lblNroCaja.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblNroCaja.setBounds(365, 440, 41, 29);
		pnVenta.add(lblNroCaja);
		
		lblS = new JLabel("S/.");
		lblS.setBounds(376, 168, 21, 14);
		pnVenta.add(lblS);
		
		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setBounds(114, 76, 86, 20);
		pnVenta.add(txtDNI);
		txtDNI.setColumns(10);
		
		lblStock = new JLabel("Disponible:");
		lblStock.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblStock.setBounds(480, 167, 74, 17);
		pnVenta.add(lblStock);
		
		btnBorrarProducto = new JButton("Borrar Productos");
		btnBorrarProducto.addActionListener(this);
		btnBorrarProducto.setForeground(Color.BLACK);
		btnBorrarProducto.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		btnBorrarProducto.setBounds(160, 394, 160, 24);
		pnVenta.add(btnBorrarProducto);
		
		button_1 = new JButton("");
		button_1.addActionListener(this);
		button_1.setBounds(375, 197, 31, 24);
		ImageIcon icoBorrar=new ImageIcon(getClass().getResource("/img/1486504830-delete-dustbin-empty-recycle-recycling-remove-trash_81361 (1).png"));
		ImageIcon imgBorrar=new ImageIcon(icoBorrar.getImage().getScaledInstance(button_1.getWidth(), button_1.getHeight(), Image.SCALE_SMOOTH));
		button_1.setIcon(imgBorrar);
		pnVenta.add(button_1);
		
		lblBorrarProducto = new JLabel("Borrar Producto");
		lblBorrarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrarProducto.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblBorrarProducto.setBounds(406, 195, 128, 24);
		pnVenta.add(lblBorrarProducto);
		
		label_4 = new JLabel("");
		label_4.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		label_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		label_4.setBounds(10, 145, 667, 91);
		pnVenta.add(label_4);
		setUndecorated(true);
		setBounds(0,0,687,480);
		setLocationRelativeTo(null);
		mostrarHora();
		txtId.setVisible(false);
		txtCodPro.setVisible(false);
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblVenta) {
			mouseClickedTblVenta(arg0);
		}
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
		if (e.getSource() == button_1) {
			actionPerformedButton_1(e);
		}
		if (e.getSource() == btnBorrarProducto) {
			actionPerformedBtnBorrarProducto(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnVentaNueva) {
			actionPerformedBtnVentaNueva(e);
		}
		if (e.getSource() == button) {
			actionPerformedButton(e);
		}
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
	private String leerNomCliente(){
		String nom=null;
		if(txtNombre.getText().trim().length()==0)alerta("Campo Nombre de Cliente Vacio");
		else nom=txtNombre.getText().trim();
		return nom;
	} 
	private int leerIdCliente(){
		int id=-1;
		try {
			if(txtId.getText().trim().length()==0) {
				alerta("Campo Id Cliente Vacio");
			}
			else id =  Integer.parseInt(txtId.getText().trim());
		} catch (NumberFormatException e) {
			alerta("ID Cliente:Formato Incorrecto");
		}
		return id;
	}
	private int leerIdProducto(){
		int id=-1;
		try {
			if(txtCodPro.getText().trim().length()==0) {
				alerta("Campo Id Producto Vacio");
			}
			else id =  Integer.parseInt(txtCodPro.getText().trim());
		} catch (NumberFormatException e) {
			alerta("ID Producto:Formato Incorrecto");
		}
		return id;
	}
	private String leerDesProducto(){
		String des=null;
		if(txtNomPro.getText().trim().length()==0)alerta("Campo Desc. Producto Vacio");
		else des = txtNomPro.getText().trim();
		return des;
	}
	private int leerStockProducto(){
		int stck=0;
		try {
			if(txtStockPro.getText().trim().length()==0)alerta("Campo Stock Producto Vacio");
			else stck =  Integer.parseInt(txtStockPro.getText().trim());
		} catch (NumberFormatException e) {
			alerta("Stock Producto:Formato Incorrecto");
		}
		return stck;
	}
	private double leerPrecioProducto(){
		double precio=0;
		try {
			if(txtPrecioPro.getText().trim().length()==0){
				alerta("Campo Precio Producto Vacio");
			}else{
				precio = Double.parseDouble(txtPrecioPro.getText().trim());
			}
		} catch (NumberFormatException e) {
			alerta("Precio Producto: Formato Incorrecto");
		}
		return precio;
	}
	private int leerCantidadProducto(){
		int cantidad=0;
		try {
			if(txtCantidadPro.getText().trim().length()==0)alerta("Campo Stock Producto Vacio");
			else cantidad =  Integer.parseInt(txtCantidadPro.getText().trim());
		} catch (NumberFormatException e) {
			alerta("Cantidad Producto:Formato Incorrecto");
		}
		return cantidad;
	}
	private double calcImpCompra(double p, int cant){
		return p*cant;
	}
	private String generarNroBoleta(){
		return gv.generarNroBoleta();
	}
	private int obtenerIdUsuario(){
		return frmLogin.u.getIdUsuario();
	}
	private void alerta(String s){
		JOptionPane.showMessageDialog(this,s,"ALERTA",0);
	}
	private int leerNroCaja(){
		return Integer.parseInt(lblNroCaja.getText().trim());
	}
	private String fechaActual() {
		int dd, mm, aa;
		Calendar c = new GregorianCalendar();
		dd = c.get(Calendar.DAY_OF_MONTH);
		mm = c.get(Calendar.MONTH) + 1;
		aa = c.get(Calendar.YEAR);
		return ajustar(dd) + "/" + ajustar(mm) + "/" + aa;
	}
	private String ajustar(int numero) {
		return String.format("%02d", numero);
	}
	private void agregarProductos() {
		int idUsuario=obtenerIdUsuario(),idCliente=leerIdCliente(),cant=leerCantidadProducto(),stock=leerStockProducto(),codProd=leerIdProducto();
		double precio=leerPrecioProducto(),importe=calcImpCompra(precio,cant);
		String descripcion=leerDesProducto(),nomCliente=leerNomCliente();
		numBol = generarNroBoleta();
		if(cant>stock){
			alerta("Stock insuficiente");
			return;
		}
		if(idCliente==0||nomCliente==null||cant==0||stock==0||codProd==0||precio==0||descripcion==null){
			alerta("Error: No se pudo agregar producto!");
		}else{
		Object fila[]={
				codProd,idUsuario,descripcion,precio,cant,String.format( "%.2f",importe)
		};
		model.addRow(fila);
		importeTotal+=importe;
		lblMonto.setText("s/. "+String.format( "%.2f", importeTotal));
		txtCantidadPro.setText("");
		txtCantidadPro.requestFocus();
		
		}
		//agregar datos a la clase detalle boleta
		DetalleVenta d=new DetalleVenta(cant, codProd, precio, numBol);	
		detVenta.add(d);
	}
	private void finalizarCompra() {
		String numBol = generarNroBoleta();
		int idCliente = leerIdCliente();
		int idUsuario = obtenerIdUsuario();
		int idCaja = leerNroCaja();
		double total_bol = importeTotal;
		
		if(idCliente == -1) {
			alerta("Seleccione un Cliente");
			return;
		}
		if(leerIdProducto() == -1) {
			alerta("Seleccione un Producto");
			return;
		}
		
		if(tblVenta.getRowCount() == 0) {
			alerta("Debe Registrar 1 pedido como mínimo");
			return;
		}
			
		int n = JOptionPane.showConfirmDialog(this,"¿Desea confirmar esta operación?","SISTEMA", JOptionPane.YES_NO_OPTION,1);
		
		if(n == 0){
			CabeceraVenta cabVenta=new CabeceraVenta(idCliente, idCaja,idUsuario , total_bol, null, numBol);
			
			int ok=gv.realizarVenta(cabVenta, detVenta);
			DlgResumenVenta drv=new DlgResumenVenta();
			drv.setVisible(true);
			drv.setLocationRelativeTo(this);
			if(ok==0){
				alerta("Error en la venta");
			}else{
				mensaje("Venta exitosa!");
				nuevaVenta();
			}
		}
		

		
	}
	private void borrarProductos(){
		int rowCount = model.getRowCount();
		if(rowCount==0){
			alerta("No hay productos a eliminar");
		}else{
		for (int i = rowCount - 1; i >= 0; i--)
			if(i==-1){
				alerta("No hay productos para eliminar");
			}else{
		    model.removeRow(i);
	}}}
	private void borrarProducto(int f){
		model.removeRow(f);
	}

	private void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
		
	}
	protected void actionPerformedButton(ActionEvent e) {
		agregarProductos();
	}
	private void nuevaVenta(){
		txtId.setText("");
		txtNombre.setText("");
		txtDNI.setText("");
		txtNroBoleta.setText(generarNroBoleta());
		txtCodPro.setText("");
		txtNomPro.setText("");
		txtStockPro.setText("");
		txtPrecioPro.setText("");
		txtCantidadPro.setText("");
		model.setRowCount(0);
		lblMonto.setText("S/.0.00");
	}
	protected void actionPerformedBtnVentaNueva(ActionEvent e) {
		
		nuevaVenta();
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		finalizarCompra();
	}
	public void mostrarHora(){
		HiloHoraVenta hora=new HiloHoraVenta();
		hora.start();
	}
	protected void actionPerformedBtnBorrarProducto(ActionEvent e) {
		
		int ok = confirmacion();
		if(ok==0){
		borrarProductos();
		}
		else{
			return;
		}
	}
	protected void mouseClickedTblVenta(MouseEvent arg0) {
		fila = tblVenta.getSelectedRow();
	}
	protected void actionPerformedButton_1(ActionEvent e) {
		try{
		if(fila==0){
			alerta("Debe seleccionar un producto a eliminar");
		}else{
		borrarProducto(fila);
		}}catch(NullPointerException ex){
			alerta("No hay productos para eliminar");
		}
	}
	int confirmacion(){
		return JOptionPane.showConfirmDialog(this,"¿Seguro de Borrar todos los productos?","SISTEMA",JOptionPane.YES_NO_OPTION);
	}
}
