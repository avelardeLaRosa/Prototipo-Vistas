package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;
import AppPackage.AnimationClass;
import Hilos.HiloHora;

import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;
public class frmPrincipalEmp extends JFrame implements MouseListener, MouseMotionListener {

	private JPanel contentPane;
	private JPanel panel;
	int xmouse, ymouse;
	private JLabel lblVenta;
	private JLabel lblInventario_1;
	private JLabel lblReporte;
	private JLabel lblInventario;
	private JLabel lblClientes;
	private JLabel lblProveedores;
	private JLabel lblVenta_1;
	private JLabel lblCaja;
	private JLabel lblClientes_1;
	private JLabel lblInventario_2;
	private JLabel lblProveedores_1;
	private JLabel lblReportes;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNombreDeCajero;
	public static JLabel lbl_Hora;
	private JLabel lblFecha;
	private JLabel lblBienvenido;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipalEmp frame = new frmPrincipalEmp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmPrincipalEmp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBounds(0, 0, 687, 481);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblVenta = new JLabel("");
		lblVenta.addMouseListener(this);
		lblVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenta.setIcon(new ImageIcon(frmPrincipalEmp.class.getResource("/img/bolsa-de-la-compra (2).png")));
		lblVenta.setBorder(new LineBorder(Color.BLACK));
		lblVenta.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		lblVenta.setBounds(36, 82, 150, 131);
		panel.add(lblVenta);
		
		lblInventario_1 = new JLabel("");
		lblInventario_1.addMouseListener(this);
		lblInventario_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInventario_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventario_1.setIcon(new ImageIcon(frmPrincipalEmp.class.getResource("/img/inventario.png")));
		lblInventario_1.setBorder(new LineBorder(Color.BLACK));
		lblInventario_1.setBounds(36, 279, 150, 131);
		panel.add(lblInventario_1);
		
		lblReporte = new JLabel("");
		lblReporte.addMouseListener(this);
		lblReporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblReporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporte.setIcon(new ImageIcon(frmPrincipalEmp.class.getResource("/img/envio.png")));
		lblReporte.setBorder(new LineBorder(Color.BLACK));
		lblReporte.setBounds(258, 279, 150, 131);
		panel.add(lblReporte);
		
		lblInventario = new JLabel("");
		lblInventario.addMouseListener(this);
		lblInventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInventario.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventario.setIcon(new ImageIcon(frmPrincipalEmp.class.getResource("/img/caja-registradora (1).png")));
		lblInventario.setBorder(new LineBorder(Color.BLACK));
		lblInventario.setBounds(258, 82, 150, 131);
		panel.add(lblInventario);
		
		lblClientes = new JLabel("");
		lblClientes.addMouseListener(this);
		lblClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClientes.setIcon(new ImageIcon(frmPrincipalEmp.class.getResource("/img/clasificacion (1).png")));
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setBorder(new LineBorder(Color.BLACK));
		lblClientes.setBounds(501, 82, 150, 131);
		panel.add(lblClientes);
		
		lblProveedores = new JLabel("");
		lblProveedores.addMouseListener(this);
		lblProveedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProveedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedores.setIcon(new ImageIcon(frmPrincipalEmp.class.getResource("/img/grafico-de-barras.png")));
		lblProveedores.setBounds(501, 279, 150, 131);
		lblProveedores.setBorder(new LineBorder(Color.BLACK));
		panel.add(lblProveedores);
		
		lblVenta_1 = new JLabel("VENTA");
		lblVenta_1.setFont(new Font("Yu Gothic Light", Font.PLAIN, 11));
		lblVenta_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenta_1.setBounds(85, 184, 46, 14);
		panel.add(lblVenta_1);
		
		lblCaja = new JLabel("CAJA");
		lblCaja.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaja.setFont(new Font("Yu Gothic Light", Font.PLAIN, 11));
		lblCaja.setBounds(310, 184, 46, 14);
		panel.add(lblCaja);
		
		lblClientes_1 = new JLabel("CLIENTES");
		lblClientes_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes_1.setFont(new Font("Yu Gothic Light", Font.PLAIN, 11));
		lblClientes_1.setBounds(556, 184, 62, 14);
		panel.add(lblClientes_1);
		
		lblInventario_2 = new JLabel("INVENTARIO");
		lblInventario_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventario_2.setFont(new Font("Yu Gothic Light", Font.PLAIN, 11));
		lblInventario_2.setBounds(67, 382, 84, 14);
		panel.add(lblInventario_2);
		
		lblProveedores_1 = new JLabel("PROVEEDORES");
		lblProveedores_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedores_1.setFont(new Font("Yu Gothic Light", Font.PLAIN, 11));
		lblProveedores_1.setBounds(295, 382, 84, 14);
		panel.add(lblProveedores_1);
		
