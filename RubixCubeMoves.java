import java.util.Scanner;
class RubixCubeMoves
{
    Scanner sc = new Scanner(System.in);
    String a[]=new String[21];
    void Accept()
    {
        a[0] = "";
        int i;
        for(i=1;i<21;i++)
        {
            System.out.println("Enter Rubix Cube member" +i);
            a[i]=sc.next();
        }
    }
    void L1r()
    {
        String t1,t2,t3,t4;
        
        //swapping edge pieces
        t1=a[1];
        t2=a[2];
        t3=a[3];
        t4=a[4];
        a[1]=t4;
        a[2]=t1;
        a[3]=t2;
        a[4]=t3;
        
        //interchanging faces not required as there is no face conflicts in moving the first layer
        
        //swapping corner pieces
        t1=a[5];
        t2=a[6];
        t3=a[7];
        t4=a[8];
        a[5]=t4;
        a[6]=t1;
        a[7]=t2;
        a[8]=t3;
        
        //interchanging faces not required as there is no face conflicts in moving the first layer
    }
    void L3r()
    {
        String t1,t2,t3,t4;
        
        //swapping edge pieces
        t1=a[13];
        t2=a[14];
        t3=a[15];
        t4=a[16];
        a[13]=t4;
        a[14]=t1;
        a[15]=t2;
        a[16]=t3;
        
        //interchanging faces not required as there is no face conflicts in moving the third layer
        
        //swapping corner pieces
        t1=a[17];
        t2=a[18];
        t3=a[19];
        t4=a[20];
        a[17]=t4;
        a[18]=t1;
        a[19]=t2;
        a[20]=t3;
        
        //interchanging faces not required as there is no face conflicts in moving the third layer    
    }
    void SRd()
    {
        String t1,t2,t3,t4;
        
        //swapping edge pieces
        t1=a[2];
        t2=a[9];
        t3=a[14];
        t4=a[10];
        a[2]=t4;
        a[9]=t1;
        a[14]=t2;
        a[10]=t3;
        
        //interchanging edge pieces
        a[2] = a[2].substring(0,3) + a[2].charAt(4) + "u" + a[2].charAt(6) + "d";
        a[9] = a[9].substring(0,3) + a[9].charAt(6) + "r" + a[9].charAt(4) + "l";
        a[14] = a[14].substring(0,3) + a[14].charAt(4) + "u" + a[14].charAt(6) + "d";
        a[10] = a[10].substring(0,3) + a[10].charAt(6) + "r" + a[10].charAt(4) + "l";
        
        //swapping corner pieces
        t1=a[6];
        t2=a[5];
        t3=a[17];
        t4=a[18];
        a[6]=t4;
        a[5]=t1;
        a[17]=t2;
        a[18]=t3;
        
        //interchanging corner pieces
        a[6] = a[6].substring(0,3) + a[6].charAt(8) + "u" + a[6].charAt(4) + "d" + a[6].charAt(6) + "r";
        a[5] = a[5].substring(0,3) + a[5].charAt(8) + "u" + a[6].charAt(4) + "d" + a[5].charAt(6) + "r";
        a[17] = a[17].substring(0,3) + a[17].charAt(4) + "u" + a[17].charAt(6) + "d" + a[17].charAt(8) + "r";
        a[18] = a[18].substring(0,3) + a[18].charAt(8) + "u" + a[18].charAt(4) + "d" + a[18].charAt(6) + "r";
    }
    void SLd()
    {
        String t1,t2,t3,t4;
        
        //swapping edge pieces
        t1=a[4];
        t2=a[12];
        t3=a[16];
        t4=a[11];
        a[4]=t4;
        a[12]=t1;
        a[16]=t2;
        a[11]=t3;
        
        //interchanging edge pieces
        a[4] = a[4].substring(0,3) + a[4].charAt(6) + "u" + a[4].charAt(4) + "d";
        a[12] = a[12].substring(0,3) + a[12].charAt(4) + "r" + a[12].charAt(6) + "l";
        a[16] = a[16].substring(0,3) + a[16].charAt(6) + "u" + a[16].charAt(4) + "d";
        a[11] = a[11].substring(0,3) + a[11].charAt(4) + "r" + a[11].charAt(6) + "l";
        
        //swapping corner pieces
        t1=a[7];
        t2=a[8];
        t3=a[20];
        t4=a[19];
        a[7]=t4;
        a[8]=t1;
        a[20]=t2;
        a[19]=t3;
        
        //interchanging corner pieces
        a[7] = a[7].substring(0,3) + a[7].charAt(4) + "u" + a[7].charAt(6) + "d" + a[7].charAt(8) + "r";
        a[8] = a[8].substring(0,3) + a[8].charAt(6) + "u" + a[8].charAt(8) + "d" + a[8].charAt(4) + "r";
        a[20] = a[20].substring(0,3) + a[20].charAt(6) + "u" + a[20].charAt(8) + "d" + a[20].charAt(4) + "r";
        a[19] = a[19].substring(0,3) + a[19].charAt(6) + "u" + a[19].charAt(8) + "d" + a[19].charAt(4) + "r";
    }
    void P1c()
    {
        String t1,t2,t3,t4;
        
        //swapping edge pieces
        t1=a[1];
        t2=a[9];
        t3=a[13];
        t4=a[12];
        a[1]=t4;
        a[9]=t1;
        a[13]=t2;
        a[12]=t3;
        
        //interchanging edge pieces
        a[1] = a[1].substring(0,3) + a[1].charAt(6) + "u" + a[1].charAt(4) + "d";
        a[9] = a[9].substring(0,3) + a[9].charAt(4) + "r" + a[9].charAt(6) + "l";
        a[13] = a[13].substring(0,3) + a[13].charAt(6) + "u" + a[13].charAt(4) + "d";
        a[12] = a[12].substring(0,3) + a[12].charAt(4) + "r" + a[12].charAt(6) + "l";
        
        //swapping corner pieces
        t1=a[8];
        t2=a[5];
        t3=a[17];
        t4=a[20];
        a[8]=t4;
        a[5]=t1;
        a[17]=t2;
        a[20]=t3;
        
        //interchanging corner pieces
        a[8] = a[8].substring(0,3) + a[8].charAt(4) + "u" + a[8].charAt(6) + "d" + a[8].charAt(8) + "r";
        a[5] = a[5].substring(0,3) + a[5].charAt(6) + "u" + a[5].charAt(8) + "d" + a[5].charAt(4) + "r";
        a[17] = a[17].substring(0,3) + a[17].charAt(6) + "u" + a[17].charAt(8) + "d" + a[17].charAt(4) + "r";
        a[20] = a[20].substring(0,3) + a[20].charAt(6) + "u" + a[20].charAt(8) + "d" + a[20].charAt(4) + "r";
    }
    void P3c()
    {
        String t1,t2,t3,t4;
        
        //swapping edge pieces
        t1=a[3];
        t2=a[10];
        t3=a[15];
        t4=a[11];
        a[3]=t4;
        a[10]=t1;
        a[15]=t2;
        a[11]=t3;
        
        //interchanging edge pieces
        a[3] = a[3].substring(0,3) + a[3].charAt(4) + "u" + a[3].charAt(6) + "d";
        a[10] = a[10].substring(0,3) + a[10].charAt(6) + "r" + a[10].charAt(4) + "l";
        a[15] = a[15].substring(0,3) + a[15].charAt(4) + "u" + a[15].charAt(6) + "d";
        a[11] = a[11].substring(0,3) + a[11].charAt(6) + "r" + a[11].charAt(4) + "l";
        
        //swapping corner pieces
        t1=a[7];
        t2=a[6];
        t3=a[18];
        t4=a[19];
        a[7]=t4;
        a[6]=t1;
        a[18]=t2;
        a[19]=t3;
        
        //interchanging corner pieces
        a[7] = a[7].substring(0,3) + a[7].charAt(8) + "u" + a[7].charAt(4) + "d" + a[7].charAt(6) + "r";
        a[6] = a[6].substring(0,3) + a[6].charAt(8) + "u" + a[6].charAt(4) + "d" + a[6].charAt(6) + "r";
        a[18] = a[18].substring(0,3) + a[18].charAt(4) + "u" + a[18].charAt(6) + "d" + a[18].charAt(8) + "r";
        a[19] = a[19].substring(0,3) + a[19].charAt(8) + "u" + a[19].charAt(4) + "d" + a[19].charAt(6) + "r";
    }
    public static void main(String args[])
    {
        RubixCubeMoves RCM = new RubixCubeMoves();
        RCM.Accept();
    }
}


