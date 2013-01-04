Android sketch
==============

## Start

Open the main app *DoorbellFeedActivity*

Look for user credentials (maybe stored as HTTP session)
If no user credentials found, show *AuthDialog*

### AuthDialog(Fragment?)

LinearLayout

* Image (logo)
* Username (or email?) (EditText)
* Password (EditText)
* Sign in (Button)

Notes: If tag read, show Toast ("Please sign in first")
TODO: Registration from app

### DoorbellFeedActivity

LinearLayout

* ActionBar
    * Title (Doorbells)
    * NFC tag write button
* Doorbell list (ListView); each item contains...
    * First row
        * Sender's name
        * Date/time received
    * Second row
        * Message snippet OR (in gray) "<No message>"

## Tag reading

When we read the tag...

### From home screen

Open *SendRingActivity*

### From DoorbellFeedActivity

Open *SendRingActivity*

### SendRingActivity

LinearLayout

* ActionBar
    * Send (Button)
    * Cancel (Button)
* LinearLayout (android:orientation = horizontal)
    * Profile picture (ImageView)
    * Display name (TextView)
* Message (EditText), 140 characters max
* Characters left (TextView, flush right)

TODO: what does the Twitter app look like on Android?
