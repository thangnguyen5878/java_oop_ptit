public class NhanVien extends CanBo {
    // Attributes
    private String congViec;

    // Constructors
    public NhanVien(String hoTen, int tuoi, String gioiTinh, String diaChi, String congViec) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.congViec = congViec;
    }

    public NhanVien() {
        super();
        this.congViec = "";
    }

    // Getters and Setters
    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }
}
