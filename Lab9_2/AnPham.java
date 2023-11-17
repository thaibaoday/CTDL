package Lab9_2;

public class AnPham {
	String tieuDe;
	int soTrang;
	int namXuatBan;
	String tacGia;
	int giaTien;

	public AnPham(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giaTien) {
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
		this.namXuatBan = namXuatBan;
		this.tacGia = tacGia;
		this.giaTien = giaTien;
	}

	public Object getType() {
		return this.tacGia;
	};

}
