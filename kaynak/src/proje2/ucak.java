package proje2;

public class ucak extends havatasitlari { //Inheritance
    private static int id = 0;
    private boolean inis;

    public ucak() {
    }

    public ucak(String marka, String yturu, int hiz, String yolcu, String teker, String fiyat, String uretim, String renk) {
        super(marka, yturu, hiz, yolcu, teker, fiyat, uretim, renk);
    }

    @Override
    public String getYturu() {
        return "YOK";
    }

    public void setInis(boolean inis) {
        this.inis = inis;
    }

    public boolean getInis() {
        return inis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getId() {
        return id;
    }

    public void hizlan(int hiz) {
        super.setHiz(super.getHiz() + hiz);
    }

    public void yavasla(int hiz) {
        super.setHiz(super.getHiz() - hiz);
    }

    public void dur(boolean inis) {
        if (inis) {
            super.setHiz(0);
        } else {
            System.out.println("Arac Inis Yapmadan Duramaz.");
        }
    }

}
