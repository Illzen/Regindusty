import pymysql
import requests
import json

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

    def setDATAv(self, url, adcode, exname):
        self.datav_api["front"] = url
        self.datav_api["adcode"] = adcode
        self.datav_api["back"] = exname
        self.resetAPI

    def setADcode(self,adcode):
        self.datav_api["adcode"] = adcode
        self.resetAPI()

    def resetAPI(self):
        self.api = self.datav_api["front"] + \
            str(self.datav_api["adcode"]) + self.datav_api["back"]

    def req(self):

        with requests.get(self.api) as res:
            return json.loads(res.text)
            

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
path = "D:\\Projects\\基于知识图谱的乡村产业振兴信息平台开发与应用\\regindusty\\sql\\server.json"
with open(path) as file:
    server = json.load(file)
    connection = pymysql.connect(host=server["url"],
                         user=server["user"],
                         password=server["password"],
                         database=server["database"]["name"])
    with connection:
        with connection.cursor() as cursor:

            region = getRegion()
            region.setADcode("350000")
            res = region.req()

            for city in res["features"]:

                region.setADcode(city["properties"]["adcode"])
                districts = region.req()

                for country in districts["features"]:
                    cursor.execute("INSERT INTO districts(adcode,name) VALUES (%s,%s);",
                                    (country["properties"]["adcode"],
                                    country["properties"]["name"]))
                    try:
                        connection.commit()
                    except:
                        connection.rollback()


            
                    
            

# districts = getRegion()