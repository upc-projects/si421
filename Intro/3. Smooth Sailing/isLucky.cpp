bool isLucky(int n) {
    int sum1=0, sum2=0, c=std::to_string(n).length();;
    int num = n;

    for (int i=0; i< c/2; i++){
    sum1+= num%10;
    num = num/10;
    }
    
    for (int i=0; i< c/2; i++){
    sum2+= num%10;
    num = num/10;
    }
    
    return (sum1 == sum2);
}
