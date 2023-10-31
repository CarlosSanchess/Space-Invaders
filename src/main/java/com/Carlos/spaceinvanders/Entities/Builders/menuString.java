package com.Carlos.spaceinvanders.Entities.Builders;

public class menuString{
    static String text =
            "                          _                     _               \n" +
                    "                         (_)                   | |              \n" +
                    " ___ _ __   __ _  ___ ___ _ _ ____   ____ _  __| | ___ _ __ ___ \n" +
                    "/ __| '_ \\ / _` |/ __/ _ \\ | '_ \\ \\ / / _` |/ _` |/ _ \\ '__/ __|\n" +
                    "\\__ \\.|_) | (_| | (_|  __/ | | | \\ V / (_| | (_| |  __/ |  \\__ \\\n" +
                    "|___/ .__/ \\__,_|\\___\\___|_|_| |_|\\_/ \\__,_|\\__,_|\\___|_|  |___/\n" +
                    "    | |                                                          \n" +
                    "    |_|                                                          \n";

    static String startGame = "NEW GAME";
    public static String getTitle(){
            return text;
    }
    public static String getStartGame(){
        return startGame;
    }
}
