import urllib.request
import json
import sys
from pprint import pprint
# Necesario para conexiones no seguras
import ssl


url = "https://back.catteam.tk/authorize"
values = {
    "idToken": sys.argv[1]
}

headers = {
    "Content-Type": "application/json"
}

data = json.dumps(values).encode("utf-8")

# Necesario para conexiones no seguras
context = ssl._create_unverified_context()

try:
    req = urllib.request.Request(url, data, headers)
    with urllib.request.urlopen(req, context=context) as f:
        res = f.read()
    pprint(res.decode())
except Exception as e:
    pprint(e)