package proje2;

public class havatasitlari {
    private String marka;
    private String yturu = "N/A";
    private int hiz;
    private String yolcu;
    private String teker;
    private String fiyat;
    private String uretim;
    private String renk;

    public havatasitlari() {
    }

    public havatasitlari(String marka, String yturu, int hiz, String yolcu, String teker, String fiyat, String uretim, String renk) {
        this.marka = marka;
        this.yturu = "N/A";
        this.hiz = hiz;
        this.yolcu = yolcu;
        this.teker = teker;
        this.fiyat = fiyat;
        this.uretim = uretim;
        this.renk = renk;
    }

    //GET-SET Encapsulation
    public String getMarka() {
        return marka;
    }

    public String getYturu() {
        return "YOK";
    }

    public int getHiz() {
        return hiz;
    }

    public String getYolcu() {
        return yolcu;
    }

    public String getTeker() {
        return teker;
    }

    public String getFiyat() {
        return fiyat;
    }

    public String getUretim() {
        return uretim;
    }

    public String getRenk() {
        return renk;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setYturu(String yturu) {
        this.yturu = yturu;
    }

    public void setHiz(int hiz) {
        this.hiz = hiz;
    }

    public void setYolcu(String yolcu) {
        this.yolcu = yolcu;
    }

    public void setTeker(String teker) {
        this.teker = teker;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public void setUretim(String uretim) {
        this.uretim = uretim;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public void hizlan(int hiz) {
        setHiz(this.getHiz() + hiz);
    }

    public void yavasla(int hiz) {
        setHiz(this.getHiz() - hiz);
    }

    public void dur() {
        setHiz(0);
    }


}
