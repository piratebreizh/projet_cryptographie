package org.esgi.crypto;

import org.esgi.crypto.attaques.TranspositionAttack;
import org.esgi.crypto.interfaces.IExecute;

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
