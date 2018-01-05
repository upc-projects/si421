def addBorder(picture):
    for i in range(len(picture)) :
        picture[i] = '*'+picture[i]+'*'
    
    a = ''
    for i in range(len(picture[0])):
        a += '*'
    
    picture.insert(len(picture),a)
    picture.insert(0,a)
    
    return picture