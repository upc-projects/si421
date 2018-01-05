def arrayChange(inputArray):
    i = 1
    sum = 0
    while i < len(inputArray):
        if inputArray[i] <= inputArray[i-1]:
            sum += (inputArray[i-1] - inputArray[i]) + 1
            inputArray[i] += (inputArray[i-1] - inputArray[i]) + 1 
        i += 1
    return sum