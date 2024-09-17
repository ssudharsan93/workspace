import {test, expect} from '@playwright/test';

test("Open home page and verify title", async ({page}) => { 
    await page.goto('https://www.fifa.com/en/home');
    await expect(page).toHaveTitle(/FIFA/);
    await expect(page).toHaveTitle('FIFA | The Home of Football');
})

test("Verify logo is visible and has the alt property", async ({page}) => { 
    await page.goto('https://www.fifa.com/en/home');
    const logo = page.locator('[href="/en/home"]'); // css locator
                                                    // to identify by specific properties do the above.
                                                    // to identify by class precede the word with a .
                                                    // to identify by id precede the word with a #
    const img = page.locator('[href="/en/home"] img'); // this says locate the component with the given
                                                    // href property and then locate the img tag
    await expect(logo).toBeVisible();
    await expect(img).toHaveAttribute('alt', 'FIFA');
})

test("Verify Nav Bar Texts", async ({page}) => {
    const navTexts = [
           "Games", "", "", "Schedule", "", "", "", "", "", "", "Watch", "", "", "News", "",
           "", "", "", "", "", "", "", "", "Olympics", "Summer League", "Free Agency", "NBA Cup",
           "Stats", "", "", "", "", "", "", "", "", "", "", "", "", "Teams", "", "", "", "", "",
           "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
           "", "", "", "", "Players", "", "", "", "", "", "NBA Play", "", "", "", "", "", "", "",
           "Future Starts Now", "League Pass", "Store", "", "", "", "", "", "", "", "", "", "", "",
           "", "", "Tickets", "", "", "", "", "", "", "",
        ];
    await page.goto('https://www.nba.com/');
    await page.pause();
    const navLinks = page.locator('#nav-ul a');
    await expect(navLinks.first()).toBeVisible(); // waits for the first link in the nav bar to be visible
    expect(await navLinks.allInnerTexts()).toEqual(navTexts); // only put await in front of 
                                                              // methods that return promises
                                                              // Hovering over methods tells you this.
                                                              // Checks the text of all the nav bar elements and
                                                              // ensures that all that text matches what is expected.
})