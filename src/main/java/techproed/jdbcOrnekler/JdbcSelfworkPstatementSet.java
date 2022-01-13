package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcSelfworkPstatementSet {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection contact=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");	
	  //  Statement zone= contact.createStatement();
		

// ==================================================================================================================
	    
	  /*   String teacher="CREATE TABLE ogretmen"
				         +"(ad VARCHAR(20),"
				         + "soyad VARCHAR(20),"
				         + "maas DOUBLE,"
				         + "nobetsira INT);";		
		zone.execute(teacher);
		System.out.println("Teacher tablosu başarı ile oluşturuldu.");       */

// ==================================================================================================================
		
		// zone.execute("ALTER TABLE ogretmen ADD cinsiyet CHAR(5)");
		// System.out.println("ogretmen tablosuna cinsiyet eklendi...");  
		
// ==================================================================================================================
		
		// zone.execute("ALTER TABLE ogretmen DROP COLUMN nobetsira");
		// System.out.println("ogretmen tablosundan nobetsira silindi..");
		
// ==================================================================================================================
		
	
		List <JdbcSelWorkPojo> girisler=new ArrayList <> ();
		
		girisler.add( new JdbcSelWorkPojo("merve", "kuzu", 5000, 1));
		girisler.add( new JdbcSelWorkPojo("hakan", "alyan", 10000,2 ));
		girisler.add( new JdbcSelWorkPojo("sena", "eren", 7000, 3));
		girisler.add( new JdbcSelWorkPojo("furkan", "meran", 8000, 4));
		girisler.add( new JdbcSelWorkPojo("aki", "koru", 3000, 5));
		
		
        PreparedStatement giris=contact.prepareStatement( "INSERT INTO ogretmen VALUES (?,?,?,?)" );

		
		for (JdbcSelWorkPojo e : girisler) {
			
			giris.setString(1, e.getAd());
			giris.setString(2, e.getSoyad());
			giris.setDouble(3, e.getMaas());
			giris.setInt(4, e.getNobetsira());
			giris.addBatch();
		}
		
          giris.executeBatch();
        
          System.out.println("veriler eklendi");
        
        
      
        
        
        
        
        
        
        
        
        
		
		
	}

}
