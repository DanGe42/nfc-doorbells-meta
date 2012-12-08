package org.danielge.doorbells;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.os.Bundle;
import org.danielge.nfcskeleton.NdefReaderActivity;

import java.nio.charset.Charset;

public class DoorbellsActivity extends NdefReaderActivity
{
    public static final String TAG = DoorbellsActivity.class.getSimpleName();

    public static final  String  MIME    = "application/org.danielge.doorbells";
    private static final Charset charset = Charset.forName("US-ASCII");


    private String tagId = null;
    private String tagLocation = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onNdefMessage(NdefMessage ndefMessage) {
        NdefRecord[] records = ndefMessage.getRecords();
        NdefRecord contents = records[0];

        // NdefRecord playURLRecord = records[1];

        readFromTag(contents);
    }

    private boolean readFromTag(NdefRecord record) {
        // sanity check
        if (record.getTnf() != NdefRecord.TNF_MIME_MEDIA
                || !MIME.equals(new String(record.getType(), charset))) {
            return false;
        }

        String payload = new String(record.getPayload(), charset);

        String id = null;
        String location = null;
        for (String entry : payload.split("\n")) {
            // read key-value pairs

            // Minimum length of a key-value pair is 2 ("x=")
            if (entry == null || entry.length() <= 2) {
                continue;
            }

            String[] keyValue = entry.split("=");
            if (keyValue.length != 2) {
                // unset key or improperly formatted key-value pair
                continue;
            }

            if (keyValue[0].equals("id")) {
                id = keyValue[1];
            } else if (keyValue[1].equals("loc")) {
                location = keyValue[1];
            }
        }

        if (id != null && location != null) {
            this.tagId       = id;
            this.tagLocation = location;

            return true;
        } else {
            return false;
        }
    }
}
