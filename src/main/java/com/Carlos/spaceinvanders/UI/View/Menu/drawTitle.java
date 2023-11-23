package com.Carlos.spaceinvanders.UI.View.Menu;
import com.Carlos.spaceinvanders.Entities.Model.MenuModel;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;



//TODO
//IMPROVE NA LOGICA DE DESENHO DO MENU
//Fazer algo semelhante a da arena
public class drawTitle implements drawMenu {

    private int row;
    private MenuModel menuModel; // Onde vamos buscar o titlo e os outros atributos
    public drawTitle(){
        menuModel = new MenuModel();
    }

    public void drawTitle(TextGraphics graphics){
        TextColor textColor = new TextColor.RGB(178,73,210) ;
        TextColor backgroundColor = new TextColor.RGB(0, 0, 0);

        graphics.setForegroundColor(textColor);
        graphics.setBackgroundColor(backgroundColor);
        graphics.enableModifiers(SGR.BOLD);

        //String[] lines = menuModel.getTitle().split("\n");
        row = 0;
       // for (String line : lines) {
       //     graphics.putString(7, row, line);
       //     row++;
       // }
    }

    //Organizar melhor a posição das opcções deveriam ser inicializadas no Draw Menu
    //Alinhar
    //Fazer com que dependa do tamanho da arena!!!
    /*
    public void drawOptions(TextGraphics graphics){ // Deveria haver mais
        drawString(graphics,33, row + 5, menuModel.getStartGame(),new TextColor.RGB(255,255,0));
        drawString(graphics,33, row + 8, menuModel.getMySpaceShip(), new TextColor.RGB(0,255,0));
        drawString(graphics,33, row + 11, menuModel.Tutorial(), new TextColor.RGB(0,255,0));
        drawString(graphics,33, row + 14, menuModel.Options(), new TextColor.RGB(0,255,0));
        drawString(graphics,33, row + 17, menuModel.Exit(), new TextColor.RGB(255,0,0));
    }
    */
    public void drawString(TextGraphics graphics,int column, int row, String string, TextColor.RGB color){
        graphics.setForegroundColor(color);
        graphics.putString(column,row,string);
    }
    @Override
    public void draw(TextGraphics graphics){
        drawTitle(graphics);
        //drawOptions(graphics);
    }
}
