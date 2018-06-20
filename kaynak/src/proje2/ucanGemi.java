package proje2;

public class ucanGemi extends havatasitlari implements deniztasitlari {
    private static int id = 0;
    private boolean inis;

    public ucanGemi() {
    }

    public ucanGemi(String marka, String yturu, int hiz, String yolcu, String teker, String fiyat, String uretim, String renk) {
        super(marka, yturu, hiz, yolcu, teker, fiyat, uretim, renk);
    }

    @Override
    public String getYturu() {
        return "YOK";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInis(boolean inis) {
        this.inis = inis;
    }

    public boolean getInis() {
        return this.inis;
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
            System.out.println("Arac Inis Yapamadan Duramaz.");
        }
    }
}
