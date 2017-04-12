def subsetSumTabAllPositives(arr, target):
	ans = []
	for idx in range(len(arr)):
		ans.append([False for sum in range(target+1)])
		
	for idx in range(len(arr)):
		ans[idx][0] = True
	
	if arr[0] <= target:
		ans[0][arr[0]] = True
	
	for idx in range(1,len(arr)):
		for sum in range(1, target+1):
			possibleOnExcluding = ans[idx-1][sum]
			possibleOnIncluding = False
			if not ans[idx][sum]:
				if sum-arr[idx] >= 0:
					possibleOnIncluding = ans[idx-1][sum-arr[idx]]
			
			ans[idx][sum] = possibleOnExcluding or possibleOnIncluding
			
	
	return ans[len(arr)-1][target]
	


def subsetSumTab(arr, target):
	minNegativeSum = sum(filter(lambda x: x<0, arr))
	if target < minNegativeSum:
		return False
	
	maxPositiveSum = sum(filter(lambda x: x>0, arr))
	if target > maxPositiveSum:
		return False
	
	
	ans = []
	for idx in range(len(arr)):
		ans.append([False for sum_val in range(minNegativeSum, maxPositiveSum + 1)])
	
	
	shift = abs(minNegativeSum)
	for idx in range(len(arr)):
		ans[idx][shift] = True
		
	ans[0][arr[0] + shift] = True
	
	
	for idx in range(1,len(arr)):
		for sum_val in range(minNegativeSum, maxPositiveSum + 1):
			shifted_sum = sum_val + shift
			possibleOnExcluding = ans[idx-1][shifted_sum]
			
			possibleOnIncluding = False
			req_sum = sum_val - arr[idx]
			if req_sum >= minNegativeSum and req_sum <= maxPositiveSum:
				shifted_req_sum = req_sum + shift
				possibleOnIncluding = ans[idx-1][shifted_req_sum]
				
			ans[idx][shifted_sum] = possibleOnExcluding or possibleOnIncluding
	

	for v in ans:
		print v
	return ans[len(ans)-1][target + shift]
			
	
	
	
arr = map(int, raw_input().split())
target = int(raw_input())

print subsetSumTab(arr, target)
	
	
	
	
	
	
	
	
	