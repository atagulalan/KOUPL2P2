package proje2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;
import java.util.ArrayList;


public class main extends JPanel {
    private static otomobil oto = new otomobil();
    private static bisiklet bis = new bisiklet();
    private static gemi gem = new gemi();
    private static ucak uca = new ucak();
    private static ucanGemi ugm = new ucanGemi();
    private static String satir;
    private Color arkaplan = new Color(0x22181C);
    private Color buton = new Color(241, 48, 48);
    private static String tip = "";
    private static String eski = "";

    //https://stackoverflow.com/questions/27706197/how-can-i-center-graphics-drawstring-in-java
    public static void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(font);
        g.drawString(text, x, y);
    }

    public static Font getMontserrat(String boldness, int size){
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(".\\Montserrat-"+boldness+".ttf"));
            return font.deriveFont(Font.PLAIN, size);
        } catch (Exception e) {
            System.out.println("Font yuklenirken hata!");
            return new Font("Arial", Font.PLAIN, size);
        }
    }

    public static class stilliButon extends JButton {
        public static Color COLOR = new Color(241, 48, 48);
        public String text = "";
        public boolean active = false;

        @Override
        public String toString(){
            return this.text;
        }

        public stilliButon(String text) {
            this.text = text;
            setBorderPainted(false);
            setOpaque(false);
            setBackground(new Color(0xF13030));
            addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) { setBackground(new Color(0xF24242)); }
                public void mouseReleased(java.awt.event.MouseEvent evt) { setBackground(new Color(0xF24242)); }
                public void mouseExited(java.awt.event.MouseEvent evt) { setBackground(new Color(0xF13030)); }
                public void mousePressed(java.awt.event.MouseEvent evt) { setBackground(new Color(0xF13030)); }
            });
        }

        @Override
        public void setBackground(Color c){
            if(!this.active){
                COLOR = c;
            }
        }

        //https://stackoverflow.com/questions/423950/rounded-swing-jbutton-using-java
        @Override
        protected void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D)g.create();
            RenderingHints qualityHints =
                    new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHints(qualityHints);
            g2.setPaint(COLOR);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
            g2.setPaint(new Color(0xffffff));
            drawCenteredString(g2, this.text, new Rectangle(getWidth(), getHeight()), getMontserrat("SemiBold", 13));
            g2.dispose();
        }

    }

    public static class altiCizgiliInput extends JTextField {
        public altiCizgiliInput(JPanel panel, String ad, int w, int h, int x, int y, String initialValue) {
            setCaretColor(new Color(0xffffff));
            setForeground(new Color(0xffffff));
            setOpaque(false);
            setFont(getMontserrat("Regular", 13));
            setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0xF13030)));
            JLabel label = new JLabel(ad);
            setSize(w,h);
            setLocation(x,y);
            panel.add(this);
            label.setForeground(new Color(0xcccccc));
            label.setFont(getMontserrat("Regular", 10));
            label.setSize(w,h);
            label.setLocation(x,y-16);
            setText(initialValue);
            panel.add(label);
        }
    }

    public main() throws IOException {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        String editIco = "Güncelle";

        JFrame frame = new JFrame("Araç Yönetim Sistemi");
        frame.setSize(600, 400);

        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        panel.setBackground(arkaplan);

        stilliButon vgiris = new stilliButon("Yeni Giriş");
        stilliButon vlistele = new stilliButon("Listele");
        stilliButon vguncelle = new stilliButon("Güncelle");

        vgiris.setBounds(50, 50, 100, 50);
        vlistele.setBounds(250, 50, 100, 50);
        vguncelle.setBounds(450, 50, 100, 50);

        panel.add(vgiris);
        panel.add(vlistele);
        panel.add(vguncelle);
        frame.setVisible(true);


        //--------------------veri girisi---------------
        frame.setVisible(true);
        JFrame giris = new JFrame("Veri Girişi");
        giris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        giris.setSize(600, 470);
        giris.setLocation(dim.width/2-giris.getSize().width/2, dim.height/2-giris.getSize().height/2);

        JPanel ekle = new JPanel();
        ekle.setLayout(null);
        ekle.setSize(600, 470);
        ekle.setBackground(Color.white);
        giris.add(ekle);
        ekle.setBackground(arkaplan);

        altiCizgiliInput marka = new altiCizgiliInput(ekle, "Marka", 220, 30, 20, 30, "");
        altiCizgiliInput yakit = new altiCizgiliInput(ekle, "Yakıt Türü", 220, 30, 20, 80, "");
        altiCizgiliInput hiz = new altiCizgiliInput(ekle, "Hız", 220, 30, 20, 130, "");
        altiCizgiliInput yolcu = new altiCizgiliInput(ekle, "Yolcu Sayısı", 220, 30, 20, 180, "");
        altiCizgiliInput teker = new altiCizgiliInput(ekle, "Teker Sayısı", 220, 30, 20, 230, "");
        altiCizgiliInput fiyat = new altiCizgiliInput(ekle, "Fiyat", 220, 30, 20, 280, "");
        altiCizgiliInput uretim = new altiCizgiliInput(ekle, "Üretim Tarihi", 220, 30, 20, 330, "");
        altiCizgiliInput renk = new altiCizgiliInput(ekle, "Renk", 220, 30, 20, 380, "");
        ekle.add(marka);
        ekle.add(yakit);
        ekle.add(hiz);
        ekle.add(yolcu);
        ekle.add(teker);
        ekle.add(fiyat);
        ekle.add(uretim);
        ekle.add(renk);

        stilliButon hizlan1 = new stilliButon("Hızlan");
        hizlan1.setBounds(470, 70, 90, 30);
        ekle.add(hizlan1);
        altiCizgiliInput miktar = new altiCizgiliInput(ekle, "Miktar", 90, 30, 470, 30, "0");
        ekle.add(miktar);
        miktar.setOpaque(false);
        stilliButon yavasla1 = new stilliButon("Yavasla");
        yavasla1.setBounds(470, 110, 90, 30);
        ekle.add(yavasla1);
        stilliButon dur1 = new stilliButon("Dur");
        dur1.setBounds(470, 150, 90, 30);
        ekle.add(dur1);
        JCheckBox tdur1 = new JCheckBox("İniş(Hava A.)");
        tdur1.setForeground(new Color(0xffffff));
        tdur1.setBounds(470, 180, 100, 30);
        ekle.add(tdur1);
        tdur1.setOpaque(false);

        String otoIco = "Otomobil";
        String bisIco = "Bisiklet";
        String ucaIco = "Uçak";
        String gemIco = "Gemi";
        String ugeIco = "Uçan Gemi";
        String gerIco = "Geri";

        stilliButon otomobil = new stilliButon(otoIco);
        otomobil.setBounds(280, 25, 150, 50);
        ekle.add(otomobil);
        stilliButon bisiklet = new stilliButon(bisIco);
        bisiklet.setBounds(280, 85, 150, 50);
        ekle.add(bisiklet);
        stilliButon gemi = new stilliButon(gemIco);
        gemi.setBounds(280, 145, 150, 50);
        ekle.add(gemi);
        stilliButon ucak = new stilliButon(ucaIco);
        ucak.setBounds(280, 205, 150, 50);
        ekle.add(ucak);
        stilliButon ucanGemi = new stilliButon(ugeIco);
        ucanGemi.setBounds(280, 265, 150, 50);
        ekle.add(ucanGemi);
        stilliButon geri2 = new stilliButon(gerIco);
        geri2.setBounds(500, 380, 60, 30);
        ekle.add(geri2);
        stilliButon kayit = new stilliButon("Kayıt");
        kayit.setBounds(410, 380, 80, 30);
        ekle.add(kayit);
        geri2.setBackground(arkaplan);

        giris.setVisible(false);

        //--------------listeleme-------------
        JFrame listeleme = new JFrame("Kayıt Listeleme");
        listeleme.setSize(600, 400);
        listeleme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listeleme.setLocation(dim.width/2-listeleme.getSize().width/2, dim.height/2-listeleme.getSize().height/2);
        listeleme.setVisible(false);

        JPanel panelist = new JPanel();
        panelist.setSize(600, 400);
        panelist.setLayout(null);
        listeleme.add(panelist);
        panelist.setBackground(arkaplan);

        JTextArea liste = new JTextArea();
        panelist.add(liste);
        liste.setBackground(Color.lightGray);

        JScrollPane scroll = new JScrollPane(liste);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(40, 120, 500, 175);
        panelist.add(scroll);

        JLabel bas = new JLabel("SinifID Marka Y.Turu Hiz YolcuS. TekerS. Fiyat UretimT. Renk ");
        bas.setHorizontalAlignment(0);
        panelist.add(bas);
        bas.setBounds(15, 80, 550, 40);
        bas.setFont(new Font("f", Font.BOLD, 18));
        bas.setForeground(buton);

        JButton kara = new stilliButon("Kara Taşıtları");
        kara.setBounds(25, 25, 150, 50);
        panelist.add(kara);

        JButton deniz = new stilliButon("Deniz Taşıtları");
        deniz.setBounds(225, 25, 150, 50);
        panelist.add(deniz);

        JButton hava = new stilliButon("Hava Taşıtları");
        hava.setBounds(425, 25, 150, 50);
        panelist.add(hava);


        JButton geri = new stilliButon(gerIco);
        geri.setBounds(260, 310, 60, 30);
        panelist.add(geri);

        //------------guncelleme----------------
        JFrame guncelleme = new JFrame("Kayıt Güncelleme");
        guncelleme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guncelleme.setSize(600, 470);
        guncelleme.setLocation(dim.width/2-guncelleme.getSize().width/2, dim.height/2-guncelleme.getSize().height/2);
        guncelleme.setVisible(false);
        JPanel guncel = new JPanel();
        guncel.setSize(600, 470);
        guncel.setLayout(null);
        guncelleme.add(guncel);
        panel.setBackground(arkaplan);
        guncel.setBackground(arkaplan);

        altiCizgiliInput bul = new altiCizgiliInput(guncel, "SINIF_ID", 100, 30, 30, 50, "");
        guncel.add(bul);


        String bulIco = "Ara";
        stilliButon bbul = new stilliButon(bulIco);
        bbul.setBounds(150, 50, 90, 30);
        guncel.add(bbul);
        bbul.setBackground(buton);







        altiCizgiliInput marka1 = new altiCizgiliInput(guncel, "Marka", 220, 30, 340, 30, "");
        altiCizgiliInput yakit1 = new altiCizgiliInput(guncel, "Yakıt Türü", 220, 30, 340, 80, "");
        altiCizgiliInput hiz1 = new altiCizgiliInput(guncel, "Hız", 220, 30, 340, 130, "");
        altiCizgiliInput yolcu1 = new altiCizgiliInput(guncel, "Yolcu Sayısı", 220, 30, 340, 180, "");
        altiCizgiliInput teker1 = new altiCizgiliInput(guncel, "Teker Sayısı", 220, 30, 340, 230, "");
        altiCizgiliInput fiyat1 = new altiCizgiliInput(guncel, "Fiyat", 220, 30, 340, 280, "");
        altiCizgiliInput uretim1 = new altiCizgiliInput(guncel, "Üretim Tarihi", 220, 30, 340, 330, "");
        altiCizgiliInput renk1 = new altiCizgiliInput(guncel, "Renk", 220, 30, 340, 380, "");
        guncel.add(marka1);
        guncel.add(yakit1);
        guncel.add(hiz1);
        guncel.add(yolcu1);
        guncel.add(teker1);
        guncel.add(fiyat1);
        guncel.add(uretim1);
        guncel.add(renk1);




        altiCizgiliInput thizlan = new altiCizgiliInput(guncel,"Miktar", 100, 30, 30, 110, "0");
        guncel.add(thizlan);

        stilliButon hizlan = new stilliButon("Hızlan");
        hizlan.setBounds(150, 110, 90, 30);
        guncel.add(hizlan);

        stilliButon yavasla = new stilliButon("Yavasla");
        yavasla.setBounds(150, 150, 90, 30);
        guncel.add(yavasla);

        stilliButon dur = new stilliButon("Dur");
        dur.setBounds(150, 190, 90, 30);
        guncel.add(dur);

        JCheckBox tdur = new JCheckBox("İniş yaptı mı?");
        tdur.setForeground(new Color(0xffffff));
        tdur.setBounds(145, 230, 150, 30);
        guncel.add(tdur);
        tdur.setOpaque(false);

        stilliButon edit = new stilliButon(editIco);
        edit.setBounds(150, 310, 90, 30);
        guncel.add(edit);

        stilliButon geri3 = new stilliButon(gerIco);
        geri3.setBounds(30, 310, 90, 30);
        guncel.add(geri3);


        //------dosya okuma----------------------
        oto.setId(oku("OTO"));
        bis.setId(oku("BİS"));
        gem.setId(oku("GEM"));
        uca.setId(oku("UCK"));
        ugm.setId(oku("UGM"));


        vgiris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                giris.setVisible(true);
                frame.setVisible(false);
            }
        });
        geri2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                giris.setVisible(false);
                frame.setVisible(true);
            }
        });

        kayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switch (tip){
                    case "OTO":

                        System.out.println(String.valueOf(oto.getHiz()));
                        satir = "OTO_" + oto.getId() + "," + oto.getMarka() + "," + oto.getYturu() + "," + oto.getHiz() + "," + oto.getYolcu() + "," + oto.getTeker() + "," +
                                oto.getFiyat() + "," + oto.getUretim() + "," + oto.getRenk();
                        oto.setId(oto.getId() + 1);
                        System.out.println(tip+"_" + (oto.getId()-1) + " Basariyla Olusturuldu");
                        break;

                    case "BİS":
                        System.out.println(String.valueOf(bis.getHiz()));
                        satir = "BİS_" + bis.getId() + "," + bis.getMarka() + ",YOK," + bis.getHiz() + "," + bis.getYolcu() + "," + bis.getTeker() + "," +
                                bis.getFiyat() + "," + bis.getUretim() + "," + bis.getRenk();
                        bis.setId(bis.getId() + 1);
                        System.out.println(tip+"_" + (bis.getId()-1) + " Basariyla Olusturuldu");
                        break;

                    case "GEM":
                        System.out.println(String.valueOf(gem.getHiz()));
                        satir = "GEM_" + gem.getId() + "," + gem.getMarka() + ",YOK," + gem.getHiz() + "," + gem.getYolcu() + ",YOK," +
                                gem.getFiyat() + "," + gem.getUretim() + "," + gem.getRenk();
                        gem.setId(gem.getId() + 1);
                        System.out.println(tip+"_" + (gem.getId()-1) + " Basariyla Olusturuldu");
                        break;
                    case "UCK":
                        System.out.println(String.valueOf(uca.getHiz()));
                        satir = "UCK_" + uca.getId() + "," + uca.getMarka() + ",YOK," + uca.getHiz() + "," + uca.getYolcu() + "," + uca.getTeker() + "," +
                                uca.getFiyat() + "," + uca.getUretim() + "," + uca.getRenk();
                        uca.setId(uca.getId() + 1);
                        System.out.println(tip+"_" + (uca.getId()-1) + " Basariyla Olusturuldu");
                        break;

                    case "UGM":
                        System.out.println(String.valueOf(ugm.getHiz()));
                        satir = "UGM_" + ugm.getId() + "," + ugm.getMarka() + ",YOK," + ugm.getHiz() + "," + ugm.getYolcu() + "," + ugm.getTeker() + "," +
                                ugm.getFiyat() + "," + ugm.getUretim() + "," + ugm.getRenk();
                        ugm.setId(ugm.getId() + 1);
                        System.out.println(tip+"_" + (ugm.getId()-1) + " Basariyla Olusturuldu");
                        break;

                    default:
                        break;
                }
                try {
                    yaz(satir);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    marka.setText("");
                    yakit.setText("");
                    hiz.setText("");
                    yolcu.setText("");
                    teker.setText("");
                    uretim.setText("");
                    fiyat.setText("");
                    renk.setText("");
                    miktar.setText("0");
                }

            }
        });

        hizlan1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switch (tip){
                    case "OTO":
                        oto.hizlan(Integer.parseInt(miktar.getText()));
                        hiz.setText(String.valueOf(oto.getHiz()));
                        break;

                    case "BİS":
                        bis.hizlan(Integer.parseInt(miktar.getText()));
                        hiz.setText(String.valueOf(bis.getHiz()));
                        break;

                    case "GEM":
                        gem.hizlan(Integer.parseInt(miktar.getText()));
                        hiz.setText(String.valueOf(gem.getHiz()));
                        break;

                    case "UCK":
                        uca.hizlan(Integer.parseInt(miktar.getText()));
                        hiz.setText(String.valueOf(uca.getHiz()));
                        break;

                    case "UGM":
                        ugm.hizlan(Integer.parseInt(miktar.getText()));
                        hiz.setText(String.valueOf(ugm.getHiz()));
                        break;

                    default:
                        break;
                }
            }
        });

        yavasla1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switch (tip){
                    case "OTO":
                        oto.yavasla(Integer.parseInt(miktar.getText()));
                        hiz.setText(String.valueOf(oto.getHiz()));
                        break;

                    case "BİS":
                        bis.yavasla(Integer.parseInt(miktar.getText()));
                        hiz.setText(String.valueOf(bis.getHiz()));
                        break;

                    case "GEM":
                        gem.yavasla(Integer.parseInt(miktar.getText()));
                        hiz.setText(String.valueOf(gem.getHiz()));
                        break;

                    case "UCK":
                        uca.yavasla(Integer.parseInt(miktar.getText()));
                        hiz.setText(String.valueOf(uca.getHiz()));
                        break;

                    case "UGM":
                        ugm.yavasla(Integer.parseInt(miktar.getText()));
                        hiz.setText(String.valueOf(ugm.getHiz()));
                        break;

                    default:
                        break;
                }
            }
        });

        dur1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switch (tip){
                    case "OTO":
                        oto.dur();
                        hiz.setText(String.valueOf(oto.getHiz()));
                        break;

                    case "BİS":
                        bis.dur();
                        hiz.setText(String.valueOf(bis.getHiz()));
                        break;

                    case "GEM":
                        gem.dur();
                        hiz.setText(String.valueOf(gem.getHiz()));
                        break;

                    case "UCK":
                        uca.dur(tdur1.isSelected());
                        hiz.setText(String.valueOf(uca.getHiz()));
                        break;

                    case "UGM":
                        ugm.dur(tdur1.isSelected());
                        hiz.setText(String.valueOf(ugm.getHiz()));
                        break;

                    default:
                        break;
                }
            }
        });

        otomobil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                oto.setMarka(marka.getText());
                oto.setYturu(yakit.getText());
                oto.setHiz(Integer.parseInt(hiz.getText()));
                oto.setYolcu(yolcu.getText());
                oto.setTeker(teker.getText());
                oto.setFiyat(fiyat.getText());
                oto.setUretim(uretim.getText());
                oto.setRenk(renk.getText());
                tip = "OTO";
            }
        });
        bisiklet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bis.setMarka(marka.getText());
                bis.setYturu("YOK");
                bis.setHiz(Integer.parseInt(hiz.getText()));
                bis.setYolcu(yolcu.getText());
                bis.setTeker(teker.getText());
                bis.setFiyat(fiyat.getText());
                bis.setUretim(uretim.getText());
                bis.setRenk(renk.getText());
                tip = "BİS";
            }
        });
        gemi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gem.setMarka(marka.getText());
                gem.setYturu("YOK");
                gem.setHiz(Integer.parseInt(hiz.getText()));
                gem.setYolcu(yolcu.getText());
                gem.setTeker("YOK");
                gem.setFiyat(fiyat.getText());
                gem.setUretim(uretim.getText());
                gem.setRenk(renk.getText());
                tip = "GEM";
            }
        });
        ucak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                uca.setMarka(marka.getText());
                uca.setYturu("YOK");
                uca.setHiz(Integer.parseInt(hiz.getText()));
                uca.setYolcu(yolcu.getText());
                uca.setTeker(teker.getText());
                uca.setFiyat(fiyat.getText());
                uca.setUretim(uretim.getText());
                uca.setRenk(renk.getText());
                tip = "UCK";
            }
        });
        ucanGemi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ugm.setMarka(marka.getText());
                ugm.setYturu("YOK");
                ugm.setHiz(Integer.parseInt(hiz.getText()));
                ugm.setYolcu(yolcu.getText());
                ugm.setTeker(teker.getText());
                ugm.setFiyat(fiyat.getText());
                ugm.setUretim(uretim.getText());
                ugm.setRenk(renk.getText());
                ugm.setId(ugm.getId());
                tip = "UGM";
            }
        });
        vlistele.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                listeleme.setVisible(true);
            }
        });
        kara.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                liste.setText("");
                try {
                    String[] str = karaListe();
                    for (String x : str) {
                        liste.append(" " + x + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        deniz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                liste.setText("");
                try {
                    String[] str = denizListe();
                    for (String x : str) {
                        liste.append(" " + x + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        hava.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                liste.setText("");
                try {
                    String[] str = havaListe();
                    for (String x : str) {
                        liste.append(" " + x + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        geri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(true);
                listeleme.setVisible(false);
            }
        });

        vguncelle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                guncelleme.setVisible(true);
            }
        });

        bbul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    eski = tara(bul.getText().toUpperCase(), marka1, yakit1, hiz1, yolcu1, teker1, fiyat1, uretim1, renk1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        hizlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                hiz1.setText(String.valueOf(Integer.parseInt(hiz1.getText()) + Integer.parseInt(thizlan.getText())));
            }
        });

        yavasla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                hiz1.setText(String.valueOf(Integer.parseInt(hiz1.getText()) - Integer.parseInt(thizlan.getText())));
            }
        });

        dur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (bul.getText().toUpperCase().startsWith("UCK") || bul.getText().toUpperCase().startsWith("UGM")) {
                    if (tdur.isSelected()) {
                        hiz1.setText("0");
                    } else {
                        System.out.println("Arac Inis Yapmadigindan Duramaz.");
                        hiz1.setText(hiz1.getText());
                    }
                } else {
                    hiz1.setText("0");
                }

            }
        });

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String yeni = bul.getText().toUpperCase() + "," + marka1.getText() + "," + yakit1.getText() + "," + hiz1.getText() + "," + yolcu1.getText() + "," +
                        teker1.getText() + "," + uretim1.getText() + "," + fiyat1.getText() + "," + renk1.getText();
                edit(yeni);
                System.out.println(bul.getText().toUpperCase() + " Basariyla Guncellendi");
            }
        });

        geri3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                marka1.setText("");
                yakit1.setText("");
                hiz1.setText("");
                yolcu1.setText("");
                teker1.setText("");
                uretim1.setText("");
                fiyat1.setText("");
                renk1.setText("");
                thizlan.setText("0");
                bul.setText("");


                frame.setVisible(true);
                guncelleme.setVisible(false);
            }
        });

    }


    public String tara(String sinifid, altiCizgiliInput m, altiCizgiliInput y, altiCizgiliInput h, altiCizgiliInput o, altiCizgiliInput t, altiCizgiliInput f, altiCizgiliInput u, altiCizgiliInput r) throws IOException {
        FileReader fileReader = new FileReader("liste.txt");
        String line;
        String ilk[];
        BufferedReader br = new BufferedReader(fileReader);

        while ((line = br.readLine()) != null) {
            ilk = line.split(",");
            if (ilk[0].equals(sinifid)) {
                System.out.println("Kayit Bulundu");
                m.setText(ilk[1]);
                y.setText(ilk[2]);
                h.setText(ilk[3]);
                o.setText(ilk[4]);
                t.setText(ilk[5]);
                f.setText(ilk[6]);
                u.setText(ilk[7]);
                r.setText(ilk[8]);
                break;
            }
        }

        br.close();
        return line;
    }

    //https://www.youtube.com/watch?v=HFC-KspB9l4
    static void edit(String yeni) {
        File fileToBeModified = new File("liste.txt");
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            System.out.println(yeni);
            String newContent = oldContent.replaceAll(eski, yeni);
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static int oku(String keyword) throws IOException {
        //OKUNAN SATIRIN ILK3 HARFI KEYWORDA ESITSA SAYAC++
        int sayac = 0;
        FileReader fileReader = new FileReader("liste.txt");
        String line, str;
        String ilk[];
        BufferedReader br = new BufferedReader(fileReader);

        while ((line = br.readLine()) != null) {
            ilk = line.split("_");
            str = ilk[0];
            if (str.equals(keyword)) {
                sayac++;
            }
        }

        br.close();
        return sayac;
    }

    public static void yaz(String satir) throws IOException {
        File file = new File("liste.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.newLine();
        bWriter.write(satir);
        bWriter.close();
    }


    public static String[] karaListe() throws IOException {
        ArrayList<String> liste = new ArrayList<>();
        FileReader fileReader = new FileReader("liste.txt");
        String line, str;
        String ilk[];
        BufferedReader br = new BufferedReader(fileReader);

        while ((line = br.readLine()) != null) {
            ilk = line.split("_");
            str = ilk[0];
            if (str.equals("OTO") || str.equals("BİS")) {
                liste.add(line);
            }
        }

        String[] don = liste.toArray(new String[liste.size()]);
        br.close();
        return don;
    }

    public static String[] denizListe() throws IOException {
        //OKUNAN SATIRIN ILK3 HARFI KEYWORDA ESITSA SAYAC++
        ArrayList<String> liste = new ArrayList<>();
        FileReader fileReader = new FileReader("liste.txt");
        String line, str;
        String ilk[];
        BufferedReader br = new BufferedReader(fileReader);

        while ((line = br.readLine()) != null) {
            ilk = line.split("_");
            str = ilk[0];
            if (str.equals("GEM") || str.equals("UGM")) {
                liste.add(line);
            }
        }
        String[] don = liste.toArray(new String[liste.size()]);
        br.close();
        return don;
    }

    public static String[] havaListe() throws IOException {
        //OKUNAN SATIRIN ILK3 HARFI KEYWORDA ESITSE SAYAC++
        ArrayList<String> liste = new ArrayList<>();
        FileReader fileReader = new FileReader("liste.txt");
        String line, str;
        String ilk[];
        BufferedReader br = new BufferedReader(fileReader);

        while ((line = br.readLine()) != null) {
            ilk = line.split("_");
            str = ilk[0];
            if (str.equals("UCK") || str.equals("UGM")) {
                liste.add(line);
            }
        }
        String[] don = liste.toArray(new String[liste.size()]);
        br.close();
        return don;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        new main();
    }
}
