package g5.ROPA;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.scene.control.Label;

class TestsUnit {
	
	
	@Test
    void testDBConnectionNotNull() {
        Connection connection = DBConnection.getConnection();
        assertNotNull(connection, "La conexión a la base de datos no debería ser nula");
    }

    @Test
    void testDBConnectionClose() {
        Connection connection = DBConnection.getConnection();
        assertDoesNotThrow(() -> connection.close(), "Cerrar la conexión no debería lanzar excepciones");
    }

 // Test para SMS
    /*@Test
    void testSendSMS() {
    	SMS sms = SMS.getInstance();																		//singleton
        boolean result = sms.enviarSMS("Mensaje de prueba");
        assertTrue(result, "El envío de SMS debería ser exitoso");
    }

    // Test para la clase User (Singleton)
    @Test
    void testUserSingletonInstance() {
        User u1 = User.getInstance();
        User u2 = User.getInstance();
        assertSame(u1, u2, "User.getInstance debería devolver la misma instancia");
    }*/

    @Test
    void testUserSettersAndGetters() {
        User user = User.getInstance();
        user.setNombre("Juan");
        user.setTipo("A");
        user.setCorreo("juan@example.com");
        assertEquals("Juan", user.getNombre(), "El nombre debería coincidir");
        assertEquals("A", user.getTipo(), "El tipo debería coincidir");
        assertEquals("juan@example.com", user.getCorreo(), "El correo debería coincidir");
    }

    // Test para la entidad Tela (Builder pattern)
    @Test
    void testTelaBuilder() {
        Tela tela = new Tela.Builder()
            .nombre("Algodón")
            .descripcion("Tela suave")
            .nota(5)
            .imagen("algodon.png")
            .build();
        assertEquals("Algodón", tela.getNombre(), "El nombre de la tela debería coincidir");
        assertEquals("Tela suave", tela.getDescripcion(), "La descripción debería coincidir");
        assertEquals(5, tela.getNota(), "La nota debería coincidir");
        assertEquals("algodon.png", tela.getImagen(), "La imagen debería coincidir");
    }

    // Test para la entidad Emprendimiento (Builder pattern)
    @Test
    void testEmprendimientoBuilder() {
        Emprendimiento emp = new Emprendimiento.Builder()
            .nombre("EcoModa")
            .descripcion("Ropa reciclada")
            .pagina("www.ecomoda.com")
            .imagen("ecomoda.png")
            .correo("contacto@ecomoda.com")
            .build();
        assertEquals("EcoModa", emp.getNombre(), "El nombre del emprendimiento debería coincidir");
        assertEquals("Ropa reciclada", emp.getDescripcion(), "La descripción debería coincidir");
        assertEquals("www.ecomoda.com", emp.getPagina(), "La página debería coincidir");
        assertEquals("ecomoda.png", emp.getImagen(), "La imagen debería coincidir");
        assertEquals("contacto@ecomoda.com", emp.getCorreo(), "El correo debería coincidir");
    }

    // Test para la entidad Proveedor (Builder pattern)
    @Test
    void testProveedorBuilder() {
        Proveedor prov = new Proveedor.Builder()
            .nombre("Proveedor1")
            .descripcion("Suministros Textiles")
            .pagina("www.proveedor1.com")
            .imagen("prov1.png")
            .correo("ventas@proveedor1.com")
            .build();
        assertEquals("Proveedor1", prov.getNombre(), "El nombre del proveedor debería coincidir");
        assertEquals("Suministros Textiles", prov.getDescripcion(), "La descripción debería coincidir");
        assertEquals("www.proveedor1.com", prov.getPagina(), "La página debería coincidir");
        assertEquals("prov1.png", prov.getImagen(), "La imagen debería coincidir");
        assertEquals("ventas@proveedor1.com", prov.getCorreo(), "El correo debería coincidir");
    }

