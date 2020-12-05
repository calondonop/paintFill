import org.junit.Test;

import static org.junit.Assert.*;

public class PaintFillTest {

    Color white = Color.White;
    Color pink = Color.Pink;
    Color blue = Color.Blue;
    Color purple = Color.Purple;

    @Test
    public void paintFillTest(){
        //Arrange
        Color[][] screen = new Color[4][4];

        screen[0] = new Color[]{blue, blue, blue, blue};
        screen[1] = new Color[]{blue, pink, pink, pink};
        screen[2] = new Color[]{blue, blue, blue, blue};
        screen[3] = new Color[]{blue, blue, blue, pink};

        //Expected Matrix case 1
        Color[][] expectedScreen1 = new Color[4][4];
        expectedScreen1[0] = new Color[]{blue, blue, blue, blue};
        expectedScreen1[1] = new Color[]{blue, purple, purple, purple};
        expectedScreen1[2] = new Color[]{blue, blue, blue, blue};
        expectedScreen1[3] = new Color[]{blue, blue, blue, pink};

        //Expected Matrix case 2
        Color[][] expectedScreen2 = new Color[4][4];
        expectedScreen2[0] = new Color[]{white, white, white, white};
        expectedScreen2[1] = new Color[]{white, purple, purple, purple};
        expectedScreen2[2] = new Color[]{white, white, white, white};
        expectedScreen2[3] = new Color[]{white, white, white, pink};

        //Act - In this case we are going to validate a given point centered in the matrix
        PaintFill.paintFill(screen, pink, purple, 1, 1);

        //Assert
        assertArrayEquals(expectedScreen1, screen);

        //Act - We are going to validate it work when the given point is in a extreme in the matrix
        PaintFill.paintFill(screen, blue, white, 3, 0);

        //Assert
        assertArrayEquals(expectedScreen2, screen);
    }
}
