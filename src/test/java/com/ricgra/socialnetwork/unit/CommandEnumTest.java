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

    @Test(description = "Test the POSTING command from input")
    public void testPostingCommandFromInput() {
        Assert.assertEquals(CommandEnum.getTypeFromInput("Alice -> new test post"), CommandEnum.POSTING);
    }

    @Test(description = "Test the READING command pattern")
    public void testReadingPatternSymbol() {
        Assert.assertEquals(CommandEnum.READING.getPattern(), " ");
    }

    @Test(description = "Test the READING command from input")
    public void testReadingCommandFromInput() {
        Assert.assertEquals(CommandEnum.getTypeFromInput("Alice"), CommandEnum.READING);
    }

    @Test(description = "Test the FOLLOWS command pattern")
    public void testFollowsPatternSymbol() {
        Assert.assertEquals(CommandEnum.FOLLOWS.getPattern(), " follows ");
    }

    @Test(description = "Test the FOLLOWS command from input")
    public void testFollowsCommandFromInput() {
        Assert.assertEquals(CommandEnum.getTypeFromInput("Alice follows Bob"), CommandEnum.FOLLOWS);
    }

    @Test(description = "Test the WALL command pattern")
    public void testWallPatternSymbol() {
        Assert.assertEquals(CommandEnum.WALL.getPattern(), " wall");
    }

    @Test(description = "Test the WALL command from input")
    public void testWallCommandFromInput() {
        Assert.assertEquals(CommandEnum.getTypeFromInput("Alice wall"), CommandEnum.WALL);
    }

}
