package com.zkylab.common;

import com.zkylab.data.Progress;
import com.zkylab.entity.NPC_BigRock;
import com.zkylab.entity.NPC_Merchant;
import com.zkylab.entity.NPC_OldMan;
import com.zkylab.monster.MON_GreenSlime;
import com.zkylab.monster.MON_Orc;
import com.zkylab.monster.MON_RedSlime;
import com.zkylab.monster.MON_SkeletonLord;
import com.zkylab.monster.MON_Bat;
import com.zkylab.object.OBJ_Axe;
import com.zkylab.object.OBJ_BlueHeart;
import com.zkylab.object.OBJ_Boots;
import com.zkylab.object.OBJ_Chest;
import com.zkylab.object.OBJ_Door;
import com.zkylab.object.OBJ_DoorIron;
import com.zkylab.object.OBJ_Key;
import com.zkylab.object.OBJ_Lantern;
import com.zkylab.object.OBJ_Pickaxe;
import com.zkylab.object.OBJ_Potion_Red;
import com.zkylab.object.OBJ_Shield_Red;
import com.zkylab.tile_interactive.IT_DestructibleWall;
import com.zkylab.tile_interactive.IT_DryTree;
import com.zkylab.tile_interactive.IT_MetalPlate;
import com.zkylab.tile_interactive.IT_StairLeft;
import com.zkylab.tile_interactive.IT_StairRight;

public class AssetSetter {

    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setObject() {

        int mapNumber = 0;
        int i = 0;

        gamePanel.obj[mapNumber][i] = new OBJ_Lantern(gamePanel);
        gamePanel.obj[mapNumber][i].worldX = gamePanel.tileSize * 10;
        gamePanel.obj[mapNumber][i].worldY = gamePanel.tileSize * 33;
        i++;

        gamePanel.obj[mapNumber][i] = new OBJ_Chest(gamePanel);
        gamePanel.obj[mapNumber][i].setLoot(new OBJ_Axe(gamePanel));
        gamePanel.obj[mapNumber][i].worldX = gamePanel.tileSize * 11;
        gamePanel.obj[mapNumber][i].worldY = gamePanel.tileSize * 33;
        i++;

        gamePanel.obj[mapNumber][i] = new OBJ_Chest(gamePanel);
        gamePanel.obj[mapNumber][i].setLoot(new OBJ_Key(gamePanel));
        gamePanel.obj[mapNumber][i].worldX = gamePanel.tileSize * 24;
        gamePanel.obj[mapNumber][i].worldY = gamePanel.tileSize * 29;
        i++;

        gamePanel.obj[mapNumber][i] = new OBJ_Chest(gamePanel);
        gamePanel.obj[mapNumber][i].setLoot(new OBJ_Potion_Red(gamePanel));
        gamePanel.obj[mapNumber][i].worldX = gamePanel.tileSize * 30;
        gamePanel.obj[mapNumber][i].worldY = gamePanel.tileSize * 15;
        i++;

        gamePanel.obj[mapNumber][i] = new OBJ_Door(gamePanel);
        gamePanel.obj[mapNumber][i].worldX = gamePanel.tileSize * 14;
        gamePanel.obj[mapNumber][i].worldY = gamePanel.tileSize * 24;
        i++;

        mapNumber = 2;
        i = 0;

        gamePanel.obj[mapNumber][i] = new OBJ_Door(gamePanel);
        gamePanel.obj[mapNumber][i].worldX = gamePanel.tileSize * 9;
        gamePanel.obj[mapNumber][i].worldY = gamePanel.tileSize * 39;
        i++;

        gamePanel.obj[mapNumber][i] = new OBJ_Chest(gamePanel);
        gamePanel.obj[mapNumber][i].setLoot(new OBJ_Pickaxe(gamePanel));
        gamePanel.obj[mapNumber][i].worldX = gamePanel.tileSize * 40;
        gamePanel.obj[mapNumber][i].worldY = gamePanel.tileSize * 41;
        i++;

        gamePanel.obj[mapNumber][i] = new OBJ_Chest(gamePanel);
        gamePanel.obj[mapNumber][i].setLoot(new OBJ_Potion_Red(gamePanel));
        gamePanel.obj[mapNumber][i].worldX = gamePanel.tileSize * 13;
        gamePanel.obj[mapNumber][i].worldY = gamePanel.tileSize * 16;
        i++;

        gamePanel.obj[mapNumber][i] = new OBJ_Chest(gamePanel);
        gamePanel.obj[mapNumber][i].setLoot(new OBJ_Potion_Red(gamePanel));
        gamePanel.obj[mapNumber][i].worldX = gamePanel.tileSize * 26;
        gamePanel.obj[mapNumber][i].worldY = gamePanel.tileSize * 34;
        i++;

        gamePanel.obj[mapNumber][i] = new OBJ_Chest(gamePanel);
        gamePanel.obj[mapNumber][i].setLoot(new OBJ_Potion_Red(gamePanel));
        gamePanel.obj[mapNumber][i].worldX = gamePanel.tileSize * 27;
        gamePanel.obj[mapNumber][i].worldY = gamePanel.tileSize * 15;
        i++;

        gamePanel.obj[mapNumber][i] = new OBJ_DoorIron(gamePanel);
        gamePanel.obj[mapNumber][i].worldX = gamePanel.tileSize * 18;
        gamePanel.obj[mapNumber][i].worldY = gamePanel.tileSize * 23;
        i++;

        mapNumber = 3;
        i = 0;
        
        gamePanel.obj[mapNumber][i] = new OBJ_DoorIron(gamePanel);
        gamePanel.obj[mapNumber][i].worldX = gamePanel.tileSize * 25;
        gamePanel.obj[mapNumber][i].worldY = gamePanel.tileSize * 15;
        i++;
        
        gamePanel.obj[mapNumber][i] = new OBJ_BlueHeart(gamePanel);
        gamePanel.obj[mapNumber][i].worldX = gamePanel.tileSize * 25;
        gamePanel.obj[mapNumber][i].worldY = gamePanel.tileSize * 8;
        i++;

        mapNumber = 6;
        i = 0;
        
        gamePanel.obj[mapNumber][i] = new OBJ_Chest(gamePanel);
        gamePanel.obj[mapNumber][i].setLoot(new OBJ_Shield_Red(gamePanel));
        gamePanel.obj[mapNumber][i].worldX = gamePanel.tileSize * 41;
        gamePanel.obj[mapNumber][i].worldY = gamePanel.tileSize * 32;
        i++;
        
        gamePanel.obj[mapNumber][i] = new OBJ_Chest(gamePanel);
        gamePanel.obj[mapNumber][i].setLoot(new OBJ_Key(gamePanel));
        gamePanel.obj[mapNumber][i].worldX = gamePanel.tileSize * 23;
        gamePanel.obj[mapNumber][i].worldY = gamePanel.tileSize * 31;
        i++;

    }

