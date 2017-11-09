int shapeArea(int n) {
    if(n == 1) return 1;
    int sum = 0 ,  band = (n*2)-1;
    while(band > 2 ){
        sum += ( ( (n*2)-band ) *2 );
        band -=2;
    }
    
    sum += n*2 -1 ;
    
    return sum;

}

