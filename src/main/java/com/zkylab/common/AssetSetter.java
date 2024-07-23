package com.zkylab.common;

import com.zkylab.entity.NPC_Girl;
import com.zkylab.entity.NPC_Librarian;
import com.zkylab.entity.NPC_Musician;
import com.zkylab.entity.NPC_Professor;
import com.zkylab.entity.NPC_Red;
import com.zkylab.pet.PET_Dog;
import com.zkylab.tile_interactive.IT_StairLeft;
import com.zkylab.tile_interactive.IT_StairRight;

public class AssetSetter {

    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setObject() {

    }

    public void setNPC() {

        int mapNumber = 0;
        int i = 0;

        gamePanel.npc[mapNumber][i] = new NPC_Red(gamePanel);
        gamePanel.npc[mapNumber][i].worldX = gamePanel.tileSize * 18;
        gamePanel.npc[mapNumber][i].worldY = gamePanel.tileSize * 24;
        i++;

        gamePanel.npc[mapNumber][i] = new NPC_Girl(gamePanel);
        gamePanel.npc[mapNumber][i].worldX = gamePanel.tileSize * 26;
        gamePanel.npc[mapNumber][i].worldY = gamePanel.tileSize * 23;
        i++;

        mapNumber = 4;
        i = 0;

        gamePanel.npc[mapNumber][i] = new NPC_Professor(gamePanel);
        gamePanel.npc[mapNumber][i].worldX = gamePanel.tileSize * 27;
        gamePanel.npc[mapNumber][i].worldY = gamePanel.tileSize * 26;
        i++;

        gamePanel.npc[mapNumber][i] = new PET_Dog(gamePanel);
        gamePanel.npc[mapNumber][i].worldX = gamePanel.tileSize * 22;
        gamePanel.npc[mapNumber][i].worldY = gamePanel.tileSize * 26;
        i++;

        mapNumber = 7;
        i = 0;

        gamePanel.npc[mapNumber][i] = new NPC_Librarian(gamePanel);
        gamePanel.npc[mapNumber][i].worldX = gamePanel.tileSize * 24;
        gamePanel.npc[mapNumber][i].worldY = gamePanel.tileSize * 27;
        i++;

        mapNumber = 8;
        i = 0;

        gamePanel.npc[mapNumber][i] = new NPC_Musician(gamePanel);
        gamePanel.npc[mapNumber][i].worldX = gamePanel.tileSize * 30;
        gamePanel.npc[mapNumber][i].worldY = gamePanel.tileSize * 33;
        i++;

    }

    public void setMonster() {

    }

    public void setInteractiveTile() {

        // PERPUSTAKAAN
        int mapNumber = 7;
        int i = 0;

        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 23);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 24);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 25);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 26);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 27);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 28);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 29);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 30);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 23);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 24);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 25);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 26);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 26);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 27);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 28);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 29);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 30);
        i++;

        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 23);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 24);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 25);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 26);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 26);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 27);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 28);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 29);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 30);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 23);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 24);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 25);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 26);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 26);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 27);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 28);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 29);
        i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 30);
        i++;

    }
}
