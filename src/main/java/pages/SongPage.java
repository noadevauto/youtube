package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SongPage  extends BasePage{
    public static Logger log = Logger.getLogger(SongPage.class.getName());

    @FindBy(how = How.CSS, using = "#owner #upload-info")
    public WebElement publisherTxt;

    @FindBy(how = How.CSS, using = "#description-inner #expand")
    public WebElement showMoreBtn;

    @FindBy(how = How.ID, using = "default-metadata")
    public List<WebElement> listOfMeteData;

    @FindBy(how = How.CSS, using = ".ytp-ad-skip-button [id*='ad-text']")
    public WebElement skipAdBtn;

    @FindBy(how = How.CSS, using = "[id*='ad-text']")
    public List<WebElement> adsListElements;


    public SongPage(WebDriver driver) {
        super(driver);
    }

    public String getThePublisherOfSong(){
        return readText(publisherTxt).split("\n")[0];
    }

    public void clickShowMoreBtn(){
        click(showMoreBtn);
    }

    public void clickOnSkipAd(){
        click(skipAdBtn);
    }

    public void skipOnAds(){
        try{
            WebElement var = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ytp-ad-skip-button [id*='ad-text']")));
            if(var.isDisplayed())
            {
                clickOnSkipAd();
            }
        }
        catch(TimeoutException exception){

        }



    }

    public String getTheArtistName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("default-metadata")));
        return  readText(listOfMeteData.get(1));
    }
}
