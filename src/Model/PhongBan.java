package Model;

public class PhongBan {
    private String maPB;
    private String tenPB;
    private String moTa;

    // Constructor
    public PhongBan(String maPB, String tenPB, String moTa) {
        this.maPB = maPB;
        this.tenPB = tenPB;
        this.moTa = moTa;
    }

    // Getters and Setters
    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}