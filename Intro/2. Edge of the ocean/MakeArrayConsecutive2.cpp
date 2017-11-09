int makeArrayConsecutive2(std::vector<int> statues) {
    int con = 0;
    std::sort(statues.begin(),statues.end());
    for(int i = 0 ; i<statues.size()-1;i++){
        if(statues[i+1] != statues[i]+1) { con +=  ( (statues[i+1] - statues[i] ) -1 ); }
    }
    return con;
}

