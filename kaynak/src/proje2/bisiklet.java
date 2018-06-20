package proje2;

public class bisiklet extends karatasitlari { //Inheritance
    private static int id = 0;

    public bisiklet() {
    }

    public bisiklet(String marka, String yturu, int hiz, String yolcu, String teker, String fiyat, String uretim, String renk) {
        super(marka, yturu, hiz, yolcu, teker, fiyat, uretim, renk);
    }

    public static int getId() {
        return id;
    }

    @Override//Polmorphism
    public String getYturu() {
        return "YOK";
    }

    public static void setId(int id) {
        bisiklet.id = id;
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
