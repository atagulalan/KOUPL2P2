Araç Yönetim Sistemi

Ata Gülalan		-	160202034
Oğuzhan Türker	-	160202015

Bu readme.txt dosyası, Araç Yönetim Sistemi projesine aittir.
Bu paket, kaynak kodu ile aynı dizin içerisinde bulunacaktır.


1-PAKETİN İÇERİĞİ:
----------
160202034-160202015.txt - Projenin tek dosyaya indirgenmiş salt kaynak kodu.
readme.txt - Bu dosya.
kaynak.zip - Projenin kaynak kodunun ve yardımcı dosyaların ziplenmiş hali.
rapor.pdf - Proje raporu.
----------


2-SİSTEM GEREKSİNİMLERİ:
-------------------
java - Oracle Java™ - http://java.com/
-------------------


3-PROJEYİ ÇALIŞTIRMAK:
-------------------
Paket içeriğini, yukarıda görebilirsiniz.

Bu kod, iki adet Windows kurulu makinede çalıştırıldı.

Bu iki durumda da, kod, herhangi bir hata vermeksizin, daha önceden
belirlenen kriterlere uygun çalıştı.

Ön gereklilik:
Projenin çalıştırıldığı dizinde, yazma özelliği açık bir şekilde
liste.txt dosyası oluşturulmalıdır. 

Projeyi çalıştırmak için proje dizinine girip;
----------------------------
java -cp classes proje2.main
----------------------------
yazmanız yeterli. 

-------------------


4-KODU DERLEMEK:
------------------
Artık bilgisayarımızda kurulu olan Java ile kodu kolayca derleyebiliriz.

Projeyi derlemek için proje dizinine girip;
----------------------------
javac -sourcepath ./src/proje2 ./src/proje2/*.java -d ./classes/ -encoding UTF8
----------------------------
yazmanız yeterli. 


-- ÖNEMLİ NOT -----------------
-- 
-- Eğer şuna benzer bir hata ile karşılaşırsanız;
-- ----------------------------
-- javac: directory not found: ./classes/
-- Usage: javac <options> <source files>
-- use -help for a list of possible options
-- ----------------------------
-- 
-- Projenizin ana dizininde classes adlı bir klasör açmanız gerekiyor.
-- 
-- Komut ile yapılması:
-- ----------------------------
-- mkdir classes
-- ----------------------------


Derleme bittikten sonra 3-PROJEYİ ÇALIŞTIRMAK kısmındaki yönergeleri
izleyerek kodu çalıştırabilirsiniz.
------------------


5- PARAMETRELER
---------------------------
Kodun çalışması için başlangıçta herhangi bir parametre gerekmiyor.
------------------


6- PROGRAMIN KULLANIMI
-----------------------------
Araç Yönetim Sistemi, araç sınıflarının kullanıcının belirlediği
özelliklerde oluşturulup, düzenlenmesini ve birbirleri arasındaki
iletişimini, kolay ve anlaşılabilir bir arayüz ile kullanıcıya
sunduğu bir hizmettir.

Kullanıcı istediği araç türünü oluşturup, düzenleyebilir.
Oluşturulan sınıfları listeleyip, güncelleyebilir.

Programın arayüzü oldukça basittir. Öncelikle sizden ne yapması
gerektiğini isteyecek.

Yeni giriş yapmak için, "Yeni Giriş" butonuna tıklayın.

Yapılan girişleri listelemek için, "Listele" butonuna tıklayın.

Daha önceden kaydedilmiş girişleri değiştirmek için "Güncelle"
butonuna tıklayın.


Yeni giriş sayfası ----------

Açılan ekranda, Marka, Yakıt Türü, Yolcu Sayısı, Teker Sayısı,
Fiyat, Üretim Tarihi, Renk düz yazı şeklinde tutulurken; Hız,
tam sayı şeklinde tutulur. 

Bu kutucukların tamamını eksiksiz bir şekilde doldurduktan sonra,
bu değerlerin hangi araca ait olduğunu seçmeniz gerekir.

Hangi araca olduğunu seçtikten sonra bu aracı hızlandırabilir,
yavaşlatabilir veya durdurabilirsiniz.

Uçak ve Uçan Gemi araçları için durdurma, iniş yapmadan
gerçekleştirilemez.

İniş yapmak için, "Dur" butonunun altındaki "İniş" ibaresini
işaretlemeniz gerekmektedir.

Bu ibare işaretli olduğunda hava araçları da durabilir.

Araç üzerinde tüm değişiklikleri yaptıktan sonra aracı "Kaydet"
butonuna tıklayarak kaydedebilirsiniz.

Önceki menüye geri dönmek için "Geri" butonuna tıklayın.


Listeleme sayfası -----------

Listeleme sayfası, dosyadan okunan verileri, istenen biçme
göre listeler.

Listelemeyi yapmak için ekrandaki 3 büyük butondan birine
tıklayın.

Önceki menüye geri dönmek için "Geri" butonuna tıklayın.


Güncelleme sayfası ----------

Güncelleme sayfası, bir aracı güncellemenizi sağlar.
SINIF_ID kısmına aracın ID'sini yazıp "Ara" butonuna tıklayarak
O araca ait bilgileri gösterebilirsiniz. (Örn: OTO_0)

Araca ait bilgiler sağ tarafta gözüktükten sonra, "Miktar"
inputuna girilen değere göre aracı hızlandırıp
yavaşlatabilirsiniz.

"İniş yaptı mı?" ibaresi, yeni araç ekleme ekranındaki ile
aynı mantıkta çalışmaktadır.

Uçak ve Uçan Gemi araçları için durdurma, iniş yapmadan
gerçekleştirilemez.

İniş yapmak için, "Dur" butonunun altındaki "İniş yaptı mı?"
ibaresini işaretlemeniz gerekmektedir.

Bu ibare işaretli olduğunda hava araçları da durabilir.

Güncellemek istediğini kısımları değiştirdikten sonra
"Güncelle" butonuna tıklayarak veriyi güncelleyebilirsiniz.

Önceki menüye geri dönmek için "Geri" butonuna tıklayın.

-----------------------------