def sortByHeight(a):
    people_only = []
    result = []
    people_count = 0
    for i in range(len(a)):
        if a[i] is not -1:
            people_only.append(a[i])            
    people_only.sort()
    for i in range(len(a)):
        if a[i] is -1:
            result.insert(i,a[i])
        else :
            result.insert(i,people_only[people_count])
            people_count += 1
    return result
