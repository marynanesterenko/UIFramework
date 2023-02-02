package utils;

import org.junit.After;
import org.junit.Before;

public class Base extends DriverUtils{

    @Before
    public void setUp(){
        createDriver("https://www.saucedemo.com/");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }

}
