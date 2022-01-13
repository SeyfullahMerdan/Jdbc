package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelfwork_DML {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		/* DQL  ---- >> Data Query Language         SELECT                                          ExecuteQuery
		   DDL  ---- >> Data Definition Language    CREATE / ALTER /DROP                               Execute
		   DML  ---- >> Data Manipulation Language  INSERT/ UPDATE/ SET/ DELETE                 Execute,ExecuteUpdate
		   Execute Update  -- İşlem yaptıgı satır sayısını döndürür.
		                      Büyük verilerde DML de 'EUpdate' kullanmak daha mantıklı. 
		 */
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");	
	    Statement zone= con.createStatement();
	    
	 /*   String table= "CREATE TABLE nufus(ad VARCHAR(20),soyad VARCHAR(20),cinsiyet CHAR(5),kimlikno DOUBLE,ikamet VARCHAR(15));";
		zone.execute(table);
		System.out.println("nufus tablosu oluşturuldu.");          */
	    
	    
	 /*   zone.executeUpdate("INSERT INTO nufus VALUES('ahmet', 'ozel', 'e', 987654321, 'ankara')");
	    System.out.println("Veriler tabloya eklendi.");   */
	    
	 /*  int eklenenSayi=zone.executeUpdate("INSERT INTO nufus VALUES('merve', 'kuzgun', 'k', 789456123, 'istanbul')");
	    System.out.println("Tabloya "+ eklenenSayi + " veri girişi yapıldı.");  // Tabloya 1 veri girişi yapıldı.
	 */
	    
	    
// ================================================================================================================
// ==== >>>>  TOPLU VERİ GİRİŞİNDE ARRAY KULLANACAM. VE FOREACH İLE ARRAYİN İÇİNDE DÖNEREK EKLEYECEM
// ================================================================================================================
	    
	   /* String girisler[]=  { "INSERT INTO nufus VALUES('emre', 'bilgin', 'e', 321654987, 'mersin')",
	                          "INSERT INTO nufus VALUES('selma', 'kuzu', 'k', 963852741, 'adana')",
	                          "INSERT INTO nufus VALUES('esra', 'tarhan', 'k', 741852963, 'izmir')" };
		
		int count=0;
		for (String e : girisler) {  
			zone.executeUpdate(e);          // forun scopu farklı Arraye ekleme yapmaz ama biz SQL tablosuna ekliyoruz. Scope SQL'de yok.
			count++;  // kaç verinin girildigini syacak
		}
		System.out.println(count + " verinin girişi yapıldı");
		*/

// ==================================================================================================================
		
		   /*                             addBatch            --> Topluluk Haline Eklemek 
		                                  executeBatch        --> Topluluk Halinde olan verileri işle
		                                                                                              Bu yöntemle de veri ekleyecegim...        */                                      
		      
		
		 String girisler2 []=  { "INSERT INTO nufus VALUES('hasan', 'sacan', 'e', 753159654, 'antep')",
                                 "INSERT INTO nufus VALUES('serap', 'belgin', 'k', 951357789, 'trabzon')",
                                 "INSERT INTO nufus VALUES('furkan', 'kara', 'e', 258147369, 'karaman')" };
		
		
		 for (String e : girisler2) {
			 zone.addBatch(e);    // foreachten gelen elemanları toparlayacak batchin içinde. Gelen verileri bekletecek
			                      // geleni atmayacam. hepsi toplansın sonra atacam.	 
		}
		 zone.executeBatch();     // gelen-bekleyen verileri toplu olarak sql database'e gönderiyorum.
		 System.out.println("Veriler Gönderildi.");
                                                                                           
		 
// ===================================================================================================================
		 
		 
		/* 
		 String yeniGirisler []= { "INSERT INTO nufus(ad,soyad,cinsiyet) VALUES('erkan', 'akan', 'e')",
                                   "INSERT INTO nufus(kimlikno,ikamet) VALUES(369258147, 'manisa')"  };
		 
		 for (String e : yeniGirisler) {
		zone.addBatch(e);
		}
		 zone.executeBatch();
		 System.out.println("Yeni parçalı verilerin girişi tamamlandı...");         */
		 
// ===================================================================================================================		 
		 
		 
		 zone.close();
		 con.close();
		 
		
	}

}
