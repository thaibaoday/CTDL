package Lab12_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SachThamKhao extends AnPham {
	private String linhVuc;
	private List<ChuongSach> chuongSach = new ArrayList<>();

	
	public SachThamKhao(String tieuDe, int soTrang, int namXuatBan, String tacGia, int gia, String linhVuc,
			List<ChuongSach> chuongSach) {
		super(tieuDe, soTrang, namXuatBan, tacGia, gia);
		this.linhVuc = linhVuc;
		this.chuongSach = chuongSach;
	}
	

	public void add(ChuongSach c) {
		this.chuongSach.add(c);
	}

	public List<ChuongSach> getChuongSach() {
		return chuongSach;
	}
	public ChuongSach getMaxChuongSach() {
		return chuongSach.stream().max(Comparator.comparing(ChuongSach::getSoTrang)).get();
	}
	public long tongSoTrang() {
		return chuongSach.stream().collect(Collectors.summarizingLong(ChuongSach::getSoTrang)).getSum();
	}
	public String loaiAnPham() {
		return "Sach Tham Khao";
		
	}

	@Override
	public String toString() {
		return "SachThamKhao [linhVuc=" + linhVuc + ", chuongSach=" + chuongSach + ", tieuDe=" + tieuDe + ", soTrang="
				+ soTrang + ", namXuatBan=" + namXuatBan + ", tacGia=" + tacGia + ", gia=" + gia + "]";
	}


	@Override
	public boolean laTapChiXuatBan10Nam(int namHienTai) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
