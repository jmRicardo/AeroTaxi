package AeroTaxi.graphic;


import java.awt.*;

public class SwingUtil {

    public static final Color backgroundColor = initColor(44,44,44,255);
    public static final Color buttonColor = initColor(36,39,41,255);
    public static final Color textColor = initColor(255,255,255,200);

    private static Color initColor(int r,int g,int b,int a){
        return new Color(r,g,b,a);
    }
}
