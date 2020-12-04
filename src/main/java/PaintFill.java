import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.*;

public class PaintFill {
    public static void main(String[] args) {

    }

    public static Color[][] paintFill(Color[][] screen, int x, int y, Color newColor){
        int rows = screen.length;
        int columns = screen[0].length;
        if(validatePointExist(rows, columns, x, y)){
            //First we have a list with the positions we'll change the color, all points around the given point.
            List<Pair<Integer,Integer>> pointToChangeColor = new ArrayList<>();
            pointToChangeColor.add(new Pair<>(x-1, y-1));
            pointToChangeColor.add(new Pair<>(x, y-1));
            pointToChangeColor.add(new Pair<>(x+1, y-1));
            pointToChangeColor.add(new Pair<>(x-1, y+1));
            pointToChangeColor.add(new Pair<>(x, y+1));
            pointToChangeColor.add(new Pair<>(x+1, y+1));
            pointToChangeColor.add(new Pair<>(x-1, y));
            pointToChangeColor.add(new Pair<>(x+1, y));

            Color[][] finalScreen = screen;
            pointToChangeColor.stream().forEach((pair) -> {
                if(validatePointExist(rows, columns, pair.getKey(), pair.getValue())){
                    changeColor(finalScreen, pair.getKey(), pair.getValue(), newColor);
                }
            });
            screen = finalScreen;
        }
        return screen;
    }

    public static boolean validatePointExist(int rows, int columns, int x, int y){
        /* Taking as a reference the matrix length and positive positions.
           Determine if the point exist inside the matrix*/
        if (x>=0 && y>=0 && x<rows && y<columns) {
            return true;
        }else{
            return false;
        }
    }

    public static Color[][] changeColor(Color[][] screen, int x, int y, Color newColor){
        //When the color in the specified position is different to the newColor, is changed
        if (screen[x][y] != newColor) {
            screen[x][y] = newColor;
        }
        return screen;
    }
}
