package com.ascensive_software.utils;

import android.content.ContextWrapper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by edwin on 11/5/16.
 */

public class AssetReader {
    private static final String LOG_I_TAG = "ASSET_READER";

    public interface ReadLineCallBack {
        void onReadLine(String line);
    }

    public static void readTextAsset(
            ContextWrapper context,
            String assetFileName,
            ReadLineCallBack callBackInterface) {

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(assetFileName)));

            String line;
            while((line = reader.readLine()) != null) {
                callBackInterface.onReadLine(line);
            }
        } catch (IOException ex) {
            Log.i(LOG_I_TAG, "readTextAsset: asset:" + assetFileName + " not found");
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Log.i(LOG_I_TAG, "readTextAsset: reader.close() exception");
                }
            }
        }
    }
}
