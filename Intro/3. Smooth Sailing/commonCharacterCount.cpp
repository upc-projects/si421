int commonCharacterCount(std::string s1, std::string s2) {
    int c = 0;
    for(int i = 0 ; i < std::min(s1.length(),s2.length()) ; i++){
      for(int j = 0 ; j < std::max(s1.length(),s2.length()) ; j++){
          if(s1[i]==s2[j]){
              c++;
              s2[j]='@';
              break;
          }
      }
    }
    return c;
}

