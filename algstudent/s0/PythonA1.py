from time import time
from PythonA1v1 import listadoPrimos

if __name__ == '__main__':
    n = 10000
    for casos in range(7):
        t1 = time()
        primes = listadoPrimos(n)
        t2 = time()
        print("n =", n, "***", "time =", int(1000*(t2-t1)), "milliseconds)")
        #print(primes)
        n = n*2

