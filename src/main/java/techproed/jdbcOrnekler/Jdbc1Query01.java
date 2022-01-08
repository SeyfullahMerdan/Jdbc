package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1Query01 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

     
		// İlgili driveri yüklemeliyiz. (fişi takma eylemi gibi, hangi cihazsa o cihazın fişini takarız)   
	 
		
		Class.forName("com.mysql.cj.jdbc.Driver");
      		
		
		// baglantı oluşturmalıyız. programa girdiginde şifre ile verilere erişebilmeli (uydu şifrelerini girmeliyiz.)
		
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
		
		
		// SQL komutları için bir Statement nesnesi oluştur. Her kanal için kumanda da yer ayarlamak gibi bir şey...
		
        
        Statement st= con.createStatement();		
		
		// SQL ifadeleri yazabilir ve çalıştırabilriz. ...Kumanda da 1'e basarım, ve tv kanallarından birisi gelir gibi düşünebiliriz...
		
		
        ResultSet veri = st.executeQuery("SELECT isim,maas FROM personel WHERE id=123456789");
        
        // Sonuçları alırım ve işlerim...
        
        while (veri.next()) {
			System.out.println(veri.getString("isim") + " " + veri.getInt("maas") );
			
			System.out.println("Personel Adi: " + veri.getString(1) + " " + "Maaş: " + veri.getInt(2)  );
					
		}
        
        
        // oluşturulan nesneleri bellekten kaldıralım
        
        con.close();
 		st.close();
 		veri.close();
        
 		// bunun altına mysql den veri getiremem. closelardan önce işlem yapabilirm. 
        
	}

}
