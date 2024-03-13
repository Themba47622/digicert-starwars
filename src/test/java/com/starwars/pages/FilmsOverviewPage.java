package com.starwars.pages;

import com.starwars.guiutils.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilmsOverviewPage extends Common {

    private final WebDriver driver;

    @FindBy(xpath = "//a[.='Back']")
    private WebElement backBtn;

    @FindBy(xpath = "//h1[.='Species']")
    private WebElement headerSpecies;

    @FindBy(xpath = "//h1[.='Planets']")
    private WebElement headerPlanets;

    @FindBy(xpath = "//div[h1[text()='Species']]/following-sibling::ul")
    private WebElement ulElementSpecies;

    @FindBy(xpath = "//div[h1[text()='Planets']]/following-sibling::ul")
    private WebElement ulElementPlanets;

    public FilmsOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean verifySpeciesList(String expectedSpecie) {
        waitForElementVisibility(driver, headerSpecies, 10);
        scrollToElement(driver, headerSpecies);

        return isTextPresentInList(ulElementSpecies, expectedSpecie);
    }

    public Boolean verifyPlanetsList(String expectedPlanet) {
        waitForElementVisibility(driver, headerPlanets, 10);
        scrollToElement(driver, headerPlanets);

        return isTextPresentInList(ulElementPlanets, expectedPlanet);
    }
}
