package com.ricgra.socialnetwork.unit;

import com.ricgra.socialnetwork.model.CommandEnum;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CommandEnumTest {

    @Test(description = "Test the POSTING command pattern")
    public void testPostingPatternSymbol() {
        Assert.assertEquals(CommandEnum.POSTING.getPattern(), " -> ");
    }

    @Test(description = "Test the READING command pattern")
    public void testReadingPatternSymbol() {
        Assert.assertEquals(CommandEnum.READING.getPattern(), " ");
    }

    @Test(description = "Test the FOLLOWS command pattern")
    public void testFollowsPatternSymbol() {
        Assert.assertEquals(CommandEnum.FOLLOWS.getPattern(), " follows ");
    }

    @Test(description = "Test the WALLS command pattern")
    public void testWallPatternSymbol() {
        Assert.assertEquals(CommandEnum.WALLS.getPattern(), " wall");
    }

}
