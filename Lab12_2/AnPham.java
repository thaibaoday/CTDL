package Lab12_2;

public abstract class AnPham {
	protected String tieuDe;
	protected int soTrang;
	protected int namXuatBan;
	protected String tacGia;
	protected int gia;
	public AnPham(String tieuDe, int soTrang, int namXuatBan, String tacGia, int gia) {
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
		this.namXuatBan = namXuatBan;
		this.tacGia = tacGia;
		this.gia = gia;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public int getNamXuatBan() {
		return namXuatBan;
	}
	public int getGia() {
		return gia;
	}
	//Cau 3
	public abstract String loaiAnPham();
	
	//Cau 4
	public abstract boolean laTapChiXuatBan10Nam(int namHienTai);
	
	//Cau 5
	public boolean coCungLoaiCungTacGia(AnPham ap) {
		return this.loaiAnPham().equals(ap.loaiAnPham()) && this.tacGia.equals(ap.tacGia);
	}
	

}
