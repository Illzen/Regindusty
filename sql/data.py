import pymysql
import requests
import json
import os

class getRegion:

    datav_api = {
        
        "front": "",
        "adcode": "",
        "back": ""
        
    }

    api = ""

    region = []
    
    def __init__(self):

        self.setDATAv("https://geo.datav.aliyun.com/areas_v3/bound/",
                      "100000", "_full.json")
        self.resetAPI()

    def setDATAv(self, url, adcode, exname):
        self.datav_api["front"] = url
        self.datav_api["adcode"] = adcode
        self.datav_api["back"] = exname

    def resetAPI(self):
        self.api = self.datav_api["front"] + \
            self.datav_api["adcode"] + self.datav_api["back"]

    def req(self):

        with requests.get(self.api) as res:
            res = json.loads(res.text)
            return res

######################################
#存储数据库相关信息的json文件
#{
#   "url":
#   "port":
#   "user":
#   "password":
#   "database":
# }
######################################
path = "D:\\Projects\\基于知识图谱的乡村产业振兴信息平台开发与应用\\sql\\server.json"
with open(path) as file:
    server = json.load(file)
    connection = pymysql.connect(host=server["url"],
                         user=server["user"],
                         password=server["password"],
                         database=server["database"])
    with connection:
        with connection.cursor() as cursor:
            res = getRegion().req

# districts = getRegion()