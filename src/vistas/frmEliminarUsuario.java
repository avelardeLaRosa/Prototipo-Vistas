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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import entidad.UsuarioXTipo;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;

public class frmEliminarUsuario extends JDialog implements MouseListener, ActionListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblIngreseCodigoO;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField txtCodigo;
	private JLabel label_3;
	private JScrollPane scrollPane;
	private JButton btnEliminar;
	GestionUsuarioDAO gu=new GestionUsuarioDAO();
	DefaultTableModel model=new DefaultTableModel();
	private JTable tblUsuario;
	int xMouse,yMouse;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmEliminarUsuario dialog = new frmEliminarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmEliminarUsuario() {
		setBounds(0, 0, 450, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(193,18,5));
		panel.setBounds(0, 0, 450, 350);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.addMouseMotionListener(this);
		panel_1.addMouseListener(this);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 430, 350);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblIngreseCodigoO = new JLabel("Ingrese Codigo o Seleccione Usuario");
		lblIngreseCodigoO.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseCodigoO.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblIngreseCodigoO.setBounds(34, 25, 352, 26);
		panel_1.add(lblIngreseCodigoO);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(this);
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_SMOOTH));
		label_1.setIcon(imgCerrar);
		panel_1.add(label_1);
		
		label_2 = new JLabel("BUSCAR POR CODIGO");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		label_2.setBounds(10, 132, 172, 22);
		panel_1.add(label_2);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(192, 132, 188, 22);
		panel_1.add(txtCodigo);
		
		label_3 = new JLabel("");
		label_3.addMouseListener(this);
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setBounds(390, 132, 30, 22);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscar=new ImageIcon(icoBuscar.getImage().getScaledInstance(label_3.getWidth(), label_3.getHeight(), Image.SCALE_SMOOTH));
		label_3.setIcon(imgBuscar);
		panel_1.add(label_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0,0,0)));
		scrollPane.setBounds(10, 165, 410, 137);
		panel_1.add(scrollPane);
		
		tblUsuario = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int columnIndex){
				return false;}
		};
		tblUsuario.addMouseListener(this);
		model.addColumn("ID Usuario");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Usuario");
		model.addColumn("Clave");
		model.addColumn("Fecha Registro");
		model.addColumn("Tipo");
		tblUsuario.setModel(model);
		scrollPane.setViewportView(tblUsuario);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnEliminar.setBounds(125, 313, 172, 26);
		panel_1.add(btnEliminar);
		setUndecorated(true);
		setLocationRelativeTo(null);
		listarUsuario();
		
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblUsuario) {
			mouseClickedTblUsuario(e);
		}
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
		if (e.getSource() == panel_1) {
			mousePressedPanel_1(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedLabel_1(MouseEvent e) {
		this.dispose();
	}
	private int leerId(){
		int id=0;
		try{
		if(txtCodigo.getText().trim().length()==0) alerta("Campo ID vacio");
		else id = Integer.parseInt(txtCodigo.getText().trim());
		}catch(NumberFormatException e){
			alerta("Solo se aceptan numeros");
			txtCodigo.setText("");
			
		}
		return id;
	}
	private void alerta(String s){
		JOptionPane.showMessageDialog(null,s,"Alerta",2);
	}
	private void mensaje(String s){
		JOptionPane.showMessageDialog(null, s);
	}
	private void eliminarUsuario(int xid){
		int boton,id;
		id = leerId();
		boton = JOptionPane.showConfirmDialog(null,"¿Seguro de eliminar USUARIO?","SISTEMA",JOptionPane.YES_NO_OPTION);
		if(boton==0){
			int ok = gu.eliminar(id);
			if(ok==0){
				alerta("Error al eliminar usuario");
			}else{
				mensaje("Se elimino Usuario");
				listarUsuario();
			}		
		}
	}
	private void listarUsuarioId(int xid){
		model.setRowCount(0);
		ArrayList<UsuarioXTipo>listar=gu.ListarXDesTipo(xid);
		if(listar.size()==0){
			alerta("Usuario no existe");
			listarUsuario();
		}else{
		for(UsuarioXTipo ut:listar){
			Object[]fila={
					ut.getIdUsuario(),
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
	private void listarUsuario(){
		//model.setRowCount(0);
		ArrayList<UsuarioXTipo>listarUser=gu.listarUsuario();
		if(listarUser.size()==0){
			alerta("No existen usuarios !");
		}else{
			for(UsuarioXTipo ut:listarUser){
				Object[]fila={
						ut.getIdUsuario(),
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
	private void mostrarCodigo(int pos){
		String id;
		id = tblUsuario.getValueAt(pos,0).toString();
		txtCodigo.setText(id);
	}
	protected void mouseClickedLabel_3(MouseEvent e) {
		listarUsuarioId(leerId());
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarUsuario(leerId());
	}
	protected void mouseClickedTblUsuario(MouseEvent e) {
		int pos=tblUsuario.getSelectedRow();
		mostrarCodigo(pos);
	}
	protected void mousePressedPanel_1(MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == panel_1) {
			mouseDraggedPanel_1(arg0);
		}
	}
	public void mouseMoved(MouseEvent arg0) {
	}
	protected void mouseDraggedPanel_1(MouseEvent arg0) {
		int x = arg0.getXOnScreen();
		int y = arg0.getYOnScreen();
		this.setLocation(x-xMouse, y-yMouse);
	}
}
