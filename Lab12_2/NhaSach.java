package Lab12_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NhaSach {
	private List<AnPham> danhSachAnPham = new ArrayList<>();

	public void add(AnPham ap) {
		this.danhSachAnPham.add(ap);

	}

	public String toString() {
		return danhSachAnPham.toString();
	}

	// Cau 6
	public long tongTien() {
		return danhSachAnPham.stream().collect(Collectors.summarizingLong(AnPham::getGia)).getSum();
	}

	// Cau 7
	public AnPham timSachThamKhaoNhieuTrangNhat() {
		Comparator<AnPham> comparator = (ap1, ap2) -> {
			SachThamKhao tk1 = (SachThamKhao) ap1;
			SachThamKhao tk2 = (SachThamKhao) ap2;
			return Long.compare(tk1.getMaxChuongSach().getSoTrang(), tk2.getMaxChuongSach().getSoTrang());
		};
		return danhSachAnPham.stream().filter(x -> x.loaiAnPham().equals("Sach Tham Khao")).max(comparator).get();
	}

	// Cau 8
	public boolean coChuaTapChi(String tenTapChi) {
		return danhSachAnPham.stream().filter(x -> x.loaiAnPham().equals("Tap Chi"))
				.filter(x -> ((TapChi) x).getTenTapChi().equals(tenTapChi)).count() != 0;
	}

	// Cau 9
	public List<AnPham> danhSachTapChi(int namXuatBan) {
		return this.danhSachAnPham.stream().filter(x -> x.loaiAnPham().equals("Tap Chi")
				&& x.getNamXuatBan() == namXuatBan).collect(Collectors.toList());

	}

	// Cau 10
	public void sapXepTheoTieuDeVaNamXuatBan() {
		Comparator<AnPham> comparator = Comparator.comparing(AnPham::getTieuDe).thenComparing(AnPham::getNamXuatBan,
				Comparator.reverseOrder());
		danhSachAnPham.sort(comparator);

	}

	// Cau 11
	public Map<Integer, Long> thongKeSoLuongAnPhamTheoNamXuatBan() {
		return danhSachAnPham.stream().collect(Collectors.groupingBy(AnPham::getNamXuatBan, Collectors.counting()));
	}

}
