package by.epam.java.horse_racing.service;

import by.epam.java.horse_racing.bean.Bet;
import by.epam.java.horse_racing.bean.Event;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BetServiceTest {

    @Test(dataProvider = "formBetsTestData" , dataProviderClass = BetServiceTestData.class)
    public void formBetsTest(List<Bet> bets , List<Bet> expected) {
        //when
        bets = BetService.getInstance().formBets(bets);
        //then
        Assert.assertEquals(bets , expected);
    }

    @Test(dataProvider = "getPlayedBetsTestData" , dataProviderClass = BetServiceTestData.class)
    public void getPlayedBetsTest(List<Bet> bets , List<Bet> expected) {
        //when
        bets = BetService.getInstance().getPlayedBets(bets);
        //then
        Assert.assertEquals(bets , expected);
    }

    @Test(dataProvider = "getComingBetsTestData" , dataProviderClass = BetServiceTestData.class)
    public void getComingBetsTest(List<Bet> bets , List<Bet> expected) {
        //when
        bets = BetService.getInstance().getComingBets(bets);
        //then
        Assert.assertEquals(bets , expected);
    }

    @Test(dataProvider = "getCoefTypeByRiderPositionTestData" , dataProviderClass = BetServiceTestData.class)
    public void getCoefTypeByRiderPositionTest(Event event , int riderNumber , int riderPosition , List<Object> expected) {
        //when
        List<Object> actual = BetService.getInstance().getCoefTypeByRiderPosition(event , riderNumber , riderPosition);
        //then
        Assert.assertEquals(actual , expected);
    }
}
