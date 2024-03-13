package com.starwars.pages;

import com.starwars.guiutils.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilmsLandingPage extends Common {

    private final WebDriver driver;

    @FindBy(xpath = "//th[contains(text(),'Title')]")
    private WebElement tableHeaderTitle;

    @FindBy(xpath = "//a[.='The Empire Strikes Back']")
    private WebElement linkTheEmpireStrikesBack;

    @FindBy(xpath = "//a[.='The Phantom Menace']")
    private WebElement linkThePhantomMenace;

    @FindBy(xpath = "//tbody/tr[last()]")
    private WebElement lastRowFilms;

    public FilmsLandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sortFilmsByTitle() {
        waitForClickableElement(driver, tableHeaderTitle, 10).click();
    }

    public void selectTheEmpireStrikesBackMovie() {
        waitForClickableElement(driver, linkTheEmpireStrikesBack, 10).click();
    }

    public void selectThePhantomMenaceMovie() {
        waitForClickableElement(driver, linkThePhantomMenace, 10).click();
    }

    public String verifyTitleAfterSort() {
        return getTextFromLastRow(lastRowFilms);
    }
}
