package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

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

import controlador.GestionCajaDAO;
import entidad.Caja;
import entidad.CajaApertura;
import entidad.CajaCierre;
import entidad.DetalleVenta;

import javax.swing.JComboBox;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

public class frmReporteCaja extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JComboBox cboCaja;
	int xMouse,yMouse;
	private JLabel lblReporteDeCaja;
	private JLabel label_1;
	private JScrollPane scrollPane;
	private JTable tblRepoCaja;
	DefaultTableModel model=new DefaultTableModel();
	GestionCajaDAO gc=new GestionCajaDAO();
	private JButton button;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmReporteCaja frame = new frmReporteCaja();
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
	public frmReporteCaja() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setBackground(new Color(193, 18, 5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 0, 430, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		cboCaja = new JComboBox();
		cboCaja.addActionListener(this);
		cboCaja.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		cboCaja.setModel(new DefaultComboBoxModel(new String[] {"Elegir Reporte", "Reporte de Apeturas", "Reporte de Cierres"}));
		cboCaja.setBounds(10, 63, 200, 25);
		panel.add(cboCaja);
		
		lblReporteDeCaja = new JLabel("REPORTE DE CAJA");
		lblReporteDeCaja.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteDeCaja.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblReporteDeCaja.setBounds(72, 22, 283, 30);
		panel.add(lblReporteDeCaja);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(this);
		label_1.setBounds(394, 11, 32, 30);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.DEFAULT));
		label_1.setIcon(imgCerrar);
		panel.add(label_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 410, 178);
		panel.add(scrollPane);
		
		tblRepoCaja = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int columnIndex){
				return false;}
		};
		model.addColumn("Monto de Apertura");
		model.addColumn("Fecha y Hora");
		model.addColumn("Comentario");
		tblRepoCaja.setModel(model);
		tblRepoCaja.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblRepoCaja);
		
		button = new JButton("EXPORTAR");
		button.addActionListener(this);
		button.setBounds(154, 302, 145, 30);
		panel.add(button);
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
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == panel) {
			mouseDraggedPanel(e);
		}
	}
	public void mouseMoved(MouseEvent e) {
	}
	protected void mouseDraggedPanel(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		this.setLocation(x-xMouse, y-yMouse);
	}
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		DlgOpcReportes dop=new DlgOpcReportes();
		dop.setVisible(true);
		dop.setLocationRelativeTo(this);
		this.dispose();
	}
	int getCboCaja(){
		int cbo=0;
		if(cboCaja.getSelectedIndex()==0){
			alerta("Debe seleccionar el tipo de reporte");
		}else{
			cbo = cboCaja.getSelectedIndex();
		}
		return cbo;
	}
	void alerta(String s){
		JOptionPane.showMessageDialog(null, s,"ERROR",0);
	}
	void listarReporteApertura(){
		model.setRowCount(0);
		ArrayList<CajaApertura>listar=gc.listarRegistrosApertura();
		if(listar.size()==0){
			alerta("No existen reportes de apertura");
		}else{
			for (CajaApertura c : listar) {
				Object fila [] = {
						c.getMonto(),
						c.getFecha(),
						c.getComentario(),
						c.getIdCaja(),
						c.getIdUsuario(),
						c.getCod_estado()
				};
				model.addRow(fila);
			}
		}
	}
	void listarReporteCierre(){
		model.setRowCount(0);
		ArrayList<CajaCierre>listar=gc.listarRegistrosCierre();
		if(listar.size()==0){
			alerta("No existen reportes de cierre");
		}else{
			for (CajaCierre cc : listar) {
				Object fila [] = {
						cc.getMonto(),
						cc.getFecha(),
						cc.getComentario()
				};
				model.addRow(fila);
			}
		}
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;}
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
		}
		if (arg0.getSource() == cboCaja) {
			actionPerformedCboCaja(arg0);
		}
	}
	protected void actionPerformedCboCaja(ActionEvent arg0) {
		switch(getCboCaja()){
		case 1: listarReporteApertura(); break;
		case 2: listarReporteCierre(); break;
		default:
			break;
		}
	}
	void imprimePDF() {

		//PASO 1 : ASIGNAR EL NOMBRE DEL ARCHIVO Y UBICACION
		String nomArchivo = "reportes/reporteAperturasCaja.pdf";
		try {
				if(cboCaja.getSelectedIndex() == 0) {
					alerta("Seleccione reporte que desea exportar");
				}
				else {
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
					Paragraph p=new Paragraph("Reporte de caja",FontFactory.getFont("arial",20,Font.ITALIC,BaseColor.BLACK));
					p.setAlignment(Chunk.ALIGN_CENTER);
					plantilla.add(p);
					//--linea en blanco
					Paragraph b=new Paragraph(" ");
					plantilla.add(b);
					//--listado de productos
					int cbo = getCboCaja();
					ArrayList<CajaApertura>listarApertura=gc.listarRegistrosApertura();
					ArrayList<CajaCierre>listarCierre=gc.listarRegistrosCierre();
					//validar resultado
					if(listarApertura==null||listarApertura.size()==0||listarCierre==null||listarCierre.size()==0){
						Paragraph listaProd=new Paragraph("Lista Vacia",FontFactory.getFont("arial",18,Font.BOLD,BaseColor.RED));
						p.setAlignment(Chunk.ALIGN_CENTER);
						plantilla.add(listaProd);
					}else{
						switch (cbo) {
						case 1:
							Paragraph ap=new Paragraph("APERTURAS",FontFactory.getFont("arial",20,Font.ITALIC,BaseColor.BLACK));
							ap.setAlignment(Chunk.ALIGN_CENTER);
							plantilla.add(ap);
							Paragraph esp=new Paragraph(" ");
							plantilla.add(esp);
							//crear una tabla
							PdfPTable table=new PdfPTable(6);
							//agregar las columnas
							table.addCell("Monto");
							table.addCell("Fecha y Hora");
							table.addCell("Comentario");
							table.addCell("ID Caja");
							table.addCell("ID Usuario");
							table.addCell("Codigo Estado ");
							//bucle para obtener la data
							for (CajaApertura ca : listarApertura) {
											table.addCell("S/."+String.format("%.2f", ca.getMonto()));
											table.addCell(ca.getFecha()+"");
											table.addCell(ca.getComentario()+"");
											table.addCell(ca.getIdCaja()+"");
											table.addCell(ca.getIdUsuario()+"");
											table.addCell(ca.getCod_estado()+"");
								}
							//agregar la tabla a la plantilla
								plantilla.add(table);
							break;

						default:
							Paragraph ac=new Paragraph("CIERRES",FontFactory.getFont("arial",20,Font.ITALIC,BaseColor.BLACK));
							ac.setAlignment(Chunk.ALIGN_CENTER);
							plantilla.add(ac);
							Paragraph esp1=new Paragraph(" ");
							plantilla.add(esp1);
							//crear una tabla
							PdfPTable table1=new PdfPTable(6);
							//agregar las columnas
							table1.addCell("Monto");
							table1.addCell("Fecha y Hora");
							table1.addCell("Comentario");
							table1.addCell("ID Caja");
							table1.addCell("ID Usuario");
							table1.addCell("Codigo Estado ");
							//bucle para obtener la data
							for (CajaCierre cc : listarCierre) {
								table1.addCell("S/."+String.format("%.2f", cc.getMonto()));
								table1.addCell(cc.getFecha()+"");
								table1.addCell(cc.getComentario()+"");
								table1.addCell(cc.getIdCaja()+"");
								table1.addCell(cc.getIdUsuario()+"");
								table1.addCell(cc.getCod_estado()+"");
								}
							//agregar la tabla a la plantilla
								plantilla.add(table1);
							break;
						}
						
						}
			
					//PASO 7: CERRAR LA PLANTILLA
					plantilla.close();
					//PASO 8: MOSTRAR EL ARCHIVO PDF
					Desktop.getDesktop().open(new File(nomArchivo));
				}
			} 
			catch (Exception e) {
			System.out.println("Error al crear el archivo");
		}
}	protected void actionPerformedButton(ActionEvent arg0) {
	imprimePDF();
	}
}
