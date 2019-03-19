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

    @Test(dataProvider = "isRidersValidTestData" , dataProviderClass = BetValidationTestData.class)
    public void isRidersValidTest(int rider1Position , int rider2Position , int rider3Position , int rider4Position , int countOfRiders , boolean expected) {
        //when
        boolean actual = BetValidation.getInstance().isRidersValid(rider1Position , rider2Position , rider3Position , rider4Position , countOfRiders);
        //then
        Assert.assertEquals(actual , expected);
    }

}
