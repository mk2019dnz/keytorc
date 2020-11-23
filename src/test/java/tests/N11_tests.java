package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.N11_pages;
import utilities.ConfigurationReader;
import utilities.Driver;

public class N11_tests {



    @Test
    public void Test01() throws InterruptedException {

        // 1-) http://www.n11.com<http://www.n11.com/> sitesine gelecek ve anasayfanin acildigini onaylayacak
        Driver.getDriver().get(ConfigurationReader.getProperty("n11_url"));  //n11 sayfasina gittik
        Thread.sleep(1000);
        String url = Driver.getDriver().getCurrentUrl();   // sayfanin url'sini aldik
        Assert.assertEquals(url, ConfigurationReader.getProperty("n11_url"));  // sayfayi dogruladik
    }

    @Test
    public void Test02() throws InterruptedException {

        // 2-) Login ekranini acip, bir kullanici ile login olacak ( daha once siteye uyeliginiz varsa o olabilir )
        Driver.getDriver().get(ConfigurationReader.getProperty("n11_url"));
        N11_pages n11_pages = new N11_pages();
        n11_pages.spanMesaj.click();
        n11_pages.n11GirisYap.click();
        n11_pages.emailKutusu.sendKeys(ConfigurationReader.getProperty("email"));
        n11_pages.passwordKutusu.sendKeys(ConfigurationReader.getProperty("sifre"));
        Thread.sleep(2000);
        n11_pages.girisYap.click();


       //  3-) Ekranin ustundeki Search alanina 'samsung' yazip Ara butonuna tiklayacak
        Thread.sleep(2000);
        n11_pages.aramaKutusu.sendKeys("Samsung");
        n11_pages.aramaButonu.click();
        Thread.sleep(2000);

        // 4-) Gelen sayfada samsung icin sonuc bulundugunu onaylayacak
        String samsungSonucSayisi = n11_pages.sonuc.getText();
        System.out.println(samsungSonucSayisi);
        Thread.sleep(2000);

        // 5-) Arama sonuclarindan 2. sayfaya tiklayacak ve acilan sayfada 2. sayfanin su an gosterimde oldugunu onaylayacak
        n11_pages.sayfa2.click();
        String url2 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(url2,"https://www.n11.com/arama?q=Samsung&pg=2");

        // 6-) Ustten 3. urunun icindeki 'favorilere ekle' butonuna tiklayacak
        Thread.sleep(2000);
        n11_pages.favorilerimeEkle.click();
        String secilenUrun = n11_pages.favoriUrun.getText();

        // 7-) Ekranin en ustundeki 'favorilerim' linkine tiklayacak
        Thread.sleep(2000);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(n11_pages.hesabim).perform();
        n11_pages.favorilerim.click();

        // 8-) Acilan sayfada bir onceki sayfada izlemeye alinmis urunun bulundugunu onaylayacak
        Thread.sleep(2000);
        n11_pages.favorilerimListi.click();
        String urunum = n11_pages.urunIsmi.getText();
        Assert.assertEquals(secilenUrun,urunum);

        // 9-) Favorilere alinan bu urunun yanindaki 'Kaldir' butonuna basarak, favorilerimden cikaracak
        Thread.sleep(2000);
        n11_pages.deleteFavori.click();
        Thread.sleep(2000);
        n11_pages.tamamMesaji.click();

        // 10-) Sayfada bu urunun artik favorilere alinmadigini onaylayacak.
        Thread.sleep(2000);
        String bosFavoriListesiMesaji = n11_pages.bosListe.getText();
        System.out.println(bosFavoriListesiMesaji);

    }

}
