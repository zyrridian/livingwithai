package com.zkylab.common;

import com.zkylab.data.Progress;
import com.zkylab.entity.Entity;

public class EventHandler {

    GamePanel gamePanel;
    EventRect eventRect[][][];
    Entity eventMaster;

    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    int tempMap, tempCol, tempRow;

    public EventHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        eventMaster = new Entity(gamePanel);
        eventRect = new EventRect[gamePanel.maxMap][gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        int map = 0;
        int col = 0;
        int row = 0;
        while (map < gamePanel.maxMap && col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow) {
            eventRect[map][col][row] = new EventRect();
            eventRect[map][col][row].x = 23;
            eventRect[map][col][row].y = 23;
            eventRect[map][col][row].width = 2;
            eventRect[map][col][row].height = 2;
            eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
            eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;
            col++;
            if (col == gamePanel.maxWorldCol) {
                col = 0;
                row++;
                if (row == gamePanel.maxWorldRow) {
                    row = 0;
                    map++;
                }
            }
        }
        setDialogue();
    }

    public void setDialogue() {
        eventMaster.dialogues[0][0] = "You fall into a pit!";
        eventMaster.dialogues[1][0] = "You drink the water.\nYour life has been recovered.\n(The progress has been saved)";
        eventMaster.dialogues[1][1] = "Damn, that's a good water.";

        eventMaster.dialogues[2][0] = "Pintu terkunci.";
        eventMaster.dialogues[3][0] = "Sebuah tanaman.";
        eventMaster.dialogues[4][0] = "Tidak ada acara menarik di televisi.";
        eventMaster.dialogues[4][1] = "Membosankan.";
        eventMaster.dialogues[5][0] = "Sofa yang nyaman.";
    }

