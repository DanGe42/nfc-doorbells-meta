Server sketch
=============

Styling: likely Twitter Bootstrap

## Home page

Top bar:
- (email) (password) |Log in|

Two columns:
* left column
    * Row 1: Doorbells (i.e. product name)
    * Row 2: Cheesy motto
* right column
    * Image of an Android phone with app open, sending message, below tag

Sign up button

Blurbs (optional marketing; add once mature past STWing Labs)
* How it works (uses NFC)

Footer: Built by Daniel Ge (+ other devs)
A loving part of STWing Labs

## Log in/Sign up pages

Should be straightforward

## App home page: /messages

Top bar:
* |Log out|

Side bar:
* Messages (/messages)
* Tags (/tags)

## API

### GET /tags/:id.json

(with the cookie, for now)

Response (JSON):
{
    location: "Location",
    name: "John Doe",
    picture: "http://gravatar.com/...",
    csrf: "something really long"
}

### POST /bell/:id?csrf=:token

(with the cookie, again)

Body:
    msg="message"
