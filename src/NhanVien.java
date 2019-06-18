import java.util.Scanner;

// thông tin của nhân viên bán (mã nhân viên, tên nhân viên,điện thoại)
public class NhanVien {
    private String MaNV;
    private String TenNV;
    private String SoDT;

    //constructor
    public NhanVien(String maNV, String tenNV, String soDT) {
        MaNV = maNV;
        TenNV = tenNV;
        SoDT = soDT;
    }

    public NhanVien(NhanVien n) {
        MaNV = n.MaNV;
        TenNV = n.TenNV;
        SoDT = n.SoDT;
    }

    public NhanVien() {
        MaNV = "";
        TenNV = "";
        SoDT = "";
    }

    //getter & setter


    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String soDT) {
        SoDT = soDT;
    }
    //method
    public void Input() {
        Scanner cin = new Scanner(System.in);
        String temp;
        System.out.print("Nhap Ma Nhan Vien: ");
        temp = cin.nextLine();
        setMaNV(temp);
        System.out.print("Nhap Ten Nhan Vien: ");
        temp = cin.nextLine();
        setTenNV(temp);
        System.out.print("So Dien Thoai: ");
        temp = cin.nextLine();
        setSoDT(temp);
    }

    public void Output() {
        System.out.printf("%-10s %-30s %-10s ",getMaNV(), getTenNV(), getSoDT());
    }
}
