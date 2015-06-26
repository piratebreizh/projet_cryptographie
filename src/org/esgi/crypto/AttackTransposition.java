package org.esgi.crypto;

import attaques.TranspositionAttack;
import interfaces.IExecute;

import java.io.File;

public class AttackTransposition implements IExecute{
    @Override
    public void execute(File encoded, File key, File decoded) {
        File source = new File("source.txt");
        TranspositionAttack attack = new TranspositionAttack();
        attack.createFrequence(source);
        attack.launchAttack(encoded, decoded);
    }
}
