package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelfwork_DDL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
		Statement zone= con.createStatement();
		
		
		// ====================================== //
		
	/*	
	  String talebe= "CREATE TABLE talebe "
	  		+ "(ad VARCHAR(25),"
	  		+ "soyad VARCHAR(25),"
	  		+ "bolum CHAR(3),"
	  		+ "notu DOUBLE);"	;
		
		zone.execute(talebe);
		System.out.println("Talebe tablosu oluştu.");
		*/
		
		
	/*	
	  String nufus= "CREATE TABLE nufus "
	  		+ "(adsoyad VARCHAR(40),"
	  		+ "kimlikno DOUBLE,"
	  		+ "ikamet VARCHAR(25),"
	  		+ "mdurum CHAR(5),"
	  		+ "meslek VARCHAR(30),"
	  		+ "bireys INT);";
	
	   zone.execute(nufus);
	   System.out.println("Nufus tablosu oluştu");
		
		*/
		
		
	/*	
		zone.execute("DROP TABLE isciler");
		System.out.println("Tablo başarı ile silindi");        */
		
		
	/*	zone.execute("DROP TABLE talebe");
		System.out.println("Talebe tablosu başarı ile silindi");      */

		
	/*	zone.execute( "ALTER TABLE nufus ADD gelir DOUBLE" );
		System.out.println("Nufus tablosuna Gelir sutunu eklendi.");  */
		
	/*  zone.execute("ALTER TABLE nufus ADD cinsiyet CHAR(5)");
		System.out.println("Nufus tablosuna cinsiyet eklendi...");   */
		
		
	/*    zone.execute("ALTER TABLE nufus ADD (sırano int,bolum VARCHAR(20))");	
		System.out.println("Nufus tablosuna iki tane birden sutun ekledim");        */
		
		
		
	/*	zone.execute("ALTER TABLE nufus DROP COLUMN sırano");
		System.out.println("Nufus tablsoundan sırano silindi");   */
		
		
	/*	zone.execute("ALTER TABLE nufus DROP COLUMN bolum,DROP COLUMN ikamet");
		System.out.println("Nufus tablsoundan iki sutun silindi");         */
		                                    
		
	/*	zone.execute("ALTER TABLE nufus RENAME TO nufusbilgi");
		System.out.println("Tablonun ismini degiştirdim");       */
		
		
		String dropTable="DROP TABLE nufusbilgi";           // -->  Önce bir Variable oluşturdum, komutumu variablea atadım.
		zone.execute(dropTable);                              // --> Komut atadıgım variable'ı execute içinde run ediyorum
		System.out.println("nufusbilgi tabosu silindi");
		
		
		zone.close();
		con.close();
		
	}

}
