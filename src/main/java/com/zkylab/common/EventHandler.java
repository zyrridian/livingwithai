package com.zkylab.common;

import com.zkylab.data.Progress;
import com.zkylab.entity.Entity;

/**
 * Handles events such as dialogues, teleportation, and interactions in the
 * game.
 */
public class EventHandler {

    GamePanel gamePanel; // Game panel reference
    EventRect eventRect[][][]; // 3D array for event rectangles
    Entity eventMaster; // Entity responsible for dialogues and other events
    int previousEventX, previousEventY; // Previous event coordinates

    // Flags and temporary variables
    boolean canTouchEvent = true;
    int tempMap, tempCol, tempRow;

    /**
     * Constructor to initialize the event handler.
     *
     * @param gamePanel The GamePanel instance to interact with the game world.
     */
    public EventHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        eventMaster = new Entity(gamePanel);

        // Initialize the eventRect array
        eventRect = new EventRect[gamePanel.maxMap][gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        initializeEventRect();

        // Set default dialogues
        setDialogue();
    }

    public void initializeEventRect() {
        int map = 0, col = 0, row = 0;
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
    }

    /**
     * Sets default dialogues for various events.
     */
    public void setDialogue() {
        eventMaster.dialogues[0][0] = "You fall into a pit!";
        eventMaster.dialogues[1][0] = "You drink the water.\nYour life has been recovered.\n(The progress has been saved)";
        eventMaster.dialogues[1][1] = "Damn, that's a good water.";

        eventMaster.dialogues[2][0] = "Pintu terkunci.";
        eventMaster.dialogues[3][0] = "Sebuah tanaman.";
        eventMaster.dialogues[4][0] = "Tidak ada acara menarik di televisi.";
        eventMaster.dialogues[4][1] = "Membosankan.";
        eventMaster.dialogues[5][0] = "Sofa yang nyaman.";

        eventMaster.dialogues[6][0] = "Area ini berbahaya.";
        eventMaster.dialogues[6][1] = "Jangan mendekat.";
    }

    /**
     * Checks for events and triggers the appropriate actions based on player
     * position.
     */
    public void checkEvent() {
        // Check if the player character is more than 1 tile away from the last event
        int xDistance = Math.abs(gamePanel.player.worldX - previousEventX);
        int yDistance = Math.abs(gamePanel.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);

        // if (distance > gamePanel.tileSize) {
        canTouchEvent = true;
        // }

        if (canTouchEvent) {
            handleEvents();
        }

    }

