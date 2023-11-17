package Lab9_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhMucAnPham {
	List<AnPham> dmAnPham;

	public DanhMucAnPham() {

		this.dmAnPham = new ArrayList<>();

	}

	public void addPublication(AnPham dmPham) {
		this.dmAnPham.add(dmPham);
	}

	public boolean isMagazineAndPublished10YearsAgo(AnPham dmPham) {
		return dmPham instanceof TapChi && dmPham.namXuatBan == 2021;
	}

	public boolean isSameTypeAndAuthor(AnPham p1, AnPham p2) {
		return p1.getType().equals(p2.getType()) && p1.tacGia.equals(p2.tacGia);
	}

	public double getTotalPrice() {
		double total = 0;
		for (AnPham p : dmAnPham) {
			total += p.giaTien;
		}
		return total;
	}

	public SachThamKhao getReferenceBookWithMostPages() {
		SachThamKhao maxBook = null;
		int maxPages = 0;
		for (AnPham p : dmAnPham) {
			if (p instanceof SachThamKhao) {
				SachThamKhao book = (SachThamKhao) p;
				for (ChungSach c : book.dsChungSach) {
					if (c.soTrang > maxPages) {
						maxPages = c.soTrang;
						maxBook = book;
					}
				}
			}
		}
		return maxBook;
	}

	public boolean containsMagazine(String tenTapChi) {
		for (AnPham p : dmAnPham) {
			if (p instanceof TapChi && ((TapChi) p).getTenTapChi().equals(tenTapChi)) {
				return true;
			}
		}
		return false;
	}

	public List<TapChi> getMagazinesPublishedInYear(int year) {
		List<TapChi> tapChi = new ArrayList<>();
		for (AnPham p : dmAnPham) {
			if (p instanceof TapChi && p.namXuatBan == year) {
				tapChi.add((TapChi) p);
			}
		}
		return tapChi;
	}

	public void sortPublications() {
		Collections.sort(dmAnPham, new Comparator<AnPham>() {
			@Override
			public int compare(AnPham p1, AnPham p2) {
				int tdCompare = p1.tieuDe.compareTo(p2.tieuDe);
				if (tdCompare != 0) {
					return tdCompare;
				} else {
					return Integer.compare(p2.namXuatBan, p1.namXuatBan);
				}
			}
		});
	}

	public Map<Integer, Integer> getPublicationCountByYear() {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (AnPham p : dmAnPham) {
			countMap.put(p.namXuatBan, countMap.getOrDefault(p.namXuatBan, 0) + 1);
		}
		return countMap;
	}

}
