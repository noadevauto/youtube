package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.testng.annotations.Test;
import pages.SongPage;
import pages.YouTubePage;

public class YouTubeTests extends BaseTest {


    private final Logger log = Logger.getLogger(YouTubeTests.class);
    @Test (priority = 0)
    public void invalidLoginTest_InvalidUserNameInvalidPassword () throws InterruptedException {
        //*************PAGE METHODS WITH JAVA GENERICS********************

        //Initialize elements by using PageFactory
        page.GetInstance(YouTubePage.class).goToYouTube();

        //Chain of Invocation (Go to Login Page and then LoginToN11)
        page.GetInstance(YouTubePage.class)
                .searchVideo("I Will Survive - Alien song.");

        page.GetInstance(YouTubePage.class)
                .filter();
        page.GetInstance(YouTubePage.class)
                .clickOnfilterByVideo();
        page.GetInstance(YouTubePage.class)
                .filter();
        try{
            page.GetInstance(YouTubePage.class)
                    .clickOnViewCount();
        }
        catch (ElementNotInteractableException e){
            page.GetInstance(YouTubePage.class)
                    .filter();
            page.GetInstance(YouTubePage.class)
                    .clickOnViewCount();
        }

        page.GetInstance(YouTubePage.class)
                .goToIWillSurviveSong();
        page.GetInstance(SongPage.class)
                .skipOnAds();
        page.GetInstance(SongPage.class)
                .skipOnAds();
        String publisher = page.GetInstance(SongPage.class)
                .getThePublisherOfSong();
        log.info("The name of the publisher is: "+ publisher);
        page.GetInstance(SongPage.class)
                .clickShowMoreBtn();

        try{
            String artist = page.GetInstance(SongPage.class)
                    .getTheArtistName();
            log.info("The Atrtist name: "+artist);
        }
        catch (NullPointerException e){
            log.debug("No Artist name of this video");
        }



    }



}