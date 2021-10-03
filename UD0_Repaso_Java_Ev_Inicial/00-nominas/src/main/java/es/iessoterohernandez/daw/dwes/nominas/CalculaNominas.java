package es.iessoterohernandez.daw.dwes.nominas;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import es.iessoterohernandez.daw.dwes.nominas.laboral.ConexionBD;
import es.iessoterohernandez.daw.dwes.nominas.laboral.DatosNoCorrectosException;
import es.iessoterohernandez.daw.dwes.nominas.laboral.Empleado;
import es.iessoterohernandez.daw.dwes.nominas.laboral.EmpleadosDAO;
import es.iessoterohernandez.daw.dwes.nominas.laboral.Nomina;

/**
 * Hello Nóminas!
 *
 */
public class CalculaNominas 
{
//    /**
//     * Método main correspondiente a la parte 1 del ejercicio
//     * @param args
//     */
//	public static void main( String[] args )
//    {
//        try {
//        	//cambio el dni del enunciado de ambos empleados por uno correcto porque estoy hacendo la validación del mismo
//	    	Empleado e1=new Empleado("James Coslng","48811600B",'M',4,7); 
//	        Empleado e2=new Empleado("Ada Lovelace", "48814047C", 'F');
//	        escribe(e1, e2);
//	        
//	        e2.incrAnyo();
//	        e1.setCategoria(9);
//	        escribe(e1, e2);
//        }catch (DatosNoCorrectosException e) {
//        	System.out.println(e.getMessage());
//        }
//    }
//	
//    private static void escribe(Empleado e1, Empleado e2) {
//    	System.out.println(e1.imprime() +  " - Sueldo="+ Nomina.sueldo(e1));
//    	System.out.println(e2.imprime() + " - Sueldo="+ Nomina.sueldo(e2));
//    }
	
//    /**
//     * Método main correspondiente a la parte 2 del ejercicio leyendo y escribiendo en ficheros
//     * @param args
//     */
//	public static void main( String[] args )
//    {
//        try {
//        	//Fichero de entrada
//        	File fentrada = new File("empleados.txt");
//	        FileReader fr = new FileReader(fentrada);
//	        BufferedReader br = new BufferedReader(fr);
//	        
//	        //Fichero de texto de salida para actualizar el de entrada
//        	File fentradaActualizada = new File("empleadosActualizados.txt");
//	        FileWriter fw = new FileWriter(fentradaActualizada);
//	        BufferedWriter bw = new BufferedWriter(fw);
//	        
//	        //Fichero binario de salida
//	        File fsalida = new File("salarios.dat");
//	        FileOutputStream fos = new FileOutputStream(fsalida);
//	        BufferedOutputStream bos = new BufferedOutputStream(fos);
////	        OutputStreamWriter bos = new OutputStreamWriter(fos);
//	        
//	        //Variables
//	        String line;;
//	        Empleado e;
//	        String []datosEmp;
//	        
//	        while (br.ready()) {
//	        	//Leemos línea por línea el fichero de entrada
//	        	line = br.readLine();
//	        	datosEmp = line.split(";");
//	        	if (datosEmp.length == 3) //en el caso de que en la línea solo haya 3 datos del empleado
//	        		e = new Empleado(datosEmp[0], datosEmp[1], datosEmp[2].toCharArray()[0]);
//	        	else //en el caso de que vayan todos los datos
//	        		e = new Empleado(datosEmp[0], datosEmp[1], datosEmp[2].toCharArray()[0], Integer.parseInt(datosEmp[3]), Integer.parseInt(datosEmp[4]));
//
//	        	escribeEmp(e);
//	        	
//	        	//Escribimos en el fichero binario
//	        	bos.write((e.dni + ";" + Nomina.sueldo(e)+'\n').getBytes());
////	        	bos.write(e.dni + ";" + Nomina.sueldo(e)+'\n');
//	        	
//	        	if (e.nombre.equalsIgnoreCase("James Cosling")) {
//	        		e.setCategoria(9);
//	        	}else if (e.nombre.equalsIgnoreCase("Ada Lovealace")) {
//	        		e.incrAnyo();
//	        	}
//
//	        	//Actualizamos el fichero de entrada
//	        	bw.write(e.nombre+";"+e.dni+";"+e.sexo+";"+e.getCategoria()+";"+e.anyos+'\n');
//	        }
//	        
//	        //Cerramos todos los búferes
//	        br.close();
//	        bos.close();
//	        bw.close();
//	        
//	        //renombramos para dejar el mismo fichero de entrada
//	        fentrada.delete();
//	        fentradaActualizada.renameTo(fentrada);
//	                
//	      }catch (FileNotFoundException e){
//	    	  e.printStackTrace();
//	      }catch (IOException e) {
//	    	  e.printStackTrace();
//	      }catch (DatosNoCorrectosException e) {
//			e.printStackTrace();
//	      }catch (SQLException throwables) {
//			throwables.printStackTrace();
//		}
//    }
//    
//    private static void escribeEmp(Empleado e1) {
//    	System.out.println(e1.imprime() +  " - Sueldo="+ Nomina.sueldo(e1));
//    }
	
	/**
     * Método main correspondiente a la parte 2 del ejercicio leyendo y escribiendo de base de datos
     * @param args
     */
//	public static void main( String[] args )
//    {
//        //Conexón a la base de datos
//        Connection con = ConexionBD.getConnection();
//        ArrayList<Empleado> lista_empleados = new ArrayList<Empleado>();
//        Empleado e;
//	        
//        try {    
//	        Statement st=con.createStatement();
//	        ResultSet rs=st.executeQuery("select nombre, dni, sexo, categoria, anyos from empleados");
//	        
//			while (rs.next()) {
//				e = new Empleado(rs.getString(1), rs.getString(2),  rs.getString(3).toCharArray()[0], rs.getInt(4), rs.getInt(5));
//				lista_empleados.add(e);
//			}
//			
////			System.out.println(lista_empleados.toString());
//			//Actualizamos los datos de los empleados
//				
//			Iterator<Empleado> it = lista_empleados.iterator();
//			while (it.hasNext()) {
//				e=it.next();
//				if (e.nombre.equalsIgnoreCase("James Cosling")) {
//	        		e.setCategoria(9);
//	        		st.execute("update empleados e set e.categoria="+e.getCategoria()+" where e.nombre='James Cosling'");
//	        	}else if (e.nombre.equalsIgnoreCase("Ada Lovealace")) {
//	        		e.incrAnyo();
//	    			st.execute("update empleados e set e.anyos="+e.anyos+" where e.nombre='Ada Lovealace'");
//	        	}
//				//Insertamos el sueldo del empleado
//				st.execute("insert into nominas(dni, sueldo) values ('"+e.dni+"','"+Nomina.sueldo(e)+"')");
//			}
//	        
//
//	          
//	      }catch (SQLException ex) {
//	    	  ex.printStackTrace();
//	      }catch (DatosNoCorrectosException ex) {
//	    	  ex.printStackTrace();
//
//	      }
//    }
//    
//    private static void escribeEmp(Empleado e1) {
//    	System.out.println(e1.imprime() +  " - Sueldo="+ Nomina.sueldo(e1));
//    }
	
	/**
	  * Método main correspondiente a la parte 2 del ejercicio: Métodos "altaEmpleados" 
	  * @param args
	  */
	public static void main( String[] args )
    {
        EmpleadosDAO.altaEmpleado("empleadosNuevos.txt");
    }
   
}
