package spireMapOverhaul.zones.gremlinTown.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import spireMapOverhaul.abstracts.AbstractSMOCard;

import java.util.ArrayList;

import static spireMapOverhaul.SpireAnniversary6Mod.makeID;
import static spireMapOverhaul.util.Wiz.*;

public class AngryStrike extends AbstractSMOCard {
    public final static String ID = makeID(AngryStrike.class.getSimpleName());
    private final static int DAMAGE = 6;
    private final static int UPG_DAMAGE = 2;
    private final static int COST = 0;

    public AngryStrike() {
        super(ID, COST, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY, CardColor.COLORLESS);

        baseDamage = DAMAGE;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_DIAGONAL);
        atb(new AbstractGameAction() {
            @Override
            public void update() {
                isDone = true;
                ArrayList<AbstractCard> cards = new ArrayList<>();
                for (AbstractCard c : adp().hand.group)
                    if (c.type != CardType.ATTACK)
                        cards.add(c);

                if (cards.isEmpty())
                    return;

                int x = AbstractDungeon.cardRandomRng.random(cards.size() - 1);
                att(new ExhaustSpecificCardAction(cards.get(x), adp().hand));
            }
        });
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}