    // test funcion de comprobacion de valides de una URL
    @Test
    void testUtilityes() {
        String url = "https://cdn-icons-png.flaticon.com/256/3733/3733132.png";
        Utilityes util = new Utilityes();
        assertTrue(util.urlValida(url), "La URL deberia ser valida");
    }
    
    // test funcion de comprobacion de valides de una URL
    @Test
    void testUtilityesfail() {
    	String url = "ejemploURL123";
        Utilityes util = new Utilityes();
        assertFalse(util.urlValida(url), "La URL no deberia ser valida");
    }
    
    // test funcion texto
    @Test
	    void testTextoE() {
    	EmprendimientosController empr = new EmprendimientosController();
    	List<Emprendimiento> lE = new ArrayList<>();
		Emprendimiento emprendimientoIn = new Emprendimiento.Builder()												//builder
				.nombre("nombre")
				.descripcion("descripcion")
				.pagina("pagina")
				.imagen("imagen")
				.correo("correo")
				.build();
		lE.add(emprendimientoIn);
		empr.setlEmprendimiento(lE);
		assertEquals(empr.texto(0),"descripcion\npagina: pagina\ncorreo: correo","el texto coincide");
    }
    
    // test funcion texto
    @Test
    void testTextoDisE() {
	EmprendimientosController empr = new EmprendimientosController();
	List<Emprendimiento> lE = new ArrayList<>();
	Emprendimiento emprendimientoIn = new Emprendimiento.Builder()												//builder
			.nombre("nombre")
			.descripcion("descripcion2")
			.pagina("pagina2")
			.imagen("imagen")
			.correo("correo2")
			.build();
	lE.add(emprendimientoIn);
	empr.setlEmprendimiento(lE);
	assertNotEquals(empr.texto(0),"descripcion\npagina: pagina\ncorreo: correo","el texto coincide");
    }
    
    // test funcion texto
    @Test
    void testTextoP() {
	ProveedorController prov = new ProveedorController();
	List<Proveedor> lP = new ArrayList<>();
	Proveedor emprendimientoIn = new Proveedor.Builder()												//builder
			.nombre("nombre")
			.descripcion("descripcion")
			.pagina("pagina")
			.imagen("imagen")
			.correo("correo")
			.build();
	lP.add(emprendimientoIn);
	prov.setlProveedor(lP);
	assertEquals(prov.texto(0),"descripcion\npagina: pagina\ncorreo: correo","el texto coincide");
	}
	
    // test funcion texto
	@Test
	void testTextoDisP() {
		ProveedorController prov = new ProveedorController();
	List<Proveedor> lP = new ArrayList<>();
	Proveedor emprendimientoIn = new Proveedor.Builder()												//builder
			.nombre("nombre")
			.descripcion("descripcion2")
			.pagina("pagina2")
			.imagen("imagen")
			.correo("correo2")
			.build();
	lP.add(emprendimientoIn);
	prov.setlProveedor(lP);
	assertNotEquals(prov.texto(0),"descripcion\npagina: pagina\ncorreo: correo","el texto coincide");
	}
	
    // test funcion texto
	@Test
	void testTextoT() {
	TelasController tela = new TelasController();
	List<Tela> lT = new ArrayList<>();
	Tela telaIn = new Tela.Builder()						//builder
			.nombre("nombre")
			.descripcion("descripcion")
			.nota(8)
			.imagen("imagen")
			.build();
	lT.add(telaIn);
	tela.setlTelas(lT);
	assertEquals(tela.texto(0),"descripcion\nNota: 8");
	}
	
    // test funcion texto
	@Test
	void testTextoDisT() {
		TelasController tela = new TelasController();
	List<Tela> lT = new ArrayList<>();
	Tela telaIn = new Tela.Builder()						//builder
			.nombre("nombre")
			.descripcion("descripcion2")
			.nota(7)
			.imagen("imagen")
			.build();
	lT.add(telaIn);
	tela.setlTelas(lT);
	assertNotEquals(tela.texto(0),"descripcion\nNota: 8");
	}
}
