from time import time
from PythonA1v0 import primoA1

def listadoPrimos(n):
    """ calculates and returns all primes up to n """
    primes = []
    for i in range (2, n+1):
        if primoA1(i):
            primes.append(i)
    return primes

if __name__ == '__main__':
    n = 10000
    t1 = time()  
    primes = listadoPrimos(n)
    t2 = time()
    print("n =", n, "***", "time =", int(1000*(t2-t1)), "milliseconds)")
    print(primes)