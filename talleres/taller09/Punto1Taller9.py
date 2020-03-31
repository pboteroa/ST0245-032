class HashTable():
    
    def __init__(self):
       self.tabla = [0]*10
       
    # hash_function
    def funcion_hash(self, k):
       return int(k[0]) % 10
       
    def get(self, k):
       return self.tabla[funcion_hash(k)]
       
    def put(self, k, v): 
       self.tabla[funcion_hash(k)] = v