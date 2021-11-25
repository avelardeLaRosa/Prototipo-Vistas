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
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import controlador.GestionCategoriaDAO;
import controlador.GestionProductoDAO;
import controlador.GestionProveedorDAO;
import entidad.Categoria;
import entidad.Producto;
import entidad.Proveedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

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
	private JTextField txtNombre;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JLabel lblNuevoProducto;
	private JButton btnNewButton;
	private JComboBox cboCategoria;
	GestionCategoriaDAO gc=new GestionCategoriaDAO();
	GestionProductoDAO gp=new GestionProductoDAO();
	GestionProveedorDAO gpro=new GestionProveedorDAO();
	private JTextField textField;
	private JLabel lblProveedor;
	private JComboBox cboProveedor;
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
		lblCodigo.setBounds(27, 60, 96, 26);
		panel_1.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblNombre.setBounds(27, 97, 96, 29);
		panel_1.add(lblNombre);
		
		lblPrecioVenta = new JLabel("Stock");
		lblPrecioVenta.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblPrecioVenta.setBounds(27, 137, 96, 27);
		panel_1.add(lblPrecioVenta);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblPrecio.setBounds(27, 175, 96, 24);
		panel_1.add(lblPrecio);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCategoria.setBounds(27, 210, 96, 26);
		panel_1.add(lblCategoria);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtNombre.setColumns(10);
		txtNombre.setBounds(169, 97, 168, 26);
		panel_1.add(txtNombre);
		
		txtStock = new JTextField();
		txtStock.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtStock.setColumns(10);
		txtStock.setBounds(169, 137, 168, 26);
		panel_1.add(txtStock);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(169, 175, 168, 26);
		panel_1.add(txtPrecio);
		
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
		
		cboCategoria = new JComboBox();
		cboCategoria.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		cboCategoria.setBounds(169, 210, 168, 26);
		panel_1.add(cboCategoria);
		
		textField = new JTextField();
		textField.setText("AUTOGENERADO");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.DARK_GRAY);
		textField.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(169, 60, 168, 26);
		panel_1.add(textField);
		
		lblProveedor = new JLabel("Proveedor");
		lblProveedor.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblProveedor.setBounds(27, 247, 96, 26);
		panel_1.add(lblProveedor);
		
		cboProveedor = new JComboBox();
		cboProveedor.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		cboProveedor.setBounds(169, 247, 168, 26);
		panel_1.add(cboProveedor);
		setUndecorated(true);
		setBounds(0,0,450,350);
		setLocationRelativeTo(null);
		cargarComboCategoria();
		cargarComboProveedor();
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
		registrarProducto();
	}
	
	void cargarComboCategoria() {
		ArrayList<Categoria> cbo = gc.listar();
		cboCategoria.addItem("Selecione Categoria ");
		for (Categoria c : cbo) {
		cboCategoria.addItem(c.getDes_categoria());
	}	
	}
	void cargarComboProveedor() {
		ArrayList<Proveedor> cbo = gpro.listarProveedor();
		cboProveedor.addItem("Selecione Proveedor ");
		for (Proveedor pro : cbo) {
		cboProveedor.addItem(pro.getNombre());
	}	
	}
	/*private int leerCodigo(){
		int cod=0;
		try{
		if(txtCodigo.getText().trim().length()==0){
			alerta("Campo Codigo Vacio");
		}else{
			cod = Integer.parseInt(txtCodigo.getText().trim());
		}}catch(NumberFormatException e){
			alerta("CODIGO, solo numeros!");
		}
		return cod;
	}*/
	private String leerNombre(){
		String nom=null;
		if(txtNombre.getText().trim().length()==0){
			alerta("Campo Nombre Vacio");
		}else{
			nom = txtNombre.getText().trim();
		}
		return nom;
	}
	private int leerStock(){
		int st=0;
		try {
			if(txtStock.getText().trim().length()==0){
				alerta("Campo Stock Vacio");
			}else{
				st = Integer.parseInt(txtStock.getText().trim());
			}
		} catch (NumberFormatException e) {
			alerta("STOCK, solo numeros!");
		}
		return st;
	}
	private int leerCbo(){
		int cbo=0;
		if(cboCategoria.getSelectedIndex()==0){
			alerta("Campo Categoria Vacio");
		}else{
			cbo = cboCategoria.getSelectedIndex();
		}
		return cbo;
	}
	private int leerCboPro(){
		int cbo=0;
		if(cboProveedor.getSelectedIndex()==0){
			alerta("Campo Proveedor Vacio");
		}else{
			cbo = cboProveedor.getSelectedIndex();
		}
		return cbo;
	}
	private double leerPrecio(){
		double pre = 0;
		try{
		if(txtPrecio.getText().trim().length()==0){
			alerta("Campo Precio Vacio");
		}else{
			pre = Double.parseDouble(txtPrecio.getText().trim());
		}}catch(NumberFormatException e){
			alerta("PRECIO, solo numeros");
		}
		return pre;
	}
	private void registrarProducto(){
		int /*cod=leerCodigo(),*/
				stck=leerStock(),cbo=leerCbo(),cboPro=leerCboPro();
		double precio=leerPrecio();
		String nom=leerNombre();
		
		if(/*cod==0||*/nom==null||stck==0||cbo==0||precio==0||cboPro==0){
			alerta("No se registro producto");
		}else{
			Producto p=new Producto();
			/*p.setIdCategoria(cod);*/
			p.setNombre(nom);
			p.setCantidad(stck);
			p.setPrecio(precio);
			p.setIdCategoria(cbo);
			p.setIdProveedor(cboPro);
			int ok = gp.registar(p);
			if(ok==0){
				alerta("Error en el resgistro");
			}else{
				mensaje("Registro Exitoso");
			}
		}
	}
	private void alerta(String cad){
		JOptionPane.showMessageDialog(null,cad,"ALERTA",2);
	}
	private void mensaje(String s){
		JOptionPane.showMessageDialog(null,s);
	}
}
