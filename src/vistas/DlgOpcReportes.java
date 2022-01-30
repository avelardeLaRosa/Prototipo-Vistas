package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
//
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//




import controlador.GestionUsuarioDAO;
import entidad.Usuario;
import entidad.UsuarioXTipo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class DlgOpcReportes extends JDialog implements MouseListener, ActionListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JLabel lblReportes;
	private JLabel label_1;
	private JLabel lblTransacciones;
	private JLabel lblCaja;
	private JButton btnReporteDeAperturas;
	private JLabel lblInventario;
	private JButton btnReporteDeInventario;
	private JLabel lblUsuarios;
	private JButton btnReporteDeUsuarios;
	int xMouse,yMouse;
	GestionUsuarioDAO gu=new GestionUsuarioDAO();
	Usuario u=new Usuario();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgOpcReportes dialog = new DlgOpcReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgOpcReportes() {
		setBounds(100, 100, 471, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(193,18,5));
		panel.setBounds(0, 0, 471, 399);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.addMouseMotionListener(this);
		panel_1.addMouseListener(this);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 451, 399);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnNewButton = new JButton("Reporte de Venta Por Numero de Boleta");
		btnNewButton.setIcon(new ImageIcon(DlgOpcReportes.class.getResource("/img/boleto.png")));
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		btnNewButton.setBounds(55, 79, 329, 41);
		panel_1.add(btnNewButton);
		
		lblReportes = new JLabel("REPORTES");
		lblReportes.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblReportes.setBounds(127, 11, 191, 26);
		panel_1.add(lblReportes);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(this);
		label_1.setIcon(new ImageIcon(DlgOpcReportes.class.getResource("/img/leftarrow_theapplication_izquierda_4435.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(402, 11, 39, 32);
		panel_1.add(label_1);
		
		lblTransacciones = new JLabel("Transacciones");
		lblTransacciones.setHorizontalAlignment(SwingConstants.LEFT);
		lblTransacciones.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		lblTransacciones.setBounds(55, 48, 131, 20);
		panel_1.add(lblTransacciones);
		
		lblCaja = new JLabel("Caja");
		lblCaja.setHorizontalAlignment(SwingConstants.LEFT);
		lblCaja.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		lblCaja.setBounds(55, 132, 131, 20);
		panel_1.add(lblCaja);
		
		btnReporteDeAperturas = new JButton("Reporte de Caja");
		btnReporteDeAperturas.addActionListener(this);
		btnReporteDeAperturas.setIcon(new ImageIcon(DlgOpcReportes.class.getResource("/img/cajaApertura.png")));
		btnReporteDeAperturas.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		btnReporteDeAperturas.setBounds(55, 162, 329, 41);
		panel_1.add(btnReporteDeAperturas);
		
		lblInventario = new JLabel("Inventario");
		lblInventario.setHorizontalAlignment(SwingConstants.LEFT);
		lblInventario.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		lblInventario.setBounds(55, 214, 131, 20);
		panel_1.add(lblInventario);
		
		btnReporteDeInventario = new JButton("Reporte de Inventario");
		btnReporteDeInventario.addActionListener(this);
		btnReporteDeInventario.setIcon(new ImageIcon(DlgOpcReportes.class.getResource("/img/reporteInventario.png")));
		btnReporteDeInventario.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		btnReporteDeInventario.setBounds(55, 245, 329, 41);
		panel_1.add(btnReporteDeInventario);
		
		lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuarios.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		lblUsuarios.setBounds(55, 297, 131, 20);
		panel_1.add(lblUsuarios);
		
		btnReporteDeUsuarios = new JButton("Reporte de Usuarios");
		btnReporteDeUsuarios.addActionListener(this);
		btnReporteDeUsuarios.setIcon(new ImageIcon(DlgOpcReportes.class.getResource("/img/user_32_px.png")));
		btnReporteDeUsuarios.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		btnReporteDeUsuarios.setBounds(55, 328, 329, 41);
		panel_1.add(btnReporteDeUsuarios);
		setUndecorated(true);
		
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
		if (arg0.getSource() == panel_1) {
			mousePressedPanel_1(arg0);
		}
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		frmPrincipalEmp pri=new frmPrincipalEmp();
		pri.setVisible(true);
		pri.setLocationRelativeTo(this);
		this.dispose();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReporteDeUsuarios) {
			actionPerformedBtnReporteDeUsuarios(arg0);
		}
		if (arg0.getSource() == btnReporteDeInventario) {
			actionPerformedBtnReporteDeInventario(arg0);
		}
		if (arg0.getSource() == btnReporteDeAperturas) {
			actionPerformedBtnReporteDeAperturas(arg0);
		}
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		frmReporteTransacciones repo=new frmReporteTransacciones();
		repo.setVisible(true);
		repo.setLocationRelativeTo(this);
		this.dispose();
	}
	protected void mousePressedPanel_1(MouseEvent arg0) {
		xMouse = arg0.getX();
		yMouse = arg0.getY();
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
	protected void actionPerformedBtnReporteDeAperturas(ActionEvent arg0) {
		frmReporteCaja frc=new frmReporteCaja();
		frc.setVisible(true);
		frc.setLocationRelativeTo(this);
		this.dispose();
	}
	protected void actionPerformedBtnReporteDeInventario(ActionEvent arg0) {
		frmInventarioReporte i=new frmInventarioReporte();
		i.setVisible(true);
		i.setLocationRelativeTo(this);
		this.dispose();
	}
	protected void actionPerformedBtnReporteDeUsuarios(ActionEvent arg0) {
		imprimePDF();
	}
	void imprimePDF() {

		//PASO 1 : ASIGNAR EL NOMBRE DEL ARCHIVO Y UBICACION
		String nomArchivo = "reportes/reporteUsuarios.pdf";
		try {
			//PASO 2: AGREGAR UNA PLANTILLA 
			Document plantilla=new Document();
			//PASO 3: CREAR ARCHIVO PDF EN FISICO
			FileOutputStream fos=new FileOutputStream(nomArchivo);
			//PASO 4: RELACIONAR LA PLANTILLA CON EL ARCHIVO PDF
			PdfWriter pdfWrt = PdfWriter.getInstance(plantilla, fos);
			//PASO 5: PLANTILLA A MODO DE ESCRITURA
			plantilla.open();
			//PASO 6: AGREGAR LOS COMPONENTES
			//imagenes
			Image img= Image.getInstance("img/logoChanny.png");
			img.scaleToFit(80,80);
			img.setAlignment(Chunk.ALIGN_RIGHT);
			plantilla.add(img);
			//--titulo
			Paragraph p=new Paragraph("Listado de Usuarios",FontFactory.getFont("arial",20,Font.BOLD,BaseColor.BLUE));
			p.setAlignment(Chunk.ALIGN_CENTER);
			plantilla.add(p);
			//--linea en blanco
			Paragraph b=new Paragraph(" ");
			plantilla.add(b);
			
			//--listado de productos
			ArrayList<UsuarioXTipo>listar=gu.listarUsuario();
			//validar resultado
			if(listar==null||listar.size()==0){
				Paragraph listaUsr=new Paragraph("Lista Vacia",FontFactory.getFont("arial",18,Font.BOLD,BaseColor.RED));
				p.setAlignment(Chunk.ALIGN_CENTER);
				plantilla.add(listaUsr);
			}else{
				//crear una tabla
				PdfPTable table=new PdfPTable(6);
				//agregar las columnas
				table.addCell("Codigo");
				table.addCell("Nombre");
				table.addCell("Apellido");
				table.addCell("Usuario");
				table.addCell("Clave");
				table.addCell("Foto");
				//bucle para obtener la data
				for (UsuarioXTipo ut : listar) {//ut.getIdUsuario()  src/img/emp1.png  src/img/empnulo.png
					if(new File("src/img/emp"+ut.getIdUsuario()+".png").exists()){
						img = Image.getInstance("src/img/emp"+ut.getIdUsuario()+".png");
					}else{
						img = Image.getInstance("src/img/empnulo.png");
					}
							
								table.addCell(ut.getIdUsuario()+"");
								table.addCell(ut.getNombre());
								table.addCell(ut.getApellido());
								table.addCell(ut.getUsuario());
								table.addCell(ut.getClave());
								table.addCell(img);
					}
				//agregar la tabla a la plantilla
					plantilla.add(table);
				}
			
			

			//PASO 7: CERRAR LA PLANTILLA
			plantilla.close();
			//PASO 8: MOSTRAR EL ARCHIVO PDF
			Desktop.getDesktop().open(new File(nomArchivo));
		} catch (Exception e) {
			System.out.println("Error al crear el archivo"+e.getMessage());
		}
		}
	

	private void alerta(String s) {
		JOptionPane.showMessageDialog(null,s,"ERROR",0);
		
	}
	
}
