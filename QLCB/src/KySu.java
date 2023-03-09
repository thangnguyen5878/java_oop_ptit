public class KySu extends CanBo {
    // Attributes
    private String nganhDaoTao;

    // Constructors
    public KySu(String hoTen, int tuoi, String gioiTinh, String diaChi, String nganhDaoTao) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.nganhDaoTao = nganhDaoTao;
    }

    public KySu() {
        super();
        this.nganhDaoTao = "";
    }

    // Setters and Getters
    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }
}
