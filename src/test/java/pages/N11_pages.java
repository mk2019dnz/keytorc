package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class N11_pages {

    public N11_pages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (partialLinkText = "Giriş Yap")
    public WebElement n11GirisYap;

    @FindBy(xpath = "//span[@class='btn btnBlack']")
    public WebElement spanMesaj;

    @FindBy (id = "email")
    public WebElement emailKutusu;

    @FindBy (id = "password")
    public WebElement passwordKutusu;

    @FindBy (className = "green_flat")
    public WebElement girisYap;

    @FindBy (id = "searchData")
    public WebElement aramaKutusu;

    @FindBy (xpath = "//a[@class='searchBtn']")
    public WebElement aramaButonu;

    @FindBy (className = "resultText ")
    public WebElement sonuc;

    @FindBy (xpath = "//a[@href='https://www.n11.com/arama?q=Samsung&pg=2']")
    public WebElement sayfa2;

    @FindBy (xpath = "//span[@class='textImg followBtn']")
    public WebElement favorilerimeEkle;

    @FindBy (xpath = "//h3[@class='productName ']")
    public WebElement favoriUrun;

    @FindBy (xpath = "//div[@class='myAccount']")
    public WebElement hesabim;

    @FindBy (xpath = "//a[@title='Favorilerim / Listelerim']")
    public WebElement favorilerim;

    @FindBy (xpath = "//h4[@class='listItemTitle']")
    public WebElement favorilerimListi;

    @FindBy (xpath = "//h3[@class='productName']")
    public WebElement urunIsmi;

    @FindBy (xpath = "//span[@class='deleteProFromFavorites']")
    public WebElement deleteFavori;

    @FindBy (xpath = "//div[@class='btnHolder']")
    public WebElement tamamMesaji;

    @FindBy (xpath = "//div[@class='emptyWatchList hiddentext']")
    public WebElement bosListe;


}
