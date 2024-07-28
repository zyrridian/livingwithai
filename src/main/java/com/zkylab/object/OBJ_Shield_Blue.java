package com.zkylab.object;

import com.zkylab.common.GamePanel;
import com.zkylab.entity.Entity;

public class OBJ_Shield_Blue extends Entity {
    
    public static final String objName = "Perisai Super";

    public OBJ_Shield_Blue(GamePanel gamePanel) {
        super(gamePanel);
        type = type_shield;
        name = objName;
        down1 = setup("/objects/shield_blue", gamePanel.tileSize, gamePanel.tileSize);
        defenseValue = 100;
        description = "[" + name + "]\nPerisai Legendaris.";
        price = 400;
    }
    
}
