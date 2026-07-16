import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bakiye = 10000 ;
        boolean atmcalisiyormu = true;
        int dogrusifre = 1234 ;
        boolean girisbasarilimi = false;
        int kalanhak = 3;
        System.out.println("Deka Banka Hoş Geldiniz");
        while (girisbasarilimi == false && kalanhak > 0 ) {
            System.out.println("Lütfen Şifrenizi Giriniz = " + kalanhak);
            int girilensifre = scanner.nextInt();
            if (girilensifre == dogrusifre) {
                System.out.println("Şifre Doğru, Giriş Yapılıyor");
                girisbasarilimi = true;
            } else {
                kalanhak = kalanhak - 1;
                if (kalanhak > 0) {
                    System.out.println("Hatalı Şifre, Lütfen Tekrar Deneyiniz");
                } else {
                    System.out.println("3 Defa Yanlış Deneme yaptınız,Kartınız Bloke Edilmiştir");
                }

            }
        }
        if (girisbasarilimi) {
            while (atmcalisiyormu) {
                System.out.println("Lütfen İstediğiniz İşlemi Seçin");
                System.out.println("1- Bakiye Sorgulama");
                System.out.println("2- Para Çekme");
                System.out.println("3- Para Yatırma");
                System.out.println("4- Çık");
                int secim = scanner.nextInt();
                switch (secim) {
                    case 1:
                        System.out.println("Güncel Bakiye +   = " + bakiye + "TL" );
                        break;
                    case 2:
                        System.out.println("Çekilecek Tutar");
                        int cekilecektutar = scanner.nextInt();
                        if (cekilecektutar>bakiye)  {
                            System.out.println("Yetersiz Bakiye Lütfen Tekrar Deneyiniz");
                        } else {
                            bakiye = bakiye - cekilecektutar;
                            System.out.println("Yeni Bakiye = " +  bakiye + "TL");
                            System.out.println("Lütfen Paranızı Alınız");
                        } break;
                    case 3:
                        System.out.println("Yatırılacak Tutar");
                        int yatiricalaktutar = scanner.nextInt();
                        bakiye = bakiye + yatiricalaktutar;
                        System.out.println("Yeni Bakiye = " + bakiye + "TL");
                        break;
                    case 4:
                        System.out.println("Kartınızı Alınız");
                        atmcalisiyormu = false;
                        break;
                    default:
                        System.out.println("Yanlış Rakam Girdiniz, Lütfen Tekarar Deneyiniz");
                }
            }
        } else {
            System.out.println("Giriş başarısız olduğu için ATM menüsüne bağlanılamadı");
        }
    }
}