    public void checkEvent() {

        // Check if the player character is more than 1 tile away from the last event
        int xDistance = Math.abs(gamePanel.player.worldX - previousEventX);
        int yDistance = Math.abs(gamePanel.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);

        if (distance > gamePanel.tileSize) {
            canTouchEvent = true;
        }

        if (canTouchEvent) {
            if (hit(0, 27, 16, "right"))
                damagePit(27, 16, GamePanel.DIALOGUE_STATE);

            // ========== Healing Pool ========== //
            else if (hit(0, 17, 15, "up"))
                healingPool(17, 15, GamePanel.DIALOGUE_STATE);
            else if (hit(0, 18, 15, "up"))
                healingPool(18, 15, GamePanel.DIALOGUE_STATE);
            else if (hit(0, 19, 15, "up"))
                healingPool(19, 15, GamePanel.DIALOGUE_STATE);
            else if (hit(0, 20, 15, "up"))
                healingPool(20, 15, GamePanel.DIALOGUE_STATE);
            else if (hit(0, 21, 15, "up"))
                healingPool(21, 15, GamePanel.DIALOGUE_STATE);
            else if (hit(0, 22, 15, "up"))
                healingPool(22, 15, GamePanel.DIALOGUE_STATE);
            else if (hit(0, 23, 15, "up"))
                healingPool(23, 15, GamePanel.DIALOGUE_STATE);

            // ========== Teleport ========== //
            else if (hit(0, 38, 38, "right"))
                teleport(4, 9, 12, GamePanel.OUTSIDE_AREA);
            else if (hit(0, 38, 39, "right"))
                teleport(4, 9, 12, GamePanel.OUTSIDE_AREA);
            else if (hit(0, 38, 40, "right"))
                teleport(4, 9, 12, GamePanel.OUTSIDE_AREA);
            else if (hit(4, 9, 11, "left"))
                teleport(0, 39, 38, GamePanel.OUTSIDE_AREA);
            else if (hit(4, 9, 12, "left"))
                teleport(0, 39, 38, GamePanel.OUTSIDE_AREA);
            else if (hit(4, 9, 13, "left"))
                teleport(0, 39, 38, GamePanel.OUTSIDE_AREA);

            else if (hit(4, 33, 10, "up"))
                teleport(5, 24, 27, GamePanel.OUTSIDE_AREA);
            else if (hit(4, 34, 10, "up"))
                teleport(5, 24, 27, GamePanel.OUTSIDE_AREA);
            else if (hit(4, 35, 10, "up"))
                teleport(5, 24, 27, GamePanel.OUTSIDE_AREA);
            else if (hit(4, 36, 10, "up"))
                teleport(5, 24, 27, GamePanel.OUTSIDE_AREA);
            else if (hit(4, 37, 10, "up"))
                teleport(5, 24, 27, GamePanel.OUTSIDE_AREA);
            else if (hit(4, 38, 10, "up"))
                teleport(5, 24, 27, GamePanel.OUTSIDE_AREA);
            else if (hit(4, 39, 10, "up"))
                teleport(5, 24, 27, GamePanel.OUTSIDE_AREA);
            else if (hit(5, 24, 237, "down"))
                teleport(4, 36, 10, GamePanel.OUTSIDE_AREA);

            else if (hit(1, 12, 9, "up"))
                speak(gamePanel.npc[1][0]);
            else if (hit(0, 14, 20, "any"))
                teleport(1, 12, 13, GamePanel.INDOOR_AREA); // To the merchant
            else if (hit(1, 12, 13, "any"))
                teleport(0, 14, 20, GamePanel.OUTSIDE_AREA);
            else if (hit(0, 36, 11, "any"))
                teleport(2, 9, 41, GamePanel.DUNGEON_AREA); // To the dungeon
            else if (hit(2, 9, 41, "any"))
                teleport(0, 36, 11, GamePanel.OUTSIDE_AREA); // To the to outside
            else if (hit(2, 8, 7, "any"))
                teleport(3, 26, 41, GamePanel.DUNGEON_AREA); // To B2
            else if (hit(3, 26, 41, "any"))
                teleport(2, 8, 7, GamePanel.DUNGEON_AREA); // To B1
            else if (hit(3, 25, 27, "any"))
                skeletonLord();

            else if (hit(4, 28, 18, "any"))
                teleport(6, 12, 16, GamePanel.DUNGEON_AREA);
            else if (hit(4, 28, 21, "any"))
                teleport(6, 12, 16, GamePanel.DUNGEON_AREA);
            else if (hit(6, 12, 16, "any"))
                teleport(4, 28, 18, GamePanel.OUTSIDE_AREA);

            // teleport new map
            else if (hit(7, 17, 28, "left"))
                teleport(8, 28, 27, GamePanel.INDOOR_AREA);
            else if (hit(8, 29, 27, "right"))
                teleport(7, 18, 28, GamePanel.INDOOR_AREA);

            else if (hit(7, 32, 24, "up"))
                interactObject(32, 24, GamePanel.DIALOGUE_STATE, 2);
            else if (hit(7, 27, 24, "up"))
                interactObject(27, 24, GamePanel.DIALOGUE_STATE, 2);
            else if (hit(7, 23, 24, "up"))
                interactObject(23, 24, GamePanel.DIALOGUE_STATE, 3);
            else if (hit(7, 34, 24, "up"))
                interactObject(34, 24, GamePanel.DIALOGUE_STATE, 3);

            else if (hit(7, 20, 24, "up"))
                interactObject(20, 24, GamePanel.DIALOGUE_STATE, 4);
            else if (hit(7, 21, 24, "up"))
                interactObject(21, 24, GamePanel.DIALOGUE_STATE, 4);
            else if (hit(7, 22, 24, "up"))
                interactObject(22, 24, GamePanel.DIALOGUE_STATE, 4);

            else if (hit(7, 19, 24, "down"))
                interactObject(19, 24, GamePanel.DIALOGUE_STATE, 5);
            else if (hit(7, 20, 25, "left"))
                interactObject(20, 25, GamePanel.DIALOGUE_STATE, 5);
            else if (hit(7, 20, 26, "left"))
                interactObject(20, 26, GamePanel.DIALOGUE_STATE, 5);
            else if (hit(7, 20, 27, "left"))
                interactObject(20, 27, GamePanel.DIALOGUE_STATE, 5);
            else if (hit(7, 19, 28, "up"))
                interactObject(20, 27, GamePanel.DIALOGUE_STATE, 5);

            else if (hit(9, 24, 11, "up"))
                teleport(7, 24, 28, GamePanel.INDOOR_AREA);
            else if (hit(9, 25, 11, "up"))
                teleport(7, 24, 28, GamePanel.INDOOR_AREA);
            else if (hit(7, 24, 28, "down"))
                teleport(9, (int) (25.5), 11, GamePanel.INDOOR_AREA);
        }

    }