    public void setNPC() {

        int mapNumber = 0;
        int i = 0;

        gamePanel.npc[mapNumber][i] = new NPC_OldMan(gamePanel);
        gamePanel.npc[mapNumber][i].worldX = gamePanel.tileSize * 21;
        gamePanel.npc[mapNumber][i].worldY = gamePanel.tileSize * 35;
        i++;

        mapNumber = 1;
        i = 0;

        gamePanel.npc[mapNumber][i] = new NPC_Merchant(gamePanel);
        gamePanel.npc[mapNumber][i].worldX = gamePanel.tileSize * 12;
        gamePanel.npc[mapNumber][i].worldY = gamePanel.tileSize * 7;
        i++;

        mapNumber = 2;
        i = 0;

        gamePanel.npc[mapNumber][i] = new NPC_BigRock(gamePanel);
        gamePanel.npc[mapNumber][i].worldX = gamePanel.tileSize * 20;
        gamePanel.npc[mapNumber][i].worldY = gamePanel.tileSize * 25;
        i++;

        gamePanel.npc[mapNumber][i] = new NPC_BigRock(gamePanel);
        gamePanel.npc[mapNumber][i].worldX = gamePanel.tileSize * 11;
        gamePanel.npc[mapNumber][i].worldY = gamePanel.tileSize * 18;
        i++;

        gamePanel.npc[mapNumber][i] = new NPC_BigRock(gamePanel);
        gamePanel.npc[mapNumber][i].worldX = gamePanel.tileSize * 23;
        gamePanel.npc[mapNumber][i].worldY = gamePanel.tileSize * 14;
        i++;

    }

