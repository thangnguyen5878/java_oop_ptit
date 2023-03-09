import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class QLCB {
    private List<CanBo> danhSachCanBo;
    private Scanner scanner;

    public QLCB() {
        danhSachCanBo = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void themCanBo() {
        System.out.printf("Thêm cán bộ:\n");
        System.out.println("1. Công nhân");
        System.out.println("2. Kỹ sư");
        System.out.println("3. Nhân viên");

        int choice = 0;
        while (true) {
            System.out.println("Nhập lựa chọn của bạn (1-3): ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if(choice >= 1 || choice <= 3)
                break;
            System.out.println("Lựa chọn không hợp lệ!");
        }


        switch (choice) {
            case 1:
                themCongNhan();
                break;
            case 2:
                themKySu();
                break;
            case 3:
                themNhanVien();
                break;
        }
        troLaiManHinhChinh();
    }

    private void themCongNhan() {
        System.out.printf("Nhập thông tin công nhân:\n");
        System.out.println("Họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.println("Tuổi: ");
        int tuoi = scanner.nextInt();
        scanner.nextLine();

        // Nhập giới tính
        int temp;
        String gioiTinh = "";
        while (true) {
            System.out.println("Nhập giới tính (Nam [0], Nữ [1]): ");
            temp = scanner.nextInt();
            if (temp == 0) {
                gioiTinh = "nam";
                break;
            } else if (temp == 1) {
                gioiTinh = "nữ";
                break;
            } else {
                System.out.println("Giới tính không hợp lệ!");
            }
        };

        // Nhập địa chỉ
        System.out.println("Nhập địa chỉ: ");
        scanner.nextLine();
        String diaChi = scanner.nextLine();

        // Nhập cấp bậc của công nhân
        int bac;
        while (true) {
            System.out.println("Cấp bậc (1-10): ");
            bac = scanner.nextInt();
            scanner.nextLine();
            if(bac >= 1 || bac <= 10)
                break;
            System.out.println("Cấp bậc không hợp lệ!");
        }

        CanBo congNhan = new CongNhan(hoTen, tuoi, gioiTinh, diaChi, bac);
        danhSachCanBo.add(congNhan);

        System.out.println("Thêm công nhân thành công!");
    }

    private void themKySu() {
        System.out.printf("Nhập thông tin kỹ sư:\n");
        System.out.println("Họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.println("Tuổi: ");
        int tuoi = scanner.nextInt();
        scanner.nextLine();

        // Nhập giới tính
        int temp;
        String gioiTinh = "";
        while (true) {
            System.out.println("Nhập giới tính (Nam [0], Nữ [1]): ");
            temp = scanner.nextInt();
            if (temp == 0) {
                gioiTinh = "nam";
                break;
            } else if (temp == 1) {
                gioiTinh = "nữ";
                break;
            } else {
                System.out.println("Giới tính không hợp lệ!");
            }
        };

        // Nhập địa chỉ
        System.out.println("Nhập địa chỉ: ");
        scanner.nextLine();
        String diaChi = scanner.nextLine();

        System.out.println("Ngành đào tạo: ");
        String nganhDaoTao = scanner.nextLine();

        CanBo kySu = new KySu(hoTen, tuoi, gioiTinh, diaChi, nganhDaoTao);
        danhSachCanBo.add(kySu);

        System.out.println("Thêm kỹ sư thành công!");
    }

    private void themNhanVien() {
        System.out.printf("Nhập thông tin nhân viên:\n");
        System.out.println("Họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.println("Tuổi: ");
        int tuoi = scanner.nextInt();
        scanner.nextLine();

        // Nhập giới tính
        int temp;
        String gioiTinh = "";
        while (true) {
            System.out.println("Nhập giới tính (Nam [0], Nữ [1]): ");
            temp = scanner.nextInt();
            if (temp == 0) {
                gioiTinh = "nam";
                break;
            } else if (temp == 1) {
                gioiTinh = "nữ";
                break;
            } else {
                System.out.println("Giới tính không hợp lệ!");
            }
        };

        // Nhập địa chỉ
        System.out.println("Nhập địa chỉ: ");
        scanner.nextLine();
        String diaChi = scanner.nextLine();

        System.out.println("Công việc: ");
        String congViec = scanner.nextLine();

        CanBo nhanVien = new NhanVien(hoTen, tuoi, gioiTinh, diaChi, congViec);
        danhSachCanBo.add(nhanVien);

        System.out.println("Thêm nhân viên thành công!");
    }

    // Tìm kiếm cán bộ theo họ tên
    public void timKiem() {
        boolean found = false;
        System.out.println("Nhập họ tên cán bộ mà bạn muốn tìm kiếm: ");
        String hoTen = scanner.nextLine();
        hoTen.toLowerCase();
        for (CanBo canBo : danhSachCanBo) {
            // TH1: Tìm thấy
            if (canBo.getHoTen().toLowerCase().contains(hoTen)) {
                found = true;
                System.out.println("Họ tên: " + canBo.getHoTen());
                System.out.println("Tuổi: " + canBo.getTuoi());
                System.out.println("Giới tính: " + canBo.getGioiTinh());
                System.out.println("Địa chỉ: " + canBo.getDiaChi());
                if (canBo instanceof CongNhan) {
                    System.out.println("Cấp bậc: " + ((CongNhan) canBo).getBac());
                } else if (canBo instanceof KySu) {
                    System.out.println("Ngành đào tạo: " + ((KySu) canBo).getNganhDaoTao());
                } else if (canBo instanceof NhanVien) {
                    System.out.println("Công việc: " + ((NhanVien) canBo).getCongViec());
                }
                System.out.println("------------------------------------------");
            }
        }
        // TH2: Duyệt hết danh sách nhưng không tìm thấy
        if (found == false)
            System.out.println("Không tìm thấy cán bộ có họ tên là " + hoTen);
        troLaiManHinhChinh();
    }

    // Hiển thị danh sách cán bộ (chi tiết)
    public void hienThiDanhSach() {
        if (danhSachCanBo.isEmpty() == true) {
            System.out.println("(trống)");
        } else {
            System.out.println("Danh sách cán bộ");
            System.out.println("------------------------------------------");
            for (CanBo canBo : danhSachCanBo) {
                System.out.println("Họ tên: " + canBo.getHoTen());
                System.out.println("Tuổi: " + canBo.getTuoi());
                System.out.println("Giới tính: " + canBo.getGioiTinh());
                System.out.println("Địa chỉ: " + canBo.getDiaChi());
                if (canBo instanceof CongNhan) {
                    System.out.println("Cấp bậc: " + ((CongNhan) canBo).getBac());
                } else if (canBo instanceof KySu) {
                    System.out.println("Ngành đào tạo: " + ((KySu) canBo).getNganhDaoTao());
                } else if (canBo instanceof NhanVien) {
                    System.out.println("Công việc: " + ((NhanVien) canBo).getCongViec());
                }
                System.out.println("------------------------------------------");
            }
        }
        troLaiManHinhChinh();
    }

    // Trở lại màn hình chính (home)
    public void troLaiManHinhChinh() {
        System.out.print("Nhấn Enter để quay lại màn hình chính");
        scanner.nextLine();
        hienThiManHinhChinh();
    }

    // Màn hình chính (Home)
    public void hienThiManHinhChinh() {
        System.out.printf("Nhập lựa chọn của bạn (1-4)\n");

        System.out.printf("1. Thêm cán bộ\n");
        System.out.printf("2. Tìm kiếm theo họ tên\n");
        System.out.printf("3. Hiển thị danh sách cán bộ\n");
        System.out.printf("4. Thoát\n");

        int choice;
        while (true) {
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    themCanBo();
                    break;
                case 2:
                    timKiem();
                    break;
                case 3:
                    hienThiDanhSach();
                    break;
                case 4:
                    exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}
