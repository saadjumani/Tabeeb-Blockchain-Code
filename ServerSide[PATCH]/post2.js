var request = require('request');
var express = require('express');
var app = express();

// Set the headers
var headers = {
    'User-Agent':       'Super Agent/0.0.1',
    'Content-Type':     'application/x-www-form-urlencoded'
}

// Configure the request

app.get("/api/:p1/:p2/:p3" , function(req,res){

    console.log("doctor connected ");
    //res.send("You entered : " + req.params.id );
//    var data = req.params.id;
   
    var options = {
    url: 'http://localhost:3000/api/Doctor',
    method: 'POST',
    headers: headers,
    form:  {
  "$class": "org.acme.biznet.Doctor",
  "doctor_id": req.params.p1,
  "name": req.params.p2,
  "organization": req.params.p3
}}

// Start the request
request(options, function (error, response, body) {
    if (!error && response.statusCode == 200) {
        // Print out the response body
        console.log(body)
    }
})
   
});

app.listen(3002);
