public class Main {

    public static void main(String [] args){

        int [][] myArray = {{1,1,1},{1,1,1},{1,1,1}};

        isMgcSqr(myArray);
    }

    public static void isMgcSqr(int[][] theArray){

        if (isPrfctSqr(theArray)) {
            int diagonal_1, diagonal_2;
            diagonal_1 = diagonal_2 = 0;

            int initialSum = 0;

            boolean notMagic = false;

            for(int i=0 ; i < theArray.length ; i++){
                initialSum += theArray[0][i];
            }

            for(int row = 0 ; row < theArray.length ; row++){

                int rowTotal, colTotal;
                rowTotal = colTotal = 0;

                for(int col = 0 ; col < theArray.length ; col++){
                    rowTotal += theArray[row][col];
                    colTotal += theArray[col][row];
                }
                diagonal_1 += theArray[row][row];
                diagonal_2 += theArray[row][theArray.length-1-row];

                if(rowTotal!=initialSum || colTotal!=initialSum){
                    System.out.println("Sorry, not a Magic Square");
                    notMagic=true;
                    break;
                }
            }

            if(!notMagic && (diagonal_1!=initialSum || diagonal_2!=initialSum)){
                System.out.println("Sorry, not a Magic Square");
                notMagic=true;
            }

            if(!notMagic){
                System.out.println("Great! It is a Magic Square");
            }
        }else{System.out.println("Sorry, but the array you provided is not a square.");}
    }

    public static boolean isPrfctSqr(int[][] theArray){

        int size2D = theArray.length;
        int size1D = theArray[0].length;

        return size1D==size2D;
    }
}
