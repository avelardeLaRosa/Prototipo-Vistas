package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmProveedores extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	int xMouse, yMouse;
	private JLabel lblProveedores;
	private JLabel label_1;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private Button button;
	private JLabel label_2;
	private JTextField textField;
	private JLabel label_3;
	private JLabel label_4;
	private Button button_1;
	private Button button_2;
	private JLabel label_5;
	private JLabel label_6;
	private Button button_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmProveedores dialog = new frmProveedores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmProveedores() {
		setBounds(0,0,687,480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0,0,687,480);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblProveedores = new JLabel("PROVEEDORES");
		lblProveedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedores.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblProveedores.setBounds(269, 11, 149, 30);
		panel.add(lblProveedores);
		
		label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(this);
		label_1.setIcon(new ImageIcon(frmProveedores.class.getResource("/img/cerrarVnt.png")));
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
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		button = new Button("Actualizar Tabla");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Roboto Medium", Font.BOLD, 14));
		button.setBounds(252, 309, 177, 22);
		panel_1.add(button);
		
		label_2 = new JLabel("BUSCAR POR CODIGO");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		label_2.setBounds(10, 10, 177, 14);
		panel_1.add(label_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(197, 10, 188, 19);
		panel_1.add(textField);
		
		label_3 = new JLabel("");
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setBounds(395, 10, 30, 22);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscar=new ImageIcon(icoBuscar.getImage().getScaledInstance(label_3.getWidth(), label_3.getHeight(), Image.SCALE_SMOOTH));
		label_3.setIcon(imgBuscar);
		panel_1.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(frmProveedores.class.getResource("/img/add_icon-icons.com_74429.png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(53, 399, 65, 43);
		panel.add(label_4);
		
		button_1 = new Button("Agregar Nuevo Proveedor");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(this);
		button_1.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		button_1.setBounds(24, 448, 160, 22);
		panel.add(button_1);
		
		button_2 = new Button("Modificar un Proveedor");
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.addActionListener(this);
		button_2.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		button_2.setBounds(274, 448, 132, 22);
		panel.add(button_2);
		
		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(frmProveedores.class.getResource("/img/pen_edit_modify_pencil_icon_181536 (1).png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(311, 399, 65, 43);
		panel.add(label_5);
		
		label_6 = new JLabel("");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(565, 399, 65, 43);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/1486504830-delete-dustbin-empty-recycle-recycling-remove-trash_81361 (1).png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_6.getWidth(),label_6.getHeight() , Image.SCALE_SMOOTH));
		label_6.setIcon(imgCerrar);
		panel.add(label_6);
		
		button_3 = new Button("Eliminar Proveedor");
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.addActionListener(this);
		button_3.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		button_3.setBounds(530, 448, 132, 22);
		panel.add(button_3);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_1) {
			mouseClickedLabel_1(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == panel) {
			mousePressedPanel(arg0);
		}
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mousePressedPanel(MouseEvent arg0) {
		xMouse = arg0.getX();
		yMouse = arg0.getY();
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
	public void actionPerformed(ActionEvent arg0) {
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
		frmAddProveedor addprove=new frmAddProveedor();
		addprove.setVisible(true);
		addprove.setLocationRelativeTo(null);
	}
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		frmPrincipalEmp pri=new frmPrincipalEmp();
		pri.setVisible(true);
		pri.setLocationRelativeTo(null);
		this.dispose();
	}
	protected void actionPerformedButton_2(ActionEvent arg0) {
		frmModCliente mod=new frmModCliente();
		mod.setVisible(true);
		mod.setLocationRelativeTo(null);
	}
	
	protected void actionPerformedButton_3(ActionEvent arg0) {
		frmEliminarProveedor elim=new frmEliminarProveedor();
		elim.setVisible(true);
		elim.setLocationRelativeTo(null);
	}
}
