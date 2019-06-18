import java.util.Scanner;

//Giao dịch đất: Mã giao dịch, ngày giao dịch (ngày/tháng/ năm), đơn giá, loại đất
//(loại A, B, C), diện tích, thông tin của nhân viên bán (mã nhân viên, tên nhân
//viên,điện thoại). Nếu là loại B, C thì thành tiền = diện tích * đơn giá. Nếu là loại A
//thì thành tiền = diện tích * đơn giá * 1.5.
public class GiaoDichDat extends GiaoDich {
    private String LoaiDat;

    //constructor


    public GiaoDichDat(String maGD, String ngayGD, double donGia, double dienTich, NhanVien NV, String loaiDat) {
        super(maGD, ngayGD, donGia, dienTich, NV);
        LoaiDat = loaiDat;
    }

    public GiaoDichDat() {
        super();
        LoaiDat = "";
    }

    //getter & setter

    public String getLoaiDat() {
        return LoaiDat;
    }

    public void setLoaiDat(String loaiDat) {
        LoaiDat = loaiDat;
    }

    //method
    public void Input() {
        super.Input();
        Scanner cin = new Scanner(System.in);
        String p;
        System.out.print("Nhap Loai Dat(A/B/C): ");
        p = cin.nextLine();
        setLoaiDat(p);
    }

    public void Output() {
        super.Output();
        System.out.printf(" %-5s %-10.2f ", getLoaiDat(), ThanhTien());
    }
    double ThanhTien() {
        if (getLoaiDat().toUpperCase().equals("A"))
            return 1.5*getDonGia()*getDienTich();
        else
            return getDonGia()*getDienTich();
    }
}
