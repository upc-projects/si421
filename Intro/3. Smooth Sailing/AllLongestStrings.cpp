std::vector<std::string> allLongestStrings(std::vector<std::string> inputArray) {
    std::vector<std::string> answ;
    int m=0;
    for(int i = 0 ; i < inputArray.size() ; i++){
        int sz = inputArray[i].length();
        m = max(m,sz);
    }
    for(int i = 0 ; i < inputArray.size() ; i++){
        if(inputArray[i].length() == m) answ.push_back(inputArray[i]);
    }
    return answ;
    
}

