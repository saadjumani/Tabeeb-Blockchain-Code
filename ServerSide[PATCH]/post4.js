var request = require('request');
var express = require('express');
var app = express();

// Set the headers
var headers = {
    'User-Agent':       'Super Agent/0.0.1',
    'Content-Type':     'application/x-www-form-urlencoded'
}

// Configure the request

app.get("/api/:p1/:p2" , function(req,res){

    console.log("invoice connected");
    //res.send("You entered : " + req.params.id );
//    var data = req.params.id;
   
    var options = {
    url: 'http://localhost:3000/api/Invoice',
    method: 'POST',
    headers: headers,
    form:  {
  "$class": "org.acme.biznet.Invoice",
  "presc_id": req.params.p1,
  "Ammount": req.params.p2
}}

// Start the request
request(options, function (error, response, body) {
    if (!error && response.statusCode == 200) {
        // Print out the response body
        console.log(body)
    }
})
   
});
app.listen(3004);

//});

