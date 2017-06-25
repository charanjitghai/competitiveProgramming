
n, f = map(int, raw_input().split())
sales = []
for i in range(n):
	k,l = map(int, raw_input().split())
	sales.append(min(2*k, l))

sales = sorted(sales)
print sum(sales[-f:])


