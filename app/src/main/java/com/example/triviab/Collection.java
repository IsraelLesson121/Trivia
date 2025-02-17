package com.example.triviab;

import java.util.ArrayList;

public class Collection {

    private ArrayList<Question> arr;
    private int index; // מספר השאלה הבאה בתור

    public Collection()
    {
        arr = new ArrayList<>();

        Question q1 = new Question("1+10","7","11","3","100",2);
        Question q2 = new Question("1+2","5","2","7","3",4);
        Question q3 = new Question("1+14","15","1","12","20",1);

        arr.add(q1);
        arr.add(q2);
        arr.add(q3);

    }

    public void initQuestions(){
        index = 0;
    }

    public Question getNextQuestion(){
        //הפעולה מחזירה הפניה לשאלה הבאה
        Question q = arr.get(index);
        index++;
        return q;
    }

    public boolean isNotLastQuestion(){
        //הפעולה מחזירה אמת אם אנו בשאלה האחרונה
        return (index <arr.size());//if not at the end of the ArrayList
    }

    public int getIndex() {return index;}
}