    public boolean hit(int map, int col, int row, String reqDirection) {

        boolean hit = false;

        if (map == gamePanel.currentMap) {

            gamePanel.player.solidArea.x = gamePanel.player.worldX + gamePanel.player.solidArea.x;
            gamePanel.player.solidArea.y = gamePanel.player.worldY + gamePanel.player.solidArea.y;
            eventRect[map][col][row].x = col * gamePanel.tileSize + eventRect[map][col][row].x;
            eventRect[map][col][row].y = row * gamePanel.tileSize + eventRect[map][col][row].y;

            if (gamePanel.player.solidArea.intersects(eventRect[map][col][row])
                    && !eventRect[map][col][row].eventDone) {
                if (gamePanel.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                    hit = true;
                    previousEventX = gamePanel.player.worldX;
                    previousEventY = gamePanel.player.worldY;

                }
            }

            gamePanel.player.solidArea.x = gamePanel.player.solidAreaDefaultX;
            gamePanel.player.solidArea.y = gamePanel.player.solidAreaDefaultY;
            eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
            eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;

        }

        return hit;

    }

    public void interactObject(int col, int row, int gameState, int dialog) {
        if (gamePanel.keyHandler.enterPressed) {
            gamePanel.gameState = gameState;
            gamePanel.player.attackCanceled = true;
            // gamePanel.playSoundEffect(2);
            eventMaster.startDialogue(eventMaster, dialog);
        }
    }

    public void damagePit(int col, int row, int gameState) {
        gamePanel.gameState = gameState;
        gamePanel.playSoundEffect(1);
        eventMaster.startDialogue(eventMaster, 0);
        gamePanel.player.life -= 1;
        eventRect[0][col][row].eventDone = true;
        canTouchEvent = false;
    }

    public void healingPool(int col, int row, int gameState) {
        if (gamePanel.keyHandler.enterPressed) {
            gamePanel.gameState = gameState;
            gamePanel.player.attackCanceled = true;
            gamePanel.playSoundEffect(2);
            eventMaster.startDialogue(eventMaster, 1);
            gamePanel.player.life = gamePanel.player.maxLife;
            gamePanel.player.mana = gamePanel.player.maxMana;
            gamePanel.assetSetter.setMonster(); // optional for testing purpose. reset monster
            gamePanel.saveLoad.save();
        }
    }

    public void teleport(int map, int col, int row, int area) {
        gamePanel.gameState = GamePanel.TRANSITION_STATE;
        gamePanel.nextArea = area;
        tempMap = map;
        tempCol = col;
        tempRow = row;
        canTouchEvent = false;
        gamePanel.playSoundEffect(14);
    }

    public void speak(Entity entity) {
        if (gamePanel.keyHandler.enterPressed) {
            gamePanel.gameState = GamePanel.DIALOGUE_STATE;
            gamePanel.player.attackCanceled = true;
            entity.speak();
        }
    }

    public void skeletonLord() {
        if (!gamePanel.bossBattleOn && !Progress.skeletonLordDefeated) {
            gamePanel.gameState = GamePanel.CUTSCENE_STATE;
            gamePanel.cManager.sceneNumber = gamePanel.cManager.skeletonLord;
        }
    }

}
