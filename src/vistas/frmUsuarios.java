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

import controlador.GestionUsuarioDAO;
import entidad.Usuario;
import entidad.UsuarioXTipo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class frmUsuarios extends JDialog implements MouseListener, ActionListener, KeyListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblSuarios;
	private JLabel label_1;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private Button button;
	private JLabel label_2;
	private JTextField txtCodigo;
	private JLabel label_3;
	private JLabel label_4;
	private Button button_1;
	private Button button_2;
	private JLabel label_5;
	private JLabel label_6;
	private Button button_3;
	DefaultTableModel model=new DefaultTableModel();
	GestionUsuarioDAO gu=new GestionUsuarioDAO();
	private JTable tbUsuario;
	int xMouse,yMouse;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmUsuarios dialog = new frmUsuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmUsuarios() {
		setBounds(0,0,687,480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.addKeyListener(this);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0,0,687,480);
		panel.setBackground(Color.WHITE);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblSuarios = new JLabel("USUARIOS");
		lblSuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuarios.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblSuarios.setBounds(269, 11, 149, 30);
		panel.add(lblSuarios);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(this);
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setIcon(new ImageIcon(frmUsuarios.class.getResource("/img/leftarrow_theapplication_izquierda_4435.png")));
		label_1.setBounds(645, 11, 32, 30);
		panel.add(label_1);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(193, 18, 5));
		panel_1.setBounds(0, 47, 687, 341);
		panel.add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0,0,0)));
		scrollPane.setBounds(0, 35, 687, 268);
		panel_1.add(scrollPane);
		
		tbUsuario = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int columnIndex){
				return false;}
		};
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Usuario");
		model.addColumn("Clave");
		model.addColumn("Fecha Registro");
		model.addColumn("Tipo");
		tbUsuario.setModel(model);
		
		scrollPane.setViewportView(tbUsuario);
		
		button = new Button("Actualizar Tabla");
		button.addActionListener(this);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Roboto Medium", Font.BOLD, 14));
		button.setBounds(252, 309, 177, 22);
		panel_1.add(button);
		
		label_2 = new JLabel("BUSCAR POR CODIGO");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		label_2.setBounds(10, 10, 177, 14);
		panel_1.add(label_2);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(197, 10, 188, 19);
		panel_1.add(txtCodigo);
		
		label_3 = new JLabel("");
		label_3.addMouseListener(this);
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setBounds(395, 10, 30, 22);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscar=new ImageIcon(icoBuscar.getImage().getScaledInstance(label_3.getWidth(), label_3.getHeight(), Image.SCALE_SMOOTH));
		label_3.setIcon(imgBuscar);
		panel_1.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(frmUsuarios.class.getResource("/img/add_icon-icons.com_74429.png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(53, 399, 65, 43);
		panel.add(label_4);
		
		button_1 = new Button("Agregar Nuevo Usuario");
		button_1.addActionListener(this);
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		button_1.setBounds(24, 448, 139, 22);
		panel.add(button_1);
		
		button_2 = new Button("Modificar un Usuario");
		button_2.addActionListener(this);
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		button_2.setBounds(274, 448, 132, 22);
		panel.add(button_2);
		
		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(frmUsuarios.class.getResource("/img/pen_edit_modify_pencil_icon_181536 (1).png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(311, 399, 65, 43);
		panel.add(label_5);
		
		label_6 = new JLabel("");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(565, 399, 65, 43);
		ImageIcon icoBorrar=new ImageIcon(getClass().getResource("/img/1486504830-delete-dustbin-empty-recycle-recycling-remove-trash_81361 (1).png"));
		ImageIcon imgBorrar=new ImageIcon(icoBorrar.getImage().getScaledInstance(label_6.getWidth(), label_6.getHeight(), Image.SCALE_SMOOTH));
		label_6.setIcon(imgBorrar);
		panel.add(label_6);
		
		button_3 = new Button("Eliminar Usuario");
		button_3.addActionListener(this);
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		button_3.setBounds(530, 448, 132, 22);
		panel.add(button_3);
		setUndecorated(true);
		setLocationRelativeTo(null);
		listarUsuario();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == label_3) {
			mouseClickedLabel_3(e);
		}
		if (e.getSource() == label_1) {
			mouseClickedLabel_1(e);
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
	protected void mouseClickedLabel_1(MouseEvent e) {
		frmConfiguracion conf=new frmConfiguracion();
		conf.setVisible(true);
		conf.setLocationRelativeTo(null);
		this.dispose();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
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
		frmAddUsuario addUser=new frmAddUsuario();
		addUser.setVisible(true);
		addUser.setLocationRelativeTo(null);
	}
	protected void actionPerformedButton_2(ActionEvent arg0) {
		frmModUsuario modUser=new frmModUsuario();
		modUser.setVisible(true);
		modUser.setLocationRelativeTo(null);
	}
	protected void actionPerformedButton_3(ActionEvent arg0) {
		frmEliminarUsuario elimUser=new frmEliminarUsuario();
		elimUser.setVisible(true);
		elimUser.setLocationRelativeTo(null);
	}
	void listarUsuario(){
		ArrayList<UsuarioXTipo>listar=gu.listarUsuario();
		model.setRowCount(0);
		if(listar.size()==0){
			error("Lista Vacia");
		}else{
			for(UsuarioXTipo ut:listar){
				Object[]fila={
						ut.getNombre(),
						ut.getApellido(),
						ut.getUsuario(),
						ut.getClave(),
						ut.getFecha_registro(),
						ut.getDes_tipo()
				};
				model.addRow(fila);
			}
		}
	}
	void error(String cad){
		JOptionPane.showMessageDialog(null, cad,"ERROR",2);
	}
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getSource() == panel) {
			keyPressedPanel(arg0);
		}
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void keyPressedPanel(KeyEvent arg0) {
		
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
		this.setLocation(x-xMouse, y-yMouse);
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		//ACTUALIZAR TABLA
		listarUsuario();
	}
	void listarXId(int id){
		model.setRowCount(0);
		ArrayList<Usuario>listar = gu.listarXId(id);
		if(listar.size()==0){
			alerta("Usuario no Existe");
		}else{
			for(Usuario u: listar){
			Object[] fila={
					u.getIdUsuario(),
					u.getNombre(),
					u.getApellido(),
					u.getUsuario(),
					u.getClave(),
					u.getFecha_registro(),
					u.getIdtipo(),
			};
			model.addRow(fila);
		}
			}
	}
	void alerta(String s){
		JOptionPane.showMessageDialog(null,s,"Alerta",2);
	}
	int leerId(){
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
	protected void mouseClickedLabel_3(MouseEvent e) {
		/*LISTAR X ID USUARIO*/
		listarXId(leerId());
	}
}
