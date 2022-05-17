package main;

import java.sql.*;

import model.Animal;
import model.Camera;
import model.Expert;
import model.Role;
import model.Specialization;
class MysqlCon{  
	Connection con;
	public MysqlCon(){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/evern","root","abc123ABC");  
//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("show tables");  
			while(rs.next())  
				System.out.println(rs.getString(1));  
			//con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}
	
	public void insertRoles(Role role) {
		try
	    {
	      
	      Statement st = con.createStatement();

	      
	      st.executeUpdate("INSERT INTO roles (nombre) "
	          +"VALUES ('" +role.getNombre() + "')");

	     // con.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	}

	public void insertSpecialization(Specialization s) {
		try
	    {
	      
	      Statement st = con.createStatement();

	      
	      st.executeUpdate("INSERT INTO specializacion (nombre_especializacion) "
	          +"VALUES ('" +s.getNombre_especializacion()+ "')");

	     // con.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	}

	public void insertExpert(Expert expert) {
		try
	    {
	      
	      Statement st = con.createStatement();

	      
	      st.executeUpdate("INSERT INTO experto (nombre_empresa, email, nombre, password, extension_telefono, num_telefono, "
	      		+ "fecha_registro, apellido, fecha_modificacion, username, specialization_id) "
	          +"VALUES ('" + expert.getCompanyName() + "', '" + expert.getEmail() +"', '" + expert.getName() +"', '" +
	      		expert.getPassword() +"', " + expert.getPhoneExtension() +", " + expert.getPhoneNumber() +", '" +
	          expert.getRegisterDate() +"', '" + expert.getSurname() +"', '" + expert.getUpdatedTime() +"', '" + 
	      		expert.getUsername() +"', " + expert.getSpecialization_id() +")");

	     // con.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	}

	public void insertAnimals(Animal animal) {
		try
	    {
	      
			
	      Statement st = con.createStatement();
	      
	      
	      
	      st.executeUpdate("INSERT INTO animal (is_invasor, name) "
	          +"VALUES (" + animal.isInvasor() + ", '" + animal.getName() + "')");

	     // con.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	}

	public void insertCamera(Camera c) {
		try
	    {
	      
			
	      Statement st = con.createStatement();
	      
	      
	      
	      st.executeUpdate("INSERT INTO camara (numero_zona, nombre_zona) "
	          +"VALUES (" + c.getNumero_zona() + ", '" + c.getNombreZona() + "')");

	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	}
	
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}  