package com.army_builder.systems;

import com.army_builder.models.Cavalry;
import com.army_builder.models.Infantry;
import com.army_builder.models.Ranged;
import com.army_builder.models.Units;

public class battle {


    public void unit2unitAttack(Units attacker, Units defender) {

        // Gets damage and defense per model values from passed methods
        double attackerDamage = attacker.calculateAttack();
        double defenderValue = defender.calculateDefense();

        // starter values dont mean anything for now
        double attackerUnitModifier = 0, defednderUnitModifier = 0;
        double movementModifier = 0;

        // primary overall attack and defense based on modifier values formulas
        double primaryAttack = attackerDamage + (attackerDamage * attackerUnitModifier) + (attackerDamage * movementModifier);
        double primaryDefense = defenderValue + (defenderValue * defednderUnitModifier);

        // total overall pool
        // Critical success is based on proportion of attack overhwelming the defense
        double totalPool = primaryDefense + primaryAttack;
        double attackPortion = primaryAttack / totalPool;
        double initialAttackValue = (attackerDamage + defenderValue) - defenderValue;

        // chance of events in event of positive score for attackers
        // will program different logic for succesful defense
        double takeLossMultiplier = 0;
        if (attackPortion < .20) {
            takeLossMultiplier = .50;
            defender.removeModels((int) (takeLossMultiplier * initialAttackValue));
        }else if(attackPortion < .40){
            defender.removeModels((int) (takeLossMultiplier * initialAttackValue));
        }else if(attackPortion < .60){
            defender.removeModels((int) (takeLossMultiplier * initialAttackValue));
        }else if(attackPortion < .80){
            defender.removeModels((int) (takeLossMultiplier * initialAttackValue));
        }
    }


    public void unitWeaknessModifier(Units attacker, Units defender){

        if((attacker.getClass() == Cavalry.class) && (defender.getClass() == Infantry.class)){

        } else if((attacker.getClass() == Cavalry.class) && (defender.getClass() == Infantry.class)){

        }

}