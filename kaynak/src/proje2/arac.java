package proje2;

public interface arac {
  /*  markası, yakıt türü (motorlu), hızı, yolcu sayısı, tekerlek sayısı, fiyatı,
    üretim yılı ve rengi özellikleri olmalı
    Projede Encapsulation, Inheritance, Polymorphism, Abstraction yapılarının
            (hepsinin) kullanılması gerekmektedir.*/


    //GET-SET Encapsulation
    String getMarka();

    String getYturu();

    int getHiz();

    String getYolcu();

    String getTeker();

    String getFiyat();

    String getUretim();

    String getRenk();

    void setMarka(String marka);

    void setYturu(String yturu);

    void setHiz(int hiz);

    void setYolcu(String yolcu);

    void setTeker(String teker);

    void setFiyat(String fiyat);

    void setUretim(String uretim);

    void setRenk(String renk);

    void hizlan(int hiz);

    void yavasla(int hiz);

    void dur();

}
