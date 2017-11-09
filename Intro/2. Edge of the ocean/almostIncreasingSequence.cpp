bool almostIncreasingSequence(std::vector<int> sequence) {
    int c = 0;
    int pos = 1;
    
      for(int i = 1 ; i<sequence.size() ; i++){
          if(sequence[i-1] >= sequence[i]){
              c++;
              pos=i;
          }
          
          if(c>1) return false;
        
      }
    
    if(c==0) return true;
    
    if(pos==1 || pos == sequence.size() -1 ) return true;
    else if(sequence[pos-1] < sequence[pos+1] || sequence[pos-2]<sequence[pos]) return true;
    
    return false;
}

