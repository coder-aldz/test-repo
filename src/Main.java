public class Main {

    public static void main(String [] args){

        int [][] myArray = {{1,1,1},{1,1,1},{1,1,1}}; //00 + 11 + 22 | 02 + 11 + 20
        isMgcSqr(myArray);
    }

    public static void isMgcSqr(int[][] theArray){

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

        if(diagonal_1!=initialSum || diagonal_2!=initialSum){
            System.out.println("Sorry, not a Magic Square");
            notMagic=true;
        }

        if(!notMagic){
            System.out.println("Great! It is a Magic Square");
        }
    }
}
