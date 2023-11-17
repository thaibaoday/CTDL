package Lab9_2;

import java.util.List;

public class SachThamKhao extends AnPham{
	private String linhVuc;
	List<ChungSach> dsChungSach;
	public SachThamKhao(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giaTienString, int giaTien ,String linhVuc, List<ChungSach> dsChungSach) {
		super(tieuDe, soTrang,namXuatBan, tacGia, giaTien);
		this.linhVuc = linhVuc;
		this.dsChungSach = dsChungSach;
	}
	 public String getType() {
	        return "Sách tham khảo";
	 }

}
