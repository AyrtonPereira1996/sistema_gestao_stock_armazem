package mz.com.SistemaArmazemFCSP.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
   private static final String usuario="root";
   private static final String senha="123456";
   private static final String url="jdbc:mysql://localhost:3306/bd_arm_fcsp?useTimezone=true&serverTimezone=UTC";
   
   public static Connection conectar() throws SQLException {
	   
	   DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
	   
	   Connection conexao=DriverManager.getConnection(url, usuario,senha);
	   return conexao;
   }
   
   public static void main(String[] args) {
	
	   try {
		Connection conexao=Conexao.conectar();
		System.out.println("Conectado com sucesso");
		conexao.close();
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Falha na conexão");
		// TODO: handle exception
	}
}
	
}
