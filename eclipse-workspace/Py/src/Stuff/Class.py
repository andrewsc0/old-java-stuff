'''
Created on May 16, 2018

@author: Chris
'''

class MyClass(object):
    '''
    classdocs
    '''


    def __init__(self, k, m):
        '''
        Constructor
        '''
        self.k = k
        self.m = m
        self.printStuff(k, m)
    
    def printStuff(self, k, m):
        self.k = k
        self.m = m
        print(self.k , self.m)
        
    def average(self, list):
        
        sum = sum(list)
        av = sum / list.__sizeof__()
        print(av)
        print()
       