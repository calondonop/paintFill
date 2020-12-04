import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaintFillTest {

    Color white = Color.White;
    Color orange = Color.Orange;
    Color pink = Color.Pink;
    Color blue = Color.Blue;

    @Test
    public void paintFillTest(){
        //Arrange
        Color[][] screen = new Color[4][4];
        screen[0] = new Color[]{white, white, white, white};
        screen[1] = new Color[]{white, orange, white, white};
        screen[2] = new Color[]{white, white, white, white};
        screen[3] = new Color[]{white, white, white, white};

        //Expected Matrix case 1
        Color[][] expectedScreen1 = new Color[4][4];
        expectedScreen1[0] = new Color[]{pink, pink, pink, white};
        expectedScreen1[1] = new Color[]{pink, orange, pink, white};
        expectedScreen1[2] = new Color[]{pink, pink, pink, white};
        expectedScreen1[3] = new Color[]{white, white, white, white};

        //Expected Matrix case 2
        Color[][] expectedScreen2 = new Color[4][4];
        expectedScreen2[0] = new Color[]{pink, blue, pink, white};
        expectedScreen2[1] = new Color[]{blue, blue, pink, white};
        expectedScreen2[2] = new Color[]{pink, pink, pink, white};
        expectedScreen2[3] = new Color[]{white, white, white, white};

        //Act - In this case we are going to validate a given point centered in the matrix
        Color[][] resultScreen1 = PaintFill.paintFill(screen, 1, 1, Color.Pink);

        //Assert
        assertArrayEquals(expectedScreen1, resultScreen1);

        //Act - We are going to validate it work when the given point is in a extreme in the matrix
        Color[][] resultScreen2 = PaintFill.paintFill(screen, 0, 0, Color.Blue);

        //Assert
        assertArrayEquals(expectedScreen2, resultScreen2);
    }

    @Test
    public void validatePointExist(){
        //Act - Assert False
        //Those position cannot exist in a 4x4 matrix
        assertFalse(PaintFill.validatePointExist(4,4, -1,3));
        assertFalse(PaintFill.validatePointExist(4,4, 6,6));
        assertFalse(PaintFill.validatePointExist(4,4, 1,-2));

        //Those position exist in a 4x4 matrix
        assertTrue(PaintFill.validatePointExist(4,4, 3,3));
        assertTrue(PaintFill.validatePointExist(4,4, 0,0));
        assertTrue(PaintFill.validatePointExist(4,4, 2,2));
    }

    @Test
    public void changeColorTest(){
        //Arrange
        Color[][] screen = new Color[2][2];
        screen[0] = new Color[]{blue, blue};
        screen[1] = new Color[]{blue, blue};

        Color[][] expectedScreen = new Color[2][2];
        expectedScreen[0] = new Color[]{orange, blue};
        expectedScreen[1] = new Color[]{blue, blue};

        //Act
        Color[][] resultScreen = PaintFill.changeColor(screen, 0,0, orange);

        //Assert
        assertArrayEquals(expectedScreen, resultScreen);
    }

}
