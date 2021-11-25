package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controlador.GestionCategoriaDAO;
import controlador.GestionProductoDAO;
import entidad.Categoria;
import entidad.Producto;
import entidad.Usuario;
import entidad.UsuarioXTipo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class frmInventario extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	int xMouse, yMouse;
	private JLabel lblFlecha;
	private JLabel lblInventario;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable tblInventario;
	private Button button;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private Button button_1;
	private Button button_2;
	private Button button_3;
	private JLabel lblBuscarPorCodigo;
	private JTextField txtCodigo;
	private JLabel label_2;
	GestionProductoDAO gp=new GestionProductoDAO();
	GestionCategoriaDAO gc=new GestionCategoriaDAO();
	Categoria c=new Categoria();
	Producto p=new Producto();
	DefaultTableModel model=new DefaultTableModel();
	private JComboBox cboInventario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmInventario dialog = new frmInventario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmInventario() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBounds(0,0,687,480);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblFlecha = new JLabel("");
		lblFlecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFlecha.addMouseListener(this);
		lblFlecha.setIcon(new ImageIcon(frmInventario.class.getResource("/img/leftarrow_theapplication_izquierda_4435.png")));
		lblFlecha.setBounds(645, 11, 32, 30);
		lblFlecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(lblFlecha);
		
		lblInventario = new JLabel("INVENTARIO");
		lblInventario.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventario.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblInventario.setBounds(269, 11, 149, 30);
		panel.add(lblInventario);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 47, 687, 341);
		panel_1.setBackground(new Color(193, 18, 5));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0,0,0)));
		scrollPane.setBounds(0, 35, 687, 268);
		panel_1.add(scrollPane);
		
		tblInventario = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int columnIndex){
				return false;}
		};
		model.addColumn("ID Producto");
		model.addColumn("Nombre");
		model.addColumn("Stock");
		model.addColumn("Precio");
		model.addColumn("Categoria");
		model.addColumn("Proveedor");
		tblInventario.setModel(model);
		scrollPane.setViewportView(tblInventario);
		
		button = new Button("Actualizar Tabla");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Roboto Medium", Font.BOLD, 14));
		button.setBounds(252, 309, 177, 22);
		panel_1.add(button);
		
		lblBuscarPorCodigo = new JLabel("BUSCAR POR CODIGO");
		lblBuscarPorCodigo.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblBuscarPorCodigo.setForeground(Color.WHITE);
		lblBuscarPorCodigo.setBounds(10, 10, 177, 14);
		panel_1.add(lblBuscarPorCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		txtCodigo.setBounds(197, 10, 188, 19);
		panel_1.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		label_2 = new JLabel("");
		label_2.addMouseListener(this);
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setBounds(395, 10, 30, 22);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscar=new ImageIcon(icoBuscar.getImage().getScaledInstance(label_2.getWidth(), label_2.getHeight(), Image.SCALE_SMOOTH));
		label_2.setIcon(imgBuscar);
		panel_1.add(label_2);
		
		cboInventario = new JComboBox();
		cboInventario.addActionListener(this);
		cboInventario.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		cboInventario.setBounds(465, 10, 212, 19);
		panel_1.add(cboInventario);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(frmInventario.class.getResource("/img/add_icon-icons.com_74429.png")));
		lblNewLabel.setBounds(53, 399, 65, 43);
		panel.add(lblNewLabel);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(311, 399, 65, 43);
		ImageIcon icoMod=new ImageIcon(getClass().getResource("/img/pen_edit_modify_pencil_icon_181536 (1).png"));
		ImageIcon imgMod=new ImageIcon(icoMod.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
		label.setIcon(imgMod);
		panel.add(label);
		
		label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(565, 399, 65, 43);
		ImageIcon icoElim=new ImageIcon(getClass().getResource("/img/1486504830-delete-dustbin-empty-recycle-recycling-remove-trash_81361 (1).png"));
		ImageIcon imgElim=new ImageIcon(icoElim.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_SMOOTH));
		label_1.setIcon(imgElim);
		panel.add(label_1);
		
		button_1 = new Button("Agregar un Producto");
		button_1.addActionListener(this);
		button_1.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setBounds(24, 448, 132, 22);
		panel.add(button_1);
		
		button_2 = new Button("Modificar un Producto");
		button_2.addActionListener(this);
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		button_2.setBounds(274, 448, 132, 22);
		panel.add(button_2);
		
		button_3 = new Button("Eliminar Producto");
		button_3.addActionListener(this);
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		button_3.setBounds(530, 448, 132, 22);
		panel.add(button_3);
		setUndecorated(true);
		setBounds(0,0,687,480);
		setLocationRelativeTo(null);
		listarProductos();
		cargarComboEquipo();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == label_2) {
			mouseClickedLabel_2(e);
		}
		if (e.getSource() == lblFlecha) {
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
		xMouse =  e.getX();
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
		frmPrincipalEmp pri=new frmPrincipalEmp();
		pri.setVisible(true);
		pri.setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboInventario) {
			actionPerformedCboInventario(arg0);
		}
		if (arg0.getSource() == button_3) {
			actionPerformedButton_3(arg0);
		}
		if (arg0.getSource() == button_2) {
			actionPerformedButton_2(arg0);
		}
		if (arg0.getSource() == button_1) {
			actionPerformedButton_1(arg0);
		}
	}
	protected void actionPerformedButton_1(ActionEvent arg0) {
		frmAddProduct add=new frmAddProduct();
		add.setVisible(true);
		add.setLocationRelativeTo(null);
	}
	protected void actionPerformedButton_2(ActionEvent arg0) {
		frmModProduct mod=new frmModProduct();
		mod.setVisible(true);
		mod.setLocationRelativeTo(null);
	}
	protected void actionPerformedButton_3(ActionEvent arg0) {
		frmEliminarProduct elim=new frmEliminarProduct();
		elim.setVisible(true);
		elim.setLocationRelativeTo(null);
		
	}
	private int leerCodigo(){
		int id=0;
		try{
		if(txtCodigo.getText().trim().length()==0){
			alerta("Campo Codigo Vacio");}
		else{
			id = Integer.parseInt(txtCodigo.getText().trim());
		}
		}catch(NumberFormatException e){
			alerta("Solo se aceptan numeros");
		}
		return id;
	}
	private int leerCategoria(){
		return cboInventario.getSelectedIndex();
	}
	private void alerta(String s){
		JOptionPane.showMessageDialog(null, s,"ALERTA",2);
	}
	private void listarProductos(){
		ArrayList<Producto>listar=gp.listarProductos();
		model.setRowCount(0);
		if(listar.size()==0){
			alerta("Lista Vacia");
		}else{
			for(Producto p:listar){
				Object[]fila={
						p.getIdProducto(),
						p.getNombre(),
						p.getCantidad(),
						"s/. " + p.getPrecio(),
						p.getDes_categoria(),
						p.getDes_proveedor()
				};
				model.addRow(fila);
			}
		}
	}
	void listarXIdProducto(int id){
		model.setRowCount(0);
		ArrayList<Producto>listar = gp.listarXIdPro(id);
		if(listar.size()==0){
			alerta("Producto no Existe");
			listarProductos();
		}else{
			for(Producto p: listar){
			Object[] fila={
					p.getIdProducto(),
					p.getNombre(),
					p.getCantidad(),
					"s/. " + p.getPrecio(),
					p.getDes_categoria(),
					p.getDes_proveedor()
			};
			model.addRow(fila);
		}
			}
	}
	void listarXCategoria(int idCat){
		model.setRowCount(0);
		ArrayList<Producto>listar = gp.listarXCat(idCat);
		if(listar.size()==0){
			alerta("Producto no Existe");
			listarProductos();
		}else{
			for(Producto p: listar){
			Object[] fila={
					p.getIdProducto(),
					p.getNombre(),
					p.getCantidad(),
					"s/. " + p.getPrecio(),
					p.getDes_categoria()
			};
			cboInventario.setSelectedIndex(0);
			model.addRow(fila);
		}
			}
		
	}
	protected void mouseClickedLabel_2(MouseEvent e) {
		listarXIdProducto(leerCodigo());
	}
	void cargarComboEquipo() {
		ArrayList<Categoria> cbo = gc.listar();
		cboInventario.addItem("Selecione Tipo ");
		for (Categoria c : cbo) {
		cboInventario.addItem(c.getDes_categoria());
	}	
	}
	private void listarXCat(){
		int id = leerCategoria();
		switch (id) {
		case 1: listarXCategoria(id);break;
		case 2: listarXCategoria(id);break;
		case 3: listarXCategoria(id);break;
		case 4: listarXCategoria(id);break;
		case 5: listarXCategoria(id);break;
		case 6: listarXCategoria(id);break;
		case 7: listarXCategoria(id);break;
		case 8: listarXCategoria(id);break;
		case 9: listarXCategoria(id);break;
		default:
			break;
		}
	}
	protected void actionPerformedCboInventario(ActionEvent arg0) {
		listarXCat();
	}
}
