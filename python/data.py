import requests


datav_api = {
        "front": 'https://geo.datav.aliyun.com//areas_v3/bound/',
        "adcode": '100000',
        "back": '_full.json'
      }

print(datav_api["front"]+datav_api["adcode"]+datav_api["back"])

res = requests.get(datav_api["front"]+datav_api["adcode"]+datav_api["back"])

if(res.status_code == 200):
	print(res.text)
elif(res.status_code == 404):
	print("404 NOT FOUND")
else:
	print("NET ERROR" + res.status_code)