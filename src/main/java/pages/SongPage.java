package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SongPage  extends BasePage{

    @FindBy(how = How.CSS, using = "#owner #upload-info")
    public WebElement publisherTxt;

    @FindBy(how = How.CSS, using = "#description-inner #expand")
    public WebElement showMoreBtn;

    @FindBy(how = How.ID, using = "default-metadata")
    public List<WebElement> listOfMeteData;


    public SongPage(WebDriver driver) {
        super(driver);
    }

    public String getThePublisherOfSong(){
        return readText(publisherTxt).split("\n")[0];
    }

    public void clickShowMoreBtn(){
        click(showMoreBtn);
    }

    public String getTheArtistName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("default-metadata")));
        return  readText(listOfMeteData.get(1));
    }
}
