t = int(raw_input())
for i in range(t):
	n,b = map(int, raw_input().split())
	x = n/(2*b)
	ans = 0
	for v in range(-1,2):
		y = x+v
		ans = max(ans, y*(n-y*b))
	print ans