import pprint
table = {}

def insertCompany2(companyName, companyCountry, hashTable):
    hashTable[companyName] = companyCountry

def deleteCompany2(companyName, hashTable):
    del hashTable[companyName]
    
def searchCompany2(companyName, hashTable):
    try:
        print(hashTable[companyName])
    except:
        print("The name of the company isn't in the Hash Table")

def insertCompany(companyName, companyCountry):
    insertCompany2(companyName, companyCountry, table)

def deleteCompany(companyName):
    deleteCompany2(companyName, table)

def searchCompany(companyName):
    searchCompany2(companyName, table)

insertCompany("Google", "United States")
insertCompany("La Locura", "Colombia") 
insertCompany("Nokia", "Finland")
insertCompany("Sony", "Japan")   
pprint.pprint(table)   