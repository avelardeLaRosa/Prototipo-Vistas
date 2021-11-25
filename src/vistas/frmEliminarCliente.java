package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controlador.GestionClienteDAO;
import entidad.Cliente;
import utils.Validacion;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmEliminarCliente extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblIngreseDniO;
	private JLabel lblBuscarPorDni;
	private JTextField txtBuscar;
	private JScrollPane scrollPane;
	private JButton btnEliminar;
	private JLabel label_2;
	private JTable tblCliente;
	int xMouse,yMouse;
	private JButton btnBuscar;
	DefaultTableModel model = new DefaultTableModel();
	GestionClienteDAO gc = new GestionClienteDAO();
	private JTextField txtCodigo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmEliminarCliente dialog = new frmEliminarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmEliminarCliente() {
		setBounds(0,0,450,350);
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
		
		lblIngreseDniO = new JLabel("Ingrese Dni o Seleccione Cliente");
		lblIngreseDniO.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseDniO.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblIngreseDniO.setBounds(40, 45, 352, 26);
		panel_1.add(lblIngreseDniO);
		
		lblBuscarPorDni = new JLabel("BUSCAR POR DNI");
		lblBuscarPorDni.setForeground(Color.BLACK);
		lblBuscarPorDni.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblBuscarPorDni.setBounds(10, 95, 172, 22);
		panel_1.add(lblBuscarPorDni);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(172, 95, 125, 22);
		panel_1.add(txtBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0,0,0)));
		scrollPane.setBounds(10, 128, 410, 174);
		panel_1.add(scrollPane);
		
		tblCliente = new JTable();
		tblCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCliente);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnEliminar.setBounds(125, 313, 172, 26);
		panel_1.add(btnEliminar);
		
		label_2 = new JLabel("");
		label_2.addMouseListener(this);
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_2.getWidth(), label_2.getHeight(), Image.SCALE_SMOOTH));
		label_2.setIcon(imgCerrar);
		panel_1.add(label_2);
		
		btnBuscar = new JButton("New button");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(frmEliminarCliente.class.getResource("/img/search_icon-icons.com_74448.png")));
		btnBuscar.setBounds(307, 95, 34, 23);
		panel_1.add(btnBuscar);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		model.addColumn("Código");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		tblCliente.setModel(model);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(349, 99, 24, 20);
		panel_1.add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setVisible(false);
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_2) {
			mouseClickedLabel_2(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == panel_1) {
			mousePressedPanel_1(arg0);
		}
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedLabel_2(MouseEvent arg0) {
		this.dispose();
	}
	protected void mousePressedPanel_1(MouseEvent arg0) {
		xMouse = arg0.getX();
		yMouse = arg0.getY();
	}
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == panel_1) {
			mouseDraggedPanel_1(e);
		}
	}
	public void mouseMoved(MouseEvent e) {
	}
	protected void mouseDraggedPanel_1(MouseEvent e) {
		int x=e.getXOnScreen();
		int y=e.getYOnScreen();
		this.setLocation(x-xMouse, y-yMouse);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		buscarDNI();
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		eliminarCliente();
	}
	private void buscarDNI() {
		String dni;
		dni = getBuscar();
		ArrayList<Cliente> data = new GestionClienteDAO().listarClientexDNI(dni);

		if (data.size() == 0) {
			mensaje("No existe el DNI");
		} 
		else {
			
			for (Cliente c : data) {
				Object fila[] = {c.getIdCliente(),
						 		c.getNombre(),
						 		c.getApellido()};
				model.addRow(fila);
				txtCodigo.setText(c.getIdCliente()+"");
			}
		}
	}
	
	private String getBuscar() {
		String dni = null;
		if(txtBuscar.getText().trim().length() == 0) {
			//lblDn.setVisible(true);
			mensaje("vacio");
			txtBuscar.requestFocus();
		}
			
		else if(txtBuscar.getText().trim().matches(Validacion.DNI) == false)
			mensaje("Formato incorrecto del DNI. Ingresar 8 números");
		else
			dni = txtBuscar.getText();
		
	return dni;

	}
	
	private void mensaje(String msj){
		JOptionPane.showMessageDialog(this, msj, "Sistema" , 0);
	}
	
	private void mensaje1(String msj){
		JOptionPane.showMessageDialog(this, msj, "Sistema" , 1);
	}
	
	private void eliminarCliente() {
		//declarar variables
		int codigo,boton;
		//obtener codigo ingresado
		codigo = Integer.parseInt(txtCodigo.getText());
		
		//obtener el valor de la ventana de confirmación
		boton = JOptionPane.showConfirmDialog(this, "Seguro de eliminar ? "," Sistema",JOptionPane.YES_NO_OPTION);
		if(boton == 0) { //selecciono
			int res = gc.eliminar(codigo);
			if(res == 0)
				mensaje("Error al eliminar");
			else {
				mensaje1("Usuario eliminado");
				model.setRowCount(0);
				txtBuscar.setText("");
				txtBuscar.requestFocus();
			}
				
			
			
		}
	}
}
