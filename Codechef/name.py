def to_upper(c):
	if not is_upper(c):
		c = chr(ord(c) - ord('a') + ord('A'))
	return c
def to_lower(c):
	if not is_lower(c):
		c = chr(ord(c) - ord('A') + ord('a'))
	return c

def is_lower(c):
	return ord('a') <= ord(c) and ord(c) <= ord('z')

def is_upper(c):
	return ord('A') <= ord(c) and ord(c) <= ord('Z')


def last_namify(last_name):
	for j in range(len(last_name)):
		last_name[j] = to_lower(last_name[j])
	last_name[0] = to_upper(last_name[0])

def get_shortened_name(name):
	name_ = [name[0], '.']
	name_[0] = to_upper(name_[0])
	return name_

n = int(raw_input())
for i in range(n):
	s = raw_input().split()
	v = [list(a) for a in s]
	if len(v) == 1:
		last_name = v[0]
		last_namify(last_name)
		print "".join(last_name)
	else:
		last_name = v[-1]
		last_namify(last_name)

		for j in range(len(v)-1):
			print "".join(get_shortened_name(v[j])),

		print "".join(last_name)

