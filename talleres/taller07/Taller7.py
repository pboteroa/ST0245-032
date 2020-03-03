class Nodo():
    def __init__(self, obj=None, nxt = None):
        self.obj = obj
        self.nxt = nxt
        self.indx = indx

    def __str__(self):
        return "" + self.obj

class Lsimple():
    def __init__(self):
        self.first_Node = None
        self.size = 0
        
    def get(self, i):
        if i<0 or i>=size:
            raise Exception("Index Out of Bounds Exception")
        actual_Node= self.first_Node
        for j in range(i):
            actual_Node = actual_Node.nxt
        return actual_Node.obj
    
    def insertAtTheBeginning(self, i):
        temp = Nodo(i)
        temp.nxt = self.first_Node
        first_Node = temp
        self.size = self.size + 1

    def __void(self):
        return self.first_Node == None
    
    def get(self, i):
        temp = self.first_Node
        for j in range (1, j<=i):
            temp = self.

    def insertAtAnyPosition(self, element, position):
       if position==0:
           insertAtThebeginning(element)
       else: 
           temp = Nodo(element)
           temp.nxt = 

    def remove(self):
   
    def contains(self):
        if (size == 0):
         return false 
       else:
         elQueEstaEnEseMomento = self.first_Node
         while (elQueEstaEnEseMomento.nxt != None):
             if (element == elQueEstaEnEseMomento.obj):
                 return true
             elQueEstaEnEseMomento = elQueEstaEnEseMomento.nxt
         return false