    /**
     * Handles specific events based on player interactions with event rectangles.
     */
    private void handleEvents() {
        // Check for damage pits
        if (hit(0, 27, 16, "right"))
            damagePit(27, 16, GamePanel.DIALOGUE_STATE);

        // Check for healing pools
        else if (hit(0, 17, 15, "up") || hit(0, 18, 15, "up") || hit(0, 19, 15, "up") ||
                hit(0, 20, 15, "up") || hit(0, 21, 15, "up") || hit(0, 22, 15, "up") ||
                hit(0, 23, 15, "up"))
            healingPool(17, 15, GamePanel.DIALOGUE_STATE);

        // Check for NPC interactions
        else if (hit(1, 12, 9, "up"))
            speak(gamePanel.npc[1][0]);

        else if (hit(3, 25, 27, "any"))
            skeletonLord();

        // teleport new map
        // else if (hit(7, 17, 28, "left"))
        // teleport(8, 28, 27, GamePanel.INDOOR_AREA);
        // else if (hit(8, 29, 27, "right"))
        // teleport(7, 18, 28, GamePanel.INDOOR_AREA);
        // else if (hit(9, 24, 11, "up"))
        // teleport(7, 24, 28, GamePanel.INDOOR_AREA);
        // else if (hit(9, 25, 11, "up"))
        // teleport(7, 24, 28, GamePanel.INDOOR_AREA);
        // else if (hit(7, 24, 28, "down"))
        // teleport(9, (int) (25.5), 11, GamePanel.INDOOR_AREA);

        // else if (hit(7, 32, 24, "up") || hit(7, 27, 24, "up"))
        // interactObject(GamePanel.DIALOGUE_STATE, 2);
        // else if (hit(7, 23, 24, "up") || hit(7, 34, 24, "up"))
        // interactObject(GamePanel.DIALOGUE_STATE, 3);

        // else if (hit(7, 20, 24, "up") || hit(7, 21, 24, "up") || hit(7, 22, 24,
        // "up"))
        // interactObject(GamePanel.DIALOGUE_STATE, 4);
        // else if (hit(7, 19, 24, "down") || hit(7, 20, 25, "left") ||
        // hit(7, 20, 26, "left") || hit(7, 20, 27, "left") ||
        // hit(7, 19, 28, "up"))
        // interactObject(GamePanel.DIALOGUE_STATE, 5);

        // ========== EVENT TELEPORT ========== //
        else if (hit(0, 28, 14, "up") || hit(0, 29, 14, "up"))
            teleport(1, 26, 31, GamePanel.OUTSIDE_AREA); // Teleport kota 1 ke kota 2
        else if (hit(0, 36, 19, "right") || hit(0, 36, 20, "right") || hit(4, 18, 28, "right"))
            teleport(4, 18, 26, GamePanel.OUTSIDE_AREA); // Teleport kota 1 ke kota 5

        else if (hit(1, 25, 31, "down") || hit(1, 26, 31, "down"))
            teleport(0, 28, 14, GamePanel.OUTSIDE_AREA); // Teleport kota 2 ke kota 1
        else if (hit(1, 34, 21, "right") || hit(1, 34, 22, "right"))
            teleport(2, 14, 27, GamePanel.OUTSIDE_AREA); // Teleport kota 2 ke kota 3

        else if (hit(2, 14, 27, "left") || hit(2, 14, 28, "left"))
            teleport(1, 34, 21, GamePanel.OUTSIDE_AREA); // Teleport kota 3 ke kota 2
        else if (hit(2, 33, 27, "right") || hit(2, 33, 28, "right"))
            teleport(3, 12, 23, GamePanel.OUTSIDE_AREA); // Teleport kota 3 ke kota 4

        else if (hit(3, 12, 23, "left") || hit(3, 12, 24, "left"))
            teleport(2, 33, 27, GamePanel.OUTSIDE_AREA); // Teleport kota 4 ke kota 3
        else if (hit(3, 22, 36, "down") || hit(3, 23, 36, "down"))
            teleport(4, 24, 21, GamePanel.OUTSIDE_AREA); // Teleport kota 4 ke kota 5

        else if (hit(4, 24, 21, "up") || hit(4, 25, 21, "up") || hit(4, 26, 21, "up") || hit(4, 27, 21, "up"))
            teleport(3, 22, 36, GamePanel.OUTSIDE_AREA); // Teleport kota 5 ke kota 4
        else if (hit(4, 18, 26, "left") || hit(4, 18, 27, "left") || hit(4, 18, 28, "left"))
            teleport(0, 36, 19, GamePanel.OUTSIDE_AREA); // Teleport kota 5 ke kota 1

        // ========== RUMAH EVENTS ========== //
        else if (hit(0, 17, 19, "up"))
            openTheDoor(5, 24, 28, GamePanel.INDOOR_AREA); // Teleport kota 1 ke rumah
        else if (hit(5, 24, 28, "down"))
            teleport(0, 17, 19, GamePanel.OUTSIDE_AREA); // Teleport rumah ke kota 1
        else if (hit(5, 18, 28, "left"))
            teleport(6, 28, 27, GamePanel.INDOOR_AREA); // Teleport rumah ke dapur
        else if (hit(6, 28, 27, "right"))
            teleport(5, 18, 28, GamePanel.INDOOR_AREA); // Teleport dapur ke rumah

        else if (hit(0, 20, 19, "up"))
            openTheDoor(7, 24, 35, GamePanel.INDOOR_AREA); // Teleport kota 1 ke perpustakaan
        else if (hit(7, 24, 35, "down") || hit(7, 24, 35, "down"))
            teleport(0, 20, 19, GamePanel.OUTSIDE_AREA); // Teleport rumah ke kota 1

        // Locked door
        else if (hit(0, 26, 19, "up"))
            interactObject(GamePanel.DIALOGUE_STATE, 2);
        else if (hit(0, 33, 19, "up"))
            interactObject(GamePanel.DIALOGUE_STATE, 2);
        else if (hit(1, 29, 29, "up"))
            interactObject(GamePanel.DIALOGUE_STATE, 2);
        else if (hit(2, 19, 27, "up"))
            interactObject(GamePanel.DIALOGUE_STATE, 2);
        else if (hit(2, 25, 27, "up"))
            interactObject(GamePanel.DIALOGUE_STATE, 2);
        else if (hit(3, 19, 29, "up"))
            interactObject(GamePanel.DIALOGUE_STATE, 2);

        else if (hit(4, 33, 26, "right") || hit(4, 33, 27, "right") || hit(4, 33, 28, "right"))
            autoDialog(4, 33, 26, GamePanel.DIALOGUE_STATE, 6);

        // ========== STUDIO EVENTS ========== //
        else if (hit(0, 23, 19, "up"))
            openTheDoor(8, 28, 42, GamePanel.INDOOR_AREA); // Teleport kota 1 ke studio 1
        else if (hit(8, 28, 42, "down"))
            teleport(0, 23, 19, GamePanel.OUTSIDE_AREA); // Teleport studio 1 ke kota 1

    }

