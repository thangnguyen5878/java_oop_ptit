public class CongNhan extends CanBo {
    // Attributes
    private int bac; // Cấp bậc từ 1 đến 10

    // Constructors
    public CongNhan(String hoTen, int tuoi, String gioiTinh, String diaChi, int bac) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.bac = bac;
    }

    public CongNhan() {
        super();
        this.bac = 1;
    }

    // Getters and Setters
    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }
}
