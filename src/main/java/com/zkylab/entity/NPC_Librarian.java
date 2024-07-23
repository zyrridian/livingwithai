package com.zkylab.entity;

import java.util.Random;

import com.zkylab.common.GamePanel;

public class NPC_Librarian extends Entity {

    public static final String npcName = "Librarian";

    public NPC_Librarian(GamePanel gamePanel) {
        super(gamePanel);

        name = npcName;
        direction = "down";
        speed = 0;

        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 30;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        dialogueSet = -1;

        getImage();
        setDialogue();

    }

    public void getImage() {
        avatar = setup("/npc/avatar_librarian", gamePanel.tileSize, gamePanel.tileSize);
        up1 = setup("/npc/librarian_walk_up_1", gamePanel.tileSize, gamePanel.tileSize);
        up2 = setup("/npc/librarian_walk_up_1", gamePanel.tileSize, gamePanel.tileSize);
        left1 = setup("/npc/librarian_walk_left_1", gamePanel.tileSize, gamePanel.tileSize);
        left2 = setup("/npc/librarian_walk_left_1", gamePanel.tileSize, gamePanel.tileSize);
        down1 = setup("/npc/librarian_walk_down_1", gamePanel.tileSize, gamePanel.tileSize);
        down2 = setup("/npc/librarian_walk_down_1", gamePanel.tileSize, gamePanel.tileSize);
        right1 = setup("/npc/librarian_walk_right_1", gamePanel.tileSize, gamePanel.tileSize);
        right2 = setup("/npc/librarian_walk_right_1", gamePanel.tileSize, gamePanel.tileSize);
    }

    public void setDialogue() {
        dialogues[0][0] = "Selamat datang di perpustakaan.";
        dialogues[0][1] = "Silahkan baca buku yang kamu inginkan.";
    }

    public void setAction() {

        if (onPath) {
            
            // NPC path with goal
            // int goalCol = 12;
            // int goalRow = 9;
            
            // NPC path follow player
            int goalCol = (gamePanel.player.worldX + gamePanel.player.solidArea.x) / gamePanel.tileSize;
            int goalRow = (gamePanel.player.worldY + gamePanel.player.solidArea.y) / gamePanel.tileSize;
            // if (nextCol == goalCol && nextRow == goalRow) onPath = false;


            searchPath(goalCol, goalRow);

        } else {

            // actionLockCounter++;

            // if (actionLockCounter == 120) { // Giving delay 2 second every movement

            //     Random random = new Random();
            //     int i = random.nextInt(100) + 1; // pick up a number from 1 to 100
        
            //     if (i <= 25) direction = "up";
            //     if (i > 25 && i <= 50) direction = "down";
            //     if (i > 50 && i <= 75) direction = "left";
            //     if (i > 75 && i <= 100) direction = "right";
                
            //     actionLockCounter = 0;
                
            // }

        }
        
    }

    public void speak() {
        facePlayer();
        startDialogue(this, dialogueSet);
        dialogueSet++;
        if (dialogues[dialogueSet][0] == null) {
            // dialogueSet = 0; // Dialogue will be replayed again
            dialogueSet--; // Dialogue will be stuck in the end state
        }
    }
    
}
