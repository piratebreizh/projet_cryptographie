package org.esgi.crypto.interfaces;

import java.io.File;

public interface ICipher {

	void encode (File message, File key, File encoded);
	void decode (File encoded, File key, File decoded);
	void generateKey (File key);
}
