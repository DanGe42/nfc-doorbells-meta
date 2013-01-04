NfcDoorbell standard
====================

NFC tag format
--------------
The NFC tag will be NDEF-encoded with the messages in the below order:

### [0]
MIME type: application/org.danielge.doorbells
Payload: key-value store
    * ID=(unique string SHA1'd from Name, Location, user-chosen name for tag,
      random integer)
    * Location="Location name"

### [1]
URI
-> Google Play market URL

### [>1]
Any arbitrary data

Android <==> server handshake
----------------------------
(Authentication)

==> GET /tags/:id(.:format)
    Cookie: ...
<==
    { names: ["first last", "first last",...] }
    XML or JSON? Or both?

==> POST /ring/:id
    Body:
        msg="message"
    Cookie: ...

Google Cloud Messaging
----------------------

