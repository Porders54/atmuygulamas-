import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in) ;
        int bakiye = 10000;
        boolean AtmCalisiyorMu = true;
        System.out.println("Deka Bankasına Hoş Geldiliz");
        while (AtmCalisiyorMu) {
            System.out.println("Lütfen yapmak istediğiniz işlemi seçin");
            System.out.println("1 - Bakiye Sorgulama");
            System.out.println("2 - Para çekme");
            System.out.println("3 - Para yatırma");
            System.out.println("4 - Çık");
            int secim = x.nextInt() ;
            switch (secim) {
                case 1:
                    System.out.println("Güncel Bakiye = " + bakiye + "TL");
                    break;
                case 2:
                    System.out.println("Çekilecek Tutar");
                    int cekilecekpara = x.nextInt();
                    if (cekilecekpara > bakiye) {
                        System.out.println("Yetersiz Bakiye.Lütfen tekrar deneyiniz");
                    } else {
                        bakiye = bakiye - cekilecekpara;
                        System.out.println("Yeni Bakiye = " + bakiye + "TL");
                        System.out.println("Paranızı alınız");
                    } break;

                case 3:
                    System.out.println("Yatırılacak tutar");
                    int yatirilacakpara = x.nextInt();
                    bakiye = bakiye + yatirilacakpara;
                    System.out.println("Yeni Bakiye = " + bakiye + "TL");
                    break;
                case 4:
                    System.out.println("Kartınızı Alınız");
                    AtmCalisiyorMu = false;
                    break;
                default:
                    System.out.println("Yanlış rakam girdiniz.Lütfen tekrar deneyiniz");
            }
        }
    }
}