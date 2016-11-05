package com.ascensive_software.wstkd.core;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static android.content.ContentValues.TAG;

/**
 * Created by edwin on 10/28/16.
 */

public class Storage {

    private static final String saveFileName_ = "savedIdeas";

    private Context context_;
    public Storage(Context context) {
        context_ = context;
    }

    public void save(SavedData data) {
        try {
            FileOutputStream fs = context_.openFileOutput(saveFileName_, Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fs);
            out.writeObject(data);
            out.close();
            fs.close();

        } catch (FileNotFoundException ex) {
            Log.i(TAG, "load: FileNotFoundException");
        } catch (IOException ex) {
            Log.i(TAG, "load: IOException");
        }
    }

    public SavedData load() {
        try {
            FileInputStream fs = context_.openFileInput(saveFileName_);
            ObjectInputStream in = new ObjectInputStream(fs);
            SavedData data = (SavedData)in.readObject();
            in.close();
            fs.close();
            return data;

        } catch (FileNotFoundException ex) {
            Log.i(TAG, "load: FileNotFoundException");
            return null;
        } catch (IOException ex) {
            Log.i(TAG, "load: IOException");
            return null;
        } catch (ClassNotFoundException ex) {
            Log.i(TAG, "load: ClassNotFoundException");
            return null;
        }
    }
}
