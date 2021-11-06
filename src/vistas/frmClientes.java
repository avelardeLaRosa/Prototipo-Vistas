package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmClientes extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblClientes;
	private JPanel panel;
	private JScrollPane scrollPane;
	private Button btnActualizarCli;
	private JLabel lblBuscarPorDni;
	private JTextField txtDni;
	private JLabel lblBuscar;
	private JLabel label_3;
	private Button btnAgregarCli;
	private Button btnModCliente;
	private JLabel label_4;
	private JLabel label_5;
	private Button btnElimCliente;
	private JLabel lblNewLabel;
	private JTable tbClientes;
	int xMouse, yMouse;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmClientes dialog = new frmClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmClientes() {
		setBounds(0,0,687,480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.addMouseMotionListener(this);
		contentPanel.addMouseListener(this);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		lblClientes = new JLabel("CLIENTES");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblClientes.setBounds(269, 11, 149, 30);
		contentPanel.add(lblClientes);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBackground(new Color(193, 18, 5));
		panel.setBounds(0, 47, 687, 341);
		contentPanel.add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0,0,0)));
		scrollPane.setBounds(0, 35, 687, 268);
		panel.add(scrollPane);
		
		tbClientes = new JTable();
		scrollPane.setViewportView(tbClientes);
		
		btnActualizarCli = new Button("Actualizar Tabla");
		btnActualizarCli.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnActualizarCli.setFont(new Font("Roboto Medium", Font.BOLD, 14));
		btnActualizarCli.setBounds(252, 309, 177, 22);
		panel.add(btnActualizarCli);
		
		lblBuscarPorDni = new JLabel("BUSCAR POR DNI ");
		lblBuscarPorDni.setForeground(Color.WHITE);
		lblBuscarPorDni.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblBuscarPorDni.setBounds(10, 10, 177, 14);
		panel.add(lblBuscarPorDni);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		txtDni.setColumns(10);
		txtDni.setBounds(197, 10, 188, 19);
		panel.add(txtDni);
		
		lblBuscar = new JLabel("");
		lblBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBuscar.setBounds(395, 10, 24, 22);
		ImageIcon icoBus=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBus=new ImageIcon(icoBus.getImage().getScaledInstance(lblBuscar.getWidth(), lblBuscar.getHeight(), Image.SCALE_SMOOTH));
		lblBuscar.setIcon(imgBus);
		panel.add(lblBuscar);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(frmClientes.class.getResource("/img/add_icon-icons.com_74429.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(53, 399, 65, 43);
		contentPanel.add(label_3);
		
		btnAgregarCli = new Button("Agregar un Cliente");
		btnAgregarCli.addActionListener(this);
		btnAgregarCli.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarCli.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		btnAgregarCli.setBounds(24, 448, 132, 22);
		contentPanel.add(btnAgregarCli);
		
		btnModCliente = new Button("Modificar un Cliente");
		btnModCliente.addActionListener(this);
		btnModCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModCliente.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		btnModCliente.setBounds(274, 448, 132, 22);
		contentPanel.add(btnModCliente);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(frmClientes.class.getResource("/img/pen_edit_modify_pencil_icon_181536 (1).png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(311, 399, 65, 43);
		contentPanel.add(label_4);
		
		label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(565, 399, 56, 43);
		ImageIcon icoMod=new ImageIcon(getClass().getResource("/img/1486504830-delete-dustbin-empty-recycle-recycling-remove-trash_81361 (1).png"));
		ImageIcon imgMod=new ImageIcon(icoMod.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_SMOOTH));
		label_5.setIcon(imgMod);
		contentPanel.add(label_5);
		
		btnElimCliente = new Button("Eliminar Cliente");
		btnElimCliente.addActionListener(this);
		btnElimCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnElimCliente.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		btnElimCliente.setBounds(530, 448, 132, 22);
		contentPanel.add(btnElimCliente);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(this);
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setBounds(638, 11, 39, 30);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(imgCerrar);
		contentPanel.add(lblNewLabel);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblNewLabel) {
			mouseClickedLblNewLabel(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == contentPanel) {
			mousePressedContentPanel(arg0);
		}
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedLblNewLabel(MouseEvent arg0) {
		frmPrincipalEmp pri=new frmPrincipalEmp();
		pri.setVisible(true);
		pri.setLocationRelativeTo(null);
		this.dispose();
	}
	protected void mousePressedContentPanel(MouseEvent arg0) {
		xMouse = arg0.getX();
		yMouse = arg0.getY();
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == contentPanel) {
			mouseDraggedContentPanel(arg0);
		}
	}
	public void mouseMoved(MouseEvent arg0) {
	}
	protected void mouseDraggedContentPanel(MouseEvent arg0) {
		int x=arg0.getXOnScreen();
		int y=arg0.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnElimCliente) {
			actionPerformedBtnElimCliente(arg0);
		}
		if (arg0.getSource() == btnModCliente) {
			actionPerformedBtnModCliente(arg0);
		}
		if (arg0.getSource() == btnAgregarCli) {
			actionPerformedBtnAgregarCli(arg0);
		}
	}
	protected void actionPerformedBtnAgregarCli(ActionEvent arg0) {
		frmAddCliente addCli=new frmAddCliente();
		addCli.setVisible(true);
		addCli.setLocationRelativeTo(null);
	}
	protected void actionPerformedBtnModCliente(ActionEvent arg0) {
		frmModCliente modCli=new frmModCliente();
		modCli.setVisible(true);
		modCli.setLocationRelativeTo(null);
	}
	protected void actionPerformedBtnElimCliente(ActionEvent arg0) {
		frmEliminarCliente elimCli=new frmEliminarCliente();
		elimCli.setVisible(true);
		elimCli.setLocationRelativeTo(null);
	}
}
