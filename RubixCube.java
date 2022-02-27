import java.util.Scanner;
class RubixCube
{
    Scanner sc = new Scanner(System.in);
    String a[] = new String[21];
    String ori[] = new String[21];
    String a_solved[] = new String[21];
    String acc;
    //loop variable
    int i;
    //search variable
    int se;
    //number of moves Accumulating variable
    int nm;
    //number of movesets accumulating variable
    int nms;
    //move variables
    int c;
    //second layer variable
    int sls;
    //second layer search variable
    boolean slflag;
    //second layer flag variable
    int b;
    //thirdlayer cross, while loop control variable
    String buffer1;
    // String 1 to buffer main method
    String buffer2;
    // String 2 to buffer main method
    boolean check1;
    // flag variable to check if first layer is correct
    boolean check12; 
    // flag variable to check if first and second layer is correct
    boolean check123;
    // flag variable to check if first, second and third layer is correct
    boolean mainflag;
    // flag variable to check if first layer is correct
    String patterncheck[] = new String[21];
    //to store user input
    static boolean pattern1;
    // flag variable to check if pattern one exists
    static boolean pattern2;
    // flag variable to check if pattern two exists
    static boolean pattern3;
    String U,D,F,B,R,L,M,E,S,UI,DI,FI,BI,RI,LI,MI,EI,SI;
    RubixCube()
    {
        a[0] = "";
        a[1]=a[2]=a[3]=a[4]=a[13]=a[14]=a[15]=a[16]="xxepxuxd";
        a[9]=a[10]=a[11]=a[12]="xxepxrxl";
        a[5]=a[6]=a[7]=a[8]=a[17]=a[18]=a[19]=a[20]="xxxcxxuxdxr";
        
        a_solved[1]="grepgurd";
        a_solved[2]="gwepguwd";
        a_solved[3]="goepguod";
        a_solved[4]="gyepguyd";
        
        a_solved[5]="grwcgurdwr";
        a_solved[6]="gowcguwdor";
        a_solved[7]="goycguodyr";
        a_solved[8]="grycguydrr";
        
        a_solved[9]="rwepwrrl";
        a_solved[10]="oweporwl";
        a_solved[11]="oyepyrol";
        a_solved[12]="ryeprryl";
        
        a_solved[13]="breprubd";
        a_solved[14]="bwepwubd";
        a_solved[15]="boepoubd";
        a_solved[16]="byepyubd";
        
        a_solved[17]="brwcrubdwr";
        a_solved[18]="bowcwubdor";
        a_solved[19]="boycoubdyr";
        a_solved[20]="brycyubdrr";
        
        //move variables initialisation
        U = "U Up              Move first layer to the left";
        D = "D Down            Move third layer to the right";
        F = "F Front           Move first phase clockwise";
        B = "B Back            Move third phase anticlockwise with respect to the side you are currently holding";
        R = "R Right           Move right sub-layer upwards";
        L = "L Left            Move left sub-layer downwards";
        M = "M Middle          Move middle sub layer downwards";
        E = "E Equatorial      Move second layer to the right";
        S = "S Standing        Move second phase clockwise";
        //inverted moves
        UI = "UI Up_inv         Move first layer to the right";
        DI = "DI Down_inv       Move third layer to the left";
        FI = "FI Front_inv      Move first phase anticlockwise";
        BI = "BI Back_inv       Move third phase clockwise with respect to the side you are currently holding";
        RI = "RI Right_inv      Move right sub-layer downwards";
        LI = "LI Left_inv       Move left sub-layer upwards";
        MI = "MI Middle_inv     Move middle sub layer upwards";
        EI = "EI Equatorial_inv Move second layer to the left";
        SI = "SI Standing_inv   Move second phase anticlockwise";
        
        nm = nms = 0;
        c=0;
        slflag = false;
        buffer1  = buffer2 = null;
        check1 = true;
        check12 = true;
        check123 = true;
        mainflag = true;
        pattern1 = false;
        pattern2 = false;
        pattern3 = false;
        
        patterncheck[0] = "";
        patterncheck[1]=patterncheck[2]=patterncheck[3]=patterncheck[4]=patterncheck[13]=patterncheck[14]=patterncheck[15]=patterncheck[16]="xxepxuxd";
        patterncheck[9]=patterncheck[10]=patterncheck[11]=patterncheck[12]="xxepxrxl";
        patterncheck[5]=patterncheck[6]=patterncheck[7]=patterncheck[8]=patterncheck[17]=patterncheck[18]=patterncheck[19]=patterncheck[20]="xxxcxxuxdxr";
    }
    void Accept()
    {
        for(i=1;i<21;i++)
        {
            accept: while(true)
            {
                System.out.println("Enter Rubix Cube member at " +i);
                if(i == 1 || i == 2 || i == 3 || i == 4 || i == 13 || i == 14 || i == 15 || i == 16)
                System.out.println("Enter the first letter of the colour you see above followed by the first letter of the colour you see below it.");
                else if(i == 9 || i == 10 || i == 11 || i == 12)
                System.out.println("Enter the first letter of the colour you see to the right followed by the first letter of the colour you see to the left of it.");
                else
                System.out.println("Enter the first letter of the colour you see above, followed by the one below and then followed by the one on the right");
                acc = sc.next();
                if(i == 1 || i == 2 || i == 3 || i == 4 || i == 13 || i == 14 || i == 15 || i == 16 || i == 9 || i == 10 || i == 11 || i == 12)
                {
                    if(acc.length()<2)
                    System.out.println("Wrong entry");
                    else
                    break accept;
                }
                else
                {
                    if(acc.length()<3)
                    System.out.println("Wrong entry");
                    else
                    break accept;
                }
            }
            patterncheck[i] = acc;
            //now the entry should be correct.
            //for edge pieces
            if(i == 1 || i == 2 || i == 3 || i == 4 || i == 13 || i == 14 || i == 15 || i == 16 || i == 9 || i == 10 || i == 11 || i == 12)
            {
                if(acc.indexOf('g') != -1)
                a[i] = "g";
                else if(acc.indexOf('b') != -1)
                a[i] = "b";
                if(acc.indexOf('g') == -1 && acc.indexOf('b') == -1 && acc.indexOf('r') != -1)
                a[i] = "r";
                else if(acc.indexOf('g') == -1 && acc.indexOf('b') == -1 && acc.indexOf('o') != -1)
                a[i] = "o";
                if( (acc.indexOf('g') != -1 || acc.indexOf('b') != -1) && acc.indexOf('r') != -1)
                a[i] = a[i] + "r";
                else if( (acc.indexOf('g') != -1 || acc.indexOf('b') != -1) && acc.indexOf('o') != -1)
                a[i] = a[i] + "o";
                if(acc.indexOf('w') != -1)
                a[i] = a[i] + "w";
                else if(acc.indexOf('y') != -1)
                a[i] = a[i] + "y";
                
                a[i] = a[i] + "ep";
            }
            //for corner pieces
            if(i == 5 || i == 6 || i == 7 || i == 8 || i == 17 || i == 18 || i == 19 || i == 20)
            {
                if(acc.indexOf('g') != -1)
                a[i] = "g";
                else if(acc.indexOf('b') != -1)
                a[i] = "b";
                if(acc.indexOf('r') != -1)
                a[i] = a[i] + "r";
                else if(acc.indexOf('o') != -1)
                a[i] = a[i] + "o";
                if(acc.indexOf('w') != -1)
                a[i] = a[i] + "w";
                else if(acc.indexOf('y') != -1)
                a[i] = a[i] + "y";
                
                a[i] = a[i] + "c";
            }
            switch(i)
            {
                case 1:case 2:case 3:case 4:case 13:case 14:case 15:case 16:
                a[i] = a[i] + acc.charAt(0) + "u" + acc.charAt(1) + "d"; 
                ori[i] = a[i];
                break;
                case 9:case 10:case 11:case 12:
                a[i] = a[i] + acc.charAt(0) + "r" + acc.charAt(1) + "l"; 
                ori[i] = a[i];
                break;
                default:
                a[i] = a[i] + acc.charAt(0) + "u" + acc.charAt(1) + "d" + acc.charAt(2) + "r";
                ori[i] = a[i];
            }
        }    
    }
    void L1R()
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
    void L3R()
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
    void SRD()
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
        a[2] = a[2].substring(0,4) + a[2].charAt(4) + "u" + a[2].charAt(6) + "d";
        a[9] = a[9].substring(0,4) + a[9].charAt(6) + "r" + a[9].charAt(4) + "l";
        a[14] = a[14].substring(0,4) + a[14].charAt(4) + "u" + a[14].charAt(6) + "d";
        a[10] = a[10].substring(0,4) + a[10].charAt(6) + "r" + a[10].charAt(4) + "l";
        
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
        a[6] = a[6].substring(0,4) + a[6].charAt(8) + "u" + a[6].charAt(4) + "d" + a[6].charAt(6) + "r";
        a[5] = a[5].substring(0,4) + a[5].charAt(8) + "u" + a[5].charAt(4) + "d" + a[5].charAt(6) + "r";
        a[17] = a[17].substring(0,4) + a[17].charAt(4) + "u" + a[17].charAt(6) + "d" + a[17].charAt(8) + "r";
        a[18] = a[18].substring(0,4) + a[18].charAt(8) + "u" + a[18].charAt(4) + "d" + a[18].charAt(6) + "r";
    }
    void SLD()
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
        a[4] = a[4].substring(0,4) + a[4].charAt(6) + "u" + a[4].charAt(4) + "d";
        a[12] = a[12].substring(0,4) + a[12].charAt(4) + "r" + a[12].charAt(6) + "l";
        a[16] = a[16].substring(0,4) + a[16].charAt(6) + "u" + a[16].charAt(4) + "d";
        a[11] = a[11].substring(0,4) + a[11].charAt(4) + "r" + a[11].charAt(6) + "l";
        
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
        a[7] = a[7].substring(0,4) + a[7].charAt(4) + "u" + a[7].charAt(6) + "d" + a[7].charAt(8) + "r";
        a[8] = a[8].substring(0,4) + a[8].charAt(6) + "u" + a[8].charAt(8) + "d" + a[8].charAt(4) + "r";
        a[20] = a[20].substring(0,4) + a[20].charAt(6) + "u" + a[20].charAt(8) + "d" + a[20].charAt(4) + "r";
        a[19] = a[19].substring(0,4) + a[19].charAt(6) + "u" + a[19].charAt(8) + "d" + a[19].charAt(4) + "r";
    }
    void P1C()
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
        a[1] = a[1].substring(0,4) + a[1].charAt(6) + "u" + a[1].charAt(4) + "d";
        a[9] = a[9].substring(0,4) + a[9].charAt(4) + "r" + a[9].charAt(6) + "l";
        a[13] = a[13].substring(0,4) + a[13].charAt(6) + "u" + a[13].charAt(4) + "d";
        a[12] = a[12].substring(0,4) + a[12].charAt(4) + "r" + a[12].charAt(6) + "l";
        
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
        a[8] = a[8].substring(0,4) + a[8].charAt(4) + "u" + a[8].charAt(6) + "d" + a[8].charAt(8) + "r";
        a[5] = a[5].substring(0,4) + a[5].charAt(6) + "u" + a[5].charAt(8) + "d" + a[5].charAt(4) + "r";
        a[17] = a[17].substring(0,4) + a[17].charAt(6) + "u" + a[17].charAt(8) + "d" + a[17].charAt(4) + "r";
        a[20] = a[20].substring(0,4) + a[20].charAt(6) + "u" + a[20].charAt(8) + "d" + a[20].charAt(4) + "r";
    }
    void P3C()
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
        a[3] = a[3].substring(0,4) + a[3].charAt(4) + "u" + a[3].charAt(6) + "d";
        a[10] = a[10].substring(0,4) + a[10].charAt(6) + "r" + a[10].charAt(4) + "l";
        a[15] = a[15].substring(0,4) + a[15].charAt(4) + "u" + a[15].charAt(6) + "d";
        a[11] = a[11].substring(0,4) + a[11].charAt(6) + "r" + a[11].charAt(4) + "l";
        
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
        a[7] = a[7].substring(0,4) + a[7].charAt(8) + "u" + a[7].charAt(4) + "d" + a[7].charAt(6) + "r";
        a[6] = a[6].substring(0,4) + a[6].charAt(8) + "u" + a[6].charAt(4) + "d" + a[6].charAt(6) + "r";
        a[18] = a[18].substring(0,4) + a[18].charAt(4) + "u" + a[18].charAt(6) + "d" + a[18].charAt(8) + "r";
        a[19] = a[19].substring(0,4) + a[19].charAt(8) + "u" + a[19].charAt(4) + "d" + a[19].charAt(6) + "r";
    }
    
    //Moves of the sides of the cube
    //red side
    void RU()
    {
        L1R();
        L1R();
        L1R();
    }
    void RD()
    {
        L3R();
    }
    void RF()
    {
        P1C();
    }
    void RB()
    {
        P3C();
        P3C();
        P3C();
    }
    void RR()
    {
        SRD();
        SRD();
        SRD();
    }
    void RL()
    {
        SLD();
    }
    void RM()
    {
        RR();
        RL();
        RL();
        RL();
    }
    void RE()
    {
        RU();
        RD();
        RD();
        RD();
    }
    void RS()
    {
        RF();
        RF();
        RF();
        RB();
    }
    void RUI()
    {
        RU();
        RU();
        RU();
    }
    void RDI()
    {
        RD();
        RD();
        RD();
    }
    void RFI()
    {
        RF();
        RF();
        RF();
    }
    void RBI()
    {
        RB();
        RB();
        RB();
    }
    void RRI()
    {
        RR();
        RR();
        RR();
    }
    void RLI()
    {
        RL();
        RL();
        RL();
    }
    void RMI()
    {
        RM();
        RM();
        RM();
    }
    void REI()
    {
        RE();
        RE();
        RE();
    }
    void RSI()
    {
        RS();
        RS();
        RS();
    }
    
    //white side
    void WU()
    {
        RU();
    }
    void WD()
    {
        RD();
    }
    void WF()
    {
        RR();
    }
    void WB()
    {
        RL();
    }
    void WR()
    {
        RB();
    }
    void WL()
    {
        RF();
    }
    void WM()
    {
        RS();
    }
    void WE()
    {
        RE();
    }
    void WS()
    {
        RMI();
    }
    void WUI()
    {
        WU();
        WU();
        WU();
    }
    void WDI()
    {
        WD();
        WD();
        WD();
    }
    void WFI()
    {
        WF();
        WF();
        WF();
    }
    void WBI()
    {
        WB();
        WB();
        WB();
    }
    void WRI()
    {
        WR();
        WR();
        WR();
    }
    void WLI()
    {
        WL();
        WL();
        WL();
    }
    void WMI()
    {
        WM();
        WM();
        WM();
    }
    void WEI()
    {
        WE();
        WE();
        WE();
    }
    void WSI()
    {
        WS();
        WS();
        WS();
    }
    
    //orange side
    void OU()
    {
        RU();
    }
    void OD()
    {
        RD();
    }
    void OF()
    {
        RB();
    }
    void OB()
    {
        RF();
    }
    void OR()
    {
        RL();
    }
    void OL()
    {
        RR();
    }
    void OM()
    {
        RMI();
    }
    void OE()
    {
        RE();
    }
    void OS()
    {
        RSI();
    }
    void OUI()
    {
        OU();
        OU();
        OU();
    }
    void ODI()
    {
        OD();
        OD();
        OD();
    }
    void OFI()
    {
        OF();
        OF();
        OF();
    }
    void OBI()
    {
        OB();
        OB();
        OB();
    }
    void ORI()
    {
        OR();
        OR();
        OR();
    }
    void OLI()
    {
        OL();
        OL();
        OL();
    }
    void OMI()
    {
        OM();
        OM();
        OM();
    }
    void OEI()
    {
        OE();
        OE();
        OE();
    }
    void OSI()
    {
        OS();
        OS();
        OS();
    }
    
    //yellow side
    void YU()
    {
        RU();
    }
    void YD()
    {
        RD();
    }
    void YF()
    {
        RL();
    }
    void YB()
    {
        RR();
    }
    void YR()
    {
        RF();
    }
    void YL()
    {
        RB();
    }
    void YM()
    {
        RSI();
    }
    void YE()
    {
        RE();
    }
    void YS()
    {
        RM();
    }
    void YUI()
    {
        YU();
        YU();
        YU();
    }
    void YDI()
    {
        YD();
        YD();
        YD();
    }
    void YFI()
    {
        YF();
        YF();
        YF();
    }
    void YBI()
    {
        YB();
        YB();
        YB();
    }
    void YRI()
    {
        YR();
        YR();
        YR();
    }
    void YLI()
    {
        YL();
        YL();
        YL();
    }
    void YMI()
    {
        YM();
        YM();
        YM();
    }
    void YEI()
    {
        YE();
        YE();
        YE();
    }
    void YSI()
    {
        YS();
        YS();
        YS();
    }
    
    // green side
    // IMPORTANT:- GREEN SIDE TOWARDS YOU, RED BELOW
    void GU()
    {
        RB();
    }
    void GD()
    {
        RF();
    }
    void GF()
    {
        RU();
    }
    void GB()
    {
        RD();
    }
    void GR()
    {
        RR();
    }
    void GL()
    {
        RL();
    }
    void GM()
    {
        RM();
    }
    void GE()
    {
        RS();
    }
    void GS()
    {
        REI();
    }
    void GUI()
    {
        GU();
        GU();
        GU();
    }
    void GDI()
    {
        GD();
        GD();
        GD();
    }
    void GFI()
    {
        GF();
        GF();
        GF();
    }
    void GBI()
    {
        GB();
        GB();
        GB();
    }
    void GRI()
    {
        GR();
        GR();
        GR();
    }
    void GLI()
    {
        GL();
        GL();
        GL();
    }
    void GMI()
    {
        GM();
        GM();
        GM();
    }
    void GEI()
    {
        GE();
        GE();
        GE();
    }
    void GSI()
    {
        GS();
        GS();
        GS();
    }
    
    //blue side
    // IMPORTANT:- BLUE SIDE TOWARDS YOU AND ORANGE BELOW 
    void BU()
    {
        RF();
    }
    void BD()
    {
        RB();
    }
    void BF()
    {
        RD();
    }
    void BB()
    {
        RU();
    }
    void BR()
    {
        RR();
    }
    void BL()
    {
        RL();
    }
    void BM()
    {
        RM();
    }
    void BE()
    {
        RSI();
    }
    void BS()
    {
        RE();
    }
    void BUI()
    {
        BU();
        BU();
        BU();
    }
    void BDI()
    {
        BD();
        BD();
        BD();
    }
    void BFI()
    {
        BF();
        BF();
        BF();
    }
    void BBI()
    {
        BB();
        BB();
        BB();
    }
    void BRI()
    {
        BR();
        BR();
        BR();
    }
    void BLI()
    {
        BL();
        BL();
        BL();
    }
    void BMI()
    {
        BM();
        BM();
        BM();
    }
    void BEI()
    {
        BE();
        BE();
        BE();
    }
    void BSI()
    {
        BS();
        BS();
        BS();
    }
    
    //Movesets complete. Unit one of the rubix cube solver marks its completition.
    //Moving on to unit 2. Solving the first layer.
    void FirstLayerCross()
    {
        //first step. To Bring the green-red edge piece in the correct position.
        for(i=1;i<21;i++)
        {
            if(a[i].substring(0,4).equalsIgnoreCase("grep"))
            {
                se = i;
                break;
            }
        }
        if(!(a[1].equalsIgnoreCase("grepgurd")))
        {
            nms++;
            System.out.println("Moveset "+nms+ ":");
            System.out.println("Hold red side towards you and green side above");
            switch(se)
            {
                case 1:
                RU();
                RL();
                RF();
                System.out.println(U);
                System.out.println(L);
                System.out.println(F);
                nm+=3;
                break;
                case 2:
                if(a[2].equalsIgnoreCase("grepgurd"))
                {
                    RU();
                    System.out.println(U);
                    nm++;
                }
                else
                {
                    RRI();
                    RFI();
                    System.out.println(RI);
                    System.out.println(FI);
                    nm+=2;
                }
                break;
                case 3:
                if(a[3].equalsIgnoreCase("grepgurd"))
                {
                    RU();
                    RU();
                    System.out.println(U);
                    System.out.println(U);
                    nm+=2;
                }
                else
                {
                    RU();
                    RRI();
                    RFI();
                    System.out.println(U);
                    System.out.println(RI);
                    System.out.println(FI);
                    nm+=3;
                }
                break;
                case 4:
                if(a[4].equalsIgnoreCase("grepgurd"))
                {
                    RUI();
                    System.out.println(UI);
                    nm++;
                }
                else
                {
                    RL();
                    RF();
                    System.out.println(L);
                    System.out.println(F);
                    nm+=2;
                }
                break;
                case 9:
                if(a[9].equalsIgnoreCase("grepgrrl"))
                {
                    RFI();
                    System.out.println(FI);
                    nm++;
                }
                else
                {
                    RR();
                    RU();
                    System.out.println(R);
                    System.out.println(U);
                    nm+=2;
                }
                break;
                case 10:
                if(a[10].equalsIgnoreCase("grepgrrl"))
                {
                    RRI();
                    RU();
                    System.out.println(RI);
                    System.out.println(U);
                    nm+=2;
                }
                else
                {
                    RR();
                    RR();
                    RFI();
                    System.out.println(R);
                    System.out.println(R);
                    System.out.println(FI);
                    nm+=3;
                }
                break;
                case 11:
                if(a[11].equalsIgnoreCase("grepgrrl"))
                {
                    RL();
                    RL();
                    RF();
                    System.out.println(L);
                    System.out.println(L);
                    System.out.println(F);
                    nm+=3;
                }
                else
                {
                    RL();
                    RUI();
                    System.out.println(L);
                    System.out.println(UI);
                    nm+=2;
                }
                break;
                case 12:
                if(a[12].equalsIgnoreCase("grepgrrl"))
                {
                    RLI();
                    RUI();
                    System.out.println(LI);
                    System.out.println(UI);
                    nm+=2;
                }
                else
                {
                    RF();
                    System.out.println(F);
                    nm++;
                }
                break;
                case 13:
                if(a[13].equalsIgnoreCase("grepgurd"))
                {
                    RD();
                    RR();
                    RFI();
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(FI);
                    nm+=3;
                }
                else
                {
                    RF();
                    RF();
                    System.out.println(F);
                    System.out.println(F);
                    nm+=2;
                }
                break;
                case 14:
                if(a[14].equalsIgnoreCase("grepgurd"))
                {
                    RR();
                    RFI();
                    System.out.println(R);
                    System.out.println(FI);
                    nm+=2;
                }
                else
                {
                    RDI();
                    RF();
                    RF();
                    System.out.println(DI);
                    System.out.println(F);
                    System.out.println(F);
                    nm+=3;
                }
                break;
                case 15:
                if(a[15].equalsIgnoreCase("grepgurd"))
                {
                    RDI();
                    RR();
                    RFI();
                    System.out.println(DI);
                    System.out.println(R);
                    System.out.println(FI);
                    nm+=3;
                }
                else
                {
                    RD();
                    RD();
                    RF();
                    RF();
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(F);
                    System.out.println(F);
                    nm+=4;
                }
                break;
                default:
                if(a[16].equalsIgnoreCase("grepgurd"))
                {
                    RLI();
                    RF();
                    System.out.println(LI);
                    System.out.println(F);
                    nm+=2;
                }
                else
                {
                    RD();
                    RF();
                    RF();
                    System.out.println(D);
                    System.out.println(F);
                    System.out.println(F);
                    nm+=3;
                }
            }
        }
        //second step. To bring the gree-white edge piece in correct position.
        for(i=2;i<21;i++)
        {
            if(a[i].substring(0,4).equalsIgnoreCase("gwep"))
            {
                se = i;
                break;
            }
        }
        if(!(a[2].equalsIgnoreCase("gwepguwd")))
        {
            nms++;
            if(se!=12)
            {
                System.out.println("Moveset "+nms+ ":");
                System.out.println("Hold the white side towards you keeping the green side above");
            }
            switch(se)
            {
                case 2:
                WU();
                WL();
                WUI();
                WF();
                System.out.println(U);
                System.out.println(L);
                System.out.println(UI);
                System.out.println(F);
                nm+=4;
                break;
                case 3:
                if(a[3].equalsIgnoreCase("gwepguwd"))
                {
                    WL();
                    WU();
                    WLI();
                    System.out.println(L);
                    System.out.println(U);
                    System.out.println(LI);
                    nm+=3;
                }
                else
                {
                    WRI();
                    WFI();
                    System.out.println(RI);
                    System.out.println(FI);
                    nm+=2;
                }
                break;
                case 4:
                if(a[4].equalsIgnoreCase("gwepguwd"))
                {
                    WL();
                    WU();
                    WU();
                    WLI();
                    System.out.println(L);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(LI);
                    nm+=4;
                }
                else
                {
                    WU();
                    WRI();
                    WUI();
                    WFI();
                    System.out.println(U);
                    System.out.println(RI);
                    System.out.println(UI);
                    System.out.println(FI);
                    nm+=4;
                }
                break;
                case 9:
                if(a[9].equalsIgnoreCase("gwepgrwl"))
                {
                    WLI();
                    WUI();
                    WL();
                    System.out.println(LI);
                    System.out.println(UI);
                    System.out.println(L);
                    nm+=3;
                }
                else
                {
                    WF();
                    System.out.println(F);
                    nm++;
                }
                break;
                case 10:
                if(a[10].equalsIgnoreCase("gwepgrwl"))
                {
                    WFI();
                    System.out.println(FI);
                    nm++;
                }
                else
                {
                    WUI();
                    WR();
                    WU();
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(U);
                    nm+=3;
                }
                break;
                case 11:
                if(a[11].equalsIgnoreCase("gwepgrwl"))
                {
                    WUI();
                    WRI();
                    WU();
                    System.out.println(UI);
                    System.out.println(RI);
                    System.out.println(U);
                    nm+=3;
                }
                else
                {
                    WR();
                    WR();
                    WFI();
                    System.out.println(R);
                    System.out.println(R);
                    System.out.println(FI);
                    nm+=3;
                }
                break;
                case 12:
                if(a[12].equalsIgnoreCase("gwepgrwl"))
                {
                    System.out.println("Moveset "+nms+ ":");
                    System.out.println("Hold the red side towards you keeping the green side above");
                    
                    RL();
                    RD();
                    RD();
                    RR();
                    RR();
                    System.out.println(L);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(R);
                    nm+=5;
                }
                else
                {
                    System.out.println("Moveset "+nms+ ":");
                    System.out.println("Hold the white side towards you keeping the green side above");
                    WU();
                    WL();
                    WUI();
                    System.out.println(U);
                    System.out.println(L);
                    System.out.println(UI);
                    nm+=3;;
                }
                break;
                case 13:
                if(a[13].equalsIgnoreCase("gwepguwd"))
                {
                    WLI();
                    WF();
                    WL();
                    System.out.println(LI);
                    System.out.println(F);
                    System.out.println(L);
                    nm+=3;
                }
                else
                {
                    WD();
                    WF();
                    WF();
                    System.out.println(D);
                    System.out.println(F);
                    System.out.println(F);
                    nm+=3;
                }
                break;
                case 14:
                if(a[14].equalsIgnoreCase("gwepguwd"))
                {
                    WD();
                    WR();
                    WFI();
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(FI);
                    nm+=3;
                }
                else
                {
                    WF();
                    WF();
                    System.out.println(F);
                    System.out.println(F);
                    nm+=2;
                }
                break;
                case 15:
                if(a[15].equalsIgnoreCase("gwepguwd"))
                {
                    WR();
                    WFI();
                    System.out.println(R);
                    System.out.println(FI);
                    nm+=2;
                }
                else
                {
                    WDI();
                    WF();
                    WF();
                    System.out.println(DI);
                    System.out.println(F);
                    System.out.println(F);
                    nm+=3;
                }
                break;
                default:
                if(a[16].equalsIgnoreCase("gwepguwd"))
                {
                    WDI();
                    WR();
                    WFI();
                    System.out.println(DI);
                    System.out.println(R);
                    System.out.println(FI);
                    nm+=3;
                }
                else
                {
                    WD();
                    WD();
                    WF();
                    WF();
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(F);
                    System.out.println(F);
                    nm+=4;
                }
            }
        }
        //third step. To bring the gree-orange edge piece in correct position.
        for(i=3;i<21;i++)
        {
            if(a[i].substring(0,4).equalsIgnoreCase("goep"))
            {
                se = i;
                break;
            }
        }
        if(!(a[3].equalsIgnoreCase("goepguod")))
        {
            nms++;
            if(se != 9)
            {
                System.out.println("Moveset "+nms+ ":");
                System.out.println("Hold the orange side towards you keeping the green side above");
            }
            switch(se)
            {
                case 3:
                OU();
                OL();
                OUI();
                OF();
                System.out.println(U);
                System.out.println(L);
                System.out.println(UI);
                System.out.println(F);
                nm+=4;
                break;
                case 4:
                if(a[4].equalsIgnoreCase("goepguod"))
                {
                    ORI();
                    OUI();
                    OR();
                    OU();
                    System.out.println(RI);
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(U);
                    nm+=4;
                }
                else
                {
                    ORI();
                    OFI();
                    System.out.println(RI);
                    System.out.println(FI);
                    nm+=2;
                }
                break;
                case 9:
                if(a[9].equalsIgnoreCase("goepgrol"))
                {
                    System.out.println("Moveset "+nms+ ":");
                    System.out.println("Hold the red side towards you keeping the green side above");
                    
                    RU();
                    RU();
                    RFI();
                    RU();
                    RU();
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(FI);
                    System.out.println(U);
                    System.out.println(U);
                    nm+=5;
                }
                else
                {
                    System.out.println("Moveset "+nms+ ":");
                    System.out.println("Hold the orange side towards you keeping the green side above");
                    
                    OU();
                    OL();
                    OUI();
                    System.out.println(U);
                    System.out.println(L);
                    System.out.println(UI);
                    nm+=3;
                }
                break;
                case 10:
                if(a[10].equalsIgnoreCase("goepgrol"))
                {
                    OU();
                    OLI();
                    OUI();
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(UI);
                    nm+=3;
                }
                else
                {
                    OF();
                    System.out.println(F);
                    nm++;
                }
                break;
                case 11:
                if(a[11].equalsIgnoreCase("goepgrol"))
                {
                    OFI();
                    System.out.println(FI);
                    nm++;
                }
                else
                {
                    OUI();
                    OR();
                    OU();
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(U);
                    nm+=3;
                }
                break;
                case 12:
                if(a[12].equalsIgnoreCase("grepgrol"))
                {
                    OUI();
                    ORI();
                    OU();
                    System.out.println(UI);
                    System.out.println(RI);
                    System.out.println(U);
                    nm+=3;
                }
                else
                {
                    OR();
                    OR();
                    OFI();
                    System.out.println(R);
                    System.out.println(R);
                    System.out.println(FI);
                    nm+=3;
                }
                break;
                case 13:
                if(a[13].equalsIgnoreCase("goepguod"))
                {
                    ODI();
                    OR();
                    OFI();
                    System.out.println(DI);
                    System.out.println(R);
                    System.out.println(FI);
                    nm+=3;
                }
                else
                {
                    OD();
                    OD();
                    OF();
                    OF();
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(F);
                    System.out.println(F);
                    nm+=4;
                }
                break;
                case 14:
                if(a[14].equalsIgnoreCase("goepguod"))
                {
                    OU();
                    OLI();
                    OUI();
                    OF();
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(UI);
                    System.out.println(F);
                    nm+=4;
                }
                else
                {
                    OD();
                    OF();
                    OF();
                    System.out.println(D);
                    System.out.println(F);
                    System.out.println(F);
                    nm+=3;
                }
                break;
                case 15:
                if(a[15].equalsIgnoreCase("goepguod"))
                {
                    OD();
                    OR();
                    OFI();
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(FI);
                    nm+=3;
                }
                else
                {
                    OF();
                    OF();
                    System.out.println(F);
                    System.out.println(F);
                    nm+=2;
                }
                break;
                default :
                if(a[16].equalsIgnoreCase("goepguod"))
                {
                    OR();
                    OFI();
                    System.out.println(R);
                    System.out.println(FI);
                    nm+=2;
                }
                else
                {
                    ODI();
                    OF();
                    OF();
                    System.out.println(DI);
                    System.out.println(F);
                    System.out.println(F);
                    nm+=3;
                }
            }
        }
        //Fourth step. To bring the green-yellow edge piece in the correct position.        
        for(i=4;i<21;i++)
        {
            if(a[i].substring(0,4).equalsIgnoreCase("gyep"))
            {
                se = i;
                break;
            }
        }
        if(!(a[4].equalsIgnoreCase("gyepguyd")))
        {
            nms++;
            if(se != 9 && se != 10)
            {
                System.out.println("Moveset "+nms+ ":");
                System.out.println("Hold the yellow side towards you keeping the green side above");
            }
            switch(se)
            {
                case 4:
                YF();
                YUI();
                YR();
                YU();
                System.out.println(F);
                System.out.println(UI);
                System.out.println(R);
                System.out.println(U);
                nm+=4;
                break;
                case 9:
                if(a[9].equalsIgnoreCase("gyepgryl"))
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold the yellow side towards you keeping the green side above");
                    
                    YUI();
                    YRI();
                    YU();
                    System.out.println(UI);
                    System.out.println(RI);
                    System.out.println(U);
                    nm+=3;
                }
                else
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold the red side towards you keeping the green side above");
                    
                    RU();
                    RU();
                    RR();
                    RU();
                    RU();
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(R);
                    System.out.println(U);
                    System.out.println(U);
                    nm+=5;
                }
                break;
                case 10:
                if(a[10].equalsIgnoreCase("gyepgryl"))
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold the orange side towards you keeping the green side above");
                    
                    OU();
                    OU();
                    OLI();
                    OU();
                    OU();
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(U);
                    nm+=5;
                }
                else
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold the yellow side towards you keeping the green side above");
                    
                    YU();
                    YL();
                    YUI();
                    System.out.println(U);
                    System.out.println(L);
                    System.out.println(UI);
                    nm+=3;
                }
                break;
                case 11:
                if(a[11].equalsIgnoreCase("gyepgryl"))
                {
                    YU();
                    YLI();
                    YUI();
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(UI);
                    nm+=3;
                }
                else
                {
                    YF();
                    System.out.println(F);
                    nm++;
                }
                case 12:
                if(a[12].equalsIgnoreCase("gyepgryl"))
                {
                    YFI();
                    System.out.println(FI);
                    nm++;
                }
                else
                {
                    YUI();
                    YR();
                    YU();
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(U);
                    nm+=3;
                }
                break;
                case 13:
                if(a[13].equalsIgnoreCase("gyepguyd"))
                {
                    YUI();
                    YR();
                    YU();
                    YFI();
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(U);
                    System.out.println(FI);
                    nm+=4;
                }
                else
                {
                    YDI();
                    YF();
                    YF();
                    System.out.println(DI);
                    System.out.println(F);
                    System.out.println(F);
                    nm+=3;
                }
                break;
                case 14:
                if(a[14].equalsIgnoreCase("gyepguyd"))
                {
                    YD();
                    YU();
                    YLI();
                    YUI();
                    YF();
                    System.out.println(D);                    
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(UI);
                    System.out.println(F);
                    nm+=5;
                }
                else
                {
                    YD();
                    YD();
                    YF();
                    YF();
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(F);
                    System.out.println(F);
                    nm+=4;
                }
                break;
                case 15:
                if(a[15].equalsIgnoreCase("gyepguyd"))
                {
                    YU();
                    YLI();
                    YUI();
                    YF();
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(UI);
                    System.out.println(F);
                    nm+=4;
                }
                else
                {
                    YD();
                    YF();
                    YF();
                    System.out.println(D);
                    System.out.println(F);
                    System.out.println(F);
                    nm+=3;
                }
                break;
                default :
                if(a[16].equalsIgnoreCase("gyepguyd"))
                {
                    YDI();
                    YU();
                    YLI();
                    YUI();
                    YF();
                    System.out.println(DI);
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(UI);
                    System.out.println(F);
                    nm+=5;
                }
                else
                {
                    YF();
                    YF();
                    System.out.println(F);
                    System.out.println(F);
                    nm+=2;
                }
            }
        }
    }
    void FirstLayerCorners()
    {
        //first step. To Bring the green-red-white corner piece in the correct position.
        for(i=5;i<21;i++)
        {
            if(a[i].substring(0,4).equalsIgnoreCase("grwc"))
            {
                se = i;
                break;
            }
        }
        if(!(a[5].equalsIgnoreCase("grwcgurdwr")))
        {
            nms++;
            if(se != 6 && se != 7)
            {
                System.out.println("Moveset "+nms+" :");
                System.out.println("Hold red side towards you and green side above");
            }
            switch(se)
            {
                case 5:
                if(a[5].equalsIgnoreCase("grwcwugdrr"))
                {
                    RRI();
                    RD();
                    RR();
                    RDI();
                    RRI();
                    RD();
                    RR();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(DI);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=7;
                }
                else
                {
                    RRI();
                    RDI();
                    RR();
                    RD();
                    RRI();
                    RDI();
                    RR();
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    System.out.println(D);
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    nm+=7;
                }
                break;
                case 6:
                if(a[6].equalsIgnoreCase("grwcgurdwr"))
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold white side towards you and green side above");
                    
                    WRI();
                    WD();
                    WR();
                    WL();
                    WDI();
                    WLI();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(L);
                    System.out.println(DI);
                    System.out.println(LI);
                    nm+=6;
                }
                else if(a[6].equalsIgnoreCase("grwcwugdrr"))
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold red side towards you and green side above");
                    
                    RR();
                    RD();
                    RD();
                    RR();
                    RR();
                    RD();
                    RRI();
                    System.out.println(R);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(R);
                    System.out.println(D);
                    System.out.println(RI);
                    nm+=7;
                }
                else
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold red side towards you and green side above");
                    
                    RR();
                    RDI();
                    RRI();
                    RF();
                    RDI();
                    RFI();
                    System.out.println(R);
                    System.out.println(DI);
                    System.out.println(RI);
                    System.out.println(F);
                    System.out.println(DI);
                    System.out.println(FI);
                    nm+=6;
                }
                break;
                case 7:
                if(a[7].equalsIgnoreCase("grwcgurdwr"))
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold red side towards you and green side above");
                    
                    RLI();
                    RD();
                    RL();
                    RF();
                    RD();
                    RD();
                    RFI();
                    System.out.println(LI);
                    System.out.println(D);
                    System.out.println(L);
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=7;
                }
                else if(a[7].equalsIgnoreCase("grwcwugdrr"))
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold yellow side towards you and green side above");
                    
                    YL();
                    YD();
                    YLI();
                    YBI();
                    YD();
                    YB();
                    System.out.println(L);
                    System.out.println(D);
                    System.out.println(LI);
                    System.out.println("Hold red side towards you and green side above");
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=6;
                }
                else
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold red side towards you and green side above");
                    
                    RLI();
                    RDI();
                    RL();
                    RF();
                    RDI();
                    RFI();
                    System.out.println(LI);
                    System.out.println(DI);
                    System.out.println(L);
                    System.out.println(F);
                    System.out.println(DI);
                    System.out.println(FI);
                    nm+=6;
                }
                break;
                case 8:
                if(a[8].equalsIgnoreCase("grwcgurdwr"))
                {
                    RL();
                    RDI();
                    RLI();
                    RRI();
                    RD();
                    RR();
                    System.out.println(L);
                    System.out.println(DI);
                    System.out.println(LI);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=6;
                }
                else if(a[8].equalsIgnoreCase("grwcwugdrr"))
                {
                    RFI();
                    RD();
                    RF();
                    RRI();
                    RD();
                    RR();
                    System.out.println(FI);
                    System.out.println(D);
                    System.out.println(F);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=6;
                }
                else
                {
                    RFI();
                    RDI();
                    RF();
                    RF();
                    RD();
                    RD();
                    RFI();
                    System.out.println(FI);
                    System.out.println(DI);
                    System.out.println(F);
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=7;
                }
                break;
                case 17:
                if(a[17].equalsIgnoreCase("grwcgurdwr"))
                {
                    RDI();
                    RRI();
                    RD();
                    RR();
                    System.out.println(DI);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=4;
                }
                else if(a[17].equalsIgnoreCase("grwcwugdrr"))
                {
                    RRI();
                    RD();
                    RR();
                    RF();
                    RD();
                    RD();
                    RFI();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=7;
                }
                else
                {
                    RRI();
                    RDI();
                    RR();
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    nm+=3;
                }
                break;
                case 18:
                if(a[18].equalsIgnoreCase("grwcgurdwr"))
                {
                    RD();
                    RD();
                    RRI();
                    RD();
                    RR();
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=5;
                }
                else if(a[18].equalsIgnoreCase("grwcwugdrr"))
                {
                    RR();
                    RDI();
                    RR();
                    RR();
                    RD();
                    RR();
                    System.out.println(R);
                    System.out.println(DI);
                    System.out.println(R);
                    System.out.println(R);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=6;
                }
                else
                {
                    RF();
                    RDI();
                    RFI();
                    System.out.println(F);
                    System.out.println(DI);
                    System.out.println(FI);
                    nm+=3;
                }
                break;
                case 19:
                if(a[19].equalsIgnoreCase("grwcgurdwr"))
                {
                    RRI();
                    RD();
                    RD();
                    RR();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=4;
                }
                else if(a[19].equalsIgnoreCase("grwcwugdrr"))
                {
                    RLI();
                    RD();
                    RL();
                    RD();
                    RF();
                    RDI();
                    RFI();
                    System.out.println(LI);
                    System.out.println(D);
                    System.out.println(L);
                    System.out.println(D);
                    System.out.println(F);
                    System.out.println(DI);
                    System.out.println(FI);
                    nm+=7;
                }
                else
                {
                    RF();
                    RD();
                    RD();
                    RFI();
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=4;
                }
                break;
                default :
                if(a[20].equalsIgnoreCase("grwcgurdwr"))
                {
                    RRI();
                    RD();
                    RR();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=3;
                }
                else if(a[20].equalsIgnoreCase("grwcwugdrr"))
                {
                    RFI();
                    RD();
                    RF();
                    RF();
                    RDI();
                    RFI();
                    System.out.println(FI);
                    System.out.println(D);
                    System.out.println(F);
                    System.out.println(F);
                    System.out.println(DI);
                    System.out.println(FI);
                    nm+=6;
                }
                else
                {
                    RD();
                    RRI();
                    RDI();
                    RR();
                    System.out.println(D);
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    nm+=4;
                }
            }
        }
        //second step. To Bring the green-orange-white corner piece in the correct position.
        for(i=6;i<21;i++)
        {
            if(a[i].substring(0,4).equalsIgnoreCase("gowc"))
            {
                se = i;
                break;
            }
        }
        if(!(a[6].equalsIgnoreCase("gowcguwdor")))
        {
            nms++;
            if(se != 7 && se != 8)
            {
                System.out.println("Moveset "+nms+" :");
                System.out.println("Hold white side towards you and green side above");
            }
            switch(se)
            {
                case 6:
                if(a[6].equalsIgnoreCase("gwocougdwr"))
                {
                    WRI();
                    WD();
                    WR();
                    WDI();
                    WRI();
                    WD();
                    WR();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(DI);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=7;
                }
                else
                {
                    WRI();
                    WDI();
                    WR();
                    WD();
                    WRI();
                    WDI();
                    WR();
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    System.out.println(D);
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    nm+=7;
                }
                break;
                case 7:
                if(a[7].equalsIgnoreCase("gowcguwdor"))
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold orange side towards you and green side above");
                    
                    ORI();
                    OD();
                    OR();
                    OL();
                    ODI();
                    OLI();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(L);
                    System.out.println(DI);
                    System.out.println(LI);
                    nm+=6;
                }
                else if(a[7].equalsIgnoreCase("gowcougdwr"))
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold white side towards you and green side above");
                    
                    WR();
                    WD();
                    WD();
                    WR();
                    WR();
                    WD();
                    WRI();
                    System.out.println(R);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(R);
                    System.out.println(D);
                    System.out.println(RI);
                    nm+=7;
                }
                else
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold white side towards you and green side above");
                    
                    WR();
                    WDI();
                    WRI();
                    WF();
                    WDI();
                    WFI();
                    System.out.println(R);
                    System.out.println(DI);
                    System.out.println(RI);
                    System.out.println(F);
                    System.out.println(DI);
                    System.out.println(FI);
                    nm+=6;
                }
                break;
                case 8:
                if(a[8].equalsIgnoreCase("gowcwguwdor"))
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold white side towards you and green side above");
                    
                    WLI();
                    WD();
                    WL();
                    WF();
                    WD();
                    WD();
                    WFI();
                    System.out.println(LI);
                    System.out.println(D);
                    System.out.println(L);
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=7;
                }
                else if(a[8].equalsIgnoreCase("gowcougdwr"))
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold red side towards you and green side above");
                    
                    RL();
                    RD();
                    RLI();
                    RBI();
                    RD();
                    RB();
                    System.out.println(L);
                    System.out.println(D);
                    System.out.println(LI);
                    System.out.println("Hold white side towards you and green side above");
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=6;
                }
                else
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold white side towards you and green side above");
                    
                    WLI();
                    WDI();
                    WL();
                    WF();
                    WDI();
                    WFI();
                    System.out.println(LI);
                    System.out.println(DI);
                    System.out.println(L);
                    System.out.println(F);
                    System.out.println(DI);
                    System.out.println(FI);
                    nm+=6;
                }
                break;
                case 17:
                if(a[17].equalsIgnoreCase("gowcguwdor"))
                {
                    WRI();
                    WD();
                    WR();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=3;
                }
                else if(a[17].equalsIgnoreCase("gowcougdwr"))
                {
                    WD();
                    WRI();
                    WD();
                    WR();
                    WF();
                    WD();
                    WD();
                    WFI();
                    System.out.println(D);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=8;
                }
                else
                {
                    WD();
                    WRI();
                    WDI();
                    WR();
                    System.out.println(D);
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    nm+=4;
                }
                break;
                case 18:
                if(a[18].equalsIgnoreCase("gowcguwdor"))
                {
                    WDI();
                    WRI();
                    WD();
                    WR();
                    System.out.println(DI);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=4;
                }
                else if(a[18].equalsIgnoreCase("gowcougdwr"))
                {
                    WRI();
                    WD();
                    WR();
                    WF();
                    WD();
                    WD();
                    WFI();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=7;
                }
                else
                {
                    WRI();
                    WDI();
                    WR();
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    nm+=3;
                }
                break;
                case 19:
                if(a[19].equalsIgnoreCase("gowcguwdor"))
                {
                    WD();
                    WD();
                    WRI();
                    WD();
                    WR();
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=5;
                }
                else if(a[19].equalsIgnoreCase("gowcougdwr"))
                {
                    WR();
                    WDI();
                    WR();
                    WR();
                    WD();
                    WR();
                    System.out.println(R);
                    System.out.println(DI);
                    System.out.println(R);
                    System.out.println(R);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=6;
                }
                else
                {
                    WF();
                    WDI();
                    WFI();
                    System.out.println(F);
                    System.out.println(DI);
                    System.out.println(FI);
                    nm+=3;
                }
                break;
                default :
                if(a[20].equalsIgnoreCase("gowcguwdor"))
                {
                    WRI();
                    WD();
                    WD();
                    WR();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=4;
                }
                else if(a[20].equalsIgnoreCase("gowcougdwr"))
                {
                    WLI();
                    WD();
                    WL();
                    WD();
                    WF();
                    WDI();
                    WFI();
                    System.out.println(LI);
                    System.out.println(D);
                    System.out.println(L);
                    System.out.println(D);
                    System.out.println(F);
                    System.out.println(DI);
                    System.out.println(FI);
                    nm+=7;
                }
                else
                {
                    WF();
                    WD();
                    WD();
                    WFI();
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=4;
                }
            }
        }
        //third step. To Bring the green-orange-yellow corner piece in the correct position.
        for(i=7;i<21;i++)
        {
            if(a[i].substring(0,4).equalsIgnoreCase("goyc"))
            {
                se = i;
                break;
            }
        }
        if(!(a[7].equalsIgnoreCase("goycguodyr")))
        {
            nms++;
            if(se != 8)
            {
                System.out.println("Moveset "+nms+" :");
                System.out.println("Hold orange side towards you and green side above");
            }
            switch(se)
            {
                case 7:
                if(a[7].equalsIgnoreCase("goycwyugdor"))
                {
                    ORI();
                    OD();
                    OR();
                    ODI();
                    ORI();
                    OD();
                    OR();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(DI);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=7;
                }
                else
                {
                    ORI();
                    ODI();
                    OR();
                    OD();
                    ORI();
                    ODI();
                    OR();
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    System.out.println(D);
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    nm+=7;
                }
                break;
                case 8:
                if(a[8].equalsIgnoreCase("goycguodyr"))
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold yellow side towards you and green side above");
                    
                    YRI();
                    YD();
                    YR();
                    YL();
                    YDI();
                    YLI();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(L);
                    System.out.println(DI);
                    System.out.println(LI);
                    nm+=6;
                }
                else if(a[8].equalsIgnoreCase("goycyugdor"))
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold orange side towards you and green side above");
                    
                    OR();
                    OD(); 
                    OD();
                    OR();
                    OR();
                    OD();
                    ORI();
                    System.out.println(R);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(R);
                    System.out.println(D);
                    System.out.println(RI);
                    nm+=7;
                }
                else
                {
                    System.out.println("Moveset "+nms+" :");
                    System.out.println("Hold orange side towards you and green side above");
                    
                    OR();
                    ODI();
                    ORI();
                    OF();
                    ODI();
                    OFI();
                    System.out.println(R);
                    System.out.println(DI);
                    System.out.println(RI);
                    System.out.println(F);
                    System.out.println(DI);
                    System.out.println(FI);
                    nm+=6;
                }
                break;
                case 17:
                if(a[17].equalsIgnoreCase("goycguodyr"))
                {
                    ORI();
                    OD();
                    OD();
                    OR();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=4;
                }
                else if(a[17].equalsIgnoreCase("goycyugdor"))
                {
                    OD();
                    OD();
                    System.out.println(D);
                    System.out.println(D);
                    ORI();
                    OD();
                    OR();
                    OF();
                    OD();
                    OD();
                    OFI();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=9;
                }
                else
                {
                    OF();
                    OD();
                    OD();
                    OFI();
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=4;
                }
                break;
                case 18:
                if(a[18].equalsIgnoreCase("goycguodyr"))
                {
                    ORI();
                    OD();
                    OR();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=3;
                }
                else if(a[18].equalsIgnoreCase("goycyugdor"))
                {
                    OD();
                    ORI();
                    OD();
                    OR();
                    OF();
                    OD();
                    OD();
                    OFI();
                    System.out.println(D);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=8;
                }
                else
                {
                    OD();
                    ORI();
                    ODI();
                    OR();
                    System.out.println(D);
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    nm+=4;
                }
                break;
                case 19:
                if(a[19].equalsIgnoreCase("goycguodyr"))
                {
                    ODI();
                    ORI();
                    OD();
                    OR();
                    System.out.println(DI);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=4;
                }
                else if(a[19].equalsIgnoreCase("goycyugdor"))
                {
                    ORI();
                    OD();
                    OR();
                    OF();
                    OD();
                    OD();
                    OFI();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=7;
                }
                else
                {
                    ORI();
                    ODI();
                    OR();
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    nm+=3;
                }
                break;
                default :
                if(a[20].equalsIgnoreCase("goycguodyr"))
                {
                    OD();
                    OD();
                    ORI();
                    OD();
                    OR();
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=5;
                }
                else if(a[20].equalsIgnoreCase("goycyugdor"))
                {
                    OR();
                    ODI();
                    OR();
                    OR();
                    OD();
                    OR();
                    System.out.println(R);
                    System.out.println(DI);
                    System.out.println(R);
                    System.out.println(R);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=6;
                }
                else
                {
                    OF();
                    ODI();
                    OFI();
                    System.out.println(F);
                    System.out.println(DI);
                    System.out.println(FI);
                    nm+=3;
                }
            }
        }
        //fourth step. To Bring the green-red-yellow corner piece in the correct position.
        for(i=8;i<21;i++)
        {
            if(a[i].substring(0,4).equalsIgnoreCase("gryc"))
            {
                se = i;
                break;
            }
        }
        if(!(a[8].equalsIgnoreCase("grycguydrr")))
        {
            nms++;
            System.out.println("Moveset "+nms+" :");
            System.out.println("Hold yellow side towards you and green side above");
            switch(se)
            {
                case 8:
                if(a[8].equalsIgnoreCase("grycwrugdyr"))
                {
                    YRI();
                    YD();
                    YR();
                    YDI();
                    YRI();
                    YD();
                    YR();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(DI);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=7;
                }
                else
                {
                    YRI();
                    YDI();
                    YR();
                    YD();
                    YRI();
                    YDI();
                    YR();
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    System.out.println(D);
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    nm+=7;
                }
                break;
                case 17:
                if(a[17].equalsIgnoreCase("grycguydrr"))
                {
                    YD();
                    YD();
                    YRI();
                    YD();
                    YR();
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=5;
                }
                else if(a[17].equalsIgnoreCase("grycrugdyr"))
                {
                    YDI();
                    System.out.println(DI);
                    YRI();
                    YD();
                    YR();
                    YF();
                    YD();
                    YD();
                    YFI();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=7;
                }
                else
                {
                    YF();
                    YDI();
                    YFI();
                    System.out.println(F);
                    System.out.println(DI);
                    System.out.println(FI);
                    nm+=3;
                }
                break;
                case 18:
                if(a[18].equalsIgnoreCase("grycguydrr"))
                {
                    YRI();
                    YD();
                    YD();
                    YR();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=4;
                }
                else if(a[18].equalsIgnoreCase("grycrugdyr"))
                {
                    YD();
                    YD();
                    System.out.println(D);
                    System.out.println(D);
                    YRI();
                    YD();
                    YR();
                    YF();
                    YD();
                    YD();
                    YFI();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=9;
                }
                else
                {
                    YF();
                    YD();
                    YD();
                    YFI();
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=4;
                }
                break;
                case 19:
                if(a[19].equalsIgnoreCase("grycguydrr"))
                {
                    YRI();
                    YD();
                    YR();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=3;
                }
                else if(a[19].equalsIgnoreCase("grycrugdyr"))
                {
                    YD();
                    YRI();
                    YD();
                    YR();
                    YF();
                    YD();
                    YD();
                    YFI();
                    System.out.println(D);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=8;
                }
                else
                {
                    YD();
                    YRI();
                    YDI();
                    YR();
                    System.out.println(D);
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    nm+=4;
                }
                break;
                default :
                if(a[20].equalsIgnoreCase("grycguydrr"))
                {
                    YDI();
                    YRI();
                    YD();
                    YR();
                    System.out.println(DI);
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    nm+=4;
                }
                else if(a[20].equalsIgnoreCase("grycrugdyr"))
                {
                    YRI();
                    YD();
                    YR();
                    YF();
                    YD();
                    YD();
                    YFI();
                    System.out.println(RI);
                    System.out.println(D);
                    System.out.println(R);
                    System.out.println(F);
                    System.out.println(D);
                    System.out.println(D);
                    System.out.println(FI);
                    nm+=7;
                }
                else
                {
                    YRI();
                    YDI();
                    YR();
                    System.out.println(RI);
                    System.out.println(DI);
                    System.out.println(R);
                    nm+=3;
                }
            }
        }
        Display();
        CheckOne();
        //Buffer 1
        System.out.println("Enter any word/character to buffer the process");
        buffer1 = sc.next();
    }
    void SecondLayer()
    {
        if(a[9].equalsIgnoreCase("rwepwrrl"))
        c++;
        if(a[10].equalsIgnoreCase("oweporwl"))
        c++;
        if(a[11].equalsIgnoreCase("oyepyrol"))
        c++;
        if(a[12].equalsIgnoreCase("ryeprryl"))
        c++;
        while(c<4)
        {
            for(i=13;i<=16;i++)
            {
                if( (a[i].charAt(0)=='r' || a[i].charAt(0)=='w' || a[i].charAt(0)=='o' || a[i].charAt(0)=='y') && (a[i].charAt(1)=='r' || a[i].charAt(1)=='w' || a[i].charAt(1)=='o' || a[i].charAt(1)=='y') )
                {
                    sls = i;
                    slflag = true;
                    break;
                }
            }
            
            nms++;
            System.out.println("Moveset "+nms+ ":");
            
            if(slflag == false)
            {
                for(i=9;i<=12;i++)
                {
                    if( (a[i].charAt(0)=='r' || a[i].charAt(0)=='w' || a[i].charAt(0)=='o' || a[i].charAt(0)=='y') && (a[i].charAt(1)=='r' || a[i].charAt(1)=='w' || a[i].charAt(1)=='o' || a[i].charAt(1)=='y') )
                    {
                        if( (i == 9 && a[i].equalsIgnoreCase("rwepwrrl")) || (i == 10 && a[i].equalsIgnoreCase("oweporwl")) || (i == 11 && a[i].equalsIgnoreCase("oyepyrol")) || (i == 12 && a[i].equalsIgnoreCase("ryeprryl")))
                        continue;
                        else
                        {
                            sls = i;
                            break;
                        }
                    }
                }
                switch(sls)
                {
                    case 9:
                    if(a[9].compareTo("rwepwrrl")!=0)
                    {
                        RRI();
                        RD();
                        RR();
                        RD();
                        RF();
                        RDI();
                        RFI();
                        System.out.println("Hold the red side towards you keeping the green above");
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=7;
                    }
                    break;
                    case 10:
                    if(a[10].compareTo("oweporwl")!=0)
                    {
                        WRI();
                        WD();
                        WR();
                        WD();
                        WF();
                        WDI();
                        WFI();
                        System.out.println("Hold the white side towards you keeping the green above");
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=7;
                    }
                    break;
                    case 11:
                    if(a[11].compareTo("oyepyrol")!=0)
                    {
                        ORI();
                        OD();
                        OR();
                        OD();
                        OF();
                        ODI();
                        OFI();
                        System.out.println("Hold the orange side towards you keeping the green above");
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=7;
                    }
                    break;
                    default :
                    if(a[12].compareTo("ryeprryl")!=0)
                    {
                        YRI();
                        YD();
                        YR();
                        YD();
                        YF();
                        YDI();
                        YFI();
                        System.out.println("Hold the yellow side towards you keeping the green above");
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=7;
                    }
                }
                for(i=13;i<=16;i++)
                {
                    if( (a[i].charAt(0)=='r' || a[i].charAt(0)=='w' || a[i].charAt(0)=='o' || a[i].charAt(0)=='y') && (a[i].charAt(1)=='r' || a[i].charAt(1)=='w' || a[i].charAt(1)=='o' || a[i].charAt(1)=='y') )
                    {
                        sls = i;
                        slflag = true;
                        break;
                    }
                }   
            }
            
            if(slflag == true)//NO ELSE. Also, now the moveset-side_holding convention is reversed.
            {
                switch(sls)
                {
                    case 13:
                    c++;
                    if(a[13].equalsIgnoreCase("rwepruwd"))
                    {
                        System.out.println("Hold red side towards you and green side above");
                        
                        RDI();
                        RRI();
                        RD();
                        RR();
                        RD();
                        RF();
                        RDI();
                        RFI();
                        System.out.println(DI);
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=8;
                    }
                    else if(a[13].equalsIgnoreCase("rwepwurd"))
                    {
                        System.out.println("Hold white side towards you and green side above");
                        
                        WD();
                        WD();
                        WL();
                        WDI();
                        WLI();
                        WDI();
                        WFI();
                        WD();
                        WF();
                        System.out.println(D);
                        System.out.println(D);
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=9;
                    }
                    else if(a[13].equalsIgnoreCase("owepwuod"))
                    {
                        System.out.println("Hold white side towards you and green side above");
                        
                        WRI();
                        WD();
                        WR();
                        WD();
                        WF();
                        WDI();
                        WFI();
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=7;
                    }
                    else if(a[13].equalsIgnoreCase("owepouwd"))
                    {
                        System.out.println("Hold orange side towards you and green side above");
                        
                        ODI();
                        OL();
                        ODI();
                        OLI();
                        ODI();
                        OFI();
                        OD();
                        OF();
                        System.out.println(DI);
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=8;
                    }
                    else if(a[13].equalsIgnoreCase("oyepouyd"))
                    {
                        System.out.println("Hold orange side towards you and green side above");
                        
                        OD();
                        ORI();
                        OD();
                        OR();
                        OD();
                        OF();
                        ODI();
                        OFI();
                        System.out.println(D);
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=8;
                    }
                    else if(a[13].equalsIgnoreCase("oyepyuod"))
                    {
                        System.out.println("Hold yellow side towards you and green side above");
                        
                        YL();
                        YDI();
                        YLI();
                        YDI();
                        YFI();
                        YD();
                        YF();
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=7;
                    }
                    else if(a[13].equalsIgnoreCase("ryepyurd"))
                    {
                        System.out.println("Hold yellow side towards you and green side above");
                        
                        YD();
                        YD();
                        YRI();
                        YD();
                        YR();
                        YD();
                        YF();
                        YDI();
                        YFI();
                        System.out.println(D);
                        System.out.println(D);
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=9;
                    }
                    else
                    {
                        System.out.println("Hold red side towards you and green side above");
                        
                        RD();
                        RL();
                        RDI();
                        RLI();
                        RDI();
                        RFI();
                        RD();
                        RF();
                        System.out.println(D);
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=8;
                    }
                    break;
                    case 14:
                    c++;
                    if(a[14].equalsIgnoreCase("rwepruwd"))
                    {
                        System.out.println("Hold red side towards you and green side above");
                        
                        RD();
                        RD();
                        RRI();
                        RD();
                        RR();
                        RD();
                        RF();
                        RDI();
                        RFI();
                        System.out.println(D);
                        System.out.println(D);
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=9;
                    }
                    else if(a[14].equalsIgnoreCase("rwepwurd"))
                    {
                        System.out.println("Hold white side towards you and green side above");
                        
                        WD();
                        WL();
                        WDI();
                        WLI();
                        WDI();
                        WFI();
                        WD();
                        WF();
                        System.out.println(D);
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=8;
                    }
                    else if(a[14].equalsIgnoreCase("owepwuod"))
                    {
                        System.out.println("Hold white side towards you and green side above");
                        
                        WDI();
                        WRI();
                        WD();
                        WR();
                        WD();
                        WF();
                        WDI();
                        WFI();
                        System.out.println(DI);
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=8;
                    }
                    else if(a[14].equalsIgnoreCase("owepouwd"))
                    {
                        System.out.println("Hold orange side towards you and green side above");
                        
                        OD();
                        OD();
                        OL();
                        ODI();
                        OLI();
                        ODI();
                        OFI();
                        OD();
                        OF();
                        System.out.println(D);
                        System.out.println(D);
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=9;
                    }
                    else if(a[14].equalsIgnoreCase("oyepouyd"))
                    {
                        System.out.println("Hold orange side towards you and green side above");
                        
                        ORI();
                        OD();
                        OR();
                        OD();
                        OF();
                        ODI();
                        OFI();
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=7;
                    }
                    else if(a[14].equalsIgnoreCase("oyepyuod"))
                    {
                        System.out.println("Hold yellow side towards you and green side above");
                        
                        YDI();
                        YL();
                        YDI();
                        YLI();
                        YDI();
                        YFI();
                        YD();
                        YF();
                        System.out.println(DI);
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=8;
                    }
                    else if(a[14].equalsIgnoreCase("ryepyurd"))
                    {
                        System.out.println("Hold yellow side towards you and green side above");
                        
                        YD();
                        YRI();
                        YD();
                        YR();
                        YD();
                        YF();
                        YDI();
                        YFI();
                        System.out.println(D);
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=8;
                    }
                    else if(a[14].equalsIgnoreCase("ryepruyd"))
                    {
                        System.out.println("Hold red side towards you and green side above");
                        
                        RL();
                        RDI();
                        RLI();
                        RDI();
                        RFI();
                        RD();
                        RF();
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=7;
                    }
                    break;
                    case 15:
                    c++;
                    if(a[15].equalsIgnoreCase("rwepruwd"))
                    {
                        System.out.println("Hold red side towards you and green side above");
                        
                        RD();
                        RRI();
                        RD();
                        RR();
                        RD();
                        RF();
                        RDI();
                        RFI();
                        System.out.println(D);
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=8;
                    }
                    else if(a[15].equalsIgnoreCase("rwepwurd"))
                    {
                        System.out.println("Hold white side towards you and green side above");
                        
                        WL();
                        WDI();
                        WLI();
                        WDI();
                        WFI();
                        WD();
                        WF();
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=7;
                    }
                    else if(a[15].equalsIgnoreCase("owepwuod"))
                    {
                        System.out.println("Hold white side towards you and green side above");
                        
                        WD();
                        WD();
                        WRI();
                        WD();
                        WR();
                        WD();
                        WF();
                        WDI();
                        WFI();
                        System.out.println(D);
                        System.out.println(D);
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=9;
                    }
                    else if(a[15].equalsIgnoreCase("owepouwd"))
                    {
                        System.out.println("Hold orange side towards you and green side above");
                        
                        OD();
                        OL();
                        ODI();
                        OLI();
                        ODI();
                        OFI();
                        OD();
                        OF();
                        System.out.println(D);
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=8;
                    }
                    else if(a[15].equalsIgnoreCase("oyepouyd"))
                    {
                        System.out.println("Hold orange side towards you and green side above");
              
                        ODI();
                        ORI();
                        OD();
                        OR();
                        OD();
                        OF();
                        ODI();
                        OFI();
                        System.out.println(DI);
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=8;
                    }
                    else if(a[15].equalsIgnoreCase("oyepyuod"))
                    {
                        System.out.println("Hold yellow side towards you and green side above");
                        
                        YD();
                        YD();
                        YL();
                        YDI();
                        YLI();
                        YDI();
                        YFI();
                        YD();
                        YF();
                        System.out.println(D);
                        System.out.println(D);
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=9;
                    }
                    else if(a[15].equalsIgnoreCase("ryepyurd"))
                    {
                        System.out.println("Hold yellow side towards you and green side above");
                        
                        YRI();
                        YD();
                        YR();
                        YD();
                        YF();
                        YDI();
                        YFI();
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=7;
                    }
                    else if(a[15].equalsIgnoreCase("ryepruyd"))
                    {
                        System.out.println("Hold red side towards you and green side above");
                        
                        RDI();
                        RL();
                        RDI();
                        RLI();
                        RDI();
                        RFI();
                        RD();
                        RF();
                        System.out.println(DI);
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=8;
                    }
                    break;
                    default :
                    c++;
                    if(a[16].equalsIgnoreCase("rwepruwd"))
                    {
                        System.out.println("Hold red side towards you and green side above");
                        
                        RRI();
                        RD();
                        RR();
                        RD();
                        RF();
                        RDI();
                        RFI();
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=7;
                    }
                    else if(a[16].equalsIgnoreCase("rwepwurd"))
                    {
                        System.out.println("Hold white side towards you and green side above");
                        
                        WDI();
                        WL();
                        WDI();
                        WLI();
                        WDI();
                        WFI();
                        WD();
                        WF();
                        System.out.println(DI);
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=8;
                    }
                    else if(a[16].equalsIgnoreCase("owepwuod"))
                    {
                        System.out.println("Hold white side towards you and green side above");
                        
                        WD();
                        WRI();
                        WD();
                        WR();
                        WD();
                        WF();
                        WDI();
                        WFI();
                        System.out.println(D);
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=8;
                    }
                    else if(a[16].equalsIgnoreCase("owepouwd"))
                    {
                        System.out.println("Hold orange side towards you and green side above");
                        
                        OL();
                        ODI();
                        OLI();
                        ODI();
                        OFI();
                        OD();
                        OF();
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=7;
                    }
                    else if(a[16].equalsIgnoreCase("oyepouyd"))
                    {
                        System.out.println("Hold orange side towards you and green side above");
                        
                        OD();
                        OD();
                        ORI();
                        OD();
                        OR();
                        OD();
                        OF();
                        ODI();
                        OFI();
                        System.out.println(D);
                        System.out.println(D);
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=9;
                    }
                    else if(a[16].equalsIgnoreCase("oyepyuod"))
                    {
                        System.out.println("Hold yellow side towards you and green side above");
                        
                        YD();
                        YL();
                        YDI();
                        YLI();
                        YDI();
                        YFI();
                        YD();
                        YF();
                        System.out.println(D);
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=8;
                    }
                    else if(a[16].equalsIgnoreCase("ryepyurd"))
                    {
                        System.out.println("Hold yellow side towards you and green side above");
                        
                        YDI();
                        YRI();
                        YD();
                        YR();
                        YD();
                        YF();
                        YDI();
                        YFI();
                        System.out.println(DI);
                        System.out.println(RI);
                        System.out.println(D);
                        System.out.println(R);
                        System.out.println(D);
                        System.out.println(F);
                        System.out.println(DI);
                        System.out.println(FI);
                        nm+=8;
                    }
                    else
                    {
                        System.out.println("Hold red side towards you and green side above");
                        
                        RD();
                        RD();
                        RL();
                        RDI();
                        RLI();
                        RDI();
                        RFI();
                        RD();
                        RF();
                        System.out.println(D);
                        System.out.println(D);
                        System.out.println(L);
                        System.out.println(DI);
                        System.out.println(LI);
                        System.out.println(DI);
                        System.out.println(FI);
                        System.out.println(D);
                        System.out.println(F);
                        nm+=9;
                    }
                }
            }
            slflag = false;
        }
        Display();
        CheckOneTwo();
        //Buffer 2
        System.out.println("Enter any word/character to buffer the process");
        buffer2 = sc.next();
    }
    void ThirdLayerCross()
    {
        //First step. to get the blue cross.
        if(!(a[13].charAt(6)=='b' && a[14].charAt(6)=='b' && a[15].charAt(6)=='b' && a[16].charAt(6)=='b'))
        {
            nms++;
            System.out.println("Moveset "+nms+ ":");
            if(a[13].charAt(6)!='b' && a[14].charAt(6)!='b' && a[15].charAt(6)!='b' && a[16].charAt(6)!='b')
            {
                System.out.println("Hold red side towards you and blue side above");
                RF();
                RL();
                RD();
                RLI();
                RDI();
                RL();
                RD();
                RLI();
                RDI();
                RFI();
                System.out.println(F);
                System.out.println(R);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(R);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(FI);
                YF();
                YL();
                YD();
                YLI();
                YDI();
                YFI();
                System.out.println("Hold yellow side towards you and blue side above");
                System.out.println(F);
                System.out.println(R);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(FI);
                nm+=16;
            }
            else if(a[13].charAt(6)=='b' && a[14].charAt(6)!='b' && a[15].charAt(6)!='b' && a[16].charAt(6)=='b')
            {
                System.out.println("Hold red side towards you and blue side above");
                RF();
                RL();
                RD();
                RLI();
                RDI();
                RFI();
                System.out.println(F);
                System.out.println(R);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(FI);
                YF();
                YL();
                YD();
                YLI();
                YDI();
                YFI();
                System.out.println("Hold yellow side towards you and blue side above");
                System.out.println(F);
                System.out.println(R);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(FI);
                nm+=12;
            }
            else if(a[13].charAt(6)!='b' && a[14].charAt(6)!='b' && a[15].charAt(6)=='b' && a[16].charAt(6)=='b')
            {
                System.out.println("Hold yellow side towards you and blue side above");
                YF();
                YL();
                YD();
                YLI();
                YDI();
                YFI();
                System.out.println(F);
                System.out.println(R);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(FI);
                OF();
                OL();
                OD();
                OLI();
                ODI();
                OFI();
                System.out.println("Hold orange side towards you and blue side above");
                System.out.println(F);
                System.out.println(R);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(FI);
                nm+=12;
            }
            else if(a[13].charAt(6)!='b' && a[14].charAt(6)=='b' && a[15].charAt(6)=='b' && a[16].charAt(6)!='b')
            {
                System.out.println("Hold orange side towards you and blue side above");
                OF();
                OL();
                OD();
                OLI();
                ODI();
                OFI();
                System.out.println(F);
                System.out.println(R);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(FI);
                WF();
                WL();
                WD();
                WLI();
                WDI();
                WFI();
                System.out.println("Hold white side towards you and blue side above");
                System.out.println(F);
                System.out.println(R);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(FI);
                nm+=12;
            }
            else if(a[13].charAt(6)=='b' && a[14].charAt(6)=='b' && a[15].charAt(6)!='b' && a[16].charAt(6)!='b')
            {
                System.out.println("Hold white side towards you and blue side above");
                WF();
                WL();
                WD();
                WLI();
                WDI();
                WFI();
                System.out.println(F);
                System.out.println(R);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(FI);
                RF();
                RL();
                RD();
                RLI();
                RDI();
                RFI();
                System.out.println("Hold red side towards you and blue side above");
                System.out.println(F);
                System.out.println(R);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(FI);
                nm+=12;
            }
            else if(a[13].charAt(6)=='b' && a[14].charAt(6)!='b' && a[15].charAt(6)=='b' && a[16].charAt(6)!='b')
            {
                System.out.println("Hold yellow side towards you and blue side above");
                YF();
                YL();
                YD();
                YLI();
                YDI();
                YFI();
                System.out.println(F);
                System.out.println(R);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(FI);
                nm+=6;
            }
            else
            {
                System.out.println("Hold red side towards you and blue side above");
                RF();
                RL();
                RD();
                RLI();
                RDI();
                RFI();
                System.out.println(F);
                System.out.println(R);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(FI);
                nm+=6;
            }
        }
        //second step. To get the correct edge piece positions in the cross.
        if(!(a[13].charAt(4)=='r' && a[14].charAt(4)=='w' && a[15].charAt(4)=='o' && a[16].charAt(4)=='y'))
        {
            nms++;
            System.out.println("Moveset "+nms+ ":");
            while(b<=4)
            {
                if((a[13].charAt(4)=='r' && a[14].charAt(4)!='w' && a[15].charAt(4)=='o' && a[16].charAt(4)!='y') || (a[13].charAt(4)!='r' && a[14].charAt(4)=='w' && a[15].charAt(4)!='o' && a[16].charAt(4)=='y') || (a[13].charAt(4)=='r' && a[14].charAt(4)!='w' && a[15].charAt(4)!='o' && a[16].charAt(4)=='y') || (a[13].charAt(4)!='r' && a[14].charAt(4)!='w' && a[15].charAt(4)=='o' && a[16].charAt(4)=='y') || (a[13].charAt(4)!='r' && a[14].charAt(4)=='w' && a[15].charAt(4)=='o' && a[16].charAt(4)!='y') || (a[13].charAt(4)=='r' && a[14].charAt(4)=='w' && a[15].charAt(4)!='o' && a[16].charAt(4)!='y') )
                break;
                else
                {
                    RD();
                    System.out.println("Hold red side towards you and blue side above");
                    System.out.println(U);
                    b++;
                }
            }
            
            if(a[13].charAt(4)=='r' && a[14].charAt(4)!='w' && a[15].charAt(4)=='o' && a[16].charAt(4)!='y')
            {
                System.out.println("Hold red side towards you and blue side above");
                RL();
                RD();
                RD();
                RLI();
                RDI();
                RL();
                RDI();
                RLI();
                System.out.println(R);
                System.out.println(U);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(R);
                System.out.println(UI);
                System.out.println(RI);
                System.out.println("Hold yellow side towards you and blue side above");
                YL();
                YD();
                YD();
                YLI();
                YDI();
                YL();
                YDI();
                YLI();
                YDI();
                System.out.println(R);
                System.out.println(U);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(R);
                System.out.println(UI);
                System.out.println(RI);
                System.out.println(UI);
                nm+=17;
            }
            else if(a[13].charAt(4)!='r' && a[14].charAt(4)=='w' && a[15].charAt(4)!='o' && a[16].charAt(4)=='y')
            {
                System.out.println("Hold yellow side towards you and blue side above");
                YL();
                YD();
                YD();
                YLI();
                YDI();
                YL();
                YDI();
                YLI();
                System.out.println(R);
                System.out.println(U);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(R);
                System.out.println(UI);
                System.out.println(RI);
                System.out.println("Hold orange side towards you and blue side above");
                OL();
                OD();
                OD();
                OLI();
                ODI();
                OL();
                ODI();
                OLI();
                ODI();
                System.out.println(R);
                System.out.println(U);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(R);
                System.out.println(UI);
                System.out.println(RI);
                System.out.println(UI);
                nm+=17;
            }
            else if(a[13].charAt(4)=='r' && a[14].charAt(4)!='w' && a[15].charAt(4)!='o' && a[16].charAt(4)=='y')
            {
                System.out.println("Hold orange side towards you and blue side above");
                OL();
                OD();
                OD();
                OLI();
                ODI();
                OL();
                ODI();
                OLI();
                ODI();
                System.out.println(R);
                System.out.println(U);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(R);
                System.out.println(UI);
                System.out.println(RI);
                System.out.println(UI);
                nm+=9;
            }
            else if(a[13].charAt(4)!='r' && a[14].charAt(4)!='w' && a[15].charAt(4)=='o' && a[16].charAt(4)=='y')
            {
                System.out.println("Hold white side towards you and blue side above");
                WL();
                WD();
                WD();
                WLI();
                WDI();
                WL();
                WDI();
                WLI();
                WDI();
                System.out.println(R);
                System.out.println(U);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(R);
                System.out.println(UI);
                System.out.println(RI);
                System.out.println(UI);
                nm+=9;
            }
            else if(a[13].charAt(4)!='r' && a[14].charAt(4)=='w' && a[15].charAt(4)=='o' && a[16].charAt(4)!='y')
            {
                System.out.println("Hold red side towards you and blue side above");
                RL();
                RD();
                RD();
                RLI();
                RDI();
                RL();
                RDI();
                RLI();
                RDI();
                System.out.println(R);
                System.out.println(U);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(R);
                System.out.println(UI);
                System.out.println(RI);
                System.out.println(UI);
                nm+=9;
            }
            else if(a[13].charAt(4)=='r' && a[14].charAt(4)=='w' && a[15].charAt(4)!='o' && a[16].charAt(4)!='y')
            {
                System.out.println("Hold yellow side towards you and blue side above");
                YL();
                YD();
                YD();
                YLI();
                YDI();
                YL();
                YDI();
                YLI();
                YDI();
                System.out.println(R);
                System.out.println(U);
                System.out.println(U);
                System.out.println(RI);
                System.out.println(UI);
                System.out.println(R);
                System.out.println(UI);
                System.out.println(RI);
                System.out.println(UI);
                nm+=9;
            }
        }
    }
    void ThirdLayerCorners()
    {
        //First step. To get the corner pieces in the correct location.
        if(!(a[17].substring(0,4).equalsIgnoreCase("brwc") && a[18].substring(0,4).equalsIgnoreCase("bowc") && a[19].substring(0,4).equalsIgnoreCase("boyc") && a[20].substring(0,4).equalsIgnoreCase("bryc")))
        {
            nms++;
            System.out.println("Moveset "+nms+ ":");
            
            while(true)
            {
                if(a[17].substring(0,4).equalsIgnoreCase("brwc") && a[18].substring(0,4).equalsIgnoreCase("bowc") && a[19].substring(0,4).equalsIgnoreCase("boyc") && a[20].substring(0,4).equalsIgnoreCase("bryc"))
                break;
                else
                {
                    if(a[20].substring(0,4).equalsIgnoreCase("bryc"))
                    {
                        System.out.println("Hold the red side towards you keeping the blue side above");
                        RRI();
                        RD();
                        RL();
                        RDI();
                        RR();
                        RD();
                        RLI();
                        RDI();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        nm+=8;
                    }
                    else if(a[17].substring(0,4).equalsIgnoreCase("brwc"))
                    {
                        System.out.println("Hold the white side towards you keeping the blue side above");
                        WRI();
                        WD();
                        WL();
                        WDI();
                        WR();
                        WD();
                        WLI();
                        WDI();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        nm+=8;
                    }
                    else if(a[18].substring(0,4).equalsIgnoreCase("bowc"))
                    {
                        System.out.println("Hold the orange side towards you keeping the blue side above");
                        ORI();
                        OD();
                        OL();
                        ODI();
                        OR();
                        OD();
                        OLI();
                        ODI();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        nm+=8;
                    }
                    else if(a[19].substring(0,4).equalsIgnoreCase("boyc"))
                    {
                        System.out.println("Hold the yellow side towards you keeping the blue side above");
                        YRI();
                        YD();
                        YL();
                        YDI();
                        YR();
                        YD();
                        YLI();
                        YDI();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        nm+=8;
                    }
                    else
                    {
                        System.out.println("Hold the red side towards you keeping the blue side above");
                        RRI();
                        RD();
                        RL();
                        RDI();
                        RR();
                        RD();
                        RLI();
                        RDI();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        nm+=8;
                    }
                }
            }
        }
        //Second step. last step. last layer corner piece orientation correction.
        if(!(a[17].substring(4).equalsIgnoreCase("rubdwr") && a[18].substring(4).equalsIgnoreCase("wubdor") && a[19].substring(4).equalsIgnoreCase("oubdyr") && a[20].substring(4).equalsIgnoreCase("yubdrr")))
        {
            nms++;
            System.out.println("Moveset "+nms+ ":");
            
            b = 0;
            
            while(true)
            {
                if(a[17].substring(4).equalsIgnoreCase("rubdwr") && a[18].substring(4).equalsIgnoreCase("wubdor") && a[19].substring(4).equalsIgnoreCase("oubdyr") && a[20].substring(4).equalsIgnoreCase("yubdrr"))
                break;
                if(a[20].charAt(4) == 'b' && a[19].charAt(8) == 'b')
                {
                    System.out.println("Hold the red side towards you while keeping the blue side above");
                    RL();
                    RD();
                    RD();
                    RLI();
                    RDI();
                    RL();
                    RDI();
                    RLI();
                    System.out.println(R);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(RI);
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(UI);
                    System.out.println(RI);
                    RRI();
                    RD();
                    RD();
                    RR();
                    RD();
                    RRI();
                    RD();
                    RR();
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(L);
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(L);
                    nm+=16;
                }
                if(a[19].charAt(4) == 'b' && a[18].charAt(8) == 'b')
                {
                    System.out.println("Hold the yellow side towards you while keeping the blue side above");
                    YL();
                    YD();
                    YD();
                    YLI();
                    YDI();
                    YL();
                    YDI();
                    YLI();
                    System.out.println(R);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(RI);
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(UI);
                    System.out.println(RI);
                    YRI();
                    YD();
                    YD();
                    YR();
                    YD();
                    YRI();
                    YD();
                    YR();
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(L);
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(L);
                    nm+=16;
                }
                if(a[18].charAt(4) == 'b' && a[17].charAt(8) == 'b')
                {
                    System.out.println("Hold the orange side towards you while keeping the blue side above");
                    OL();
                    OD();
                    OD();
                    OLI();
                    ODI();
                    OL();
                    ODI();
                    OLI();
                    System.out.println(R);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(RI);
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(UI);
                    System.out.println(RI);
                    ORI();
                    OD();
                    OD();
                    OR();
                    OD();
                    ORI();
                    OD();
                    OR();
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(L);
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(L);
                    nm+=16;
                }
                if(a[17].charAt(4) == 'b' && a[20].charAt(8) == 'b')
                {
                    System.out.println("Hold the white side towards you while keeping the blue side above");
                    WL();
                    WD();
                    WD();
                    WLI();
                    WDI();
                    WL();
                    WDI();
                    WLI();
                    System.out.println(R);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(RI);
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(UI);
                    System.out.println(RI);
                    WRI();
                    WD();
                    WD();
                    WR();
                    WD();
                    WRI();
                    WD();
                    WR();
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(L);
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(L);
                    nm+=16;
                }
                if(a[20].charAt(8) == 'b' && a[19].charAt(4) == 'b' && a[17].charAt(6) == 'b' && a[18].charAt(6) == 'b')
                {
                    System.out.println("Hold the red side towards you while keeping the blue side above");
                    RL();
                    RD();
                    RD();
                    RLI();
                    RDI();
                    RL();
                    RDI();
                    RLI();
                    System.out.println(R);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(RI);
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(UI);
                    System.out.println(RI);
                    RRI();
                    RD();
                    RD();
                    RR();
                    RD();
                    RRI();
                    RD();
                    RR();
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(L);
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(L);
                    RL();
                    RD();
                    RD();
                    RLI();
                    RDI();
                    RL();
                    RDI();
                    RLI();
                    System.out.println(R);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(RI);
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(UI);
                    System.out.println(RI);
                    RRI();
                    RD();
                    RD();
                    RR();
                    RD();
                    RRI();
                    RD();
                    RR();
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(L);
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(L);
                    nm+=32;
                }
                if(a[19].charAt(8) == 'b' && a[18].charAt(4) == 'b' && a[17].charAt(6) == 'b' && a[20].charAt(6) == 'b')
                {
                    System.out.println("Hold the yellow side towards you while keeping the blue side above");
                    YL();
                    YD();
                    YD();
                    YLI();
                    YDI();
                    YL();
                    YDI();
                    YLI();
                    System.out.println(R);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(RI);
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(UI);
                    System.out.println(RI);
                    YRI();
                    YD();
                    YD();
                    YR();
                    YD();
                    YRI();
                    YD();
                    YR();
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(L);
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(L);
                    YL();
                    YD();
                    YD();
                    YLI();
                    YDI();
                    YL();
                    YDI();
                    YLI();
                    System.out.println(R);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(RI);
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(UI);
                    System.out.println(RI);
                    YRI();
                    YD();
                    YD();
                    YR();
                    YD();
                    YRI();
                    YD();
                    YR();
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(L);
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(L);
                    nm+=32;
                }
                if(a[18].charAt(8) == 'b' && a[17].charAt(4) == 'b' && a[19].charAt(6) == 'b' && a[20].charAt(6) == 'b')
                {
                    System.out.println("Hold the orange side towards you while keeping the blue side above");
                    OL();
                    OD();
                    OD();
                    OLI();
                    ODI();
                    OL();
                    ODI();
                    OLI();
                    System.out.println(R);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(RI);
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(UI);
                    System.out.println(RI);
                    ORI();
                    OD();
                    OD();
                    OR();
                    OD();
                    ORI();
                    OD();
                    OR();
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(L);
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(L);
                    OL();
                    OD();
                    OD();
                    OLI();
                    ODI();
                    OL();
                    ODI();
                    OLI();
                    System.out.println(R);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(RI);
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(UI);
                    System.out.println(RI);
                    ORI();
                    OD();
                    OD();
                    OR();
                    OD();
                    ORI();
                    OD();
                    OR();
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(L);
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(L);
                    nm+=32;
                }
                if(a[17].charAt(8) == 'b' && a[20].charAt(4) == 'b' && a[18].charAt(6) == 'b' && a[19].charAt(6) == 'b')
                {
                    System.out.println("Hold the white side towards you while keeping the blue side above");
                    WL();
                    WD();
                    WD();
                    WLI();
                    WDI();
                    WL();
                    WDI();
                    WLI();
                    System.out.println(R);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(RI);
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(UI);
                    System.out.println(RI);
                    WRI();
                    WD();
                    WD();
                    WR();
                    WD();
                    WRI();
                    WD();
                    WR();
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(L);
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(L);
                    WL();
                    WD();
                    WD();
                    WLI();
                    WDI();
                    WL();
                    WDI();
                    WLI();
                    System.out.println(R);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(RI);
                    System.out.println(UI);
                    System.out.println(R);
                    System.out.println(UI);
                    System.out.println(RI);
                    WRI();
                    WD();
                    WD();
                    WR();
                    WD();
                    WRI();
                    WD();
                    WR();
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(U);
                    System.out.println(L);
                    System.out.println(U);
                    System.out.println(LI);
                    System.out.println(U);
                    System.out.println(L);
                    nm+=32;
                }
                else if(a[17].charAt(6) == 'b' && a[20].charAt(6) != 'b')
                {
                    if(a[20].charAt(4) == 'b')
                    {
                        System.out.println("Hold the red side towards you while keeping the blue side above");
                        RL();
                        RD();
                        RD();
                        RLI();
                        RDI();
                        RL();
                        RDI();
                        RLI();
                        System.out.println(R);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(RI);
                        RRI();
                        RD();
                        RD();
                        RR();
                        RD();
                        RRI();
                        RD();
                        RR();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(L);
                        nm+=16;
                    }
                    else
                    {
                        System.out.println("Hold the red side towards you while keeping the blue side above");
                        RL();
                        RD();
                        RD();
                        RLI();
                        RDI();
                        RL();
                        RDI();
                        RLI();
                        System.out.println(R);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(RI);
                        RRI();
                        RD();
                        RD();
                        RR();
                        RD();
                        RRI();
                        RD();
                        RR();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(L);
                        RL();
                        RD();
                        RD();
                        RLI();
                        RDI();
                        RL();
                        RDI();
                        RLI();
                        System.out.println(R);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(RI);
                        RRI();
                        RD();
                        RD();
                        RR();
                        RD();
                        RRI();
                        RD();
                        RR();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(L);
                        nm+=32;
                    }
                }
                else if(a[20].charAt(6) == 'b' && a[19].charAt(6) != 'b')
                {
                    if(a[19].charAt(4) == 'b')
                    {
                        System.out.println("Hold the yellow side towards you while keeping the blue side above");
                        YL();
                        YD();
                        YD();
                        YLI();
                        YDI();
                        YL();
                        YDI();
                        YLI();
                        System.out.println(R);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(RI);
                        YRI();
                        YD();
                        YD();
                        YR();
                        YD();
                        YRI();
                        YD();
                        YR();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(L);
                        nm+=16;
                    }
                    else
                    {
                        System.out.println("Hold the yellow side towards you while keeping the blue side above");
                        YL();
                        YD();
                        YD();
                        YLI();
                        YDI();
                        YL();
                        YDI();
                        YLI();
                        System.out.println(R);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(RI);
                        YRI();
                        YD();
                        YD();
                        YR();
                        YD();
                        YRI();
                        YD();
                        YR();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(L);
                        YL();
                        YD();
                        YD();
                        YLI();
                        YDI();
                        YL();
                        YDI();
                        YLI();
                        System.out.println(R);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(RI);
                        YRI();
                        YD();
                        YD();
                        YR();
                        YD();
                        YRI();
                        YD();
                        YR();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(L);
                        nm+=32;
                    }
                }
                else if(a[19].charAt(6) == 'b' && a[18].charAt(6) != 'b')
                {
                    if(a[18].charAt(4) == 'b')
                    {
                        System.out.println("Hold the orange side towards you while keeping the blue side above");
                        OL();
                        OD();
                        OD();
                        OLI();
                        ODI();
                        OL();
                        ODI();
                        OLI();
                        System.out.println(R);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(RI);
                        ORI();
                        OD();
                        OD();
                        OR();
                        OD();
                        ORI();
                        OD();
                        OR();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(L);
                        nm+=16;
                    }
                    else
                    {
                        System.out.println("Hold the orange side towards you while keeping the blue side above");
                        OL();
                        OD();
                        OD();
                        OLI();
                        ODI();
                        OL();
                        ODI();
                        OLI();
                        System.out.println(R);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(RI);
                        ORI();
                        OD();
                        OD();
                        OR();
                        OD();
                        ORI();
                        OD();
                        OR();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(L);
                        OL();
                        OD();
                        OD();
                        OLI();
                        ODI();
                        OL();
                        ODI();
                        OLI();
                        System.out.println(R);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(RI);
                        ORI();
                        OD();
                        OD();
                        OR();
                        OD();
                        ORI();
                        OD();
                        OR();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(L);
                        nm+=32;
                    }
                }
                else if(a[18].charAt(6) == 'b' && a[17].charAt(6) != 'b')
                {
                    if(a[17].charAt(4) == 'b')
                    {
                        System.out.println("Hold the white side towards you while keeping the blue side above");
                        WL();
                        WD();
                        WD();
                        WLI();
                        WDI();
                        WL();
                        WDI();
                        WLI();
                        System.out.println(R);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(RI);
                        WRI();
                        WD();
                        WD();
                        WR();
                        WD();
                        WRI();
                        WD();
                        WR();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(L);
                        nm+=16;
                    }
                    else
                    {
                        System.out.println("Hold the white side towards you while keeping the blue side above");
                        WL();
                        WD();
                        WD();
                        WLI();
                        WDI();
                        WL();
                        WDI();
                        WLI();
                        System.out.println(R);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(RI);
                        WRI();
                        WD();
                        WD();
                        WR();
                        WD();
                        WRI();
                        WD();
                        WR();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(L);
                        WL();
                        WD();
                        WD();
                        WLI();
                        WDI();
                        WL();
                        WDI();
                        WLI();
                        System.out.println(R);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(RI);
                        System.out.println(UI);
                        System.out.println(R);
                        System.out.println(UI);
                        System.out.println(RI);
                        WRI();
                        WD();
                        WD();
                        WR();
                        WD();
                        WRI();
                        WD();
                        WR();
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(U);
                        System.out.println(L);
                        System.out.println(U);
                        System.out.println(LI);
                        System.out.println(U);
                        System.out.println(L);
                        nm+=32;
                    }
                }
            }
        }
        Display();
        MainCheck();
    }
    void CheckOne()
    {
        for(i=1;i<=8;i++)
        {
            if(a[i].equalsIgnoreCase(a_solved[i]))
            continue;
            else 
            {
                check1 = false;
                break;
            }
        }
        if(check1 == true)
        System.out.println("It is safe to carry on.");
        else
        System.out.println("Do not carry on, there seems to be an error.");
    }
    void CheckOneTwo()
    {
        for(i=1;i<=12;i++)
        {
            if(a[i].equalsIgnoreCase(a_solved[i]))
            continue;
            else 
            {
                check12 = false;
                break;
            }
        }
        if(check12 == true)
        System.out.println("You can carry on to step three.");
        else
        System.out.println("Sorry, do not carry on, there seems to be an error");
    }
    void CheckOneTwoThree()
    {
        for(i=1;i<=20;i++)
        {
            if(a[i].equalsIgnoreCase(a_solved[i]))
            continue;
            else 
            {
                check123 = false;
                break;
            }
        }
        if(check123 == true)
        System.out.println("Thre rubix cube is solved :D");
        else
        System.out.println("The cube is unsolved, there seems to be an error :(((((");
    }
    void Display()
    {
        for(i=1;i<21;i++)
        System.out.print("Rubix cube member at "+i+" is " +a[i]+" ");
        
        System.out.println();
    }
    //Main stuff.
    void MainCheck()
    {
        for(i=1;i<=20;i++)
        {
            if(a[i].equalsIgnoreCase(a_solved[i]))
            continue;
            else
            {
                mainflag = false;
                break;
            }
        }
        if(mainflag == true)
        {
            System.out.println("Thre rubix cube is solved :D");
            System.out.println("It took "+nms+" movesets which included "+nm+" moves.");
        }
        else
        System.out.println("The cube is unsolved, there seems to be an error :(((((");
    }
    void MainDisplay()
    {
        System.out.println("                          Welcome to Rubix cubing solving program                                      ");
        System.out.println("Basics of the rubix cube :-");
        System.out.println("Observe the cube, there are 26 pieces and 20 moveable pieces.");
        System.out.println("The central pieces are not moveable, they are called center pieces");
        System.out.println("They will always remain opposite to a certain center piece and the right and left center pieces always remain constant with respect to another colour");
        System.out.println("The pieces with two colours are called edge pieces and the pieces with 3 colours are called corner pieces");
        System.out.println("Corner pieces can be only be present in 8 slots of the rubix cube and the egde pieces in 16");
        System.out.println();
        System.out.println("Basics of the rubix cube solving PROGRAM:-");
        System.out.println("Instructions are given in advanced cubing notation and...");
        System.out.println("My own method notations! My method notations are..");
        System.out.println("The side you are holding refers to the colour of the center piece");
        System.out.println("The rubix cube is solved in layers.. by a visual demonstration, the six/five main moves will be explained");
    }
    void Pattern_One()
    {
        if(a[1].equalsIgnoreCase("boepbuod") && a[2].equalsIgnoreCase("byepbuyd") && a[3].equalsIgnoreCase("brepburd") && a[4].equalsIgnoreCase("bwepbuwd") && a[5].equalsIgnoreCase("grwcgurdwr") && a[6].equalsIgnoreCase("gowcguwdor") && a[7].equalsIgnoreCase("goycguodyr") && a[8].equalsIgnoreCase("grycguydrr") && a[9].equalsIgnoreCase("oyepyrol") && a[10].equalsIgnoreCase("ryeprryl") && a[11].equalsIgnoreCase("rwepwrrl") && a[12].equalsIgnoreCase("oweporwl") && a[13].equalsIgnoreCase("goepougd") && a[14].equalsIgnoreCase("gyepyugd") && a[15].equalsIgnoreCase("greprugd") && a[16].equalsIgnoreCase("gwepwugd") && a[17].equalsIgnoreCase("brwcrubdwr") && a[18].equalsIgnoreCase("bowcwubdor") && a[19].equalsIgnoreCase("boycoubdyr") && a[20].equalsIgnoreCase("brycyubdrr"))
        {
            System.out.println("Cheeky, you gave me a pattern.");
            nms++;
            System.out.println("Moveset "+nms+" :");
            pattern1 = true;
            RU();
            RU();
            RD();
            RD();
            RR();
            RR();
            RL();
            RL();
            System.out.println("Hold the red side towards you keeping the green side above");
            System.out.println(U);
            System.out.println(U);
            System.out.println(D);
            System.out.println(D);
            System.out.println(R);
            System.out.println(R);
            System.out.println(L);
            System.out.println(L);
            WR();
            WR();
            WL();
            WL();
            System.out.println("Hold the white side towards you keeping the green side above");
            System.out.println(R);
            System.out.println(R);
            System.out.println(L);
            System.out.println(L);
            nm+=12;
            
            Display();
            MainCheck();
        }
    }
    void Pattern_Two()
    {
        if(patterncheck[1].equalsIgnoreCase("go") && patterncheck[2].equalsIgnoreCase("gy") && patterncheck[3].equalsIgnoreCase("gr") && patterncheck[4].equalsIgnoreCase("gw") && patterncheck[5].equalsIgnoreCase("goy") && patterncheck[6].equalsIgnoreCase("gyr") && patterncheck[7].equalsIgnoreCase("grw") && patterncheck[8].equalsIgnoreCase("gwo") && patterncheck[9].equalsIgnoreCase("yo") && patterncheck[10].equalsIgnoreCase("ry") && patterncheck[11].equalsIgnoreCase("wr") && patterncheck[12].equalsIgnoreCase("ow") && patterncheck[13].equalsIgnoreCase("ob") && patterncheck[14].equalsIgnoreCase("yb") && patterncheck[15].equalsIgnoreCase("rb") && patterncheck[16].equalsIgnoreCase("wb") && patterncheck[17].equalsIgnoreCase("oby") && patterncheck[18].equalsIgnoreCase("ybr") && patterncheck[19].equalsIgnoreCase("rbw") && patterncheck[20].equalsIgnoreCase("wbo"))
        {
            System.out.println("Cheeky, you gave me a pattern.");
            nms++;
            System.out.println("Moveset "+nms+" :");
            pattern3 = true;
            RUI();
            RD();
            System.out.println("Hold the red side towards you keeping the green side above");
            System.out.println(UI);
            System.out.println(D);
            WRI();
            WL();
            System.out.println("Hold the white side towards you keeping the green side above");
            System.out.println(RI);
            System.out.println(L);
            RR();
            RLI();
            System.out.println("Hold the blue side towards you keeping the white side above");
            System.out.println(U);
            System.out.println(DI);
            RUI();
            RD();
            System.out.println("Hold the red side towards you keeping the white side above");
            System.out.println(R);
            System.out.println(LI);
            nm+=8;
        }
        else if(patterncheck[1].equalsIgnoreCase("br") && patterncheck[2].equalsIgnoreCase("by") && patterncheck[3].equalsIgnoreCase("bo") && patterncheck[4].equalsIgnoreCase("bw") && patterncheck[5].equalsIgnoreCase("bry") && patterncheck[6].equalsIgnoreCase("byo") && patterncheck[7].equalsIgnoreCase("bow") && patterncheck[8].equalsIgnoreCase("bwr") && patterncheck[9].equalsIgnoreCase("yr") && patterncheck[10].equalsIgnoreCase("oy") && patterncheck[11].equalsIgnoreCase("wo") && patterncheck[12].equalsIgnoreCase("rw") && patterncheck[13].equalsIgnoreCase("rg") && patterncheck[14].equalsIgnoreCase("yg") && patterncheck[15].equalsIgnoreCase("og") && patterncheck[16].equalsIgnoreCase("wg") && patterncheck[17].equalsIgnoreCase("rgy") && patterncheck[18].equalsIgnoreCase("ygo") && patterncheck[19].equalsIgnoreCase("ogw") && patterncheck[20].equalsIgnoreCase("wgr"))
        {
            System.out.println("Cheeky, you gave me a pattern.");
            nms++;
            System.out.println("Moveset "+nms+" :");
            pattern3 = true;
            RUI();
            RD();
            System.out.println("Hold the red side towards you keeping the green side above");
            System.out.println(UI);
            System.out.println(D);
            WRI();
            WL();
            System.out.println("Hold the white side towards you keeping the green side above");
            System.out.println(RI);
            System.out.println(L);
            RR();
            RLI();
            System.out.println("Hold the blue side towards you keeping the white side above");
            System.out.println(U);
            System.out.println(DI);
            RUI();
            RD();
            System.out.println("Hold the red side towards you keeping the white side above");
            System.out.println(R);
            System.out.println(LI);
            nm+=8;
        }
        else if(patterncheck[1].equalsIgnoreCase("bo") && patterncheck[2].equalsIgnoreCase("bw") && patterncheck[3].equalsIgnoreCase("br") && patterncheck[4].equalsIgnoreCase("by") && patterncheck[5].equalsIgnoreCase("bow") && patterncheck[6].equalsIgnoreCase("bwr") && patterncheck[7].equalsIgnoreCase("bry") && patterncheck[8].equalsIgnoreCase("byo") && patterncheck[9].equalsIgnoreCase("wo") && patterncheck[10].equalsIgnoreCase("rw") && patterncheck[11].equalsIgnoreCase("yr") && patterncheck[12].equalsIgnoreCase("oy") && patterncheck[13].equalsIgnoreCase("og") && patterncheck[14].equalsIgnoreCase("wg") && patterncheck[15].equalsIgnoreCase("rg") && patterncheck[16].equalsIgnoreCase("yg") && patterncheck[17].equalsIgnoreCase("ogw") && patterncheck[18].equalsIgnoreCase("wgr") && patterncheck[19].equalsIgnoreCase("rgy") && patterncheck[20].equalsIgnoreCase("ygo"))
        {
            System.out.println("Cheeky, you gave me a pattern.");
            nms++;
            System.out.println("Moveset "+nms+" :");
            pattern3 = true;
            RUI();
            RD();
            System.out.println("Hold the red side towards you keeping the green side above");
            System.out.println(UI);
            System.out.println(D);
            WRI();
            WL();
            System.out.println("Hold the white side towards you keeping the green side above");
            System.out.println(RI);
            System.out.println(L);
            RR();
            RLI();
            System.out.println("Hold the blue side towards you keeping the white side above");
            System.out.println(U);
            System.out.println(DI);
            RUI();
            RD();
            System.out.println("Hold the red side towards you keeping the white side above");
            System.out.println(R);
            System.out.println(LI);
            nm+=8;
        }
    }
    void Pattern_Three()
    {
        if(patterncheck[1].equalsIgnoreCase("rw") && patterncheck[2].equalsIgnoreCase("rg") && patterncheck[3].equalsIgnoreCase("ry") && patterncheck[4].equalsIgnoreCase("rb") && patterncheck[5].equalsIgnoreCase("rwg") && patterncheck[6].equalsIgnoreCase("rgy") && patterncheck[7].equalsIgnoreCase("ryb") && patterncheck[8].equalsIgnoreCase("rbw") && patterncheck[9].equalsIgnoreCase("gw") && patterncheck[10].equalsIgnoreCase("yg") && patterncheck[11].equalsIgnoreCase("by") && patterncheck[12].equalsIgnoreCase("wb") && patterncheck[13].equalsIgnoreCase("wo") && patterncheck[14].equalsIgnoreCase("go") && patterncheck[15].equalsIgnoreCase("yo") && patterncheck[16].equalsIgnoreCase("bo") && patterncheck[17].equalsIgnoreCase("wog") && patterncheck[18].equalsIgnoreCase("goy") && patterncheck[19].equalsIgnoreCase("yob") && patterncheck[20].equalsIgnoreCase("bow"))
        {
            if(pattern2 == false)
            System.out.println("Cheeky, you gave me a pattern.");
            nms++;
            System.out.println("Moveset "+nms+" :");
            pattern3 = true;
            RUI();
            RD();
            System.out.println("Hold the red side towards you keeping the yellow side above");
            System.out.println(RI);
            System.out.println(L);
            WR();
            YLI();
            System.out.println("Hold the white side towards you keeping the red side above");
            System.out.println(UI);
            System.out.println(D);
            RRI();
            RL();
            System.out.println("Hold the green side towards you keeping the red side above");
            System.out.println(R);
            System.out.println(LI);
            RUI();
            RD();
            System.out.println("Hold the red side towards you keeping the blue side above");
            System.out.println(U);
            System.out.println(DI);
            nm+=8;
            
            Display();
            MainCheck();
        }
        else if(patterncheck[1].equalsIgnoreCase("ry") && patterncheck[2].equalsIgnoreCase("rb") && patterncheck[3].equalsIgnoreCase("rw") && patterncheck[4].equalsIgnoreCase("rg") && patterncheck[5].equalsIgnoreCase("ryb") && patterncheck[6].equalsIgnoreCase("rbw") && patterncheck[7].equalsIgnoreCase("rwg") && patterncheck[8].equalsIgnoreCase("rgy") && patterncheck[9].equalsIgnoreCase("by") && patterncheck[10].equalsIgnoreCase("wb") && patterncheck[11].equalsIgnoreCase("gw") && patterncheck[12].equalsIgnoreCase("yg") && patterncheck[13].equalsIgnoreCase("yo") && patterncheck[14].equalsIgnoreCase("bo") && patterncheck[15].equalsIgnoreCase("wo") && patterncheck[16].equalsIgnoreCase("go") && patterncheck[17].equalsIgnoreCase("yob") && patterncheck[18].equalsIgnoreCase("bow") && patterncheck[19].equalsIgnoreCase("wog") && patterncheck[20].equalsIgnoreCase("goy"))
        {
            if(pattern2 == false)
            System.out.println("Cheeky, you gave me a pattern.");
            nms++;
            System.out.println("Moveset "+nms+" :");
            pattern3 = true;
            WRI();
            WL();
            System.out.println("Hold the white side towards you keeping the green side above");
            System.out.println(RI);
            System.out.println(L);
            OR();
            OLI();
            System.out.println("Hold the blue side towards you keeping the white side above");
            System.out.println(UI);
            System.out.println(D);
            OU();
            ODI();
            System.out.println("Hold the orange side towards you keeping the white side above");
            System.out.println(R);
            System.out.println(LI);
            WRI();
            WL();
            System.out.println("Hold the white side towards you keeping the red side above");
            System.out.println(U);
            System.out.println(DI);
            nm+=8;
            
            Display();
            MainCheck();
        }
        else if(a[1].equalsIgnoreCase("gwepwugd") && a[2].equalsIgnoreCase("rwepwurd") && a[3].equalsIgnoreCase("bwepwubd") && a[4].equalsIgnoreCase("owepwuod") && a[5].equalsIgnoreCase("grwcwugdrr") && a[6].equalsIgnoreCase("brwcwurdbr") && a[7].equalsIgnoreCase("bowcwubdor") && a[8].equalsIgnoreCase("gowcwuodgr") && a[9].equalsIgnoreCase("greprrgl") && a[10].equalsIgnoreCase("brepbrrl") && a[11].equalsIgnoreCase("boeporbl") && a[12].equalsIgnoreCase("goepgrol") && a[13].equalsIgnoreCase("gyepguyd") && a[14].equalsIgnoreCase("ryepruyd") && a[15].equalsIgnoreCase("byepbuyd") && a[16].equalsIgnoreCase("oyepoyd") && a[17].equalsIgnoreCase("grycguydrr") && a[18].equalsIgnoreCase("brycruydbr") && a[19].equalsIgnoreCase("boycbuydor") && a[20].equalsIgnoreCase("goycouydgr"))
        {
            if(pattern2 == false)
            System.out.println("Cheeky, you gave me a pattern.");
            nms++;
            System.out.println("Moveset "+nms+" :");
            pattern3 = true;
            YR();
            YLI();
            System.out.println("Hold the white side towards you keeping the orange side above");
            System.out.println(RI);
            System.out.println(L);
            YU();
            YDI();
            System.out.println("Hold the red side towards you keeping the white side above");
            System.out.println(UI);
            System.out.println(D);
            ORI();
            OL();
            System.out.println("Hold the blue side towards you keeping the white side above");
            System.out.println(R);
            System.out.println(LI);
            YR();
            YLI();
            System.out.println("Hold the white side towards you keeping the green side above");
            System.out.println(U);
            System.out.println(DI);
            nm+=8;
            
            Display();
            MainCheck();
        }
        else if(patterncheck[1].equalsIgnoreCase("wb") && patterncheck[2].equalsIgnoreCase("wo") && patterncheck[3].equalsIgnoreCase("wg") && patterncheck[4].equalsIgnoreCase("wr") && patterncheck[5].equalsIgnoreCase("wbo") && patterncheck[6].equalsIgnoreCase("wog") && patterncheck[7].equalsIgnoreCase("wgr") && patterncheck[8].equalsIgnoreCase("wrb") && patterncheck[9].equalsIgnoreCase("ob") && patterncheck[10].equalsIgnoreCase("go") && patterncheck[11].equalsIgnoreCase("rg") && patterncheck[12].equalsIgnoreCase("br") && patterncheck[13].equalsIgnoreCase("by") && patterncheck[14].equalsIgnoreCase("oy") && patterncheck[15].equalsIgnoreCase("gy") && patterncheck[16].equalsIgnoreCase("ry") && patterncheck[17].equalsIgnoreCase("byo") && patterncheck[18].equalsIgnoreCase("oyg") && patterncheck[19].equalsIgnoreCase("gyr") && patterncheck[20].equalsIgnoreCase("ryb"))
        {
            if(pattern2 == false)
            System.out.println("Cheeky, you gave me a pattern.");
            nms++;
            System.out.println("Moveset "+nms+" :");
            pattern3 = true;
            WUI();
            WD();
            System.out.println("Hold the white side towards you keeping the red side above");
            System.out.println(RI);
            System.out.println(L);
            OR();
            OLI();
            System.out.println("Hold the orange side towards you keeping the white side above");
            System.out.println(UI);
            System.out.println(D);
            WRI();
            WL();
            System.out.println("Hold the green side towards you keeping the white side above");
            System.out.println(R);
            System.out.println(LI);
            WUI();
            WD();
            System.out.println("Hold the white side towards you keeping the blue side above");
            System.out.println(U);
            System.out.println(DI);
            nm+=8;
            
            Display();
            MainCheck();
        }
        else if(patterncheck[1].equalsIgnoreCase("oy") && patterncheck[2].equalsIgnoreCase("og") && patterncheck[3].equalsIgnoreCase("ow") && patterncheck[4].equalsIgnoreCase("ob") && patterncheck[5].equalsIgnoreCase("oyg") && patterncheck[6].equalsIgnoreCase("ogw") && patterncheck[7].equalsIgnoreCase("owb") && patterncheck[8].equalsIgnoreCase("oby") && patterncheck[9].equalsIgnoreCase("gy") && patterncheck[10].equalsIgnoreCase("wg") && patterncheck[11].equalsIgnoreCase("bw") && patterncheck[12].equalsIgnoreCase("yb") && patterncheck[13].equalsIgnoreCase("yr") && patterncheck[14].equalsIgnoreCase("gr") && patterncheck[15].equalsIgnoreCase("wr") && patterncheck[16].equalsIgnoreCase("br") && patterncheck[17].equalsIgnoreCase("yrg") && patterncheck[18].equalsIgnoreCase("grw") && patterncheck[19].equalsIgnoreCase("wrb") && patterncheck[20].equalsIgnoreCase("bry"))
        {
            if(pattern2 == false)
            System.out.println("Cheeky, you gave me a pattern.");
            nms++;
            System.out.println("Moveset "+nms+" :");
            pattern3 = true;
            YU();
            YDI();
            System.out.println("Hold the red side towards you keeping the white side above");
            System.out.println(RI);
            System.out.println(L);
            YRI();
            YL();
            System.out.println("Hold the yellow side towards you keeping the red side above");
            System.out.println(UI);
            System.out.println(D);
            RR();
            RLI();
            System.out.println("Hold the blue side towards you keeping the red side above");
            System.out.println(R);
            System.out.println(LI);
            YU();
            YDI();
            System.out.println("Hold the red side towards you keeping the green side above");
            System.out.println(U);
            System.out.println(DI);
            nm+=8;
            
            Display();
            MainCheck();
        }
        else if(patterncheck[1].equalsIgnoreCase("ow") && patterncheck[2].equalsIgnoreCase("ob") && patterncheck[3].equalsIgnoreCase("oy") && patterncheck[4].equalsIgnoreCase("og") && patterncheck[5].equalsIgnoreCase("owb") && patterncheck[6].equalsIgnoreCase("oby") && patterncheck[7].equalsIgnoreCase("oyg") && patterncheck[8].equalsIgnoreCase("ogw") && patterncheck[9].equalsIgnoreCase("gy") && patterncheck[10].equalsIgnoreCase("yb") && patterncheck[11].equalsIgnoreCase("gy") && patterncheck[12].equalsIgnoreCase("wg") && patterncheck[13].equalsIgnoreCase("wr") && patterncheck[14].equalsIgnoreCase("br") && patterncheck[15].equalsIgnoreCase("yr") && patterncheck[16].equalsIgnoreCase("gr") && patterncheck[17].equalsIgnoreCase("wrb") && patterncheck[18].equalsIgnoreCase("bry") && patterncheck[19].equalsIgnoreCase("yrg") && patterncheck[20].equalsIgnoreCase("grw"))
        {
            if(pattern2 == false)
            System.out.println("Cheeky, you gave me a pattern.");
            nms++;
            System.out.println("Moveset "+nms+" :");
            pattern3 = true;
            OUI();
            OD();
            System.out.println("Hold the orange side towards you keeping the white side above");
            System.out.println(RI);
            System.out.println(L);
            YR();
            YLI();
            System.out.println("Hold the yellow side towards you keeping the orange side above");
            System.out.println(UI);
            System.out.println(D);
            ORI();
            OL();
            System.out.println("Hold the green side towards you keeping the orange side above");
            System.out.println(R);
            System.out.println(LI);
            OUI();
            OD();
            System.out.println("Hold the orange side towards you keeping the blue side above");
            System.out.println(U);
            System.out.println(DI);
            nm+=8;
            
            Display();
            MainCheck();
        }
        else if(a[1].equalsIgnoreCase("byepyubd") && a[2].equalsIgnoreCase("ryepyurd") && a[3].equalsIgnoreCase("gyepyugd") && a[4].equalsIgnoreCase("oyepyuod") && a[5].equalsIgnoreCase("brycyubdrr") && a[6].equalsIgnoreCase("grycyurdgr") && a[7].equalsIgnoreCase("goycyugdor") && a[8].equalsIgnoreCase("boycyuodbr") && a[9].equalsIgnoreCase("breprrbl") && a[10].equalsIgnoreCase("grepgrrl") && a[11].equalsIgnoreCase("goeporgl") && a[12].equalsIgnoreCase("boepbrol") && a[13].equalsIgnoreCase("bwepbuwd") && a[14].equalsIgnoreCase("rwepruwd") && a[15].equalsIgnoreCase("gwepguwd") && a[16].equalsIgnoreCase("owepouwd") && a[17].equalsIgnoreCase("brwcbuwdrr") && a[18].equalsIgnoreCase("grwcruwdgr") && a[19].equalsIgnoreCase("gowcguwdor") && a[20].equalsIgnoreCase("bowcouwdbr"))
        {
            if(pattern2 == false)
            System.out.println("Cheeky, you gave me a pattern.");
            nms++;
            System.out.println("Moveset "+nms+" :");
            pattern3 = true;
            WU();
            WDI();
            System.out.println("Hold the white side towards you keeping the orange side above");
            System.out.println(RI);
            System.out.println(L);
            RRI();
            RL();
            System.out.println("Hold the red side towards you keeping the white side above");
            System.out.println(UI);
            System.out.println(D);
            WLI();
            WR();
            System.out.println("Hold the blue side towards you keeping the white side above");
            System.out.println(R);
            System.out.println(LI);
            WU();
            WDI();
            System.out.println("Hold the white side towards you keeping the green side above");
            System.out.println(U);
            System.out.println(DI);
            nm+=8;
            
            Display();
            MainCheck();
        }
        else if(a[1].equalsIgnoreCase("gyepyugd") && a[2].equalsIgnoreCase("oyepyuod") && a[3].equalsIgnoreCase("byepyubd") && a[4].equalsIgnoreCase("ryepyurd") && a[5].equalsIgnoreCase("goycyugdor") && a[6].equalsIgnoreCase("boycyuodbr") && a[7].equalsIgnoreCase("brycyubdrr") && a[8].equalsIgnoreCase("grycyurdgr") && a[9].equalsIgnoreCase("goepprgl") && a[10].equalsIgnoreCase("boepbrol") && a[11].equalsIgnoreCase("breprrbl") && a[12].equalsIgnoreCase("grepgrrl") && a[13].equalsIgnoreCase("gwepguwd") && a[14].equalsIgnoreCase("owepouwd") && a[15].equalsIgnoreCase("bwepbuwd") && a[16].equalsIgnoreCase("rwepruwd") && a[17].equalsIgnoreCase("gowcguwdor") && a[18].equalsIgnoreCase("bowcouwdbr") && a[19].equalsIgnoreCase("brwcbuwdrr") && a[20].equalsIgnoreCase("grwcruwdgr"))
        {
            if(pattern2 == false)
            System.out.println("Cheeky, you gave me a pattern.");
            nms++;
            System.out.println("Moveset "+nms+" :");
            pattern3 = true;
            RR();
            RLI();
            System.out.println("Hold the red side towards you keeping the blue side above");
            System.out.println(RI);
            System.out.println(L);
            YL();
            YRI();
            System.out.println("Hold the green side towards you keeping the red side above");
            System.out.println(UI);
            System.out.println(D);
            RUI();
            RD();
            System.out.println("Hold the yellow side towards you keeping the red side above");
            System.out.println(R);
            System.out.println(LI);
            RR();
            RLI();
            System.out.println("Hold the red side towards you keeping the white side above");
            System.out.println(U);
            System.out.println(DI);
            nm+=8;
            
            Display();
            MainCheck();
        }
    }
    public static void main(String args[])
    {
        RubixCube RC = new RubixCube();
        RC.MainDisplay();
        RC.Accept();
        RC.Pattern_One();
        RC.Pattern_Two();
        RC.Pattern_Three();
        if(pattern1 == false && pattern2 == false && pattern3 == false)
        {
            RC.FirstLayerCross();
            RC.FirstLayerCorners();
            RC.SecondLayer();
            RC.ThirdLayerCross();
            RC.ThirdLayerCorners();
        }
    }
}