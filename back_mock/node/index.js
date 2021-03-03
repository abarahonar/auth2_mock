var https = require('https');
// Necesario para conexiones no seguras
process.env.NODE_TLS_REJECT_UNAUTHORIZED = '0';

idToken = process.argv[2];

var options = {
  host: 'back.catteam.tk',
  path: '/authorize',
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  }
};

callback = function(response) {
  var str = '';
  response.on('data', function (chunk) {
    str += chunk;
  });
  response.on('end', function () {
    console.log(str);
  });
}

const req = https.request(options, callback);
req.write(JSON.stringify({idToken}));
req.end();
