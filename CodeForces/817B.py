nt(raw_input())
a = sorted(map(int, raw_input().split()))

if a[0] == a[1] and a[1] == a[2]:
    c = 0
    for v in a:
        if v == a[0]:
            c += 1
        else:
            break
    print c*(c-1)*(c-2)/6

elif a[0] == a[1] and a[1] != a[2]:
    c = 0
    for v in a[2:]:
        if v == a[2]:
            c += 1
        else:
            break
    print c

elif a[1] == a[2]:
    c = 0
    for v in a[1:]:
        if v == a[1]:
            c += 1
        else:
            break
    print c*(c-1)/2

else:
    c = 0
    for v in a[2:]:
        if v == a[2]:
            c += 1
        else:
            break
    print c
