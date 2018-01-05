def alternatingSums(a):
    f = s = 0
    for item in range(len(a)):
        if  item % 2 == 0: 
            f += a[item]
        else:
            s += a[item]
    
    return [f,s]