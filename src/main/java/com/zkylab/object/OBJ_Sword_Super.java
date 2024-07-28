package com.zkylab.object;

import com.zkylab.common.GamePanel;
import com.zkylab.entity.Entity;

public class OBJ_Sword_Super extends Entity {
    
    public static final String objName = "Pedang super";

    public OBJ_Sword_Super(GamePanel gamePanel) {
        super(gamePanel);
        type = type_sword;
        name = objName;
        down1 = setup("/objects/sword_super", gamePanel.tileSize, gamePanel.tileSize);
        attackValue = 7;
        attackArea.width = 36;
        attackArea.height = 36;
        description = "[" + name + "]\nPedang legendaris.";
        price = 400;
        knockBackPower = 2;
        motion1_duration = 5;
        motion2_duration = 25;
    }

}