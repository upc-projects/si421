int adjacentElementsProduct(std::vector<int> inputArray) {
    int may = -1001 ;
    for(int i = 0 ; i<inputArray.size()-1 ; i++){
        may = std::max(may,(inputArray[i]*inputArray[i+1]));
    }
    return may;
}

