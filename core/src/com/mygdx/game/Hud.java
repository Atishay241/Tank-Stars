package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Hud implements Disposable {

    //Scene2D.ui Stage and its own Viewport for HUD
    public Stage stage;
    private Viewport viewport;

    private static Integer score1;
    private static Integer fuel1;
    private static Integer fuel2;


    private static Integer score2;
    private static Integer power1;
    private static Integer angle1;
    //Scene2D widgets
    private Label player1;
    private Label player2;
    private Label power;
    private Label angle;
    private Label fuel;
    private Label fuel11;

    private static Label powerLabel1;
    private static Label angleLabel1;
    private static Label fuelLabel2;
    private static Label fuelLabel1;

    private static Label scoreLabel1;
    private static Label scoreLabel2;


    public static Integer getScore1() {
        return score1;
    }

    public static Integer getFuel2() {
        return fuel2;
    }

    public static Integer getFuel1() {
        return fuel1;
    }

    public static void setScore1(Integer score1) {
        Hud.score1 = score1;
    }

    public static Integer getScore2() {
        return score2;
    }

    public static void setScore2(Integer score2) {
        Hud.score2 = score2;
    }

    public static Integer getPower1() {
        return power1;
    }

    public static void setPower1(Integer power1) {
        Hud.power1 = power1;
    }

    public static Integer getAngle1() {
        return angle1;
    }

    public static void setAngle1(Integer angle1) {
        Hud.angle1 = angle1;
    }

    public Hud(SpriteBatch sb){
        score1 = 100;power1=1500;angle1=1500;
        fuel1=100;
        fuel2=100;
//        fuel2=100;
        score2=100;
        viewport = new FitViewport(tank.V_WIDTH,tank.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        Table table = new Table();
        table.top();
        table.setFillParent(true);

        //define our labels using the String, and a Label style consisting of a font and color
        scoreLabel1 =new Label(String.format("%d", score1), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel2 =new Label(String.format("%d", score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        powerLabel1 =new Label(String.format("%d", power1/100), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        angleLabel1 =new Label(String.format("%d", angle1/100), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        fuelLabel1 =new Label(String.format("%d", fuel1), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        fuelLabel2 =new Label(String.format("%d", fuel2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        player1 = new Label("Player 1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        player2 = new Label("Player 2", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        power = new Label("Power", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        angle = new Label("Angle", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        fuel = new Label("Fuel 1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        fuel11 = new Label("Fuel 2", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(player1).expandX().padTop(10);
        table.add(player2).expandX().padTop(10);
        table.add(power).expandX().padTop(10);
        table.add(angle).expandX().padTop(10);
        table.add(fuel).expandX().padTop(10);
        table.add(fuel11).expandX().padTop(10);
        table.row();
        table.add(scoreLabel1).expandX();
        table.add(scoreLabel2).expandX();
        table.add(powerLabel1).expandX();
        table.add(angleLabel1).expandX();
        table.add(fuelLabel1).expandX();
        table.add(fuelLabel2).expandX();



        stage.addActor(table);

    }
    public static void minushealth1(int value){
        score1-=value;
        scoreLabel1.setText(String.format("%d", score1));
    }
    public static void minushealth2(int value){
        score2-=value;
        scoreLabel2.setText(String.format("%d", score2));
    }
    public static void minusfuel1(int value){
        fuel1-=value;
        fuelLabel1.setText(String.format("%d", fuel1));
    }
    public static void minusfuel2(int value){
        fuel1-=value;
        fuelLabel1.setText(String.format("%d", fuel1));
    }
    public static void poweradd(){
        power1+=100;
        powerLabel1.setText(String.format("%d",power1/100));

    }
    public static void powerminus(){
        power1-=100;
        powerLabel1.setText(String.format("%d",power1/100));

    }
    public static void angleadd(){
        angle1+=100;
        angleLabel1.setText(String.format("%d",angle1/100));

    }
    public static void angleminux(){
        angle1-=100;
        angleLabel1.setText(String.format("%d",angle1/100));

    }
    @Override
    public void dispose() {
        stage.dispose();
    }
}

