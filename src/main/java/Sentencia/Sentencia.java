package Sentencia;
import Conectar.Conentar_class;
import Modelos.Modelo_cls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Sentencia {
	private Connection Con;
	private PreparedStatement stm;
	private boolean estado;
	
	public boolean Insertar(Modelo_cls producto) throws SQLException {
		String insert = null;
		estado = false;
		Con=obtenerCone();
		
		try {
			Con.setAutoCommit(false);
			insert = "INSERT INTO productos(id,nombre,precio,cantidad,fechaInicio) VALUES (?,?,?,?,?)";
			stm = Con.prepareStatement(insert);
			stm.setString(1, null);
			stm.setString(2, producto.getNombre());
			stm.setDouble(3, producto.getPrecio());
			stm.setInt(4, producto.getCantidad());
			stm.setDate(5, producto.getFechaInicio());
			
			estado = stm.executeUpdate()>0;
			Con.commit();
			stm.close();		
			Con.close();
		} catch (SQLException e) {
			System.out.println("No se pudo insertar dato..."+e);
			e.printStackTrace();
		}
		return estado;
	}
	
	
	public boolean Update(Modelo_cls producto) throws SQLException {
		String update=null; 
		estado = false;
		Con=obtenerCone();
		try {

			Con.setAutoCommit(false);
			System.out.println("Para acualizar ingrese los datos a cambiar y despues el id al que corresponda...");
			update = "UPDATE productos SET nombre= ?,precio=?,cantidad=? WHERE id=?";
			stm = Con.prepareStatement(update);
			stm.setString(1, producto.getNombre());
			stm.setDouble(2, producto.getPrecio());
			stm.setInt(3, producto.getCantidad());			
			stm.setInt(4, producto.getId());
			
			estado = stm.executeUpdate()>0;
			Con.commit();
			stm.close();		
			Con.close();
			
		} catch (SQLException e) {
			Con.rollback();
			System.out.print("No se pudo actualizar dato.."+e);
			e.printStackTrace();
		}
				
		return estado;
	}
	
	public boolean Delete(int idProducto) throws SQLException {
		String delete=null;
		estado = false;
		Con=obtenerCone();
		try {
			Con.setAutoCommit(false);
			delete = "DELETE productos where id=?";
			stm = Con.prepareStatement(delete);
			stm.setInt(1, idProducto);
			
			estado = stm.executeUpdate()>0;
			
			Con.commit();
			stm.close();		
			Con.close();
			
		} catch (SQLException e) {
			Con.rollback();
			System.out.println("No se pudo eliminar dato..."+e);
			e.printStackTrace();
		}
		
		return estado;
	}
	
	public List<Modelo_cls> Select() throws SQLException {
		ResultSet resul =null;
		List<Modelo_cls> listaProducto = new ArrayList<>();
		
	
		
		String select=null;
		estado = false;
		Con=obtenerCone();
		try {
			select ="SELECT * FROM productos WHERE id=?";
			resul =stm.executeQuery(select);
			while(resul.next()) {
				Modelo_cls p = new Modelo_cls();
				p.setId(resul.getInt(1));
				p.setNombre(resul.getString(2));
				p.setPrecio(resul.getDouble(3));
				p.setCantidad(5);
				p.setFechaInicio(resul.getDate(6));
				listaProducto.add(p);				
			}
									
		} catch (Exception e) {
			Con.rollback();
			System.out.println("No se pudo consultar los datos..."+e);
		}
		            		
	return listaProducto;
	}
	
	public Modelo_cls Select(int idProducto) throws SQLException {
		ResultSet resul =null;
		Modelo_cls p = new Modelo_cls();
		
		String select=null;
		estado = false;
		Con=obtenerCone();
		try {
			select ="SELECT * FROM productos WHERE id=?";
			stm = Con.prepareStatement(select);
			stm.setInt(1, idProducto);
			
			resul =stm.executeQuery();
			
			if(resul.next()) {
				
				p.setId(resul.getInt(1));
				p.setNombre(resul.getString(2));
				p.setPrecio(resul.getDouble(3));
				p.setCantidad(5);
				p.setFechaInicio(resul.getDate(6));
							
			}
									
		} catch (Exception e) {
			
			System.out.println("No se pudo consultar los datos..."+e);
		}
		            		
	return p;
	}
	
	private Connection obtenerCone() throws SQLException {
		return Conentar_class.getConnection();
	}
	
}
