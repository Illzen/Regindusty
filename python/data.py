import requests

res = requests.get("http://shop.bytravel.cn/produce/top10/index971.html")
# 写正则 匹配 <meta charset= i /> 获取编码i，再通过i重新请求


if(res.status_code == 200):
	print(res.text)
elif(res.status_code == 404):
	print("404 NOT FOUND")
else:
	print("NET ERROR" + res.status_code)