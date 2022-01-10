package techproed.jdbcOrnekler;

import java.sql.Connection;       // importları hep java.sqlden yapıyoruz.
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1Query01 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

     
		// İlgili driveri yüklemeliyiz. (fişi takma eylemi gibi, hangi cihazsa o cihazın fişini takarız)   
	 
		
		Class.forName("com.mysql.cj.jdbc.Driver");   // burda driveri girdim, mysqli kullancagını bildi ama herhangi bir bulamama durumuna karşılık
		// kendisini saglama aldı ve throws ClassNotFoundException hatasını handle etmemizi istedi. 
      		
		
		// baglantı oluşturmalıyız. programa girdiginde şifre ile verilere erişebilmeli (uydu şifrelerini girmeliyiz.)
		
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
		//                                                                                         mysql=username  mysql=şifre
		// bunu yapmadan da yapabiliriz.Daha sonra görecegiz.
		// direk .con.createStatement() şeklinde devam edebiliriz. Ama ben her şey daha belirgin olsun diye bir Statement classından veri
        // oluşturup o variablea assign edecem.		
		// SQL komutları için bir Statement nesnesi oluştur. Her kanal için kumanda da yer ayarlamak gibi bir şey...
		// bir alan oluşturacagız. alan oluşturarak gelcek veriye yer ayırıyorum.
		con.createStatement();
        Statement st= con.createStatement();  // açtıgım alan		
		
		// SQL ifadeleri yazabilir ve çalıştırabilriz. ...Kumanda da 1'e basarım, ve tv kanallarından birisi gelir gibi düşünebiliriz...
		     // açtıgım alana sorgu yapıyorum.
        ResultSet veri = st.executeQuery("SELECT isim,maas FROM personel WHERE id=123456789"); //Burda bir sorgu yapıyorum. ()içine istedigim sorguyu yazdım.
        // bu sorgu buraya geldi, şimdi bu sorguyla gelen veriyi SYSO içinde yazdıracagım.
                                           // komple sağ tarafı yazmak yerine bu veriyi bir variablea assign ettim...
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
