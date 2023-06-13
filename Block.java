import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import processing.core.*;

public class Block implements Interface {
    private int BlockWidth = 20;
    private int BlockHeight = 50;
    private int Blockx;
    private int Blocky;
    private int bR;
    private int bG;
    private int bB;
    public boolean mordi = false;
    private boolean Crash = true;
    public static int Speedy = -80;
    public static PApplet a = Main.processing;

    public Block(int blockx, int blocky, int bR, int bG, int bB) {
        Blockx = blockx;
        Blocky = blocky;
        this.bR = bR;
        this.bG = bG;
        this.bB = bB;
    }

    public static void MakeBlocks() {
        for (int i = 0; i < 80; i++) {
            Main.blocks.add(new Block(ThreadLocalRandom.current().nextInt(1, 100), Speedy, 225, 255, 255));
            Speedy -= 80;
            Main.blocks.add(new Block(ThreadLocalRandom.current().nextInt(101, 200), Speedy, 255, 255, 255));
            Speedy += 40;
            Main.blocks.add(new Block(ThreadLocalRandom.current().nextInt(201, 300), Speedy, 255, 255, 255));
            Speedy -= 30;
            Main.blocks.add(new Block(ThreadLocalRandom.current().nextInt(301, 400), Speedy, 255, 255, 255));
            Speedy -= 80;
        }
    }

    @Override
    public void ShowObject() {
        a.fill(new Random().nextInt(1, 255), new Random().nextInt(1, 255), new Random().nextInt(1, 255));
        a.noStroke();
        a.rect(Blockx, Blocky, BlockWidth, BlockHeight);

    }

    public int getBlockWidth() {
        return BlockWidth;
    }

    public void setBlockWidth(int blockWidth) {
        BlockWidth = blockWidth;
    }

    public int getBlockHeight() {
        return BlockHeight;
    }

    public void setBlockHeight(int blockHeight) {
        BlockHeight = blockHeight;
    }

    public int getBlockx() {
        return Blockx;
    }

    public void setBlockx(int blockx) {
        Blockx = blockx;
    }

    public int getbR() {
        return bR;
    }

    public void setbR(int bR) {
        this.bR = bR;
    }

    public int getbG() {
        return bG;
    }

    public void setbG(int bG) {
        this.bG = bG;
    }

    public int getbB() {
        return bB;
    }

    public void setbB(int bB) {
        this.bB = bB;
    }

    public int getBlocky() {
        return Blocky;
    }

    public void setBlocky(int blocky) {
        Blocky = blocky;
    }

    public static PApplet getA() {
        return a;
    }

    public static void setA(PApplet a) {
        Block.a = a;
    }

    public void setMordi(boolean mordi) {
        this.mordi = mordi;
    }

    public void setCrash(boolean Crash) {
        this.Crash = Crash;
    }

    public static void setSpeedy(int speedy) {
        Speedy = speedy;
    }

    public boolean isMordi() {
        return mordi;
    }

    public boolean isCrash() {
        return Crash;
    }

    public static int getSpeedy() {
        return Speedy;
    }

}
