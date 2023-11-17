package Lab9_2;

public class TapChi extends AnPham{
	private String tenTapChi;

	public TapChi(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giaTien, String tenTapChi) {
		super(tieuDe, soTrang,namXuatBan, tacGia, giaTien);
		this.setTenTapChi(tenTapChi);
	}
	public String getType() {
        return "Tạp Chí";
	}
	public String getTenTapChi() {
		return tenTapChi;
	}
	public void setTenTapChi(String tenTapChi) {
		this.tenTapChi = tenTapChi;
	}

}
