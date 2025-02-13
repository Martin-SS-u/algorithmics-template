from time import time

def loop4 (n):
    """ time complexity  O(n**3)"""
    cont=0
    for i in range (1,n+1,1):
        for j in range (1,i+1,1):
            for k in range(1,j+1,1):
                cont=cont+1
    return cont



def main():
    print ("TIME (milliseconds)")
    t1=0
    t2=0
    n=100
    cont=0
    for i in range (10):
        t1=time()
        c=loop4(n)
        t2=time()
        print("n= ",n,"**time=",int(1000*(t2-t1)),"**counter=",c)
        n=n*2


main()