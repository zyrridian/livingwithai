package com.zkylab.entity;

import java.util.Random;

import com.zkylab.common.GamePanel;

public class NPC_Red extends Entity {

    public static final String npcName = "Red";

    public NPC_Red(GamePanel gamePanel) {
        super(gamePanel);

        name = npcName;
        direction = "down";
        speed = 1;

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
        avatar = setup("/npc/avatar_red", gamePanel.tileSize, gamePanel.tileSize);
        up1 = setup("/npc/red_walk_up_3", gamePanel.tileSize, gamePanel.tileSize);
        up2 = setup("/npc/red_walk_up_2", gamePanel.tileSize, gamePanel.tileSize);
        left1 = setup("/npc/red_walk_left_3", gamePanel.tileSize, gamePanel.tileSize);
        left2 = setup("/npc/red_walk_left_2", gamePanel.tileSize, gamePanel.tileSize);
        down1 = setup("/npc/red_walk_down_3", gamePanel.tileSize, gamePanel.tileSize);
        down2 = setup("/npc/red_walk_down_2", gamePanel.tileSize, gamePanel.tileSize);
        right1 = setup("/npc/red_walk_right_3", gamePanel.tileSize, gamePanel.tileSize);
        right2 = setup("/npc/red_walk_right_2", gamePanel.tileSize, gamePanel.tileSize);
    }

    public void setDialogue() {
        dialogues[0][0] = "Halo, namaku Tim.";
        dialogues[0][1] = "Aku benar-benar kesulitan dengan tugas esai\nsekolahku.";
        dialogues[0][2] = "Aku tidak tahu harus mulai dari mana.";
        dialogues[0][3] = "Bisakah kau membantuku?";
        dialogues[0][4] = "Tentu saja bisa!";
        dialogues[0][5] = "Temui librarian di perpustakaan.";
        dialogues[1][0] = "Perpustakaan ada di salah satu gedung di sana.";
        dialogues[2][0] = "Cepatlah! Aku butuh bantuanmu.";
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
            actionLockCounter++;
            if (actionLockCounter == 120) { // Giving delay 2 second every movement
                Random random = new Random();
                int i = random.nextInt(100) + 1; // pick up a number from 1 to 100
                if (i <= 25) direction = "up";
                if (i > 25 && i <= 50) direction = "down";
                if (i > 50 && i <= 75) direction = "left";
                if (i > 75 && i <= 100) direction = "right";
                actionLockCounter = 0;
            }
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
