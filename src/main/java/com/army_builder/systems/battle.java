package com.army_builder.systems;

import com.army_builder.models.*;

public class battle {


    public void unit2unitAttack(Units attacker, Units defender) {

        System.out.println("Attacker Stats Before");
        System.out.println(attacker.toString());
        System.out.println("Defender Stats Before");
        System.out.println(defender.toString());

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
        // Critical success is based on proportion of attack overwhelming the defense
        double totalPool = primaryDefense + primaryAttack;
        double attackPortion = primaryAttack / totalPool;
        double initialAttackValue = totalPool - defenderValue;

        defender.removeModels((int) initialAttackValue);




        // ### Removing for now, not taking loss modifiers by proportion, instead model lose will be based on initial attack value
        // chance of events in event of positive score for attackers
        // will program different logic for successful defense
        //
//        double takeLossMultiplier = 1;
//        if (attackPortion < .20) {
//            takeLossMultiplier = .50;
//            defender.removeModels((int) (takeLossMultiplier * initialAttackValue));
//        }else if(attackPortion < .40){
//            defender.removeModels((int) (takeLossMultiplier * initialAttackValue));
//        }else if(attackPortion < .60){
//            defender.removeModels((int) (takeLossMultiplier * initialAttackValue));
//        }else if(attackPortion < .80){
//            defender.removeModels((int) (takeLossMultiplier * initialAttackValue));
//        }

        System.out.println("Attacker Stats After");
        System.out.println(attacker.toString());
        System.out.println("Defender Stats After");
        System.out.println(defender.toString());
    }


//    public void unitWeaknessModifier(Units attacker, Units defender){
//
//        if((attacker.getClass() == Cavalry.class) && (defender.getClass() == Infantry.class)){
//
//        } else if((attacker.getClass() == Cavalry.class) && (defender.getClass() == Infantry.class)){
//
//        }

}