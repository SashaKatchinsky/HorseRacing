package by.epam.java.horse_racing.validation;

import by.epam.java.horse_racing.bean.Event;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BetValidationTest {
    @Test(dataProvider = "isTimeValidTestData" , dataProviderClass = BetValidationTestData.class)
    public void isTimeValidTest(Event event , boolean expected) {
        //when
        boolean actual = BetValidation.getInstance().isTimeValid(event);
        //then
        Assert.assertEquals(actual , expected);
    }
}
