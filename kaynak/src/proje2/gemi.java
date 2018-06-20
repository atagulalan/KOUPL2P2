package proje2;

public class gemi implements deniztasitlari { //Inheritance
    /*
    Ucan gemi icin deniz tasitlari veya hava tasitlarindan en az birinin interface olmasi gerekiyordu.
    Hiyerarsi dogru olmasi adina arac sinifi da interface olmustur deniz tasitlari extend edebilsin diye.
    Inhertance dan maksimum yararlanmak adina deniz tasitlari ve hava tasitlarindan biri interface digeri class yapilmistir.
    interface olanin altindaki sinif global verileri alabilecegi bir sinif olmadigindan tekrar tanimlanmistir
     */
    private String marka;
    private String yturu = "N/A"; //Sadece otomobil sinifi kullaniyor
    private int hiz;
    private String yolcu;
    private String teker = "N/A";//Hava-Kara tasitlari kullanior
    private String fiyat;
    private String uretim;
    private String renk;
    private static int id = 0;

    public gemi() {
    }

    public gemi(String marka, int hiz, String yolcu, String fiyat, String uretim, String renk) {
        this.marka = marka;
        this.yturu = "N/A";
        this.hiz = hiz;
        this.yolcu = yolcu;
        this.teker = teker = "N/A";
        this.fiyat = fiyat;
        this.uretim = uretim;
        this.renk = renk;

    }


    //GET-SET Encapsulation
    public static int getId() {
        return id;
    }

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
        return "YOK";
    }

    public String getYturu() {
        return "YOK";
    }

    public static void setId(int id) {
        gemi.id = id;
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
