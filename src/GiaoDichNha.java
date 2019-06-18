import java.util.Scanner;

//Giao dịch nhà: Mã giao dịch, ngày giao dịch (ngày/ tháng/năm), đơn giá, loại nhà
//(cao cấp, thường), địa chỉ, diện tích, thông tin của nhân viên bán (mã nhân viên,
//tên nhân viên,điện thoại). Nếu là loại nhà cao cấp thì thành tiền = diện tích * đơn
//giá, nếu là loại thường thì thành tiền = diện tích * đơn giá * 90%.
public class GiaoDichNha extends GiaoDich{
    private String LoaiNha;
    private String DiaChi;

    //constructor
    public GiaoDichNha(String maGD, String ngayGD, double donGia, double dienTich, NhanVien NV, String loaiNha, String diaChi) {
        super(maGD, ngayGD, donGia, dienTich, NV);
        LoaiNha = loaiNha;
        DiaChi = diaChi;
    }

    public GiaoDichNha() {
        super();
        LoaiNha = "";
        DiaChi = "";
    }

    //getter & setter


    public String getLoaiNha() {
        return LoaiNha;
    }

    public void setLoaiNha(String loaiNha) {
        LoaiNha = loaiNha;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    //method
    public void Input() {
        super.Input();
        Scanner cin = new Scanner(System.in);
        String p;
        System.out.print("Nhap Loai Nha(Cao cap/ Thuong): ");
        p = cin.nextLine();
        setLoaiNha(p);
        System.out.print("Dia Chi: ");
        p = cin.nextLine();
        setDiaChi(p);
    }

    public void Output() {
        super.Output();
        System.out.printf(" %-10s %-30s %-10.2f ", getLoaiNha(),getDiaChi(), ThanhTien());
    }

    double ThanhTien() {
        if (getLoaiNha().toLowerCase().equals("thuong")) {
            return getDonGia()*getDienTich()*0.9;
        } else
            return getDonGia()*getDienTich();
    }
}
