package org.esgi.crypto.interfaces;

import java.io.File;

public interface IExecute {
    public void execute(File encoded, File key, File decoded);
}
