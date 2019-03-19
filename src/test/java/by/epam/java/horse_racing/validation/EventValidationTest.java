package by.epam.java.horse_racing.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EventValidationTest {

    @Test(dataProvider = "isRidersValidTestData" , dataProviderClass = EventValidationTestData.class)
    public void isRidersValidTest(int event1Id , int event2Id , int event3Id , int event4Id , boolean expected) {
        //when
        boolean actual = EventValidation.getInstance().isRidersValid(event1Id , event2Id , event3Id , event4Id);
        //then
        Assert.assertEquals(actual , expected);
    }
}
