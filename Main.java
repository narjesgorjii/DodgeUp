import java.util.ArrayList;
import processing.core.*;

public class Main extends PApplet {

    public static PApplet processing;
    static int Count;
    boolean zendeii = true;
    static boolean Bordii = false;
    boolean test = true;
    public int Score;
    public int Highscore=0;
    public int live = 3;
    Human human;
    Block block;
    ArrayList<Integer> scores = Database.GetScore();

    public static ArrayList<Block> blocks = new ArrayList<>();

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    public void setup() {
        processing = this;
        human = new Human();
        Block.MakeBlocks();
        for(int i=0; i<scores.size(); i++){
            if(scores.get(i)>Highscore){
                Highscore=scores.get(i);
            }
        }

    }

    public void settings() {
        size(400, 600);
    }

    public void draw() {

        if (zendeii) {
            background(0);
            Score = Count;
            textSize(20);
            fill(255, 200, 180);
            text("Score = " + Count, 300, 40);

            textSize(20);
            fill(255, 200, 180);
            text("lives = " + live, 50, 40);
            stroke(150);
            line(0, 550, 400, 550);
            stroke(0);
            fill(0, 76, 153);
            for (Block block : blocks) {
                block.ShowObject();
            }
            check();
            human.ShowObject();
            MoveBlocks();
            removeBlock();

        } else if (Bordii) {
            if(Count>Highscore){
                Highscore=Count;
                // textSize(60);
                // fill(0, 200, 0);
                // text(" New High Score ", 110, 100);
            }
            background(0);
            textSize(40);
            fill(0, 200, 0);
            text("* BORDIIII *", 110, 200);
            textSize(25);
            fill(0, 200, 0);
            text("Your Score : " + Count, 120, 260);
            textSize(25);
            fill(0, 200, 0);
            text("High Score : " + Highscore, 120, 300);
            if (test) {
                Database.AddScore(Count);
                scores = Database.GetScore();
                test = false;
            }

        } else {
            if(Count>Highscore){
                Highscore=Count;
                // textSize(60);
                // fill(0, 200, 0);
                // text(" New High Score ", 110, 100);
            }
            background(0);
            textSize(40);
            fill(255, 0, 0);
            text("* MORDIIII *", 110, 200);
            textSize(25);
            fill(255, 0, 0);
            text("Your Score : " + Count, 120, 260);
            textSize(25);
            fill(255, 0, 0);
            text("High Score : " + Highscore, 120, 300);
            if (test) {
                Database.AddScore(Count);
                scores = Database.GetScore();
                test = false;
            }
        }

    }

    public void MoveBlocks() {
        for (Block block : blocks) {
            block.setBlocky(block.getBlocky() + 4);

        }

    }

    public void check() {
        for (Block block : blocks) {
            if (mouseX + 10 > block.getBlockx() && mouseX - 10 < block.getBlockx() + block.getBlockWidth()
                    && 540 + 35 > block.getBlocky()
                    && 540 - 10 < block.getBlocky() + block.getBlockHeight()) {
                background(100, 0, 0);

                if (block.isCrash()) {
                    live--;
                    block.setCrash(false);

                }

                if (live == 0) {
                    zendeii = false;
                }

            }

        }
    }

    public void removeBlock() {
        Count = 0;
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getBlocky() > 550) {
                Count++;
                if (Count >= 320) {

                    Bordii = true;
                    zendeii = false;
                }

            }
        }
    }

}