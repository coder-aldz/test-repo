public class Main {

    public static void main(String [] args){

        int [][] myAray = {{1,1,1},{1,1,1},{1,1,1}}; //00 + 11 + 22 | 02 + 11 + 20
        isMgcSqr2(myAray);
    }

    public static void isMgcSqr2(int[][] theArray){
        int[] rowTotal = new int[theArray.length];
        int[] colTotal = new int[theArray.length];
        int dia1 = 0;
        int dia2 = 0;
        boolean notMagic = false;
        for(int row = 0 ; row < theArray.length ; row++){
            for(int col = 0 ; col < theArray.length ; col++){
                rowTotal[row] += theArray[row][col];
                colTotal[col] += theArray[row][col];
            }
            dia1 += theArray[row][row];
            dia2 += theArray[row][theArray.length-1-row];
        }
        for(int i = 0 ; i < rowTotal.length ; i++){
            if(rowTotal[0]!=rowTotal[i] || rowTotal[0]!=colTotal[i] || rowTotal[0]!=dia1 || rowTotal[0]!=dia2){
                System.out.println("Sorry, not a Magic Square");
                notMagic=true;
                break;
            }
        }
        if(!notMagic){
            System.out.println("Great! It is a Magic Square");
        }
    }
}
