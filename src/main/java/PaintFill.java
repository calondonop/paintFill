public class PaintFill {
    public static void main(String[] args) {
    }
    public static void paintFill (Color [][] screen,Color oldColor, Color newColor,int x,int y)
    {
        if(x>=0 && y>=0 && x < screen.length && y<screen[0].length && screen[x][y].equals(oldColor)){
            screen[x][y]=newColor;
            paintFill(screen,oldColor,newColor, x-1, y);
            paintFill(screen, oldColor, newColor,x+1, y);
            paintFill(screen, oldColor, newColor, x, y+1);
            paintFill(screen, oldColor, newColor, x, y-1);
        }
    }
}
