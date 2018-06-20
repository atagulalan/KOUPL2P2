package proje2;

public class otomobil extends karatasitlari { //Inheritance
    private static int id = 0;

    public otomobil() {
    }

    public otomobil(String marka, String yturu, int hiz, String yolcu, String teker, String fiyat, String uretim, String renk) {
        super(marka, yturu, hiz, yolcu, teker, fiyat, uretim, renk);
    }


    public static void setId(int id) {
        otomobil.id = id;
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

    public void dur() {
        super.setHiz(0);
    }
}
