package spireMapOverhaul.zones.gremlinTown.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import spireMapOverhaul.abstracts.AbstractSMOCard;

import static spireMapOverhaul.SpireAnniversary6Mod.makeID;

public class Shield extends AbstractSMOCard {
    public final static String ID = makeID(Shield.class.getSimpleName());
    private final static int BLOCK = 11;
    private final static int UPG_BLOCK = 3;
    private final static int COST = 1;

    public Shield() {
        super(ID, COST, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF, CardColor.COLORLESS);

        baseBlock = BLOCK;
        exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
    }

    public void upp() {
        upgradeBlock(UPG_BLOCK);
    }
}