    /**
     * Checks if the player is interacting with a specific event rectangle.
     *
     * @param map          The map index.
     * @param col          The column index.
     * @param row          The row index.
     * @param reqDirection The required direction for the interaction.
     * @return true if the player is interacting with the event rectangle; false
     *         otherwise.
     */
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

            // Reset areas to default
            gamePanel.player.solidArea.x = gamePanel.player.solidAreaDefaultX;
            gamePanel.player.solidArea.y = gamePanel.player.solidAreaDefaultY;
            eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
            eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;

        }

        return hit;
    }

    public void autoDialog(int map, int col, int row, int gameState, int dialogue) {
        gamePanel.gameState = gameState;
        gamePanel.player.attackCanceled = true;
        eventMaster.startDialogue(eventMaster, dialogue);
    }

    public void openTheDoor(int map, int col, int row, int gameState) {
        if (gamePanel.keyHandler.enterPressed) {
            gamePanel.player.attackCanceled = true;
            teleport(map, col, row, gameState);
        }
    }

    /**
     * Handles interactions with objects.
     *
     * @param col       The column index.
     * @param row       The row index.
     * @param gameState The game state to transition to.
     * @param dialog    The dialogue index to display.
     */
    public void interactObject(int gameState, int dialog) {
        if (gamePanel.keyHandler.enterPressed) {
            gamePanel.gameState = gameState;
            gamePanel.player.attackCanceled = true;
            gamePanel.playSoundEffect(12);
            eventMaster.startDialogue(eventMaster, dialog);
        }
    }

    /**
     * Handles damage pit interactions.
     *
     * @param col       The column index.
     * @param row       The row index.
     * @param gameState The game state to transition to.
     */
    public void damagePit(int col, int row, int gameState) {
        gamePanel.gameState = gameState;
        gamePanel.playSoundEffect(1);
        eventMaster.startDialogue(eventMaster, 0);
        gamePanel.player.life -= 1;
        eventRect[0][col][row].eventDone = true;
        canTouchEvent = false;
    }

    /**
     * Handles healing pool interactions.
     *
     * @param col       The column index.
     * @param row       The row index.
     * @param gameState The game state to transition to.
     */
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

    /**
     * Handles teleportation events.
     *
     * @param map  The target map index.
     * @param col  The target column index.
     * @param row  The target row index.
     * @param area The target area to transition to.
     */
    public void teleport(int map, int col, int row, int area) {
        gamePanel.gameState = GamePanel.TRANSITION_STATE;
        gamePanel.nextArea = area;
        tempMap = map;
        tempCol = col;
        tempRow = row;
        canTouchEvent = false;
        gamePanel.playSoundEffect(14);
    }

    /**
     * Initiates dialogue with an entity.
     *
     * @param entity The entity to speak with.
     */
    public void speak(Entity entity) {
        if (gamePanel.keyHandler.enterPressed) {
            gamePanel.gameState = GamePanel.DIALOGUE_STATE;
            gamePanel.player.attackCanceled = true;
            entity.speak();
        }
    }

    /**
     * Handles the skeleton lord cutscene event.
     */
    public void skeletonLord() {
        if (!gamePanel.bossBattleOn && !Progress.skeletonLordDefeated) {
            gamePanel.gameState = GamePanel.CUTSCENE_STATE;
            gamePanel.cManager.sceneNumber = gamePanel.cManager.skeletonLord;
        }
    }

}
