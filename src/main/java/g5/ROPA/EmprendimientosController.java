package g5.ROPA;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EmprendimientosController {
	private List<Emprendimiento> lEmprendimiento = new ArrayList<>();
	int pag=0;
	
	Utilityes util = new Utilityes();
	String urlerror = util.urlValida("https://cdn-icons-png.flaticon.com/256/3733/3733132.png") ? "https://cdn-icons-png.flaticon.com/256/3733/3733132.png" : "icon.png";
	
	@FXML
    private Label titulo1;
	@FXML
    private Label titulo2;
	@FXML
    private Label titulo3;
	@FXML
    private Label titulo4;
	@FXML
    private Label titulo5;
	@FXML
    private Label titulo6;
	@FXML
    private Label info1;
	@FXML
    private Label info2;
	@FXML
    private Label info3;
	@FXML
    private Label info4;
	@FXML
    private Label info5;
	@FXML
    private Label info6;
	@FXML
    private Button buttonSig;
	@FXML
    private Button buttonPrev;
	@FXML
    private ImageView img1;
	@FXML
    private ImageView img2;
	@FXML
    private ImageView img3;
	@FXML
    private ImageView img4;
	@FXML
    private ImageView img5;
	@FXML
    private ImageView img6;
	
	public void initialize () throws SQLException {
		obtenerEmprendimientos();
		llenarEmprendimientos();
	}
	
	public void obtenerEmprendimientos() throws SQLException {
		
		String consultarEmprendimientos = "SELECT nombre, descripcion, pagina, imagen, correo FROM emprendimientos";
        Connection conexion = DBConnection.getConnection();
        PreparedStatement ps = conexion.prepareStatement(consultarEmprendimientos);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){													//iterator
            Emprendimiento emprendimientoIn = new Emprendimiento.Builder()		//builder
            										.nombre(rs.getString("nombre"))
            										.descripcion(rs.getString("descripcion"))
            										.pagina(rs.getString("pagina"))
            										.imagen(rs.getString("imagen"))
            										.correo(rs.getString("correo"))
            										.build();
            lEmprendimiento.add(emprendimientoIn);
        }
        
        for(Emprendimiento t : lEmprendimiento) {							//iterator para debugging
        	System.out.println(t.toString());
        }
	}
	
	public void SigEmprendimientos(ActionEvent event) throws IOException {
		if(lEmprendimiento.size() > pag+6) {pag += 6;}
		llenarEmprendimientos();
		}
	public void PrevEmprendimientos(ActionEvent event) throws IOException {
		if(pag != 0) {pag -= 6;}
		llenarEmprendimientos();
		}
	
	public String texto(int index) {
		return lEmprendimiento.get(pag + index).getDescripcion() + "\npagina: " + lEmprendimiento.get(pag + index).getPagina() + "\ncorreo: " + lEmprendimiento.get(pag + index).getCorreo();
	}
	
	public Image imagen(int index) {
		Image imagen=null;
		if(util.urlValida(lEmprendimiento.get(pag + index).getImagen())) {
    		imagen= new Image(lEmprendimiento.get(pag + index).getImagen(), true);
    		if (imagen.isError()) {
                System.err.println("Error al cargar la imagen: " + imagen.getException());
            }
    	} else {
    		imagen = new Image(urlerror);
    	}
		return imagen;
	}
	
	public void llenarEmprendimientos() {
		
        if (lEmprendimiento.size() > pag + 0) {
        	titulo1.setText(lEmprendimiento.get(pag + 0).getNombre());
        	info1.setText(texto(0));
        	img1.setImage(imagen(0));
        }else {
        	titulo1.setText("");
        	info1.setText("");
        	img1.setImage(null);
        }
        if (lEmprendimiento.size() > pag + 1) {
        	titulo2.setText(lEmprendimiento.get(pag + 1).getNombre());
        	info2.setText(texto(1));
        	img2.setImage(imagen(1));
        }else {
        	titulo2.setText("");
        	info2.setText("");
        	img2.setImage(null);
        }
        if (lEmprendimiento.size() > pag + 2) {
        	titulo3.setText(lEmprendimiento.get(pag + 2).getNombre());
        	info3.setText(texto(2));
        	img3.setImage(imagen(2));
        }else {
        	titulo3.setText("");
        	info3.setText("");
        	img3.setImage(null);
        }
        if (lEmprendimiento.size() > pag + 3) {
        	titulo4.setText(lEmprendimiento.get(pag + 3).getNombre());
        	info4.setText(texto(3));
        	img4.setImage(imagen(3));
        }else {
        	titulo4.setText("");
        	info4.setText("");
        	img4.setImage(null);
        }
        if (lEmprendimiento.size() > pag + 4) {
        	titulo5.setText(lEmprendimiento.get(pag + 4).getNombre());
        	info5.setText(texto(4));
        	img5.setImage(imagen(4));
        }else {
        	titulo5.setText("");
        	info5.setText("");
        	img5.setImage(null);
        }
        if (lEmprendimiento.size() > pag + 5) {
        	titulo6.setText(lEmprendimiento.get(pag + 5).getNombre());
        	info6.setText(texto(5));
        	img6.setImage(imagen(5));
        }else {
        	titulo6.setText("");
        	info6.setText("");
        	img6.setImage(null);
        }
	}
}
