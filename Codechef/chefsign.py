n = int(raw_input())
for i in range(n):
	s = list(raw_input())
	max_small = 0
	cur_small = 0
	max_big = 0
	cur_big = 0
	for o in s:
		if o == '<':
			max_big = max(max_big, cur_big)
			cur_big = 0
			cur_small += 1
		elif o == '>':
			max_small = max(max_small, cur_small)
			cur_small = 0
			cur_big += 1
	max_big = max(max_big, cur_big)
	max_small = max(max_small, cur_small)
	print max(max_big, max_small) + 1