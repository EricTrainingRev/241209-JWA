package com.revature;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class UsingActionAPI {

    static WebDriver driver = null;

    public static void main(String[] args) {
        /*
            When Selenium interacts with the browser it simulates
            real user interaction, but it does so through an API
            by making HTTP requests

            Most of the time this is sufficient, but when a user is expected to
            perform a more complex action (such as moving a slider) or when you
            need to simulate a page listening for and responding to certain key strokes, the
            HTTP protocol becomes insufficient

            In these scenarios you need to use the Actions API, which provides Selenium with access
            to the keyboard, mouse, scroll wheel, and pen if one is supported
         */

        try{
            driver = SeleniumRunner.initializeDriver();
            driver.get("file:///C:/Users/EricSuminski/Desktop/241209-JWA/Week%203/Selenium-Continued/src/main/resources/pages/SliderPage.html");
            WebElement slider = driver.findElement(By.tagName("input"));
            // slider.sendKeys("6"); since the input is a "range" type sendKeys will not work with the element

            /*
                You could take a trial-and-error approach to moving the slider: the default for the ActionsAPI
                when moving the mouse to a element is to place it in the center of the element. You could go
                there and start guessing how far you need to move the mouse to get the desired value. This can
                work, but it requires a lot of factors to be consistent every time you run your code, such as
                the browser being the same size.

                A more flexible approach is to calculate the size of the element and the steps of the input and
                use that information to write a set of actions that can be repeated no matter the size or shape
                of the element
             */

            /*
                FOR THIS EXAMPLE WE WANT TO MAKE THE HEADER ELEMENT SHOW THE NUMBER 6, ACCOMPLISHED BY
                MOVING THE SLIDER TO THE 6 VALUE POSITION
             */

            /*
                First thing we need to do is figure out where the element is located. We can do this by
                using the getLocation method of the slider web element. This method returns the x/y coordinates
                of the element in the browser

                The way the grid works, the farther to the right of the browser (along the x axis) an element
                is the larger the x value becomes. The farther down the browser the element is (along the y axis)
                the larger the value of y becomes
             */
            Point sliderTopLeft = slider.getLocation();
            int sliderTopleftX = sliderTopLeft.getX();
            int sliderTopleftY = sliderTopLeft.getY();
            System.out.println(sliderTopLeft.getX()); // 10
            System.out.println(sliderTopLeft.getY()); // 81

            /*
                Getting the top left point of the element is step 1. Step 2 is getting the dimensions of the
                element on the web page, specifically its height and its width. We can get this information
                using the getSize method of the element
             */

            Dimension sliderDimension = slider.getSize();
            int sliderHeight = sliderDimension.getHeight();
            int sliderWidth = sliderDimension.getWidth();
            System.out.println(sliderDimension.getHeight()); // 16
            System.out.println(sliderDimension.getWidth()); // 129

            /*
                We have the pieces we need to move the cursor via Selenium over the slider. What we don't have
                yet (in our program) is the number of possible values of the slider, and how the value changes
                each "move" of the slider. So we need three pieces of information:
                - What is the minimum value?
                - What is the maximum value?
                - How much does the current value change when the slider is moved?

                Each of these pieces of information can be retrieved from the select WebElement
             */
            int min = Integer.parseInt(slider.getAttribute("min"));
            int max = Integer.parseInt(slider.getAttribute("max"));
            int step = Integer.parseInt(slider.getAttribute("step"));

            System.out.println(min); // 0
            System.out.println(max); // 10
            System.out.println(step); // 1

            /*
                Now that we have all the data points, we can start building an action chain. The
                ActionsAPI uses the builder pattern to create a chain of actions that can either
                be executed immediately using the "perform" method, or built into an Action object
                using the "build" method for use later
             */
            /*
                what actually needs to be automated?
                1. move to start of slider element*
                2. click and hold on the slider button*
                3. drag the button to the "6" position*
                4. release the click*
             */
            // variables so we don't need to redo calculations each time the values and ratios of
            // the element change
            int midFarLeftY = sliderTopleftY + sliderHeight/2;
            /*
                since the min value is 0 we have to tell our app to add 1 to the total possible values
             */
            int valueZones = (sliderWidth / Math.abs(min + max)) + 1;
            int targetValue = 6;

            int xOffset = valueZones*targetValue;

            new Actions(driver)
                    /*
                        for our starting position we can use the top left x coordinate by itself,
                        but to make sure we actually click on the button we can move the mouse
                        slightly down from the top left Y position. Since we have the height value
                        of the element, we can add half of the height to the y value so that we move
                        halfway down the element, so that our mouse is pointed to the halfway mark
                        down the element
                     */
                    .moveToLocation(sliderTopleftX,midFarLeftY)
                    /*
                        no calculations for click and hold, just call the clickAndHold method. If you
                        do this you will want to make sure you release the mouse click at the end of
                        the sequence in order to avoid any unintended behavior in later actions
                     */
                    .clickAndHold()
                    /*
                        moveByOffset will perform the actual movement across the screen for us. We have
                        to tell Selenium how much we want it to move along the Y and X axis, and Selenium
                        will move the mouse by that distance

                        We can calculate the distance we need to move by doing a little math: we know each
                        "move" of the button increase the value by 1, so that makes things a little simpler.
                        Since we are at the start of the slider element the value is going to start at 0, so
                        we need to "move" 6 times to reach the value of 6.

                        Here is where it is useful to know the width of the element: we can divide the element
                        into a number of sections equal to the total number of possible values the slider accommodates:
                        in this case, 11 values.

                        In this example, the width of the element is 129 pixels, so if we divide 129 by 11 we get
                        ~11.72. The browser pixel distance only works with whole numbers, so to be safe we can round up
                        and say each value in the slider has ~12 pixels of space. Move out of those 12 pixels and you
                        get into the "zone" of the new value, and the header element should show that new value

                        If it is ~12 pixels per value, and we want to get to the value 6, we move the X offset by
                        12*6 = 72
                     */
                    .moveByOffset(xOffset,0)
                    /*
                        Make sure to release the click when you are done
                     */
                    .release()
                    /*
                        either perform the action immediately or use "build" to save an action object
                        for later use
                     */
                    .perform()
            ;
            System.out.println(driver.findElement(By.tagName("h1")).getText());
        } finally {
            SeleniumRunner.quitDriver(driver);
        }


    }
}