    public void setMonster() {

        int mapNumber = 0;
        int i = 0;

        // bottom center
        gamePanel.monster[mapNumber][i] = new MON_GreenSlime(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 34;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 39;
        i++;

        gamePanel.monster[mapNumber][i] = new MON_GreenSlime(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 35;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 39;
        i++;
        
        gamePanel.monster[mapNumber][i] = new MON_GreenSlime(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 36;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 39;
        i++;

        gamePanel.monster[mapNumber][i] = new MON_GreenSlime(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 35;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 37;
        i++;

        gamePanel.monster[mapNumber][i] = new MON_GreenSlime(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 35;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 40;
        i++;

        // top right
        gamePanel.monster[mapNumber][i] = new MON_RedSlime(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 35;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 13;
        i++;

        gamePanel.monster[mapNumber][i] = new MON_RedSlime(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 36;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 13;
        i++;

        gamePanel.monster[mapNumber][i] = new MON_RedSlime(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 39;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 14;
        i++;

        // bottom left
        gamePanel.monster[mapNumber][i] = new MON_Orc(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 28;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 32;
        i++;

        mapNumber = 2;
        i = 0;

        gamePanel.monster[mapNumber][i] = new MON_Bat(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 34;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 39;
        i++;

        gamePanel.monster[mapNumber][i] = new MON_Bat(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 36;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 25;
        i++;

        gamePanel.monster[mapNumber][i] = new MON_Bat(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 39;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 26;
        i++;

        gamePanel.monster[mapNumber][i] = new MON_Bat(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 28;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 11;
        i++;

        gamePanel.monster[mapNumber][i] = new MON_Bat(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 10;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 19;
        i++;

        mapNumber = 3;
        i = 0;

        if (!Progress.skeletonLordDefeated) {
            gamePanel.monster[mapNumber][i] = new MON_SkeletonLord(gamePanel);
            gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 23;
            gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 16;
            i++;
        }

        mapNumber = 6;
        i = 0;
        
        gamePanel.monster[mapNumber][i] = new MON_Orc(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 25;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 20;
        i++;
        
        gamePanel.monster[mapNumber][i] = new MON_Bat(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 40;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 17;
        i++;
        
        gamePanel.monster[mapNumber][i] = new MON_Orc(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 36;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 28;
        i++;
        
        gamePanel.monster[mapNumber][i] = new MON_Orc(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 25;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 20;
        i++;
        
        gamePanel.monster[mapNumber][i] = new MON_Bat(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 18;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 31;
        i++;
        
        gamePanel.monster[mapNumber][i] = new MON_Bat(gamePanel);
        gamePanel.monster[mapNumber][i].worldX = gamePanel.tileSize * 21;
        gamePanel.monster[mapNumber][i].worldY = gamePanel.tileSize * 26;
        i++;
        
    }
    
    public void setInteractiveTile() {

        int mapNumber = 0;
        int i = 0;

        gamePanel.iTile[mapNumber][i] = new IT_DryTree(gamePanel, 21, 27); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DryTree(gamePanel, 21, 28); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DryTree(gamePanel, 21, 29); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DryTree(gamePanel, 21, 30); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DryTree(gamePanel, 21, 31); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DryTree(gamePanel, 21, 32); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DryTree(gamePanel, 21, 33); i++;

        mapNumber = 2;
        i = 0;

        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 18, 30); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 17, 31); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 17, 32); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 17, 34); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 18, 34); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 18, 33); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 10, 22); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 10, 24); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 38, 18); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 38, 19); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 38, 20); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 38, 21); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 18, 13); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 18, 14); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 22, 28); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 30, 28); i++;
        gamePanel.iTile[mapNumber][i] = new IT_DestructibleWall(gamePanel, 32, 28); i++;

        gamePanel.iTile[mapNumber][i] = new IT_MetalPlate(gamePanel, 20, 22); i++;
        gamePanel.iTile[mapNumber][i] = new IT_MetalPlate(gamePanel, 8, 17); i++;
        gamePanel.iTile[mapNumber][i] = new IT_MetalPlate(gamePanel, 39, 31); i++;

        
        // PERPUSTAKAAN
        mapNumber = 9;
        i = 0;

        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 23); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 24); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 25); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 26); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 27); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 28); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 29); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 19, 30); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 23); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 24); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 25); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 26); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 26); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 27); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 28); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 29); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairLeft(gamePanel, 29, 30); i++;

        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 23); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 24); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 25); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 26); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 26); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 27); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 28); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 29); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 20, 30); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 23); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 24); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 25); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 26); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 26); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 27); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 28); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 29); i++;
        gamePanel.iTile[mapNumber][i] = new IT_StairRight(gamePanel, 30, 30); i++;


    }
}
