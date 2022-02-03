package com.sandburg.aicandover2.view.scene5;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;

public class MediaScanner {
    private Context ctxt;
    private String file_Path;
    private MediaScannerConnection mMediaScanner;
    private MediaScannerConnection.MediaScannerConnectionClient mMediaScannerClient;

    public static MediaScanner newInstance(Context context)
    {
        return new MediaScanner (context);
    }

    private MediaScanner (Context context) {

        ctxt = context;

    }

    public void mediaScanning(final String path, int flag) {
        if (mMediaScanner == null) {
            mMediaScannerClient = new MediaScannerConnection.MediaScannerConnectionClient() {
                @Override public void onMediaScannerConnected() {
                    mMediaScanner.scanFile(file_Path, null);
                }

                @Override public void onScanCompleted(String path, Uri uri) {
                    System.out.println("::::MediaScan Success::::");

                    mMediaScanner.disconnect();
                }
            };

            mMediaScanner = new MediaScannerConnection(ctxt, mMediaScannerClient);
        }

        file_Path = path;

        mMediaScanner.connect();

        if(flag == 1){
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            Uri screenshotUri = Uri.parse(file_Path);	// android image path

            sharingIntent.setType("image/jpg");
            sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
            ctxt.startActivity(Intent.createChooser(sharingIntent, "Share image using").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)); //
        }
    }
}

