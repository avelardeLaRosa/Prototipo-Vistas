package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import com.itextpdf.text.Image;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

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

import controlador.GestionVentasDAO;
import entidad.Categoria;
import entidad.DetalleVenta;
import entidad.Producto;
import entidad.Usuario;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmReporteTransacciones extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	int xMouse,yMouse;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JButton btnExportar;
	private JLabel lblReportes;
	private JLabel label;
	private JComboBox cboNumBol;
	private JTable tblReporteTrans;
	DefaultTableModel model=new DefaultTableModel();
	GestionVentasDAO gv=new GestionVentasDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmReporteTransacciones dialog = new frmReporteTransacciones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmReporteTransacciones() {
		setBounds(100, 100, 541, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(193, 18, 5));
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBounds(0, 0, 541, 430);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 521, 430);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 127, 458, 242);
		panel_1.add(scrollPane);
		
		tblReporteTrans = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int columnIndex){
				return false;}
		};
		tblReporteTrans.addMouseListener(this);
		model.addColumn("Precio");
		model.addColumn("Cantidad");
		model.addColumn("ID Producto");
		model.addColumn("Nro. Boleta");
		tblReporteTrans.setModel(model);
		tblReporteTrans.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblReporteTrans);
		
		btnExportar = new JButton("EXPORTAR");
		btnExportar.addActionListener(this);
		btnExportar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExportar.setBounds(189, 380, 145, 30);
		panel_1.add(btnExportar);
		
		lblReportes = new JLabel("REPORTE DE TRANSACCIONES");
		lblReportes.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblReportes.setBounds(95, 11, 298, 30);
		panel_1.add(lblReportes);
		
		label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(this);
		label.setBounds(479, 11, 32, 30);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.DEFAULT));
		label.setIcon(imgCerrar);
		panel_1.add(label);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		
		cboNumBol = new JComboBox();
		cboNumBol.addMouseListener(this);
		cboNumBol.addActionListener(this);
		cboNumBol.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		cboNumBol.setBounds(157, 74, 198, 30);
		panel_1.add(cboNumBol);
		setUndecorated(true);
		setLocationRelativeTo(null);
		cargarComboEquipo();
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label) {
			mouseClickedLabel(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == tblReporteTrans) {
			do_tblReporteTrans_mouseEntered(arg0);
		}
		if (arg0.getSource() == cboNumBol) {
			do_cboNumBol_mouseEntered(arg0);
		}
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
		int x =  arg0.getXOnScreen();
		int y = arg0.getYOnScreen();
		
		this.setLocation(x - xMouse, y - yMouse);
	}
	protected void mouseClickedLabel(MouseEvent arg0) {
		DlgOpcReportes dop=new DlgOpcReportes();
		dop.setVisible(true);
		dop.setLocationRelativeTo(this);
		this.dispose();
	}
	String getNumBol(){
		String numBol=null;
			numBol = cboNumBol.getSelectedItem().toString();
		return numBol;
	}
	void imprimePDF() {

		//PASO 1 : ASIGNAR EL NOMBRE DEL ARCHIVO Y UBICACION
		String nomArchivo = "reportes/listadoProductos.pdf";
		try {
				if(cboNumBol.getSelectedIndex() == 0) {
					alerta("Seleccione un número de boleta");
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
					Paragraph p=new Paragraph("Reporte de Transacciones",FontFactory.getFont("arial",20,Font.ITALIC,BaseColor.BLACK));
					p.setAlignment(Chunk.ALIGN_CENTER);
					plantilla.add(p);
					//--linea en blanco
					Paragraph b=new Paragraph(" ");
					plantilla.add(b);
					//--listado de productos
					String numbol=getNumBol();
					ArrayList<DetalleVenta>listar=gv.listarDetalles(numbol);
					//validar resultado
					if(listar==null||listar.size()==0){
						Paragraph listaProd=new Paragraph("Lista Vacia",FontFactory.getFont("arial",18,Font.BOLD,BaseColor.RED));
						p.setAlignment(Chunk.ALIGN_CENTER);
						plantilla.add(listaProd);
					}else{
						//crear una tabla
						PdfPTable table=new PdfPTable(4);
						//agregar las columnas
						table.addCell("Precio");
						table.addCell("Cantidad");
						table.addCell("ID Producto");
						table.addCell("Nro. Boleta");
						//bucle para obtener la data
						for (DetalleVenta dv : listar) {
										table.addCell("S/."+String.format("%.2f", dv.getPrecio()));
										table.addCell(dv.getCantidad()+"");
										table.addCell(dv.getIdProducto()+"");
										table.addCell(dv.getNum_bol());
							}
						//agregar la tabla a la plantilla
							plantilla.add(table);
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
		
		
		
		
	}
	
	
	
	void listarXCategoria(String numbol){
		model.setRowCount(0);
		ArrayList<DetalleVenta>listar = gv.listarDetalles(numbol);
			for(DetalleVenta dv: listar){
			Object[] fila={
					"s/."+String.format( "%.2f",dv.getPrecio()),
					dv.getCantidad(),
					dv.getIdProducto(),
					dv.getNum_bol()
			};
			
			model.addRow(fila);
			
		}
			
		
	}
	void cargarComboEquipo() {
		ArrayList<DetalleVenta> cboDetVenta = gv.listar();
		cboNumBol.addItem("Selecione Nro. Boleta");
		for (DetalleVenta dv : cboDetVenta) {			
			boolean exists = false;
			
			for (int i = 0; i < cboNumBol.getItemCount(); i++) {
			String s = cboNumBol.getItemAt(i).toString(); 
				if (dv.getNum_bol().toString().equals(s)) {
					exists = true;
					break;
				}
			}
				if (!exists) {
					cboNumBol.addItem(dv.getNum_bol());
				} 		
		}
	}
	

	private void alerta(String s) {
		JOptionPane.showMessageDialog(this,s,"ERROR",0);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboNumBol) {
			do_cboNumBol_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnExportar) {
			actionPerformedBtnExportar(arg0);
		}
	}
	protected void actionPerformedBtnExportar(ActionEvent arg0) {
		imprimePDF();
	}
	protected void do_cboNumBol_actionPerformed(ActionEvent arg0) {
		listarXCategoria(getNumBol());
	}
	protected void do_cboNumBol_mouseEntered(MouseEvent arg0) {
		cboNumBol.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void do_tblReporteTrans_mouseEntered(MouseEvent arg0) {
		tblReporteTrans.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
