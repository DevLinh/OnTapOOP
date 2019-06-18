import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//Mã giao dịch, ngày giao dịch (ngày/tháng/ năm), đơn giá, diện tích, thông tin của nhân viên bán (mã nhân viên, tên nhân
//viên,điện thoại).
abstract public class GiaoDich {
    private String MaGD;
    private String NgayGD;
    private double DonGia;
    private double DienTich;
    private NhanVien NV = new NhanVien();

    //để truy xuất đơn giản, ta đã nhập ngày dạng SimpleDateFormat ở Input()
    // ta tiến hành chiết xuất tháng và năm ra rồi lưu trữ dưới dạng thuộc tính
    private int month;
    private int year;

    //constructor

    public GiaoDich(String maGD, String ngayGD, double donGia, double dienTich, NhanVien NV) {
        MaGD = maGD;
        NgayGD = ngayGD;
        DonGia = donGia;
        DienTich = dienTich;
        this.NV = NV;
    }

    public GiaoDich() {
        MaGD = "";
        NgayGD = "";
        DonGia = 0f;
        DienTich = 0f;
    }

    //getter & setter

    public String getMaGD() {
        return MaGD;
    }

    public void setMaGD(String maGD) {
        MaGD = maGD;
    }

    public String getNgayGD() {
        return NgayGD;
    }

    public void setNgayGD(String ngayGD) {
        NgayGD = ngayGD;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double donGia) {
        DonGia = donGia;
    }

    public double getDienTich() {
        return DienTich;
    }

    public void setDienTich(double dienTich) {
        DienTich = dienTich;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //method
    public void Input() {
        Scanner cin = new Scanner(System.in);
        String temp;
        String dateString;
        double l;
        System.out.print("Ma Giao Dich: ");
        temp = cin.nextLine();
        setMaGD(temp);
        System.out.print("Ngay Giao Dich (dd/MM/yyyy): ");
        dateString = cin.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date d = dateFormat.parse(dateString);
            Calendar c;
            c = Calendar.getInstance();
            c.setTime(d);
            setYear(c.get(Calendar.YEAR));
            setMonth(c.get(Calendar.MONTH) + 1);//+1 là quan trọng bởi vì các tháng mang giá trị trương ứng từ 0 đến 11 // Is Important Because if the month is January then coming 0 so Add +1
        } catch (ParseException e) {
            System.out.println("Ngay khong hop le!!!");
            e.printStackTrace();
        }
        setNgayGD(dateString);
        System.out.print("Don Gia: ");
        l = cin.nextDouble();
        setDonGia(l);
        System.out.print("Dien Tich: ");
        l = cin.nextDouble();
        setDienTich(l);
        NV.Input();
    }

    public void Output() {
        System.out.printf("%-10s %-15s %-10.2f %-10.2f", getMaGD(), getNgayGD(), getDonGia(), getDienTich());
        NV.Output();
    }

    /*public static Comparator<GiaoDich> DonGIaComparator = new Comparator<GiaoDich>() {
        @Override
        public boolean compare(GiaoDich o1, GiaoDich o2) {
            double dg1 = o1.getDonGia();
            double dg2 = o2.getDonGia();
            return dg1 > dg2;
        }
    }*/

    abstract double ThanhTien();
}
