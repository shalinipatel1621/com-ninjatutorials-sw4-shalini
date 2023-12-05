package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopAndNotebookPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {

    //create an object
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    LaptopAndNotebookPage laptopAndNoteBookPage = new LaptopAndNotebookPage();
    ComponentsPage componentsPage = new ComponentsPage();

    //1. create class "TopMenuTest"
    //  1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
//1.2 This method should click on the menu whatever name is passed as parameter.

    // Write the following Test:

    @Test

    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {


//1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverAndClickOnDesktop();

//1.2 call selectMenu method and pass the menu = “Show All Desktops”
        homePage.selectMenu("Show All Desktops");

        // 1.3 Verify the text ‘Desktops’
        String expectedDesktop = "Desktops";
        String actualDesktop = desktopPage.getDesktopText();

        //verify if user is navigated to the correct page
        Assert.assertEquals(actualDesktop, expectedDesktop, "Desktop not displayed");

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {


//2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverAndClickOnLaptopsAndNotebooks();


//2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.selectMenu("Show All Laptops & Notebooks");

// 2.3 Verify the text ‘Laptops & Notebooks’
        String expectedLaptop = "Laptops & Notebooks";
        String actualLaptop = laptopAndNoteBookPage.getLaptopAndNoteBookText();
        //verify if user is navigated to the correct page
        Assert.assertEquals(actualLaptop, expectedLaptop, "Laptops & Notebooks not displayed");
    }

    @Test

    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

//3.1 Mouse hover on “Components” Tab and click
        homePage.mouseHoverAndClickOnComponents();

//3.2 call selectMenu method and pass the menu = "Show All Components"
        homePage.selectMenu("Show All Components");

// 3.3 Verify the text 'Components'
        String expectedComponents = "Components";
        String actualComponents = componentsPage.getComponentsText();
        //verify if user is navigated to the correct page
        Assert.assertEquals(actualComponents, expectedComponents, "Components not displayed");
    }


}