		lblReportes = new JLabel("REPORTES");
		lblReportes.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes.setFont(new Font("Yu Gothic Light", Font.PLAIN, 11));
		lblReportes.setBounds(544, 382, 62, 14);
		panel.add(lblReportes);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 687, 71);
		panel_1.setBackground(new Color(193,18,5));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("New label");

		lblNewLabel_1.setBounds(294, 0, 88, 71);
		ImageIcon icoVector = new ImageIcon(getClass().getResource("/img/logoVector.png"));
		ImageIcon imgVector = new ImageIcon(icoVector.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_1.setIcon(imgVector);
		panel_1.add(lblNewLabel_1);
		
		lbl_Hora = new JLabel("hora");
		lbl_Hora.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Hora.setForeground(Color.WHITE);
		lbl_Hora.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lbl_Hora.setBounds(489, 42, 140, 20);
		panel_1.add(lbl_Hora);
		
		lblNombreDeCajero = new JLabel(frmLogin.u.getNombre()+" "+frmLogin.u.getApellido());
		lblNombreDeCajero.setBounds(97, 11, 140, 20);
		panel_1.add(lblNombreDeCajero);
		lblNombreDeCajero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDeCajero.setForeground(Color.WHITE);
		lblNombreDeCajero.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		
		lblFecha = new JLabel("fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblFecha.setBounds(433, 11, 208, 20);
		panel_1.add(lblFecha);
		
		lblBienvenido = new JLabel("Cajero :");
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblBienvenido.setBounds(34, 8, 73, 26);
		panel_1.add(lblBienvenido);
		
		label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(this);
		label.setBackground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(653, 6, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
		label.setIcon(imgCerrar);
		panel_1.add(label);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(this);
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setIcon(new ImageIcon(frmPrincipalEmp.class.getResource("/img/settings.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(646, 437, 31, 33);
		panel.add(label_1);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		mostrarHora();
		mostrarFecha();
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_1) {
			mouseClickedLabel_1(arg0);
		}
		if (arg0.getSource() == label) {
			mouseClickedLabel(arg0);
		}
		if (arg0.getSource() == lblInventario) {
			mouseClickedLblInventario(arg0);
		}
		if (arg0.getSource() == lblProveedores) {
			mouseClickedLblProveedores(arg0);
		}
		if (arg0.getSource() == lblReporte) {
			mouseClickedLblReporte(arg0);
		}
		if (arg0.getSource() == lblClientes) {
			mouseClickedLblClientes(arg0);
		}
		if (arg0.getSource() == lblInventario_1) {
			mouseClickedLblInventario_1(arg0);
		}
		if (arg0.getSource() == lblVenta) {
			mouseClickedLblVenta(arg0);
		}
		if (arg0.getSource() == panel) {
			mouseClickedPanel(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
		xmouse = arg0.getX(); // X ES DE IZQUIERDA A DERECHA  FRAME
		ymouse = arg0.getY(); // Y ES DE ARRIBA ABAJO
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedPanel(MouseEvent arg0) {
		
		
	}
	
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == panel) {
			mouseDraggedPanel(arg0);
		}
	}
	public void mouseMoved(MouseEvent arg0) {
	}
	protected void mouseDraggedPanel(MouseEvent arg0) {
		int x = arg0.getXOnScreen(); // PANTALLA DE COMPUTADOR 
		int y = arg0.getYOnScreen(); // PANTALLA DE COMPUTADOR 
		
		this.setLocation(x - xmouse, y - ymouse);
	}
	public void mostrarHora(){
		HiloHora hora=new HiloHora();
		hora.start();
	}
	public void mostrarFecha() {
		Date fecha=new Date();
		DateFormat flarga = DateFormat.getDateInstance(DateFormat.LONG);
		lblFecha.setText(flarga.format(fecha));
	}
	protected void mouseClickedLblVenta(MouseEvent arg0) {
		frmVenta venta=new frmVenta();
		venta.setVisible(true);
		venta.setLocationRelativeTo(null);
		this.dispose();
	}
	protected void mouseClickedLblInventario_1(MouseEvent arg0) {
		frmInventario inventario=new frmInventario();
		inventario.setVisible(true);
		inventario.setLocationRelativeTo(null);
		this.dispose();
	}
	protected void mouseClickedLblClientes(MouseEvent arg0) {
		frmClientes clientes=new frmClientes();
		clientes.setVisible(true);
		clientes.setLocationRelativeTo(null);
		this.dispose();
	}
	protected void mouseClickedLblReporte(MouseEvent arg0) {
		frmProveedores pro=new frmProveedores();
		pro.setVisible(true);
		pro.setLocationRelativeTo(null);
		this.dispose();
	}
	protected void mouseClickedLblProveedores(MouseEvent arg0) {
		frmReportes repor=new frmReportes();
		repor.setVisible(true);
		repor.setLocationRelativeTo(null);
		this.dispose();
	}
	protected void mouseClickedLblInventario(MouseEvent arg0) {
		frmCaja caja=new frmCaja();
		caja.setVisible(true);
		caja.setLocationRelativeTo(null);
		this.dispose();
	}
	protected void mouseClickedLabel(MouseEvent arg0) {
		confirmacion();
		
	}
	int confirmacion(){
		int n = JOptionPane.showConfirmDialog(null,"¿Deseas cerrar el progama?","SALIR", JOptionPane.YES_NO_OPTION);
		if(n ==0){
			System.exit(0);
		}
		return n;
	}
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		frmConfiguracion conf=new frmConfiguracion();
		conf.setVisible(true);
		conf.setLocationRelativeTo(null);
		this.dispose();
	}
}
