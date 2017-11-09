bool checkPalindrome(std::string inputString) {
    
    std::string copyString (inputString);
    std::reverse(copyString.begin(), copyString.end());
    
    if(copyString == inputString) return true;
    else return false;
    
}

