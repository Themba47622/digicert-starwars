package com.starwars.steps;

import com.starwars.pages.FilmsLandingPage;
import com.starwars.pages.FilmsOverviewPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

public class MyStepdefsUI {
    WebDriver driver = Hooks.driver;
    FilmsLandingPage fl = new FilmsLandingPage(driver);
    FilmsOverviewPage fo = new FilmsOverviewPage(driver);

    @Given("I am on the Star Wars films landing page")
    public void iAmOnTheStarWarsFilmsLandingPage() {
        driver.get("http://localhost:3000/");
        //todo possible read the above from property file
    }

    @When("I sort movies by the Title")
    public void iSortMoviesByTheTitle() {
        fl.sortFilmsByTitle();
    }

    @Then("The last movie displayed should be {string}")
    public void theLastMovieDisplayedShouldBeThePhantomMenace(String expectedMovieName) {
        String lastMove = fl.verifyTitleAfterSort();
        assertEquals(lastMove, expectedMovieName, "Oops! Something went wrong. Assertion failed. ");
    }

    @When("I select the The Empire Strikes Back movie")
    public void iSelectTheEmpireStrikesBackMovie() {
        fl.selectTheEmpireStrikesBackMovie();
    }

    @When("I select the The Phantom Menace movie")
    public void iSelectThePhantomMenaceMovie() {
        fl.selectThePhantomMenaceMovie();
    }

    @Then("The specie {string} should be on the Species table list")
    public void theSpecieShouldBeOnTheSpeciesTableList(String specie) {
        Boolean containsWookie = fo.verifySpeciesList(specie);
        assertEquals(containsWookie, true, "Oops! Something went wrong. Assertion failed. ");
    }

    @Then("The planet {string} should not be on the Planets table list")
    public void thePlanetShouldNotBeOnThePlanetsTableList(String planet) {
        Boolean containsCamino = fo.verifyPlanetsList(planet);
        assertEquals(containsCamino, false, "Oops! Something went wrong. Assertion failed. ");
    }
}
