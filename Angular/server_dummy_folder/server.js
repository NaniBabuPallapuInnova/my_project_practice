var express = require("express")
var cors = require('cors')
var app = express()

app.use(cors());

var bodyParser = require("body-parser");

app.use(bodyParser.urlencoded({ extended: false }));

app.use(bodyParser.json());
var HTTP_PORT = 8008

app.listen(HTTP_PORT, () => {
    console.log("Server running on port %PORT%".replace("%PORT%", HTTP_PORT))
});

app.get("/", (req, res, next) => {
    res.json({ "message": "Ok" })
});


app.post("/enroll", function(req, res) {
    
    console.log(req.body);
    res.status(200).send({"Message":"Data received"});
});

