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
        self.resetAPI()


        # TODO: 将数据保存在本地json，将json添加至.gitignore
        connection = pymysql.connect(host='',
                             user='',
                             password='',
                             database='')
        
        with connection:
            with connection.cursor() as cursor:
                sql = "INSERT INTO `users` (`email`, `password`) VALUES (%s, %s)"
                cursor.execute(sql, ('webmaster@python.org', 'very-secret'))
            

        print("Will send request to ", self.api)
        region = self.req()
        print(region)

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

districts = getRegion()