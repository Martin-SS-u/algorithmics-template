from time import time

def primoA3(m):
    """ returns whether m is prime or not """
    for i in range (2,m//2+1):
        if m%i==0:
            return False
    return True

def listadoPrimos(n):
    """ calculates and returns all primes up to n """
    primes = []
    for i in range (2, n+1):
        if primoA3(i):
            primes.append(i)
    return primes

if __name__ == '__main__':
    n = 10
    for casos in range(7):
        t1 = time()
        primes = listadoPrimos(n)
        t2 = time()
        print("n =", n, "***", "time =", int(1000*(t2-t1)), "milliseconds)")
        #print(primes)
        n = n*2