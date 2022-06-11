package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

import model.Animal;
import model.Camera;
import model.Expert;
import model.Prediction;
import model.Record;
import model.Role;
import model.Specialization;
class MysqlCon{  
	Connection con;
	String statements;
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
		statements = "use evern; \n";
	}
	
	public void insertRoles(Role role) {
		try
	    {
	      
	      Statement st = con.createStatement();

	      
	      st.executeUpdate("INSERT INTO roles (nombre) "
	          +"VALUES ('" +role.getNombre() + "')");
	      statements = statements + "INSERT INTO roles (nombre) VALUES ('" + role.getNombre() + "'); \n";
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

	      statements = statements + "INSERT INTO specializacion (nombre_especializacion) " +"VALUES ('" +s.getNombre_especializacion()+ "'); \n";
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

	      
	      statements = statements + "INSERT INTO experto (nombre_empresa, email, nombre, password, extension_telefono, num_telefono, "
		      		+ "fecha_registro, apellido, fecha_modificacion, username, specialization_id) "
			          +"VALUES ('" + expert.getCompanyName() + "', '" + expert.getEmail() +"', '" + expert.getName() +"', '" +
			      		expert.getPassword() +"', " + expert.getPhoneExtension() +", " + expert.getPhoneNumber() +", '" +
			          expert.getRegisterDate() +"', '" + expert.getSurname() +"', '" + expert.getUpdatedTime() +"', '" + 
			      		expert.getUsername() +"', " + expert.getSpecialization_id() +"); \n";
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

	      statements = statements + "INSERT INTO animal (is_invasor, name) "
		          +"VALUES (" + animal.isInvasor() + ", '" + animal.getName() + "'); \n";
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
	      statements = statements + "INSERT INTO camara (numero_zona, nombre_zona) "
		          +"VALUES (" + c.getNumero_zona() + ", '" + c.getNombreZona() + "'); \n";
	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	}
	

	public void insertRecord(Record r) {
		try
	    {
	      
			
	      Statement st = con.createStatement();
	      
	      
	      
	      st.executeUpdate("INSERT INTO registro (imp_path, fecha_registro, fecha_validacion, camara_id) "
	          +"VALUES ('" + r.getImgPath() + "', '" + r.getRecordDate() + "', '" + r.getValidationDate() + "', " + r.getCamara_id()+ ")");
	      statements = statements + "INSERT INTO registro (imp_path, fecha_registro, fecha_validacion, camara_id) "
		          +"VALUES ('" + r.getImgPath() + "', '" + r.getRecordDate() + "', '" + r.getValidationDate() + "', " + r.getCamara_id()+ "); \n";
	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	}
	
	public void insertPrediction(Prediction p) {
		try
	    {
	      
			
	      Statement st = con.createStatement();
	      
	      
	      
	      st.executeUpdate("INSERT INTO prediction (confianza, es_predecido, mensaje, direccon_imagen, animal_detectado, registro_id) "
	          +"VALUES (" + p.getConfidence() + ", TRUE, '" + p.getMessage() + "', '" + p.getPredictedImagePath() + "', " + p.getAnimal_id() + ", " + p.getRegistro_id() +  ")");
	      statements = statements + "INSERT INTO prediction (confianza, es_predecido, mensaje, direccon_imagen, animal_detectado, registro_id) "
		          +"VALUES (" + p.getConfidence() + ", TRUE, '" + p.getMessage() + "', '" + p.getPredictedImagePath() + "', " + p.getAnimal_id() + ", " + p.getRegistro_id() +  "); \n";
	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	}
	
	
	public void insertPredictionValidada(Prediction p) {
		try
	    {
	      
			
	      Statement st = con.createStatement();
	      
	      
	      
	      st.executeUpdate("INSERT INTO prediction (confianza, es_predecido, es_correcto, mensaje, direccon_imagen, experto_id, animal_detectado, registro_id) "
	          +"VALUES (" + p.getConfidence() + ", TRUE, TRUE, '" + p.getMessage() + "', '" + p.getPredictedImagePath() + "', " + p.getExperto_id() 
	          + ", " + p.getAnimal_id() + ", " + p.getRegistro_id() +  ")");
	      statements = statements + "INSERT INTO prediction (confianza, es_predecido, es_correcto, mensaje, direccon_imagen, experto_id, animal_detectado, registro_id) "
		          +"VALUES (" + p.getConfidence() + ", TRUE, TRUE, '" + p.getMessage() + "', '" + p.getPredictedImagePath() + "', " + p.getExperto_id() 
		          + ", " + p.getAnimal_id() + ", " + p.getRegistro_id() +  "); \n";
	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	}
	public void closeConnection() {
		 BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("ficheros/Evern DDL.txt"));
			writer.write(statements);
		    
		    writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		    
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}  