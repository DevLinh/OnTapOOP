import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    private static int menu() {
        int n;
        Scanner cin = new Scanner(System.in);
        System.out.println("Vui long dua ra lua chon!");
        System.out.println("1. Them Giao Dich Dat");
        System.out.println("2. Them Giao Dich Nha");
        System.out.println("3. Tính trung bình thành tiền của tất cả các giao dịch đất.");
        System.out.println("4. Xuat danh sach dung Array List");
        System.out.println("5. Đổi đơn giá của giao dịch có mã được nhập từ bàn phím");
        System.out.println("6. Xuất ra các giao dịch của tháng 3 năm 2019.");
        System.out.println("7. Xóa giao dịch theo mã nhập từ bàn phím");
        System.out.println("8. Sắp xếp danh sách tăng dần theo đơn giá/ ngày giao dịch/ diện tích");
        System.out.println("0. EXIT!!!");
        System.out.print(">> ");
        n = cin.nextInt();
        return n;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        ArrayList<GiaoDich> ds = new ArrayList<>();
        byte chon;
        while(true) {
            switch (menu()) {
                case 1:
                    System.out.println("Giao Dich Dat");
                    GiaoDichDat d = new GiaoDichDat();
                    d.Input();
                    ds.add(d);
                    break;
                case 2:
                    System.out.println("Giao Dich Nha");
                    GiaoDichNha n = new GiaoDichNha();
                    n.Input();
                    ds.add(n);
                    break;
                case 3:
                    int dem = 0;
                    double sum = 0;
                    for(GiaoDich g : ds) {
                        if(g instanceof GiaoDichDat) {
                            sum += g.ThanhTien();
                            dem++;
                        }
                    }

                    System.out.println("Tính trung bình thành tiền của tất cả các giao dịch đất: " + sum/dem );
                case 4:
                    if (ds.isEmpty()) {
                        System.out.println("CHUA CO THONG TIN, VUI LONG NHAP LIEU TRUOC KHI XEM");
                        break;
                    }
                    do {
                        System.out.println("Nhap 1: xuat danh sach GIAO DICH DAT");
                        System.out.println("Nhap 2: xuat danh sach GIAO DICH NHA");
                        System.out.print(">> ");
                        chon = cin.nextByte();
                        if (chon > 2 || chon < 1) {
                            System.out.println("Lua chon khong hop le! VUI long lua chon lai");
                        }
                    } while (chon > 2 || chon < 1);
                    if (chon == 1) {
                        for(GiaoDich g : ds) {
                            if (g instanceof GiaoDichDat) {
                                g.Output();
                                System.out.println("");
                            }
                        }
                    } else {
                        for(GiaoDich g : ds) {
                            if (g instanceof GiaoDichNha) {
                                g.Output();
                                System.out.println("");
                            }
                        }
                    }
                    break;
                case 6:
                    if (ds.isEmpty()) {
                        System.out.println("CHUA CO THONG TIN, VUI LONG NHAP LIEU TRUOC KHI XEM");
                        break;
                    }
                    do {
                        System.out.println("Các giao dịch của tháng 3 năm 2019.");
                        System.out.println("Nhap 1: GIAO DICH DAT");
                        System.out.println("Nhap 2: GIAO DICH NHA");
                        System.out.print(">> ");
                        chon = cin.nextByte();
                        if (chon > 2 || chon < 1) {
                            System.out.println("Lua chon khong hop le! VUI long lua chon lai");
                        }
                    } while (chon > 2 || chon < 1);
                    if (chon == 1) {
                        for(GiaoDich g : ds) {
                            if (g instanceof GiaoDichDat && g.getYear() == 2019 && g.getMonth() == 3) {
                                g.Output();
                                System.out.println("");
                            }
                        }
                    } else {
                        for(GiaoDich g : ds) {
                            if (g instanceof GiaoDichNha && g.getYear() == 2019 && g.getMonth() == 3) {
                                g.Output();
                                System.out.println("");
                            }
                        }
                    }
                    break;
                case 8:
                    //Sap xep

                default:
                    System.out.println("Thoat...");
                    System.exit(0);
            }
        }
    }

}
