class Lab1{
    public static void main(String[] arg){
        int[] h = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                12, 13, 14, 15, 16, 17, 18, 19};

        double[] x = new double[16];
        for (int i = 0; i < 16; i++){
            x[i] = Math.random() * 13.0000000000000001 - 10.0;  /*В итоге случайное
                                                                       число будет в
                                                                       диапазоне
                                                                       [-10.0, 3.00
                                                                       00000000000001)
                                                                       
                                                                       [-10;3]*/
        }

        double[][] m = new double[16][18];
        for (int j=0; j<16; j++){
            for (int i=0; i<18; i++){
                switch (h[i]){
                    case 8:
                        m[j][i] = (3/4 * Math.asin((x[j] - 3.5) / 13) - 3/4) / 0.25;
                        break;
                        
                        
                    case 6:
                    case 7:
                    case 10:
                    case 12:
                    case 13:
                    case 14:
                    case 16:
                    case 18:
                    case 19:
                        m[j][i] = Math.pow((2 * Math.tan(x[j] / (x[j] + 1))), Math.asin(1
                                / Math.pow(Math.exp(1.0), Math.abs(x[j]))));
                        break;
                    
                    
                    default:
                    	m[j][i] = Math.sin(Math.pow(Math.atan(Math.sin(x[j])) / 
                    	Math.cos(Math.pow(x[j], x[j]/2)) - 1, 3));
                }
            }
        }
        
        for (int j=0; j<16; j++){
        	for (int i=0; i<18; i++){
        	    m[j][i] *= 10000;
        	    int result = (int)Math.round(m[j][i]);
        	    double result2 = (double) result / 10000;
        	    System.out.print(result2 + "   ");
        	}
        	System.out.println();
    	}

    }
}