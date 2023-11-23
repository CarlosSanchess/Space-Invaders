package com.Carlos.spaceinvanders.Control;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class gameCountdown {
    TextGraphics graphics;
    public gameCountdown(TextGraphics graphics){
            this.graphics = graphics;
    }
     List<Integer> numbers = new ArrayList<Integer>() {{
         add(3);
         add(2);
         add(1);
     }};
    public int Draw() throws InterruptedException {
            Thread.sleep(250);
            TextColor textColor = new TextColor.RGB(178,73,210) ;
            graphics.enableModifiers(SGR.BOLD);
            for (Integer number: numbers){
                graphics.putString(40,20,number.toString());
                Thread.sleep(1000);
            }
        return 1;
    }
}
