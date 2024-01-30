package spireMapOverhaul.zones.mycelium;

import com.badlogic.gdx.graphics.Color;
import spireMapOverhaul.SpireAnniversary6Mod;
import spireMapOverhaul.abstracts.AbstractZone;
import spireMapOverhaul.zoneInterfaces.EncounterModifyingZone;

public class Mycelium extends AbstractZone implements EncounterModifyingZone {
    public static final String ID = "Mycelium";
    private static final String MUTATED_WHALESPAWN = SpireAnniversary6Mod.makeID("SUNSTONE_ELITE");
    
    public Mycelium() {
        super(ID, Icons.MONSTER, Icons.EVENT);
        this.width = 2;
        this.height = 4;
    }
    
    @Override
    public AbstractZone copy() {
        return new Mycelium();
    }
    
    @Override
    public Color getColor() {
        return new Color(0.043f, 0.855f, 0.522f, 1f);
    }
    
    @Override
    public boolean canSpawn() {
        return isAct(1);
    }
    
    protected boolean canIncludeEarlyRows() {
        return false;
    }
}