package techproed.jdbcOrnekler;

public class JdbcSelWorkPojo {

		private String ad;
		private String soyad;
		private double maas;
		private int nobetsira;


		
		public JdbcSelWorkPojo(String ad, String soyad, double maas, int nobetsira) {
			super();
			this.ad = ad;
			this.soyad = soyad;
			this.maas = maas;
			this.nobetsira = nobetsira;
		}
		
		
		
		public String getAd() {
			return ad;
		}
		public void setAd(String ad) {
			this.ad = ad;
		}
		public String getSoyad() {
			return soyad;
		}
		public void setSoyad(String soyad) {
			this.soyad = soyad;
		}
		public double getMaas() {
			return maas;
		}
		public void setMaas(double maas) {
			this.maas = maas;
		}
		public int getNobetsira() {
			return nobetsira;
		}
		public void setNobetsira(int nobetsira) {
			this.nobetsira = nobetsira;
		}
		
		
		
		@Override
		public String toString() {
			return "JdbcSelWorkPojo [ad=" + ad + ", soyad=" + soyad + ", maas=" + maas + ", nobetsira=" + nobetsira
					+ "]";
		}

		
		
}