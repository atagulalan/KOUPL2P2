package proje2;

public interface deniztasitlari extends arac { //Inheritance

    /*GET-SET Encapsulation
    public static int getId(){
        return id; }*/
    String getRenk();

    String getUretim();

    String getFiyat();

    String getYolcu();

    int getHiz();

    String getMarka();

    String getTeker();

    String getYturu();

    void setRenk(String renk);

    void setUretim(String uretim);

    void setFiyat(String fiyat);

    void setYolcu(String yolcu);

    void setHiz(int hiz);

    void setMarka(String marka);

    void setTeker(String teker);

    void setYturu(String yturu);
}
