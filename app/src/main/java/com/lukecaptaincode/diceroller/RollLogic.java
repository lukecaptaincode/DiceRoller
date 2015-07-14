package com.lukecaptaincode.diceroller;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * Created by Luke Captain on 23-Apr-15.
 */
public class RollLogic
{//start class
    int userDiceNo;
    int userSidesNo;
    int [] results;
    SecureRandom random;
    public RollLogic()
    {//start constructor

        random = new SecureRandom();
    }//end constructor

    public void compute()
    {//start compute method
        results = new int[userDiceNo];
        for(int i =0;i< userDiceNo; i++)
        {//start of for loop for rolls
            results[i] = (random.nextInt(userSidesNo)+1);
        }//end of for loop for rolls
    }//end compute method

    //setter
    public void setUserInput(int userDiceNo, int userSidesNo)
    {//start setter
        this.userDiceNo = userDiceNo;
        this.userSidesNo = userSidesNo;
    }//end setter

    //getter
    public int [] getResults()
    {//start getter
        return results;
    }//end getter
}//end class
