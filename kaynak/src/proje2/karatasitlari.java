package proje2;

public abstract class karatasitlari implements arac { //Abstraction
    private String marka;
    private String yturu;
    private int hiz;
    private String yolcu;
    private String teker;
    private String fiyat;
    private String uretim;
    private String renk;

    public karatasitlari() {
    }

    public karatasitlari(String marka, String yturu, int hiz, String yolcu, String teker, String fiyat, String uretim, String renk) {
        this.marka = marka;
        this.yturu = yturu;
        this.hiz = hiz;
        this.yolcu = yolcu;
        this.teker = teker;
        this.fiyat = fiyat;
        this.uretim = uretim;
        this.renk = renk;
    }

    //GET-SET Encapsulation
    public String getRenk() {
        return renk;
    }

    public String getUretim() {
        return uretim;
    }

    public String getFiyat() {
        return fiyat;
    }

    public String getYolcu() {
        return yolcu;
    }

    public int getHiz() {
        return hiz;
    }

    public String getMarka() {
        return marka;
    }

    public String getTeker() {
        return teker;
    }

    public String getYturu() {
        return yturu;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public void setUretim(String uretim) {
        this.uretim = uretim;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public void setYolcu(String yolcu) {
        this.yolcu = yolcu;
    }

    public void setHiz(int hiz) {
        this.hiz = hiz;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setTeker(String teker) {
        this.teker = teker;
    }

    public void setYturu(String yturu) {
        this.yturu = yturu;
    }
}
