def subsetSum(a, idx, target, d):
	if target in d:
		return d[target]
	
	if idx == len(a):
		return None
	
	possibleOnIncluding = subsetSum(a, idx+1, target - a[idx], d)
	if possibleOnIncluding is not None:
		d[target] = [a[idx]]
		for v in possibleOnIncluding:
			d[target].append(v)
		return d[target]
	
	possibleOnExcluding = subsetSum(a, idx+1, target, d)
	d[target] = possibleOnExcluding
	return d[target]
	
	
	
a = map(int, raw_input().split())
target = int(raw_input())
d = {0:[]}
print subsetSum(a, 0, target, d)