package com.zkylab.object;

import com.zkylab.common.GamePanel;
import com.zkylab.entity.Entity;

public class OBJ_Shield_Wood extends Entity {

    public static final String objName = "Perisai";

    public OBJ_Shield_Wood(GamePanel gamePanel) {
        super(gamePanel);
        type = type_shield;
        name = objName;
        down1 = setup("/objects/shield_wood", gamePanel.tileSize, gamePanel.tileSize);
        defenseValue = 1;
        description = "[" + name + "]\nTerbuat dari besi.";
        price = 35;
    }

}