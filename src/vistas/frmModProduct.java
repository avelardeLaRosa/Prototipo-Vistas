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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import controlador.GestionCategoriaDAO;
import controlador.GestionProductoDAO;
import controlador.GestionProveedorDAO;
import entidad.Categoria;
import entidad.Producto;
import entidad.Proveedor;
import entidad.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmModProduct extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	int xMouse, yMouse;
	private JPanel panel_1;
	private JLabel lblModificaProductor;
	private JLabel label;
	private JPanel panel_2;
	private JLabel lblCodigoDeProducto;
	private JTextField txtCodProducto;
	private JLabel lblNewLabel;
	private JButton btnGuardarCambios;
	private JLabel label_1;
	private JTextField txtNombre;
	private JLabel label_2;
	private JTextField txtStock;
	private JLabel label_3;
	private JTextField txtPrecio;
	private JLabel label_4;
	private JComboBox cboCategoria;
	private JLabel label_5;
	private JComboBox cboProveedor;
	GestionProductoDAO gp=new GestionProductoDAO();
	GestionCategoriaDAO gc=new GestionCategoriaDAO();
	GestionProveedorDAO gpro=new GestionProveedorDAO();
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
		
		txtCodProducto = new JTextField();
		txtCodProducto.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtCodProducto.setColumns(10);
		txtCodProducto.setBounds(179, 12, 168, 26);
		panel_2.add(txtCodProducto);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(this);
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setBounds(357, 11, 31, 29);
		panel_2.add(lblNewLabel);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscar=new ImageIcon(icoBuscar.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(imgBuscar);
		
		btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
		btnGuardarCambios.addActionListener(this);
		btnGuardarCambios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardarCambios.setIcon(null);
		btnGuardarCambios.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnGuardarCambios.setBounds(132, 298, 188, 41);
		panel_1.add(btnGuardarCambios);
		
		label_1 = new JLabel("Nombre");
		label_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_1.setBounds(48, 111, 96, 29);
		panel_1.add(label_1);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtNombre.setColumns(10);
		txtNombre.setBounds(190, 111, 168, 26);
		panel_1.add(txtNombre);
		
		label_2 = new JLabel("Stock");
		label_2.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_2.setBounds(48, 151, 96, 27);
		panel_1.add(label_2);
		
		txtStock = new JTextField();
		txtStock.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtStock.setColumns(10);
		txtStock.setBounds(190, 151, 168, 26);
		panel_1.add(txtStock);
		
		label_3 = new JLabel("Precio");
		label_3.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_3.setBounds(48, 189, 96, 24);
		panel_1.add(label_3);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(190, 189, 168, 26);
		panel_1.add(txtPrecio);
		
		label_4 = new JLabel("Categoria");
		label_4.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_4.setBounds(48, 224, 96, 26);
		panel_1.add(label_4);
		
		cboCategoria = new JComboBox();
		cboCategoria.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		cboCategoria.setBounds(190, 224, 168, 26);
		panel_1.add(cboCategoria);
		
		label_5 = new JLabel("Proveedor");
		label_5.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_5.setBounds(48, 261, 96, 26);
		panel_1.add(label_5);
		
		cboProveedor = new JComboBox();
		cboProveedor.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		cboProveedor.setBounds(190, 261, 168, 26);
		panel_1.add(cboProveedor);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
		cargarComboCategoria();
		cargarComboProveedor();
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblNewLabel) {
			mouseClickedLblNewLabel(e);
		}
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
	private int leerCodigo(){
	int cod=0;
	try{
	if(txtCodProducto.getText().trim().length()==0){
		alerta("Campo Codigo Vacio");
	}else{
		cod = Integer.parseInt(txtCodProducto.getText().trim());
	}}catch(NumberFormatException e){
		alerta("CODIGO, solo numeros!");
	}
	return cod;
	}
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
	private void modificarProducto(){
		int cod=leerCodigo(),
		stck=leerStock(),cbo=leerCbo(),cboPro=leerCboPro();
		double precio=leerPrecio();
		String nom=leerNombre();
		
		if(cod==0||stck==0||cbo==0||cboPro==0||precio==0||nom==null){
			alerta("No se actualizo usuario !");
		}else{
			Producto p=new Producto();
			p.setIdProducto(cod);
			p.setNombre(nom);
			p.setCantidad(stck);
			p.setPrecio(precio);
			p.setIdCategoria(cbo);
			p.setIdProveedor(cboPro);
			int ok = gp.actualizar(p);
			if(ok==0){
				alerta("Error al actualizar usuario !");
				limpiarCampos();
			}else{
				mensaje("Actualizacion Exitosa !");
				limpiarCampos();
				
			}	
		}
	}
	private void listarCampos(int id){
		ArrayList<Producto>listarId=gp.listarXIdPro(id);
		if(listarId.size()==0){
			alerta("Producto no existe !");
		}else{
		for(Producto p: listarId){
			txtCodProducto.setText(String.valueOf(p.getIdProducto()));
			txtCodProducto.setEditable(false);
			txtNombre.requestFocus();
			txtNombre.setText(p.getNombre());
			txtStock.setText(String.valueOf(p.getCantidad()));
			txtPrecio.setText(String.valueOf(p.getPrecio()));
			cboCategoria.setSelectedItem(p.getDes_categoria());
			cboProveedor.setSelectedItem(p.getDes_proveedor());
		}
		}
	}
	private void limpiarCampos(){
		txtCodProducto.setEditable(true);
		txtCodProducto.setText("");
		txtNombre.setText("");
		txtStock.setText("");
		txtPrecio.setText("");
		cboCategoria.setSelectedIndex(0);
		cboProveedor.setSelectedIndex(0);
		
	}
	private void alerta(String cad){
		JOptionPane.showMessageDialog(null,cad,"ALERTA",2);
	}
	private void mensaje(String s){
		JOptionPane.showMessageDialog(null,s);
	}
	protected void mouseClickedLblNewLabel(MouseEvent e) {
		listarCampos(leerCodigo());
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGuardarCambios) {
			actionPerformedBtnGuardarCambios(arg0);
		}
	}
	protected void actionPerformedBtnGuardarCambios(ActionEvent arg0) {
		modificarProducto();
	}
	
}
