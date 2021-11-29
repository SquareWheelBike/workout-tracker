package src;

import java.awt.*;


public class FormatGUI {

    public FormatGUI(){
    }

    public GridBagConstraints setGrid(GridBagConstraints c, int gridX, int gridY, int ipady){
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = ipady;
        c.gridx = gridX;
        c.gridy = gridY;
        return c;
    }

    public GridBagConstraints setGrid(GridBagConstraints c, int gridX, int gridY){
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = gridX;
        c.gridy = gridY;
        return c;
    }
}
