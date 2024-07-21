package com.zkylab.object;

import com.zkylab.common.GamePanel;
import com.zkylab.entity.Entity;

public class OBJ_Lantern extends Entity {
    
    public static final String objName = "Lantern";

    public OBJ_Lantern(GamePanel gamePanel) {
        super(gamePanel);
        
        type = type_light;
        name = objName;
        down1 = setup("/objects/lantern", gamePanel.tileSize, gamePanel.tileSize);
        description = "[Lantern]\nIlluminate your\nsurroundings.";
        price = 200;
        lightRadius = 300;
    }
    
}
