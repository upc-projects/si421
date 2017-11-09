int matrixElementsSum(std::vector<std::vector<int>> matrix) {
    int suma = 0 ;
    for(int i = 0 ; i<matrix.size();i++){
        for(int j = 0 ; j<matrix[i].size() ; j++){
            if(i==0) suma+= matrix[i][j];
            else{
                if(matrix[i-1][j] != 0 ) {suma+=matrix[i][j];}
                else matrix[i][j]=0;
            }
        }
    }
    
    return suma;
}

