package Lab12_2;

public class TapChi extends AnPham {
	private String tenTapChi;

	public TapChi(String tieuDe, int soTrang, int namXuatBan, String tacGia, int gia, String tenTapChi) {
		super(tieuDe, soTrang, namXuatBan, tacGia, gia);
		this.tenTapChi = tenTapChi;
	}

	public String getTenTapChi() {
		return tenTapChi;
	}

	public void setTenTapChi(String tenTapChi) {
		this.tenTapChi = tenTapChi;
	}

	public String loaiAnPham() {
		return "Tap Chi";

	}

	public boolean laTapChiXuatBan10Nam(int namHienTai) {
		return (namHienTai - this.namXuatBan) == 10;

	}

	@Override
	public String toString() {
		return tieuDe + " " + soTrang + " " + namXuatBan + " " + tacGia + " " + gia + " " + tenTapChi;
	}

}
