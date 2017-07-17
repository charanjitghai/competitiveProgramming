"""
# author: k1e13
# problem: https://www.codechef.com/JULY17/problems/EXPTREE
# ref: http://www.cs.tau.ac.il/~nachumd/papers/Enumerations.pdf
"""
from fractions import gcd

m1 = 1000000007
m2 = 1000000009

t = int(raw_input())

while t>0:

	n = int(raw_input())
	n -= 1

	if n==0:
		print 0,0
		t-=1
		continue

	p = n*(n+1)
	q = 4*n-2

	g = gcd(p,q)

	p/=g
	q/=g

	a1 = pow(q,m1-2,m1)
	a2 = pow(q,m2-2,m2)

	print (p*a1)%m1, (p*a2)%m2

	t -=1