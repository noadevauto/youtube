package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class YouTubePage extends BasePage {

    //*********Constructor*********
    public YouTubePage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    String baseURL = "https://www.youtube.com";

    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.CSS, using = "#search-input #search")
    public WebElement searchText;

    @FindBy(how = How.ID, using = "search-icon-legacy")
    public WebElement glassBtn;

    @FindBy(how = How.CSS, using = "[aria-label*='filters']")
    public WebElement filterBtn;

    @FindBy(how = How.CSS, using = "#endpoint [title*='Video']")
    public WebElement filterByVideo;

    @FindBy(how = How.CSS, using = "#endpoint [title*='view count']")
    public WebElement viewCountBtn;

    @FindBy(how = How.CSS, using = "[href*='watch?v=ybXrrTX3LuI']")
    public WebElement iWillSurviveSongLink;



    public <T> void writeText (T elementAttr, String text) {
        if(elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).sendKeys(text);
        } else {
            ((WebElement) elementAttr).sendKeys(text);
        }
    }


    public void goToYouTube(){
        driver.get(baseURL);
    }


    public void searchVideo(String video){

        writeText(searchText,video);
        click(glassBtn);


    }



    public void filter(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label*='filters']")));
        click(filterBtn);
    }

    public void clickOnfilterByVideo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#endpoint [title*='Video']")));
        click(filterByVideo);
    }

    public void clickOnViewCount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#endpoint [title*='view count']")));
        click(viewCountBtn);
    }



    public SongPage goToIWillSurviveSong (){
        click(iWillSurviveSongLink);
        return new PageFactory().initElements(driver,SongPage.class);
    }
}