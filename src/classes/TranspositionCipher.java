package classes;

import interfaces.ICipher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class TranspositionCipher implements ICipher {
    private ArrayList<Byte> keyList;

    @Override
    public void encode(File message, File key, File encoded) {
        readKey(key);
        try {
            FileReader reader = new FileReader(message);
            FileWriter writer = new FileWriter(encoded);
            StringBuilder block = new StringBuilder();
            //Lecture
            int intChar;
            while ((intChar = reader.read()) != -1) {
                if (block.length() == keyList.size()) {
                    writer.write(getEncodedBlock(block.toString()));
                    block.delete(0, block.length());
                }
                block.append((char) intChar);
            }
            //Cas où le dernier block n'est pas plein
            if (block.length() > 0) {
                while (block.length() != keyList.size()) {
                    block.append(' ');
                }
                writer.write(getEncodedBlock(block.toString()));
            }
            reader.close();
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void decode(File encoded, File key, File decoded) {
        readKey(key);
        try {
            //Encoded
            FileReader reader = new FileReader(encoded);
            //decoded
            FileWriter writer = new FileWriter(decoded);
            //Lecture
            int intChar;
            StringBuilder block = new StringBuilder();

            while ((intChar = reader.read()) != -1) {
                if (block.length() == keyList.size()) {
                    String decodedBlock = getDecodedBlock(block.toString());
                    writer.write(decodedBlock);
                    block.delete(0, block.length());
                }
                block.append((char) intChar);
            }
            if(block.length() != 0){
                String decodedBlock = getDecodedBlock(block.toString());
                writer.write(decodedBlock);
            }
            reader.close();
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getEncodedBlock(String block) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < keyList.size(); i++) {
            if(keyList.get(i) < keyList.size())
                builder.append(block.charAt(keyList.get(i)));
        }

        return builder.toString();
    }

    private String getDecodedBlock(String codedString) {
        StringBuilder builder = new StringBuilder();
        for(int i=0 ; i<keyList.size() ; i++){
            if(keyList.get(i) < keyList.size()) {
                int index = keyList.indexOf(i);
                builder.append(codedString.charAt(index));
            }
        }

        return builder.toString();
    }

    @Override
    
    public void generateKey(File key) {
    }

    private void readKey(File key) {
    	keyList = new ArrayList<Byte>();
		InputStream is = null;
		try{
			// new input stream created
			is = new FileInputStream(key);

			byte currentByte;
			
			for(byte i = 0; i<key.length();i++){
				currentByte = (byte) is.read();
				keyList.add(currentByte);
			}
			
			if(is!=null)
				is.close();

		}catch(Exception e){
			e.printStackTrace();
		}
    	
    }


}
