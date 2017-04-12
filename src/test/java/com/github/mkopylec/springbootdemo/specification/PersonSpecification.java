package com.github.mkopylec.springbootdemo.specification;

import com.github.mkopylec.springbootdemo.specification.utils.DelayedInputFirefoxDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PersonSpecification {

    private DelayedInputFirefoxDriver webDriver;
    @LocalServerPort
    private int port;

    @Test
    public void shouldCreateAndDisplayPersons() throws Exception {
        webDriver.get("http://localhost:" + port + "/persons-creator");
        webDriver.wait(1);
        webDriver.enterTextIntoElement("name", "Mariusz");
        webDriver.enterTextIntoElement("surname", "Kopylec");
        webDriver.enterTextIntoElement("age", "31");
        webDriver.clickElement("creation-button");
        webDriver.wait(3);
        String message = webDriver.getElementText("message");

        assertEquals("Person Mariusz Kopylec created.", message);

        webDriver.clickElement("persons-viewer");
        webDriver.wait(3);
        String name = webDriver.getElementText("person-0-name");
        String surname = webDriver.getElementText("person-0-surname");
        String age = webDriver.getElementText("person-0-age");

        assertEquals("Mariusz", name);
        assertEquals("Kopylec", surname);
        assertEquals("31", age);

        webDriver.clickElement("persons-creator");
        webDriver.wait(1);
        webDriver.enterTextIntoElement("name", "John");
        webDriver.enterTextIntoElement("surname", "Doe");
        webDriver.enterTextIntoElement("age", "69");
        webDriver.clickElement("creation-button");
        webDriver.wait(3);
        message = webDriver.getElementText("message");

        assertEquals("Person John Doe created.", message);

        webDriver.clearElementText("name");
        webDriver.clearElementText("surname");
        webDriver.clearElementText("age");
        webDriver.enterTextIntoElement("name", "Fox");
        webDriver.enterTextIntoElement("surname", "Mulder");
        webDriver.enterTextIntoElement("age", "100");
        webDriver.clickElement("creation-button");
        webDriver.wait(3);
        message = webDriver.getElementText("message");

        assertEquals("Person Fox Mulder created.", message);

        webDriver.clickElement("persons-viewer");
        webDriver.wait(3);
        String name1 = webDriver.getElementText("person-0-name");
        String surname1 = webDriver.getElementText("person-0-surname");
        String age1 = webDriver.getElementText("person-0-age");

        assertEquals("Mariusz", name1);
        assertEquals("Kopylec", surname1);
        assertEquals("31", age1);

        String name2 = webDriver.getElementText("person-1-name");
        String surname2 = webDriver.getElementText("person-1-surname");
        String age2 = webDriver.getElementText("person-1-age");

        assertEquals("John", name2);
        assertEquals("Doe", surname2);
        assertEquals("69", age2);

        String name3 = webDriver.getElementText("person-2-name");
        String surname3 = webDriver.getElementText("person-2-surname");
        String age3 = webDriver.getElementText("person-2-age");

        assertEquals("Fox", name3);
        assertEquals("Mulder", surname3);
        assertEquals("100", age3);
    }

    @Before
    public void setUp() throws Exception {
        webDriver = new DelayedInputFirefoxDriver();
        webDriver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        webDriver.quit();
    }
}
