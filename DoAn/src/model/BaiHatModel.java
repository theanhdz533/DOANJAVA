package model;

public class BaiHatModel {
    private String maBh;
    private String tenBh;
    private String loiMoDau;
    private String theLoai;
    private String caSi;
    private String nhacSi;
    private String loiBatHat;
	
	public BaiHatModel(String maBh, String tenBh, String loiMoDau, String theLoai, String caSi, String nhacSi,
			String loiBatHat) {
		super();
		this.maBh = maBh;
		this.tenBh = tenBh;
		this.loiMoDau = loiMoDau;
		this.theLoai = theLoai;
		this.caSi = caSi;
		this.nhacSi = nhacSi;
		this.loiBatHat = loiBatHat;
	}
	public String getMaBh() {
		return maBh;
	}
	public void setMaBh(String maBh) {
		this.maBh = maBh;
	}
	public String getTenBh() {
		return tenBh;
	}
	public void setTenBh(String tenBh) {
		this.tenBh = tenBh;
	}
	public String getLoiMoDau() {
		return loiMoDau;
	}
	public void setLoiMoDau(String loiMoDau) {
		this.loiMoDau = loiMoDau;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public String getCaSi() {
		return caSi;
	}
	public void setCaSi(String caSi) {
		this.caSi = caSi;
	}
	public String getNhacSi() {
		return nhacSi;
	}
	public void setNhacSi(String nhacSi) {
		this.nhacSi = nhacSi;
	}
	public String getLoiBatHat() {
		return loiBatHat;
	}
	public void setLoiBatHat(String loiBatHat) {
		this.loiBatHat = loiBatHat;
	}
	
    
}
